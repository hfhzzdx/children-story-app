package com.dunzi.storyhouse

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import com.dunzi.storyhouse.data.database.StoryDatabase
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository
import com.dunzi.storyhouse.data.repository.StoryRepository
import com.dunzi.storyhouse.data.repository.UserSettingsRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * 故事应用主应用程序类
 */
@HiltAndroidApp
class StoryApplication : Application() {
    
    // 依赖注入组件（由Hilt自动生成）
    
    override fun onCreate() {
        super.onCreate()
        
        // 初始化日志
        if (applicationContext.applicationInfo.flags and android.content.pm.ApplicationInfo.FLAG_DEBUGGABLE != 0) {
            Timber.plant(Timber.DebugTree())
        }
        
        // 初始化数据库
        initializeDatabase()
        
        // 创建通知渠道
        createNotificationChannels()
        
        // 初始化其他组件
        initializeComponents()
        
        Timber.d("StoryApplication created")
    }
    
    /**
     * 初始化数据库
     */
    private fun initializeDatabase() {
        // 数据库会在首次访问时自动创建
        // 这里可以添加数据库迁移逻辑
        StoryDatabase.getInstance(this)
    }
    
    /**
     * 创建通知渠道（Android 8.0+）
     */
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            
            // 故事播放通知渠道
            val playChannel = NotificationChannel(
                PLAY_NOTIFICATION_CHANNEL_ID,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = getString(R.string.notification_channel_description)
                setSound(null, null) // 无声音
                enableLights(false)
                enableVibration(false)
            }
            
            // 提醒通知渠道
            val reminderChannel = NotificationChannel(
                REMINDER_NOTIFICATION_CHANNEL_ID,
                "提醒通知",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "故事提醒和定时通知"
                enableLights(true)
                enableVibration(true)
            }
            
            notificationManager.createNotificationChannels(listOf(playChannel, reminderChannel))
        }
    }
    
    /**
     * 初始化其他组件
     */
    private fun initializeComponents() {
        // 这里可以初始化其他全局组件
        // 例如：音频播放器、文本转语音引擎、网络客户端等
    }
    
    /**
     * 获取故事仓库
     */
    fun getStoryRepository(): StoryRepository {
        return StoryRepository(StoryDatabase.getInstance(this))
    }
    
    /**
     * 获取播放历史仓库
     */
    fun getPlayHistoryRepository(): PlayHistoryRepository {
        return PlayHistoryRepository(StoryDatabase.getInstance(this))
    }
    
    /**
     * 获取用户设置仓库
     */
    fun getUserSettingsRepository(): UserSettingsRepository {
        return UserSettingsRepository(StoryDatabase.getInstance(this))
    }
    
    /**
     * 清理应用数据
     */
    suspend fun clearAppData() {
        // 在协程中清理数据库
        withContext(Dispatchers.IO) {
            // 清理数据库
            StoryDatabase.getInstance(this@StoryApplication).clearAllTables()
            
            // 清理SharedPreferences
            getSharedPreferences("story_app_prefs", Context.MODE_PRIVATE).edit().clear().apply()
            
            // 清理文件缓存
            cacheDir.deleteRecursively()
            externalCacheDir?.deleteRecursively()
            
            Timber.d("App data cleared")
        }
    }
    
    companion object {
        // 通知渠道ID
        const val PLAY_NOTIFICATION_CHANNEL_ID = "story_player"
        const val REMINDER_NOTIFICATION_CHANNEL_ID = "story_reminder"
        
        // 共享偏好键名
        const val PREF_FIRST_LAUNCH = "first_launch"
        const val PREF_LAST_VERSION = "last_version"
        const val PREF_ANALYTICS_CONSENT = "analytics_consent"
        
        /**
         * 获取应用程序实例
         */
        fun getInstance(context: Context): StoryApplication {
            return context.applicationContext as StoryApplication
        }
    }
}