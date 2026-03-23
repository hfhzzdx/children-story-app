package com.dunzi.storyhouse.ui.setting;

/**
 * 设置视图模型
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001?B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ*\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012J2\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dJ&\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010\'\u001a\u00020\u001dJ&\u0010(\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dJ.\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dJ6\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001dJ&\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/dunzi/storyhouse/ui/setting/SettingViewModel;", "Landroidx/lifecycle/ViewModel;", "userSettingsRepository", "Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;", "(Lcom/dunzi/storyhouse/data/repository/UserSettingsRepository;)V", "_settingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/dunzi/storyhouse/ui/setting/SettingViewModel$SettingState;", "settingState", "Lkotlinx/coroutines/flow/StateFlow;", "getSettingState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "loadSettings", "resetToDefaults", "updateChildInfo", "name", "", "age", "", "gender", "avatar", "updateContentFilter", "level", "blockedCategories", "", "blockedTags", "ageRestriction", "", "updateDisplaySettings", "theme", "fontSize", "eyeProtectionMode", "animationEnabled", "updateNotificationSettings", "enabled", "reminders", "updates", "promotions", "updateParentalControl", "purchaseLock", "dataCollectionAllowed", "analyticsEnabled", "updatePlaybackSettings", "volume", "speed", "", "voiceType", "backgroundPlay", "autoPlayNext", "updateStorageSettings", "autoDownloadFavorites", "storageLocation", "cacheSizeLimit", "autoClearCache", "wifiOnlyDownload", "dataSaverMode", "updateTimerSettings", "sleepTimerEnabled", "sleepTimerDuration", "dailyLimitEnabled", "dailyLimitDuration", "SettingState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dunzi.storyhouse.ui.setting.SettingViewModel.SettingState> _settingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.setting.SettingViewModel.SettingState> settingState = null;
    
    @javax.inject.Inject()
    public SettingViewModel(@org.jetbrains.annotations.NotNull()
    com.dunzi.storyhouse.data.repository.UserSettingsRepository userSettingsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dunzi.storyhouse.ui.setting.SettingViewModel.SettingState> getSettingState() {
        return null;
    }
    
    public final void loadSettings() {
    }
    
    /**
     * 更新儿童信息
     */
    public final void updateChildInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int age, @org.jetbrains.annotations.NotNull()
    java.lang.String gender, @org.jetbrains.annotations.Nullable()
    java.lang.String avatar) {
    }
    
    /**
     * 更新播放设置
     */
    public final void updatePlaybackSettings(int volume, float speed, @org.jetbrains.annotations.NotNull()
    java.lang.String voiceType, boolean backgroundPlay, boolean autoPlayNext) {
    }
    
    /**
     * 更新定时设置
     */
    public final void updateTimerSettings(boolean sleepTimerEnabled, int sleepTimerDuration, boolean dailyLimitEnabled, int dailyLimitDuration) {
    }
    
    /**
     * 更新显示设置
     */
    public final void updateDisplaySettings(@org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    java.lang.String fontSize, boolean eyeProtectionMode, boolean animationEnabled) {
    }
    
    /**
     * 更新内容过滤
     */
    public final void updateContentFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String level, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedCategories, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> blockedTags, boolean ageRestriction) {
    }
    
    /**
     * 更新家长控制
     */
    public final void updateParentalControl(boolean enabled, boolean purchaseLock, boolean dataCollectionAllowed, boolean analyticsEnabled) {
    }
    
    /**
     * 更新通知设置
     */
    public final void updateNotificationSettings(boolean enabled, boolean reminders, boolean updates, boolean promotions) {
    }
    
    /**
     * 更新存储设置
     */
    public final void updateStorageSettings(boolean autoDownloadFavorites, @org.jetbrains.annotations.NotNull()
    java.lang.String storageLocation, int cacheSizeLimit, boolean autoClearCache, boolean wifiOnlyDownload, boolean dataSaverMode) {
    }
    
    /**
     * 重置为默认设置
     */
    public final void resetToDefaults() {
    }
    
    /**
     * 清除错误
     */
    public final void clearError() {
    }
    
    /**
     * 设置状态
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\f\u00a8\u0006,"}, d2 = {"Lcom/dunzi/storyhouse/ui/setting/SettingViewModel$SettingState;", "", "settings", "Lcom/dunzi/storyhouse/data/model/UserSettings;", "isLoading", "", "error", "", "(Lcom/dunzi/storyhouse/data/model/UserSettings;ZLjava/lang/String;)V", "childInfo", "error/NonExistentClass", "getChildInfo", "()Lerror/NonExistentClass;", "contentFilter", "getContentFilter", "displaySettings", "getDisplaySettings", "getError", "()Ljava/lang/String;", "hasSettings", "getHasSettings", "()Z", "isReady", "notificationSettings", "getNotificationSettings", "parentalControl", "getParentalControl", "playbackSettings", "getPlaybackSettings", "getSettings", "()Lcom/dunzi/storyhouse/data/model/UserSettings;", "storageSettings", "getStorageSettings", "timerSettings", "getTimerSettings", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class SettingState {
        @org.jetbrains.annotations.Nullable()
        private final com.dunzi.storyhouse.data.model.UserSettings settings = null;
        private final boolean isLoading = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public SettingState(@org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.UserSettings settings, boolean isLoading, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.UserSettings getSettings() {
            return null;
        }
        
        public final boolean isLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean getHasSettings() {
            return false;
        }
        
        public final boolean isReady() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getChildInfo() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getPlaybackSettings() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getTimerSettings() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getDisplaySettings() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getContentFilter() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getParentalControl() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getNotificationSettings() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final error.NonExistentClass getStorageSettings() {
            return null;
        }
        
        public SettingState() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.dunzi.storyhouse.data.model.UserSettings component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dunzi.storyhouse.ui.setting.SettingViewModel.SettingState copy(@org.jetbrains.annotations.Nullable()
        com.dunzi.storyhouse.data.model.UserSettings settings, boolean isLoading, @org.jetbrains.annotations.Nullable()
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