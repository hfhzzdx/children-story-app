package com.dunzi.storyhouse;

/**
 * 故事应用主应用程序类
 */
@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/dunzi/storyhouse/StoryApplication;", "Landroid/app/Application;", "()V", "clearAppData", "", "createNotificationChannels", "getPlayHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "getStoryRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "getUserSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "initializeComponents", "initializeDatabase", "onCreate", "Companion", "app_debug"})
public final class StoryApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PLAY_NOTIFICATION_CHANNEL_ID = "story_player";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REMINDER_NOTIFICATION_CHANNEL_ID = "story_reminder";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_FIRST_LAUNCH = "first_launch";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_LAST_VERSION = "last_version";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_ANALYTICS_CONSENT = "analytics_consent";
    @org.jetbrains.annotations.NotNull()
    public static final com.dunzi.storyhouse.StoryApplication.Companion Companion = null;
    
    public StoryApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * 初始化数据库
     */
    private final void initializeDatabase() {
    }
    
    /**
     * 创建通知渠道（Android 8.0+）
     */
    private final void createNotificationChannels() {
    }
    
    /**
     * 初始化其他组件
     */
    private final void initializeComponents() {
    }
    
    /**
     * 获取故事仓库
     */
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.StoryRepository getStoryRepository() {
        return null;
    }
    
    /**
     * 获取播放历史仓库
     */
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository getPlayHistoryRepository() {
        return null;
    }
    
    /**
     * 获取用户设置仓库
     */
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.UserSettingsRepository getUserSettingsRepository() {
        return null;
    }
    
    /**
     * 清理应用数据
     */
    public final void clearAppData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/dunzi/storyhouse/StoryApplication$Companion;", "", "()V", "PLAY_NOTIFICATION_CHANNEL_ID", "", "PREF_ANALYTICS_CONSENT", "PREF_FIRST_LAUNCH", "PREF_LAST_VERSION", "REMINDER_NOTIFICATION_CHANNEL_ID", "getInstance", "Lcom/dunzi/storyhouse/StoryApplication;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * 获取应用程序实例
         */
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.StoryApplication getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}