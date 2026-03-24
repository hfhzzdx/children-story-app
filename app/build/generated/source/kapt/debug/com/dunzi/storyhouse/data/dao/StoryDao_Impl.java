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
import com.dunzi.storyhouse.data.model.Story;
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
public final class StoryDao_Impl implements StoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Story> __insertionAdapterOfStory;

  private final ListConverter __listConverter = new ListConverter();

  private final DateConverter __dateConverter = new DateConverter();

  private final MapConverter __mapConverter = new MapConverter();

  private final EntityDeletionOrUpdateAdapter<Story> __deletionAdapterOfStory;

  private final EntityDeletionOrUpdateAdapter<Story> __updateAdapterOfStory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfIncrementPlayCount;

  private final SharedSQLiteStatement __preparedStmtOfAddToFavorites;

  private final SharedSQLiteStatement __preparedStmtOfRemoveFromFavorites;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePlayProgress;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsCompleted;

  public StoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStory = new EntityInsertionAdapter<Story>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `stories` (`id`,`title`,`author`,`description`,`coverImage`,`category`,`subCategory`,`tags`,`contentPath`,`audioPath`,`duration`,`wordCount`,`minAge`,`maxAge`,`language`,`source`,`format`,`playCount`,`favoriteCount`,`rating`,`createdAt`,`updatedAt`,`lastPlayedAt`,`isFavorite`,`isDownloaded`,`isCompleted`,`isHidden`,`lastPosition`,`progress`,`metadata`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Story entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuthor());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getCoverImage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCoverImage());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCategory());
        }
        if (entity.getSubCategory() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSubCategory());
        }
        final String _tmp = __listConverter.toString(entity.getTags());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp);
        }
        if (entity.getContentPath() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getContentPath());
        }
        if (entity.getAudioPath() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getAudioPath());
        }
        statement.bindLong(11, entity.getDuration());
        statement.bindLong(12, entity.getWordCount());
        statement.bindLong(13, entity.getMinAge());
        statement.bindLong(14, entity.getMaxAge());
        if (entity.getLanguage() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getLanguage());
        }
        if (entity.getSource() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getSource());
        }
        if (entity.getFormat() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getFormat());
        }
        statement.bindLong(18, entity.getPlayCount());
        statement.bindLong(19, entity.getFavoriteCount());
        statement.bindDouble(20, entity.getRating());
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp_1 == null) {
          statement.bindNull(21);
        } else {
          statement.bindLong(21, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getUpdatedAt());
        if (_tmp_2 == null) {
          statement.bindNull(22);
        } else {
          statement.bindLong(22, _tmp_2);
        }
        final Long _tmp_3 = __dateConverter.dateToTimestamp(entity.getLastPlayedAt());
        if (_tmp_3 == null) {
          statement.bindNull(23);
        } else {
          statement.bindLong(23, _tmp_3);
        }
        final int _tmp_4 = entity.isFavorite() ? 1 : 0;
        statement.bindLong(24, _tmp_4);
        final int _tmp_5 = entity.isDownloaded() ? 1 : 0;
        statement.bindLong(25, _tmp_5);
        final int _tmp_6 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(26, _tmp_6);
        final int _tmp_7 = entity.isHidden() ? 1 : 0;
        statement.bindLong(27, _tmp_7);
        statement.bindLong(28, entity.getLastPosition());
        statement.bindDouble(29, entity.getProgress());
        final String _tmp_8 = __mapConverter.toString(entity.getMetadata());
        if (_tmp_8 == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, _tmp_8);
        }
      }
    };
    this.__deletionAdapterOfStory = new EntityDeletionOrUpdateAdapter<Story>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `stories` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Story entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfStory = new EntityDeletionOrUpdateAdapter<Story>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `stories` SET `id` = ?,`title` = ?,`author` = ?,`description` = ?,`coverImage` = ?,`category` = ?,`subCategory` = ?,`tags` = ?,`contentPath` = ?,`audioPath` = ?,`duration` = ?,`wordCount` = ?,`minAge` = ?,`maxAge` = ?,`language` = ?,`source` = ?,`format` = ?,`playCount` = ?,`favoriteCount` = ?,`rating` = ?,`createdAt` = ?,`updatedAt` = ?,`lastPlayedAt` = ?,`isFavorite` = ?,`isDownloaded` = ?,`isCompleted` = ?,`isHidden` = ?,`lastPosition` = ?,`progress` = ?,`metadata` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Story entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuthor());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getCoverImage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCoverImage());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCategory());
        }
        if (entity.getSubCategory() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSubCategory());
        }
        final String _tmp = __listConverter.toString(entity.getTags());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp);
        }
        if (entity.getContentPath() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getContentPath());
        }
        if (entity.getAudioPath() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getAudioPath());
        }
        statement.bindLong(11, entity.getDuration());
        statement.bindLong(12, entity.getWordCount());
        statement.bindLong(13, entity.getMinAge());
        statement.bindLong(14, entity.getMaxAge());
        if (entity.getLanguage() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getLanguage());
        }
        if (entity.getSource() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getSource());
        }
        if (entity.getFormat() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getFormat());
        }
        statement.bindLong(18, entity.getPlayCount());
        statement.bindLong(19, entity.getFavoriteCount());
        statement.bindDouble(20, entity.getRating());
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getCreatedAt());
        if (_tmp_1 == null) {
          statement.bindNull(21);
        } else {
          statement.bindLong(21, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getUpdatedAt());
        if (_tmp_2 == null) {
          statement.bindNull(22);
        } else {
          statement.bindLong(22, _tmp_2);
        }
        final Long _tmp_3 = __dateConverter.dateToTimestamp(entity.getLastPlayedAt());
        if (_tmp_3 == null) {
          statement.bindNull(23);
        } else {
          statement.bindLong(23, _tmp_3);
        }
        final int _tmp_4 = entity.isFavorite() ? 1 : 0;
        statement.bindLong(24, _tmp_4);
        final int _tmp_5 = entity.isDownloaded() ? 1 : 0;
        statement.bindLong(25, _tmp_5);
        final int _tmp_6 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(26, _tmp_6);
        final int _tmp_7 = entity.isHidden() ? 1 : 0;
        statement.bindLong(27, _tmp_7);
        statement.bindLong(28, entity.getLastPosition());
        statement.bindDouble(29, entity.getProgress());
        final String _tmp_8 = __mapConverter.toString(entity.getMetadata());
        if (_tmp_8 == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, _tmp_8);
        }
        statement.bindLong(31, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM stories WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM stories";
        return _query;
      }
    };
    this.__preparedStmtOfIncrementPlayCount = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE stories SET playCount = playCount + 1, lastPlayedAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfAddToFavorites = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE stories SET favoriteCount = favoriteCount + 1, isFavorite = 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveFromFavorites = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE stories SET favoriteCount = favoriteCount - 1, isFavorite = 0 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePlayProgress = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE stories SET lastPosition = ?, progress = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarkAsCompleted = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE stories SET isCompleted = 1 WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Story story, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfStory.insertAndReturnId(story);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<Story> stories, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStory.insert(stories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Story story, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfStory.handle(story);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Story story, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStory.handle(story);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAll(final List<Story> stories, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStory.handleMultiple(stories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFavorites(final List<Long> ids, final boolean favorite,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> StoryDao.DefaultImpls.updateFavorites(StoryDao_Impl.this, ids, favorite, __cont), $completion);
  }

  @Override
  public Object deleteById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfDeleteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
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
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object incrementPlayCount(final long id, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfIncrementPlayCount.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfIncrementPlayCount.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object addToFavorites(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfAddToFavorites.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfAddToFavorites.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object removeFromFavorites(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveFromFavorites.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfRemoveFromFavorites.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePlayProgress(final long id, final long position, final float progress,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePlayProgress.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, position);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, progress);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfUpdatePlayProgress.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsCompleted(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsCompleted.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfMarkAsCompleted.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getById(final long id, final Continuation<? super Story> $completion) {
    final String _sql = "SELECT * FROM stories WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Story>() {
      @Override
      @Nullable
      public Story call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final Story _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _result = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<Story> getByIdFlow(final long id) {
    final String _sql = "SELECT * FROM stories WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<Story>() {
      @Override
      @Nullable
      public Story call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final Story _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _result = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Object getAll(final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT `stories`.`id` AS `id`, `stories`.`title` AS `title`, `stories`.`author` AS `author`, `stories`.`description` AS `description`, `stories`.`coverImage` AS `coverImage`, `stories`.`category` AS `category`, `stories`.`subCategory` AS `subCategory`, `stories`.`tags` AS `tags`, `stories`.`contentPath` AS `contentPath`, `stories`.`audioPath` AS `audioPath`, `stories`.`duration` AS `duration`, `stories`.`wordCount` AS `wordCount`, `stories`.`minAge` AS `minAge`, `stories`.`maxAge` AS `maxAge`, `stories`.`language` AS `language`, `stories`.`source` AS `source`, `stories`.`format` AS `format`, `stories`.`playCount` AS `playCount`, `stories`.`favoriteCount` AS `favoriteCount`, `stories`.`rating` AS `rating`, `stories`.`createdAt` AS `createdAt`, `stories`.`updatedAt` AS `updatedAt`, `stories`.`lastPlayedAt` AS `lastPlayedAt`, `stories`.`isFavorite` AS `isFavorite`, `stories`.`isDownloaded` AS `isDownloaded`, `stories`.`isCompleted` AS `isCompleted`, `stories`.`isHidden` AS `isHidden`, `stories`.`lastPosition` AS `lastPosition`, `stories`.`progress` AS `progress`, `stories`.`metadata` AS `metadata` FROM stories ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfTitle = 1;
          final int _cursorIndexOfAuthor = 2;
          final int _cursorIndexOfDescription = 3;
          final int _cursorIndexOfCoverImage = 4;
          final int _cursorIndexOfCategory = 5;
          final int _cursorIndexOfSubCategory = 6;
          final int _cursorIndexOfTags = 7;
          final int _cursorIndexOfContentPath = 8;
          final int _cursorIndexOfAudioPath = 9;
          final int _cursorIndexOfDuration = 10;
          final int _cursorIndexOfWordCount = 11;
          final int _cursorIndexOfMinAge = 12;
          final int _cursorIndexOfMaxAge = 13;
          final int _cursorIndexOfLanguage = 14;
          final int _cursorIndexOfSource = 15;
          final int _cursorIndexOfFormat = 16;
          final int _cursorIndexOfPlayCount = 17;
          final int _cursorIndexOfFavoriteCount = 18;
          final int _cursorIndexOfRating = 19;
          final int _cursorIndexOfCreatedAt = 20;
          final int _cursorIndexOfUpdatedAt = 21;
          final int _cursorIndexOfLastPlayedAt = 22;
          final int _cursorIndexOfIsFavorite = 23;
          final int _cursorIndexOfIsDownloaded = 24;
          final int _cursorIndexOfIsCompleted = 25;
          final int _cursorIndexOfIsHidden = 26;
          final int _cursorIndexOfLastPosition = 27;
          final int _cursorIndexOfProgress = 28;
          final int _cursorIndexOfMetadata = 29;
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<List<Story>> getAllFlow() {
    final String _sql = "SELECT `stories`.`id` AS `id`, `stories`.`title` AS `title`, `stories`.`author` AS `author`, `stories`.`description` AS `description`, `stories`.`coverImage` AS `coverImage`, `stories`.`category` AS `category`, `stories`.`subCategory` AS `subCategory`, `stories`.`tags` AS `tags`, `stories`.`contentPath` AS `contentPath`, `stories`.`audioPath` AS `audioPath`, `stories`.`duration` AS `duration`, `stories`.`wordCount` AS `wordCount`, `stories`.`minAge` AS `minAge`, `stories`.`maxAge` AS `maxAge`, `stories`.`language` AS `language`, `stories`.`source` AS `source`, `stories`.`format` AS `format`, `stories`.`playCount` AS `playCount`, `stories`.`favoriteCount` AS `favoriteCount`, `stories`.`rating` AS `rating`, `stories`.`createdAt` AS `createdAt`, `stories`.`updatedAt` AS `updatedAt`, `stories`.`lastPlayedAt` AS `lastPlayedAt`, `stories`.`isFavorite` AS `isFavorite`, `stories`.`isDownloaded` AS `isDownloaded`, `stories`.`isCompleted` AS `isCompleted`, `stories`.`isHidden` AS `isHidden`, `stories`.`lastPosition` AS `lastPosition`, `stories`.`progress` AS `progress`, `stories`.`metadata` AS `metadata` FROM stories ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfTitle = 1;
          final int _cursorIndexOfAuthor = 2;
          final int _cursorIndexOfDescription = 3;
          final int _cursorIndexOfCoverImage = 4;
          final int _cursorIndexOfCategory = 5;
          final int _cursorIndexOfSubCategory = 6;
          final int _cursorIndexOfTags = 7;
          final int _cursorIndexOfContentPath = 8;
          final int _cursorIndexOfAudioPath = 9;
          final int _cursorIndexOfDuration = 10;
          final int _cursorIndexOfWordCount = 11;
          final int _cursorIndexOfMinAge = 12;
          final int _cursorIndexOfMaxAge = 13;
          final int _cursorIndexOfLanguage = 14;
          final int _cursorIndexOfSource = 15;
          final int _cursorIndexOfFormat = 16;
          final int _cursorIndexOfPlayCount = 17;
          final int _cursorIndexOfFavoriteCount = 18;
          final int _cursorIndexOfRating = 19;
          final int _cursorIndexOfCreatedAt = 20;
          final int _cursorIndexOfUpdatedAt = 21;
          final int _cursorIndexOfLastPlayedAt = 22;
          final int _cursorIndexOfIsFavorite = 23;
          final int _cursorIndexOfIsDownloaded = 24;
          final int _cursorIndexOfIsCompleted = 25;
          final int _cursorIndexOfIsHidden = 26;
          final int _cursorIndexOfLastPosition = 27;
          final int _cursorIndexOfProgress = 28;
          final int _cursorIndexOfMetadata = 29;
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
            _result.add(_item);
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
  public Object getPaged(final int limit, final int offset,
      final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT * FROM stories ORDER BY createdAt DESC LIMIT ? OFFSET ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    _argIndex = 2;
    _statement.bindLong(_argIndex, offset);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Object getByCategory(final String category,
      final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT * FROM stories WHERE category = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<List<Story>> getByCategoryFlow(final String category) {
    final String _sql = "SELECT * FROM stories WHERE category = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
            _result.add(_item);
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
  public Object getByTag(final String tag, final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT * FROM stories WHERE ? IN (tags) ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tag == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tag);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Object getFavorites(final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT `stories`.`id` AS `id`, `stories`.`title` AS `title`, `stories`.`author` AS `author`, `stories`.`description` AS `description`, `stories`.`coverImage` AS `coverImage`, `stories`.`category` AS `category`, `stories`.`subCategory` AS `subCategory`, `stories`.`tags` AS `tags`, `stories`.`contentPath` AS `contentPath`, `stories`.`audioPath` AS `audioPath`, `stories`.`duration` AS `duration`, `stories`.`wordCount` AS `wordCount`, `stories`.`minAge` AS `minAge`, `stories`.`maxAge` AS `maxAge`, `stories`.`language` AS `language`, `stories`.`source` AS `source`, `stories`.`format` AS `format`, `stories`.`playCount` AS `playCount`, `stories`.`favoriteCount` AS `favoriteCount`, `stories`.`rating` AS `rating`, `stories`.`createdAt` AS `createdAt`, `stories`.`updatedAt` AS `updatedAt`, `stories`.`lastPlayedAt` AS `lastPlayedAt`, `stories`.`isFavorite` AS `isFavorite`, `stories`.`isDownloaded` AS `isDownloaded`, `stories`.`isCompleted` AS `isCompleted`, `stories`.`isHidden` AS `isHidden`, `stories`.`lastPosition` AS `lastPosition`, `stories`.`progress` AS `progress`, `stories`.`metadata` AS `metadata` FROM stories WHERE isFavorite = 1 ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfTitle = 1;
          final int _cursorIndexOfAuthor = 2;
          final int _cursorIndexOfDescription = 3;
          final int _cursorIndexOfCoverImage = 4;
          final int _cursorIndexOfCategory = 5;
          final int _cursorIndexOfSubCategory = 6;
          final int _cursorIndexOfTags = 7;
          final int _cursorIndexOfContentPath = 8;
          final int _cursorIndexOfAudioPath = 9;
          final int _cursorIndexOfDuration = 10;
          final int _cursorIndexOfWordCount = 11;
          final int _cursorIndexOfMinAge = 12;
          final int _cursorIndexOfMaxAge = 13;
          final int _cursorIndexOfLanguage = 14;
          final int _cursorIndexOfSource = 15;
          final int _cursorIndexOfFormat = 16;
          final int _cursorIndexOfPlayCount = 17;
          final int _cursorIndexOfFavoriteCount = 18;
          final int _cursorIndexOfRating = 19;
          final int _cursorIndexOfCreatedAt = 20;
          final int _cursorIndexOfUpdatedAt = 21;
          final int _cursorIndexOfLastPlayedAt = 22;
          final int _cursorIndexOfIsFavorite = 23;
          final int _cursorIndexOfIsDownloaded = 24;
          final int _cursorIndexOfIsCompleted = 25;
          final int _cursorIndexOfIsHidden = 26;
          final int _cursorIndexOfLastPosition = 27;
          final int _cursorIndexOfProgress = 28;
          final int _cursorIndexOfMetadata = 29;
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<List<Story>> getFavoritesFlow() {
    final String _sql = "SELECT `stories`.`id` AS `id`, `stories`.`title` AS `title`, `stories`.`author` AS `author`, `stories`.`description` AS `description`, `stories`.`coverImage` AS `coverImage`, `stories`.`category` AS `category`, `stories`.`subCategory` AS `subCategory`, `stories`.`tags` AS `tags`, `stories`.`contentPath` AS `contentPath`, `stories`.`audioPath` AS `audioPath`, `stories`.`duration` AS `duration`, `stories`.`wordCount` AS `wordCount`, `stories`.`minAge` AS `minAge`, `stories`.`maxAge` AS `maxAge`, `stories`.`language` AS `language`, `stories`.`source` AS `source`, `stories`.`format` AS `format`, `stories`.`playCount` AS `playCount`, `stories`.`favoriteCount` AS `favoriteCount`, `stories`.`rating` AS `rating`, `stories`.`createdAt` AS `createdAt`, `stories`.`updatedAt` AS `updatedAt`, `stories`.`lastPlayedAt` AS `lastPlayedAt`, `stories`.`isFavorite` AS `isFavorite`, `stories`.`isDownloaded` AS `isDownloaded`, `stories`.`isCompleted` AS `isCompleted`, `stories`.`isHidden` AS `isHidden`, `stories`.`lastPosition` AS `lastPosition`, `stories`.`progress` AS `progress`, `stories`.`metadata` AS `metadata` FROM stories WHERE isFavorite = 1 ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfTitle = 1;
          final int _cursorIndexOfAuthor = 2;
          final int _cursorIndexOfDescription = 3;
          final int _cursorIndexOfCoverImage = 4;
          final int _cursorIndexOfCategory = 5;
          final int _cursorIndexOfSubCategory = 6;
          final int _cursorIndexOfTags = 7;
          final int _cursorIndexOfContentPath = 8;
          final int _cursorIndexOfAudioPath = 9;
          final int _cursorIndexOfDuration = 10;
          final int _cursorIndexOfWordCount = 11;
          final int _cursorIndexOfMinAge = 12;
          final int _cursorIndexOfMaxAge = 13;
          final int _cursorIndexOfLanguage = 14;
          final int _cursorIndexOfSource = 15;
          final int _cursorIndexOfFormat = 16;
          final int _cursorIndexOfPlayCount = 17;
          final int _cursorIndexOfFavoriteCount = 18;
          final int _cursorIndexOfRating = 19;
          final int _cursorIndexOfCreatedAt = 20;
          final int _cursorIndexOfUpdatedAt = 21;
          final int _cursorIndexOfLastPlayedAt = 22;
          final int _cursorIndexOfIsFavorite = 23;
          final int _cursorIndexOfIsDownloaded = 24;
          final int _cursorIndexOfIsCompleted = 25;
          final int _cursorIndexOfIsHidden = 26;
          final int _cursorIndexOfLastPosition = 27;
          final int _cursorIndexOfProgress = 28;
          final int _cursorIndexOfMetadata = 29;
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
            _result.add(_item);
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
  public Object getRecentlyPlayed(final int limit,
      final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT * FROM stories WHERE lastPlayedAt IS NOT NULL ORDER BY lastPlayedAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<List<Story>> getRecentlyPlayedFlow(final int limit) {
    final String _sql = "SELECT * FROM stories WHERE lastPlayedAt IS NOT NULL ORDER BY lastPlayedAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
            _result.add(_item);
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
  public Object search(final String query, final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT * FROM stories WHERE title LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%' OR author LIKE '%' || ? || '%' ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<List<Story>> searchFlow(final String query) {
    final String _sql = "SELECT * FROM stories WHERE title LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%' OR author LIKE '%' || ? || '%' ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
            _result.add(_item);
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
  public Object getByAge(final int age, final Continuation<? super List<Story>> $completion) {
    final String _sql = "SELECT * FROM stories WHERE ? BETWEEN minAge AND maxAge ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, age);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Flow<List<Story>> getByAgeFlow(final int age) {
    final String _sql = "SELECT * FROM stories WHERE ? BETWEEN minAge AND maxAge ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, age);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"stories"}, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
            _result.add(_item);
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
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM stories";
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
  public Object getFavoriteCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM stories WHERE isFavorite = 1";
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
  public Object getCategoryCount(final String category,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM stories WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
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
  public Object getAgeCount(final int age, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM stories WHERE ? BETWEEN minAge AND maxAge";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, age);
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
  public Object getRecommendations(final String userId, final int age, final int limit,
      final Continuation<? super List<Story>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM stories \n"
            + "        WHERE id NOT IN (\n"
            + "            SELECT storyId FROM play_history \n"
            + "            WHERE userId = ? AND completed = 1\n"
            + "        )\n"
            + "        AND ? BETWEEN minAge AND maxAge\n"
            + "        AND isHidden = 0\n"
            + "        ORDER BY rating DESC, playCount DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, age);
    _argIndex = 3;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Object getPopular(final int limit, final Continuation<? super List<Story>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM stories \n"
            + "        WHERE playCount > 0 \n"
            + "        AND isHidden = 0\n"
            + "        ORDER BY playCount DESC, rating DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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
  public Object getNewStories(final long sinceTimestamp, final int limit,
      final Continuation<? super List<Story>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM stories \n"
            + "        WHERE createdAt >= ?\n"
            + "        AND isHidden = 0\n"
            + "        ORDER BY createdAt DESC\n"
            + "        LIMIT ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sinceTimestamp);
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Story>>() {
      @Override
      @NonNull
      public List<Story> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCoverImage = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSubCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "subCategory");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfContentPath = CursorUtil.getColumnIndexOrThrow(_cursor, "contentPath");
          final int _cursorIndexOfAudioPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioPath");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
          final int _cursorIndexOfMinAge = CursorUtil.getColumnIndexOrThrow(_cursor, "minAge");
          final int _cursorIndexOfMaxAge = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAge");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "format");
          final int _cursorIndexOfPlayCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playCount");
          final int _cursorIndexOfFavoriteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteCount");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final int _cursorIndexOfLastPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPlayedAt");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "isDownloaded");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfIsHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "isHidden");
          final int _cursorIndexOfLastPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "lastPosition");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<Story> _result = new ArrayList<Story>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Story _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCoverImage;
            if (_cursor.isNull(_cursorIndexOfCoverImage)) {
              _tmpCoverImage = null;
            } else {
              _tmpCoverImage = _cursor.getString(_cursorIndexOfCoverImage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSubCategory;
            if (_cursor.isNull(_cursorIndexOfSubCategory)) {
              _tmpSubCategory = null;
            } else {
              _tmpSubCategory = _cursor.getString(_cursorIndexOfSubCategory);
            }
            final List<String> _tmpTags;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __listConverter.fromString(_tmp);
            final String _tmpContentPath;
            if (_cursor.isNull(_cursorIndexOfContentPath)) {
              _tmpContentPath = null;
            } else {
              _tmpContentPath = _cursor.getString(_cursorIndexOfContentPath);
            }
            final String _tmpAudioPath;
            if (_cursor.isNull(_cursorIndexOfAudioPath)) {
              _tmpAudioPath = null;
            } else {
              _tmpAudioPath = _cursor.getString(_cursorIndexOfAudioPath);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final int _tmpWordCount;
            _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
            final int _tmpMinAge;
            _tmpMinAge = _cursor.getInt(_cursorIndexOfMinAge);
            final int _tmpMaxAge;
            _tmpMaxAge = _cursor.getInt(_cursorIndexOfMaxAge);
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final String _tmpFormat;
            if (_cursor.isNull(_cursorIndexOfFormat)) {
              _tmpFormat = null;
            } else {
              _tmpFormat = _cursor.getString(_cursorIndexOfFormat);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final int _tmpFavoriteCount;
            _tmpFavoriteCount = _cursor.getInt(_cursorIndexOfFavoriteCount);
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final Date _tmpCreatedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpUpdatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            _tmpUpdatedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpLastPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfLastPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfLastPlayedAt);
            }
            _tmpLastPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final boolean _tmpIsFavorite;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp_4 != 0;
            final boolean _tmpIsDownloaded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsDownloaded);
            _tmpIsDownloaded = _tmp_5 != 0;
            final boolean _tmpIsCompleted;
            final int _tmp_6;
            _tmp_6 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_6 != 0;
            final boolean _tmpIsHidden;
            final int _tmp_7;
            _tmp_7 = _cursor.getInt(_cursorIndexOfIsHidden);
            _tmpIsHidden = _tmp_7 != 0;
            final long _tmpLastPosition;
            _tmpLastPosition = _cursor.getLong(_cursorIndexOfLastPosition);
            final float _tmpProgress;
            _tmpProgress = _cursor.getFloat(_cursorIndexOfProgress);
            final Map<String, String> _tmpMetadata;
            final String _tmp_8;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_8 = null;
            } else {
              _tmp_8 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_8);
            _item = new Story(_tmpId,_tmpTitle,_tmpAuthor,_tmpDescription,_tmpCoverImage,_tmpCategory,_tmpSubCategory,_tmpTags,_tmpContentPath,_tmpAudioPath,_tmpDuration,_tmpWordCount,_tmpMinAge,_tmpMaxAge,_tmpLanguage,_tmpSource,_tmpFormat,_tmpPlayCount,_tmpFavoriteCount,_tmpRating,_tmpCreatedAt,_tmpUpdatedAt,_tmpLastPlayedAt,_tmpIsFavorite,_tmpIsDownloaded,_tmpIsCompleted,_tmpIsHidden,_tmpLastPosition,_tmpProgress,_tmpMetadata);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
