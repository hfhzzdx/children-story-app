package com.dunzi.storyhouse.data.repository;

/**
 * 故事仓库，封装故事数据访问逻辑
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001aJ\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010 J\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001aJ&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010$\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001a2\b\b\u0002\u0010$\u001a\u00020\u0016J.\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010$\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010*J\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001a2\u0006\u0010\u0017\u001a\u00020\u0016J\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001a2\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010.\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010 J\u001e\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u001a\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001a2\u0006\u00105\u001a\u00020\u001dJ\u001e\u00106\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000e2\u0006\u00107\u001a\u000208H\u0086@\u00a2\u0006\u0002\u00109J$\u0010:\u001a\u00020\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010<\u001a\u000208H\u0086@\u00a2\u0006\u0002\u0010=J&\u0010>\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020AH\u0086@\u00a2\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "", "database", "Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "(Lcom/dunzi/storyhouse/data/database/StoryDatabase;)V", "storyDao", "Lcom/dunzi/storyhouse/data/dao/StoryDao;", "addStories", "", "stories", "", "Lcom/dunzi/storyhouse/data/model/Story;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addStory", "", "story", "(Lcom/dunzi/storyhouse/data/model/Story;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteStory", "deleteStoryById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgeCount", "", "age", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllStories", "Lkotlinx/coroutines/flow/Flow;", "getCategoryCount", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteStories", "getNewStories", "sinceTimestamp", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopularStories", "getRecentlyPlayedStories", "getRecommendations", "userId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStoriesByAge", "getStoriesByCategory", "getStoryById", "getStoryCount", "incrementPlayCount", "storyId", "timestamp", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsCompleted", "searchStories", "query", "toggleFavorite", "isFavorite", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFavorites", "ids", "favorite", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlayProgress", "position", "progress", "", "(JJFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStory", "app_debug"})
public final class StoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.database.StoryDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.dao.StoryDao storyDao = null;
    
    @javax.inject.Inject()
    public StoryRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.database.StoryDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getAllStories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.dunzi.storyhouse.data.model.Story> getStoryById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getFavoriteStories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getRecentlyPlayedStories(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getStoriesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getStoriesByAge(int age) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.dunzi.storyhouse.data.model.Story>> searchStories(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecommendations(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, int age, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPopularStories(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNewStories(long sinceTimestamp, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.Story>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addStory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateStory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteStory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteStoryById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addStories(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dunzi.storyhouse.data.model.Story> stories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleFavorite(long storyId, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlayProgress(long storyId, long position, float progress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object incrementPlayCount(long storyId, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAsCompleted(long storyId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFavoriteCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCategoryCount(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAgeCount(int age, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFavorites(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids, boolean favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}