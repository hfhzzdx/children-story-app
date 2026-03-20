package com.dunzi.storyhouse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dunzi.storyhouse.data.converter.DateConverter
import com.dunzi.storyhouse.data.converter.ListConverter
import java.util.Date

/**
 * 故事实体类
 */
@Entity(tableName = "stories")
@TypeConverters(DateConverter::class, ListConverter::class)
data class Story(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    // 基本信息
    val title: String,
    val author: String = "",
    val description: String = "",
    val coverImage: String = "", // 封面图片路径或URL
    
    // 分类信息
    val category: String, // 故事分类
    val subCategory: String = "", // 子分类
    val tags: List<String> = emptyList(), // 标签
    
    // 内容信息
    val contentPath: String = "", // 故事内容文件路径
    val audioPath: String = "", // 音频文件路径
    val duration: Long = 0, // 时长（毫秒）
    val wordCount: Int = 0, // 字数
    
    // 适合年龄
    val minAge: Int = 3,
    val maxAge: Int = 6,
    
    // 元数据
    val language: String = "zh-CN", // 语言
    val source: String = "", // 来源（导入/生成/内置）
    val format: String = "", // 格式（txt/pdf/epub/audio）
    
    // 统计信息
    val playCount: Int = 0, // 播放次数
    val favoriteCount: Int = 0, // 收藏次数
    val rating: Float = 0f, // 评分（0-5）
    
    // 时间信息
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val lastPlayedAt: Date? = null, // 最后播放时间
    
    // 状态信息
    val isFavorite: Boolean = false,
    val isDownloaded: Boolean = false,
    val isCompleted: Boolean = false, // 是否已听完
    val isHidden: Boolean = false, // 是否隐藏（家长控制）
    
    // 播放进度
    val lastPosition: Long = 0, // 最后播放位置（毫秒）
    val progress: Float = 0f, // 播放进度（0-1）
    
    // 扩展字段
    val metadata: Map<String, String> = emptyMap() // 扩展元数据
) {
    /**
     * 获取适合年龄范围字符串
     */
    fun getAgeRange(): String {
        return if (minAge == maxAge) {
            "$minAge岁"
        } else {
            "${minAge}-${maxAge}岁"
        }
    }
    
    /**
     * 获取时长字符串
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
     * 获取进度百分比
     */
    fun getProgressPercentage(): Int {
        return (progress * 100).toInt()
    }
    
    /**
     * 检查是否适合指定年龄
     */
    fun isSuitableForAge(age: Int): Boolean {
        return age in minAge..maxAge
    }
    
    /**
     * 检查是否有音频
     */
    fun hasAudio(): Boolean {
        return audioPath.isNotBlank()
    }
    
    /**
     * 检查是否有文本内容
     */
    fun hasContent(): Boolean {
        return contentPath.isNotBlank()
    }
    
    /**
     * 获取主要标签（前3个）
     */
    fun getMainTags(): List<String> {
        return tags.take(3)
    }
}