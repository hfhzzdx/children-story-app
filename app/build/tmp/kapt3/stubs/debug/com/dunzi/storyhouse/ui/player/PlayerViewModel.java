package com.dunzi.storyhouse.ui.player;

/**
 * 播放器视图模型
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u001bJ\u0006\u0010%\u001a\u00020\u001bJ\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u001dJ\u0014\u0010(\u001a\u00020\u001b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u001bJ\u0006\u0010-\u001a\u00020\u001bJ\u0006\u0010.\u001a\u00020\u001bJ\u0006\u0010.\u001a\u00020\u001bJ\u0006\u0010/\u001a\u00020\u001bJ\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0011H\u0002J\u0016\u00102\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/dunzi/storyhouse/ui/player/PlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/dunzi/storyhouse/data/repository/StoryRepository;", "userSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "playHistoryRepository", "Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;", "(Lcom/dunzi/storyhouse/data/repository/StoryRepository;Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;Lcom/dunzi/storyhouse/data/repository/PlayHistoryRepository;)V", "_playerState", "error/NonExistentClass", "Lerror/NonExistentClass;", "_playlist", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/dunzi/storyhouse/data/model/Story;", "_userSettings", "Lcom/dunzi/storyhouse/data/model/UserSettings;", "playerState", "Lkotlinx/coroutines/flow/StateFlow;", "getPlayerState", "()Lkotlinx/coroutines/flow/StateFlow;", "playlist", "getPlaylist", "userSettings", "getUserSettings", "fastForward", "", "getRemainingSleepTimerTime", "", "loadUserSettings", "pausePlayback", "playNext", "playPrevious", "playStory", "story", "resumePlayback", "rewind", "seekTo", "position", "setPlaylist", "setSleepTimer", "minutes", "", "stopPlayback", "togglePlayback", "toggleRepeatMode", "updatePlayMode", "updatePlayerSettings", "settings", "updateProgress", "duration", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.StoryRepository storyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.PlayHistoryRepository playHistoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass _playerState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<error.NonExistentClass> playerState = null;
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
    public final kotlinx.coroutines.flow.StateFlow<error.NonExistentClass> getPlayerState() {
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
     * 跳转到指定位置
     */
    public final void seekTo(long position) {
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
     * 切换循环模式
     */
    public final void toggleRepeatMode() {
    }
}