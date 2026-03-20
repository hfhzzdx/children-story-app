package com.dunzi.storyhouse.ui.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository
import com.dunzi.storyhouse.data.repository.StoryRepository
import com.dunzi.storyhouse.data.repository.UserSettingsRepository
import com.dunzi.storyhouse.service.AudioPlaybackService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 播放器视图模型
 */
@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val userSettingsRepository: UserSettingsRepository,
    private val playHistoryRepository: PlayHistoryRepository
) : ViewModel() {
    
    // 播放器状态
    private val _playerState = MutableStateFlow(PlayerState())
    val playerState: StateFlow<PlayerState> = _playerState.asStateFlow()
    
    // 播放列表
    private val _playlist = MutableStateFlow<List<com.dunzi.storyhouse.data.model.Story>>(emptyList())
    val playlist: StateFlow<List<com.dunzi.storyhouse.data.model.Story>> = _playlist.asStateFlow()
    
    // 用户设置
    private val _userSettings = MutableStateFlow<com.dunzi.storyhouse.data.model.UserSettings?>(null)
    val userSettings: StateFlow<com.dunzi.storyhouse.data.model.UserSettings?> = _userSettings.asStateFlow()
    
    init {
        loadUserSettings()
    }
    
    /**
     * 加载用户设置
     */
    private fun loadUserSettings() {
        viewModelScope.launch {
            userSettingsRepository.getUserSettings().collect { settings ->
                _userSettings.value = settings
                
                // 更新播放器设置
                settings?.let { updatePlayerSettings(it) }
            }
        }
    }
    
    /**
     * 更新播放器设置
     */
    private fun updatePlayerSettings(settings: com.dunzi.storyhouse.data.model.UserSettings) {
        _playerState.update { state ->
            state.copy(
                volume = settings.defaultVolume,
                playbackSpeed = settings.defaultPlaybackSpeed,
                backgroundPlay = settings.backgroundPlay,
                autoPlayNext = settings.autoPlayNext,
                shuffleEnabled = settings.shuffleEnabled,
                repeatMode = when (settings.playMode) {
                    "repeat_one" -> RepeatMode.REPEAT_ONE
                    "repeat_all" -> RepeatMode.REPEAT_ALL
                    else -> RepeatMode.NONE
                }
            )
        }
    }
    
    /**
     * 播放故事
     */
    fun playStory(story: com.dunzi.storyhouse.data.model.Story) {
        _playerState.update { state ->
            state.copy(
                currentStory = story,
                isPlaying = true,
                isLoading = true
            )
        }
        
        // 启动播放服务
        AudioPlaybackService.startService(
            context = android.content.ContextWrapper(null).baseContext,
            storyId = story.id,
            audioUrl = story.audioUrl,
            title = story.title,
            author = story.author
        )
        
        // 更新播放进度
        viewModelScope.launch {
            storyRepository.updatePlayProgress(story.id, 0.0f)
        }
    }
    
    /**
     * 暂停播放
     */
    fun pausePlayback() {
        _playerState.update { state ->
            state.copy(isPlaying = false)
        }
        
        // 发送暂停命令
        val intent = android.content.Intent(
            android.content.ContextWrapper(null).baseContext,
            AudioPlaybackService::class.java
        ).apply {
            action = AudioPlaybackService.ACTION_PAUSE
        }
        android.content.ContextWrapper(null).baseContext.startService(intent)
    }
    
    /**
     * 恢复播放
     */
    fun resumePlayback() {
        _playerState.update { state ->
            state.copy(isPlaying = true)
        }
        
        // 发送播放命令
        val intent = android.content.Intent(
            android.content.ContextWrapper(null).baseContext,
            AudioPlaybackService::class.java
        ).apply {
            action = AudioPlaybackService.ACTION_PLAY
        }
        android.content.ContextWrapper(null).baseContext.startService(intent)
    }
    
    /**
     * 停止播放
     */
    fun stopPlayback() {
        _playerState.update { state ->
            state.copy(
                isPlaying = false,
                currentStory = null,
                currentPosition = 0L,
                duration = 0L
            )
        }
        
        AudioPlaybackService.stopService(android.content.ContextWrapper(null).baseContext)
    }
    
    /**
     * 调整播放速度
     */
    fun adjustPlaybackSpeed(newSpeed: Float) {
        _playerState.update { state ->
            state.copy(playbackSpeed = newSpeed)
        }
        
        // 保存到用户设置
        viewModelScope.launch {
            userSettingsRepository.updatePlaybackSpeed(newSpeed)
        }
    }
    
    /**
     * 调整音量
     */
    fun adjustVolume(newVolume: Float) {
        _playerState.update { state ->
            state.copy(volume = newVolume)
        }
        
        // 保存到用户设置
        viewModelScope.launch {
            userSettingsRepository.updateDefaultVolume(newVolume)
        }
    }
    
    /**
     * 切换随机播放
     */
    fun toggleShuffle() {
        _playerState.update { state ->
            state.copy(shuffleEnabled = !state.shuffleEnabled)
        }
        
        // 保存到用户设置
        viewModelScope.launch {
            userSettingsRepository.updateShuffleEnabled(!_playerState.value.shuffleEnabled)
        }
    }
    
    /**
     * 切换循环模式
     */
    fun toggleRepeatMode() {
        val currentMode = _playerState.value.repeatMode
        val nextMode = when (currentMode) {
            RepeatMode.NONE -> RepeatMode.REPEAT_ALL
            RepeatMode.REPEAT_ALL -> RepeatMode.REPEAT_ONE
            RepeatMode.REPEAT_ONE -> RepeatMode.NONE
        }
        
        _playerState.update { state ->
            state.copy(repeatMode = nextMode)
        }
        
        // 保存到用户设置
        viewModelScope.launch {
            val playMode = when (nextMode) {
                RepeatMode.NONE -> "none"
                RepeatMode.REPEAT_ALL -> "repeat_all"
                RepeatMode.REPEAT_ONE -> "repeat_one"
            }
            userSettingsRepository.updatePlayMode(playMode)
        }
    }
    
    /**
     * 跳转到指定位置
     */
    fun seekTo(position: Long) {
        _playerState.update { state ->
            state.copy(currentPosition = position)
        }
        
        // 发送跳转命令
        AudioPlaybackService.seekTo(android.content.ContextWrapper(null).baseContext, position)
    }
    
    /**
     * 快进10秒
     */
    fun fastForward() {
        val currentPosition = _playerState.value.currentPosition
        val duration = _playerState.value.duration
        val newPosition = (currentPosition + 10000L).coerceAtMost(duration)
        
        seekTo(newPosition)
    }
    
    /**
     * 快退10秒
     */
    fun rewind() {
        val currentPosition = _playerState.value.currentPosition
        val newPosition = (currentPosition - 10000L).coerceAtLeast(0L)
        
        seekTo(newPosition)
    }
    
    /**
     * 设置睡眠定时器
     */
    fun setSleepTimer(minutes: Int) {
        val duration = minutes * 60 * 1000L // 转换为毫秒
        
        // 更新状态
        _playerState.update { state ->
            state.copy(
                sleepTimerDuration = duration,
                sleepTimerStartTime = System.currentTimeMillis()
            )
        }
        
        // 发送到服务
        AudioPlaybackService.setSleepTimer(android.content.ContextWrapper(null).baseContext, duration)
        
        // 保存到用户设置
        viewModelScope.launch {
            userSettingsRepository.updateSleepTimerDuration(minutes)
        }
    }
    
    /**
     * 取消睡眠定时器
     */
    fun cancelSleepTimer() {
        _playerState.update { state ->
            state.copy(
                sleepTimerDuration = 0L,
                sleepTimerStartTime = 0L
            )
        }
        
        // 发送到服务
        AudioPlaybackService.cancelSleepTimer(android.content.ContextWrapper(null).baseContext)
        
        // 保存到用户设置
        viewModelScope.launch {
            userSettingsRepository.updateSleepTimerDuration(0)
        }
    }
    
    /**
     * 获取剩余睡眠定时器时间（秒）
     */
    fun getRemainingSleepTimerTime(): Long {
        val state = _playerState.value
        if (state.sleepTimerDuration == 0L) {
            return 0L
        }
        
        val elapsedTime = System.currentTimeMillis() - state.sleepTimerStartTime
        val remainingTime = state.sleepTimerDuration - elapsedTime
        
        return if (remainingTime > 0) {
            remainingTime / 1000L // 转换为秒
        } else {
            0L
        }
    }
    
    /**
     * 切换播放状态
     */
    fun togglePlayback() {
        val currentState = _playerState.value
        if (currentState.isPlaying) {
            pausePlayback()
        } else {
            if (currentState.currentStory != null) {
                resumePlayback()
            }
        }
    }
    
    /**
     * 跳转到指定位置
     */
    fun seekTo(position: Long) {
        _playerState.update { state ->
            state.copy(currentPosition = position)
        }
        
        // TODO: 实现跳转逻辑
    }
    
    /**
     * 更新播放进度
     */
    fun updateProgress(position: Long, duration: Long) {
        _playerState.update { state ->
            state.copy(
                currentPosition = position,
                duration = duration,
                isLoading = false
            )
        }
        
        // 更新数据库中的播放进度
        val currentStory = _playerState.value.currentStory
        if (currentStory != null && duration > 0) {
            val progress = position.toFloat() / duration.toFloat()
            viewModelScope.launch {
                storyRepository.updatePlayProgress(currentStory.id, progress)
            }
        }
    }
    
    /**
     * 播放下一首
     */
    fun playNext() {
        val currentStory = _playerState.value.currentStory
        val currentPlaylist = _playlist.value
        
        if (currentStory != null && currentPlaylist.isNotEmpty()) {
            val currentIndex = currentPlaylist.indexOfFirst { it.id == currentStory.id }
            if (currentIndex >= 0 && currentIndex < currentPlaylist.size - 1) {
                val nextStory = currentPlaylist[currentIndex + 1]
                playStory(nextStory)
            }
        }
    }
    
    /**
     * 播放上一首
     */
    fun playPrevious() {
        val currentStory = _playerState.value.currentStory
        val currentPlaylist = _playlist.value
        
        if (currentStory != null && currentPlaylist.isNotEmpty()) {
            val currentIndex = currentPlaylist.indexOfFirst { it.id == currentStory.id }
            if (currentIndex > 0) {
                val previousStory = currentPlaylist[currentIndex - 1]
                playStory(previousStory)
            }
        }
    }
    
    /**
     * 设置播放列表
     */
    fun setPlaylist(stories: List<com.dunzi.storyhouse.data.model.Story>) {
        _playlist.value = stories
    }
    
    /**
     * 切换随机播放
     */
    fun toggleShuffle() {
        _playerState.update { state ->
            state.copy(shuffleEnabled = !state.shuffleEnabled)
        }
        
        // 更新用户设置
        viewModelScope.launch {
            userSettingsRepository.updatePlayMode(
                shuffle = _playerState.value.shuffleEnabled
            )
        }
    }
    
    /**
     * 切换循环模式
     */
    fun toggleRepeatMode() {
        val currentMode = _playerState.value.repeatMode
        val nextMode = when (currentMode) {
            RepeatMode.NONE -> RepeatMode.REPEAT_ALL
            RepeatMode.REPEAT_ALL -> RepeatMode.REPEAT_ONE
            RepeatMode.REPEAT_ONE -> RepeatMode.NONE
        }
        
        _playerState.update { state ->
            state.copy(repeatMode = nextMode)
        }
        
        // 更新用户设置
        viewModelScope.launch {
            val modeString = when (nextMode) {
                RepeatMode.NONE -> "normal"
                RepeatMode.REPEAT_ALL -> "repeat_all"
                RepeatMode.REPEAT_ONE -> "repeat_one"
            }
            userSettingsRepository.updatePlayMode(mode = modeString)
        }
    }
    
    /**
     * 调整音量
     */
    fun adjustVolume(volume: Float) {
        _playerState.update { state ->
            state.copy(volume = volume.coerceIn(0f, 1f))
        }
        
        // 更新用户设置
        viewModelScope.launch {
            userSettingsRepository.updatePlaybackSettings(volume = volume)
        }
    }
    
    /**
     * 调整播放速度
     */
    fun adjustPlaybackSpeed(speed: Float) {
        _playerState.update { state ->
            state.copy(playbackSpeed = speed.coerceIn(0.5f, 2.0f))
        }
        
        // 更新用户设置
        viewModelScope.launch {
            userSettingsRepository.updatePlaybackSettings(speed = speed)
        }
    }
    
    /**
     * 切换收藏状态
     */
    fun toggleFavorite() {
        val currentStory = _playerState.value.currentStory
        if (currentStory != null) {
            viewModelScope.launch {
                storyRepository.toggleFavorite(currentStory.id, !currentStory.isFavorite)
                
                // 更新本地状态
                _playerState.update { state ->
                    state.copy(
                        currentStory = currentStory.copy(isFavorite = !currentStory.isFavorite)
                    )
                }
            }
        }
    }
    
    /**
     * 获取播放统计
     */
    fun getPlayStats() {
        viewModelScope.launch {
            val stats = playHistoryRepository.getPlayStatsSummary("default")
            _playerState.update { state ->
                state.copy(playStats = stats)
            }
        }
    }
    
    /**
     * 清除错误
     */
    fun clearError() {
        _playerState.update { state ->
            state.copy(error = null)
        }
    }
    
    /**
     * 播放器状态
     */
    data class PlayerState(
        val currentStory: com.dunzi.storyhouse.data.model.Story? = null,
        val isPlaying: Boolean = false,
        val isLoading: Boolean = false,
        val currentPosition: Long = 0L,
        val duration: Long = 0L,
        val volume: Float = 0.8f,
        val playbackSpeed: Float = 1.0f,
        val backgroundPlay: Boolean = true,
        val autoPlayNext: Boolean = true,
        val shuffleEnabled: Boolean = false,
        val repeatMode: RepeatMode = RepeatMode.NONE,
        val sleepTimerDuration: Long = 0L, // 睡眠定时器时长（毫秒）
        val sleepTimerStartTime: Long = 0L, // 睡眠定时器开始时间
        val playStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary? = null,
        val error: String? = null
    ) {
        /**
         * 获取播放进度百分比
         */
        val progress: Float
            get() = if (duration > 0) {
                currentPosition.toFloat() / duration.toFloat()
            } else {
                0f
            }
        
        /**
         * 获取格式化后的当前位置
         */
        val formattedPosition: String
            get() = formatTime(currentPosition)
        
        /**
         * 获取格式化后的总时长
         */
        val formattedDuration: String
            get() = formatTime(duration)
        
        /**
         * 检查是否有当前故事
         */
        val hasCurrentStory: Boolean
            get() = currentStory != null
        
        /**
         * 检查是否在播放
         */
        val isActive: Boolean
            get() = hasCurrentStory && (isPlaying || isLoading)
        
        /**
         * 格式化时间
         */
        private fun formatTime(milliseconds: Long): String {
            val totalSeconds = milliseconds / 1000
            val minutes = totalSeconds / 60
            val seconds = totalSeconds % 60
            return String.format("%02d:%02d", minutes, seconds)
        }
        
        /**
         * 检查是否有活动的睡眠定时器
         */
        val hasActiveSleepTimer: Boolean
            get() = sleepTimerDuration > 0L && getRemainingSleepTimerTime() > 0
        
        /**
         * 获取剩余睡眠定时器时间（秒）
         */
        fun getRemainingSleepTimerTime(): Long {
            if (sleepTimerDuration == 0L) {
                return 0L
            }
            
            val elapsedTime = System.currentTimeMillis() - sleepTimerStartTime
            val remainingTime = sleepTimerDuration - elapsedTime
            
            return if (remainingTime > 0) {
                remainingTime / 1000L // 转换为秒
            } else {
                0L
            }
        }
        
        /**
         * 获取剩余睡眠定时器时间（格式化字符串）
         */
        fun getFormattedRemainingSleepTimerTime(): String {
            val remainingSeconds = getRemainingSleepTimerTime()
            if (remainingSeconds <= 0) {
                return "无"
            }
            
            val minutes = remainingSeconds / 60
            val seconds = remainingSeconds % 60
            
            return if (minutes > 0) {
                if (seconds > 0) {
                    "${minutes}分${seconds}秒"
                } else {
                    "${minutes}分钟"
                }
            } else {
                "${seconds}秒"
            }
        }
    }
    
    /**
     * 循环模式枚举
     */
    enum class RepeatMode {
        NONE,
        REPEAT_ALL,
        REPEAT_ONE
    }
}