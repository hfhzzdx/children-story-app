package com.dunzi.storyhouse.di;

/**
 * 应用模块 - 提供全局依赖
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/dunzi/storyhouse/di/AppModule;", "", "()V", "provideApplicationContext", "Landroid/content/Context;", "context", "providePlayHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "database", "Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "provideStoryDatabase", "provideStoryRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "provideUserSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.dunzi.storyhouse.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    /**
     * 提供应用上下文
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context provideApplicationContext(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * 提供数据库实例
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.database.StoryDatabase provideStoryDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * 提供故事仓库
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.StoryRepository provideStoryRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.database.StoryDatabase database) {
        return null;
    }
    
    /**
     * 提供播放历史仓库
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository providePlayHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.database.StoryDatabase database) {
        return null;
    }
    
    /**
     * 提供用户设置仓库
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.repository.UserSettingsRepository provideUserSettingsRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.database.StoryDatabase database) {
        return null;
    }
}