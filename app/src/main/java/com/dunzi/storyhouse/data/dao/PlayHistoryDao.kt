package com.dunzi.storyhouse.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dunzi.storyhouse.data.model.PlayHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PlayHistory)

    @Query("DELETE FROM play_history")
    suspend fun clear()

    // Return pair: totalPlayTime, totalPlayCount
    @Query(
        "SELECT COALESCE(SUM(playDuration),0) as totalTime, COALESCE(COUNT(*),0) as totalCount FROM play_history WHERE storyId = :storyId"
    )
    fun observeStats(storyId: Long): Flow<Pair<Long, Long>>
}
