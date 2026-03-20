package com.dunzi.storyhouse.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dunzi.storyhouse.data.repository.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 设置视图模型
 */
@HiltViewModel
class SettingViewModel @Inject constructor(
    private val userSettingsRepository: UserSettingsRepository
) : ViewModel() {
    
    // 设置状态
    private val _settingState = MutableStateFlow(SettingState())
    val settingState: StateFlow<SettingState> = _settingState.asStateFlow()
    
    // 加载设置
    fun loadSettings() {
        _settingState.update { it.copy(isLoading = true) }
        
        viewModelScope.launch {
            try {
                val settings = userSettingsRepository.getUserSettings("default")
                if (settings != null) {
                    _settingState.update { state ->
                        state.copy(
                            settings = settings,
                            isLoading = false,
                            error = null
                        )
                    }
                } else {
                    _settingState.update { state ->
                        state.copy(
                            isLoading = false,
                            error = "设置不存在"
                        )
                    }
                }
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(
                        isLoading = false,
                        error = "加载设置失败: ${e.message}"
                    )
                }
            }
        }
    }
    
    /**
     * 更新儿童信息
     */
    fun updateChildInfo(
        name: String,
        age: Int,
        gender: String,
        avatar: String? = null
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateChildInfo(
                    userId = "default",
                    name = name,
                    age = age,
                    gender = gender,
                    avatar = avatar
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新儿童信息失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新播放设置
     */
    fun updatePlaybackSettings(
        volume: Int,
        speed: Float,
        voiceType: String,
        backgroundPlay: Boolean,
        autoPlayNext: Boolean
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updatePlaybackSettings(
                    userId = "default",
                    volume = volume,
                    speed = speed,
                    voiceType = voiceType,
                    backgroundPlay = backgroundPlay,
                    autoPlayNext = autoPlayNext
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新播放设置失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新定时设置
     */
    fun updateTimerSettings(
        sleepTimerEnabled: Boolean,
        sleepTimerDuration: Int,
        dailyLimitEnabled: Boolean,
        dailyLimitDuration: Int
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateTimerSettings(
                    userId = "default",
                    sleepTimerEnabled = sleepTimerEnabled,
                    sleepTimerDuration = sleepTimerDuration,
                    dailyLimitEnabled = dailyLimitEnabled,
                    dailyLimitDuration = dailyLimitDuration
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新定时设置失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新显示设置
     */
    fun updateDisplaySettings(
        theme: String,
        fontSize: String,
        eyeProtectionMode: Boolean,
        animationEnabled: Boolean
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateDisplaySettings(
                    userId = "default",
                    theme = theme,
                    fontSize = fontSize,
                    eyeProtectionMode = eyeProtectionMode,
                    animationEnabled = animationEnabled
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新显示设置失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新内容过滤
     */
    fun updateContentFilter(
        level: String,
        blockedCategories: List<String>,
        blockedTags: List<String>,
        ageRestriction: Boolean
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateContentFilter(
                    userId = "default",
                    level = level,
                    blockedCategories = blockedCategories,
                    blockedTags = blockedTags,
                    ageRestriction = ageRestriction
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新内容过滤失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新家长控制
     */
    fun updateParentalControl(
        enabled: Boolean,
        purchaseLock: Boolean,
        dataCollectionAllowed: Boolean,
        analyticsEnabled: Boolean
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateParentalControl(
                    userId = "default",
                    enabled = enabled,
                    purchaseLock = purchaseLock,
                    dataCollectionAllowed = dataCollectionAllowed,
                    analyticsEnabled = analyticsEnabled
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新家长控制失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新通知设置
     */
    fun updateNotificationSettings(
        enabled: Boolean,
        reminders: Boolean,
        updates: Boolean,
        promotions: Boolean
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateNotificationSettings(
                    userId = "default",
                    enabled = enabled,
                    reminders = reminders,
                    updates = updates,
                    promotions = promotions
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新通知设置失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 更新存储设置
     */
    fun updateStorageSettings(
        autoDownloadFavorites: Boolean,
        storageLocation: String,
        cacheSizeLimit: Int,
        autoClearCache: Boolean,
        wifiOnlyDownload: Boolean,
        dataSaverMode: Boolean
    ) {
        viewModelScope.launch {
            try {
                userSettingsRepository.updateStorageSettings(
                    userId = "default",
                    autoDownloadFavorites = autoDownloadFavorites,
                    storageLocation = storageLocation,
                    cacheSizeLimit = cacheSizeLimit,
                    autoClearCache = autoClearCache,
                    wifiOnlyDownload = wifiOnlyDownload,
                    dataSaverMode = dataSaverMode
                )
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "更新存储设置失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 重置为默认设置
     */
    fun resetToDefaults() {
        viewModelScope.launch {
            try {
                userSettingsRepository.resetToDefaults("default")
                
                // 重新加载设置
                loadSettings()
            } catch (e: Exception) {
                _settingState.update { state ->
                    state.copy(error = "重置设置失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 清除错误
     */
    fun clearError() {
        _settingState.update { it.copy(error = null) }
    }
    
    /**
     * 设置状态
     */
    data class SettingState(
        val settings: com.dunzi.storyhouse.data.model.UserSettings? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    ) {
        /**
         * 检查是否有设置
         */
        val hasSettings: Boolean
            get() = settings != null
        
        /**
         * 检查是否在加载
         */
        val isReady: Boolean
            get() = !isLoading && hasSettings && error == null
        
        /**
         * 获取儿童信息
         */
        val childInfo: com.dunzi.storyhouse.data.model.UserSettings.ChildInfo?
            get() = settings?.childInfo
        
        /**
         * 获取播放设置
         */
        val playbackSettings: com.dunzi.storyhouse.data.model.UserSettings.PlaybackSettings?
            get() = settings?.playbackSettings
        
        /**
         * 获取定时设置
         */
        val timerSettings: com.dunzi.storyhouse.data.model.UserSettings.TimerSettings?
            get() = settings?.timerSettings
        
        /**
         * 获取显示设置
         */
        val displaySettings: com.dunzi.storyhouse.data.model.UserSettings.DisplaySettings?
            get() = settings?.displaySettings
        
        /**
         * 获取内容过滤
         */
        val contentFilter: com.dunzi.storyhouse.data.model.UserSettings.ContentFilter?
            get() = settings?.contentFilter
        
        /**
         * 获取家长控制
         */
        val parentalControl: com.dunzi.storyhouse.data.model.UserSettings.ParentalControl?
            get() = settings?.parentalControl
        
        /**
         * 获取通知设置
         */
        val notificationSettings: com.dunzi.storyhouse.data.model.UserSettings.NotificationSettings?
            get() = settings?.notificationSettings
        
        /**
         * 获取存储设置
         */
        val storageSettings: com.dunzi.storyhouse.data.model.UserSettings.StorageSettings?
            get() = settings?.storageSettings
    }
}