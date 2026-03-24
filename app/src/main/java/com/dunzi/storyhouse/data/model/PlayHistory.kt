package com.dunzi.storyhouse.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "play_history")
data class PlayHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "storyId")
    val storyId: Long,
    @ColumnInfo(name = "playDuration")
    val playDuration: Long,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long,
)
