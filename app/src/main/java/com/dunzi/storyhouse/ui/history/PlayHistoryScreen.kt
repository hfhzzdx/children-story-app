package com.dunzi.storyhouse.ui.history

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.theme.SettingDescriptionStyle
import com.dunzi.storyhouse.ui.theme.SettingTitleStyle
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale




// 导入缺失的依赖
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color

/**
 * 播放历史界面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayHistoryScreen(
    viewModel: PlayHistoryViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val historyState by viewModel.historyState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    
    // 加载播放历史
    LaunchedEffect(Unit) {
        viewModel.loadPlayHistory()
    }
    
    // 显示错误消息
    LaunchedEffect(historyState.error) {
        historyState.error?.let { error ->
            snackbarHostState.showSnackbar(error)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            PlayHistoryTopBar(
                onBack = onBack,
                onClearAll = viewModel::clearPlayHistory,
                hasHistory = historyState.hasHistory
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                historyState.isLoading -> {
                    // 加载中
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                
                !historyState.hasHistory -> {
                    // 没有播放历史
                    EmptyHistoryScreen(
                        onBack = onBack,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                
                else -> {
                    // 显示播放历史
                    PlayHistoryContent(
                        historyState = historyState,
                        onDeleteItem = viewModel::deleteHistoryItem,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

/**
 * 播放历史顶部栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayHistoryTopBar(
    onBack: () -> Unit,
    onClearAll: () -> Unit,
    hasHistory: Boolean,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = "播放历史",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "返回"
                )
            }
        },
        actions = {
            if (hasHistory) {
                IconButton(
                    onClick = onClearAll,
                    enabled = hasHistory
                ) {
                    Icon(
                        imageVector = Icons.Default.ClearAll,
                        contentDescription = "清空历史"
                    )
                }
            }
        },
        modifier = modifier
    )
}

/**
 * 空播放历史界面
 */
@Composable
fun EmptyHistoryScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.History,
            contentDescription = "播放历史",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(64.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "暂无播放历史",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "开始播放故事后，这里会显示您的播放记录",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(onClick = onBack) {
            Text(text = "返回")
        }
    }
}

/**
 * 播放历史内容
 */
@Composable
fun PlayHistoryContent(
    historyState: PlayHistoryViewModel.PlayHistoryState,
    onDeleteItem: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        // 统计卡片
        item {
            PlayStatsCard(
                playStats = historyState.playStats,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 最常播放的故事
        if (historyState.mostPlayedStories.isNotEmpty()) {
            item {
                MostPlayedStoriesSection(
                    mostPlayedStories = historyState.mostPlayedStories,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
        
        // 播放历史列表
        items(historyState.playHistory.chunked(10).flatMapIndexed { index, chunk ->
            listOf("日期分组 ${index + 1}") + chunk
        }) { item ->
            when (item) {
                is String -> {
                    // 日期分组标题
                    Text(
                        text = item,
                        style = SettingTitleStyle,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                
                is com.dunzi.storyhouse.data.model.PlayHistory -> {
                    // 播放历史项
                    PlayHistoryItem(
                        history = item,
                        onDelete = { onDeleteItem(item.id) },
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
        
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/**
 * 播放统计卡片
 */
@Composable
fun PlayStatsCard(
    playStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "播放统计",
                style = SettingTitleStyle,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItem(
                    title = "总播放时长",
                    value = "${playStats?.totalPlayTime?.div(60) ?: 0}分钟",
                    icon = Icons.Default.Timer
                )
                
                StatItem(
                    title = "总播放次数",
                    value = "${playStats?.totalPlayCount ?: 0}次",
                    icon = Icons.Default.PlayArrow
                )
                
                StatItem(
                    title = "连续播放",
                    value = "${playStats?.consecutiveDays ?: 0}天",
                    icon = Icons.Default.History
                )
            }
        }
    }
}

/**
 * 统计项组件
 */
@Composable
fun StatItem(
    title: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = title,
            style = SettingDescriptionStyle,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * 最常播放的故事部分
 */
@Composable
fun MostPlayedStoriesSection(
    mostPlayedStories: List<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.StoryPlayStats>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "最常播放的故事",
                style = SettingTitleStyle,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            mostPlayedStories.take(5).forEachIndexed { index, storyStats ->
                MostPlayedStoryItem(
                    storyStats = storyStats,
                    rank = index + 1,
                    modifier = Modifier.fillMaxWidth()
                )
                
                if (index < mostPlayedStories.take(5).size - 1) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

/**
 * 最常播放的故事项
 */
@Composable
fun MostPlayedStoryItem(
    storyStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.StoryPlayStats,
    rank: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 排名
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(
                    when (rank) {
                        1 -> MaterialTheme.colorScheme.primary
                        2 -> MaterialTheme.colorScheme.secondary
                        3 -> MaterialTheme.colorScheme.tertiary
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = rank.toString(),
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = when (rank) {
                    1, 2, 3 -> MaterialTheme.colorScheme.onPrimary
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
        
        Spacer(modifier = Modifier.width(12.dp))
        
        // 故事信息
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = storyStats.storyTitle,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1
            )
            
            Spacer(modifier = Modifier.height(2.dp))
            
            Text(
                text = "播放 ${storyStats.playCount} 次",
                style = SettingDescriptionStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        // 播放时长
        Text(
            text = "${storyStats.totalPlayTime / 60}分钟",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * 播放历史项
 */
@Composable
fun PlayHistoryItem(
    history: com.dunzi.storyhouse.data.model.PlayHistory,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 播放图标
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "播放",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(20.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(12.dp))
            
            // 播放信息
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = history.storyTitle,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1
                )
                
                Spacer(modifier = Modifier.height(2.dp))
                
                Row {
                    Text(
                        text = formatDate(history.playedAt),
                        style = SettingDescriptionStyle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Text(
                        text = " • ",
                        style = SettingDescriptionStyle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Text(
                        text = "播放 ${history.playDuration / 60}分钟",
                        style = SettingDescriptionStyle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            // 删除按钮
            IconButton(
                onClick = onDelete,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "删除",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * 格式化日期
 */
private fun formatDate(date: Date): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(date)
}

