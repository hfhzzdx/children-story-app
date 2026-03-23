package com.dunzi.storyhouse.data.repository;

/**
 * 播放历史仓库，封装播放历史数据访问逻辑
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001TB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJR\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010#\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\'0&J\u000e\u0010(\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010,\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J&\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\'2\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010/\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u00100J$\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\'2\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u00104J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\'2\u0006\u00106\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u000e\u00107\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\'2\u0006\u00109\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010:\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\'2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u001c\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\'0&2\b\b\u0002\u0010/\u001a\u00020)J\u001a\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\'0&2\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010@\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010A\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010B\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010C\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010D\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u000e\u0010E\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010F\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u001a\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\'0&2\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010H\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010I\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010J\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJN\u0010K\u001a\u00020\r2\u0006\u00106\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020)2\b\b\u0002\u0010Q\u001a\u00020)2\b\b\u0002\u0010R\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010SR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "", "database", "Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "(Lcom/dunzi/storyhouse/data/database/StoryDatabase;)V", "playHistoryDao", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao;", "addPlayHistory", "", "history", "Lcom/dunzi/storyhouse/data/model/PlayHistory;", "(Lcom/dunzi/storyhouse/data/model/PlayHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAllPlayHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaySession", "", "storyId", "userId", "deviceId", "deviceName", "playbackSpeed", "", "volume", "voiceType", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldPlayHistory", "beforeDate", "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlayHistory", "deletePlayHistoryById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteStoryPlayHistory", "deleteUserPlayHistory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompletedPlayHistory", "Lkotlinx/coroutines/flow/Flow;", "", "getCompletedPlayHistoryCount", "", "getDeviceUsage", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$DeviceUsageStats;", "getMaxConsecutiveDays", "getMostPlayedStories", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$StoryPlayStats;", "limit", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayHistoryByDateRange", "startDate", "endDate", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayHistoryBySessionId", "sessionId", "getPlayHistoryCount", "getPlayHistorySinceDate", "sinceDate", "getPlayStatsSummary", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "getPlayTimeDistribution", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao$PlayTimeStats;", "getRecentPlayHistory", "getStoryPlayHistory", "getStoryPlayHistoryCount", "getStoryTotalPlayDuration", "getThisMonthPlayDuration", "getThisWeekPlayDuration", "getTodayPlayDuration", "getTotalPlayDuration", "getUserCompletedPlayHistoryCount", "getUserPlayHistory", "getUserPlayHistoryCount", "getUserTotalPlayDuration", "updatePlayHistory", "updatePlaySession", "endPosition", "duration", "completed", "", "interruptions", "skips", "rewinds", "(Ljava/lang/String;JJZIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlayStatsSummary", "app_debug"})
public final class PlayHistoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.database.StoryDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.dao.PlayHistoryDao playHistoryDao = null;
    
    @javax.inject.Inject()
    public PlayHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.database.StoryDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getUserPlayHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getStoryPlayHistory(long storyId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getRecentPlayHistory(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getCompletedPlayHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addPlayHistory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlayHistory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deletePlayHistory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deletePlayHistoryById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteUserPlayHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteStoryPlayHistory(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAllPlayHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteOldPlayHistory(@org.jetbrains.annotations.NotNull()
    java.util.Date beforeDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayHistoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserPlayHistoryCount(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStoryPlayHistoryCount(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCompletedPlayHistoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserCompletedPlayHistoryCount(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTotalPlayDuration(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserTotalPlayDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStoryTotalPlayDuration(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTodayPlayDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getThisWeekPlayDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getThisMonthPlayDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMostPlayedStories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.dao.PlayHistoryDao.StoryPlayStats>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayTimeDistribution(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.dao.PlayHistoryDao.PlayTimeStats>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDeviceUsage(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.dao.PlayHistoryDao.DeviceUsageStats>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMaxConsecutiveDays(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayHistoryByDateRange(@org.jetbrains.annotations.NotNull()
    java.util.Date startDate, @org.jetbrains.annotations.NotNull()
    java.util.Date endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayHistorySinceDate(@org.jetbrains.annotations.NotNull()
    java.util.Date sinceDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayHistoryBySessionId(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createPlaySession(long storyId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceName, float playbackSpeed, float volume, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlaySession(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, long endPosition, long duration, boolean completed, int interruptions, int skips, int rewinds, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlayStatsSummary(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010 \u001a\u00020!J\t\u0010\"\u001a\u00020\bH\u00d6\u0001J\t\u0010#\u001a\u00020!H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006$"}, d2 = {"Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "", "totalDuration", "", "todayDuration", "thisWeekDuration", "thisMonthDuration", "playCount", "", "completedCount", "consecutiveDays", "(JJJJIII)V", "getCompletedCount", "()I", "getConsecutiveDays", "getPlayCount", "getThisMonthDuration", "()J", "getThisWeekDuration", "getTodayDuration", "getTotalDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getTotalDurationString", "", "hashCode", "toString", "app_debug"})
    public static final class PlayStatsSummary {
        private final long totalDuration = 0L;
        private final long todayDuration = 0L;
        private final long thisWeekDuration = 0L;
        private final long thisMonthDuration = 0L;
        private final int playCount = 0;
        private final int completedCount = 0;
        private final int consecutiveDays = 0;
        
        public PlayStatsSummary(long totalDuration, long todayDuration, long thisWeekDuration, long thisMonthDuration, int playCount, int completedCount, int consecutiveDays) {
            super();
        }
        
        public final long getTotalDuration() {
            return 0L;
        }
        
        public final long getTodayDuration() {
            return 0L;
        }
        
        public final long getThisWeekDuration() {
            return 0L;
        }
        
        public final long getThisMonthDuration() {
            return 0L;
        }
        
        public final int getPlayCount() {
            return 0;
        }
        
        public final int getCompletedCount() {
            return 0;
        }
        
        public final int getConsecutiveDays() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTotalDurationString() {
            return null;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final long component4() {
            return 0L;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final int component6() {
            return 0;
        }
        
        public final int component7() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary copy(long totalDuration, long todayDuration, long thisWeekDuration, long thisMonthDuration, int playCount, int completedCount, int consecutiveDays) {
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