package com.dunzi.storyhouse.service;

/**
 * 音频播放服务
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0014\u0010.\u001a\u0004\u0018\u00010/2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\u001fH\u0016J\b\u00102\u001a\u00020\u001fH\u0002J\"\u00103\u001a\u0002042\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0016J\b\u00107\u001a\u00020\u001fH\u0002J(\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020\u001fH\u0002J\b\u0010<\u001a\u00020\u001fH\u0002J\u0010\u0010=\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u0004H\u0002J\b\u0010>\u001a\u00020\u001fH\u0002J\u0010\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u0004H\u0002J\b\u0010C\u001a\u00020\u001fH\u0002J\b\u0010D\u001a\u00020\u001fH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\b\u0010F\u001a\u00020\u001fH\u0002J\b\u0010G\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006I"}, d2 = {"Lcom/dunzi/storyhouse/service/AudioPlaybackService;", "Landroid/app/Service;", "()V", "PROGRESS_UPDATE_INTERVAL", "", "currentStoryId", "isPlaying", "", "playHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "getPlayHistoryRepository", "()Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "setPlayHistoryRepository", "(Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;)V", "playbackProgressHandler", "Landroid/os/Handler;", "playbackProgressRunnable", "Ljava/lang/Runnable;", "player", "Lcom/google/android/exoplayer2/ExoPlayer;", "sleepTimerDuration", "sleepTimerHandler", "sleepTimerRunnable", "sleepTimerStartTime", "storyRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "getStoryRepository", "()Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "setStoryRepository", "(Lcom/dunzi/storyhouse/data/repository/StoryRepository;)V", "cancelSleepTimer", "", "createNotification", "Landroid/app/Notification;", "title", "", "author", "createNotificationChannel", "getPendingAction", "Landroid/app/PendingIntent;", "action", "getRemainingSleepTimerTime", "handleIntent", "intent", "Landroid/content/Intent;", "initializePlayer", "onBind", "Landroid/os/IBinder;", "onCreate", "onDestroy", "onPlaybackCompleted", "onStartCommand", "", "flags", "startId", "pauseAudio", "playAudio", "storyId", "audioUrl", "playNext", "playPrevious", "recordPlayHistory", "releasePlayer", "seekTo", "position", "setSleepTimer", "duration", "startProgressUpdates", "stopAudio", "stopProgressUpdates", "updateNotification", "updatePlaybackProgress", "Companion", "app_debug"})
public final class AudioPlaybackService extends android.app.Service {
    @javax.inject.Inject()
    public com.dunzi.storyhouse.data.repository.StoryRepository storyRepository;
    @javax.inject.Inject()
    public com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository;
    private com.google.android.exoplayer2.ExoPlayer player;
    private long currentStoryId = -1L;
    private boolean isPlaying = false;
    @org.jetbrains.annotations.Nullable()
    private android.os.Handler playbackProgressHandler;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Runnable playbackProgressRunnable;
    private final long PROGRESS_UPDATE_INTERVAL = 1000L;
    @org.jetbrains.annotations.Nullable()
    private android.os.Handler sleepTimerHandler;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Runnable sleepTimerRunnable;
    private long sleepTimerDuration = 0L;
    private long sleepTimerStartTime = 0L;
    private static final int NOTIFICATION_ID = 1001;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CHANNEL_ID = "story_player";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_PLAY = "com.dunzi.storyhouse.action.PLAY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_PAUSE = "com.dunzi.storyhouse.action.PAUSE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_STOP = "com.dunzi.storyhouse.action.STOP";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_NEXT = "com.dunzi.storyhouse.action.NEXT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_PREVIOUS = "com.dunzi.storyhouse.action.PREVIOUS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SEEK_TO = "com.dunzi.storyhouse.action.SEEK_TO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SET_SLEEP_TIMER = "com.dunzi.storyhouse.action.SET_SLEEP_TIMER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CANCEL_SLEEP_TIMER = "com.dunzi.storyhouse.action.CANCEL_SLEEP_TIMER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_STORY_ID = "story_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_POSITION = "position";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_SLEEP_TIMER_DURATION = "sleep_timer_duration";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_AUDIO_URL = "audio_url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_STORY_TITLE = "story_title";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_STORY_AUTHOR = "story_author";
    @org.jetbrains.annotations.NotNull()
    public static final com.dunzi.storyhouse.service.AudioPlaybackService.Companion Companion = null;
    
    public AudioPlaybackService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.StoryRepository getStoryRepository() {
        return null;
    }
    
    public final void setStoryRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.StoryRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository getPlayHistoryRepository() {
        return null;
    }
    
    public final void setPlayHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.PlayHistoryRepository p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    /**
     * 初始化播放器
     */
    private final void initializePlayer() {
    }
    
    /**
     * 处理意图
     */
    private final void handleIntent(android.content.Intent intent) {
    }
    
    /**
     * 播放音频
     */
    private final void playAudio(long storyId, java.lang.String audioUrl, java.lang.String title, java.lang.String author) {
    }
    
    /**
     * 暂停音频
     */
    private final void pauseAudio() {
    }
    
    /**
     * 停止音频
     */
    private final void stopAudio() {
    }
    
    /**
     * 播放下一首
     */
    private final void playNext() {
    }
    
    /**
     * 播放上一首
     */
    private final void playPrevious() {
    }
    
    /**
     * 跳转到指定位置
     */
    private final void seekTo(long position) {
    }
    
    /**
     * 设置睡眠定时器
     */
    private final void setSleepTimer(long duration) {
    }
    
    /**
     * 取消睡眠定时器
     */
    private final void cancelSleepTimer() {
    }
    
    /**
     * 获取剩余睡眠定时器时间（秒）
     */
    private final long getRemainingSleepTimerTime() {
        return 0L;
    }
    
    /**
     * 播放完成处理
     */
    private final void onPlaybackCompleted() {
    }
    
    /**
     * 记录播放历史
     */
    private final void recordPlayHistory(long storyId) {
    }
    
    /**
     * 创建通知渠道
     */
    private final void createNotificationChannel() {
    }
    
    /**
     * 创建通知
     */
    private final android.app.Notification createNotification(java.lang.String title, java.lang.String author, boolean isPlaying) {
        return null;
    }
    
    /**
     * 更新通知
     */
    private final void updateNotification() {
    }
    
    /**
     * 获取待处理动作
     */
    private final android.app.PendingIntent getPendingAction(java.lang.String action) {
        return null;
    }
    
    /**
     * 开始更新播放进度
     */
    private final void startProgressUpdates() {
    }
    
    /**
     * 停止更新播放进度
     */
    private final void stopProgressUpdates() {
    }
    
    /**
     * 更新播放进度到数据库
     */
    private final void updatePlaybackProgress() {
    }
    
    /**
     * 释放播放器资源
     */
    private final void releasePlayer() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001bJ0\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/dunzi/storyhouse/service/AudioPlaybackService$Companion;", "", "()V", "ACTION_CANCEL_SLEEP_TIMER", "", "ACTION_NEXT", "ACTION_PAUSE", "ACTION_PLAY", "ACTION_PREVIOUS", "ACTION_SEEK_TO", "ACTION_SET_SLEEP_TIMER", "ACTION_STOP", "CHANNEL_ID", "EXTRA_AUDIO_URL", "EXTRA_POSITION", "EXTRA_SLEEP_TIMER_DURATION", "EXTRA_STORY_AUTHOR", "EXTRA_STORY_ID", "EXTRA_STORY_TITLE", "NOTIFICATION_ID", "", "cancelSleepTimer", "", "context", "Landroid/content/Context;", "seekTo", "position", "", "setSleepTimer", "duration", "startService", "storyId", "audioUrl", "title", "author", "stopService", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * 启动播放服务
         */
        public final void startService(@org.jetbrains.annotations.NotNull()
        android.content.Context context, long storyId, @org.jetbrains.annotations.NotNull()
        java.lang.String audioUrl, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String author) {
        }
        
        /**
         * 停止播放服务
         */
        public final void stopService(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        /**
         * 跳转到指定位置
         */
        public final void seekTo(@org.jetbrains.annotations.NotNull()
        android.content.Context context, long position) {
        }
        
        /**
         * 设置睡眠定时器
         */
        public final void setSleepTimer(@org.jetbrains.annotations.NotNull()
        android.content.Context context, long duration) {
        }
        
        /**
         * 取消睡眠定时器
         */
        public final void cancelSleepTimer(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}