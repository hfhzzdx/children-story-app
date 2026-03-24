package com.dunzi.storyhouse.data.model

/**
 * 家长控制数据类
 */
data class ParentalControl(
    val enabled: Boolean = false,
    val pinCode: String = "", // PIN码
    val purchaseLock: Boolean = true, // 购买锁定
    val inAppPurchaseLimit: Int = 0, // 应用内购买限制（元）
    val dataCollectionAllowed: Boolean = false, // 数据收集
    val analyticsEnabled: Boolean = true, // 分析功能
    val socialSharingRestricted: Boolean = true, // 社交分享限制
    val chatRestricted: Boolean = true, // 聊天限制
    val friendRequestsRestricted: Boolean = true, // 好友请求限制
    val screenTimeLimit: Int = 120, // 屏幕时间限制（分钟）
    val bedtimeStart: String = "21:00", // 就寝开始时间
    val bedtimeEnd: String = "07:00", // 就寝结束时间
    val appRestrictions: Map<String, Boolean> = emptyMap() // 应用限制
)