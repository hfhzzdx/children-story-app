package com.dunzi.storyhouse.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dunzi.storyhouse.data.MockDataGenerator
import com.dunzi.storyhouse.data.converter.DateConverter
import com.dunzi.storyhouse.data.converter.ListConverter
import com.dunzi.storyhouse.data.converter.MapConverter
import com.dunzi.storyhouse.data.dao.PlayHistoryDao
import com.dunzi.storyhouse.data.dao.StoryDao
import com.dunzi.storyhouse.data.dao.UserSettingsDao
import com.dunzi.storyhouse.data.model.PlayHistory
import com.dunzi.storyhouse.data.model.Story
import com.dunzi.storyhouse.data.model.UserSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

/**
 * 故事应用数据库
 */
@Database(
    entities = [
        Story::class,
        PlayHistory::class,
        UserSettings::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    DateConverter::class,
    ListConverter::class,
    MapConverter::class
)
abstract class StoryDatabase : RoomDatabase() {
    
    abstract fun storyDao(): StoryDao
    abstract fun playHistoryDao(): PlayHistoryDao
    abstract fun userSettingsDao(): UserSettingsDao
    
    companion object {
        @Volatile
        private var INSTANCE: StoryDatabase? = null
        
        private const val DATABASE_NAME = "story_database.db"
        
        /**
         * 获取数据库实例
         */
        fun getInstance(context: Context): StoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StoryDatabase::class.java,
                    DATABASE_NAME
                )
                .addCallback(DatabaseCallback(context))
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        /**
         * 数据库回调，用于初始化和迁移
         */
        private class DatabaseCallback(
            private val context: Context
        ) : RoomDatabase.Callback() {
            
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // 数据库创建时初始化数据
                CoroutineScope(Dispatchers.IO).launch {
                    val database = getInstance(context)
                    initializeDatabase(database)
                }
            }
            
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // 数据库打开时执行的操作
                db.execSQL("PRAGMA foreign_keys = ON;")
                db.execSQL("PRAGMA journal_mode = WAL;")
                db.execSQL("PRAGMA synchronous = NORMAL;")
            }
            
            /**
             * 初始化数据库，添加示例数据
             */
            private suspend fun initializeDatabase(database: StoryDatabase) {
                try {
                    // 插入模拟故事数据
                    val mockStories = MockDataGenerator.generateMockStories()
                    database.storyDao().insertAll(mockStories)
                    
                    // 插入默认用户设置
                    val defaultSettings = MockDataGenerator.generateDefaultUserSettings()
                    database.userSettingsDao().insert(defaultSettings)
                } catch (e: Exception) {
                    // 如果插入失败，使用简单初始化
                    e.printStackTrace()
                    initializeSimpleDatabase(database)
                }
            }
            
            /**
             * 简单初始化数据库（备用方案）
             */
            private suspend fun initializeSimpleDatabase(database: StoryDatabase) {
                // 初始化默认用户设置
                val defaultSettings = UserSettings(
                    userId = "default",
                    childName = "小墩子",
                    childAge = 4,
                    childGender = "boy",
                    createdAt = Date(),
                    updatedAt = Date()
                )
                database.userSettingsDao().insert(defaultSettings)
                
                // 添加示例故事（可选）
                // initializeSampleStories(database)
            }
            
            /**
             * 初始化示例故事（开发测试用）
             */
            private suspend fun initializeSampleStories(database: StoryDatabase) {
                val sampleStories = listOf(
                    Story(
                        title = "三只小猪",
                        author = "传统故事",
                        description = "三只小猪建房子的经典故事，教会孩子们勤劳和智慧的重要性。",
                        category = "通话故事",
                        tags = listOf("经典", "动物", "勤劳"),
                        minAge = 3,
                        maxAge = 6,
                        duration = 300000, // 5分钟
                        wordCount = 500,
                        createdAt = Date(),
                        updatedAt = Date()
                    ),
                    Story(
                        title = "小红帽",
                        author = "格林童话",
                        description = "小红帽去看望奶奶，遇到大灰狼的经典童话故事。",
                        category = "通话故事",
                        tags = listOf("童话", "冒险", "安全"),
                        minAge = 4,
                        maxAge = 6,
                        duration = 420000, // 7分钟
                        wordCount = 700,
                        createdAt = Date(),
                        updatedAt = Date()
                    ),
                    Story(
                        title = "龟兔赛跑",
                        author = "伊索寓言",
                        description = "乌龟和兔子比赛跑步的寓言故事，教会孩子们不要骄傲。",
                        category = "寓言故事",
                        tags = listOf("寓言", "动物", "谦虚"),
                        minAge = 3,
                        maxAge = 5,
                        duration = 240000, // 4分钟
                        wordCount = 400,
                        createdAt = Date(),
                        updatedAt = Date()
                    ),
                    Story(
                        title = "星星的约定",
                        author = "现代创作",
                        description = "一个关于友谊和承诺的温馨睡前故事。",
                        category = "睡前故事",
                        tags = listOf("温馨", "友谊", "星空"),
                        minAge = 3,
                        maxAge = 6,
                        duration = 360000, // 6分钟
                        wordCount = 600,
                        createdAt = Date(),
                        updatedAt = Date()
                    ),
                    Story(
                        title = "恐龙探险队",
                        author = "科普作家",
                        description = "跟随小恐龙们一起探索史前世界的科普故事。",
                        category = "科普故事",
                        tags = listOf("恐龙", "科普", "探险"),
                        minAge = 5,
                        maxAge = 6,
                        duration = 480000, // 8分钟
                        wordCount = 800,
                        createdAt = Date(),
                        updatedAt = Date()
                    )
                )
                
                database.storyDao().insertAll(sampleStories)
            }
        }
    }
    
    /**
     * 清空所有数据（测试用）
     */
    suspend fun clearAll() {
        storyDao().deleteAll()
        playHistoryDao().deleteAll()
        userSettingsDao().deleteByUserId("default")
    }
    
    /**
     * 导出数据库到文件（备份用）
     */
    fun exportToFile(context: Context, filePath: String): Boolean {
        return try {
            val dbFile = context.getDatabasePath(DATABASE_NAME)
            val exportFile = java.io.File(filePath)
            dbFile.copyTo(exportFile, overwrite = true)
            true
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * 从文件导入数据库（恢复用）
     */
    fun importFromFile(context: Context, filePath: String): Boolean {
        return try {
            val dbFile = context.getDatabasePath(DATABASE_NAME)
            val importFile = java.io.File(filePath)
            importFile.copyTo(dbFile, overwrite = true)
            true
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * 获取数据库统计信息
     */
    suspend fun getDatabaseStats(): DatabaseStats {
        val storyCount = storyDao().getCount()
        val historyCount = playHistoryDao().getCount()
        val userCount = userSettingsDao().getCount()
        val totalDuration = playHistoryDao().getTotalDuration() ?: 0
        
        return DatabaseStats(
            storyCount = storyCount,
            historyCount = historyCount,
            userCount = userCount,
            totalPlayDuration = totalDuration
        )
    }
    
    data class DatabaseStats(
        val storyCount: Int,
        val historyCount: Int,
        val userCount: Int,
        val totalPlayDuration: Long
    )
}