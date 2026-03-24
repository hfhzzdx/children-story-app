package com.dunzi.storyhouse.data.model

/**
 * 儿童信息数据类
 */
data class ChildInfo(
    val name: String = "",
    val age: Int = 3,
    val gender: String = "", // boy/girl
    val avatar: String = "", // 头像路径
    val interests: List<String> = emptyList(), // 兴趣标签
    val learningLevel: String = "beginner", // 学习水平：beginner/intermediate/advanced
    val favoriteCategories: List<String> = emptyList(), // 喜欢的分类
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)