package com.dunzi.storyhouse.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.dunzi.storyhouse.data.converter.DateConverter;
import com.dunzi.storyhouse.data.converter.MapConverter;
import com.dunzi.storyhouse.data.model.PlayHistory;
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
public final class PlayHistoryDao_Impl implements PlayHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PlayHistory> __insertionAdapterOfPlayHistory;

  private final DateConverter __dateConverter = new DateConverter();

  private final MapConverter __mapConverter = new MapConverter();

  private final EntityDeletionOrUpdateAdapter<PlayHistory> __deletionAdapterOfPlayHistory;

  private final EntityDeletionOrUpdateAdapter<PlayHistory> __updateAdapterOfPlayHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByStoryId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByUserId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOlderThan;

  public PlayHistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlayHistory = new EntityInsertionAdapter<PlayHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `play_history` (`id`,`storyId`,`userId`,`startPosition`,`endPosition`,`duration`,`completed`,`playbackSpeed`,`volume`,`voiceType`,`deviceId`,`deviceName`,`playedAt`,`finishedAt`,`interruptions`,`skips`,`rewinds`,`sessionId`,`metadata`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PlayHistory entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getStoryId());
        if (entity.getUserId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUserId());
        }
        statement.bindLong(4, entity.getStartPosition());
        statement.bindLong(5, entity.getEndPosition());
        statement.bindLong(6, entity.getDuration());
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindDouble(8, entity.getPlaybackSpeed());
        statement.bindDouble(9, entity.getVolume());
        if (entity.getVoiceType() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getVoiceType());
        }
        if (entity.getDeviceId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDeviceId());
        }
        if (entity.getDeviceName() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getDeviceName());
        }
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getPlayedAt());
        if (_tmp_1 == null) {
          statement.bindNull(13);
        } else {
          statement.bindLong(13, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getFinishedAt());
        if (_tmp_2 == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, _tmp_2);
        }
        statement.bindLong(15, entity.getInterruptions());
        statement.bindLong(16, entity.getSkips());
        statement.bindLong(17, entity.getRewinds());
        if (entity.getSessionId() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getSessionId());
        }
        final String _tmp_3 = __mapConverter.toString(entity.getMetadata());
        if (_tmp_3 == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, _tmp_3);
        }
      }
    };
    this.__deletionAdapterOfPlayHistory = new EntityDeletionOrUpdateAdapter<PlayHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `play_history` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PlayHistory entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfPlayHistory = new EntityDeletionOrUpdateAdapter<PlayHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `play_history` SET `id` = ?,`storyId` = ?,`userId` = ?,`startPosition` = ?,`endPosition` = ?,`duration` = ?,`completed` = ?,`playbackSpeed` = ?,`volume` = ?,`voiceType` = ?,`deviceId` = ?,`deviceName` = ?,`playedAt` = ?,`finishedAt` = ?,`interruptions` = ?,`skips` = ?,`rewinds` = ?,`sessionId` = ?,`metadata` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PlayHistory entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getStoryId());
        if (entity.getUserId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUserId());
        }
        statement.bindLong(4, entity.getStartPosition());
        statement.bindLong(5, entity.getEndPosition());
        statement.bindLong(6, entity.getDuration());
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindDouble(8, entity.getPlaybackSpeed());
        statement.bindDouble(9, entity.getVolume());
        if (entity.getVoiceType() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getVoiceType());
        }
        if (entity.getDeviceId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDeviceId());
        }
        if (entity.getDeviceName() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getDeviceName());
        }
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getPlayedAt());
        if (_tmp_1 == null) {
          statement.bindNull(13);
        } else {
          statement.bindLong(13, _tmp_1);
        }
        final Long _tmp_2 = __dateConverter.dateToTimestamp(entity.getFinishedAt());
        if (_tmp_2 == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, _tmp_2);
        }
        statement.bindLong(15, entity.getInterruptions());
        statement.bindLong(16, entity.getSkips());
        statement.bindLong(17, entity.getRewinds());
        if (entity.getSessionId() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getSessionId());
        }
        final String _tmp_3 = __mapConverter.toString(entity.getMetadata());
        if (_tmp_3 == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, _tmp_3);
        }
        statement.bindLong(20, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM play_history WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByStoryId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM play_history WHERE storyId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByUserId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM play_history WHERE userId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM play_history";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOlderThan = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM play_history WHERE playedAt < ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final PlayHistory history, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPlayHistory.insertAndReturnId(history);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<PlayHistory> histories,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPlayHistory.insert(histories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final PlayHistory history, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPlayHistory.handle(history);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final PlayHistory history, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPlayHistory.handle(history);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
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
  public Object deleteByStoryId(final long storyId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByStoryId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, storyId);
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
          __preparedStmtOfDeleteByStoryId.release(_stmt);
        }
      }
    }, $completion);
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
  public Object deleteOlderThan(final Date beforeDate,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOlderThan.acquire();
        int _argIndex = 1;
        final Long _tmp = __dateConverter.dateToTimestamp(beforeDate);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindLong(_argIndex, _tmp);
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
          __preparedStmtOfDeleteOlderThan.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getById(final long id, final Continuation<? super PlayHistory> $completion) {
    final String _sql = "SELECT * FROM play_history WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayHistory>() {
      @Override
      @Nullable
      public PlayHistory call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final PlayHistory _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _result = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getByStoryId(final long storyId,
      final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT * FROM play_history WHERE storyId = ? ORDER BY playedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, storyId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Flow<List<PlayHistory>> getByStoryIdFlow(final long storyId) {
    final String _sql = "SELECT * FROM play_history WHERE storyId = ? ORDER BY playedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, storyId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"play_history"}, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getByUserId(final String userId,
      final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT * FROM play_history WHERE userId = ? ORDER BY playedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Flow<List<PlayHistory>> getByUserIdFlow(final String userId) {
    final String _sql = "SELECT * FROM play_history WHERE userId = ? ORDER BY playedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"play_history"}, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getByDateRange(final Date startDate, final Date endDate,
      final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT * FROM play_history WHERE playedAt BETWEEN ? AND ? ORDER BY playedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final Long _tmp = __dateConverter.dateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
    final Long _tmp_1 = __dateConverter.dateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_3);
            final Date _tmpFinishedAt;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_4);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_5);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getSinceDate(final Date sinceDate,
      final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT * FROM play_history WHERE playedAt >= ? ORDER BY playedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final Long _tmp = __dateConverter.dateToTimestamp(sinceDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_1 != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_2);
            final Date _tmpFinishedAt;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_3);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_4);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getRecent(final int limit,
      final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT * FROM play_history ORDER BY playedAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Flow<List<PlayHistory>> getRecentFlow(final int limit) {
    final String _sql = "SELECT * FROM play_history ORDER BY playedAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"play_history"}, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getCompleted(final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT `play_history`.`id` AS `id`, `play_history`.`storyId` AS `storyId`, `play_history`.`userId` AS `userId`, `play_history`.`startPosition` AS `startPosition`, `play_history`.`endPosition` AS `endPosition`, `play_history`.`duration` AS `duration`, `play_history`.`completed` AS `completed`, `play_history`.`playbackSpeed` AS `playbackSpeed`, `play_history`.`volume` AS `volume`, `play_history`.`voiceType` AS `voiceType`, `play_history`.`deviceId` AS `deviceId`, `play_history`.`deviceName` AS `deviceName`, `play_history`.`playedAt` AS `playedAt`, `play_history`.`finishedAt` AS `finishedAt`, `play_history`.`interruptions` AS `interruptions`, `play_history`.`skips` AS `skips`, `play_history`.`rewinds` AS `rewinds`, `play_history`.`sessionId` AS `sessionId`, `play_history`.`metadata` AS `metadata` FROM play_history WHERE completed = 1 ORDER BY finishedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfStoryId = 1;
          final int _cursorIndexOfUserId = 2;
          final int _cursorIndexOfStartPosition = 3;
          final int _cursorIndexOfEndPosition = 4;
          final int _cursorIndexOfDuration = 5;
          final int _cursorIndexOfCompleted = 6;
          final int _cursorIndexOfPlaybackSpeed = 7;
          final int _cursorIndexOfVolume = 8;
          final int _cursorIndexOfVoiceType = 9;
          final int _cursorIndexOfDeviceId = 10;
          final int _cursorIndexOfDeviceName = 11;
          final int _cursorIndexOfPlayedAt = 12;
          final int _cursorIndexOfFinishedAt = 13;
          final int _cursorIndexOfInterruptions = 14;
          final int _cursorIndexOfSkips = 15;
          final int _cursorIndexOfRewinds = 16;
          final int _cursorIndexOfSessionId = 17;
          final int _cursorIndexOfMetadata = 18;
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Flow<List<PlayHistory>> getCompletedFlow() {
    final String _sql = "SELECT `play_history`.`id` AS `id`, `play_history`.`storyId` AS `storyId`, `play_history`.`userId` AS `userId`, `play_history`.`startPosition` AS `startPosition`, `play_history`.`endPosition` AS `endPosition`, `play_history`.`duration` AS `duration`, `play_history`.`completed` AS `completed`, `play_history`.`playbackSpeed` AS `playbackSpeed`, `play_history`.`volume` AS `volume`, `play_history`.`voiceType` AS `voiceType`, `play_history`.`deviceId` AS `deviceId`, `play_history`.`deviceName` AS `deviceName`, `play_history`.`playedAt` AS `playedAt`, `play_history`.`finishedAt` AS `finishedAt`, `play_history`.`interruptions` AS `interruptions`, `play_history`.`skips` AS `skips`, `play_history`.`rewinds` AS `rewinds`, `play_history`.`sessionId` AS `sessionId`, `play_history`.`metadata` AS `metadata` FROM play_history WHERE completed = 1 ORDER BY finishedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"play_history"}, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfStoryId = 1;
          final int _cursorIndexOfUserId = 2;
          final int _cursorIndexOfStartPosition = 3;
          final int _cursorIndexOfEndPosition = 4;
          final int _cursorIndexOfDuration = 5;
          final int _cursorIndexOfCompleted = 6;
          final int _cursorIndexOfPlaybackSpeed = 7;
          final int _cursorIndexOfVolume = 8;
          final int _cursorIndexOfVoiceType = 9;
          final int _cursorIndexOfDeviceId = 10;
          final int _cursorIndexOfDeviceName = 11;
          final int _cursorIndexOfPlayedAt = 12;
          final int _cursorIndexOfFinishedAt = 13;
          final int _cursorIndexOfInterruptions = 14;
          final int _cursorIndexOfSkips = 15;
          final int _cursorIndexOfRewinds = 16;
          final int _cursorIndexOfSessionId = 17;
          final int _cursorIndexOfMetadata = 18;
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
  public Object getBySessionId(final String sessionId,
      final Continuation<? super List<PlayHistory>> $completion) {
    final String _sql = "SELECT * FROM play_history WHERE sessionId = ? ORDER BY playedAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sessionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sessionId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistory>>() {
      @Override
      @NonNull
      public List<PlayHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "storyId");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfStartPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "startPosition");
          final int _cursorIndexOfEndPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "endPosition");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfPlaybackSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "playbackSpeed");
          final int _cursorIndexOfVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "volume");
          final int _cursorIndexOfVoiceType = CursorUtil.getColumnIndexOrThrow(_cursor, "voiceType");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceName");
          final int _cursorIndexOfPlayedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "playedAt");
          final int _cursorIndexOfFinishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "finishedAt");
          final int _cursorIndexOfInterruptions = CursorUtil.getColumnIndexOrThrow(_cursor, "interruptions");
          final int _cursorIndexOfSkips = CursorUtil.getColumnIndexOrThrow(_cursor, "skips");
          final int _cursorIndexOfRewinds = CursorUtil.getColumnIndexOrThrow(_cursor, "rewinds");
          final int _cursorIndexOfSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionId");
          final int _cursorIndexOfMetadata = CursorUtil.getColumnIndexOrThrow(_cursor, "metadata");
          final List<PlayHistory> _result = new ArrayList<PlayHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpStartPosition;
            _tmpStartPosition = _cursor.getLong(_cursorIndexOfStartPosition);
            final long _tmpEndPosition;
            _tmpEndPosition = _cursor.getLong(_cursorIndexOfEndPosition);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final float _tmpPlaybackSpeed;
            _tmpPlaybackSpeed = _cursor.getFloat(_cursorIndexOfPlaybackSpeed);
            final float _tmpVolume;
            _tmpVolume = _cursor.getFloat(_cursorIndexOfVolume);
            final String _tmpVoiceType;
            if (_cursor.isNull(_cursorIndexOfVoiceType)) {
              _tmpVoiceType = null;
            } else {
              _tmpVoiceType = _cursor.getString(_cursorIndexOfVoiceType);
            }
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final Date _tmpPlayedAt;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayedAt)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfPlayedAt);
            }
            _tmpPlayedAt = __dateConverter.fromTimestamp(_tmp_1);
            final Date _tmpFinishedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFinishedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfFinishedAt);
            }
            _tmpFinishedAt = __dateConverter.fromTimestamp(_tmp_2);
            final int _tmpInterruptions;
            _tmpInterruptions = _cursor.getInt(_cursorIndexOfInterruptions);
            final int _tmpSkips;
            _tmpSkips = _cursor.getInt(_cursorIndexOfSkips);
            final int _tmpRewinds;
            _tmpRewinds = _cursor.getInt(_cursorIndexOfRewinds);
            final String _tmpSessionId;
            if (_cursor.isNull(_cursorIndexOfSessionId)) {
              _tmpSessionId = null;
            } else {
              _tmpSessionId = _cursor.getString(_cursorIndexOfSessionId);
            }
            final Map<String, String> _tmpMetadata;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfMetadata)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfMetadata);
            }
            _tmpMetadata = __mapConverter.fromString(_tmp_3);
            _item = new PlayHistory(_tmpId,_tmpStoryId,_tmpUserId,_tmpStartPosition,_tmpEndPosition,_tmpDuration,_tmpCompleted,_tmpPlaybackSpeed,_tmpVolume,_tmpVoiceType,_tmpDeviceId,_tmpDeviceName,_tmpPlayedAt,_tmpFinishedAt,_tmpInterruptions,_tmpSkips,_tmpRewinds,_tmpSessionId,_tmpMetadata);
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
    final String _sql = "SELECT COUNT(*) FROM play_history";
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
  public Object getCountByUserId(final String userId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM play_history WHERE userId = ?";
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
  public Object getCountByStoryId(final long storyId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM play_history WHERE storyId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, storyId);
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
  public Object getCompletedCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM play_history WHERE completed = 1";
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
  public Object getCompletedCountByUserId(final String userId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM play_history WHERE userId = ? AND completed = 1";
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
  public Object getTotalDuration(final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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

  @Override
  public Object getTotalDurationByUserId(final String userId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
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

  @Override
  public Object getTotalDurationByStoryId(final long storyId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history WHERE storyId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, storyId);
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

  @Override
  public Object getDurationByDateRange(final Date startDate, final Date endDate,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history WHERE playedAt BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final Long _tmp = __dateConverter.dateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
    final Long _tmp_1 = __dateConverter.dateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
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
            final Long _tmp_2;
            if (_cursor.isNull(0)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(0);
            }
            _result = _tmp_2;
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
  public Object getTodayDuration(final String userId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history WHERE userId = ? AND date(playedAt/1000, 'unixepoch') = date('now')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
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

  @Override
  public Object getThisWeekDuration(final String userId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history WHERE userId = ? AND strftime('%Y-%W', playedAt/1000, 'unixepoch') = strftime('%Y-%W', 'now')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
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

  @Override
  public Object getThisMonthDuration(final String userId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM play_history WHERE userId = ? AND strftime('%Y-%m', playedAt/1000, 'unixepoch') = strftime('%Y-%m', 'now')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
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

  @Override
  public Object getMostPlayedStories(final String userId, final int limit,
      final Continuation<? super List<PlayHistoryDao.StoryPlayStats>> $completion) {
    final String _sql = "\n"
            + "        SELECT storyId, COUNT(*) as playCount, SUM(duration) as totalDuration\n"
            + "        FROM play_history \n"
            + "        WHERE userId = ?\n"
            + "        GROUP BY storyId \n"
            + "        ORDER BY playCount DESC \n"
            + "        LIMIT ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistoryDao.StoryPlayStats>>() {
      @Override
      @NonNull
      public List<PlayHistoryDao.StoryPlayStats> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStoryId = 0;
          final int _cursorIndexOfPlayCount = 1;
          final int _cursorIndexOfTotalDuration = 2;
          final List<PlayHistoryDao.StoryPlayStats> _result = new ArrayList<PlayHistoryDao.StoryPlayStats>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistoryDao.StoryPlayStats _item;
            final long _tmpStoryId;
            _tmpStoryId = _cursor.getLong(_cursorIndexOfStoryId);
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final long _tmpTotalDuration;
            _tmpTotalDuration = _cursor.getLong(_cursorIndexOfTotalDuration);
            _item = new PlayHistoryDao.StoryPlayStats(_tmpStoryId,_tmpPlayCount,_tmpTotalDuration);
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
  public Object getPlayTimeDistribution(final String userId,
      final Continuation<? super List<PlayHistoryDao.PlayTimeStats>> $completion) {
    final String _sql = "\n"
            + "        SELECT \n"
            + "            strftime('%H', playedAt/1000, 'unixepoch') as hour,\n"
            + "            COUNT(*) as playCount,\n"
            + "            SUM(duration) as totalDuration\n"
            + "        FROM play_history \n"
            + "        WHERE userId = ?\n"
            + "        GROUP BY hour\n"
            + "        ORDER BY hour\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistoryDao.PlayTimeStats>>() {
      @Override
      @NonNull
      public List<PlayHistoryDao.PlayTimeStats> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHour = 0;
          final int _cursorIndexOfPlayCount = 1;
          final int _cursorIndexOfTotalDuration = 2;
          final List<PlayHistoryDao.PlayTimeStats> _result = new ArrayList<PlayHistoryDao.PlayTimeStats>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistoryDao.PlayTimeStats _item;
            final String _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getString(_cursorIndexOfHour);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final long _tmpTotalDuration;
            _tmpTotalDuration = _cursor.getLong(_cursorIndexOfTotalDuration);
            _item = new PlayHistoryDao.PlayTimeStats(_tmpHour,_tmpPlayCount,_tmpTotalDuration);
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
  public Object getDeviceUsage(final String userId,
      final Continuation<? super List<PlayHistoryDao.DeviceUsageStats>> $completion) {
    final String _sql = "\n"
            + "        SELECT \n"
            + "            deviceName,\n"
            + "            COUNT(*) as playCount,\n"
            + "            SUM(duration) as totalDuration\n"
            + "        FROM play_history \n"
            + "        WHERE userId = ? AND deviceName != ''\n"
            + "        GROUP BY deviceName\n"
            + "        ORDER BY totalDuration DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PlayHistoryDao.DeviceUsageStats>>() {
      @Override
      @NonNull
      public List<PlayHistoryDao.DeviceUsageStats> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDeviceName = 0;
          final int _cursorIndexOfPlayCount = 1;
          final int _cursorIndexOfTotalDuration = 2;
          final List<PlayHistoryDao.DeviceUsageStats> _result = new ArrayList<PlayHistoryDao.DeviceUsageStats>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayHistoryDao.DeviceUsageStats _item;
            final String _tmpDeviceName;
            if (_cursor.isNull(_cursorIndexOfDeviceName)) {
              _tmpDeviceName = null;
            } else {
              _tmpDeviceName = _cursor.getString(_cursorIndexOfDeviceName);
            }
            final int _tmpPlayCount;
            _tmpPlayCount = _cursor.getInt(_cursorIndexOfPlayCount);
            final long _tmpTotalDuration;
            _tmpTotalDuration = _cursor.getLong(_cursorIndexOfTotalDuration);
            _item = new PlayHistoryDao.DeviceUsageStats(_tmpDeviceName,_tmpPlayCount,_tmpTotalDuration);
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
  public Object getRecentPlayDays(final String userId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "\n"
            + "        SELECT COUNT(DISTINCT date(playedAt/1000, 'unixepoch')) as recentPlayDays\n"
            + "        FROM play_history \n"
            + "        WHERE userId = ? \n"
            + "        AND playedAt >= (strftime('%s', 'now', '-7 days') * 1000)\n"
            + "    ";
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
