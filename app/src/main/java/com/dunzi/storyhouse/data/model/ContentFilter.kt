package com.dunzi.storyhouse.data.model

/**
 * 内容过滤数据类
 */
data class ContentFilter(
    val filterLevel: String = "moderate", // strict/moderate/relaxed
    val blockedCategories: List<String> = emptyList(), // 屏蔽的分类
    val blockedTags: List<String> = emptyList(), // 屏蔽的标签
    val ageRestriction: Boolean = true, // 年龄限制
    val violenceFilter: Boolean = true, // 暴力内容过滤
    val scaryFilter: Boolean = true, // 恐怖内容过滤
    val inappropriateLanguageFilter: Boolean = true, // 不当语言过滤
    val educationalFocus: Boolean = false, // 教育重点
    val customFilters: Map<String, Boolean> = emptyMap() // 自定义过滤规则
)