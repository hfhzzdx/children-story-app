package com.dunzi.storyhouse.data.model

/**
 * 学习设置数据类
 */
data class LearningSettings(
    val learningMode: Boolean = false, // 学习模式
    val repeatDifficultParts: Boolean = true, // 重复困难部分
    val showSubtitles: Boolean = false, // 显示字幕
    val vocabularyHighlight: Boolean = true, // 词汇高亮
    val pronunciationPractice: Boolean = false, // 发音练习
    val comprehensionQuestions: Boolean = true, // 理解问题
    val progressTracking: Boolean = true, // 进度跟踪
    val achievementSystem: Boolean = true, // 成就系统
    val dailyGoals: Boolean = false, // 每日目标
    val dailyGoalMinutes: Int = 30, // 每日目标分钟数
    val difficultyLevel: String = "adaptive" // 难度级别：easy/medium/hard/adaptive
)