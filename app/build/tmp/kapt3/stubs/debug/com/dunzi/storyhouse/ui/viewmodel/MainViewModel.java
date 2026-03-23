package com.dunzi.storyhouse.ui.viewmodel;

/**
 * 主视图模型
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0006\u0010\u0019\u001a\u00020\u0014J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u000e\u0010\u001e\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0014H\u0002J\u0006\u0010!\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/dunzi/storyhouse/ui/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "userSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "playHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "(Lcom/dunzi/storyhouse/data/repository/StoryRepository;Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/dunzi/storyhouse/ui/viewmodel/MainViewModel$MainUiState;", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "clearError", "", "clearSearch", "getAgeAppropriateStories", "", "Lcom/dunzi/storyhouse/data/model/Story;", "getPlayStats", "getStoriesByCategory", "category", "", "initializeData", "loadInitialData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeData", "onDestroy", "onPause", "onResume", "refreshData", "searchStories", "query", "toggleFavorite", "storyId", "", "MainUiState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.StoryRepository storyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.ui.viewmodel.MainViewModel.MainUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.viewmodel.MainViewModel.MainUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.StoryRepository storyRepository, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.viewmodel.MainViewModel.MainUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    /**
     * 初始化数据
     */
    private final void initializeData() {
    }
    
    /**
     * 监听数据变化
     */
    private final void observeData() {
    }
    
    /**
     * 加载初始数据
     */
    private final java.lang.Object loadInitialData(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 搜索故事
     */
    public final void searchStories(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    /**
     * 清除搜索
     */
    public final void clearSearch() {
    }
    
    /**
     * 切换收藏状态
     */
    public final void toggleFavorite(long storyId) {
    }
    
    /**
     * 获取分类故事
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.dunzi.storyhouse.data.model.Story> getStoriesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    /**
     * 获取按年龄推荐的故事
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.dunzi.storyhouse.data.model.Story> getAgeAppropriateStories() {
        return null;
    }
    
    /**
     * 获取播放统计
     */
    public final void getPlayStats() {
    }
    
    /**
     * 处理错误
     */
    public final void clearError() {
    }
    
    /**
     * 刷新数据
     */
    public final void refreshData() {
    }
    
    /**
     * 活动恢复时调用
     */
    public final void onResume() {
    }
    
    /**
     * 活动暂停时调用
     */
    public final void onPause() {
    }
    
    /**
     * 活动销毁时调用
     */
    public final void onDestroy() {
    }
    
    /**
     * 主界面UI状态
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0012J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\nH\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u00109\u001a\u00020\u0010H\u00c6\u0003J\u0091\u0001\u0010:\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010;\u001a\u00020\u00102\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020>H\u00d6\u0001J\t\u0010?\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001eR\u0011\u0010#\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R#\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006@"}, d2 = {"Lcom/dunzi/storyhouse/ui/viewmodel/MainViewModel$MainUiState;", "", "allStories", "", "Lcom/dunzi/storyhouse/data/model/Story;", "favoriteStories", "recentStories", "recommendedStories", "searchResults", "searchQuery", "", "userSettings", "Lcom/dunzi/storyhouse/data/model/UserSettings;", "playStats", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "isLoading", "", "error", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/dunzi/storyhouse/data/model/UserSettings;Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;ZLjava/lang/String;)V", "getAllStories", "()Ljava/util/List;", "categories", "getCategories", "displayedStories", "getDisplayedStories", "getError", "()Ljava/lang/String;", "getFavoriteStories", "hasFavorites", "getHasFavorites", "()Z", "hasRecent", "getHasRecent", "hasStories", "getHasStories", "isSearching", "getPlayStats", "()Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "getRecentStories", "getRecommendedStories", "getSearchQuery", "getSearchResults", "storiesByCategory", "", "getStoriesByCategory", "()Ljava/util/Map;", "getUserSettings", "()Lcom/dunzi/storyhouse/data/model/UserSettings;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class MainUiState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dunzi.storyhouse.data.model.Story> allStories = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dunzi.storyhouse.data.model.Story> favoriteStories = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dunzi.storyhouse.data.model.Story> recentStories = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dunzi.storyhouse.data.model.Story> recommendedStories = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dunzi.storyhouse.data.model.Story> searchResults = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String searchQuery = null;
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.model.UserSettings userSettings = null;
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats = null;
        private final boolean isLoading = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public MainUiState(@org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> allStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> favoriteStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> recentStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> recommendedStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> searchResults, @org.jetbrains.annotations.NotNull()
        java.lang.String searchQuery, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.UserSettings userSettings, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> getAllStories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> getFavoriteStories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> getRecentStories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> getRecommendedStories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> getSearchResults() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSearchQuery() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.UserSettings getUserSettings() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary getPlayStats() {
            return null;
        }
        
        public final boolean isLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getCategories() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.lang.String, java.util.List<com.dunzi.storyhouse.data.model.Story>> getStoriesByCategory() {
            return null;
        }
        
        public final boolean getHasStories() {
            return false;
        }
        
        public final boolean getHasFavorites() {
            return false;
        }
        
        public final boolean getHasRecent() {
            return false;
        }
        
        public final boolean isSearching() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> getDisplayedStories() {
            return null;
        }
        
        public MainUiState() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.Story> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.UserSettings component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary component8() {
            return null;
        }
        
        public final boolean component9() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.viewmodel.MainViewModel.MainUiState copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> allStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> favoriteStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> recentStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> recommendedStories, @org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.Story> searchResults, @org.jetbrains.annotations.NotNull()
        java.lang.String searchQuery, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.UserSettings userSettings, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, boolean isLoading, @org.jetbrains.annotations.Nullable()
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