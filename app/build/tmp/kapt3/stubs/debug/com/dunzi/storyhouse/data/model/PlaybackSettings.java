package com.dunzi.storyhouse.data.model;

/**
 * 播放设置数据类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\'\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\tH\u00c6\u0003J\t\u0010)\u001a\u00020\tH\u00c6\u0003J\t\u0010*\u001a\u00020\fH\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003Jw\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tH\u00c6\u0001J\u0013\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0003H\u00d6\u0001J\t\u00102\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/dunzi/storyhouse/data/model/PlaybackSettings;", "", "defaultVolume", "", "defaultPlaybackSpeed", "", "defaultVoiceType", "", "backgroundPlay", "", "autoPlayNext", "crossfadeDuration", "", "shuffleEnabled", "repeatMode", "equalizerPreset", "spatialAudio", "volumeBoost", "(IFLjava/lang/String;ZZJZLjava/lang/String;Ljava/lang/String;ZZ)V", "getAutoPlayNext", "()Z", "getBackgroundPlay", "getCrossfadeDuration", "()J", "getDefaultPlaybackSpeed", "()F", "getDefaultVoiceType", "()Ljava/lang/String;", "getDefaultVolume", "()I", "getEqualizerPreset", "getRepeatMode", "getShuffleEnabled", "getSpatialAudio", "getVolumeBoost", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class PlaybackSettings {
    private final int defaultVolume = 0;
    private final float defaultPlaybackSpeed = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String defaultVoiceType = null;
    private final boolean backgroundPlay = false;
    private final boolean autoPlayNext = false;
    private final long crossfadeDuration = 0L;
    private final boolean shuffleEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String repeatMode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String equalizerPreset = null;
    private final boolean spatialAudio = false;
    private final boolean volumeBoost = false;
    
    public PlaybackSettings(int defaultVolume, float defaultPlaybackSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultVoiceType, boolean backgroundPlay, boolean autoPlayNext, long crossfadeDuration, boolean shuffleEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String repeatMode, @org.jetbrains.annotations.NotNull()
    java.lang.String equalizerPreset, boolean spatialAudio, boolean volumeBoost) {
        super();
    }
    
    public final int getDefaultVolume() {
        return 0;
    }
    
    public final float getDefaultPlaybackSpeed() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDefaultVoiceType() {
        return null;
    }
    
    public final boolean getBackgroundPlay() {
        return false;
    }
    
    public final boolean getAutoPlayNext() {
        return false;
    }
    
    public final long getCrossfadeDuration() {
        return 0L;
    }
    
    public final boolean getShuffleEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRepeatMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEqualizerPreset() {
        return null;
    }
    
    public final boolean getSpatialAudio() {
        return false;
    }
    
    public final boolean getVolumeBoost() {
        return false;
    }
    
    public PlaybackSettings() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.model.PlaybackSettings copy(int defaultVolume, float defaultPlaybackSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultVoiceType, boolean backgroundPlay, boolean autoPlayNext, long crossfadeDuration, boolean shuffleEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String repeatMode, @org.jetbrains.annotations.NotNull()
    java.lang.String equalizerPreset, boolean spatialAudio, boolean volumeBoost) {
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