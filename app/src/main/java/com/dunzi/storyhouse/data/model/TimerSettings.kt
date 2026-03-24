package com.dunzi.storyhouse.data.model

/**
 * 定时设置数据类
 */
data class TimerSettings(
    val sleepTimerEnabled: Boolean = false, // 睡眠定时器
    val sleepTimerDuration: Int = 30, // 睡眠定时时长（分钟）
    val dailyLimitEnabled: Boolean = false, // 每日限制
    val dailyLimitDuration: Int = 60, // 每日限制时长（分钟）
    val breakReminderEnabled: Boolean = true, // 休息提醒
    val breakInterval: Int = 30, // 休息间隔（分钟）
    val breakDuration: Int = 5, // 休息时长（分钟）
    val autoPauseEnabled: Boolean = false, // 自动暂停
    val autoPauseDuration: Int = 15 // 自动暂停时长（分钟）
)