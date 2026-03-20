package com.dunzi.storyhouse.data.repository

import com.dunzi.storyhouse.data.database.StoryDatabase
import com.dunzi.storyhouse.data.model.Story
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 故事仓库，封装故事数据访问逻辑
 */
@Singleton
class StoryRepository @Inject constructor(
    private val database: StoryDatabase
) {
    private val storyDao = database.storyDao()
    
    // 获取所有故事
    fun getAllStories(): Flow<List<Story>> = storyDao.getAllFlow()
    
    // 获取故事详情
    fun getStoryById(id: Long): Flow<Story?> = storyDao.getByIdFlow(id)
    
    // 获取收藏的故事
    fun getFavoriteStories(): Flow<List<Story>> = storyDao.getFavoritesFlow()
    
    // 获取最近播放的故事
    fun getRecentlyPlayedStories(limit: Int = 20): Flow<List<Story>> = 
        storyDao.getRecentlyPlayedFlow(limit)
    
    // 按分类获取故事
    fun getStoriesByCategory(category: String): Flow<List<Story>> = 
        storyDao.getByCategoryFlow(category)
    
    // 按年龄获取故事
    fun getStoriesByAge(age: Int): Flow<List<Story>> = 
        storyDao.getByAgeFlow(age)
    
    // 搜索故事
    fun searchStories(query: String): Flow<List<Story>> = 
        storyDao.searchFlow(query)
    
    // 获取推荐故事
    suspend fun getRecommendations(userId: String, age: Int, limit: Int = 10): List<Story> =
        storyDao.getRecommendations(userId, age, limit)
    
    // 获取热门故事
    suspend fun getPopularStories(limit: Int = 10): List<Story> =
        storyDao.getPopular(limit)
    
    // 获取新故事
    suspend fun getNewStories(sinceTimestamp: Long, limit: Int = 10): List<Story> =
        storyDao.getNewStories(sinceTimestamp, limit)
    
    // 添加故事
    suspend fun addStory(story: Story): Long = storyDao.insert(story)
    
    // 更新故事
    suspend fun updateStory(story: Story) = storyDao.update(story)
    
    // 删除故事
    suspend fun deleteStory(story: Story) = storyDao.delete(story)
    
    // 删除故事（按ID）
    suspend fun deleteStoryById(id: Long) = storyDao.deleteById(id)
    
    // 批量添加故事
    suspend fun addStories(stories: List<Story>) = storyDao.insertAll(stories)
    
    // 更新收藏状态
    suspend fun toggleFavorite(storyId: Long, isFavorite: Boolean) {
        if (isFavorite) {
            storyDao.addToFavorites(storyId)
        } else {
            storyDao.removeFromFavorites(storyId)
        }
    }
    
    // 更新播放进度
    suspend fun updatePlayProgress(storyId: Long, position: Long, progress: Float) =
        storyDao.updatePlayProgress(storyId, position, progress)
    
    // 增加播放次数
    suspend fun incrementPlayCount(storyId: Long, timestamp: Long) =
        storyDao.incrementPlayCount(storyId, timestamp)
    
    // 标记为已完成
    suspend fun markAsCompleted(storyId: Long) = storyDao.markAsCompleted(storyId)
    
    // 获取故事数量
    suspend fun getStoryCount(): Int = storyDao.getCount()
    
    // 获取收藏数量
    suspend fun getFavoriteCount(): Int = storyDao.getFavoriteCount()
    
    // 按分类获取数量
    suspend fun getCategoryCount(category: String): Int = storyDao.getCategoryCount(category)
    
    // 按年龄获取数量
    suspend fun getAgeCount(age: Int): Int = storyDao.getAgeCount(age)
    
    // 批量更新收藏状态
    suspend fun updateFavorites(ids: List<Long>, favorite: Boolean) =
        storyDao.updateFavorites(ids, favorite)
}