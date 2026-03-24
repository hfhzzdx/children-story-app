package com.dunzi.storyhouse.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.dunzi.storyhouse.data.model.Story

@Dao
interface StoryDao {
    @Query("SELECT * FROM story ORDER BY id DESC LIMIT 20")
    suspend fun getRecommendations(): List<Story>
}
