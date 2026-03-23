package com.dunzi.storyhouse.data.model;

/**
 * 播放历史实体类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b9\b\u0087\b\u0018\u00002\u00020\u0001B\u00cf\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001b\u00a2\u0006\u0002\u0010\u001cJ\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0006H\u00c6\u0003J\t\u00109\u001a\u00020\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\t\u0010;\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\t\u0010=\u001a\u00020\u0016H\u00c6\u0003J\t\u0010>\u001a\u00020\u0016H\u00c6\u0003J\t\u0010?\u001a\u00020\u0016H\u00c6\u0003J\t\u0010@\u001a\u00020\u0006H\u00c6\u0003J\u0015\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u000bH\u00c6\u0003J\t\u0010H\u001a\u00020\rH\u00c6\u0003J\t\u0010I\u001a\u00020\rH\u00c6\u0003J\u00d5\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00062\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH\u00c6\u0001J\u0013\u0010K\u001a\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010M\u001a\u00020\u0006J\u0006\u0010N\u001a\u00020\rJ\u0006\u0010O\u001a\u00020\u0016J\u0006\u0010P\u001a\u00020\u0006J\t\u0010Q\u001a\u00020\u0016H\u00d6\u0001J\u0006\u0010R\u001a\u00020\u000bJ\t\u0010S\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010#R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0011\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0011\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010-\u00a8\u0006T"}, d2 = {"Lcom/dunzi/storyhouse/data/model/PlayHistory;", "", "id", "", "storyId", "userId", "", "startPosition", "endPosition", "duration", "completed", "", "playbackSpeed", "", "volume", "voiceType", "deviceId", "deviceName", "playedAt", "Ljava/util/Date;", "finishedAt", "interruptions", "", "skips", "rewinds", "sessionId", "metadata", "", "(JJLjava/lang/String;JJJZFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;IIILjava/lang/String;Ljava/util/Map;)V", "getCompleted", "()Z", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getDuration", "()J", "getEndPosition", "getFinishedAt", "()Ljava/util/Date;", "getId", "getInterruptions", "()I", "getMetadata", "()Ljava/util/Map;", "getPlaybackSpeed", "()F", "getPlayedAt", "getRewinds", "getSessionId", "getSkips", "getStartPosition", "getStoryId", "getUserId", "getVoiceType", "getVolume", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getDurationString", "getProgress", "getProgressPercentage", "getTimeRange", "hashCode", "isFullPlay", "toString", "app_debug"})
@androidx.room.Entity(tableName = "play_history", foreignKeys = {@androidx.room.ForeignKey(entity = com.dunzi.storyhouse.data.model.Story.class, parentColumns = {"id"}, childColumns = {"storyId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"storyId"}), @androidx.room.Index(value = {"userId"}), @androidx.room.Index(value = {"playedAt"})})
@androidx.room.TypeConverters(value = {com.dunzi.storyhouse.data.converter.DateConverter.class})
public final class PlayHistory {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    private final long storyId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    private final long startPosition = 0L;
    private final long endPosition = 0L;
    private final long duration = 0L;
    private final boolean completed = false;
    private final float playbackSpeed = 0.0F;
    private final float volume = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String voiceType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deviceId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deviceName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date playedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.Date finishedAt = null;
    private final int interruptions = 0;
    private final int skips = 0;
    private final int rewinds = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> metadata = null;
    
    public PlayHistory(long id, long storyId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, long startPosition, long endPosition, long duration, boolean completed, float playbackSpeed, float volume, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceType, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceName, @org.jetbrains.annotations.NotNull()
    java.util.Date playedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date finishedAt, int interruptions, int skips, int rewinds, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> metadata) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getStoryId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final long getStartPosition() {
        return 0L;
    }
    
    public final long getEndPosition() {
        return 0L;
    }
    
    public final long getDuration() {
        return 0L;
    }
    
    public final boolean getCompleted() {
        return false;
    }
    
    public final float getPlaybackSpeed() {
        return 0.0F;
    }
    
    public final float getVolume() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVoiceType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getPlayedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getFinishedAt() {
        return null;
    }
    
    public final int getInterruptions() {
        return 0;
    }
    
    public final int getSkips() {
        return 0;
    }
    
    public final int getRewinds() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSessionId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getMetadata() {
        return null;
    }
    
    /**
     * 获取播放时长字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDurationString() {
        return null;
    }
    
    /**
     * 获取播放进度
     */
    public final float getProgress() {
        return 0.0F;
    }
    
    /**
     * 获取播放进度百分比
     */
    public final int getProgressPercentage() {
        return 0;
    }
    
    /**
     * 检查是否是完整播放
     */
    public final boolean isFullPlay() {
        return false;
    }
    
    /**
     * 获取播放时间段
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeRange() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component14() {
        return null;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component19() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final float component8() {
        return 0.0F;
    }
    
    public final float component9() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.model.PlayHistory copy(long id, long storyId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, long startPosition, long endPosition, long duration, boolean completed, float playbackSpeed, float volume, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceType, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceName, @org.jetbrains.annotations.NotNull()
    java.util.Date playedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date finishedAt, int interruptions, int skips, int rewinds, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> metadata) {
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