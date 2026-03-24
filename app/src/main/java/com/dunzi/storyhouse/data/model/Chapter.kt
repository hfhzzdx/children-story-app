package com.dunzi.storyhouse.data.model

/**
 * 故事章节
 */
data class Chapter(
    val id: Long = 0,
    val storyId: Long = 0,
    val title: String = "",
    val content: String = "",
    val audioPath: String = "",
    val duration: Long = 0, // 时长（毫秒）
    val order: Int = 0, // 章节顺序
    val wordCount: Int = 0 // 字数
) {
    /**
     * 获取章节时长字符串
     */
    fun getDurationString(): String {
        val minutes = duration / 60000
        val seconds = (duration % 60000) / 1000
        return if (minutes > 0) {
            "${minutes}分${seconds}秒"
        } else {
            "${seconds}秒"
        }
    }
    
    /**
     * 获取章节摘要
     */
    fun getSummary(maxLength: Int = 100): String {
        return if (content.length > maxLength) {
            content.substring(0, maxLength) + "..."
        } else {
            content
        }
    }
}