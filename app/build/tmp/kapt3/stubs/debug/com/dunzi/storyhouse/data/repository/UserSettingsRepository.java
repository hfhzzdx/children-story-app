package com.dunzi.storyhouse.data.repository;

/**
 * 用户设置仓库，封装用户设置数据访问逻辑
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b?\b\u0007\u0018\u00002\u00020\u0001:\u0001wB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00162\b\b\u0002\u0010\t\u001a\u00020\nJ\u0018\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ \u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010 \u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ8\u0010!\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\'J&\u0010(\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0086@\u00a2\u0006\u0002\u0010*J&\u0010+\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0086@\u00a2\u0006\u0002\u0010*J:\u0010-\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\n2\b\b\u0002\u00101\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u00102J(\u00103\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u00106J,\u00107\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n09H\u0086@\u00a2\u0006\u0002\u0010:J8\u0010;\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010@J\u0018\u0010A\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ8\u0010B\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010GJ0\u0010H\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010LJ8\u0010M\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010GJ8\u0010R\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010GJ0\u0010V\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010ZJ@\u0010[\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010aJ0\u0010b\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010c\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010fJ8\u0010g\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\u00122\u0006\u0010k\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010lJ8\u0010m\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010n\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\u00122\u0006\u0010p\u001a\u00020\u001b2\u0006\u0010q\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020\b2\u0006\u00108\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010tJ\u0016\u0010u\u001a\u00020\b2\u0006\u00108\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010tJ\u0016\u0010v\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006x"}, d2 = {"Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "", "database", "Lcom/dunzi/storyhouse/data/database/StoryDatabase;", "(Lcom/dunzi/storyhouse/data/database/StoryDatabase;)V", "userSettingsDao", "Lcom/dunzi/storyhouse/data/dao/UserSettingsDao;", "deleteUserSettings", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUserSettings", "", "Lcom/dunzi/storyhouse/data/model/UserSettings;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultUserSettings", "getRemainingPlayTimeToday", "", "getUserCount", "", "getUserSettings", "Lkotlinx/coroutines/flow/Flow;", "getUserSettingsSummary", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository$UserSettingsSummary;", "initializeUserSettings", "isDailyLimitEnabled", "", "isDailyLimitReached", "todayPlayTime", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isParentalControlEnabled", "resetToDefaults", "updateAudioSettings", "bgMusic", "bgMusicType", "bgMusicVolume", "", "soundEffects", "(Ljava/lang/String;ZLjava/lang/String;FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBlockedCategories", "categories", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBlockedTags", "tags", "updateChildInfo", "name", "age", "gender", "avatar", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContentFilter", "level", "ageRestriction", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCustomSettings", "settings", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDisplaySettings", "theme", "fontSize", "eyeProtection", "animation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastLogin", "updateLearningSettings", "learningMode", "repeatParts", "subtitles", "vocabularyHighlight", "(Ljava/lang/String;ZZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNetworkSettings", "wifiOnly", "dataSaver", "sync", "(Ljava/lang/String;ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationSettings", "enabled", "reminders", "updates", "promotional", "updateParentalControl", "purchaseLock", "dataCollection", "analytics", "updatePlayMode", "mode", "shuffle", "crossfade", "(Ljava/lang/String;Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlaybackSettings", "volume", "speed", "voiceType", "backgroundPlay", "autoPlayNext", "(Ljava/lang/String;FFLjava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatistics", "additionalTime", "completedCount", "favoritesCount", "(Ljava/lang/String;JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStorageSettings", "autoDownload", "location", "cacheLimit", "autoClear", "(Ljava/lang/String;ZLjava/lang/String;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTimerSettings", "sleepTimerEnabled", "sleepTimerDuration", "dailyLimitEnabled", "dailyLimitDuration", "(Ljava/lang/String;ZJZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserSettings", "(Lcom/dunzi/storyhouse/data/model/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertUserSettings", "userSettingsExists", "UserSettingsSummary", "app_debug"})
public final class UserSettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.database.StoryDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.dao.UserSettingsDao userSettingsDao = null;
    
    @javax.inject.Inject()
    public UserSettingsRepository(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.database.StoryDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.dunzi.storyhouse.data.model.UserSettings> getUserSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object upsertUserSettings(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUserSettings(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.model.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteUserSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object userSettingsExists(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDefaultUserSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.model.UserSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object initializeUserSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.model.UserSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateChildInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int age, @org.jetbrains.annotations.NotNull()
    java.lang.String gender, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlaybackSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, float volume, float speed, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceType, boolean backgroundPlay, boolean autoPlayNext, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTimerSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean sleepTimerEnabled, long sleepTimerDuration, boolean dailyLimitEnabled, long dailyLimitDuration, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDisplaySettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    java.lang.String fontSize, boolean eyeProtection, boolean animation, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateContentFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String level, boolean ageRestriction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateParentalControl(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean enabled, boolean purchaseLock, boolean dataCollection, boolean analytics, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNotificationSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean enabled, boolean reminders, boolean updates, boolean promotional, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateStorageSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean autoDownload, @org.jetbrains.annotations.NotNull()
    java.lang.String location, long cacheLimit, boolean autoClear, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNetworkSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean wifiOnly, boolean dataSaver, boolean sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAudioSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean bgMusic, @org.jetbrains.annotations.NotNull()
    java.lang.String bgMusicType, float bgMusicVolume, boolean soundEffects, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlayMode(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String mode, boolean shuffle, long crossfade, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLearningSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, boolean learningMode, boolean repeatParts, boolean subtitles, boolean vocabularyHighlight, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateStatistics(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long additionalTime, int completedCount, int favoritesCount, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLastLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateBlockedCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateBlockedTags(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateCustomSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object resetToDefaults(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isParentalControlEnabled(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isDailyLimitEnabled(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRemainingPlayTimeToday(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isDailyLimitReached(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, long todayPlayTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllUserSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dunzi.storyhouse.data.model.UserSettings>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserSettingsSummary(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dunzi.storyhouse.data.repository.UserSettingsRepository.UserSettingsSummary> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\fH\u00c6\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010/\u001a\u00020\u0003J\u0006\u00100\u001a\u00020\u0003J\u0006\u00101\u001a\u00020\u0003J\t\u00102\u001a\u00020\u0005H\u00d6\u0001J\t\u00103\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018\u00a8\u00064"}, d2 = {"Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository$UserSettingsSummary;", "", "childName", "", "childAge", "", "childGender", "theme", "fontSize", "dailyLimitEnabled", "", "dailyLimitDuration", "", "parentalControlEnabled", "totalPlayTime", "storiesCompleted", "favoritesCount", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJZJII)V", "getChildAge", "()I", "getChildGender", "()Ljava/lang/String;", "getChildName", "getDailyLimitDuration", "()J", "getDailyLimitEnabled", "()Z", "getFavoritesCount", "getFontSize", "getParentalControlEnabled", "getStoriesCompleted", "getTheme", "getTotalPlayTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getChildInfo", "getDailyLimitString", "getTotalPlayTimeString", "hashCode", "toString", "app_debug"})
    public static final class UserSettingsSummary {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String childName = null;
        private final int childAge = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String childGender = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String theme = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String fontSize = null;
        private final boolean dailyLimitEnabled = false;
        private final long dailyLimitDuration = 0L;
        private final boolean parentalControlEnabled = false;
        private final long totalPlayTime = 0L;
        private final int storiesCompleted = 0;
        private final int favoritesCount = 0;
        
        public UserSettingsSummary(@org.jetbrains.annotations.NotNull()
        java.lang.String childName, int childAge, @org.jetbrains.annotations.NotNull()
        java.lang.String childGender, @org.jetbrains.annotations.NotNull()
        java.lang.String theme, @org.jetbrains.annotations.NotNull()
        java.lang.String fontSize, boolean dailyLimitEnabled, long dailyLimitDuration, boolean parentalControlEnabled, long totalPlayTime, int storiesCompleted, int favoritesCount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getChildName() {
            return null;
        }
        
        public final int getChildAge() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getChildGender() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTheme() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFontSize() {
            return null;
        }
        
        public final boolean getDailyLimitEnabled() {
            return false;
        }
        
        public final long getDailyLimitDuration() {
            return 0L;
        }
        
        public final boolean getParentalControlEnabled() {
            return false;
        }
        
        public final long getTotalPlayTime() {
            return 0L;
        }
        
        public final int getStoriesCompleted() {
            return 0;
        }
        
        public final int getFavoritesCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getChildInfo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDailyLimitString() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTotalPlayTimeString() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component10() {
            return 0;
        }
        
        public final int component11() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        public final boolean component6() {
            return false;
        }
        
        public final long component7() {
            return 0L;
        }
        
        public final boolean component8() {
            return false;
        }
        
        public final long component9() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.data.repository.UserSettingsRepository.UserSettingsSummary copy(@org.jetbrains.annotations.NotNull()
        java.lang.String childName, int childAge, @org.jetbrains.annotations.NotNull()
        java.lang.String childGender, @org.jetbrains.annotations.NotNull()
        java.lang.String theme, @org.jetbrains.annotations.NotNull()
        java.lang.String fontSize, boolean dailyLimitEnabled, long dailyLimitDuration, boolean parentalControlEnabled, long totalPlayTime, int storiesCompleted, int favoritesCount) {
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