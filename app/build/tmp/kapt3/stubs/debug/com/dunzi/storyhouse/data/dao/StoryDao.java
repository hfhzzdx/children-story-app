package com.dunzi.storyhouse.data.dao;

/**
 * 故事数据访问对象
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u0015H\'J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\'J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010 \u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\"\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010#\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u0015H\'J&\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010)J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010,J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\b\b\u0002\u0010(\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\b\b\u0002\u0010(\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u00152\b\b\u0002\u0010(\u001a\u00020\u000fH\'J.\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u00101\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u00102J\u001e\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u00105J\u0016\u00106\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u00107\u001a\u00020\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u00a7@\u00a2\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010=\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u00152\u0006\u0010=\u001a\u00020\u001aH\'J\u0016\u0010?\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010@\u001a\u00020\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u00a7@\u00a2\u0006\u0002\u00109J$\u0010A\u001a\u00020\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010C\u001a\u00020DH\u0097@\u00a2\u0006\u0002\u0010EJ&\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020IH\u00a7@\u00a2\u0006\u0002\u0010J\u00a8\u0006K"}, d2 = {"Lcom/dunzi/storyhouse/data/dao/StoryDao;", "", "addToFavorites", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "story", "Lcom/dunzi/storyhouse/data/model/Story;", "(Lcom/dunzi/storyhouse/data/model/Story;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteById", "getAgeCount", "", "age", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "getByAge", "getByAgeFlow", "getByCategory", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByCategoryFlow", "getById", "getByIdFlow", "getByTag", "tag", "getCategoryCount", "getCount", "getFavoriteCount", "getFavorites", "getFavoritesFlow", "getNewStories", "sinceTimestamp", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaged", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopular", "getRecentlyPlayed", "getRecentlyPlayedFlow", "getRecommendations", "userId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementPlayCount", "timestamp", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "insertAll", "stories", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsCompleted", "removeFromFavorites", "search", "query", "searchFlow", "update", "updateAll", "updateFavorites", "ids", "favorite", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlayProgress", "position", "progress", "", "(JJFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface StoryDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dunzi.storyhouse.data.model.Story> stories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dunzi.storyhouse.data.model.Story> stories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM stories WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM stories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.model.Story> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.dunzi.storyhouse.data.model.Story> getByIdFlow(long id);
    
    @androidx.room.Query(value = "SELECT * FROM stories ORDER BY createdAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getAllFlow();
    
    @androidx.room.Query(value = "SELECT * FROM stories ORDER BY createdAt DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPaged(int limit, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE category = :category ORDER BY createdAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE category = :category ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getByCategoryFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE :tag IN (tags) ORDER BY createdAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE isFavorite = 1 ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFavorites(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE isFavorite = 1 ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getFavoritesFlow();
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE lastPlayedAt IS NOT NULL ORDER BY lastPlayedAt DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecentlyPlayed(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE lastPlayedAt IS NOT NULL ORDER BY lastPlayedAt DESC LIMIT :limit")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getRecentlyPlayedFlow(int limit);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE title LIKE \'%\' || :query || \'%\' OR description LIKE \'%\' || :query || \'%\' OR author LIKE \'%\' || :query || \'%\' ORDER BY createdAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object search(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE title LIKE \'%\' || :query || \'%\' OR description LIKE \'%\' || :query || \'%\' OR author LIKE \'%\' || :query || \'%\' ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> searchFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE :age BETWEEN minAge AND maxAge ORDER BY createdAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByAge(int age, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM stories WHERE :age BETWEEN minAge AND maxAge ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getByAgeFlow(int age);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM stories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM stories WHERE isFavorite = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFavoriteCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM stories WHERE category = :category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategoryCount(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM stories WHERE :age BETWEEN minAge AND maxAge")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAgeCount(int age, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "UPDATE stories SET playCount = playCount + 1, lastPlayedAt = :timestamp WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object incrementPlayCount(long id, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE stories SET favoriteCount = favoriteCount + 1, isFavorite = 1 WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addToFavorites(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE stories SET favoriteCount = favoriteCount - 1, isFavorite = 0 WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeFromFavorites(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE stories SET lastPosition = :position, progress = :progress WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePlayProgress(long id, long position, float progress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE stories SET isCompleted = 1 WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsCompleted(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateFavorites(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids, boolean favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM stories \n        WHERE id NOT IN (\n            SELECT storyId FROM play_history \n            WHERE userId = :userId AND completed = 1\n        )\n        AND :age BETWEEN minAge AND maxAge\n        AND isHidden = 0\n        ORDER BY rating DESC, playCount DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecommendations(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, int age, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM stories \n        WHERE playCount > 0 \n        AND isHidden = 0\n        ORDER BY playCount DESC, rating DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPopular(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM stories \n        WHERE createdAt >= :sinceTimestamp\n        AND isHidden = 0\n        ORDER BY createdAt DESC\n        LIMIT :limit\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewStories(long sinceTimestamp, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion);
    
    /**
     * 故事数据访问对象
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object updateFavorites(@org.jetbrains.annotations.NotNull()
        com.dunzi.storyhouse.data.dao.StoryDao $this, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.Long> ids, boolean favorite, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}