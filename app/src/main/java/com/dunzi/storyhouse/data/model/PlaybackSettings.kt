package com.dunzi.storyhouse.data.model

/**
 * 播放设置数据类
 */
data class PlaybackSettings(
    val defaultVolume: Int = 80, // 默认音量（0-100）
    val defaultPlaybackSpeed: Float = 1.0f, // 默认播放速度
    val defaultVoiceType: String = "child_female", // 默认语音类型
    val backgroundPlay: Boolean = true, // 是否允许后台播放
    val autoPlayNext: Boolean = true, // 是否自动播放下一个
    val crossfadeDuration: Long = 3000, // 交叉淡入淡出时长（毫秒）
    val shuffleEnabled: Boolean = false, // 随机播放
    val repeatMode: String = "none", // 重复模式：none/one/all
    val equalizerPreset: String = "normal", // 均衡器预设
    val spatialAudio: Boolean = false, // 空间音频
    val volumeBoost: Boolean = false // 音量增强
)