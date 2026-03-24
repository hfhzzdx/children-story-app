package com.dunzi.storyhouse.data.model

/**
 * 显示设置数据类
 */
data class DisplaySettings(
    val theme: String = "light", // light/dark/eye_protection
    val fontSize: String = "medium", // small/medium/large/xlarge
    val eyeProtectionMode: Boolean = false, // 护眼模式
    val animationEnabled: Boolean = true, // 动画效果
    val brightnessAuto: Boolean = true, // 自动亮度
    val brightnessLevel: Int = 50, // 亮度级别（0-100）
    val contrastLevel: Int = 50, // 对比度级别（0-100）
    val colorBlindMode: Boolean = false, // 色盲模式
    val reduceMotion: Boolean = false // 减少动画
)