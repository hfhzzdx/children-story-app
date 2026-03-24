package com.dunzi.storyhouse.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.core.app.NotificationCompat
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.StoryApplication
import com.dunzi.storyhouse.ui.MainActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.firstOrNull
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 音频播放服务
 */
@AndroidEntryPoint
class AudioPlaybackService : Service() {
    
    @Inject
    lateinit var storyRepository: com.dunzi.storyhouse.data.repository.StoryRepository
    
    @Inject
    lateinit var playHistoryRepository: com.dunzi.storyhouse.data.repository.PlayHistoryRepository
    
    private lateinit var player: ExoPlayer
    private var currentStoryId: Long = -1
    private var isPlaying = false
    
    // 播放列表相关
    private var playlist: List<com.dunzi.storyhouse.data.model.Story> = emptyList()
    private var currentPlaylistIndex: Int = -1
    
    // Coroutine scope
    private val viewModelScope = CoroutineScope(Dispatchers.Main)
    
    // 播放设置
    private var autoPlayNext: Boolean = true
    
    // 播放进度相关
    private var playbackProgressHandler: Handler? = null
    private var playbackProgressRunnable: Runnable? = null
    private val PROGRESS_UPDATE_INTERVAL = 1000L // 1秒更新一次进度
    
    // 睡眠定时器相关
    private var sleepTimerHandler: Handler? = null
    private var sleepTimerRunnable: Runnable? = null
    private var sleepTimerDuration: Long = 0L // 睡眠定时器时长（毫秒）
    private var sleepTimerStartTime: Long = 0L // 睡眠定时器开始时间
    
    companion object {
        private const val NOTIFICATION_ID = 1001
        private const val CHANNEL_ID = "story_player"
        
        // 动作常量
        const val ACTION_PLAY = "com.dunzi.storyhouse.action.PLAY"
        const val ACTION_PAUSE = "com.dunzi.storyhouse.action.PAUSE"
        const val ACTION_STOP = "com.dunzi.storyhouse.action.STOP"
        const val ACTION_NEXT = "com.dunzi.storyhouse.action.NEXT"
        const val ACTION_PREVIOUS = "com.dunzi.storyhouse.action.PREVIOUS"
        const val ACTION_SEEK_TO = "com.dunzi.storyhouse.action.SEEK_TO"
        const val ACTION_SET_SLEEP_TIMER = "com.dunzi.storyhouse.action.SET_SLEEP_TIMER"
        const val ACTION_CANCEL_SLEEP_TIMER = "com.dunzi.storyhouse.action.CANCEL_SLEEP_TIMER"
        
        // 额外数据键
        const val EXTRA_STORY_ID = "story_id"
        const val EXTRA_POSITION = "position"
        const val EXTRA_SLEEP_TIMER_DURATION = "sleep_timer_duration"
        const val EXTRA_AUDIO_URL = "audio_url"
        const val EXTRA_STORY_TITLE = "story_title"
        const val EXTRA_STORY_AUTHOR = "story_author"
        
        /**
         * 启动播放服务
         */
        fun startService(
            context: Context,
            storyId: Long,
            audioUrl: String,
            title: String,
            author: String = ""
        ) {
            val intent = Intent(context, AudioPlaybackService::class.java).apply {
                action = ACTION_PLAY
                putExtra(EXTRA_STORY_ID, storyId)
                putExtra(EXTRA_AUDIO_URL, audioUrl)
                putExtra(EXTRA_STORY_TITLE, title)
                putExtra(EXTRA_STORY_AUTHOR, author)
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
        
        /**
         * 停止播放服务
         */
        fun stopService(context: Context) {
            val intent = Intent(context, AudioPlaybackService::class.java).apply {
                action = ACTION_STOP
            }
            context.stopService(intent)
        }
        
        /**
         * 跳转到指定位置
         */
        fun seekTo(context: Context, position: Long) {
            val intent = Intent(context, AudioPlaybackService::class.java).apply {
                action = ACTION_SEEK_TO
                putExtra(EXTRA_POSITION, position)
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
        
        /**
         * 设置睡眠定时器
         */
        fun setSleepTimer(context: Context, duration: Long) {
            val intent = Intent(context, AudioPlaybackService::class.java).apply {
                action = ACTION_SET_SLEEP_TIMER
                putExtra(EXTRA_SLEEP_TIMER_DURATION, duration)
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
        
        /**
         * 取消睡眠定时器
         */
        fun cancelSleepTimer(context: Context) {
            val intent = Intent(context, AudioPlaybackService::class.java).apply {
                action = ACTION_CANCEL_SLEEP_TIMER
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
    }
    
    override fun onCreate() {
        super.onCreate()
        initializePlayer()
        createNotificationChannel()
        
        // 初始化播放进度Handler
        playbackProgressHandler = Handler(Looper.getMainLooper())
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let { handleIntent(it) }
        return START_STICKY
    }
    
    override fun onBind(intent: Intent?): IBinder? = null
    
    override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }
    
    /**
     * 初始化播放器
     */


    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().apply {
            addListener(object : Player.Listener {
                // 重写 Player.Listener 中的方法
                override fun onPlaybackStateChanged(playbackState: Int) {
                    when (playbackState) {
                        Player.STATE_READY -> {
                            // 播放器准备就绪
                            if (isPlaying) {
                                startProgressUpdates()
                            }
                        }
                        Player.STATE_ENDED -> {
                            // 播放完成
                            onPlaybackCompleted()
                            stopProgressUpdates()
                        }
                        Player.STATE_BUFFERING -> {
                            // 缓冲中
                            stopProgressUpdates()
                        }
                        Player.STATE_IDLE -> {
                            // 空闲状态
                            stopProgressUpdates()
                        }
                    }
                }
            })
        }
    }
   



    /**
     * 处理意图
     */
    private fun handleIntent(intent: Intent) {
        when (intent.action) {
            ACTION_PLAY -> {
                val storyId = intent.getLongExtra(EXTRA_STORY_ID, -1)
                val audioUrl = intent.getStringExtra(EXTRA_AUDIO_URL) ?: return
                val title = intent.getStringExtra(EXTRA_STORY_TITLE) ?: ""
                val author = intent.getStringExtra(EXTRA_STORY_AUTHOR) ?: ""
                
                playAudio(storyId, audioUrl, title, author)
            }
            
            ACTION_PAUSE -> {
                pauseAudio()
            }
            
            ACTION_STOP -> {
                stopAudio()
            }
            
            ACTION_NEXT -> {
                playNext()
            }
            
            ACTION_PREVIOUS -> {
                playPrevious()
            }
            
            ACTION_SEEK_TO -> {
                val position = intent.getLongExtra(EXTRA_POSITION, 0L)
                seekTo(position)
            }
            
            ACTION_SET_SLEEP_TIMER -> {
                val duration = intent.getLongExtra(EXTRA_SLEEP_TIMER_DURATION, 0L)
                setSleepTimer(duration)
            }
            
            ACTION_CANCEL_SLEEP_TIMER -> {
                cancelSleepTimer()
            }
        }
    }
    
    /**
     * 播放故事
     */
    private fun playStory(storyId: Long) {
        viewModelScope.launch {
            val story = storyRepository.getStoryById(storyId).firstOrNull()
            if (story != null) {
                playAudio(storyId, story.audioPath, story.title, story.author)
            }
        }
    }
    
    /**
     * 播放音频
     */
    private fun playAudio(storyId: Long, audioUrl: String, title: String, author: String) {
        currentStoryId = storyId
        
        // 创建媒体项
        val mediaItem = MediaItem.fromUri(audioUrl)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
        
        // 开始前台服务
        startForeground(NOTIFICATION_ID, createNotification(title, author, true))
        
        // 记录播放历史
        recordPlayHistory(storyId)
    }
    
    /**
     * 暂停音频
     */
    private fun pauseAudio() {
        if (player.isPlaying) {
            player.pause()
            updateNotification()
        }
    }
    
    /**
     * 停止音频
     */
    private fun stopAudio() {
        player.stop()
        stopForeground(true)
        stopSelf()
    }
    
    /**
     * 播放下一首
     */
    private fun playNext() {
        if (playlist.isEmpty() || currentPlaylistIndex < 0) {
            return
        }
        
        val nextIndex = (currentPlaylistIndex + 1) % playlist.size
        if (nextIndex != currentPlaylistIndex) {
            currentPlaylistIndex = nextIndex
            val nextStory = playlist[nextIndex]
            playStory(nextStory.id)
        }
    }
    
    /**
     * 播放上一首
     */
    private fun playPrevious() {
        if (playlist.isEmpty() || currentPlaylistIndex < 0) {
            return
        }
        
        val prevIndex = if (currentPlaylistIndex == 0) {
            playlist.size - 1
        } else {
            currentPlaylistIndex - 1
        }
        
        if (prevIndex != currentPlaylistIndex) {
            currentPlaylistIndex = prevIndex
            val prevStory = playlist[prevIndex]
            playStory(prevStory.id)
        }
    }
    
    /**
     * 跳转到指定位置
     */
    private fun seekTo(position: Long) {
        if (player.isPlaying || player.playbackState == Player.STATE_READY) {
            player.seekTo(position)
        }
    }
    
    /**
     * 设置睡眠定时器
     */
    private fun setSleepTimer(duration: Long) {
        cancelSleepTimer() // 先取消现有的定时器
        
        if (duration <= 0) {
            return
        }
        
        sleepTimerDuration = duration
        sleepTimerStartTime = System.currentTimeMillis()
        
        sleepTimerHandler = Handler(Looper.getMainLooper())
        sleepTimerRunnable = object : Runnable {
            override fun run() {
                val elapsedTime = System.currentTimeMillis() - sleepTimerStartTime
                val remainingTime = sleepTimerDuration - elapsedTime
                
                if (remainingTime <= 0) {
                    // 时间到，停止播放
                    stopAudio()
                    cancelSleepTimer()
                } else {
                    // 继续计时
                    sleepTimerHandler?.postDelayed(this, 1000L) // 每秒检查一次
                }
            }
        }
        
        sleepTimerHandler?.post(sleepTimerRunnable!!)
        
        // 更新通知，显示睡眠定时器状态
        updateNotification()
    }
    
    /**
     * 取消睡眠定时器
     */
    private fun cancelSleepTimer() {
        sleepTimerRunnable?.let {
            sleepTimerHandler?.removeCallbacks(it)
            sleepTimerRunnable = null
        }
        sleepTimerHandler = null
        sleepTimerDuration = 0L
        sleepTimerStartTime = 0L
        
        // 更新通知
        updateNotification()
    }
    
    /**
     * 获取剩余睡眠定时器时间（秒）
     */
    private fun getRemainingSleepTimerTime(): Long {
        if (sleepTimerDuration == 0L) {
            return 0L
        }
        
        val elapsedTime = System.currentTimeMillis() - sleepTimerStartTime
        val remainingTime = sleepTimerDuration - elapsedTime
        
        return if (remainingTime > 0) {
            remainingTime / 1000L // 转换为秒
        } else {
            0L
        }
    }
    
    /**
     * 播放完成处理
     */
    private fun onPlaybackCompleted() {
        // 标记故事为已完成
        if (currentStoryId != -1L) {
            viewModelScope.launch {
                storyRepository.markAsCompleted(currentStoryId)
            }
        }
        
        // 自动播放下一首（如果启用）
        if (autoPlayNext) {
            playNext()
        } else {
            // 停止播放
            stopAudio()
        }
    }
    
    /**
     * 记录播放历史
     */
    private fun recordPlayHistory(storyId: Long) {
        // 在后台线程记录播放历史
        Thread {
            try {
                // 使用runBlocking在后台线程中调用suspend函数
                kotlinx.coroutines.runBlocking {
                    playHistoryRepository.createPlaySession(
                        storyId = storyId,
                        userId = "default",
                        deviceName = Build.MODEL
                    )
                }
            } catch (e: Exception) {
                // 记录失败，但不影响播放
                e.printStackTrace()
            }
        }.start()
    }
    
    /**
     * 创建通知渠道
     */
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = getString(R.string.notification_channel_description)
                setSound(null, null)
                enableLights(false)
                enableVibration(false)
            }
            
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
    
    /**
     * 创建通知
     */
    private fun createNotification(title: String, author: String, isPlaying: Boolean): Notification {
        // 创建点击意图
        val contentIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        // 创建动作按钮
        val playPauseAction = if (isPlaying) {
            NotificationCompat.Action.Builder(
                R.drawable.ic_pause,
                getString(R.string.btn_pause),
                getPendingAction(ACTION_PAUSE)
            ).build()
        } else {
            NotificationCompat.Action.Builder(
                R.drawable.ic_play,
                getString(R.string.btn_play),
                getPendingAction(ACTION_PLAY)
            ).build()
        }
        
        val stopAction = NotificationCompat.Action.Builder(
            R.drawable.ic_stop,
            getString(R.string.btn_stop),
            getPendingAction(ACTION_STOP)
        ).build()
        
        val nextAction = NotificationCompat.Action.Builder(
            R.drawable.ic_play,
            getString(R.string.btn_next),
            getPendingAction(ACTION_NEXT)
        ).build()
        
        // 构建通知
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_play)
            .setContentTitle(title)
            .setContentText(author.ifEmpty { getString(R.string.unknown) })
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .addAction(playPauseAction)
            .addAction(stopAction)
            .addAction(nextAction)
            .setStyle(
                androidx.media.app.NotificationCompat.MediaStyle()
                    .setShowActionsInCompactView(0, 1, 2)
            )
            .build()
    }
    
    /**
     * 更新通知
     */
    private fun updateNotification() {
        // 获取当前播放的故事信息
        val story = try {
            kotlinx.coroutines.runBlocking { storyRepository.getStoryById(currentStoryId).firstOrNull() }
        } catch (_: Exception) { null }
        val title = story?.title ?: getString(R.string.unknown)
        val author = story?.author ?: ""
        
        val notification = createNotification(title, author, isPlaying)
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(NOTIFICATION_ID, notification)
    }
    
    /**
     * 获取待处理动作
     */
    private fun getPendingAction(action: String): PendingIntent {
        val intent = Intent(this, AudioPlaybackService::class.java).apply {
            this.action = action
        }
        return PendingIntent.getService(
            this,
            action.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
    
    /**
     * 开始更新播放进度
     */
    private fun startProgressUpdates() {
        stopProgressUpdates() // 先停止现有的更新
        
        playbackProgressRunnable = object : Runnable {
            override fun run() {
                updatePlaybackProgress()
                playbackProgressHandler?.postDelayed(this, PROGRESS_UPDATE_INTERVAL)
            }
        }
        
        playbackProgressHandler?.post(playbackProgressRunnable!!)
    }
    
    /**
     * 停止更新播放进度
     */
    private fun stopProgressUpdates() {
        playbackProgressRunnable?.let {
            playbackProgressHandler?.removeCallbacks(it)
            playbackProgressRunnable = null
        }
    }
    
    /**
     * 更新播放进度到数据库
     */
    private fun updatePlaybackProgress() {
        if (currentStoryId != -1L && player.isPlaying) {
            val currentPosition = player.currentPosition
            val duration = player.duration
            
            if (duration > 0) {
                val progress = currentPosition.toFloat() / duration.toFloat()
                
                // 在后台线程更新进度
                Thread {
                    try {
                        // 使用runBlocking在后台线程中调用suspend函数
                        kotlinx.coroutines.runBlocking {
                            storyRepository.updatePlayProgress(currentStoryId, currentPosition, progress)
                        }
                    } catch (e: Exception) {
                        // 忽略更新错误
                    }
                }.start()
            }
        }
    }
    
    /**
     * 释放播放器资源
     */
    private fun releasePlayer() {
        stopProgressUpdates()
        cancelSleepTimer()
        
        playbackProgressHandler?.removeCallbacksAndMessages(null)
        playbackProgressHandler = null
        
        sleepTimerHandler?.removeCallbacksAndMessages(null)
        sleepTimerHandler = null
        
        player.release()
    }
}
