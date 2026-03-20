package com.dunzi.storyhouse.data.repository

import com.dunzi.storyhouse.data.database.StoryDatabase
import com.dunzi.storyhouse.data.model.UserSettings
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 用户设置仓库，封装用户设置数据访问逻辑
 */
@Singleton
class UserSettingsRepository @Inject constructor(
    private val database: StoryDatabase
) {
    private val userSettingsDao = database.userSettingsDao()
    
    // 获取用户设置
    fun getUserSettings(userId: String = "default"): Flow<UserSettings?> = 
        userSettingsDao.getByUserIdFlow(userId)
    
    // 创建或更新用户设置
    suspend fun upsertUserSettings(settings: UserSettings) = 
        userSettingsDao.upsert(settings)
    
    // 更新用户设置
    suspend fun updateUserSettings(settings: UserSettings) = 
        userSettingsDao.update(settings)
    
    // 删除用户设置
    suspend fun deleteUserSettings(userId: String) = 
        userSettingsDao.deleteByUserId(userId)
    
    // 检查用户设置是否存在
    suspend fun userSettingsExists(userId: String): Boolean = 
        userSettingsDao.exists(userId) > 0
    
    // 获取默认用户设置
    suspend fun getDefaultUserSettings(): UserSettings {
        return UserSettings(
            userId = "default",
            childName = "小墩子",
            childAge = 4,
            childGender = "boy",
            createdAt = Date(),
            updatedAt = Date()
        )
    }
    
    // 初始化用户设置（如果不存在）
    suspend fun initializeUserSettings(userId: String = "default"): UserSettings {
        return if (userSettingsExists(userId)) {
            userSettingsDao.getByUserId(userId)!!
        } else {
            val defaultSettings = getDefaultUserSettings().copy(userId = userId)
            userSettingsDao.insert(defaultSettings)
            defaultSettings
        }
    }
    
    // 更新儿童信息
    suspend fun updateChildInfo(
        userId: String = "default",
        name: String,
        age: Int,
        gender: String,
        avatar: String = ""
    ) {
        userSettingsDao.updateChildInfo(
            userId = userId,
            name = name,
            age = age,
            gender = gender,
            avatar = avatar,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新播放设置
    suspend fun updatePlaybackSettings(
        userId: String = "default",
        volume: Float,
        speed: Float,
        voiceType: String,
        backgroundPlay: Boolean,
        autoPlayNext: Boolean
    ) {
        userSettingsDao.updatePlaybackSettings(
            userId = userId,
            volume = volume,
            speed = speed,
            voiceType = voiceType,
            backgroundPlay = backgroundPlay,
            autoPlayNext = autoPlayNext,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新定时设置
    suspend fun updateTimerSettings(
        userId: String = "default",
        sleepTimerEnabled: Boolean,
        sleepTimerDuration: Long,
        dailyLimitEnabled: Boolean,
        dailyLimitDuration: Long
    ) {
        userSettingsDao.updateTimerSettings(
            userId = userId,
            enabled = sleepTimerEnabled,
            duration = sleepTimerDuration,
            limitEnabled = dailyLimitEnabled,
            limitDuration = dailyLimitDuration,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新显示设置
    suspend fun updateDisplaySettings(
        userId: String = "default",
        theme: String,
        fontSize: String,
        eyeProtection: Boolean,
        animation: Boolean
    ) {
        userSettingsDao.updateDisplaySettings(
            userId = userId,
            theme = theme,
            fontSize = fontSize,
            eyeProtection = eyeProtection,
            animation = animation,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新内容过滤
    suspend fun updateContentFilter(
        userId: String = "default",
        level: String,
        ageRestriction: Boolean
    ) {
        userSettingsDao.updateContentFilter(
            userId = userId,
            level = level,
            ageRestriction = ageRestriction,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新家长控制
    suspend fun updateParentalControl(
        userId: String = "default",
        enabled: Boolean,
        purchaseLock: Boolean,
        dataCollection: Boolean,
        analytics: Boolean
    ) {
        userSettingsDao.updateParentalControl(
            userId = userId,
            enabled = enabled,
            purchaseLock = purchaseLock,
            dataCollection = dataCollection,
            analytics = analytics,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新通知设置
    suspend fun updateNotificationSettings(
        userId: String = "default",
        enabled: Boolean,
        reminders: Boolean,
        updates: Boolean,
        promotional: Boolean
    ) {
        userSettingsDao.updateNotificationSettings(
            userId = userId,
            enabled = enabled,
            reminders = reminders,
            updates = updates,
            promotional = promotional,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新存储设置
    suspend fun updateStorageSettings(
        userId: String = "default",
        autoDownload: Boolean,
        location: String,
        cacheLimit: Long,
        autoClear: Boolean
    ) {
        userSettingsDao.updateStorageSettings(
            userId = userId,
            autoDownload = autoDownload,
            location = location,
            cacheLimit = cacheLimit,
            autoClear = autoClear,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新网络设置
    suspend fun updateNetworkSettings(
        userId: String = "default",
        wifiOnly: Boolean,
        dataSaver: Boolean,
        sync: Boolean
    ) {
        userSettingsDao.updateNetworkSettings(
            userId = userId,
            wifiOnly = wifiOnly,
            dataSaver = dataSaver,
            sync = sync,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新音频设置
    suspend fun updateAudioSettings(
        userId: String = "default",
        bgMusic: Boolean,
        bgMusicType: String,
        bgMusicVolume: Float,
        soundEffects: Boolean
    ) {
        userSettingsDao.updateAudioSettings(
            userId = userId,
            bgMusic = bgMusic,
            bgMusicType = bgMusicType,
            bgMusicVolume = bgMusicVolume,
            soundEffects = soundEffects,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新播放模式
    suspend fun updatePlayMode(
        userId: String = "default",
        mode: String,
        shuffle: Boolean,
        crossfade: Long
    ) {
        userSettingsDao.updatePlayMode(
            userId = userId,
            mode = mode,
            shuffle = shuffle,
            crossfade = crossfade,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新学习设置
    suspend fun updateLearningSettings(
        userId: String = "default",
        learningMode: Boolean,
        repeatParts: Boolean,
        subtitles: Boolean,
        vocabularyHighlight: Boolean
    ) {
        userSettingsDao.updateLearningSettings(
            userId = userId,
            learningMode = learningMode,
            repeatParts = repeatParts,
            subtitles = subtitles,
            vocabularyHighlight = vocabularyHighlight,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新统计信息
    suspend fun updateStatistics(
        userId: String = "default",
        additionalTime: Long,
        completedCount: Int,
        favoritesCount: Int
    ) {
        userSettingsDao.updateStatistics(
            userId = userId,
            additionalTime = additionalTime,
            completedCount = completedCount,
            favoritesCount = favoritesCount,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新最后登录时间
    suspend fun updateLastLogin(userId: String = "default") {
        userSettingsDao.updateLastLogin(userId, System.currentTimeMillis())
    }
    
    // 更新屏蔽分类
    suspend fun updateBlockedCategories(
        userId: String = "default",
        categories: List<String>
    ) {
        userSettingsDao.updateBlockedCategories(
            userId = userId,
            categories = categories,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新屏蔽标签
    suspend fun updateBlockedTags(
        userId: String = "default",
        tags: List<String>
    ) {
        userSettingsDao.updateBlockedTags(
            userId = userId,
            tags = tags,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 更新自定义设置
    suspend fun updateCustomSettings(
        userId: String = "default",
        settings: Map<String, String>
    ) {
        userSettingsDao.updateCustomSettings(
            userId = userId,
            settings = settings,
            timestamp = System.currentTimeMillis()
        )
    }
    
    // 重置为默认设置
    suspend fun resetToDefaults(userId: String = "default") {
        userSettingsDao.resetToDefaults(userId, System.currentTimeMillis())
    }
    
    // 检查家长控制是否启用
    suspend fun isParentalControlEnabled(userId: String = "default"): Boolean {
        return userSettingsDao.isParentalControlEnabled(userId) ?: false
    }
    
    // 检查每日限制是否启用
    suspend fun isDailyLimitEnabled(userId: String = "default"): Boolean {
        return userSettingsDao.isDailyLimitEnabled(userId) ?: false
    }
    
    // 获取今日剩余播放时间
    suspend fun getRemainingPlayTimeToday(userId: String = "default"): Long {
        return userSettingsDao.getRemainingPlayTimeToday(userId) ?: Long.MAX_VALUE
    }
    
    // 检查是否达到每日限制
    suspend fun isDailyLimitReached(
        userId: String = "default",
        todayPlayTime: Long
    ): Boolean {
        val settings = userSettingsDao.getByUserId(userId)
        return settings?.isDailyLimitReached(todayPlayTime) ?: false
    }
    
    // 获取所有用户设置
    suspend fun getAllUserSettings(): List<UserSettings> = 
        userSettingsDao.getAll()
    
    // 获取用户数量
    suspend fun getUserCount(): Int = 
        userSettingsDao.getCount()
    
    // 获取用户设置摘要
    suspend fun getUserSettingsSummary(userId: String = "default"): UserSettingsSummary {
        val settings = userSettingsDao.getByUserId(userId) ?: getDefaultUserSettings()
        
        return UserSettingsSummary(
            childName = settings.childName,
            childAge = settings.childAge,
            childGender = settings.childGender,
            theme = settings.theme,
            fontSize = settings.fontSize,
            dailyLimitEnabled = settings.dailyLimitEnabled,
            dailyLimitDuration = settings.dailyLimitDuration,
            parentalControlEnabled = settings.parentalControlEnabled,
            totalPlayTime = settings.totalPlayTime,
            storiesCompleted = settings.storiesCompleted,
            favoritesCount = settings.favoritesCount
        )
    }
    
    data class UserSettingsSummary(
        val childName: String,
        val childAge: Int,
        val childGender: String,
        val theme: String,
        val fontSize: String,
        val dailyLimitEnabled: Boolean,
        val dailyLimitDuration: Long,
        val parentalControlEnabled: Boolean,
        val totalPlayTime: Long,
        val storiesCompleted: Int,
        val favoritesCount: Int
    ) {
        fun getChildInfo(): String {
            val genderText = when (childGender) {
                "boy" -> "男孩"
                "girl" -> "女孩"
                else -> ""
            }
            return "$childName，${childAge}岁$genderText"
        }
        
        fun getDailyLimitString(): String {
            return if (dailyLimitEnabled) {
                val minutes = dailyLimitDuration / 60000
                "${minutes}分钟/天"
            } else {
                "无限制"
            }
        }
        
        fun getTotalPlayTimeString(): String {
            val hours = totalPlayTime / 3600000
            val minutes = (totalPlayTime % 3600000) / 60000
            return if (hours > 0) {
                "${hours}小时${minutes}分钟"
            } else {
                "${minutes}分钟"
            }
        }
    }
}