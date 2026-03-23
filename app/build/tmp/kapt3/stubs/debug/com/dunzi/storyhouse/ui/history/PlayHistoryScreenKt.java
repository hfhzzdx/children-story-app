package com.dunzi.storyhouse.ui.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a \u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u000e\u001a.\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a(\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a \u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a6\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a*\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020(2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0002\u00a8\u0006,"}, d2 = {"EmptyHistoryScreen", "", "onBack", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "MostPlayedStoriesSection", "mostPlayedStories", "", "error/NonExistentClass", "MostPlayedStoryItem", "storyStats", "rank", "", "(Lerror/NonExistentClass;ILandroidx/compose/ui/Modifier;)V", "PlayHistoryContent", "historyState", "Lcom/dunzi/storyhouse/ui/history/PlayHistoryViewModel$PlayHistoryState;", "onDeleteItem", "Lkotlin/Function1;", "", "PlayHistoryItem", "history", "Lcom/dunzi/storyhouse/data/model/PlayHistory;", "onDelete", "PlayHistoryScreen", "viewModel", "Lcom/dunzi/storyhouse/ui/history/PlayHistoryViewModel;", "PlayHistoryTopBar", "onClearAll", "hasHistory", "", "PlayStatsCard", "playStats", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "StatItem", "title", "", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "formatDate", "date", "Ljava/util/Date;", "app_debug"})
public final class PlayHistoryScreenKt {
    
    /**
     * 播放历史界面
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PlayHistoryScreen(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.ui.history.PlayHistoryViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    /**
     * 播放历史顶部栏
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PlayHistoryTopBar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearAll, boolean hasHistory, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 空播放历史界面
     */
    @androidx.compose.runtime.Composable()
    public static final void EmptyHistoryScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 播放历史内容
     */
    @androidx.compose.runtime.Composable()
    public static final void PlayHistoryContent(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.ui.history.PlayHistoryViewModel.PlayHistoryState historyState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onDeleteItem, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 播放统计卡片
     */
    @androidx.compose.runtime.Composable()
    public static final void PlayStatsCard(@org.jetbrains.annotations.Nullable()
    com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 统计项组件
     */
    @androidx.compose.runtime.Composable()
    public static final void StatItem(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 最常播放的故事部分
     */
    @androidx.compose.runtime.Composable()
    public static final void MostPlayedStoriesSection(@org.jetbrains.annotations.NotNull()
    java.util.List<error.NonExistentClass> mostPlayedStories, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 最常播放的故事项
     */
    @androidx.compose.runtime.Composable()
    public static final void MostPlayedStoryItem(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass storyStats, int rank, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 播放历史项
     */
    @androidx.compose.runtime.Composable()
    public static final void PlayHistoryItem(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.PlayHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 格式化日期
     */
    private static final java.lang.String formatDate(java.util.Date date) {
        return null;
    }
}