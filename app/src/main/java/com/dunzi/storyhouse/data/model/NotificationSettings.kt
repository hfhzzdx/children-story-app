package com.dunzi.storyhouse.data.model

/**
 * 通知设置数据类
 */
data class NotificationSettings(
    val enabled: Boolean = true,
    val reminderNotifications: Boolean = true, // 提醒通知
    val updateNotifications: Boolean = true, // 更新通知
    val promotionalNotifications: Boolean = false, // 推广通知
    val soundEnabled: Boolean = true, // 声音
    val vibrationEnabled: Boolean = true, // 振动
    val ledEnabled: Boolean = true, // LED灯
    val priorityLevel: String = "default", // 优先级：default/high/max
    val quietHoursEnabled: Boolean = false, // 静音时段
    val quietHoursStart: String = "22:00", // 静音开始时间
    val quietHoursEnd: String = "07:00", // 静音结束时间
    val doNotDisturb: Boolean = false // 勿扰模式
)