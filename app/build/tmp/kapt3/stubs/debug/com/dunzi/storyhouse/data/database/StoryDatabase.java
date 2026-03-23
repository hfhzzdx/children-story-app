package com.dunzi.storyhouse.data.database;

/**
 * 故事应用数据库
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0017"}, d2 = {"Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "Landroidx/room/RoomDatabase;", "()V", "clearAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportToFile", "", "context", "Landroid/content/Context;", "filePath", "", "getDatabaseStats", "Lcom/dunzi/storyhouse/data/database/StoryDatabase$DatabaseStats;", "importFromFile", "playHistoryDao", "Lcom/dunzi/storyhouse/data/dao/PlayHistoryDao;", "storyDao", "Lcom/dunzi/storyhouse/data/dao/StoryDao;", "userSettingsDao", "Lcom/dunzi/storyhouse/data/dao/UserSettingsDao;", "Companion", "DatabaseStats", "app_debug"})
@androidx.room.Database(entities = {com.dunzi.storyhouse.data.model.Story.class, com.dunzi.storyhouse.data.model.PlayHistory.class, com.dunzi.storyhouse.data.model.UserSettings.class}, version = 1, exportSchema = true)
@androidx.room.TypeConverters(value = {com.dunzi.storyhouse.data.converter.DateConverter.class, com.dunzi.storyhouse.data.converter.ListConverter.class, com.dunzi.storyhouse.data.converter.MapConverter.class})
public abstract class StoryDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.dunzi.storyhouse.data.database.StoryDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATABASE_NAME = "story_database.db";
    @org.jetbrains.annotations.NotNull()
    public static final com.dunzi.storyhouse.data.database.StoryDatabase.Companion Companion = null;
    
    public StoryDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.dunzi.storyhouse.data.dao.StoryDao storyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.dunzi.storyhouse.data.dao.PlayHistoryDao playHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.dunzi.storyhouse.data.dao.UserSettingsDao userSettingsDao();
    
    /**
     * 清空所有数据（测试用）
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 导出数据库到文件（备份用）
     */
    public final boolean exportToFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return false;
    }
    
    /**
     * 从文件导入数据库（恢复用）
     */
    public final boolean importFromFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return false;
    }
    
    /**
     * 获取数据库统计信息
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDatabaseStats(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.database.StoryDatabase.DatabaseStats> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/dunzi/storyhouse/data/database/StoryDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "INSTANCE", "Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "getInstance", "context", "Landroid/content/Context;", "DatabaseCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * 获取数据库实例
         */
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.database.StoryDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        /**
         * 数据库回调，用于初始化和迁移
         */
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/dunzi/storyhouse/data/database/StoryDatabase$Companion$DatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initializeDatabase", "", "database", "Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "(Lcom/dunzi/storyhouse/data/database/StoryDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeSampleStories", "initializeSimpleDatabase", "onCreate", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onOpen", "app_debug"})
        static final class DatabaseCallback extends androidx.room.RoomDatabase.Callback {
            @org.jetbrains.annotations.NotNull()
            private final android.content.Context context = null;
            
            public DatabaseCallback(@org.jetbrains.annotations.NotNull()
            android.content.Context context) {
                super();
            }
            
            @java.lang.Override()
            public void onCreate(@org.jetbrains.annotations.NotNull()
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
            
            @java.lang.Override()
            public void onOpen(@org.jetbrains.annotations.NotNull()
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
            
            /**
             * 初始化数据库，添加示例数据
             */
            private final java.lang.Object initializeDatabase(com.dunzi.storyhouse.data.database.StoryDatabase database, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
                return null;
            }
            
            /**
             * 简单初始化数据库（备用方案）
             */
            private final java.lang.Object initializeSimpleDatabase(com.dunzi.storyhouse.data.database.StoryDatabase database, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
                return null;
            }
            
            /**
             * 初始化示例故事（开发测试用）
             */
            private final java.lang.Object initializeSampleStories(com.dunzi.storyhouse.data.database.StoryDatabase database, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/dunzi/storyhouse/data/database/StoryDatabase$DatabaseStats;", "", "storyCount", "", "historyCount", "userCount", "totalPlayDuration", "", "(IIIJ)V", "getHistoryCount", "()I", "getStoryCount", "getTotalPlayDuration", "()J", "getUserCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class DatabaseStats {
        private final int storyCount = 0;
        private final int historyCount = 0;
        private final int userCount = 0;
        private final long totalPlayDuration = 0L;
        
        public DatabaseStats(int storyCount, int historyCount, int userCount, long totalPlayDuration) {
            super();
        }
        
        public final int getStoryCount() {
            return 0;
        }
        
        public final int getHistoryCount() {
            return 0;
        }
        
        public final int getUserCount() {
            return 0;
        }
        
        public final long getTotalPlayDuration() {
            return 0L;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final long component4() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.database.StoryDatabase.DatabaseStats copy(int storyCount, int historyCount, int userCount, long totalPlayDuration) {
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