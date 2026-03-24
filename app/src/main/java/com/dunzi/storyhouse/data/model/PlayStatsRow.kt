package com.dunzi.storyhouse.data.model

import androidx.room.ColumnInfo

// 用于 Room 查询映射播放统计（列名需与 SQL 中别名一致）
data class PlayStatsRow(
    @ColumnInfo(name = "totalTime") val totalTime: Long,
    @ColumnInfo(name = "totalCount") val totalCount: Long,
)
