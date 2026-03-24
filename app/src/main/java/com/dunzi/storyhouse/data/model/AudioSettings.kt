package com.dunzi.storyhouse.data.model

/**
 * 音频设置数据类
 */
data class AudioSettings(
    val backgroundMusic: Boolean = false, // 背景音乐
    val backgroundMusicType: String = "piano", // 背景音乐类型
    val backgroundMusicVolume: Int = 30, // 背景音乐音量（0-100）
    val soundEffects: Boolean = true, // 音效
    val soundEffectsVolume: Int = 70, // 音效音量（0-100）
    val equalizerEnabled: Boolean = false, // 均衡器
    val equalizerPreset: String = "normal", // 均衡器预设
    val bassBoost: Boolean = false, // 低音增强
    val virtualizer: Boolean = false, // 虚拟环绕声
    val loudnessEnhancer: Boolean = false // 响度增强
)