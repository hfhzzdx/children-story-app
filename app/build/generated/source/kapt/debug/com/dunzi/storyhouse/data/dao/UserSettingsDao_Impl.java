package com.dunzi.storyhouse.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.dunzi.storyhouse.data.converter.DateConverter;
import com.dunzi.storyhouse.data.converter.ListConverter;
import com.dunzi.storyhouse.data.converter.MapConverter;
import com.dunzi.storyhouse.data.model.UserSettings;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserSettingsDao_Impl implements UserSettingsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserSettings> __insertionAdapterOfUserSettings;

  private final ListConverter __listConverter = new ListConverter();

  private final DateConverter __dateConverter = new DateConverter();

  private final MapConverter __mapConverter = new MapConverter();

  private final EntityDeletionOrUpdateAdapter<UserSettings> __deletionAdapterOfUserSettings;

  private final EntityDeletionOrUpdateAdapter<UserSettings> __updateAdapterOfUserSettings;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByUserId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChildInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePlaybackSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTimerSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDisplaySettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateContentFilter;

  private final SharedSQLiteStatement __preparedStmtOfUpdateParentalControl;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNotificationSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStorageSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNetworkSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAudioSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePlayMode;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLearningSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatistics;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastLogin;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBlockedCategories;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBlockedTags;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCustomSettings;

  private final SharedSQLiteStatement __preparedStmtOfResetToDefaults;

  public UserSettingsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserSettings = new EntityInsertionAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_settings` (`userId`,`childName`,`childAge`,`childGender`,`childAvatar`,`defaultVolume`,`defaultPlaybackSpeed`,`defaultVoiceType`,`backgroundPlay`,`autoPlayNext`,`sleepTimerEnabled`,`sleepTimerDuration`,`dailyLimitEnabled`,`dailyLimitDuration`,`theme`,`fontSize`,`eyeProtectionMode`,`animationEnabled`,`contentFilterLevel`,`blockedCategories`,`blockedTags`,`ageRestriction`,`parentalControlEnabled`,`purchaseLock`,`dataCollectionAllowed`,`analyticsEnabled`,`notificationsEnabled`,`reminderNotifications`,`updateNotifications`,`promotionalNotifications`,`autoDownloadFavorites`,`storageLocation`,`cacheSizeLimit`,`autoClearCache`,`wifiOnlyDownload`,`dataSaverMode`,`syncEnabled`,`backgroundMusic`,`backgroundMusicType`,`backgroundMusicVolume`,`soundEffects`,`playMode`,`shuffleEnabled`,`crossfadeDuration`,`learningMode`,`repeatDifficultParts`,`showSubtitles`,`vocabularyHighlight`,`createdAt`,`updatedAt`,`lastLoginAt`,`totalPlayTime`,`storiesCompleted`,`favoritesCount`,`customSettings`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        if (entity.getChildName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChildName());
        }
        statement.bindLong(3, entity.getChildAge());
        if (entity.getChildGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getChildGender());
        }
        if (entity.getChildAvatar() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getChildAvatar());
        }
        statement.bindDouble(6, entity.getDefaultVolume());
        statement.bindDouble(7, entity.getDefaultPlaybackSpeed());
        if (entity.getDefaultVoiceType() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDefaultVoiceType());
        }
        final int _tmp = entity.getBackgroundPlay() ? 1 : 0;
        statement.bindLong(9, _tmp);
        final int _tmp_1 = entity.getAutoPlayNext() ? 1 : 0;
        statement.bindLong(10, _tmp_1);
        final int _tmp_2 = entity.getSleepTimerEnabled() ? 1 : 0;
        statement.bindLong(11, _tmp_2);
        statement.bindLong(12, entity.getSleepTimerDuration());
        final int _tmp_3 = entity.getDailyLimitEnabled() ? 1 : 0;
        statement.bindLong(13, _tmp_3);
        statement.bindLong(14, entity.getDailyLimitDuration());
        if (entity.getTheme() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getTheme());
        }
        if (entity.getFontSize() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getFontSize());
        }
        final int _tmp_4 = entity.getEyeProtectionMode() ? 1 : 0;
        statement.bindLong(17, _tmp_4);
        final int _tmp_5 = entity.getAnimationEnabled() ? 1 : 0;
        statement.bindLong(18, _tmp_5);
        if (entity.getContentFilterLevel() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getContentFilterLevel());
        }
        final String _tmp_6 = __listConverter.toString(entity.getBlockedCategories());
        if (_tmp_6 == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, _tmp_6);
        }
        final String _tmp_7 = __listConverter.toString(entity.getBlockedTags());
        if (_tmp_7 == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, _tmp_7);
        }
        final int _tmp_8 = entity.getAgeRestriction() ? 1 : 0;
        statement.bindLong(22, _tmp_8);
        final int _tmp_9 = entity.getParentalControlEnabled() ? 1 : 0;
        statement.bindLong(23, _tmp_9);
        final int _tmp_10 = entity.getPurchaseLock() ? 1 : 0;
        statement.bindLong(24, _tmp_10);
        final int _tmp_11 = entity.getDataCollectionAllowed() ? 1 : 0;
        statement.bindLong(25, _tmp_11);
        final int _tmp_12 = entity.getAnalyticsEnabled() ? 1 : 0;
        statement.bindLong(26, _tmp_12);
        final int _tmp_13 = entity.getNotificationsEnabled() ? 1 : 0;
        statement.bindLong(27, _tmp_13);
        final int _tmp_14 = entity.getReminderNotifications() ? 1 : 0;
        statement.bindLong(28, _tmp_14);
        final int _tmp_15 = entity.getUpdateNotifications() ? 1 : 0;
        statement.bindLong(29, _tmp_15);
        final int _tmp_16 = entity.getPromotionalNotifications() ? 1 : 0;
        statement.bindLong(30, _tmp_16);
        final int _tmp_17 = entity.getAutoDownloadFavorites() ? 1 : 0;
        statement.bindLong(31, _tmp_17);
        if (entity.getStorageLocation() == null) {
          statement.bindNull(32);
        } else {
          statement.bindString(32, entity.getStorageLocation());
        }
        statement.bindLong(33, entity.getCacheSizeLimit());
        final int _tmp_18 = entity.getAutoClearCache() ? 1 : 0;
        statement.bindLong(34, _tmp_18);
        final int _tmp_19 = entity.getWifiOnlyDownload() ? 1 : 0;
        statement.bindLong(35, _tmp_19);
        final int _tmp_20 = entity.getDataSaverMode() ? 1 : 0;
        statement.bindLong(36, _tmp_20);
        final int _tmp_21 = entity.getSyncEnabled() ? 1 : 0;
        statement.bindLong(37, _tmp_21);
        final int _tmp_22 = entity.getBackgroundMusic() ? 1 : 0;
        statement.bindLong(38, _tmp_22);
        if (entity.getBackgroundMusicType() == null) {
          statement.bindNull(39);
        } else {
          statement.bindString(39, entity.getBackgroundMusicType());
        }
        statement.bindDouble(40, entity.getBackgroundMusicVolume());
        final int _tmp_23 = entity.getSoundEffects() ? 1 : 0;
        statement.bindLong(41, _tmp_23);
        if (entity.getPlayMode() == null) {
          statement.bindNull(42);
        } else {
          statement.bindString(42, entity.getPlayMode());
        }
        final int _tmp_24 = entity.getShuffleEnabled() ? 1 : 0;
        statement.bindLong(43, _tmp_24);
        statement.bindLong(44, entity.getCrossfadeDuration());
        final int _tmp_25 = entity.getLearningMode() ? 1 : 0;
        statement.bindLong(45, _tmp_25);
        final int _tmp_26 = entity.getRepeatDifficultParts() ? 1 : 0;
        statement.bindLong(46, _tmp_26);
        final int _tmp_27 = entity.getShowSubtitles() ? 1 : 0;
        statement.bindLong(47, _tmp_27);
        final int _tmp_28 = entity.getVocabularyHighlight() ? 1 : 0;
        statement.bindLong(48, _tmp_28);
        final Long _tmp_29 = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp_29 == null) {
          statement.bindNull(49);
        } else {
          statement.bindLong(49, _tmp_29);
        }
        final Long _tmp_30 = __dateConverter.dateToTimestamp(entity.getUpdatedAt());
        if (_tmp_30 == null) {
          statement.bindNull(50);
        } else {
          statement.bindLong(50, _tmp_30);
        }
        final Long _tmp_31 = __dateConverter.dateToTimestamp(entity.getLastLoginAt());
        if (_tmp_31 == null) {
          statement.bindNull(51);
        } else {
          statement.bindLong(51, _tmp_31);
        }
        statement.bindLong(52, entity.getTotalPlayTime());
        statement.bindLong(53, entity.getStoriesCompleted());
        statement.bindLong(54, entity.getFavoritesCount());
        final String _tmp_32 = __mapConverter.toString(entity.getCustomSettings());
        if (_tmp_32 == null) {
          statement.bindNull(55);
        } else {
          statement.bindString(55, _tmp_32);
        }
      }
    };
    this.__deletionAdapterOfUserSettings = new EntityDeletionOrUpdateAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `user_settings` WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
      }
    };
    this.__updateAdapterOfUserSettings = new EntityDeletionOrUpdateAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_settings` SET `userId` = ?,`childName` = ?,`childAge` = ?,`childGender` = ?,`childAvatar` = ?,`defaultVolume` = ?,`defaultPlaybackSpeed` = ?,`defaultVoiceType` = ?,`backgroundPlay` = ?,`autoPlayNext` = ?,`sleepTimerEnabled` = ?,`sleepTimerDuration` = ?,`dailyLimitEnabled` = ?,`dailyLimitDuration` = ?,`theme` = ?,`fontSize` = ?,`eyeProtectionMode` = ?,`animationEnabled` = ?,`contentFilterLevel` = ?,`blockedCategories` = ?,`blockedTags` = ?,`ageRestriction` = ?,`parentalControlEnabled` = ?,`purchaseLock` = ?,`dataCollectionAllowed` = ?,`analyticsEnabled` = ?,`notificationsEnabled` = ?,`reminderNotifications` = ?,`updateNotifications` = ?,`promotionalNotifications` = ?,`autoDownloadFavorites` = ?,`storageLocation` = ?,`cacheSizeLimit` = ?,`autoClearCache` = ?,`wifiOnlyDownload` = ?,`dataSaverMode` = ?,`syncEnabled` = ?,`backgroundMusic` = ?,`backgroundMusicType` = ?,`backgroundMusicVolume` = ?,`soundEffects` = ?,`playMode` = ?,`shuffleEnabled` = ?,`crossfadeDuration` = ?,`learningMode` = ?,`repeatDifficultParts` = ?,`showSubtitles` = ?,`vocabularyHighlight` = ?,`createdAt` = ?,`updatedAt` = ?,`lastLoginAt` = ?,`totalPlayTime` = ?,`storiesCompleted` = ?,`favoritesCount` = ?,`customSettings` = ? WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        if (entity.getUserId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUserId());
        }
        if (entity.getChildName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChildName());
        }
        statement.bindLong(3, entity.getChildAge());
        if (entity.getChildGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getChildGender());
        }
        if (entity.getChildAvatar() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getChildAvatar());
        }
        statement.bindDouble(6, entity.getDefaultVolume());
        statement.bindDouble(7, entity.getDefaultPlaybackSpeed());
        if (entity.getDefaultVoiceType() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDefaultVoiceType());
        }
        final int _tmp = entity.getBackgroundPlay() ? 1 : 0;
        statement.bindLong(9, _tmp);
        final int _tmp_1 = entity.getAutoPlayNext() ? 1 : 0;
        statement.bindLong(10, _tmp_1);
        final int _tmp_2 = entity.getSleepTimerEnabled() ? 1 : 0;
        statement.bindLong(11, _tmp_2);
        statement.bindLong(12, entity.getSleepTimerDuration());
        final int _tmp_3 = entity.getDailyLimitEnabled() ? 1 : 0;
        statement.bindLong(13, _tmp_3);
        statement.bindLong(14, entity.getDailyLimitDuration());
        if (entity.getTheme() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getTheme());
        }
        if (entity.getFontSize() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getFontSize());
        }
        final int _tmp_4 = entity.getEyeProtectionMode() ? 1 : 0;
        statement.bindLong(17, _tmp_4);
        final int _tmp_5 = entity.getAnimationEnabled() ? 1 : 0;
        statement.bindLong(18, _tmp_5);
        if (entity.getContentFilterLevel() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getContentFilterLevel());
        }
        final String _tmp_6 = __listConverter.toString(entity.getBlockedCategories());
        if (_tmp_6 == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, _tmp_6);
        }
        final String _tmp_7 = __listConverter.toString(entity.getBlockedTags());
        if (_tmp_7 == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, _tmp_7);
        }
        final int _tmp_8 = entity.getAgeRestriction() ? 1 : 0;
        statement.bindLong(22, _tmp_8);
        final int _tmp_9 = entity.getParentalControlEnabled() ? 1 : 0;
        statement.bindLong(23, _tmp_9);
        final int _tmp_10 = entity.getPurchaseLock() ? 1 : 0;
        statement.bindLong(24, _tmp_10);
        final int _tmp_11 = entity.getDataCollectionAllowed() ? 1 : 0;
        statement.bindLong(25, _tmp_11);
        final int _tmp_12 = entity.getAnalyticsEnabled() ? 1 : 0;
        statement.bindLong(26, _tmp_12);
        final int _tmp_13 = entity.getNotificationsEnabled() ? 1 : 0;
        statement.bindLong(27, _tmp_13);
        final int _tmp_14 = entity.getReminderNotifications() ? 1 : 0;
        statement.bindLong(28, _tmp_14);
        final int _tmp_15 = entity.getUpdateNotifications() ? 1 : 0;
        statement.bindLong(29, _tmp_15);
        final int _tmp_16 = entity.getPromotionalNotifications() ? 1 : 0;
        statement.bindLong(30, _tmp_16);
        final int _tmp_17 = entity.getAutoDownloadFavorites() ? 1 : 0;
        statement.bindLong(31, _tmp_17);
        if (entity.getStorageLocation() == null) {
          statement.bindNull(32);
        } else {
          statement.bindString(32, entity.getStorageLocation());
        }
        statement.bindLong(33, entity.getCacheSizeLimit());
        final int _tmp_18 = entity.getAutoClearCache() ? 1 : 0;
        statement.bindLong(34, _tmp_18);
        final int _tmp_19 = entity.getWifiOnlyDownload() ? 1 : 0;
        statement.bindLong(35, _tmp_19);
        final int _tmp_20 = entity.getDataSaverMode() ? 1 : 0;
        statement.bindLong(36, _tmp_20);
        final int _tmp_21 = entity.getSyncEnabled() ? 1 : 0;
        statement.bindLong(37, _tmp_21);
        final int _tmp_22 = entity.getBackgroundMusic() ? 1 : 0;
        statement.bindLong(38, _tmp_22);
        if (entity.getBackgroundMusicType() == null) {
          statement.bindNull(39);
        } else {
          statement.bindString(39, entity.getBackgroundMusicType());
        }
        statement.bindDouble(40, entity.getBackgroundMusicVolume());
        final int _tmp_23 = entity.getSoundEffects() ? 1 : 0;
        statement.bindLong(41, _tmp_23);
        if (entity.getPlayMode() == null) {
          statement.bindNull(42);
        } else {
          statement.bindString(42, entity.getPlayMode());
        }
        final int _tmp_24 = entity.getShuffleEnabled() ? 1 : 0;
        statement.bindLong(43, _tmp_24);
        statement.bindLong(44, entity.getCrossfadeDuration());
        final int _tmp_25 = entity.getLearningMode() ? 1 : 0;
        statement.bindLong(45, _tmp_25);
        final int _tmp_26 = entity.getRepeatDifficultParts() ? 1 : 0;
        statement.bindLong(46, _tmp_26);
        final int _tmp_27 = entity.getShowSubtitles() ? 1 : 0;
        statement.bindLong(47, _tmp_27);
        final int _tmp_28 = entity.getVocabularyHighlight() ? 1 : 0;
        statement.bindLong(48, _tmp_28);
        final Long _tmp_29 = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp_29 == null) {
          statement.bindNull(49);
        } else {
          statement.bindLong(49, _tmp_29);
        }
        final Long _tmp_30 = __dateConverter.dateToTimestamp(entity.getUpdatedAt());
        if (_tmp_30 == null) {
          statement.bindNull(50);
        } else {
          statement.bindLong(50, _tmp_30);
        }
        final Long _tmp_31 = __dateConverter.dateToTimestamp(entity.getLastLoginAt());
        if (_tmp_31 == null) {
          statement.bindNull(51);
        } else {
          statement.bindLong(51, _tmp_31);
        }
        statement.bindLong(52, entity.getTotalPlayTime());
        statement.bindLong(53, entity.getStoriesCompleted());
        statement.bindLong(54, entity.getFavoritesCount());
        final String _tmp_32 = __mapConverter.toString(entity.getCustomSettings());
        if (_tmp_32 == null) {
          statement.bindNull(55);
        } else {
          statement.bindString(55, _tmp_32);
        }
        if (entity.getUserId() == null) {
          statement.bindNull(56);
        } else {
          statement.bindString(56, entity.getUserId());
        }
      }
    };
    this.__preparedStmtOfDeleteByUserId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM user_settings WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateChildInfo = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET childName = ?, childAge = ?, childGender = ?, childAvatar = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePlaybackSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET defaultVolume = ?, defaultPlaybackSpeed = ?, defaultVoiceType = ?, backgroundPlay = ?, autoPlayNext = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTimerSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET sleepTimerEnabled = ?, sleepTimerDuration = ?, dailyLimitEnabled = ?, dailyLimitDuration = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDisplaySettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET theme = ?, fontSize = ?, eyeProtectionMode = ?, animationEnabled = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateContentFilter = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET contentFilterLevel = ?, ageRestriction = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateParentalControl = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET parentalControlEnabled = ?, purchaseLock = ?, dataCollectionAllowed = ?, analyticsEnabled = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNotificationSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET notificationsEnabled = ?, reminderNotifications = ?, updateNotifications = ?, promotionalNotifications = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStorageSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET autoDownloadFavorites = ?, storageLocation = ?, cacheSizeLimit = ?, autoClearCache = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNetworkSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET wifiOnlyDownload = ?, dataSaverMode = ?, syncEnabled = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAudioSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET backgroundMusic = ?, backgroundMusicType = ?, backgroundMusicVolume = ?, soundEffects = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePlayMode = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET playMode = ?, shuffleEnabled = ?, crossfadeDuration = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLearningSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET learningMode = ?, repeatDifficultParts = ?, showSubtitles = ?, vocabularyHighlight = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStatistics = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET totalPlayTime = totalPlayTime + ?, storiesCompleted = storiesCompleted + ?, favoritesCount = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastLogin = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET lastLoginAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBlockedCategories = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET blockedCategories = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBlockedTags = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET blockedTags = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCustomSettings = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET customSettings = ?, updatedAt = ? WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfResetToDefaults = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE user_settings SET \n"
                + "            childName = '',\n"
                + "            childAge = 3,\n"
                + "            childGender = '',\n"
                + "            childAvatar = '',\n"
                + "            defaultVolume = 0.8,\n"
                + "            defaultPlaybackSpeed = 1.0,\n"
                + "            defaultVoiceType = 'child_female',\n"
                + "            backgroundPlay = true,\n"
                + "            autoPlayNext = true,\n"
                + "            sleepTimerEnabled = false,\n"
                + "            sleepTimerDuration = 1800000,\n"
                + "            dailyLimitEnabled = false,\n"
                + "            dailyLimitDuration = 3600000,\n"
                + "            theme = 'light',\n"
                + "            fontSize = 'medium',\n"
                + "            eyeProtectionMode = false,\n"
                + "            animationEnabled = true,\n"
                + "            contentFilterLevel = 'moderate',\n"
                + "            blockedCategories = '[]',\n"
                + "            blockedTags = '[]',\n"
                + "            ageRestriction = true,\n"
                + "            parentalControlEnabled = false,\n"
                + "            purchaseLock = true,\n"
                + "            dataCollectionAllowed = false,\n"
                + "            analyticsEnabled = true,\n"
                + "            notificationsEnabled = true,\n"
                + "            reminderNotifications = true,\n"
                + "            updateNotifications = true,\n"
                + "            promotionalNotifications = false,\n"
                + "            autoDownloadFavorites = false,\n"
                + "            storageLocation = 'internal',\n"
                + "            cacheSizeLimit = 1073741824,\n"
                + "            autoClearCache = true,\n"
                + "            wifiOnlyDownload = true,\n"
                + "            dataSaverMode = false,\n"
                + "            syncEnabled = false,\n"
                + "            backgroundMusic = false,\n"
                + "            backgroundMusicType = 'piano',\n"
                + "            backgroundMusicVolume = 0.3,\n"
                + "            soundEffects = true,\n"
                + "            playMode = 'sequential',\n"
                + "            shuffleEnabled = false,\n"
                + "            crossfadeDuration = 3000,\n"
                + "            learningMode = false,\n"
                + "            repeatDifficultParts = true,\n"
                + "            showSubtitles = false,\n"
                + "            vocabularyHighlight = true,\n"
                + "            customSettings = '{}',\n"
                + "            updatedAt = ?\n"
                + "        WHERE userId = ?\n"
                + "    ";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final UserSettings settings, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserSettings.insert(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final UserSettings settings, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserSettings.handle(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final UserSettings settings, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserSettings.handle(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsert(final UserSettings settings, final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> UserSettingsDao.DefaultImpls.upsert(UserSettingsDao_Impl.this, settings, __cont), $completion);
  }

  @Override
  public Object deleteByUserId(final String userId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByUserId.acquire();
        int _argIndex = 1;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteByUserId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateChildInfo(final String userId, final String name, final int age,
      final String gender, final String avatar, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateChildInfo.acquire();
        int _argIndex = 1;
        if (name == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, name);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, age);
        _argIndex = 3;
        if (gender == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, gender);
        }
        _argIndex = 4;
        if (avatar == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, avatar);
        }
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateChildInfo.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePlaybackSettings(final String userId, final float volume, final float speed,
      final String voiceType, final boolean backgroundPlay, final boolean autoPlayNext,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePlaybackSettings.acquire();
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, volume);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, speed);
        _argIndex = 3;
        if (voiceType == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, voiceType);
        }
        _argIndex = 4;
        final int _tmp = backgroundPlay ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 5;
        final int _tmp_1 = autoPlayNext ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 6;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 7;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdatePlaybackSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTimerSettings(final String userId, final boolean enabled, final long duration,
      final boolean limitEnabled, final long limitDuration, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTimerSettings.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, duration);
        _argIndex = 3;
        final int _tmp_1 = limitEnabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, limitDuration);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateTimerSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateDisplaySettings(final String userId, final String theme,
      final String fontSize, final boolean eyeProtection, final boolean animation,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDisplaySettings.acquire();
        int _argIndex = 1;
        if (theme == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, theme);
        }
        _argIndex = 2;
        if (fontSize == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, fontSize);
        }
        _argIndex = 3;
        final int _tmp = eyeProtection ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 4;
        final int _tmp_1 = animation ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateDisplaySettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateContentFilter(final String userId, final String level,
      final boolean ageRestriction, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateContentFilter.acquire();
        int _argIndex = 1;
        if (level == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, level);
        }
        _argIndex = 2;
        final int _tmp = ageRestriction ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 4;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateContentFilter.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateParentalControl(final String userId, final boolean enabled,
      final boolean purchaseLock, final boolean dataCollection, final boolean analytics,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateParentalControl.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        final int _tmp_1 = purchaseLock ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 3;
        final int _tmp_2 = dataCollection ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_2);
        _argIndex = 4;
        final int _tmp_3 = analytics ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_3);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateParentalControl.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNotificationSettings(final String userId, final boolean enabled,
      final boolean reminders, final boolean updates, final boolean promotional,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNotificationSettings.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        final int _tmp_1 = reminders ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 3;
        final int _tmp_2 = updates ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_2);
        _argIndex = 4;
        final int _tmp_3 = promotional ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_3);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateNotificationSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStorageSettings(final String userId, final boolean autoDownload,
      final String location, final long cacheLimit, final boolean autoClear, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStorageSettings.acquire();
        int _argIndex = 1;
        final int _tmp = autoDownload ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (location == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, location);
        }
        _argIndex = 3;
        _stmt.bindLong(_argIndex, cacheLimit);
        _argIndex = 4;
        final int _tmp_1 = autoClear ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateStorageSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNetworkSettings(final String userId, final boolean wifiOnly,
      final boolean dataSaver, final boolean sync, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNetworkSettings.acquire();
        int _argIndex = 1;
        final int _tmp = wifiOnly ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        final int _tmp_1 = dataSaver ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 3;
        final int _tmp_2 = sync ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_2);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 5;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateNetworkSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAudioSettings(final String userId, final boolean bgMusic,
      final String bgMusicType, final float bgMusicVolume, final boolean soundEffects,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAudioSettings.acquire();
        int _argIndex = 1;
        final int _tmp = bgMusic ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (bgMusicType == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, bgMusicType);
        }
        _argIndex = 3;
        _stmt.bindDouble(_argIndex, bgMusicVolume);
        _argIndex = 4;
        final int _tmp_1 = soundEffects ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateAudioSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePlayMode(final String userId, final String mode, final boolean shuffle,
      final long crossfade, final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePlayMode.acquire();
        int _argIndex = 1;
        if (mode == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, mode);
        }
        _argIndex = 2;
        final int _tmp = shuffle ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, crossfade);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 5;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdatePlayMode.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLearningSettings(final String userId, final boolean learningMode,
      final boolean repeatParts, final boolean subtitles, final boolean vocabularyHighlight,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLearningSettings.acquire();
        int _argIndex = 1;
        final int _tmp = learningMode ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        final int _tmp_1 = repeatParts ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 3;
        final int _tmp_2 = subtitles ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_2);
        _argIndex = 4;
        final int _tmp_3 = vocabularyHighlight ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_3);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 6;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLearningSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStatistics(final String userId, final long additionalTime,
      final int completedCount, final int favoritesCount, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatistics.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, additionalTime);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, completedCount);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, favoritesCount);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 5;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateStatistics.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastLogin(final String userId, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastLogin.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLastLogin.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateBlockedCategories(final String userId, final List<String> categories,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBlockedCategories.acquire();
        int _argIndex = 1;
        final String _tmp = __listConverter.toString(categories);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 3;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateBlockedCategories.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateBlockedTags(final String userId, final List<String> tags,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBlockedTags.acquire();
        int _argIndex = 1;
        final String _tmp = __listConverter.toString(tags);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 3;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateBlockedTags.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateCustomSettings(final String userId, final Map<String, String> settings,
      final long timestamp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCustomSettings.acquire();
        int _argIndex = 1;
        final String _tmp = __mapConverter.toString(settings);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 3;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateCustomSettings.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object resetToDefaults(final String userId, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfResetToDefaults.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 2;
        if (userId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, userId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfResetToDefaults.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getByUserId(final String userId,
      final Continuation<? super UserSettings> $completion) {
    final String _sql = "SELECT * FROM user_settings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserSettings>() {
      @Override
      @Nullable
      public UserSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfChildName = CursorUtil.getColumnIndexOrThrow(_cursor, "childName");
          final int _cursorIndexOfChildAge = CursorUtil.getColumnIndexOrThrow(_cursor, "childAge");
          final int _cursorIndexOfChildGender = CursorUtil.getColumnIndexOrThrow(_cursor, "childGender");
          final int _cursorIndexOfChildAvatar = CursorUtil.getColumnIndexOrThrow(_cursor, "childAvatar");
          final int _cursorIndexOfDefaultVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultVolume");
          final int _cursorIndexOfDefaultPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultPlaybackSpeed");
          final int _cursorIndexOfDefaultVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultVoiceType");
          final int _cursorIndexOfBackgroundPlay = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundPlay");
          final int _cursorIndexOfAutoPlayNext = CursorUtil.getColumnIndexOrThrow(_cursor, "autoPlayNext");
          final int _cursorIndexOfSleepTimerEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepTimerEnabled");
          final int _cursorIndexOfSleepTimerDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepTimerDuration");
          final int _cursorIndexOfDailyLimitEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyLimitEnabled");
          final int _cursorIndexOfDailyLimitDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyLimitDuration");
          final int _cursorIndexOfTheme = CursorUtil.getColumnIndexOrThrow(_cursor, "theme");
          final int _cursorIndexOfFontSize = CursorUtil.getColumnIndexOrThrow(_cursor, "fontSize");
          final int _cursorIndexOfEyeProtectionMode = CursorUtil.getColumnIndexOrThrow(_cursor, "eyeProtectionMode");
          final int _cursorIndexOfAnimationEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "animationEnabled");
          final int _cursorIndexOfContentFilterLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "contentFilterLevel");
          final int _cursorIndexOfBlockedCategories = CursorUtil.getColumnIndexOrThrow(_cursor, "blockedCategories");
          final int _cursorIndexOfBlockedTags = CursorUtil.getColumnIndexOrThrow(_cursor, "blockedTags");
          final int _cursorIndexOfAgeRestriction = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRestriction");
          final int _cursorIndexOfParentalControlEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "parentalControlEnabled");
          final int _cursorIndexOfPurchaseLock = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseLock");
          final int _cursorIndexOfDataCollectionAllowed = CursorUtil.getColumnIndexOrThrow(_cursor, "dataCollectionAllowed");
          final int _cursorIndexOfAnalyticsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "analyticsEnabled");
          final int _cursorIndexOfNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationsEnabled");
          final int _cursorIndexOfReminderNotifications = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderNotifications");
          final int _cursorIndexOfUpdateNotifications = CursorUtil.getColumnIndexOrThrow(_cursor, "updateNotifications");
          final int _cursorIndexOfPromotionalNotifications = CursorUtil.getColumnIndexOrThrow(_cursor, "promotionalNotifications");
          final int _cursorIndexOfAutoDownloadFavorites = CursorUtil.getColumnIndexOrThrow(_cursor, "autoDownloadFavorites");
          final int _cursorIndexOfStorageLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "storageLocation");
          final int _cursorIndexOfCacheSizeLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "cacheSizeLimit");
          final int _cursorIndexOfAutoClearCache = CursorUtil.getColumnIndexOrThrow(_cursor, "autoClearCache");
          final int _cursorIndexOfWifiOnlyDownload = CursorUtil.getColumnIndexOrThrow(_cursor, "wifiOnlyDownload");
          final int _cursorIndexOfDataSaverMode = CursorUtil.getColumnIndexOrThrow(_cursor, "dataSaverMode");
          final int _cursorIndexOfSyncEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "syncEnabled");
          final int _cursorIndexOfBackgroundMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundMusic");
          final int _cursorIndexOfBackgroundMusicType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundMusicType");
          final int _cursorIndexOfBackgroundMusicVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundMusicVolume");
          final int _cursorIndexOfSoundEffects = CursorUtil.getColumnIndexOrThrow(_cursor, "soundEffects");
          final int _cursorIndexOfPlayMode = CursorUtil.getColumnIndexOrThrow(_cursor, "playMode");
          final int _cursorIndexOfShuffleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "shuffleEnabled");
          final int _cursorIndexOfCrossfadeDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "crossfadeDuration");
          final int _cursorIndexOfLearningMode = CursorUtil.getColumnIndexOrThrow(_cursor, "learningMode");
          final int _cursorIndexOfRepeatDifficultParts = CursorUtil.getColumnIndexOrThrow(_cursor, "repeatDifficultParts");
          final int _cursorIndexOfShowSubtitles = CursorUtil.getColumnIndexOrThrow(_cursor, "showSubtitles");
          final int _cursorIndexOfVocabularyHighlight = CursorUtil.getColumnIndexOrThrow(_cursor, "vocabularyHighlight");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfTotalPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPlayTime");
          final int _cursorIndexOfStoriesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "storiesCompleted");
          final int _cursorIndexOfFavoritesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoritesCount");
          final int _cursorIndexOfCustomSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "customSettings");
          final UserSettings _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpChildName;
            if (_cursor.isNull(_cursorIndexOfChildName)) {
              _tmpChildName = null;
            } else {
              _tmpChildName = _cursor.getString(_cursorIndexOfChildName);
            }
            final int _tmpChildAge;
            _tmpChildAge = _cursor.getInt(_cursorIndexOfChildAge);
            final String _tmpChildGender;
            if (_cursor.isNull(_cursorIndexOfChildGender)) {
              _tmpChildGender = null;
            } else {
              _tmpChildGender = _cursor.getString(_cursorIndexOfChildGender);
            }
            final String _tmpChildAvatar;
            if (_cursor.isNull(_cursorIndexOfChildAvatar)) {
              _tmpChildAvatar = null;
            } else {
              _tmpChildAvatar = _cursor.getString(_cursorIndexOfChildAvatar);
            }
            final float _tmpDefaultVolume;
            _tmpDefaultVolume = _cursor.getFloat(_cursorIndexOfDefaultVolume);
            final float _tmpDefaultPlaybackSpeed;
            _tmpDefaultPlaybackSpeed = _cursor.getFloat(_cursorIndexOfDefaultPlaybackSpeed);
            final String _tmpDefaultVoiceType;
            if (_cursor.isNull(_cursorIndexOfDefaultVoiceType)) {
              _tmpDefaultVoiceType = null;
            } else {
              _tmpDefaultVoiceType = _cursor.getString(_cursorIndexOfDefaultVoiceType);
            }
            final boolean _tmpBackgroundPlay;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfBackgroundPlay);
            _tmpBackgroundPlay = _tmp != 0;
            final boolean _tmpAutoPlayNext;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAutoPlayNext);
            _tmpAutoPlayNext = _tmp_1 != 0;
            final boolean _tmpSleepTimerEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfSleepTimerEnabled);
            _tmpSleepTimerEnabled = _tmp_2 != 0;
            final long _tmpSleepTimerDuration;
            _tmpSleepTimerDuration = _cursor.getLong(_cursorIndexOfSleepTimerDuration);
            final boolean _tmpDailyLimitEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfDailyLimitEnabled);
            _tmpDailyLimitEnabled = _tmp_3 != 0;
            final long _tmpDailyLimitDuration;
            _tmpDailyLimitDuration = _cursor.getLong(_cursorIndexOfDailyLimitDuration);
            final String _tmpTheme;
            if (_cursor.isNull(_cursorIndexOfTheme)) {
              _tmpTheme = null;
            } else {
              _tmpTheme = _cursor.getString(_cursorIndexOfTheme);
            }
            final String _tmpFontSize;
            if (_cursor.isNull(_cursorIndexOfFontSize)) {
              _tmpFontSize = null;
            } else {
              _tmpFontSize = _cursor.getString(_cursorIndexOfFontSize);
            }
            final boolean _tmpEyeProtectionMode;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfEyeProtectionMode);
            _tmpEyeProtectionMode = _tmp_4 != 0;
            final boolean _tmpAnimationEnabled;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAnimationEnabled);
            _tmpAnimationEnabled = _tmp_5 != 0;
            final String _tmpContentFilterLevel;
            if (_cursor.isNull(_cursorIndexOfContentFilterLevel)) {
              _tmpContentFilterLevel = null;
            } else {
              _tmpContentFilterLevel = _cursor.getString(_cursorIndexOfContentFilterLevel);
            }
            final List<String> _tmpBlockedCategories;
            final String _tmp_6;
            if (_cursor.isNull(_cursorIndexOfBlockedCategories)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getString(_cursorIndexOfBlockedCategories);
            }
            _tmpBlockedCategories = __listConverter.fromString(_tmp_6);
            final List<String> _tmpBlockedTags;
            final String _tmp_7;
            if (_cursor.isNull(_cursorIndexOfBlockedTags)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getString(_cursorIndexOfBlockedTags);
            }
            _tmpBlockedTags = __listConverter.fromString(_tmp_7);
            final boolean _tmpAgeRestriction;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfAgeRestriction);
            _tmpAgeRestriction = _tmp_8 != 0;
            final boolean _tmpParentalControlEnabled;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfParentalControlEnabled);
            _tmpParentalControlEnabled = _tmp_9 != 0;
            final boolean _tmpPurchaseLock;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfPurchaseLock);
            _tmpPurchaseLock = _tmp_10 != 0;
            final boolean _tmpDataCollectionAllowed;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfDataCollectionAllowed);
            _tmpDataCollectionAllowed = _tmp_11 != 0;
            final boolean _tmpAnalyticsEnabled;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfAnalyticsEnabled);
            _tmpAnalyticsEnabled = _tmp_12 != 0;
            final boolean _tmpNotificationsEnabled;
            final int _tmp_13;
            _tmp_13 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_13 != 0;
            final boolean _tmpReminderNotifications;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfReminderNotifications);
            _tmpReminderNotifications = _tmp_14 != 0;
            final boolean _tmpUpdateNotifications;
            final int _tmp_15;
            _tmp_15 = _cursor.getInt(_cursorIndexOfUpdateNotifications);
            _tmpUpdateNotifications = _tmp_15 != 0;
            final boolean _tmpPromotionalNotifications;
            final int _tmp_16;
            _tmp_16 = _cursor.getInt(_cursorIndexOfPromotionalNotifications);
            _tmpPromotionalNotifications = _tmp_16 != 0;
            final boolean _tmpAutoDownloadFavorites;
            final int _tmp_17;
            _tmp_17 = _cursor.getInt(_cursorIndexOfAutoDownloadFavorites);
            _tmpAutoDownloadFavorites = _tmp_17 != 0;
            final String _tmpStorageLocation;
            if (_cursor.isNull(_cursorIndexOfStorageLocation)) {
              _tmpStorageLocation = null;
            } else {
              _tmpStorageLocation = _cursor.getString(_cursorIndexOfStorageLocation);
            }
            final long _tmpCacheSizeLimit;
            _tmpCacheSizeLimit = _cursor.getLong(_cursorIndexOfCacheSizeLimit);
            final boolean _tmpAutoClearCache;
            final int _tmp_18;
            _tmp_18 = _cursor.getInt(_cursorIndexOfAutoClearCache);
            _tmpAutoClearCache = _tmp_18 != 0;
            final boolean _tmpWifiOnlyDownload;
            final int _tmp_19;
            _tmp_19 = _cursor.getInt(_cursorIndexOfWifiOnlyDownload);
            _tmpWifiOnlyDownload = _tmp_19 != 0;
            final boolean _tmpDataSaverMode;
            final int _tmp_20;
            _tmp_20 = _cursor.getInt(_cursorIndexOfDataSaverMode);
            _tmpDataSaverMode = _tmp_20 != 0;
            final boolean _tmpSyncEnabled;
            final int _tmp_21;
            _tmp_21 = _cursor.getInt(_cursorIndexOfSyncEnabled);
            _tmpSyncEnabled = _tmp_21 != 0;
            final boolean _tmpBackgroundMusic;
            final int _tmp_22;
            _tmp_22 = _cursor.getInt(_cursorIndexOfBackgroundMusic);
            _tmpBackgroundMusic = _tmp_22 != 0;
            final String _tmpBackgroundMusicType;
            if (_cursor.isNull(_cursorIndexOfBackgroundMusicType)) {
              _tmpBackgroundMusicType = null;
            } else {
              _tmpBackgroundMusicType = _cursor.getString(_cursorIndexOfBackgroundMusicType);
            }
            final float _tmpBackgroundMusicVolume;
            _tmpBackgroundMusicVolume = _cursor.getFloat(_cursorIndexOfBackgroundMusicVolume);
            final boolean _tmpSoundEffects;
            final int _tmp_23;
            _tmp_23 = _cursor.getInt(_cursorIndexOfSoundEffects);
            _tmpSoundEffects = _tmp_23 != 0;
            final String _tmpPlayMode;
            if (_cursor.isNull(_cursorIndexOfPlayMode)) {
              _tmpPlayMode = null;
            } else {
              _tmpPlayMode = _cursor.getString(_cursorIndexOfPlayMode);
            }
            final boolean _tmpShuffleEnabled;
            final int _tmp_24;
            _tmp_24 = _cursor.getInt(_cursorIndexOfShuffleEnabled);
            _tmpShuffleEnabled = _tmp_24 != 0;
            final long _tmpCrossfadeDuration;
            _tmpCrossfadeDuration = _cursor.getLong(_cursorIndexOfCrossfadeDuration);
            final boolean _tmpLearningMode;
            final int _tmp_25;
            _tmp_25 = _cursor.getInt(_cursorIndexOfLearningMode);
            _tmpLearningMode = _tmp_25 != 0;
            final boolean _tmpRepeatDifficultParts;
            final int _tmp_26;
            _tmp_26 = _cursor.getInt(_cursorIndexOfRepeatDifficultParts);
            _tmpRepeatDifficultParts = _tmp_26 != 0;
            final boolean _tmpShowSubtitles;
            final int _tmp_27;
            _tmp_27 = _cursor.getInt(_cursorIndexOfShowSubtitles);
            _tmpShowSubtitles = _tmp_27 != 0;
            final boolean _tmpVocabularyHighlight;
            final int _tmp_28;
            _tmp_28 = _cursor.getInt(_cursorIndexOfVocabularyHighlight);
            _tmpVocabularyHighlight = _tmp_28 != 0;
            final Date _tmpCreatedAt;
            final Long _tmp_29;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_29 = null;
            } else {
              _tmp_29 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_29);
            final Date _tmpUpdatedAt;
            final Long _tmp_30;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_30 = null;
            } else {
              _tmp_30 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_30);
            final Date _tmpLastLoginAt;
            final Long _tmp_31;
            if (_cursor.isNull(_cursorIndexOfLastLoginAt)) {
              _tmp_31 = null;
            } else {
              _tmp_31 = _cursor.getLong(_cursorIndexOfLastLoginAt);
            }
            _tmpLastLoginAt = __dateConverter.fromTimestamp(_tmp_31);
            final long _tmpTotalPlayTime;
            _tmpTotalPlayTime = _cursor.getLong(_cursorIndexOfTotalPlayTime);
            final int _tmpStoriesCompleted;
            _tmpStoriesCompleted = _cursor.getInt(_cursorIndexOfStoriesCompleted);
            final int _tmpFavoritesCount;
            _tmpFavoritesCount = _cursor.getInt(_cursorIndexOfFavoritesCount);
            final Map<String, String> _tmpCustomSettings;
            final String _tmp_32;
            if (_cursor.isNull(_cursorIndexOfCustomSettings)) {
              _tmp_32 = null;
            } else {
              _tmp_32 = _cursor.getString(_cursorIndexOfCustomSettings);
            }
            _tmpCustomSettings = __mapConverter.fromString(_tmp_32);
            _result = new UserSettings(_tmpUserId,_tmpChildName,_tmpChildAge,_tmpChildGender,_tmpChildAvatar,_tmpDefaultVolume,_tmpDefaultPlaybackSpeed,_tmpDefaultVoiceType,_tmpBackgroundPlay,_tmpAutoPlayNext,_tmpSleepTimerEnabled,_tmpSleepTimerDuration,_tmpDailyLimitEnabled,_tmpDailyLimitDuration,_tmpTheme,_tmpFontSize,_tmpEyeProtectionMode,_tmpAnimationEnabled,_tmpContentFilterLevel,_tmpBlockedCategories,_tmpBlockedTags,_tmpAgeRestriction,_tmpParentalControlEnabled,_tmpPurchaseLock,_tmpDataCollectionAllowed,_tmpAnalyticsEnabled,_tmpNotificationsEnabled,_tmpReminderNotifications,_tmpUpdateNotifications,_tmpPromotionalNotifications,_tmpAutoDownloadFavorites,_tmpStorageLocation,_tmpCacheSizeLimit,_tmpAutoClearCache,_tmpWifiOnlyDownload,_tmpDataSaverMode,_tmpSyncEnabled,_tmpBackgroundMusic,_tmpBackgroundMusicType,_tmpBackgroundMusicVolume,_tmpSoundEffects,_tmpPlayMode,_tmpShuffleEnabled,_tmpCrossfadeDuration,_tmpLearningMode,_tmpRepeatDifficultParts,_tmpShowSubtitles,_tmpVocabularyHighlight,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastLoginAt,_tmpTotalPlayTime,_tmpStoriesCompleted,_tmpFavoritesCount,_tmpCustomSettings);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<UserSettings> getByUserIdFlow(final String userId) {
    final String _sql = "SELECT * FROM user_settings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"user_settings"}, new Callable<UserSettings>() {
      @Override
      @Nullable
      public UserSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfChildName = CursorUtil.getColumnIndexOrThrow(_cursor, "childName");
          final int _cursorIndexOfChildAge = CursorUtil.getColumnIndexOrThrow(_cursor, "childAge");
          final int _cursorIndexOfChildGender = CursorUtil.getColumnIndexOrThrow(_cursor, "childGender");
          final int _cursorIndexOfChildAvatar = CursorUtil.getColumnIndexOrThrow(_cursor, "childAvatar");
          final int _cursorIndexOfDefaultVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultVolume");
          final int _cursorIndexOfDefaultPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultPlaybackSpeed");
          final int _cursorIndexOfDefaultVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultVoiceType");
          final int _cursorIndexOfBackgroundPlay = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundPlay");
          final int _cursorIndexOfAutoPlayNext = CursorUtil.getColumnIndexOrThrow(_cursor, "autoPlayNext");
          final int _cursorIndexOfSleepTimerEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepTimerEnabled");
          final int _cursorIndexOfSleepTimerDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepTimerDuration");
          final int _cursorIndexOfDailyLimitEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyLimitEnabled");
          final int _cursorIndexOfDailyLimitDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyLimitDuration");
          final int _cursorIndexOfTheme = CursorUtil.getColumnIndexOrThrow(_cursor, "theme");
          final int _cursorIndexOfFontSize = CursorUtil.getColumnIndexOrThrow(_cursor, "fontSize");
          final int _cursorIndexOfEyeProtectionMode = CursorUtil.getColumnIndexOrThrow(_cursor, "eyeProtectionMode");
          final int _cursorIndexOfAnimationEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "animationEnabled");
          final int _cursorIndexOfContentFilterLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "contentFilterLevel");
          final int _cursorIndexOfBlockedCategories = CursorUtil.getColumnIndexOrThrow(_cursor, "blockedCategories");
          final int _cursorIndexOfBlockedTags = CursorUtil.getColumnIndexOrThrow(_cursor, "blockedTags");
          final int _cursorIndexOfAgeRestriction = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRestriction");
          final int _cursorIndexOfParentalControlEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "parentalControlEnabled");
          final int _cursorIndexOfPurchaseLock = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseLock");
          final int _cursorIndexOfDataCollectionAllowed = CursorUtil.getColumnIndexOrThrow(_cursor, "dataCollectionAllowed");
          final int _cursorIndexOfAnalyticsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "analyticsEnabled");
          final int _cursorIndexOfNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationsEnabled");
          final int _cursorIndexOfReminderNotifications = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderNotifications");
          final int _cursorIndexOfUpdateNotifications = CursorUtil.getColumnIndexOrThrow(_cursor, "updateNotifications");
          final int _cursorIndexOfPromotionalNotifications = CursorUtil.getColumnIndexOrThrow(_cursor, "promotionalNotifications");
          final int _cursorIndexOfAutoDownloadFavorites = CursorUtil.getColumnIndexOrThrow(_cursor, "autoDownloadFavorites");
          final int _cursorIndexOfStorageLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "storageLocation");
          final int _cursorIndexOfCacheSizeLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "cacheSizeLimit");
          final int _cursorIndexOfAutoClearCache = CursorUtil.getColumnIndexOrThrow(_cursor, "autoClearCache");
          final int _cursorIndexOfWifiOnlyDownload = CursorUtil.getColumnIndexOrThrow(_cursor, "wifiOnlyDownload");
          final int _cursorIndexOfDataSaverMode = CursorUtil.getColumnIndexOrThrow(_cursor, "dataSaverMode");
          final int _cursorIndexOfSyncEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "syncEnabled");
          final int _cursorIndexOfBackgroundMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundMusic");
          final int _cursorIndexOfBackgroundMusicType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundMusicType");
          final int _cursorIndexOfBackgroundMusicVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundMusicVolume");
          final int _cursorIndexOfSoundEffects = CursorUtil.getColumnIndexOrThrow(_cursor, "soundEffects");
          final int _cursorIndexOfPlayMode = CursorUtil.getColumnIndexOrThrow(_cursor, "playMode");
          final int _cursorIndexOfShuffleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "shuffleEnabled");
          final int _cursorIndexOfCrossfadeDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "crossfadeDuration");
          final int _cursorIndexOfLearningMode = CursorUtil.getColumnIndexOrThrow(_cursor, "learningMode");
          final int _cursorIndexOfRepeatDifficultParts = CursorUtil.getColumnIndexOrThrow(_cursor, "repeatDifficultParts");
          final int _cursorIndexOfShowSubtitles = CursorUtil.getColumnIndexOrThrow(_cursor, "showSubtitles");
          final int _cursorIndexOfVocabularyHighlight = CursorUtil.getColumnIndexOrThrow(_cursor, "vocabularyHighlight");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastLoginAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastLoginAt");
          final int _cursorIndexOfTotalPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPlayTime");
          final int _cursorIndexOfStoriesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "storiesCompleted");
          final int _cursorIndexOfFavoritesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoritesCount");
          final int _cursorIndexOfCustomSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "customSettings");
          final UserSettings _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpChildName;
            if (_cursor.isNull(_cursorIndexOfChildName)) {
              _tmpChildName = null;
            } else {
              _tmpChildName = _cursor.getString(_cursorIndexOfChildName);
            }
            final int _tmpChildAge;
            _tmpChildAge = _cursor.getInt(_cursorIndexOfChildAge);
            final String _tmpChildGender;
            if (_cursor.isNull(_cursorIndexOfChildGender)) {
              _tmpChildGender = null;
            } else {
              _tmpChildGender = _cursor.getString(_cursorIndexOfChildGender);
            }
            final String _tmpChildAvatar;
            if (_cursor.isNull(_cursorIndexOfChildAvatar)) {
              _tmpChildAvatar = null;
            } else {
              _tmpChildAvatar = _cursor.getString(_cursorIndexOfChildAvatar);
            }
            final float _tmpDefaultVolume;
            _tmpDefaultVolume = _cursor.getFloat(_cursorIndexOfDefaultVolume);
            final float _tmpDefaultPlaybackSpeed;
            _tmpDefaultPlaybackSpeed = _cursor.getFloat(_cursorIndexOfDefaultPlaybackSpeed);
            final String _tmpDefaultVoiceType;
            if (_cursor.isNull(_cursorIndexOfDefaultVoiceType)) {
              _tmpDefaultVoiceType = null;
            } else {
              _tmpDefaultVoiceType = _cursor.getString(_cursorIndexOfDefaultVoiceType);
            }
            final boolean _tmpBackgroundPlay;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfBackgroundPlay);
            _tmpBackgroundPlay = _tmp != 0;
            final boolean _tmpAutoPlayNext;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAutoPlayNext);
            _tmpAutoPlayNext = _tmp_1 != 0;
            final boolean _tmpSleepTimerEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfSleepTimerEnabled);
            _tmpSleepTimerEnabled = _tmp_2 != 0;
            final long _tmpSleepTimerDuration;
            _tmpSleepTimerDuration = _cursor.getLong(_cursorIndexOfSleepTimerDuration);
            final boolean _tmpDailyLimitEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfDailyLimitEnabled);
            _tmpDailyLimitEnabled = _tmp_3 != 0;
            final long _tmpDailyLimitDuration;
            _tmpDailyLimitDuration = _cursor.getLong(_cursorIndexOfDailyLimitDuration);
            final String _tmpTheme;
            if (_cursor.isNull(_cursorIndexOfTheme)) {
              _tmpTheme = null;
            } else {
              _tmpTheme = _cursor.getString(_cursorIndexOfTheme);
            }
            final String _tmpFontSize;
            if (_cursor.isNull(_cursorIndexOfFontSize)) {
              _tmpFontSize = null;
            } else {
              _tmpFontSize = _cursor.getString(_cursorIndexOfFontSize);
            }
            final boolean _tmpEyeProtectionMode;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfEyeProtectionMode);
            _tmpEyeProtectionMode = _tmp_4 != 0;
            final boolean _tmpAnimationEnabled;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAnimationEnabled);
            _tmpAnimationEnabled = _tmp_5 != 0;
            final String _tmpContentFilterLevel;
            if (_cursor.isNull(_cursorIndexOfContentFilterLevel)) {
              _tmpContentFilterLevel = null;
            } else {
              _tmpContentFilterLevel = _cursor.getString(_cursorIndexOfContentFilterLevel);
            }
            final List<String> _tmpBlockedCategories;
            final String _tmp_6;
            if (_cursor.isNull(_cursorIndexOfBlockedCategories)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getString(_cursorIndexOfBlockedCategories);
            }
            _tmpBlockedCategories = __listConverter.fromString(_tmp_6);
            final List<String> _tmpBlockedTags;
            final String _tmp_7;
            if (_cursor.isNull(_cursorIndexOfBlockedTags)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getString(_cursorIndexOfBlockedTags);
            }
            _tmpBlockedTags = __listConverter.fromString(_tmp_7);
            final boolean _tmpAgeRestriction;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfAgeRestriction);
            _tmpAgeRestriction = _tmp_8 != 0;
            final boolean _tmpParentalControlEnabled;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfParentalControlEnabled);
            _tmpParentalControlEnabled = _tmp_9 != 0;
            final boolean _tmpPurchaseLock;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfPurchaseLock);
            _tmpPurchaseLock = _tmp_10 != 0;
            final boolean _tmpDataCollectionAllowed;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfDataCollectionAllowed);
            _tmpDataCollectionAllowed = _tmp_11 != 0;
            final boolean _tmpAnalyticsEnabled;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfAnalyticsEnabled);
            _tmpAnalyticsEnabled = _tmp_12 != 0;
            final boolean _tmpNotificationsEnabled;
            final int _tmp_13;
            _tmp_13 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_13 != 0;
            final boolean _tmpReminderNotifications;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfReminderNotifications);
            _tmpReminderNotifications = _tmp_14 != 0;
            final boolean _tmpUpdateNotifications;
            final int _tmp_15;
            _tmp_15 = _cursor.getInt(_cursorIndexOfUpdateNotifications);
            _tmpUpdateNotifications = _tmp_15 != 0;
            final boolean _tmpPromotionalNotifications;
            final int _tmp_16;
            _tmp_16 = _cursor.getInt(_cursorIndexOfPromotionalNotifications);
            _tmpPromotionalNotifications = _tmp_16 != 0;
            final boolean _tmpAutoDownloadFavorites;
            final int _tmp_17;
            _tmp_17 = _cursor.getInt(_cursorIndexOfAutoDownloadFavorites);
            _tmpAutoDownloadFavorites = _tmp_17 != 0;
            final String _tmpStorageLocation;
            if (_cursor.isNull(_cursorIndexOfStorageLocation)) {
              _tmpStorageLocation = null;
            } else {
              _tmpStorageLocation = _cursor.getString(_cursorIndexOfStorageLocation);
            }
            final long _tmpCacheSizeLimit;
            _tmpCacheSizeLimit = _cursor.getLong(_cursorIndexOfCacheSizeLimit);
            final boolean _tmpAutoClearCache;
            final int _tmp_18;
            _tmp_18 = _cursor.getInt(_cursorIndexOfAutoClearCache);
            _tmpAutoClearCache = _tmp_18 != 0;
            final boolean _tmpWifiOnlyDownload;
            final int _tmp_19;
            _tmp_19 = _cursor.getInt(_cursorIndexOfWifiOnlyDownload);
            _tmpWifiOnlyDownload = _tmp_19 != 0;
            final boolean _tmpDataSaverMode;
            final int _tmp_20;
            _tmp_20 = _cursor.getInt(_cursorIndexOfDataSaverMode);
            _tmpDataSaverMode = _tmp_20 != 0;
            final boolean _tmpSyncEnabled;
            final int _tmp_21;
            _tmp_21 = _cursor.getInt(_cursorIndexOfSyncEnabled);
            _tmpSyncEnabled = _tmp_21 != 0;
            final boolean _tmpBackgroundMusic;
            final int _tmp_22;
            _tmp_22 = _cursor.getInt(_cursorIndexOfBackgroundMusic);
            _tmpBackgroundMusic = _tmp_22 != 0;
            final String _tmpBackgroundMusicType;
            if (_cursor.isNull(_cursorIndexOfBackgroundMusicType)) {
              _tmpBackgroundMusicType = null;
            } else {
              _tmpBackgroundMusicType = _cursor.getString(_cursorIndexOfBackgroundMusicType);
            }
            final float _tmpBackgroundMusicVolume;
            _tmpBackgroundMusicVolume = _cursor.getFloat(_cursorIndexOfBackgroundMusicVolume);
            final boolean _tmpSoundEffects;
            final int _tmp_23;
            _tmp_23 = _cursor.getInt(_cursorIndexOfSoundEffects);
            _tmpSoundEffects = _tmp_23 != 0;
            final String _tmpPlayMode;
            if (_cursor.isNull(_cursorIndexOfPlayMode)) {
              _tmpPlayMode = null;
            } else {
              _tmpPlayMode = _cursor.getString(_cursorIndexOfPlayMode);
            }
            final boolean _tmpShuffleEnabled;
            final int _tmp_24;
            _tmp_24 = _cursor.getInt(_cursorIndexOfShuffleEnabled);
            _tmpShuffleEnabled = _tmp_24 != 0;
            final long _tmpCrossfadeDuration;
            _tmpCrossfadeDuration = _cursor.getLong(_cursorIndexOfCrossfadeDuration);
            final boolean _tmpLearningMode;
            final int _tmp_25;
            _tmp_25 = _cursor.getInt(_cursorIndexOfLearningMode);
            _tmpLearningMode = _tmp_25 != 0;
            final boolean _tmpRepeatDifficultParts;
            final int _tmp_26;
            _tmp_26 = _cursor.getInt(_cursorIndexOfRepeatDifficultParts);
            _tmpRepeatDifficultParts = _tmp_26 != 0;
            final boolean _tmpShowSubtitles;
            final int _tmp_27;
            _tmp_27 = _cursor.getInt(_cursorIndexOfShowSubtitles);
            _tmpShowSubtitles = _tmp_27 != 0;
            final boolean _tmpVocabularyHighlight;
            final int _tmp_28;
            _tmp_28 = _cursor.getInt(_cursorIndexOfVocabularyHighlight);
            _tmpVocabularyHighlight = _tmp_28 != 0;
            final Date _tmpCreatedAt;
            final Long _tmp_29;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_29 = null;
            } else {
              _tmp_29 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_29);
            final Date _tmpUpdatedAt;
            final Long _tmp_30;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_30 = null;
            } else {
              _tmp_30 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_30);
            final Date _tmpLastLoginAt;
            final Long _tmp_31;
            if (_cursor.isNull(_cursorIndexOfLastLoginAt)) {
              _tmp_31 = null;
            } else {
              _tmp_31 = _cursor.getLong(_cursorIndexOfLastLoginAt);
            }
            _tmpLastLoginAt = __dateConverter.fromTimestamp(_tmp_31);
            final long _tmpTotalPlayTime;
            _tmpTotalPlayTime = _cursor.getLong(_cursorIndexOfTotalPlayTime);
            final int _tmpStoriesCompleted;
            _tmpStoriesCompleted = _cursor.getInt(_cursorIndexOfStoriesCompleted);
            final int _tmpFavoritesCount;
            _tmpFavoritesCount = _cursor.getInt(_cursorIndexOfFavoritesCount);
            final Map<String, String> _tmpCustomSettings;
            final String _tmp_32;
            if (_cursor.isNull(_cursorIndexOfCustomSettings)) {
              _tmp_32 = null;
            } else {
              _tmp_32 = _cursor.getString(_cursorIndexOfCustomSettings);
            }
            _tmpCustomSettings = __mapConverter.fromString(_tmp_32);
            _result = new UserSettings(_tmpUserId,_tmpChildName,_tmpChildAge,_tmpChildGender,_tmpChildAvatar,_tmpDefaultVolume,_tmpDefaultPlaybackSpeed,_tmpDefaultVoiceType,_tmpBackgroundPlay,_tmpAutoPlayNext,_tmpSleepTimerEnabled,_tmpSleepTimerDuration,_tmpDailyLimitEnabled,_tmpDailyLimitDuration,_tmpTheme,_tmpFontSize,_tmpEyeProtectionMode,_tmpAnimationEnabled,_tmpContentFilterLevel,_tmpBlockedCategories,_tmpBlockedTags,_tmpAgeRestriction,_tmpParentalControlEnabled,_tmpPurchaseLock,_tmpDataCollectionAllowed,_tmpAnalyticsEnabled,_tmpNotificationsEnabled,_tmpReminderNotifications,_tmpUpdateNotifications,_tmpPromotionalNotifications,_tmpAutoDownloadFavorites,_tmpStorageLocation,_tmpCacheSizeLimit,_tmpAutoClearCache,_tmpWifiOnlyDownload,_tmpDataSaverMode,_tmpSyncEnabled,_tmpBackgroundMusic,_tmpBackgroundMusicType,_tmpBackgroundMusicVolume,_tmpSoundEffects,_tmpPlayMode,_tmpShuffleEnabled,_tmpCrossfadeDuration,_tmpLearningMode,_tmpRepeatDifficultParts,_tmpShowSubtitles,_tmpVocabularyHighlight,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastLoginAt,_tmpTotalPlayTime,_tmpStoriesCompleted,_tmpFavoritesCount,_tmpCustomSettings);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object exists(final String userId, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM user_settings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<UserSettings>> $completion) {
    final String _sql = "SELECT `user_settings`.`userId` AS `userId`, `user_settings`.`childName` AS `childName`, `user_settings`.`childAge` AS `childAge`, `user_settings`.`childGender` AS `childGender`, `user_settings`.`childAvatar` AS `childAvatar`, `user_settings`.`defaultVolume` AS `defaultVolume`, `user_settings`.`defaultPlaybackSpeed` AS `defaultPlaybackSpeed`, `user_settings`.`defaultVoiceType` AS `defaultVoiceType`, `user_settings`.`backgroundPlay` AS `backgroundPlay`, `user_settings`.`autoPlayNext` AS `autoPlayNext`, `user_settings`.`sleepTimerEnabled` AS `sleepTimerEnabled`, `user_settings`.`sleepTimerDuration` AS `sleepTimerDuration`, `user_settings`.`dailyLimitEnabled` AS `dailyLimitEnabled`, `user_settings`.`dailyLimitDuration` AS `dailyLimitDuration`, `user_settings`.`theme` AS `theme`, `user_settings`.`fontSize` AS `fontSize`, `user_settings`.`eyeProtectionMode` AS `eyeProtectionMode`, `user_settings`.`animationEnabled` AS `animationEnabled`, `user_settings`.`contentFilterLevel` AS `contentFilterLevel`, `user_settings`.`blockedCategories` AS `blockedCategories`, `user_settings`.`blockedTags` AS `blockedTags`, `user_settings`.`ageRestriction` AS `ageRestriction`, `user_settings`.`parentalControlEnabled` AS `parentalControlEnabled`, `user_settings`.`purchaseLock` AS `purchaseLock`, `user_settings`.`dataCollectionAllowed` AS `dataCollectionAllowed`, `user_settings`.`analyticsEnabled` AS `analyticsEnabled`, `user_settings`.`notificationsEnabled` AS `notificationsEnabled`, `user_settings`.`reminderNotifications` AS `reminderNotifications`, `user_settings`.`updateNotifications` AS `updateNotifications`, `user_settings`.`promotionalNotifications` AS `promotionalNotifications`, `user_settings`.`autoDownloadFavorites` AS `autoDownloadFavorites`, `user_settings`.`storageLocation` AS `storageLocation`, `user_settings`.`cacheSizeLimit` AS `cacheSizeLimit`, `user_settings`.`autoClearCache` AS `autoClearCache`, `user_settings`.`wifiOnlyDownload` AS `wifiOnlyDownload`, `user_settings`.`dataSaverMode` AS `dataSaverMode`, `user_settings`.`syncEnabled` AS `syncEnabled`, `user_settings`.`backgroundMusic` AS `backgroundMusic`, `user_settings`.`backgroundMusicType` AS `backgroundMusicType`, `user_settings`.`backgroundMusicVolume` AS `backgroundMusicVolume`, `user_settings`.`soundEffects` AS `soundEffects`, `user_settings`.`playMode` AS `playMode`, `user_settings`.`shuffleEnabled` AS `shuffleEnabled`, `user_settings`.`crossfadeDuration` AS `crossfadeDuration`, `user_settings`.`learningMode` AS `learningMode`, `user_settings`.`repeatDifficultParts` AS `repeatDifficultParts`, `user_settings`.`showSubtitles` AS `showSubtitles`, `user_settings`.`vocabularyHighlight` AS `vocabularyHighlight`, `user_settings`.`createdAt` AS `createdAt`, `user_settings`.`updatedAt` AS `updatedAt`, `user_settings`.`lastLoginAt` AS `lastLoginAt`, `user_settings`.`totalPlayTime` AS `totalPlayTime`, `user_settings`.`storiesCompleted` AS `storiesCompleted`, `user_settings`.`favoritesCount` AS `favoritesCount`, `user_settings`.`customSettings` AS `customSettings` FROM user_settings";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UserSettings>>() {
      @Override
      @NonNull
      public List<UserSettings> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserId = 0;
          final int _cursorIndexOfChildName = 1;
          final int _cursorIndexOfChildAge = 2;
          final int _cursorIndexOfChildGender = 3;
          final int _cursorIndexOfChildAvatar = 4;
          final int _cursorIndexOfDefaultVolume = 5;
          final int _cursorIndexOfDefaultPlaybackSpeed = 6;
          final int _cursorIndexOfDefaultVoiceType = 7;
          final int _cursorIndexOfBackgroundPlay = 8;
          final int _cursorIndexOfAutoPlayNext = 9;
          final int _cursorIndexOfSleepTimerEnabled = 10;
          final int _cursorIndexOfSleepTimerDuration = 11;
          final int _cursorIndexOfDailyLimitEnabled = 12;
          final int _cursorIndexOfDailyLimitDuration = 13;
          final int _cursorIndexOfTheme = 14;
          final int _cursorIndexOfFontSize = 15;
          final int _cursorIndexOfEyeProtectionMode = 16;
          final int _cursorIndexOfAnimationEnabled = 17;
          final int _cursorIndexOfContentFilterLevel = 18;
          final int _cursorIndexOfBlockedCategories = 19;
          final int _cursorIndexOfBlockedTags = 20;
          final int _cursorIndexOfAgeRestriction = 21;
          final int _cursorIndexOfParentalControlEnabled = 22;
          final int _cursorIndexOfPurchaseLock = 23;
          final int _cursorIndexOfDataCollectionAllowed = 24;
          final int _cursorIndexOfAnalyticsEnabled = 25;
          final int _cursorIndexOfNotificationsEnabled = 26;
          final int _cursorIndexOfReminderNotifications = 27;
          final int _cursorIndexOfUpdateNotifications = 28;
          final int _cursorIndexOfPromotionalNotifications = 29;
          final int _cursorIndexOfAutoDownloadFavorites = 30;
          final int _cursorIndexOfStorageLocation = 31;
          final int _cursorIndexOfCacheSizeLimit = 32;
          final int _cursorIndexOfAutoClearCache = 33;
          final int _cursorIndexOfWifiOnlyDownload = 34;
          final int _cursorIndexOfDataSaverMode = 35;
          final int _cursorIndexOfSyncEnabled = 36;
          final int _cursorIndexOfBackgroundMusic = 37;
          final int _cursorIndexOfBackgroundMusicType = 38;
          final int _cursorIndexOfBackgroundMusicVolume = 39;
          final int _cursorIndexOfSoundEffects = 40;
          final int _cursorIndexOfPlayMode = 41;
          final int _cursorIndexOfShuffleEnabled = 42;
          final int _cursorIndexOfCrossfadeDuration = 43;
          final int _cursorIndexOfLearningMode = 44;
          final int _cursorIndexOfRepeatDifficultParts = 45;
          final int _cursorIndexOfShowSubtitles = 46;
          final int _cursorIndexOfVocabularyHighlight = 47;
          final int _cursorIndexOfCreatedAt = 48;
          final int _cursorIndexOfUpdatedAt = 49;
          final int _cursorIndexOfLastLoginAt = 50;
          final int _cursorIndexOfTotalPlayTime = 51;
          final int _cursorIndexOfStoriesCompleted = 52;
          final int _cursorIndexOfFavoritesCount = 53;
          final int _cursorIndexOfCustomSettings = 54;
          final List<UserSettings> _result = new ArrayList<UserSettings>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UserSettings _item;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpChildName;
            if (_cursor.isNull(_cursorIndexOfChildName)) {
              _tmpChildName = null;
            } else {
              _tmpChildName = _cursor.getString(_cursorIndexOfChildName);
            }
            final int _tmpChildAge;
            _tmpChildAge = _cursor.getInt(_cursorIndexOfChildAge);
            final String _tmpChildGender;
            if (_cursor.isNull(_cursorIndexOfChildGender)) {
              _tmpChildGender = null;
            } else {
              _tmpChildGender = _cursor.getString(_cursorIndexOfChildGender);
            }
            final String _tmpChildAvatar;
            if (_cursor.isNull(_cursorIndexOfChildAvatar)) {
              _tmpChildAvatar = null;
            } else {
              _tmpChildAvatar = _cursor.getString(_cursorIndexOfChildAvatar);
            }
            final float _tmpDefaultVolume;
            _tmpDefaultVolume = _cursor.getFloat(_cursorIndexOfDefaultVolume);
            final float _tmpDefaultPlaybackSpeed;
            _tmpDefaultPlaybackSpeed = _cursor.getFloat(_cursorIndexOfDefaultPlaybackSpeed);
            final String _tmpDefaultVoiceType;
            if (_cursor.isNull(_cursorIndexOfDefaultVoiceType)) {
              _tmpDefaultVoiceType = null;
            } else {
              _tmpDefaultVoiceType = _cursor.getString(_cursorIndexOfDefaultVoiceType);
            }
            final boolean _tmpBackgroundPlay;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfBackgroundPlay);
            _tmpBackgroundPlay = _tmp != 0;
            final boolean _tmpAutoPlayNext;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAutoPlayNext);
            _tmpAutoPlayNext = _tmp_1 != 0;
            final boolean _tmpSleepTimerEnabled;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfSleepTimerEnabled);
            _tmpSleepTimerEnabled = _tmp_2 != 0;
            final long _tmpSleepTimerDuration;
            _tmpSleepTimerDuration = _cursor.getLong(_cursorIndexOfSleepTimerDuration);
            final boolean _tmpDailyLimitEnabled;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfDailyLimitEnabled);
            _tmpDailyLimitEnabled = _tmp_3 != 0;
            final long _tmpDailyLimitDuration;
            _tmpDailyLimitDuration = _cursor.getLong(_cursorIndexOfDailyLimitDuration);
            final String _tmpTheme;
            if (_cursor.isNull(_cursorIndexOfTheme)) {
              _tmpTheme = null;
            } else {
              _tmpTheme = _cursor.getString(_cursorIndexOfTheme);
            }
            final String _tmpFontSize;
            if (_cursor.isNull(_cursorIndexOfFontSize)) {
              _tmpFontSize = null;
            } else {
              _tmpFontSize = _cursor.getString(_cursorIndexOfFontSize);
            }
            final boolean _tmpEyeProtectionMode;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfEyeProtectionMode);
            _tmpEyeProtectionMode = _tmp_4 != 0;
            final boolean _tmpAnimationEnabled;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfAnimationEnabled);
            _tmpAnimationEnabled = _tmp_5 != 0;
            final String _tmpContentFilterLevel;
            if (_cursor.isNull(_cursorIndexOfContentFilterLevel)) {
              _tmpContentFilterLevel = null;
            } else {
              _tmpContentFilterLevel = _cursor.getString(_cursorIndexOfContentFilterLevel);
            }
            final List<String> _tmpBlockedCategories;
            final String _tmp_6;
            if (_cursor.isNull(_cursorIndexOfBlockedCategories)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getString(_cursorIndexOfBlockedCategories);
            }
            _tmpBlockedCategories = __listConverter.fromString(_tmp_6);
            final List<String> _tmpBlockedTags;
            final String _tmp_7;
            if (_cursor.isNull(_cursorIndexOfBlockedTags)) {
              _tmp_7 = null;
            } else {
              _tmp_7 = _cursor.getString(_cursorIndexOfBlockedTags);
            }
            _tmpBlockedTags = __listConverter.fromString(_tmp_7);
            final boolean _tmpAgeRestriction;
            final int _tmp_8;
            _tmp_8 = _cursor.getInt(_cursorIndexOfAgeRestriction);
            _tmpAgeRestriction = _tmp_8 != 0;
            final boolean _tmpParentalControlEnabled;
            final int _tmp_9;
            _tmp_9 = _cursor.getInt(_cursorIndexOfParentalControlEnabled);
            _tmpParentalControlEnabled = _tmp_9 != 0;
            final boolean _tmpPurchaseLock;
            final int _tmp_10;
            _tmp_10 = _cursor.getInt(_cursorIndexOfPurchaseLock);
            _tmpPurchaseLock = _tmp_10 != 0;
            final boolean _tmpDataCollectionAllowed;
            final int _tmp_11;
            _tmp_11 = _cursor.getInt(_cursorIndexOfDataCollectionAllowed);
            _tmpDataCollectionAllowed = _tmp_11 != 0;
            final boolean _tmpAnalyticsEnabled;
            final int _tmp_12;
            _tmp_12 = _cursor.getInt(_cursorIndexOfAnalyticsEnabled);
            _tmpAnalyticsEnabled = _tmp_12 != 0;
            final boolean _tmpNotificationsEnabled;
            final int _tmp_13;
            _tmp_13 = _cursor.getInt(_cursorIndexOfNotificationsEnabled);
            _tmpNotificationsEnabled = _tmp_13 != 0;
            final boolean _tmpReminderNotifications;
            final int _tmp_14;
            _tmp_14 = _cursor.getInt(_cursorIndexOfReminderNotifications);
            _tmpReminderNotifications = _tmp_14 != 0;
            final boolean _tmpUpdateNotifications;
            final int _tmp_15;
            _tmp_15 = _cursor.getInt(_cursorIndexOfUpdateNotifications);
            _tmpUpdateNotifications = _tmp_15 != 0;
            final boolean _tmpPromotionalNotifications;
            final int _tmp_16;
            _tmp_16 = _cursor.getInt(_cursorIndexOfPromotionalNotifications);
            _tmpPromotionalNotifications = _tmp_16 != 0;
            final boolean _tmpAutoDownloadFavorites;
            final int _tmp_17;
            _tmp_17 = _cursor.getInt(_cursorIndexOfAutoDownloadFavorites);
            _tmpAutoDownloadFavorites = _tmp_17 != 0;
            final String _tmpStorageLocation;
            if (_cursor.isNull(_cursorIndexOfStorageLocation)) {
              _tmpStorageLocation = null;
            } else {
              _tmpStorageLocation = _cursor.getString(_cursorIndexOfStorageLocation);
            }
            final long _tmpCacheSizeLimit;
            _tmpCacheSizeLimit = _cursor.getLong(_cursorIndexOfCacheSizeLimit);
            final boolean _tmpAutoClearCache;
            final int _tmp_18;
            _tmp_18 = _cursor.getInt(_cursorIndexOfAutoClearCache);
            _tmpAutoClearCache = _tmp_18 != 0;
            final boolean _tmpWifiOnlyDownload;
            final int _tmp_19;
            _tmp_19 = _cursor.getInt(_cursorIndexOfWifiOnlyDownload);
            _tmpWifiOnlyDownload = _tmp_19 != 0;
            final boolean _tmpDataSaverMode;
            final int _tmp_20;
            _tmp_20 = _cursor.getInt(_cursorIndexOfDataSaverMode);
            _tmpDataSaverMode = _tmp_20 != 0;
            final boolean _tmpSyncEnabled;
            final int _tmp_21;
            _tmp_21 = _cursor.getInt(_cursorIndexOfSyncEnabled);
            _tmpSyncEnabled = _tmp_21 != 0;
            final boolean _tmpBackgroundMusic;
            final int _tmp_22;
            _tmp_22 = _cursor.getInt(_cursorIndexOfBackgroundMusic);
            _tmpBackgroundMusic = _tmp_22 != 0;
            final String _tmpBackgroundMusicType;
            if (_cursor.isNull(_cursorIndexOfBackgroundMusicType)) {
              _tmpBackgroundMusicType = null;
            } else {
              _tmpBackgroundMusicType = _cursor.getString(_cursorIndexOfBackgroundMusicType);
            }
            final float _tmpBackgroundMusicVolume;
            _tmpBackgroundMusicVolume = _cursor.getFloat(_cursorIndexOfBackgroundMusicVolume);
            final boolean _tmpSoundEffects;
            final int _tmp_23;
            _tmp_23 = _cursor.getInt(_cursorIndexOfSoundEffects);
            _tmpSoundEffects = _tmp_23 != 0;
            final String _tmpPlayMode;
            if (_cursor.isNull(_cursorIndexOfPlayMode)) {
              _tmpPlayMode = null;
            } else {
              _tmpPlayMode = _cursor.getString(_cursorIndexOfPlayMode);
            }
            final boolean _tmpShuffleEnabled;
            final int _tmp_24;
            _tmp_24 = _cursor.getInt(_cursorIndexOfShuffleEnabled);
            _tmpShuffleEnabled = _tmp_24 != 0;
            final long _tmpCrossfadeDuration;
            _tmpCrossfadeDuration = _cursor.getLong(_cursorIndexOfCrossfadeDuration);
            final boolean _tmpLearningMode;
            final int _tmp_25;
            _tmp_25 = _cursor.getInt(_cursorIndexOfLearningMode);
            _tmpLearningMode = _tmp_25 != 0;
            final boolean _tmpRepeatDifficultParts;
            final int _tmp_26;
            _tmp_26 = _cursor.getInt(_cursorIndexOfRepeatDifficultParts);
            _tmpRepeatDifficultParts = _tmp_26 != 0;
            final boolean _tmpShowSubtitles;
            final int _tmp_27;
            _tmp_27 = _cursor.getInt(_cursorIndexOfShowSubtitles);
            _tmpShowSubtitles = _tmp_27 != 0;
            final boolean _tmpVocabularyHighlight;
            final int _tmp_28;
            _tmp_28 = _cursor.getInt(_cursorIndexOfVocabularyHighlight);
            _tmpVocabularyHighlight = _tmp_28 != 0;
            final Date _tmpCreatedAt;
            final Long _tmp_29;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_29 = null;
            } else {
              _tmp_29 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_29);
            final Date _tmpUpdatedAt;
            final Long _tmp_30;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_30 = null;
            } else {
              _tmp_30 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_30);
            final Date _tmpLastLoginAt;
            final Long _tmp_31;
            if (_cursor.isNull(_cursorIndexOfLastLoginAt)) {
              _tmp_31 = null;
            } else {
              _tmp_31 = _cursor.getLong(_cursorIndexOfLastLoginAt);
            }
            _tmpLastLoginAt = __dateConverter.fromTimestamp(_tmp_31);
            final long _tmpTotalPlayTime;
            _tmpTotalPlayTime = _cursor.getLong(_cursorIndexOfTotalPlayTime);
            final int _tmpStoriesCompleted;
            _tmpStoriesCompleted = _cursor.getInt(_cursorIndexOfStoriesCompleted);
            final int _tmpFavoritesCount;
            _tmpFavoritesCount = _cursor.getInt(_cursorIndexOfFavoritesCount);
            final Map<String, String> _tmpCustomSettings;
            final String _tmp_32;
            if (_cursor.isNull(_cursorIndexOfCustomSettings)) {
              _tmp_32 = null;
            } else {
              _tmp_32 = _cursor.getString(_cursorIndexOfCustomSettings);
            }
            _tmpCustomSettings = __mapConverter.fromString(_tmp_32);
            _item = new UserSettings(_tmpUserId,_tmpChildName,_tmpChildAge,_tmpChildGender,_tmpChildAvatar,_tmpDefaultVolume,_tmpDefaultPlaybackSpeed,_tmpDefaultVoiceType,_tmpBackgroundPlay,_tmpAutoPlayNext,_tmpSleepTimerEnabled,_tmpSleepTimerDuration,_tmpDailyLimitEnabled,_tmpDailyLimitDuration,_tmpTheme,_tmpFontSize,_tmpEyeProtectionMode,_tmpAnimationEnabled,_tmpContentFilterLevel,_tmpBlockedCategories,_tmpBlockedTags,_tmpAgeRestriction,_tmpParentalControlEnabled,_tmpPurchaseLock,_tmpDataCollectionAllowed,_tmpAnalyticsEnabled,_tmpNotificationsEnabled,_tmpReminderNotifications,_tmpUpdateNotifications,_tmpPromotionalNotifications,_tmpAutoDownloadFavorites,_tmpStorageLocation,_tmpCacheSizeLimit,_tmpAutoClearCache,_tmpWifiOnlyDownload,_tmpDataSaverMode,_tmpSyncEnabled,_tmpBackgroundMusic,_tmpBackgroundMusicType,_tmpBackgroundMusicVolume,_tmpSoundEffects,_tmpPlayMode,_tmpShuffleEnabled,_tmpCrossfadeDuration,_tmpLearningMode,_tmpRepeatDifficultParts,_tmpShowSubtitles,_tmpVocabularyHighlight,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastLoginAt,_tmpTotalPlayTime,_tmpStoriesCompleted,_tmpFavoritesCount,_tmpCustomSettings);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM user_settings";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object isParentalControlEnabled(final String userId,
      final Continuation<? super Boolean> $completion) {
    final String _sql = "SELECT parentalControlEnabled FROM user_settings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      @Nullable
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object isDailyLimitEnabled(final String userId,
      final Continuation<? super Boolean> $completion) {
    final String _sql = "SELECT dailyLimitEnabled FROM user_settings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      @Nullable
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getRemainingPlayTimeToday(final String userId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT dailyLimitDuration - COALESCE((SELECT SUM(duration) FROM play_history WHERE userId = ? AND date(playedAt/1000, 'unixepoch') = date('now')), 0) as remainingTime FROM user_settings WHERE userId = ? AND dailyLimitEnabled = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
