package com.dunzi.storyhouse.ui.history;

/**
 * 播放历史视图模型
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/dunzi/storyhouse/ui/history/PlayHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "playHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "(Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;)V", "_historyState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/dunzi/storyhouse/ui/history/PlayHistoryViewModel$PlayHistoryState;", "historyState", "Lkotlinx/coroutines/flow/StateFlow;", "getHistoryState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "clearPlayHistory", "deleteHistoryItem", "historyId", "", "loadPlayHistory", "PlayHistoryState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.ui.history.PlayHistoryViewModel.PlayHistoryState> _historyState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.history.PlayHistoryViewModel.PlayHistoryState> historyState = null;
    
    @javax.inject.Inject()
    public PlayHistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.history.PlayHistoryViewModel.PlayHistoryState> getHistoryState() {
        return null;
    }
    
    public final void loadPlayHistory() {
    }
    
    /**
     * 清除播放历史
     */
    public final void clearPlayHistory() {
    }
    
    /**
     * 删除单个播放记录
     */
    public final void deleteHistoryItem(long historyId) {
    }
    
    /**
     * 清除错误
     */
    public final void clearError() {
    }
    
    /**
     * 播放历史状态
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\nH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fH\u00c6\u0003JK\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u000fH\u00d6\u0001J\t\u0010-\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0011\u0010\"\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0011\u00a8\u0006."}, d2 = {"Lcom/dunzi/storyhouse/ui/history/PlayHistoryViewModel$PlayHistoryState;", "", "playHistory", "", "Lcom/dunzi/storyhouse/data/model/PlayHistory;", "playStats", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "mostPlayedStories", "error/NonExistentClass", "isLoading", "", "error", "", "(Ljava/util/List;Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;Ljava/util/List;ZLjava/lang/String;)V", "averagePlayTimeMinutes", "", "getAveragePlayTimeMinutes", "()I", "getError", "()Ljava/lang/String;", "hasHistory", "getHasHistory", "()Z", "historyByDate", "", "getHistoryByDate", "()Ljava/util/Map;", "getMostPlayedStories", "()Ljava/util/List;", "getPlayHistory", "getPlayStats", "()Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "totalPlayCount", "getTotalPlayCount", "totalPlayTimeMinutes", "getTotalPlayTimeMinutes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class PlayHistoryState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dunzi.storyhouse.data.model.PlayHistory> playHistory = null;
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<error.NonExistentClass> mostPlayedStories = null;
        private final boolean isLoading = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public PlayHistoryState(@org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.PlayHistory> playHistory, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, @org.jetbrains.annotations.NotNull()
        java.util.List<error.NonExistentClass> mostPlayedStories, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.PlayHistory> getPlayHistory() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary getPlayStats() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<error.NonExistentClass> getMostPlayedStories() {
            return null;
        }
        
        public final boolean isLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean getHasHistory() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.lang.String, java.util.List<com.dunzi.storyhouse.data.model.PlayHistory>> getHistoryByDate() {
            return null;
        }
        
        public final int getTotalPlayTimeMinutes() {
            return 0;
        }
        
        public final int getTotalPlayCount() {
            return 0;
        }
        
        public final int getAveragePlayTimeMinutes() {
            return 0;
        }
        
        public PlayHistoryState() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dunzi.storyhouse.data.model.PlayHistory> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<error.NonExistentClass> component3() {
            return null;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.history.PlayHistoryViewModel.PlayHistoryState copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.dunzi.storyhouse.data.model.PlayHistory> playHistory, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, @org.jetbrains.annotations.NotNull()
        java.util.List<error.NonExistentClass> mostPlayedStories, boolean isLoading, @org.jetbrains.annotations.Nullable()
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