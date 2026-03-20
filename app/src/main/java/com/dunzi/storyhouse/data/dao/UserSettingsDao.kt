package com.dunzi.storyhouse.data.dao

import androidx.room.*
import com.dunzi.storyhouse.data.model.UserSettings
import kotlinx.coroutines.flow.Flow

/**
 * 用户设置数据访问对象
 */
@Dao
interface UserSettingsDao {
    
    // 插入操作
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settings: UserSettings)
    
    // 更新操作
    @Update
    suspend fun update(settings: UserSettings)
    
    // 删除操作
    @Delete
    suspend fun delete(settings: UserSettings)
    
    @Query("DELETE FROM user_settings WHERE userId = :userId")
    suspend fun deleteByUserId(userId: String)
    
    // 查询操作
    @Query("SELECT * FROM user_settings WHERE userId = :userId")
    suspend fun getByUserId(userId: String): UserSettings?
    
    @Query("SELECT * FROM user_settings WHERE userId = :userId")
    fun getByUserIdFlow(userId: String): Flow<UserSettings?>
    
    // 检查是否存在
    @Query("SELECT COUNT(*) FROM user_settings WHERE userId = :userId")
    suspend fun exists(userId: String): Int
    
    // 创建或更新
    @Transaction
    suspend fun upsert(settings: UserSettings) {
        if (exists(settings.userId) > 0) {
            update(settings)
        } else {
            insert(settings)
        }
    }
    
    // 部分更新操作 - 儿童信息
    @Query("UPDATE user_settings SET childName = :name, childAge = :age, childGender = :gender, childAvatar = :avatar, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateChildInfo(userId: String, name: String, age: Int, gender: String, avatar: String, timestamp: Long)
    
    // 部分更新操作 - 播放设置
    @Query("UPDATE user_settings SET defaultVolume = :volume, defaultPlaybackSpeed = :speed, defaultVoiceType = :voiceType, backgroundPlay = :backgroundPlay, autoPlayNext = :autoPlayNext, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updatePlaybackSettings(userId: String, volume: Float, speed: Float, voiceType: String, backgroundPlay: Boolean, autoPlayNext: Boolean, timestamp: Long)
    
    // 部分更新操作 - 定时设置
    @Query("UPDATE user_settings SET sleepTimerEnabled = :enabled, sleepTimerDuration = :duration, dailyLimitEnabled = :limitEnabled, dailyLimitDuration = :limitDuration, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateTimerSettings(userId: String, enabled: Boolean, duration: Long, limitEnabled: Boolean, limitDuration: Long, timestamp: Long)
    
    // 部分更新操作 - 显示设置
    @Query("UPDATE user_settings SET theme = :theme, fontSize = :fontSize, eyeProtectionMode = :eyeProtection, animationEnabled = :animation, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateDisplaySettings(userId: String, theme: String, fontSize: String, eyeProtection: Boolean, animation: Boolean, timestamp: Long)
    
    // 部分更新操作 - 内容过滤
    @Query("UPDATE user_settings SET contentFilterLevel = :level, ageRestriction = :ageRestriction, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateContentFilter(userId: String, level: String, ageRestriction: Boolean, timestamp: Long)
    
    // 部分更新操作 - 家长控制
    @Query("UPDATE user_settings SET parentalControlEnabled = :enabled, purchaseLock = :purchaseLock, dataCollectionAllowed = :dataCollection, analyticsEnabled = :analytics, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateParentalControl(userId: String, enabled: Boolean, purchaseLock: Boolean, dataCollection: Boolean, analytics: Boolean, timestamp: Long)
    
    // 部分更新操作 - 通知设置
    @Query("UPDATE user_settings SET notificationsEnabled = :enabled, reminderNotifications = :reminders, updateNotifications = :updates, promotionalNotifications = :promotional, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateNotificationSettings(userId: String, enabled: Boolean, reminders: Boolean, updates: Boolean, promotional: Boolean, timestamp: Long)
    
    // 部分更新操作 - 存储设置
    @Query("UPDATE user_settings SET autoDownloadFavorites = :autoDownload, storageLocation = :location, cacheSizeLimit = :cacheLimit, autoClearCache = :autoClear, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateStorageSettings(userId: String, autoDownload: Boolean, location: String, cacheLimit: Long, autoClear: Boolean, timestamp: Long)
    
    // 部分更新操作 - 网络设置
    @Query("UPDATE user_settings SET wifiOnlyDownload = :wifiOnly, dataSaverMode = :dataSaver, syncEnabled = :sync, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateNetworkSettings(userId: String, wifiOnly: Boolean, dataSaver: Boolean, sync: Boolean, timestamp: Long)
    
    // 部分更新操作 - 音频设置
    @Query("UPDATE user_settings SET backgroundMusic = :bgMusic, backgroundMusicType = :bgMusicType, backgroundMusicVolume = :bgMusicVolume, soundEffects = :soundEffects, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateAudioSettings(userId: String, bgMusic: Boolean, bgMusicType: String, bgMusicVolume: Float, soundEffects: Boolean, timestamp: Long)
    
    // 部分更新操作 - 播放模式
    @Query("UPDATE user_settings SET playMode = :mode, shuffleEnabled = :shuffle, crossfadeDuration = :crossfade, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updatePlayMode(userId: String, mode: String, shuffle: Boolean, crossfade: Long, timestamp: Long)
    
    // 部分更新操作 - 学习设置
    @Query("UPDATE user_settings SET learningMode = :learningMode, repeatDifficultParts = :repeatParts, showSubtitles = :subtitles, vocabularyHighlight = :vocabularyHighlight, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateLearningSettings(userId: String, learningMode: Boolean, repeatParts: Boolean, subtitles: Boolean, vocabularyHighlight: Boolean, timestamp: Long)
    
    // 部分更新操作 - 统计信息
    @Query("UPDATE user_settings SET totalPlayTime = totalPlayTime + :additionalTime, storiesCompleted = storiesCompleted + :completedCount, favoritesCount = :favoritesCount, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateStatistics(userId: String, additionalTime: Long, completedCount: Int, favoritesCount: Int, timestamp: Long)
    
    // 部分更新操作 - 最后登录时间
    @Query("UPDATE user_settings SET lastLoginAt = :timestamp WHERE userId = :userId")
    suspend fun updateLastLogin(userId: String, timestamp: Long)
    
    // 批量更新操作 - 屏蔽分类
    @Query("UPDATE user_settings SET blockedCategories = :categories, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateBlockedCategories(userId: String, categories: List<String>, timestamp: Long)
    
    // 批量更新操作 - 屏蔽标签
    @Query("UPDATE user_settings SET blockedTags = :tags, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateBlockedTags(userId: String, tags: List<String>, timestamp: Long)
    
    // 自定义设置操作
    @Query("UPDATE user_settings SET customSettings = :settings, updatedAt = :timestamp WHERE userId = :userId")
    suspend fun updateCustomSettings(userId: String, settings: Map<String, String>, timestamp: Long)
    
    // 重置设置
    @Query("""
        UPDATE user_settings SET 
            childName = '',
            childAge = 3,
            childGender = '',
            childAvatar = '',
            defaultVolume = 0.8,
            defaultPlaybackSpeed = 1.0,
            defaultVoiceType = 'child_female',
            backgroundPlay = true,
            autoPlayNext = true,
            sleepTimerEnabled = false,
            sleepTimerDuration = 1800000,
            dailyLimitEnabled = false,
            dailyLimitDuration = 3600000,
            theme = 'light',
            fontSize = 'medium',
            eyeProtectionMode = false,
            animationEnabled = true,
            contentFilterLevel = 'moderate',
            blockedCategories = '[]',
            blockedTags = '[]',
            ageRestriction = true,
            parentalControlEnabled = false,
            purchaseLock = true,
            dataCollectionAllowed = false,
            analyticsEnabled = true,
            notificationsEnabled = true,
            reminderNotifications = true,
            updateNotifications = true,
            promotionalNotifications = false,
            autoDownloadFavorites = false,
            storageLocation = 'internal',
            cacheSizeLimit = 1073741824,
            autoClearCache = true,
            wifiOnlyDownload = true,
            dataSaverMode = false,
            syncEnabled = false,
            backgroundMusic = false,
            backgroundMusicType = 'piano',
            backgroundMusicVolume = 0.3,
            soundEffects = true,
            playMode = 'sequential',
            shuffleEnabled = false,
            crossfadeDuration = 3000,
            learningMode = false,
            repeatDifficultParts = true,
            showSubtitles = false,
            vocabularyHighlight = true,
            customSettings = '{}',
            updatedAt = :timestamp
        WHERE userId = :userId
    """)
    suspend fun resetToDefaults(userId: String, timestamp: Long)
    
    // 获取所有用户
    @Query("SELECT * FROM user_settings")
    suspend fun getAll(): List<UserSettings>
    
    // 获取用户数量
    @Query("SELECT COUNT(*) FROM user_settings")
    suspend fun getCount(): Int
    
    // 检查家长控制是否启用
    @Query("SELECT parentalControlEnabled FROM user_settings WHERE userId = :userId")
    suspend fun isParentalControlEnabled(userId: String): Boolean?
    
    // 检查每日限制是否启用
    @Query("SELECT dailyLimitEnabled FROM user_settings WHERE userId = :userId")
    suspend fun isDailyLimitEnabled(userId: String): Boolean?
    
    // 获取今日剩余播放时间
    @Query("SELECT dailyLimitDuration - COALESCE((SELECT SUM(duration) FROM play_history WHERE userId = :userId AND date(playedAt/1000, 'unixepoch') = date('now')), 0) as remainingTime FROM user_settings WHERE userId = :userId AND dailyLimitEnabled = 1")
    suspend fun getRemainingPlayTimeToday(userId: String): Long?
}