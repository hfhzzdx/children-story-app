package com.dunzi.storyhouse.ui.story;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a \u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007\u001a>\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"STATS_PLAY_COUNT", "", "STATS_TITLE", "STORY_NOT_FOUND", "TIP_GO_BACK", "EmptyStoryScreen", "", "onBack", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "StoryDetailContent", "story", "Lcom/dunzi/storyhouse/data/model/Story;", "StoryDetailScreen", "storyId", "", "viewModel", "Lcom/dunzi/storyhouse/ui/story/StoryDetailViewModel;", "StoryDetailTopBar", "storyTitle", "isFavorite", "", "onToggleFavorite", "app_debug"})
public final class StoryDetailActivityKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STORY_NOT_FOUND = "\u6545\u4e8b\u4e0d\u5b58\u5728";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TIP_GO_BACK = "\u8bf7\u8fd4\u56de\u4e3b\u754c\u9762\u9009\u62e9\u5176\u4ed6\u6545\u4e8b";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATS_TITLE = "\u7edf\u8ba1\u4fe1\u606f";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STATS_PLAY_COUNT = "\u64ad\u653e\u6b21\u6570";
    
    /**
     * 故事详情界面
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void StoryDetailScreen(long storyId, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.ui.story.StoryDetailViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    /**
     * 故事详情顶部栏
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void StoryDetailTopBar(@org.jetbrains.annotations.NotNull()
    java.lang.String storyTitle, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleFavorite, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 空故事界面
     */
    @androidx.compose.runtime.Composable()
    public static final void EmptyStoryScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 故事详情内容
     */
    @androidx.compose.runtime.Composable()
    public static final void StoryDetailContent(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}