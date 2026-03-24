package com.dunzi.storyhouse.ui.story

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository
import com.dunzi.storyhouse.data.repository.StoryRepository
import com.dunzi.storyhouse.data.repository.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 故事详情视图模型
 */
@HiltViewModel
class StoryDetailViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val userSettingsRepository: UserSettingsRepository,
    private val playHistoryRepository: PlayHistoryRepository
) : ViewModel() {
    
    // 故事详情状态
    private val _storyDetailState = MutableStateFlow(StoryDetailState())
    val storyDetailState: StateFlow<StoryDetailState> = _storyDetailState.asStateFlow()
    
    // 相关故事
    private val _relatedStories = MutableStateFlow<List<com.dunzi.storyhouse.data.model.Story>>(emptyList())
    val relatedStories: StateFlow<List<com.dunzi.storyhouse.data.model.Story>> = _relatedStories.asStateFlow()
    
    // 播放统计
    private val _playStats = MutableStateFlow<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary?>(null)
    val playStats: StateFlow<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary?> = _playStats.asStateFlow()
    
    /**
     * 加载故事详情
     */
    fun loadStoryDetail(storyId: Long) {
        _storyDetailState.update { it.copy(isLoading = true) }
        
        viewModelScope.launch {
            try {
                // 加载故事详情
                val story = storyRepository.getStoryById(storyId)
                if (story != null) {
                    _storyDetailState.update { state ->
                        state.copy(
                            story = story,
                            isLoading = false,
                            error = null
                        )
                    }
                    
                    // 加载相关故事
                    loadRelatedStories(story)
                    
                    // 加载播放统计
                    loadPlayStats(storyId)
                } else {
                    _storyDetailState.update { state ->
                        state.copy(
                            isLoading = false,
                            error = "故事不存在"
                        )
                    }
                }
            } catch (e: Exception) {
                _storyDetailState.update { state ->
                    state.copy(
                        isLoading = false,
                        error = "加载失败: ${e.message}"
                    )
                }
            }
        }
    }
    
    /**
     * 加载相关故事
     */
    private fun loadRelatedStories(story: com.dunzi.storyhouse.data.model.Story) {
        viewModelScope.launch {
            try {
                // 根据分类加载相关故事
                val related = storyRepository.getStoriesByCategory(
                    category = story.category,
                    limit = 10
                ).filter { it.id != story.id }
                
                _relatedStories.value = related
            } catch (e: Exception) {
                // 忽略错误，相关故事不是关键功能
            }
        }
    }
    
    /**
     * 加载播放统计
     */
    private fun loadPlayStats(storyId: Long) {
        viewModelScope.launch {
            try {
                val stats = playHistoryRepository.getStoryPlayStats(storyId)
                _playStats.value = stats
            } catch (e: Exception) {
                // 忽略错误，统计信息不是关键功能
            }
        }
    }
    
    /**
     * 切换收藏状态
     */
    fun toggleFavorite() {
        val story = _storyDetailState.value.story
        if (story != null) {
            viewModelScope.launch {
                try {
                    storyRepository.toggleFavorite(story.id, !story.isFavorite)
                    
                    // 更新本地状态
                    _storyDetailState.update { state ->
                        state.copy(
                            story = story.copy(isFavorite = !story.isFavorite)
                        )
                    }
                } catch (e: Exception) {
                    _storyDetailState.update { state ->
                        state.copy(error = "收藏操作失败: ${e.message}")
                    }
                }
            }
        }
    }
    
    /**
     * 标记为已读/未读
     */
    fun toggleReadStatus() {
        val story = _storyDetailState.value.story
        if (story != null) {
            viewModelScope.launch {
                try {
                    storyRepository.markAsCompleted(story.id, !story.completed)
                    
                    // 更新本地状态
                    _storyDetailState.update { state ->
                        state.copy(
                            story = story.copy(completed = !story.completed)
                        )
                    }
                } catch (e: Exception) {
                    _storyDetailState.update { state ->
                        state.copy(error = "更新状态失败: ${e.message}")
                    }
                }
            }
        }
    }
    
    /**
     * 更新播放进度
     */
    fun updatePlayProgress(progress: Float) {
        val story = _storyDetailState.value.story
        if (story != null) {
            viewModelScope.launch {
                try {
                    storyRepository.updatePlayProgress(story.id, progress)
                    
                    // 更新本地状态
                    _storyDetailState.update { state ->
                        state.copy(
                            story = story.copy(progress = progress)
                        )
                    }
                } catch (e: Exception) {
                    // 忽略错误，进度更新不是关键功能
                }
            }
        }
    }
    
    /**
     * 记录播放历史
     */
    fun recordPlayHistory(duration: Long, completed: Boolean = false) {
        val story = _storyDetailState.value.story
        if (story != null) {
            viewModelScope.launch {
                try {
                    playHistoryRepository.recordPlay(
                        storyId = story.id,
                        userId = "default",
                        duration = duration,
                        playedAt = System.currentTimeMillis(),
                        completed = completed,
                        deviceName = android.os.Build.MODEL
                    )
                    
                    // 重新加载统计
                    loadPlayStats(story.id)
                } catch (e: Exception) {
                    // 忽略错误，历史记录不是关键功能
                }
            }
        }
    }
    
    /**
     * 获取年龄建议
     */
    fun getAgeSuggestion(): String {
        val story = _storyDetailState.value.story
        return if (story != null) {
            if (story.minAge == story.maxAge) {
                "适合${story.minAge}岁儿童"
            } else if (story.maxAge > 0) {
                "适合${story.minAge}-${story.maxAge}岁儿童"
            } else {
                "适合${story.minAge}岁以上儿童"
            }
        } else {
            ""
        }
    }
    
    /**
     * 获取时长描述
     */
    fun getDurationDescription(): String {
        val story = _storyDetailState.value.story
        return story?.getDurationString() ?: ""
    }
    
    /**
     * 获取难度描述
     */
    fun getDifficultyDescription(): String {
        val story = _storyDetailState.value.story
        return when (story?.difficulty) {
            "easy" -> "简单"
            "medium" -> "中等"
            "hard" -> "困难"
            else -> "未知"
        }
    }
    
    /**
     * 获取播放次数
     */
    fun getPlayCount(): Int {
        return _playStats.value?.playCount ?: 0
    }
    
    /**
     * 获取平均播放时长
     */
    fun getAveragePlayTime(): String {
        val stats = _playStats.value
        return if (stats != null && stats.totalPlayTime > 0 && stats.playCount > 0) {
            val averageMs = stats.totalPlayTime / stats.playCount
            val minutes = averageMs / 60000
            val seconds = (averageMs % 60000) / 1000
            "${minutes}分${seconds}秒"
        } else {
            "暂无数据"
        }
    }
    
    /**
     * 获取完成率
     */
    fun getCompletionRate(): String {
        val stats = _playStats.value
        return if (stats != null && stats.playCount > 0) {
            val rate = (stats.completedCount.toFloat() / stats.playCount * 100).toInt()
            "${rate}%"
        } else {
            "0%"
        }
    }
    
    /**
     * 清除错误
     */
    fun clearError() {
        _storyDetailState.update { it.copy(error = null) }
    }
    
    /**
     * 故事详情状态
     */
    data class StoryDetailState(
        val story: com.dunzi.storyhouse.data.model.Story? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    ) {
        /**
         * 检查是否有故事
         */
        val hasStory: Boolean
            get() = story != null
        
        /**
         * 检查是否在加载
         */
        val isReady: Boolean
            get() = !isLoading && hasStory && error == null
        
        /**
         * 获取故事标签
         */
        val tags: List<String>
            get() = story?.tags ?: emptyList()
        
        /**
         * 获取故事章节
         */
        val chapters: List<com.dunzi.storyhouse.data.model.Chapter>
            get() = emptyList() // 暂时返回空列表，需要从数据库或API获取
        
        /**
         * 检查是否有章节
         */
        val hasChapters: Boolean
            get() = chapters.isNotEmpty()
        
        /**
         * 检查是否有标签
         */
        val hasTags: Boolean
            get() = tags.isNotEmpty()
        
        /**
         * 获取故事描述
         */
        val description: String
            get() = story?.description ?: ""
        
        /**
         * 获取故事内容
         */
        val content: String
            get() = story?.content ?: ""
        
        /**
         * 检查是否有内容
         */
        val hasContent: Boolean
            get() = content.isNotBlank()
        
        /**
         * 检查是否有描述
         */
        val hasDescription: Boolean
            get() = description.isNotBlank()
    }
}