package com.dunzi.storyhouse.data.dao;

/**
 * 用户设置数据访问对象
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b:\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00122\u0006\u0010\b\u001a\u00020\tH\'J\u000e\u0010\u0013\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J>\u0010\u001e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010$J,\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\'J,\u0010(\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\'J>\u0010*\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010/J.\u00100\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u00103J2\u00104\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t052\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u00106J>\u00107\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001cJ>\u0010>\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010CJ6\u0010D\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010HJ>\u0010I\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010CJ>\u0010N\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010CJ6\u0010R\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010VJF\u0010W\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\"2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010]J6\u0010^\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010bJ>\u0010c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010d\u001a\u00020\u00182\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u00152\u0006\u0010g\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010hJ>\u0010i\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u00152\u0006\u0010k\u001a\u00020\u00182\u0006\u0010l\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010mJ\u0016\u0010n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006o"}, d2 = {"Lcom/dunzi/storyhouse/data/dao/UserSettingsDao;", "", "delete", "", "settings", "Lcom/dunzi/storyhouse/data/model/UserSettings;", "(Lcom/dunzi/storyhouse/data/model/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByUserId", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exists", "", "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByUserId", "getByUserIdFlow", "Lkotlinx/coroutines/flow/Flow;", "getCount", "getRemainingPlayTimeToday", "", "insert", "isDailyLimitEnabled", "", "isParentalControlEnabled", "resetToDefaults", "timestamp", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "updateAudioSettings", "bgMusic", "bgMusicType", "bgMusicVolume", "", "soundEffects", "(Ljava/lang/String;ZLjava/lang/String;FZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBlockedCategories", "categories", "(Ljava/lang/String;Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBlockedTags", "tags", "updateChildInfo", "name", "age", "gender", "avatar", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContentFilter", "level", "ageRestriction", "(Ljava/lang/String;Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCustomSettings", "", "(Ljava/lang/String;Ljava/util/Map;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDisplaySettings", "theme", "fontSize", "eyeProtection", "animation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastLogin", "updateLearningSettings", "learningMode", "repeatParts", "subtitles", "vocabularyHighlight", "(Ljava/lang/String;ZZZZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNetworkSettings", "wifiOnly", "dataSaver", "sync", "(Ljava/lang/String;ZZZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationSettings", "enabled", "reminders", "updates", "promotional", "updateParentalControl", "purchaseLock", "dataCollection", "analytics", "updatePlayMode", "mode", "shuffle", "crossfade", "(Ljava/lang/String;Ljava/lang/String;ZJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlaybackSettings", "volume", "speed", "voiceType", "backgroundPlay", "autoPlayNext", "(Ljava/lang/String;FFLjava/lang/String;ZZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatistics", "additionalTime", "completedCount", "favoritesCount", "(Ljava/lang/String;JIIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStorageSettings", "autoDownload", "location", "cacheLimit", "autoClear", "(Ljava/lang/String;ZLjava/lang/String;JZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTimerSettings", "duration", "limitEnabled", "limitDuration", "(Ljava/lang/String;ZJZJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "app_debug"})
@androidx.room.Dao()
public abstract interface UserSettingsDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM user_settings WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_settings WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.model.UserSettings> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_settings WHERE userId = :userId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.dunzi.storyhouse.data.model.UserSettings> getByUserIdFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM user_settings WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object exists(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET childName = :name, childAge = :age, childGender = :gender, childAvatar = :avatar, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateChildInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int age, @org.jetbrains.annotations.NotNull()
    java.lang.String gender, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET defaultVolume = :volume, defaultPlaybackSpeed = :speed, defaultVoiceType = :voiceType, backgroundPlay = :backgroundPlay, autoPlayNext = :autoPlayNext, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePlaybackSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, float volume, float speed, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceType, boolean backgroundPlay, boolean autoPlayNext, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET sleepTimerEnabled = :enabled, sleepTimerDuration = :duration, dailyLimitEnabled = :limitEnabled, dailyLimitDuration = :limitDuration, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTimerSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean enabled, long duration, boolean limitEnabled, long limitDuration, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET theme = :theme, fontSize = :fontSize, eyeProtectionMode = :eyeProtection, animationEnabled = :animation, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDisplaySettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    java.lang.String fontSize, boolean eyeProtection, boolean animation, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET contentFilterLevel = :level, ageRestriction = :ageRestriction, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateContentFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String level, boolean ageRestriction, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET parentalControlEnabled = :enabled, purchaseLock = :purchaseLock, dataCollectionAllowed = :dataCollection, analyticsEnabled = :analytics, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateParentalControl(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean enabled, boolean purchaseLock, boolean dataCollection, boolean analytics, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET notificationsEnabled = :enabled, reminderNotifications = :reminders, updateNotifications = :updates, promotionalNotifications = :promotional, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNotificationSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean enabled, boolean reminders, boolean updates, boolean promotional, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET autoDownloadFavorites = :autoDownload, storageLocation = :location, cacheSizeLimit = :cacheLimit, autoClearCache = :autoClear, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStorageSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean autoDownload, @org.jetbrains.annotations.NotNull()
    java.lang.String location, long cacheLimit, boolean autoClear, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET wifiOnlyDownload = :wifiOnly, dataSaverMode = :dataSaver, syncEnabled = :sync, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNetworkSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean wifiOnly, boolean dataSaver, boolean sync, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET backgroundMusic = :bgMusic, backgroundMusicType = :bgMusicType, backgroundMusicVolume = :bgMusicVolume, soundEffects = :soundEffects, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAudioSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean bgMusic, @org.jetbrains.annotations.NotNull()
    java.lang.String bgMusicType, float bgMusicVolume, boolean soundEffects, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET playMode = :mode, shuffleEnabled = :shuffle, crossfadeDuration = :crossfade, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePlayMode(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String mode, boolean shuffle, long crossfade, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET learningMode = :learningMode, repeatDifficultParts = :repeatParts, showSubtitles = :subtitles, vocabularyHighlight = :vocabularyHighlight, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLearningSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean learningMode, boolean repeatParts, boolean subtitles, boolean vocabularyHighlight, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET totalPlayTime = totalPlayTime + :additionalTime, storiesCompleted = storiesCompleted + :completedCount, favoritesCount = :favoritesCount, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStatistics(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long additionalTime, int completedCount, int favoritesCount, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET lastLoginAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLastLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET blockedCategories = :categories, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBlockedCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET blockedTags = :tags, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBlockedTags(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_settings SET customSettings = :settings, updatedAt = :timestamp WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateCustomSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> settings, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        UPDATE user_settings SET \n            childName = \'\',\n            childAge = 3,\n            childGender = \'\',\n            childAvatar = \'\',\n            defaultVolume = 0.8,\n            defaultPlaybackSpeed = 1.0,\n            defaultVoiceType = \'child_female\',\n            backgroundPlay = true,\n            autoPlayNext = true,\n            sleepTimerEnabled = false,\n            sleepTimerDuration = 1800000,\n            dailyLimitEnabled = false,\n            dailyLimitDuration = 3600000,\n            theme = \'light\',\n            fontSize = \'medium\',\n            eyeProtectionMode = false,\n            animationEnabled = true,\n            contentFilterLevel = \'moderate\',\n            blockedCategories = \'[]\',\n            blockedTags = \'[]\',\n            ageRestriction = true,\n            parentalControlEnabled = false,\n            purchaseLock = true,\n            dataCollectionAllowed = false,\n            analyticsEnabled = true,\n            notificationsEnabled = true,\n            reminderNotifications = true,\n            updateNotifications = true,\n            promotionalNotifications = false,\n            autoDownloadFavorites = false,\n            storageLocation = \'internal\',\n            cacheSizeLimit = 1073741824,\n            autoClearCache = true,\n            wifiOnlyDownload = true,\n            dataSaverMode = false,\n            syncEnabled = false,\n            backgroundMusic = false,\n            backgroundMusicType = \'piano\',\n            backgroundMusicVolume = 0.3,\n            soundEffects = true,\n            playMode = \'sequential\',\n            shuffleEnabled = false,\n            crossfadeDuration = 3000,\n            learningMode = false,\n            repeatDifficultParts = true,\n            showSubtitles = false,\n            vocabularyHighlight = true,\n            customSettings = \'{}\',\n            updatedAt = :timestamp\n        WHERE userId = :userId\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resetToDefaults(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_settings")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.UserSettings>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM user_settings")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT parentalControlEnabled FROM user_settings WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isParentalControlEnabled(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @androidx.room.Query(value = "SELECT dailyLimitEnabled FROM user_settings WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isDailyLimitEnabled(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @androidx.room.Query(value = "SELECT dailyLimitDuration - COALESCE((SELECT SUM(duration) FROM play_history WHERE userId = :userId AND date(playedAt/1000, \'unixepoch\') = date(\'now\')), 0) as remainingTime FROM user_settings WHERE userId = :userId AND dailyLimitEnabled = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRemainingPlayTimeToday(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    /**
     * 用户设置数据访问对象
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
        com.dunzi.storyhouse.data.dao.UserSettingsDao $this, @org.jetbrains.annotations.NotNull()
        com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}