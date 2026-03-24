package com.dunzi.storyhouse.data.model

/**
 * 存储设置数据类
 */
data class StorageSettings(
    val autoDownloadFavorites: Boolean = false, // 自动下载收藏
    val storageLocation: String = "internal", // internal/external
    val cacheSizeLimit: Long = 1073741824, // 1GB（字节）
    val autoClearCache: Boolean = true, // 自动清理缓存
    val wifiOnlyDownload: Boolean = true, // 仅WiFi下载
    val dataSaverMode: Boolean = false, // 省流量模式
    val downloadQuality: String = "high", // 下载质量：low/medium/high
    val parallelDownloads: Int = 3, // 并行下载数
    val resumeBrokenDownloads: Boolean = true, // 恢复中断的下载
    val deleteAfterPlay: Boolean = false // 播放后删除
)