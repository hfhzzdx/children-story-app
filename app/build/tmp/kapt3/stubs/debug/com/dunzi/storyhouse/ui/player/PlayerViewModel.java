package com.dunzi.storyhouse.ui.player;

/**
 * 播放器视图模型
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u00029:B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001aH\u0002J\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u000eJ\u0006\u0010\'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u001aJ\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020 J\u0014\u0010+\u001a\u00020\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020,0\rJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u001aJ\u0006\u00101\u001a\u00020\u001aJ\u0006\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001aJ\u0006\u00104\u001a\u00020\u001aJ\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u0010H\u0002J\u0016\u00107\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020 2\u0006\u00108\u001a\u00020 R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/dunzi/storyhouse/ui/player/PlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "userSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "playHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "(Lcom/dunzi/storyhouse/data/repository/StoryRepository;Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;)V", "_playerState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/dunzi/storyhouse/ui/player/PlayerViewModel$PlayerState;", "_playlist", "", "Lcom/dunzi/storyhouse/data/model/Story;", "_userSettings", "Lcom/dunzi/storyhouse/data/model/UserSettings;", "playerState", "Lkotlinx/coroutines/flow/StateFlow;", "getPlayerState", "()Lkotlinx/coroutines/flow/StateFlow;", "playlist", "getPlaylist", "userSettings", "getUserSettings", "adjustPlaybackSpeed", "", "speed", "", "fastForward", "getPlayStats", "getRemainingSleepTimerTime", "", "loadUserSettings", "pausePlayback", "playNext", "playPrevious", "playStory", "story", "resumePlayback", "rewind", "seekTo", "position", "setPlaylist", "error/NonExistentClass", "setSleepTimer", "minutes", "", "stopPlayback", "toggleFavorite", "togglePlayback", "toggleRepeatMode", "updatePlayMode", "updatePlayerSettings", "settings", "updateProgress", "duration", "PlayerState", "RepeatMode", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.StoryRepository storyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.ui.player.PlayerViewModel.PlayerState> _playerState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.player.PlayerViewModel.PlayerState> playerState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.dunzi.storyhouse.data.model.Story>> _playlist = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.dunzi.storyhouse.data.model.Story>> playlist = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.data.model.UserSettings> _userSettings = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.data.model.UserSettings> userSettings = null;
    
    @javax.inject.Inject()
    public PlayerViewModel(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.StoryRepository storyRepository, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository, @org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.player.PlayerViewModel.PlayerState> getPlayerState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.dunzi.storyhouse.data.model.Story>> getPlaylist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.data.model.UserSettings> getUserSettings() {
        return null;
    }
    
    /**
     * 加载用户设置
     */
    private final void loadUserSettings() {
    }
    
    /**
     * 更新播放器设置
     */
    private final void updatePlayerSettings(com.dunzi.storyhouse.data.model.UserSettings settings) {
    }
    
    /**
     * 播放故事
     */
    public final void playStory(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.Story story) {
    }
    
    /**
     * 暂停播放
     */
    public final void pausePlayback() {
    }
    
    /**
     * 恢复播放
     */
    public final void resumePlayback() {
    }
    
    /**
     * 停止播放
     */
    public final void stopPlayback() {
    }
    
    /**
     * 切换循环模式
     */
    public final void toggleRepeatMode() {
    }
    
    /**
     * 跳转到指定位置
     */
    public final void seekTo(long position) {
    }
    
    /**
     * 快进10秒
     */
    public final void fastForward() {
    }
    
    /**
     * 快退10秒
     */
    public final void rewind() {
    }
    
    /**
     * 设置睡眠定时器
     */
    public final void setSleepTimer(int minutes) {
    }
    
    /**
     * 获取剩余睡眠定时器时间（秒）
     */
    public final long getRemainingSleepTimerTime() {
        return 0L;
    }
    
    /**
     * 切换播放状态
     */
    public final void togglePlayback() {
    }
    
    /**
     * 更新播放进度
     */
    public final void updateProgress(long position, long duration) {
    }
    
    /**
     * 播放下一首
     */
    public final void playNext() {
    }
    
    /**
     * 播放上一首
     */
    public final void playPrevious() {
    }
    
    /**
     * 设置播放列表
     */
    public final void setPlaylist(@org.jetbrains.annotations.NotNull()
    java.util.List<error.NonExistentClass> playlist) {
    }
    
    /**
     * 更新播放模式
     */
    public final void updatePlayMode() {
    }
    
    /**
     * 调整播放速度
     */
    public final void adjustPlaybackSpeed(float speed) {
    }
    
    /**
     * 切换收藏状态
     */
    public final void toggleFavorite() {
    }
    
    /**
     * 获取播放统计
     */
    public final void getPlayStats() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u0018J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0011H\u00c6\u0003J\t\u0010;\u001a\u00020\bH\u00c6\u0003J\t\u0010<\u001a\u00020\bH\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0005H\u00c6\u0003J\t\u0010A\u001a\u00020\bH\u00c6\u0003J\t\u0010B\u001a\u00020\bH\u00c6\u0003J\t\u0010C\u001a\u00020\u000bH\u00c6\u0003J\t\u0010D\u001a\u00020\u000bH\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\u00a5\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001J\u0013\u0010H\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0010\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\bH\u0002J\u0006\u0010L\u001a\u00020\u0017J\u0006\u0010M\u001a\u00020\bJ\t\u0010N\u001a\u00020OH\u00d6\u0001J\t\u0010P\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\"R\u0011\u0010\'\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u001aR\u0011\u0010)\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u001aR\u0011\u0010+\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010/R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010/\u00a8\u0006Q"}, d2 = {"Lcom/dunzi/storyhouse/ui/player/PlayerViewModel$PlayerState;", "", "currentStory", "Lcom/dunzi/storyhouse/data/model/Story;", "isPlaying", "", "isLoading", "currentPosition", "", "duration", "volume", "", "playbackSpeed", "backgroundPlay", "autoPlayNext", "shuffleEnabled", "repeatMode", "Lcom/dunzi/storyhouse/ui/player/PlayerViewModel$RepeatMode;", "sleepTimerDuration", "sleepTimerStartTime", "playStats", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "error", "", "(Lcom/dunzi/storyhouse/data/model/Story;ZZJJFFZZZLcom/dunzi/storyhouse/ui/player/PlayerViewModel$RepeatMode;JJLcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;Ljava/lang/String;)V", "getAutoPlayNext", "()Z", "getBackgroundPlay", "getCurrentPosition", "()J", "getCurrentStory", "()Lcom/dunzi/storyhouse/data/model/Story;", "getDuration", "getError", "()Ljava/lang/String;", "formattedDuration", "getFormattedDuration", "formattedPosition", "getFormattedPosition", "hasActiveSleepTimer", "getHasActiveSleepTimer", "hasCurrentStory", "getHasCurrentStory", "isActive", "getPlayStats", "()Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository$PlayStatsSummary;", "getPlaybackSpeed", "()F", "progress", "getProgress", "getRepeatMode", "()Lcom/dunzi/storyhouse/ui/player/PlayerViewModel$RepeatMode;", "getShuffleEnabled", "getSleepTimerDuration", "getSleepTimerStartTime", "getVolume", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "formatTime", "milliseconds", "getFormattedRemainingSleepTimerTime", "getRemainingSleepTimerTime", "hashCode", "", "toString", "app_debug"})
    public static final class PlayerState {
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.model.Story currentStory = null;
        private final boolean isPlaying = false;
        private final boolean isLoading = false;
        private final long currentPosition = 0L;
        private final long duration = 0L;
        private final float volume = 0.0F;
        private final float playbackSpeed = 0.0F;
        private final boolean backgroundPlay = false;
        private final boolean autoPlayNext = false;
        private final boolean shuffleEnabled = false;
        @org.jetbrains.annotations.NotNull()
        private final com.dunzi.storyhouse.ui.player.PlayerViewModel.RepeatMode repeatMode = null;
        private final long sleepTimerDuration = 0L;
        private final long sleepTimerStartTime = 0L;
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public PlayerState(@org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.Story currentStory, boolean isPlaying, boolean isLoading, long currentPosition, long duration, float volume, float playbackSpeed, boolean backgroundPlay, boolean autoPlayNext, boolean shuffleEnabled, @org.jetbrains.annotations.NotNull()
        com.dunzi.storyhouse.ui.player.PlayerViewModel.RepeatMode repeatMode, long sleepTimerDuration, long sleepTimerStartTime, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.Story getCurrentStory() {
            return null;
        }
        
        public final boolean isPlaying() {
            return false;
        }
        
        public final boolean isLoading() {
            return false;
        }
        
        public final long getCurrentPosition() {
            return 0L;
        }
        
        public final long getDuration() {
            return 0L;
        }
        
        public final float getVolume() {
            return 0.0F;
        }
        
        public final float getPlaybackSpeed() {
            return 0.0F;
        }
        
        public final boolean getBackgroundPlay() {
            return false;
        }
        
        public final boolean getAutoPlayNext() {
            return false;
        }
        
        public final boolean getShuffleEnabled() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.player.PlayerViewModel.RepeatMode getRepeatMode() {
            return null;
        }
        
        public final long getSleepTimerDuration() {
            return 0L;
        }
        
        public final long getSleepTimerStartTime() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary getPlayStats() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final float getProgress() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFormattedPosition() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFormattedDuration() {
            return null;
        }
        
        public final boolean getHasCurrentStory() {
            return false;
        }
        
        public final boolean isActive() {
            return false;
        }
        
        /**
         * 格式化时间
         */
        private final java.lang.String formatTime(long milliseconds) {
            return null;
        }
        
        public final boolean getHasActiveSleepTimer() {
            return false;
        }
        
        /**
         * 获取剩余睡眠定时器时间（秒）
         */
        public final long getRemainingSleepTimerTime() {
            return 0L;
        }
        
        /**
         * 获取剩余睡眠定时器时间（格式化字符串）
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFormattedRemainingSleepTimerTime() {
            return null;
        }
        
        public PlayerState() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.Story component1() {
            return null;
        }
        
        public final boolean component10() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.player.PlayerViewModel.RepeatMode component11() {
            return null;
        }
        
        public final long component12() {
            return 0L;
        }
        
        public final long component13() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary component14() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component15() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final long component4() {
            return 0L;
        }
        
        public final long component5() {
            return 0L;
        }
        
        public final float component6() {
            return 0.0F;
        }
        
        public final float component7() {
            return 0.0F;
        }
        
        public final boolean component8() {
            return false;
        }
        
        public final boolean component9() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.player.PlayerViewModel.PlayerState copy(@org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.Story currentStory, boolean isPlaying, boolean isLoading, long currentPosition, long duration, float volume, float playbackSpeed, boolean backgroundPlay, boolean autoPlayNext, boolean shuffleEnabled, @org.jetbrains.annotations.NotNull()
        com.dunzi.storyhouse.ui.player.PlayerViewModel.RepeatMode repeatMode, long sleepTimerDuration, long sleepTimerStartTime, @org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary playStats, @org.jetbrains.annotations.Nullable()
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
    
    /**
     * 循环模式枚举
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/dunzi/storyhouse/ui/player/PlayerViewModel$RepeatMode;", "", "(Ljava/lang/String;I)V", "NONE", "REPEAT_ALL", "REPEAT_ONE", "app_debug"})
    public static enum RepeatMode {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ REPEAT_ALL /* = new REPEAT_ALL() */,
        /*public static final*/ REPEAT_ONE /* = new REPEAT_ONE() */;
        
        RepeatMode() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.dunzi.storyhouse.ui.player.PlayerViewModel.RepeatMode> getEntries() {
            return null;
        }
    }
}