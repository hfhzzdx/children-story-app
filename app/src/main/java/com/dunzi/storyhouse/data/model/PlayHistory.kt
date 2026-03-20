package com.dunzi.storyhouse.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dunzi.storyhouse.data.converter.DateConverter
import java.util.Date

/**
 * 播放历史实体类
 */
@Entity(
    tableName = "play_history",
    foreignKeys = [
        ForeignKey(
            entity = Story::class,
            parentColumns = ["id"],
            childColumns = ["storyId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["storyId"]),
        Index(value = ["userId"]),
        Index(value = ["playedAt"])
    ]
)
@TypeConverters(DateConverter::class)
data class PlayHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    // 关联信息
    val storyId: Long, // 关联的故事ID
    val userId: String = "default", // 用户ID（支持多用户）
    
    // 播放信息
    val startPosition: Long = 0, // 开始播放位置（毫秒）
    val endPosition: Long = 0, // 结束播放位置（毫秒）
    val duration: Long = 0, // 本次播放时长（毫秒）
    val completed: Boolean = false, // 是否播放完成
    
    // 播放设置
    val playbackSpeed: Float = 1.0f, // 播放速度
    val volume: Float = 1.0f, // 音量
    val voiceType: String = "default", // 语音类型
    
    // 设备信息
    val deviceId: String = "", // 设备ID
    val deviceName: String = "", // 设备名称
    
    // 时间信息
    val playedAt: Date = Date(), // 播放时间
    val finishedAt: Date? = null, // 完成时间
    
    // 统计信息
    val interruptions: Int = 0, // 中断次数
    val skips: Int = 0, // 跳过次数
    val rewinds: Int = 0, // 回退次数
    
    // 扩展信息
    val sessionId: String = "", // 会话ID
    val metadata: Map<String, String> = emptyMap() // 扩展元数据
) {
    /**
     * 获取播放时长字符串
     */
    fun getDurationString(): String {
        val minutes = duration / 60000
        val seconds = (duration % 60000) / 1000
        
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
    
    /**
     * 获取播放进度
     */
    fun getProgress(): Float {
        return if (duration > 0) {
            (endPosition - startPosition).toFloat() / duration
        } else {
            0f
        }
    }
    
    /**
     * 获取播放进度百分比
     */
    fun getProgressPercentage(): Int {
        return (getProgress() * 100).toInt()
    }
    
    /**
     * 检查是否是完整播放
     */
    fun isFullPlay(): Boolean {
        return completed && getProgress() >= 0.95f // 95%以上算完整播放
    }
    
    /**
     * 获取播放时间段
     */
    fun getTimeRange(): String {
        val startTime = playedAt
        val endTime = finishedAt ?: playedAt
        
        // 这里可以添加时间格式化逻辑
        return "从 ${startTime} 到 ${endTime}"
    }
}