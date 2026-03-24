package com.dunzi.storyhouse.ui.story;

/**
 * 故事详情视图模型
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020\u000eH\u0002J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020%2\b\b\u0002\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u001aJ\u0006\u0010.\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/dunzi/storyhouse/ui/story/StoryDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "userSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "playHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "(Lcom/dunzi/storyhouse/data/repository/StoryRepository;Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;)V", "_playStats", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "_relatedStories", "", "Lcom/dunzi/storyhouse/data/model/Story;", "_storyDetailState", "Lcom/dunzi/storyhouse/ui/story/StoryDetailViewModel$StoryDetailState;", "playStats", "Lkotlinx/coroutines/flow/StateFlow;", "getPlayStats", "()Lkotlinx/coroutines/flow/StateFlow;", "relatedStories", "getRelatedStories", "storyDetailState", "getStoryDetailState", "clearError", "", "getAgeSuggestion", "", "getAveragePlayTime", "getCompletionRate", "getDifficultyDescription", "getDurationDescription", "getPlayCount", "", "loadPlayStats", "storyId", "", "loadRelatedStories", "story", "loadStoryDetail", "recordPlayHistory", "duration", "completed", "", "toggleFavorite", "toggleReadStatus", "updatePlayProgress", "progress", "", "StoryDetailState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class StoryDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.StoryRepository storyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.ui.story.StoryDetailViewModel.StoryDetailState> _storyDetailState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.story.StoryDetailViewModel.StoryDetailState> storyDetailState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.dunzi.storyhouse.data.model.Story>> _relatedStories = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.dunzi.storyhouse.data.model.Story>> relatedStories = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary> _playStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary> playStats = null;
    
    @javax.inject.Inject()
    public StoryDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.StoryRepository storyRepository, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.story.StoryDetailViewModel.StoryDetailState> getStoryDetailState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getRelatedStories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary> getPlayStats() {
        return null;
    }
    
    /**
     * 加载故事详情
     */
    public final void loadStoryDetail(long storyId) {
    }
    
    /**
     * 加载相关故事
     */
    private final void loadRelatedStories(com.dunzi.storyhouse.data.model.Story story) {
    }
    
    /**
     * 加载播放统计
     */
    private final void loadPlayStats(long storyId) {
    }
    
    /**
     * 切换收藏状态
     */
    public final void toggleFavorite() {
    }
    
    /**
     * 标记为已读/未读
     */
    public final void toggleReadStatus() {
    }
    
    /**
     * 更新播放进度
     */
    public final void updatePlayProgress(float progress) {
    }
    
    /**
     * 记录播放历史
     */
    public final void recordPlayHistory(long duration, boolean completed) {
    }
    
    /**
     * 获取年龄建议
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAgeSuggestion() {
        return null;
    }
    
    /**
     * 获取时长描述
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDurationDescription() {
        return null;
    }
    
    /**
     * 获取难度描述
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDifficultyDescription() {
        return null;
    }
    
    /**
     * 获取播放次数
     */
    public final int getPlayCount() {
        return 0;
    }
    
    /**
     * 获取平均播放时长
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAveragePlayTime() {
        return null;
    }
    
    /**
     * 获取完成率
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompletionRate() {
        return null;
    }
    
    /**
     * 清除错误
     */
    public final void clearError() {
    }
    
    /**
     * 故事详情状态
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/dunzi/storyhouse/ui/story/StoryDetailViewModel$StoryDetailState;", "", "story", "Lcom/dunzi/storyhouse/data/model/Story;", "isLoading", "", "error", "", "(Lcom/dunzi/storyhouse/data/model/Story;ZLjava/lang/String;)V", "chapters", "", "Lcom/dunzi/storyhouse/data/model/Chapter;", "getChapters", "()Ljava/util/List;", "content", "getContent", "()Ljava/lang/String;", "description", "getDescription", "getError", "hasChapters", "getHasChapters", "()Z", "hasContent", "getHasContent", "hasDescription", "getHasDescription", "hasStory", "getHasStory", "hasTags", "getHasTags", "isReady", "getStory", "()Lcom/dunzi/storyhouse/data/model/Story;", "tags", "getTags", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class StoryDetailState {
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.model.Story story = null;
        private final boolean isLoading = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public StoryDetailState(@org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.Story story, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.Story getStory() {
            return null;
        }
        
        public final boolean isLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean getHasStory() {
            return false;
        }
        
        public final boolean isReady() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getTags() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Chapter> getChapters() {
            return null;
        }
        
        public final boolean getHasChapters() {
            return false;
        }
        
        public final boolean getHasTags() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getContent() {
            return null;
        }
        
        public final boolean getHasContent() {
            return false;
        }
        
        public final boolean getHasDescription() {
            return false;
        }
        
        public StoryDetailState() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.Story component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.story.StoryDetailViewModel.StoryDetailState copy(@org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.Story story, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
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