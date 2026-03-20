package com.dunzi.storyhouse.data.dao

import androidx.room.*
import com.dunzi.storyhouse.data.model.PlayHistory
import kotlinx.coroutines.flow.Flow
import java.util.Date

/**
 * 播放历史数据访问对象
 */
@Dao
interface PlayHistoryDao {
    
    // 插入操作
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(history: PlayHistory): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(histories: List<PlayHistory>)
    
    // 更新操作
    @Update
    suspend fun update(history: PlayHistory)
    
    // 删除操作
    @Delete
    suspend fun delete(history: PlayHistory)
    
    @Query("DELETE FROM play_history WHERE id = :id")
    suspend fun deleteById(id: Long)
    
    @Query("DELETE FROM play_history WHERE storyId = :storyId")
    suspend fun deleteByStoryId(storyId: Long)
    
    @Query("DELETE FROM play_history WHERE userId = :userId")
    suspend fun deleteByUserId(userId: String)
    
    @Query("DELETE FROM play_history")
    suspend fun deleteAll()
    
    @Query("DELETE FROM play_history WHERE playedAt < :beforeDate")
    suspend fun deleteOlderThan(beforeDate: Date)
    
    // 查询操作 - 按ID
    @Query("SELECT * FROM play_history WHERE id = :id")
    suspend fun getById(id: Long): PlayHistory?
    
    // 查询操作 - 按故事ID
    @Query("SELECT * FROM play_history WHERE storyId = :storyId ORDER BY playedAt DESC")
    suspend fun getByStoryId(storyId: Long): List<PlayHistory>
    
    @Query("SELECT * FROM play_history WHERE storyId = :storyId ORDER BY playedAt DESC")
    fun getByStoryIdFlow(storyId: Long): Flow<List<PlayHistory>>
    
    // 查询操作 - 按用户ID
    @Query("SELECT * FROM play_history WHERE userId = :userId ORDER BY playedAt DESC")
    suspend fun getByUserId(userId: String): List<PlayHistory>
    
    @Query("SELECT * FROM play_history WHERE userId = :userId ORDER BY playedAt DESC")
    fun getByUserIdFlow(userId: String): Flow<List<PlayHistory>>
    
    // 查询操作 - 按时间段
    @Query("SELECT * FROM play_history WHERE playedAt BETWEEN :startDate AND :endDate ORDER BY playedAt DESC")
    suspend fun getByDateRange(startDate: Date, endDate: Date): List<PlayHistory>
    
    @Query("SELECT * FROM play_history WHERE playedAt >= :sinceDate ORDER BY playedAt DESC")
    suspend fun getSinceDate(sinceDate: Date): List<PlayHistory>
    
    // 查询操作 - 最近播放
    @Query("SELECT * FROM play_history ORDER BY playedAt DESC LIMIT :limit")
    suspend fun getRecent(limit: Int = 50): List<PlayHistory>
    
    @Query("SELECT * FROM play_history ORDER BY playedAt DESC LIMIT :limit")
    fun getRecentFlow(limit: Int = 50): Flow<List<PlayHistory>>
    
    // 查询操作 - 完成的历史
    @Query("SELECT * FROM play_history WHERE completed = 1 ORDER BY finishedAt DESC")
    suspend fun getCompleted(): List<PlayHistory>
    
    @Query("SELECT * FROM play_history WHERE completed = 1 ORDER BY finishedAt DESC")
    fun getCompletedFlow(): Flow<List<PlayHistory>>
    
    // 查询操作 - 按会话ID
    @Query("SELECT * FROM play_history WHERE sessionId = :sessionId ORDER BY playedAt ASC")
    suspend fun getBySessionId(sessionId: String): List<PlayHistory>
    
    // 统计操作 - 计数
    @Query("SELECT COUNT(*) FROM play_history")
    suspend fun getCount(): Int
    
    @Query("SELECT COUNT(*) FROM play_history WHERE userId = :userId")
    suspend fun getCountByUserId(userId: String): Int
    
    @Query("SELECT COUNT(*) FROM play_history WHERE storyId = :storyId")
    suspend fun getCountByStoryId(storyId: Long): Int
    
    @Query("SELECT COUNT(*) FROM play_history WHERE completed = 1")
    suspend fun getCompletedCount(): Int
    
    @Query("SELECT COUNT(*) FROM play_history WHERE userId = :userId AND completed = 1")
    suspend fun getCompletedCountByUserId(userId: String): Int
    
    // 统计操作 - 时长
    @Query("SELECT SUM(duration) FROM play_history")
    suspend fun getTotalDuration(): Long?
    
    @Query("SELECT SUM(duration) FROM play_history WHERE userId = :userId")
    suspend fun getTotalDurationByUserId(userId: String): Long?
    
    @Query("SELECT SUM(duration) FROM play_history WHERE storyId = :storyId")
    suspend fun getTotalDurationByStoryId(storyId: Long): Long?
    
    @Query("SELECT SUM(duration) FROM play_history WHERE playedAt BETWEEN :startDate AND :endDate")
    suspend fun getDurationByDateRange(startDate: Date, endDate: Date): Long?
    
    // 统计操作 - 今日播放
    @Query("SELECT SUM(duration) FROM play_history WHERE userId = :userId AND date(playedAt/1000, 'unixepoch') = date('now')")
    suspend fun getTodayDuration(userId: String): Long?
    
    // 统计操作 - 本周播放
    @Query("SELECT SUM(duration) FROM play_history WHERE userId = :userId AND strftime('%Y-%W', playedAt/1000, 'unixepoch') = strftime('%Y-%W', 'now')")
    suspend fun getThisWeekDuration(userId: String): Long?
    
    // 统计操作 - 本月播放
    @Query("SELECT SUM(duration) FROM play_history WHERE userId = :userId AND strftime('%Y-%m', playedAt/1000, 'unixepoch') = strftime('%Y-%m', 'now')")
    suspend fun getThisMonthDuration(userId: String): Long?
    
    // 聚合查询 - 最常播放的故事
    @Query("""
        SELECT storyId, COUNT(*) as playCount, SUM(duration) as totalDuration
        FROM play_history 
        WHERE userId = :userId
        GROUP BY storyId 
        ORDER BY playCount DESC 
        LIMIT :limit
    """)
    suspend fun getMostPlayedStories(userId: String, limit: Int = 10): List<StoryPlayStats>
    
    // 聚合查询 - 播放时间段分布
    @Query("""
        SELECT 
            strftime('%H', playedAt/1000, 'unixepoch') as hour,
            COUNT(*) as playCount,
            SUM(duration) as totalDuration
        FROM play_history 
        WHERE userId = :userId
        GROUP BY hour
        ORDER BY hour
    """)
    suspend fun getPlayTimeDistribution(userId: String): List<PlayTimeStats>
    
    // 聚合查询 - 设备使用统计
    @Query("""
        SELECT 
            deviceName,
            COUNT(*) as playCount,
            SUM(duration) as totalDuration
        FROM play_history 
        WHERE userId = :userId AND deviceName != ''
        GROUP BY deviceName
        ORDER BY totalDuration DESC
    """)
    suspend fun getDeviceUsage(userId: String): List<DeviceUsageStats>
    
    // 复杂查询 - 连续播放天数
    @Query("""
        WITH dates AS (
            SELECT DISTINCT date(playedAt/1000, 'unixepoch') as playDate
            FROM play_history 
            WHERE userId = :userId
            ORDER BY playDate DESC
        ),
        grouped AS (
            SELECT 
                playDate,
                julianday(playDate) - julianday(LAG(playDate) OVER (ORDER BY playDate DESC)) as dayDiff
            FROM dates
        )
        SELECT MAX(consecutiveDays) as maxConsecutiveDays
        FROM (
            SELECT 
                COUNT(*) as consecutiveDays
            FROM grouped
            WHERE dayDiff = 1 OR dayDiff IS NULL
            GROUP BY (julianday(playDate) - ROW_NUMBER() OVER (ORDER BY playDate))
        )
    """)
    suspend fun getMaxConsecutiveDays(userId: String): Int?
    
    // 数据模型用于聚合查询结果
    data class StoryPlayStats(
        val storyId: Long,
        val playCount: Int,
        val totalDuration: Long
    )
    
    data class PlayTimeStats(
        val hour: String,
        val playCount: Int,
        val totalDuration: Long
    )
    
    data class DeviceUsageStats(
        val deviceName: String,
        val playCount: Int,
        val totalDuration: Long
    )
}