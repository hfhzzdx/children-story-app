package com.dunzi.storyhouse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dunzi.storyhouse.data.converter.DateConverter
import com.dunzi.storyhouse.data.converter.MapConverter
import java.util.Date

/**
 * 用户设置实体类
 */
@Entity(tableName = "user_settings")
@TypeConverters(DateConverter::class, MapConverter::class)
data class UserSettings(
    @PrimaryKey
    val userId: String = "default",
    
    // 儿童信息
    val childName: String = "",
    val childAge: Int = 3,
    val childGender: String = "", // boy/girl
    val childAvatar: String = "", // 头像路径
    
    // 播放设置
    val defaultVolume: Float = 0.8f, // 默认音量（0-1）
    val defaultPlaybackSpeed: Float = 1.0f, // 默认播放速度
    val defaultVoiceType: String = "child_female", // 默认语音类型
    val backgroundPlay: Boolean = true, // 是否允许后台播放
    val autoPlayNext: Boolean = true, // 是否自动播放下一个
    
    // 定时设置
    val sleepTimerEnabled: Boolean = false, // 睡眠定时器
    val sleepTimerDuration: Long = 1800000, // 30分钟（毫秒）
    val dailyLimitEnabled: Boolean = false, // 每日限制
    val dailyLimitDuration: Long = 3600000, // 1小时（毫秒）
    
    // 显示设置
    val theme: String = "light", // light/dark/eye_protection
    val fontSize: String = "medium", // small/medium/large/xlarge
    val eyeProtectionMode: Boolean = false, // 护眼模式
    val animationEnabled: Boolean = true, // 动画效果
    
    // 内容过滤
    val contentFilterLevel: String = "moderate", // strict/moderate/relaxed
    val blockedCategories: List<String> = emptyList(), // 屏蔽的分类
    val blockedTags: List<String> = emptyList(), // 屏蔽的标签
    val ageRestriction: Boolean = true, // 年龄限制
    
    // 家长控制
    val parentalControlEnabled: Boolean = false,
    val purchaseLock: Boolean = true, // 购买锁定
    val dataCollectionAllowed: Boolean = false, // 数据收集
    val analyticsEnabled: Boolean = true, // 分析功能
    
    // 通知设置
    val notificationsEnabled: Boolean = true,
    val reminderNotifications: Boolean = true, // 提醒通知
    val updateNotifications: Boolean = true, // 更新通知
    val promotionalNotifications: Boolean = false, // 推广通知
    
    // 存储设置
    val autoDownloadFavorites: Boolean = false, // 自动下载收藏
    val storageLocation: String = "internal", // internal/external
    val cacheSizeLimit: Long = 1073741824, // 1GB（字节）
    val autoClearCache: Boolean = true, // 自动清理缓存
    
    // 网络设置
    val wifiOnlyDownload: Boolean = true, // 仅WiFi下载
    val dataSaverMode: Boolean = false, // 省流量模式
    val syncEnabled: Boolean = false, // 云同步
    
    // 音频设置
    val backgroundMusic: Boolean = false, // 背景音乐
    val backgroundMusicType: String = "piano", // 背景音乐类型
    val backgroundMusicVolume: Float = 0.3f, // 背景音乐音量
    val soundEffects: Boolean = true, // 音效
    
    // 播放模式
    val playMode: String = "sequential", // sequential/random/repeat_one/repeat_all
    val shuffleEnabled: Boolean = false, // 随机播放
    val crossfadeDuration: Long = 3000, // 交叉淡入淡出时长（毫秒）
    
    // 学习设置
    val learningMode: Boolean = false, // 学习模式
    val repeatDifficultParts: Boolean = true, // 重复困难部分
    val showSubtitles: Boolean = false, // 显示字幕
    val vocabularyHighlight: Boolean = true, // 词汇高亮
    
    // 时间信息
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val lastLoginAt: Date? = null, // 最后登录时间
    
    // 统计信息
    val totalPlayTime: Long = 0, // 总播放时长（毫秒）
    val storiesCompleted: Int = 0, // 完成的故事数
    val favoritesCount: Int = 0, // 收藏数
    
    // 扩展设置
    val customSettings: Map<String, String> = emptyMap() // 自定义设置
) {
    /**
     * 获取主题资源ID
     */
    fun getThemeResource(): Int {
        // 返回主题标识，实际资源引用应该在UI层处理
        return when (theme) {
            "dark" -> 1
            "eye_protection" -> 2
            else -> 0
        }
    }
    
    /**
     * 获取字体大小资源
     */
    fun getFontSizeResource(): Int {
        // 返回字体大小标识，实际资源引用应该在UI层处理
        return when (fontSize) {
            "small" -> 0
            "large" -> 2
            "xlarge" -> 3
            else -> 1 // medium
        }
    }
    
    /**
     * 获取每日限制时间字符串
     */
    fun getDailyLimitString(): String {
        val minutes = dailyLimitDuration / 60000
        return "${minutes}分钟"
    }
    
    /**
     * 获取睡眠定时时间字符串
     */
    fun getSleepTimerString(): String {
        val minutes = sleepTimerDuration / 60000
        return "${minutes}分钟"
    }
    
    /**
     * 检查是否达到每日限制
     */
    fun isDailyLimitReached(todayPlayTime: Long): Boolean {
        return dailyLimitEnabled && todayPlayTime >= dailyLimitDuration
    }
    
    /**
     * 获取剩余播放时间
     */
    fun getRemainingPlayTime(todayPlayTime: Long): Long {
        return if (dailyLimitEnabled) {
            maxOf(0, dailyLimitDuration - todayPlayTime)
        } else {
            Long.MAX_VALUE
        }
    }
    
    /**
     * 获取语音类型显示名称
     */
    fun getVoiceTypeDisplayName(): String {
        return when (defaultVoiceType) {
            "child_female" -> "儿童女声"
            "child_male" -> "儿童男声"
            "gentle_female" -> "温柔女声"
            "grandpa" -> "爷爷声音"
            else -> "默认语音"
        }
    }
    
    /**
     * 获取播放模式显示名称
     */
    fun getPlayModeDisplayName(): String {
        return when (playMode) {
            "sequential" -> "顺序播放"
            "random" -> "随机播放"
            "repeat_one" -> "单曲循环"
            "repeat_all" -> "列表循环"
            else -> "顺序播放"
        }
    }
}