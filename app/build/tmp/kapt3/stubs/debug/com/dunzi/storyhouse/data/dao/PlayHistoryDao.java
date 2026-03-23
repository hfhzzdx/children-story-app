package com.dunzi.storyhouse.data.dao;

/**
 * 播放历史数据访问对象
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bg\u0018\u00002\u00020\u0001:\u0003FGHJ\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u001e\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180!2\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180!2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010%\u001a\u00020&H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\'\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180!H\'J\u000e\u0010)\u001a\u00020&H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010*\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010+\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J \u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001bJ&\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00182\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00101\u001a\u00020&H\u00a7@\u00a2\u0006\u0002\u00102J\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\b\b\u0002\u00101\u001a\u00020&H\u00a7@\u00a2\u0006\u0002\u00106J\u001e\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180!2\b\b\u0002\u00101\u001a\u00020&H\'J\u0016\u00108\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010:\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010<\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010=\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bH\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010?\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010@\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010A\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010B\u001a\u00020\u00032\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u00a7@\u00a2\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006I"}, d2 = {"Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao;", "", "delete", "", "history", "Lcom/dunzi/storyhouse/data/model/PlayHistory;", "(Lcom/dunzi/storyhouse/data/model/PlayHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByStoryId", "storyId", "deleteByUserId", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOlderThan", "beforeDate", "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByDateRange", "", "startDate", "endDate", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "getBySessionId", "sessionId", "getByStoryId", "getByStoryIdFlow", "Lkotlinx/coroutines/flow/Flow;", "getByUserId", "getByUserIdFlow", "getCompleted", "getCompletedCount", "", "getCompletedCountByUserId", "getCompletedFlow", "getCount", "getCountByStoryId", "getCountByUserId", "getDeviceUsage", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$DeviceUsageStats;", "getDurationByDateRange", "getMostPlayedStories", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$StoryPlayStats;", "limit", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayTimeDistribution", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$PlayTimeStats;", "getRecent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentFlow", "getRecentPlayDays", "getSinceDate", "sinceDate", "getThisMonthDuration", "getThisWeekDuration", "getTodayDuration", "getTotalDuration", "getTotalDurationByStoryId", "getTotalDurationByUserId", "insert", "insertAll", "histories", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "DeviceUsageStats", "PlayTimeStats", "StoryPlayStats", "app_debug"})
@androidx.room.Dao()
public abstract interface PlayHistoryDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dunzi.storyhouse.data.model.PlayHistory> histories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM play_history WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM play_history WHERE storyId = :storyId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByStoryId(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM play_history WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM play_history")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM play_history WHERE playedAt < :beforeDate")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOlderThan(@org.jetbrains.annotations.NotNull()
    java.util.Date beforeDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.model.PlayHistory> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE storyId = :storyId ORDER BY playedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByStoryId(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE storyId = :storyId ORDER BY playedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getByStoryIdFlow(long storyId);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE userId = :userId ORDER BY playedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE userId = :userId ORDER BY playedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getByUserIdFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE playedAt BETWEEN :startDate AND :endDate ORDER BY playedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE playedAt >= :sinceDate ORDER BY playedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSinceDate(@org.jetbrains.annotations.NotNull()
    java.util.Date sinceDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history ORDER BY playedAt DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecent(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history ORDER BY playedAt DESC LIMIT :limit")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getRecentFlow(int limit);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE completed = 1 ORDER BY finishedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompleted(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE completed = 1 ORDER BY finishedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getCompletedFlow();
    
    @androidx.room.Query(value = "SELECT * FROM play_history WHERE sessionId = :sessionId ORDER BY playedAt ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBySessionId(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM play_history")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM play_history WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCountByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM play_history WHERE storyId = :storyId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCountByStoryId(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM play_history WHERE completed = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompletedCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM play_history WHERE userId = :userId AND completed = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompletedCountByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalDuration(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalDurationByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history WHERE storyId = :storyId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalDurationByStoryId(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history WHERE playedAt BETWEEN :startDate AND :endDate")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDurationByDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history WHERE userId = :userId AND date(playedAt/1000, \'unixepoch\') = date(\'now\')")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTodayDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history WHERE userId = :userId AND strftime(\'%Y-%W\', playedAt/1000, \'unixepoch\') = strftime(\'%Y-%W\', \'now\')")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getThisWeekDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM play_history WHERE userId = :userId AND strftime(\'%Y-%m\', playedAt/1000, \'unixepoch\') = strftime(\'%Y-%m\', \'now\')")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getThisMonthDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "\n        SELECT storyId, COUNT(*) as playCount, SUM(duration) as totalDuration\n        FROM play_history \n        WHERE userId = :userId\n        GROUP BY storyId \n        ORDER BY playCount DESC \n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMostPlayedStories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.dao.PlayHistoryDao.StoryPlayStats>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT \n            strftime(\'%H\', playedAt/1000, \'unixepoch\') as hour,\n            COUNT(*) as playCount,\n            SUM(duration) as totalDuration\n        FROM play_history \n        WHERE userId = :userId\n        GROUP BY hour\n        ORDER BY hour\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayTimeDistribution(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.dao.PlayHistoryDao.PlayTimeStats>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT \n            deviceName,\n            COUNT(*) as playCount,\n            SUM(duration) as totalDuration\n        FROM play_history \n        WHERE userId = :userId AND deviceName != \'\'\n        GROUP BY deviceName\n        ORDER BY totalDuration DESC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceUsage(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.dao.PlayHistoryDao.DeviceUsageStats>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT COUNT(DISTINCT date(playedAt/1000, \'unixepoch\')) as recentPlayDays\n        FROM play_history \n        WHERE userId = :userId \n        AND playedAt >= (strftime(\'%s\', \'now\', \'-7 days\') * 1000)\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecentPlayDays(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * 播放历史数据访问对象
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$DeviceUsageStats;", "", "deviceName", "", "playCount", "", "totalDuration", "", "(Ljava/lang/String;IJ)V", "getDeviceName", "()Ljava/lang/String;", "getPlayCount", "()I", "getTotalDuration", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class DeviceUsageStats {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String deviceName = null;
        private final int playCount = 0;
        private final long totalDuration = 0L;
        
        public DeviceUsageStats(@org.jetbrains.annotations.NotNull()
        java.lang.String deviceName, int playCount, long totalDuration) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDeviceName() {
            return null;
        }
        
        public final int getPlayCount() {
            return 0;
        }
        
        public final long getTotalDuration() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final long component3() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.dao.PlayHistoryDao.DeviceUsageStats copy(@org.jetbrains.annotations.NotNull()
        java.lang.String deviceName, int playCount, long totalDuration) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$PlayTimeStats;", "", "hour", "", "playCount", "", "totalDuration", "", "(Ljava/lang/String;IJ)V", "getHour", "()Ljava/lang/String;", "getPlayCount", "()I", "getTotalDuration", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class PlayTimeStats {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String hour = null;
        private final int playCount = 0;
        private final long totalDuration = 0L;
        
        public PlayTimeStats(@org.jetbrains.annotations.NotNull()
        java.lang.String hour, int playCount, long totalDuration) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getHour() {
            return null;
        }
        
        public final int getPlayCount() {
            return 0;
        }
        
        public final long getTotalDuration() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final long component3() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.dao.PlayHistoryDao.PlayTimeStats copy(@org.jetbrains.annotations.NotNull()
        java.lang.String hour, int playCount, long totalDuration) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$StoryPlayStats;", "", "storyId", "", "playCount", "", "totalDuration", "(JIJ)V", "getPlayCount", "()I", "getStoryId", "()J", "getTotalDuration", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class StoryPlayStats {
        private final long storyId = 0L;
        private final int playCount = 0;
        private final long totalDuration = 0L;
        
        public StoryPlayStats(long storyId, int playCount, long totalDuration) {
            super();
        }
        
        public final long getStoryId() {
            return 0L;
        }
        
        public final int getPlayCount() {
            return 0;
        }
        
        public final long getTotalDuration() {
            return 0L;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final long component3() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.dao.PlayHistoryDao.StoryPlayStats copy(long storyId, int playCount, long totalDuration) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}