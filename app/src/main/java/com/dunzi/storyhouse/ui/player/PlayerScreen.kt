package com.dunzi.storyhouse.ui.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Forward10
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Replay10
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.github.bumptech.glide.integration.compose.GlideImage
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.theme.FavoriteColor
import com.dunzi.storyhouse.ui.theme.PlayButtonColor
import com.dunzi.storyhouse.ui.theme.PlayerProgress
import kotlinx.coroutines.delay

/**
 * 播放器界面
 */
@Composable
fun PlayerScreen(
    viewModel: PlayerViewModel,
    onBack: () -> Unit
) {
    val playerState by viewModel.playerState.collectAsStateWithLifecycle()
    
    // 自动更新进度
    LaunchedEffect(playerState.isPlaying) {
        while (playerState.isPlaying) {
            delay(1000) // 每秒更新一次
            // TODO: 从播放服务获取实际进度
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 返回按钮
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 专辑封面
            AlbumCover(
                coverImage = playerState.currentStory?.coverImage,
                isLoading = playerState.isLoading,
                modifier = Modifier.size(240.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // 歌曲信息
            SongInfo(
                title = playerState.currentStory?.title ?: stringResource(R.string.no_song_selected),
                author = playerState.currentStory?.author ?: "",
                isFavorite = playerState.currentStory?.isFavorite ?: false,
                onToggleFavorite = viewModel::toggleFavorite
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // 进度条
            PlaybackProgress(
                currentPosition = playerState.currentPosition,
                duration = playerState.duration,
                onSeek = viewModel::seekTo,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // 播放控制
            PlaybackControls(
                isPlaying = playerState.isPlaying,
                hasPrevious = playerState.playStats?.hasPreviousStory ?: false,
                hasNext = playerState.playStats?.hasNextStory ?: false,
                onPlayPause = viewModel::togglePlayback,
                onPrevious = viewModel::playPrevious,
                onNext = viewModel::playNext,
                onForward = { viewModel.seekTo(playerState.currentPosition + 10000) },
                onRewind = { viewModel.seekTo(playerState.currentPosition - 10000) },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // 额外控制
            ExtraControls(
                volume = playerState.volume,
                playbackSpeed = playerState.playbackSpeed,
                shuffleEnabled = playerState.shuffleEnabled,
                repeatMode = playerState.repeatMode,
                onVolumeChange = viewModel::adjustVolume,
                onSpeedChange = viewModel::adjustPlaybackSpeed,
                onShuffleToggle = viewModel::toggleShuffle,
                onRepeatToggle = viewModel::toggleRepeatMode,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // 睡眠定时器控制
            SleepTimerControl(
                hasActiveSleepTimer = playerState.hasActiveSleepTimer,
                remainingTime = playerState.getFormattedRemainingSleepTimerTime(),
                onSetSleepTimer = { minutes ->
                    viewModel.setSleepTimer(minutes)
                },
                onCancelSleepTimer = {
                    viewModel.cancelSleepTimer()
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        // 加载指示器
        if (playerState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = PlayButtonColor,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}

/**
 * 专辑封面
 */
@Composable
fun AlbumCover(
    coverImage: String?,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (coverImage?.isNotBlank() == true) {
                AsyncImage(
                    model = coverImage,
                    contentDescription = stringResource(R.string.story_cover),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
            
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}

/**
 * 歌曲信息
 */
@Composable
fun SongInfo(
    title: String,
    author: String,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 标题和收藏按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            IconButton(
                onClick = onToggleFavorite,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = if (isFavorite) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    },
                    contentDescription = stringResource(R.string.btn_favorite),
                    tint = if (isFavorite) FavoriteColor else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 作者
        if (author.isNotBlank()) {
            Text(
                text = author,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * 播放进度
 */
@Composable
fun PlaybackProgress(
    currentPosition: Long,
    duration: Long,
    onSeek: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var isDragging by remember { mutableLongStateOf(false) }
    
    // 格式化时间
    fun formatTime(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
    
    Column(modifier = modifier) {
        // 进度条
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
                isDragging = true
            },
            onValueChangeFinished = {
                val newPosition = (sliderPosition * duration).toLong()
                onSeek(newPosition)
                isDragging = false
            },
            colors = androidx.compose.material3.SliderDefaults.colors(
                thumbColor = PlayerProgress,
                activeTrackColor = PlayerProgress,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // 时间显示
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = formatTime(currentPosition),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Text(
                text = formatTime(duration),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * 播放控制
 */
@Composable
fun PlaybackControls(
    isPlaying: Boolean,
    hasPrevious: Boolean,
    hasNext: Boolean,
    onPlayPause: () -> Unit,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onForward: () -> Unit,
    onRewind: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 主要控制按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 快退10秒
            IconButton(
                onClick = onRewind,
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Replay10,
                    contentDescription = stringResource(R.string.btn_rewind),
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // 上一首
            IconButton(
                onClick = onPrevious,
                enabled = hasPrevious,
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.SkipPrevious,
                    contentDescription = stringResource(R.string.btn_previous),
                    tint = if (hasPrevious) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // 播放/暂停
            IconButton(
                onClick = onPlayPause,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(PlayButtonColor)
            ) {
                Icon(
                    imageVector = if (isPlaying) {
                        Icons.Default.Pause
                    } else {
                        Icons.Default.PlayArrow
                    },
                    contentDescription = if (isPlaying) {
                        stringResource(R.string.btn_pause)
                    } else {
                        stringResource(R.string.btn_play)
                    },
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // 下一首
            IconButton(
                onClick = onNext,
                enabled = hasNext,
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.SkipNext,
                    contentDescription = stringResource(R.string.btn_next),
                    tint = if (hasNext) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // 快进10秒
            IconButton(
                onClick = onForward,
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Forward10,
                    contentDescription = stringResource(R.string.btn_forward),
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 停止按钮
        IconButton(
            onClick = { /* TODO: 停止播放 */ },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Stop,
                contentDescription = stringResource(R.string.btn_stop),
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

/**
 * 额外控制
 */
@Composable
fun ExtraControls(
    volume: Float,
    playbackSpeed: Float,
    shuffleEnabled: Boolean,
    repeatMode: PlayerViewModel.RepeatMode,
    onVolumeChange: (Float) -> Unit,
    onSpeedChange: (Float) -> Unit,
    onShuffleToggle: () -> Unit,
    onRepeatToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // 音量控制
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.VolumeDown,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(24.dp)
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Slider(
                value = volume,
                onValueChange = onVolumeChange,
                valueRange = 0f..1f,
                modifier = Modifier.weight(1f)
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.VolumeUp,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 播放速度和模式控制
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 播放速度
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.Speed,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(4.dp))
                
                Text(
                    text = "${playbackSpeed}x",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.width(8.dp))
                
                // 速度调整按钮
                IconButton(
                    onClick = { onSpeedChange((playbackSpeed - 0.25f).coerceAtLeast(0.5f)) },
                    modifier = Modifier.size(32.dp)
                ) {
                    Text(
                        text = "-",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                
                Spacer(modifier = Modifier.width(4.dp))
                
                IconButton(
                    onClick = { onSpeedChange((playbackSpeed + 0.25f).coerceAtMost(2.0f)) },
                    modifier = Modifier.size(32.dp)
                ) {
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            
            // 随机播放
            IconButton(
                onClick = onShuffleToggle,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.Shuffle,
                    contentDescription = stringResource(R.string.player_shuffle),
                    tint = if (shuffleEnabled) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // 循环模式
            IconButton(
                onClick = onRepeatToggle,
                modifier = Modifier.size(40.dp)
            ) {
                val (icon, tint) = when (repeatMode) {
                    PlayerViewModel.RepeatMode.NONE -> {
                        androidx.compose.material.icons.Icons.Default.Repeat to MaterialTheme.colorScheme.onSurfaceVariant
                    }
                    PlayerViewModel.RepeatMode.REPEAT_ALL -> {
                        androidx.compose.material.icons.Icons.Default.Repeat to MaterialTheme.colorScheme.primary
                    }
                    PlayerViewModel.RepeatMode.REPEAT_ONE -> {
                        androidx.compose.material.icons.Icons.Default.RepeatOne to MaterialTheme.colorScheme.primary
                    }
                }
                
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(R.string.player_repeat_mode),
                    tint = tint,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
