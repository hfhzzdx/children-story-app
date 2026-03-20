package com.dunzi.storyhouse.data.dao

import androidx.room.*
import com.dunzi.storyhouse.data.model.Story
import kotlinx.coroutines.flow.Flow

/**
 * 故事数据访问对象
 */
@Dao
interface StoryDao {
    
    // 插入操作
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(story: Story): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stories: List<Story>)
    
    // 更新操作
    @Update
    suspend fun update(story: Story)
    
    @Update
    suspend fun updateAll(stories: List<Story>)
    
    // 删除操作
    @Delete
    suspend fun delete(story: Story)
    
    @Query("DELETE FROM stories WHERE id = :id")
    suspend fun deleteById(id: Long)
    
    @Query("DELETE FROM stories")
    suspend fun deleteAll()
    
    // 查询操作 - 按ID
    @Query("SELECT * FROM stories WHERE id = :id")
    suspend fun getById(id: Long): Story?
    
    @Query("SELECT * FROM stories WHERE id = :id")
    fun getByIdFlow(id: Long): Flow<Story?>
    
    // 查询操作 - 全部
    @Query("SELECT * FROM stories ORDER BY createdAt DESC")
    suspend fun getAll(): List<Story>
    
    @Query("SELECT * FROM stories ORDER BY createdAt DESC")
    fun getAllFlow(): Flow<List<Story>>
    
    // 查询操作 - 分页
    @Query("SELECT * FROM stories ORDER BY createdAt DESC LIMIT :limit OFFSET :offset")
    suspend fun getPaged(limit: Int, offset: Int): List<Story>
    
    // 查询操作 - 按分类
    @Query("SELECT * FROM stories WHERE category = :category ORDER BY createdAt DESC")
    suspend fun getByCategory(category: String): List<Story>
    
    @Query("SELECT * FROM stories WHERE category = :category ORDER BY createdAt DESC")
    fun getByCategoryFlow(category: String): Flow<List<Story>>
    
    // 查询操作 - 按标签
    @Query("SELECT * FROM stories WHERE :tag IN (tags) ORDER BY createdAt DESC")
    suspend fun getByTag(tag: String): List<Story>
    
    // 查询操作 - 收藏
    @Query("SELECT * FROM stories WHERE isFavorite = 1 ORDER BY updatedAt DESC")
    suspend fun getFavorites(): List<Story>
    
    @Query("SELECT * FROM stories WHERE isFavorite = 1 ORDER BY updatedAt DESC")
    fun getFavoritesFlow(): Flow<List<Story>>
    
    // 查询操作 - 最近播放
    @Query("SELECT * FROM stories WHERE lastPlayedAt IS NOT NULL ORDER BY lastPlayedAt DESC LIMIT :limit")
    suspend fun getRecentlyPlayed(limit: Int = 20): List<Story>
    
    @Query("SELECT * FROM stories WHERE lastPlayedAt IS NOT NULL ORDER BY lastPlayedAt DESC LIMIT :limit")
    fun getRecentlyPlayedFlow(limit: Int = 20): Flow<List<Story>>
    
    // 查询操作 - 搜索
    @Query("SELECT * FROM stories WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' OR author LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    suspend fun search(query: String): List<Story>
    
    @Query("SELECT * FROM stories WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' OR author LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    fun searchFlow(query: String): Flow<List<Story>>
    
    // 查询操作 - 按年龄
    @Query("SELECT * FROM stories WHERE :age BETWEEN minAge AND maxAge ORDER BY createdAt DESC")
    suspend fun getByAge(age: Int): List<Story>
    
    @Query("SELECT * FROM stories WHERE :age BETWEEN minAge AND maxAge ORDER BY createdAt DESC")
    fun getByAgeFlow(age: Int): Flow<List<Story>>
    
    // 查询操作 - 统计
    @Query("SELECT COUNT(*) FROM stories")
    suspend fun getCount(): Int
    
    @Query("SELECT COUNT(*) FROM stories WHERE isFavorite = 1")
    suspend fun getFavoriteCount(): Int
    
    @Query("SELECT COUNT(*) FROM stories WHERE category = :category")
    suspend fun getCategoryCount(category: String): Int
    
    @Query("SELECT COUNT(*) FROM stories WHERE :age BETWEEN minAge AND maxAge")
    suspend fun getAgeCount(age: Int): Int
    
    // 更新操作 - 播放统计
    @Query("UPDATE stories SET playCount = playCount + 1, lastPlayedAt = :timestamp WHERE id = :id")
    suspend fun incrementPlayCount(id: Long, timestamp: Long)
    
    @Query("UPDATE stories SET favoriteCount = favoriteCount + 1, isFavorite = 1 WHERE id = :id")
    suspend fun addToFavorites(id: Long)
    
    @Query("UPDATE stories SET favoriteCount = favoriteCount - 1, isFavorite = 0 WHERE id = :id")
    suspend fun removeFromFavorites(id: Long)
    
    @Query("UPDATE stories SET lastPosition = :position, progress = :progress WHERE id = :id")
    suspend fun updatePlayProgress(id: Long, position: Long, progress: Float)
    
    @Query("UPDATE stories SET isCompleted = 1 WHERE id = :id")
    suspend fun markAsCompleted(id: Long)
    
    // 批量操作
    @Transaction
    suspend fun updateFavorites(ids: List<Long>, favorite: Boolean) {
        if (favorite) {
            ids.forEach { id ->
                addToFavorites(id)
            }
        } else {
            ids.forEach { id ->
                removeFromFavorites(id)
            }
        }
    }
    
    // 复杂查询 - 推荐故事
    @Query("""
        SELECT * FROM stories 
        WHERE id NOT IN (
            SELECT storyId FROM play_history 
            WHERE userId = :userId AND completed = 1
        )
        AND :age BETWEEN minAge AND maxAge
        AND isHidden = 0
        ORDER BY rating DESC, playCount DESC
        LIMIT :limit
    """)
    suspend fun getRecommendations(userId: String, age: Int, limit: Int = 10): List<Story>
    
    // 复杂查询 - 热门故事
    @Query("""
        SELECT * FROM stories 
        WHERE playCount > 0 
        AND isHidden = 0
        ORDER BY playCount DESC, rating DESC
        LIMIT :limit
    """)
    suspend fun getPopular(limit: Int = 10): List<Story>
    
    // 复杂查询 - 新故事
    @Query("""
        SELECT * FROM stories 
        WHERE createdAt >= :sinceTimestamp
        AND isHidden = 0
        ORDER BY createdAt DESC
        LIMIT :limit
    """)
    suspend fun getNewStories(sinceTimestamp: Long, limit: Int = 10): List<Story>
}