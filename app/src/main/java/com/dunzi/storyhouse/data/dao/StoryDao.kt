package com.dunzi.storyhouse.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dunzi.storyhouse.data.model.Story

@Dao
interface StoryDao {
    @Query("SELECT * FROM stories ORDER BY id DESC LIMIT 20")
    suspend fun getRecommendations(): List<Story>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stories: List<Story>)

    @Query("DELETE FROM stories")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM stories")
    suspend fun getCount(): Int
}
