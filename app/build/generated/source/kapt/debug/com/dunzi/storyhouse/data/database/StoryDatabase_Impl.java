package com.dunzi.storyhouse.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.dunzi.storyhouse.data.dao.PlayHistoryDao;
import com.dunzi.storyhouse.data.dao.PlayHistoryDao_Impl;
import com.dunzi.storyhouse.data.dao.StoryDao;
import com.dunzi.storyhouse.data.dao.StoryDao_Impl;
import com.dunzi.storyhouse.data.dao.UserSettingsDao;
import com.dunzi.storyhouse.data.dao.UserSettingsDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StoryDatabase_Impl extends StoryDatabase {
  private volatile StoryDao _storyDao;

  private volatile PlayHistoryDao _playHistoryDao;

  private volatile UserSettingsDao _userSettingsDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `stories` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `author` TEXT NOT NULL, `description` TEXT NOT NULL, `coverImage` TEXT NOT NULL, `category` TEXT NOT NULL, `subCategory` TEXT NOT NULL, `tags` TEXT NOT NULL, `contentPath` TEXT NOT NULL, `audioPath` TEXT NOT NULL, `duration` INTEGER NOT NULL, `wordCount` INTEGER NOT NULL, `minAge` INTEGER NOT NULL, `maxAge` INTEGER NOT NULL, `language` TEXT NOT NULL, `source` TEXT NOT NULL, `format` TEXT NOT NULL, `playCount` INTEGER NOT NULL, `favoriteCount` INTEGER NOT NULL, `rating` REAL NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `lastPlayedAt` INTEGER, `isFavorite` INTEGER NOT NULL, `isDownloaded` INTEGER NOT NULL, `isCompleted` INTEGER NOT NULL, `isHidden` INTEGER NOT NULL, `lastPosition` INTEGER NOT NULL, `progress` REAL NOT NULL, `metadata` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `play_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `storyId` INTEGER NOT NULL, `userId` TEXT NOT NULL, `startPosition` INTEGER NOT NULL, `endPosition` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `completed` INTEGER NOT NULL, `playbackSpeed` REAL NOT NULL, `volume` REAL NOT NULL, `voiceType` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `deviceName` TEXT NOT NULL, `playedAt` INTEGER NOT NULL, `finishedAt` INTEGER, `interruptions` INTEGER NOT NULL, `skips` INTEGER NOT NULL, `rewinds` INTEGER NOT NULL, `sessionId` TEXT NOT NULL, `metadata` TEXT NOT NULL, FOREIGN KEY(`storyId`) REFERENCES `stories`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_play_history_storyId` ON `play_history` (`storyId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_play_history_userId` ON `play_history` (`userId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_play_history_playedAt` ON `play_history` (`playedAt`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_settings` (`userId` TEXT NOT NULL, `childName` TEXT NOT NULL, `childAge` INTEGER NOT NULL, `childGender` TEXT NOT NULL, `childAvatar` TEXT NOT NULL, `defaultVolume` REAL NOT NULL, `defaultPlaybackSpeed` REAL NOT NULL, `defaultVoiceType` TEXT NOT NULL, `backgroundPlay` INTEGER NOT NULL, `autoPlayNext` INTEGER NOT NULL, `sleepTimerEnabled` INTEGER NOT NULL, `sleepTimerDuration` INTEGER NOT NULL, `dailyLimitEnabled` INTEGER NOT NULL, `dailyLimitDuration` INTEGER NOT NULL, `theme` TEXT NOT NULL, `fontSize` TEXT NOT NULL, `eyeProtectionMode` INTEGER NOT NULL, `animationEnabled` INTEGER NOT NULL, `contentFilterLevel` TEXT NOT NULL, `blockedCategories` TEXT NOT NULL, `blockedTags` TEXT NOT NULL, `ageRestriction` INTEGER NOT NULL, `parentalControlEnabled` INTEGER NOT NULL, `purchaseLock` INTEGER NOT NULL, `dataCollectionAllowed` INTEGER NOT NULL, `analyticsEnabled` INTEGER NOT NULL, `notificationsEnabled` INTEGER NOT NULL, `reminderNotifications` INTEGER NOT NULL, `updateNotifications` INTEGER NOT NULL, `promotionalNotifications` INTEGER NOT NULL, `autoDownloadFavorites` INTEGER NOT NULL, `storageLocation` TEXT NOT NULL, `cacheSizeLimit` INTEGER NOT NULL, `autoClearCache` INTEGER NOT NULL, `wifiOnlyDownload` INTEGER NOT NULL, `dataSaverMode` INTEGER NOT NULL, `syncEnabled` INTEGER NOT NULL, `backgroundMusic` INTEGER NOT NULL, `backgroundMusicType` TEXT NOT NULL, `backgroundMusicVolume` REAL NOT NULL, `soundEffects` INTEGER NOT NULL, `playMode` TEXT NOT NULL, `shuffleEnabled` INTEGER NOT NULL, `crossfadeDuration` INTEGER NOT NULL, `learningMode` INTEGER NOT NULL, `repeatDifficultParts` INTEGER NOT NULL, `showSubtitles` INTEGER NOT NULL, `vocabularyHighlight` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `lastLoginAt` INTEGER, `totalPlayTime` INTEGER NOT NULL, `storiesCompleted` INTEGER NOT NULL, `favoritesCount` INTEGER NOT NULL, `customSettings` TEXT NOT NULL, PRIMARY KEY(`userId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4bacb4bb2e84b84c3e315276f6c3dd3d')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `stories`");
        db.execSQL("DROP TABLE IF EXISTS `play_history`");
        db.execSQL("DROP TABLE IF EXISTS `user_settings`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsStories = new HashMap<String, TableInfo.Column>(30);
        _columnsStories.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("coverImage", new TableInfo.Column("coverImage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("subCategory", new TableInfo.Column("subCategory", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("contentPath", new TableInfo.Column("contentPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("audioPath", new TableInfo.Column("audioPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("wordCount", new TableInfo.Column("wordCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("minAge", new TableInfo.Column("minAge", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("maxAge", new TableInfo.Column("maxAge", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("format", new TableInfo.Column("format", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("playCount", new TableInfo.Column("playCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("favoriteCount", new TableInfo.Column("favoriteCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("lastPlayedAt", new TableInfo.Column("lastPlayedAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("isDownloaded", new TableInfo.Column("isDownloaded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("isHidden", new TableInfo.Column("isHidden", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("lastPosition", new TableInfo.Column("lastPosition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("progress", new TableInfo.Column("progress", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStories.put("metadata", new TableInfo.Column("metadata", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStories = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStories = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStories = new TableInfo("stories", _columnsStories, _foreignKeysStories, _indicesStories);
        final TableInfo _existingStories = TableInfo.read(db, "stories");
        if (!_infoStories.equals(_existingStories)) {
          return new RoomOpenHelper.ValidationResult(false, "stories(com.dunzi.storyhouse.data.model.Story).\n"
                  + " Expected:\n" + _infoStories + "\n"
                  + " Found:\n" + _existingStories);
        }
        final HashMap<String, TableInfo.Column> _columnsPlayHistory = new HashMap<String, TableInfo.Column>(19);
        _columnsPlayHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("storyId", new TableInfo.Column("storyId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("startPosition", new TableInfo.Column("startPosition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("endPosition", new TableInfo.Column("endPosition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("playbackSpeed", new TableInfo.Column("playbackSpeed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("volume", new TableInfo.Column("volume", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("voiceType", new TableInfo.Column("voiceType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("deviceName", new TableInfo.Column("deviceName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("playedAt", new TableInfo.Column("playedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("finishedAt", new TableInfo.Column("finishedAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("interruptions", new TableInfo.Column("interruptions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("skips", new TableInfo.Column("skips", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("rewinds", new TableInfo.Column("rewinds", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("sessionId", new TableInfo.Column("sessionId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayHistory.put("metadata", new TableInfo.Column("metadata", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlayHistory = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPlayHistory.add(new TableInfo.ForeignKey("stories", "CASCADE", "NO ACTION", Arrays.asList("storyId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPlayHistory = new HashSet<TableInfo.Index>(3);
        _indicesPlayHistory.add(new TableInfo.Index("index_play_history_storyId", false, Arrays.asList("storyId"), Arrays.asList("ASC")));
        _indicesPlayHistory.add(new TableInfo.Index("index_play_history_userId", false, Arrays.asList("userId"), Arrays.asList("ASC")));
        _indicesPlayHistory.add(new TableInfo.Index("index_play_history_playedAt", false, Arrays.asList("playedAt"), Arrays.asList("ASC")));
        final TableInfo _infoPlayHistory = new TableInfo("play_history", _columnsPlayHistory, _foreignKeysPlayHistory, _indicesPlayHistory);
        final TableInfo _existingPlayHistory = TableInfo.read(db, "play_history");
        if (!_infoPlayHistory.equals(_existingPlayHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "play_history(com.dunzi.storyhouse.data.model.PlayHistory).\n"
                  + " Expected:\n" + _infoPlayHistory + "\n"
                  + " Found:\n" + _existingPlayHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsUserSettings = new HashMap<String, TableInfo.Column>(55);
        _columnsUserSettings.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("childName", new TableInfo.Column("childName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("childAge", new TableInfo.Column("childAge", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("childGender", new TableInfo.Column("childGender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("childAvatar", new TableInfo.Column("childAvatar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("defaultVolume", new TableInfo.Column("defaultVolume", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("defaultPlaybackSpeed", new TableInfo.Column("defaultPlaybackSpeed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("defaultVoiceType", new TableInfo.Column("defaultVoiceType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("backgroundPlay", new TableInfo.Column("backgroundPlay", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("autoPlayNext", new TableInfo.Column("autoPlayNext", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("sleepTimerEnabled", new TableInfo.Column("sleepTimerEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("sleepTimerDuration", new TableInfo.Column("sleepTimerDuration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("dailyLimitEnabled", new TableInfo.Column("dailyLimitEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("dailyLimitDuration", new TableInfo.Column("dailyLimitDuration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("theme", new TableInfo.Column("theme", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("fontSize", new TableInfo.Column("fontSize", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("eyeProtectionMode", new TableInfo.Column("eyeProtectionMode", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("animationEnabled", new TableInfo.Column("animationEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("contentFilterLevel", new TableInfo.Column("contentFilterLevel", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("blockedCategories", new TableInfo.Column("blockedCategories", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("blockedTags", new TableInfo.Column("blockedTags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("ageRestriction", new TableInfo.Column("ageRestriction", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("parentalControlEnabled", new TableInfo.Column("parentalControlEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("purchaseLock", new TableInfo.Column("purchaseLock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("dataCollectionAllowed", new TableInfo.Column("dataCollectionAllowed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("analyticsEnabled", new TableInfo.Column("analyticsEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("notificationsEnabled", new TableInfo.Column("notificationsEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("reminderNotifications", new TableInfo.Column("reminderNotifications", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("updateNotifications", new TableInfo.Column("updateNotifications", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("promotionalNotifications", new TableInfo.Column("promotionalNotifications", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("autoDownloadFavorites", new TableInfo.Column("autoDownloadFavorites", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("storageLocation", new TableInfo.Column("storageLocation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("cacheSizeLimit", new TableInfo.Column("cacheSizeLimit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("autoClearCache", new TableInfo.Column("autoClearCache", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("wifiOnlyDownload", new TableInfo.Column("wifiOnlyDownload", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("dataSaverMode", new TableInfo.Column("dataSaverMode", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("syncEnabled", new TableInfo.Column("syncEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("backgroundMusic", new TableInfo.Column("backgroundMusic", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("backgroundMusicType", new TableInfo.Column("backgroundMusicType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("backgroundMusicVolume", new TableInfo.Column("backgroundMusicVolume", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("soundEffects", new TableInfo.Column("soundEffects", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("playMode", new TableInfo.Column("playMode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("shuffleEnabled", new TableInfo.Column("shuffleEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("crossfadeDuration", new TableInfo.Column("crossfadeDuration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("learningMode", new TableInfo.Column("learningMode", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("repeatDifficultParts", new TableInfo.Column("repeatDifficultParts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("showSubtitles", new TableInfo.Column("showSubtitles", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("vocabularyHighlight", new TableInfo.Column("vocabularyHighlight", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("lastLoginAt", new TableInfo.Column("lastLoginAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("totalPlayTime", new TableInfo.Column("totalPlayTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("storiesCompleted", new TableInfo.Column("storiesCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("favoritesCount", new TableInfo.Column("favoritesCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("customSettings", new TableInfo.Column("customSettings", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserSettings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserSettings = new TableInfo("user_settings", _columnsUserSettings, _foreignKeysUserSettings, _indicesUserSettings);
        final TableInfo _existingUserSettings = TableInfo.read(db, "user_settings");
        if (!_infoUserSettings.equals(_existingUserSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "user_settings(com.dunzi.storyhouse.data.model.UserSettings).\n"
                  + " Expected:\n" + _infoUserSettings + "\n"
                  + " Found:\n" + _existingUserSettings);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4bacb4bb2e84b84c3e315276f6c3dd3d", "4c68655d618f71e04ba84cf74847b343");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "stories","play_history","user_settings");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `stories`");
      _db.execSQL("DELETE FROM `play_history`");
      _db.execSQL("DELETE FROM `user_settings`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(StoryDao.class, StoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PlayHistoryDao.class, PlayHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserSettingsDao.class, UserSettingsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public StoryDao storyDao() {
    if (_storyDao != null) {
      return _storyDao;
    } else {
      synchronized(this) {
        if(_storyDao == null) {
          _storyDao = new StoryDao_Impl(this);
        }
        return _storyDao;
      }
    }
  }

  @Override
  public PlayHistoryDao playHistoryDao() {
    if (_playHistoryDao != null) {
      return _playHistoryDao;
    } else {
      synchronized(this) {
        if(_playHistoryDao == null) {
          _playHistoryDao = new PlayHistoryDao_Impl(this);
        }
        return _playHistoryDao;
      }
    }
  }

  @Override
  public UserSettingsDao userSettingsDao() {
    if (_userSettingsDao != null) {
      return _userSettingsDao;
    } else {
      synchronized(this) {
        if(_userSettingsDao == null) {
          _userSettingsDao = new UserSettingsDao_Impl(this);
        }
        return _userSettingsDao;
      }
    }
  }
}
