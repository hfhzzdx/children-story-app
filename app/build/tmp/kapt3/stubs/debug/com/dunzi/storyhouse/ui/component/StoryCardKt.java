package com.dunzi.storyhouse.ui.component;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001aB\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u000b"}, d2 = {"StoryCard", "", "story", "Lcom/dunzi/storyhouse/data/model/Story;", "onStoryClick", "Lkotlin/Function1;", "", "onToggleFavorite", "modifier", "Landroidx/compose/ui/Modifier;", "StoryListItem", "app_debug"})
public final class StoryCardKt {
    
    /**
     * 故事卡片组件
     */
    @androidx.compose.runtime.Composable()
    public static final void StoryCard(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onStoryClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onToggleFavorite, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 故事列表项组件（用于列表视图）
     */
    @androidx.compose.runtime.Composable()
    public static final void StoryListItem(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onStoryClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onToggleFavorite, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}