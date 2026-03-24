package com.dunzi.storyhouse.data.repository

import com.dunzi.storyhouse.data.dao.PlayHistoryDao
import com.dunzi.storyhouse.data.database.StoryDatabase
import com.dunzi.storyhouse.data.model.PlayHistory
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 播放历史仓库，封装播放历史数据访问逻辑
 */
@Singleton
class PlayHistoryRepository @Inject constructor(
    private val database: StoryDatabase
) {
    private val playHistoryDao = database.playHistoryDao()
    
    // 获取用户的播放历史
    fun getUserPlayHistory(userId: String): Flow<List<PlayHistory>> = 
        playHistoryDao.getByUserIdFlow(userId)
    
    // 获取故事的播放历史
    fun getStoryPlayHistory(storyId: Long): Flow<List<PlayHistory>> = 
        playHistoryDao.getByStoryIdFlow(storyId)
    
    // 获取最近的播放历史
    fun getRecentPlayHistory(limit: Int = 50): Flow<List<PlayHistory>> = 
        playHistoryDao.getRecentFlow(limit)
    
    // 获取完成的播放历史
    fun getCompletedPlayHistory(): Flow<List<PlayHistory>> = 
        playHistoryDao.getCompletedFlow()
    
    // 添加播放记录
    suspend fun addPlayHistory(history: PlayHistory): Long = 
        playHistoryDao.insert(history)
    
    // 更新播放记录
    suspend fun updatePlayHistory(history: PlayHistory) = 
        playHistoryDao.update(history)
    
    // 删除播放记录
    suspend fun deletePlayHistory(history: PlayHistory) = 
        playHistoryDao.delete(history)
    
    // 按ID删除播放记录
    suspend fun deletePlayHistoryById(id: Long) = 
        playHistoryDao.deleteById(id)
    
    // 删除用户的所有播放记录
    suspend fun deleteUserPlayHistory(userId: String) = 
        playHistoryDao.deleteByUserId(userId)
    
    // 删除故事的所有播放记录
    suspend fun deleteStoryPlayHistory(storyId: Long) = 
        playHistoryDao.deleteByStoryId(storyId)
    
    // 清空所有播放记录
    suspend fun clearAllPlayHistory() = 
        playHistoryDao.deleteAll()
    
    // 删除指定日期之前的播放记录
    suspend fun deleteOldPlayHistory(beforeDate: Date) = 
        playHistoryDao.deleteOlderThan(beforeDate)
    
    // 获取播放记录数量
    suspend fun getPlayHistoryCount(): Int = 
        playHistoryDao.getCount()
    
    // 获取用户播放记录数量
    suspend fun getUserPlayHistoryCount(userId: String): Int = 
        playHistoryDao.getCountByUserId(userId)
    
    // 获取用户播放历史
    suspend fun getPlayHistory(userId: String, limit: Int = 50): List<PlayHistory> = 
        playHistoryDao.getByUserId(userId, limit)
    
    // 获取故事播放记录数量
    suspend fun getStoryPlayHistoryCount(storyId: Long): Int = 
        playHistoryDao.getCountByStoryId(storyId)
    
    // 获取完成播放记录数量
    suspend fun getCompletedPlayHistoryCount(): Int = 
        playHistoryDao.getCompletedCount()
    
    // 获取用户完成播放记录数量
    suspend fun getUserCompletedPlayHistoryCount(userId: String): Int = 
        playHistoryDao.getCompletedCountByUserId(userId)
    
    // 获取总播放时长
    suspend fun getTotalPlayDuration(): Long = 
        playHistoryDao.getTotalDuration() ?: 0
    
    // 获取用户总播放时长
    suspend fun getUserTotalPlayDuration(userId: String): Long = 
        playHistoryDao.getTotalDurationByUserId(userId) ?: 0
    
    // 获取故事总播放时长
    suspend fun getStoryTotalPlayDuration(storyId: Long): Long = 
        playHistoryDao.getTotalDurationByStoryId(storyId) ?: 0
    
    // 获取今日播放时长
    suspend fun getTodayPlayDuration(userId: String): Long = 
        playHistoryDao.getTodayDuration(userId) ?: 0
    
    // 获取本周播放时长
    suspend fun getThisWeekPlayDuration(userId: String): Long = 
        playHistoryDao.getThisWeekDuration(userId) ?: 0
    
    // 获取本月播放时长
    suspend fun getThisMonthPlayDuration(userId: String): Long = 
        playHistoryDao.getThisMonthDuration(userId) ?: 0
    
    // 获取最常播放的故事
    suspend fun getMostPlayedStories(userId: String, limit: Int = 10): 
        List<PlayHistoryDao.StoryPlayStats> = 
        playHistoryDao.getMostPlayedStories(userId, limit)
    
    // 获取播放时间段分布
    suspend fun getPlayTimeDistribution(userId: String): 
        List<PlayHistoryDao.PlayTimeStats> = 
        playHistoryDao.getPlayTimeDistribution(userId)
    
    // 获取设备使用统计
    suspend fun getDeviceUsage(userId: String): 
        List<PlayHistoryDao.DeviceUsageStats> = 
        playHistoryDao.getDeviceUsage(userId)
    
    // 获取最近7天内播放的天数
    suspend fun getRecentPlayDays(userId: String): Int = 
        playHistoryDao.getRecentPlayDays(userId)
    
    // 按时间段获取播放记录
    suspend fun getPlayHistoryByDateRange(startDate: Date, endDate: Date): List<PlayHistory> = 
        playHistoryDao.getByDateRange(startDate, endDate)
    
    // 获取指定日期之后的播放记录
    suspend fun getPlayHistorySinceDate(sinceDate: Date): List<PlayHistory> = 
        playHistoryDao.getSinceDate(sinceDate)
    
    // 按会话ID获取播放记录
    suspend fun getPlayHistoryBySessionId(sessionId: String): List<PlayHistory> = 
        playHistoryDao.getBySessionId(sessionId)
    
    // 创建播放会话
    suspend fun createPlaySession(
        storyId: Long,
        userId: String = "default",
        deviceId: String = "",
        deviceName: String = "",
        playbackSpeed: Float = 1.0f,
        volume: Float = 1.0f,
        voiceType: String = "default"
    ): String {
        val sessionId = "session_${System.currentTimeMillis()}_${storyId}"
        val history = PlayHistory(
            storyId = storyId,
            userId = userId,
            deviceId = deviceId,
            deviceName = deviceName,
            playbackSpeed = playbackSpeed,
            volume = volume,
            voiceType = voiceType,
            sessionId = sessionId,
            playedAt = Date()
        )
        playHistoryDao.insert(history)
        return sessionId
    }
    
    // 更新播放会话
    suspend fun updatePlaySession(
        sessionId: String,
        endPosition: Long,
        duration: Long,
        completed: Boolean = false,
        interruptions: Int = 0,
        skips: Int = 0,
        rewinds: Int = 0
    ) {
        val histories = playHistoryDao.getBySessionId(sessionId)
        histories.lastOrNull()?.let { history ->
            val updatedHistory = history.copy(
                endPosition = endPosition,
                duration = duration,
                completed = completed,
                interruptions = interruptions,
                skips = skips,
                rewinds = rewinds,
                finishedAt = if (completed) Date() else null
            )
            playHistoryDao.update(updatedHistory)
        }
    }
    
    // 获取播放统计摘要
    suspend fun getPlayStatsSummary(userId: String): PlayStatsSummary {
        val totalDuration = getUserTotalPlayDuration(userId)
        val todayDuration = getTodayPlayDuration(userId)
        val thisWeekDuration = getThisWeekPlayDuration(userId)
        val thisMonthDuration = getThisMonthPlayDuration(userId)
        val playCount = getUserPlayHistoryCount(userId)
        val completedCount = getUserCompletedPlayHistoryCount(userId)
        val recentPlayDays = getRecentPlayDays(userId)
        
        return PlayStatsSummary(
            totalDuration = totalDuration,
            todayDuration = todayDuration,
            thisWeekDuration = thisWeekDuration,
            thisMonthDuration = thisMonthDuration,
            playCount = playCount,
            completedCount = completedCount,
            recentPlayDays = recentPlayDays
        )
    }
    
    data class PlayStatsSummary(
        val totalDuration: Long,
        val todayDuration: Long,
        val thisWeekDuration: Long,
        val thisMonthDuration: Long,
        val playCount: Int,
        val completedCount: Int,
        val recentPlayDays: Int
    ) {
        fun getTotalDurationString(): String {
            val hours = totalDuration / 3600000
            val minutes = (totalDuration % 3600000) / 60000
            return if (hours > 0) {
                "${hours}小时${minutes}分钟"
            } else {
                "${minutes}分钟"
            }
        }
    }
}