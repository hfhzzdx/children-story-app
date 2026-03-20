package com.dunzi.storyhouse.di

import android.content.Context
import com.dunzi.storyhouse.data.database.StoryDatabase
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository
import com.dunzi.storyhouse.data.repository.StoryRepository
import com.dunzi.storyhouse.data.repository.UserSettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 应用模块 - 提供全局依赖
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    /**
     * 提供应用上下文
     */
    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }
    
    /**
     * 提供数据库实例
     */
    @Provides
    @Singleton
    fun provideStoryDatabase(@ApplicationContext context: Context): StoryDatabase {
        return StoryDatabase.getInstance(context)
    }
    
    /**
     * 提供故事仓库
     */
    @Provides
    @Singleton
    fun provideStoryRepository(database: StoryDatabase): StoryRepository {
        return StoryRepository(database)
    }
    
    /**
     * 提供播放历史仓库
     */
    @Provides
    @Singleton
    fun providePlayHistoryRepository(database: StoryDatabase): PlayHistoryRepository {
        return PlayHistoryRepository(database)
    }
    
    /**
     * 提供用户设置仓库
     */
    @Provides
    @Singleton
    fun provideUserSettingsRepository(database: StoryDatabase): UserSettingsRepository {
        return UserSettingsRepository(database)
    }
}