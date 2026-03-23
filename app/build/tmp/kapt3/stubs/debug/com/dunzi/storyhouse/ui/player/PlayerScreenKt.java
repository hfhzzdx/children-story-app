package com.dunzi.storyhouse.ui.player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a$\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a{\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010\u0015\u001ap\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a6\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001e\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007\u001a8\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006-"}, d2 = {"AlbumCover", "", "coverImage", "", "isLoading", "", "modifier", "Landroidx/compose/ui/Modifier;", "ExtraControls", "volume", "", "playbackSpeed", "shuffleEnabled", "repeatMode", "error/NonExistentClass", "onVolumeChange", "Lkotlin/Function1;", "onSpeedChange", "onShuffleToggle", "Lkotlin/Function0;", "onRepeatToggle", "(FFZLerror/NonExistentClass;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;)V", "PlaybackControls", "isPlaying", "hasPrevious", "hasNext", "onPlayPause", "onPrevious", "onNext", "onForward", "onRewind", "PlaybackProgress", "currentPosition", "", "duration", "onSeek", "PlayerScreen", "viewModel", "Lcom/dunzi/storyhouse/ui/player/PlayerViewModel;", "onBack", "SongInfo", "title", "author", "isFavorite", "onToggleFavorite", "app_debug"})
public final class PlayerScreenKt {
    
    /**
     * 播放器界面
     */
    @androidx.compose.runtime.Composable()
    public static final void PlayerScreen(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.ui.player.PlayerViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    /**
     * 专辑封面
     */
    @androidx.compose.runtime.Composable()
    public static final void AlbumCover(@org.jetbrains.annotations.Nullable()
    java.lang.String coverImage, boolean isLoading, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 歌曲信息
     */
    @androidx.compose.runtime.Composable()
    public static final void SongInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleFavorite, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 播放进度
     */
    @androidx.compose.runtime.Composable()
    public static final void PlaybackProgress(long currentPosition, long duration, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onSeek, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 播放控制
     */
    @androidx.compose.runtime.Composable()
    public static final void PlaybackControls(boolean isPlaying, boolean hasPrevious, boolean hasNext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPlayPause, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPrevious, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onForward, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRewind, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 额外控制
     */
    @androidx.compose.runtime.Composable()
    public static final void ExtraControls(float volume, float playbackSpeed, boolean shuffleEnabled, @org.jetbrains.annotations.NotNull()
    error.NonExistentClass repeatMode, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onVolumeChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onSpeedChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onShuffleToggle, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRepeatToggle, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}