package com.dunzi.storyhouse.ui.story

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
import com.dunzi.storyhouse.ui.component.AgeTag
import com.dunzi.storyhouse.ui.component.CategoryTag
import com.dunzi.storyhouse.ui.component.StoryCard
import com.dunzi.storyhouse.ui.theme.FavoriteColor
import com.dunzi.storyhouse.ui.theme.PlayButtonColor
import com.dunzi.storyhouse.ui.theme.PlayerProgress
import com.dunzi.storyhouse.ui.theme.StoryDescriptionStyle
import com.dunzi.storyhouse.ui.theme.StoryTitleStyle
import com.dunzi.storyhouse.ui.theme.TagBackground
import com.dunzi.storyhouse.ui.theme.TagTextStyle

/**
 * 故事详情界面
 */
@Composable
fun StoryDetailScreen(
    viewModel: StoryDetailViewModel,
    storyId: Long,
    onBack: () -> Unit,
    onPlay: (Long) -> Unit,
    onRelatedStoryClick: (Long) -> Unit
) {
    val storyDetailState by viewModel.storyDetailState.collectAsStateWithLifecycle()
    val relatedStories by viewModel.relatedStories.collectAsStateWithLifecycle()
    val playStats by viewModel.playStats.collectAsStateWithLifecycle()
    
    val snackbarHostState = remember { SnackbarHostState() }
    
    // 加载故事详情
    LaunchedEffect(storyId) {
        viewModel.loadStoryDetail(storyId)
    }
    
    // 显示错误消息
    LaunchedEffect(storyDetailState.error) {
        storyDetailState.error?.let { error ->
            snackbarHostState.showSnackbar(error)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when {
                storyDetailState.isLoading -> {
                    // 加载中
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                
                !storyDetailState.hasStory -> {
                    // 没有故事
                    EmptyStoryDetail(
                        onBack = onBack,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                
                else -> {
                    // 显示故事详情
                    StoryDetailContent(
                        storyDetailState = storyDetailState,
                        relatedStories = relatedStories,
                        playStats = playStats,
                        onBack = onBack,
                        onPlay = { onPlay(storyId) },
                        onToggleFavorite = viewModel::toggleFavorite,
                        onToggleReadStatus = viewModel::toggleReadStatus,
                        onRelatedStoryClick = onRelatedStoryClick,
                        getAgeSuggestion = viewModel::getAgeSuggestion,
                        getDurationDescription = viewModel::getDurationDescription,
                        getDifficultyDescription = viewModel::getDifficultyDescription,
                        getPlayCount = viewModel::getPlayCount,
                        getAveragePlayTime = viewModel::getAveragePlayTime,
                        getCompletionRate = viewModel::getCompletionRate,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

/**
 * 空故事详情
 */
@Composable
fun EmptyStoryDetail(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 返回按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = stringResource(R.string.story_not_found),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = stringResource(R.string.tip_go_back),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * 故事详情内容
 */
@Composable
fun StoryDetailContent(
    storyDetailState: StoryDetailViewModel.StoryDetailState,
    relatedStories: List<com.dunzi.storyhouse.data.model.Story>,
    playStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary?,
    onBack: () -> Unit,
    onPlay: () -> Unit,
    onToggleFavorite: () -> Unit,
    onToggleReadStatus: () -> Unit,
    onRelatedStoryClick: (Long) -> Unit,
    getAgeSuggestion: () -> String,
    getDurationDescription: () -> String,
    getDifficultyDescription: () -> String,
    getPlayCount: () -> Int,
    getAveragePlayTime: () -> String,
    getCompletionRate: () -> String,
    modifier: Modifier = Modifier
) {
    val story = storyDetailState.story!!
    
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 头部
        item {
            StoryDetailHeader(
                story = story,
                onBack = onBack,
                onToggleFavorite = onToggleFavorite,
                onShare = { /* TODO: 分享故事 */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        // 封面和基本信息
        item {
            StoryCoverAndInfo(
                story = story,
                onPlay = onPlay,
                getAgeSuggestion = getAgeSuggestion,
                getDurationDescription = getDurationDescription,
                getDifficultyDescription = getDifficultyDescription,
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        // 播放进度
        item {
            if (story.progress > 0) {
                PlayProgressSection(
                    progress = story.progress,
                    completed = story.completed,
                    onToggleReadStatus = onToggleReadStatus,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        // 播放统计
        item {
            if (playStats != null) {
                PlayStatsSection(
                    playStats = playStats,
                    getPlayCount = getPlayCount,
                    getAveragePlayTime = getAveragePlayTime,
                    getCompletionRate = getCompletionRate,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        // 故事描述
        item {
            if (storyDetailState.hasDescription) {
                StoryDescriptionSection(
                    description = storyDetailState.description,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        // 标签
        item {
            if (storyDetailState.hasTags) {
                StoryTagsSection(
                    tags = storyDetailState.tags,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        // 章节
        item {
            if (storyDetailState.hasChapters) {
                StoryChaptersSection(
                    chapters = storyDetailState.chapters,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        // 相关故事
        item {
            if (relatedStories.isNotEmpty()) {
                RelatedStoriesSection(
                    stories = relatedStories,
                    onStoryClick = onRelatedStoryClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        // 底部间距
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/**
 * 故事详情头部
 */
@Composable
fun StoryDetailHeader(
    story: com.dunzi.storyhouse.data.model.Story,
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    onShare: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 返回按钮
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        
        // 标题
        Text(
            text = story.title,
            style = StoryTitleStyle.copy(fontSize = 18.sp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        
        // 收藏按钮
        IconButton(onClick = onToggleFavorite) {
            Icon(
                imageVector = if (story.isFavorite) {
                    Icons.Default.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                contentDescription = stringResource(R.string.btn_favorite),
                tint = if (story.isFavorite) FavoriteColor else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        // 分享按钮
        IconButton(onClick = onShare) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = stringResource(R.string.btn_share),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * 封面和基本信息
 */
@Composable
fun StoryCoverAndInfo(
    story: com.dunzi.storyhouse.data.model.Story,
    onPlay: () -> Unit,
    getAgeSuggestion: () -> String,
    getDurationDescription: () -> String,
    getDifficultyDescription: () -> String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 封面
        Card(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (story.coverImage.isNotBlank()) {
                    AsyncImage(
                        model = story.coverImage,
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
                
                // 播放按钮
                IconButton(
                    onClick = onPlay,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(PlayButtonColor.copy(alpha = 0.9f))
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = stringResource(R.string.btn_play),
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 标题
        Text(
            text = story.title,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 作者
        if (story.author.isNotBlank()) {
            Text(
                text = story.author,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        // 分类
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CategoryTag(
                category = story.category,
                modifier = Modifier
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 基本信息网格
        StoryInfoGrid(
            ageSuggestion = getAgeSuggestion(),
            duration = getDurationDescription(),
            difficulty = getDifficultyDescription(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * 故事信息网格
 */
@Composable
fun StoryInfoGrid(
    ageSuggestion: String,
    duration: String,
    difficulty: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // 年龄建议
        InfoItem(
            title = stringResource(R.string.story_age_range),
            value = ageSuggestion,
            modifier = Modifier.weight(1f)
        )
        
        // 时长
        InfoItem(
            title = stringResource(R.string.story_duration),
            value = duration,
            modifier = Modifier.weight(1f)
        )
        
        // 难度
        InfoItem(
            title = "难度",
            value = difficulty,
            modifier = Modifier.weight(1f)
        )
    }
}

/**
 * 信息项
 */
@Composable
fun InfoItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

/**
 * 播放进度部分
 */
@Composable
fun PlayProgressSection(
    progress: Float,
    completed: Boolean,
    onToggleReadStatus: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // 标题
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "播放进度",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                
                // 完成状态
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (completed) "已听完" else "未听完",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (completed) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    IconButton(
                        onClick = onToggleReadStatus,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = if (completed) "标记为未读" else "标记为已读",
                            tint = if (completed) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            },
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // 进度条
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = PlayerProgress,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 进度文本
            Text(
                text = "已播放 ${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * 播放统计部分
 */
@Composable
fun PlayStatsSection(
    playStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary,
    getPlayCount: () -> Int,
    getAveragePlayTime: () -> String,
    getCompletionRate: () -> String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "播放统计",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // 播放次数
                StatItem(
                    title = "播放次数",
                    value = getPlayCount().toString(),
                    unit = "次",
                    modifier = Modifier.weight(1f)
                )
                
                // 平均时长
                StatItem(
                    title = "平均时长",
                    value = getAveragePlayTime(),
                    unit = "",
                    modifier = Modifier.weight(1f)
                )
                
                // 完成率
                StatItem(
                    title = "完成率",
                    value = getCompletionRate(),
                    unit = "",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

/**
 * 统计项
 */
@Composable
fun StatItem(
    title: String,
    value: String,
    unit: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
            
            if (unit.isNotBlank()) {
                Text(
                    text = unit,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * 故事描述部分
 */
@Composable
fun StoryDescriptionSection(
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "故事简介",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = androidx.compose.ui.unit.sp(24),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

/**
 * 故事标签部分
 */
@Composable
fun StoryTagsSection(
    tags: List<String>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "故事标签",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            // 标签流式布局
            FlowLayout(
                items = tags,
                modifier = Modifier.fillMaxWidth()
            ) { tag ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(TagBackground)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = tag,
                        style = TagTextStyle,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

/**
 * 故事章节部分
 */
@Composable
fun StoryChaptersSection(
    chapters: List<com.dunzi.storyhouse.data.model.Story.Chapter>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "故事章节",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            chapters.forEachIndexed { index, chapter ->
                ChapterItem(
                    chapter = chapter,
                    index = index + 1,
                    modifier = Modifier.fillMaxWidth()
                )
                
                if (index < chapters.size - 1) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

/**
 * 章节项
 */
@Composable
fun ChapterItem(
    chapter: com.dunzi.storyhouse.data.model.Story.Chapter,
    index: Int,
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
            // 章节编号
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = index.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            
            Spacer(modifier = Modifier.width(12.dp))
            
            // 章节信息
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = chapter.title,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = chapter.getDurationString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Spacer(modifier = Modifier.width(12.dp))
            
            // 播放按钮
            IconButton(
                onClick = { /* TODO: 播放章节 */ },
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "播放章节",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

/**
 * 相关故事部分
 */
@Composable
fun RelatedStoriesSection(
    stories: List<com.dunzi.storyhouse.data.model.Story>,
    onStoryClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "相关故事",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        // 水平滚动列表
        androidx.compose.foundation.lazy.LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(stories) { story ->
                StoryCard(
                    story = story,
                    onStoryClick = { onStoryClick(story.id) },
                    onToggleFavorite = { /* TODO: 切换收藏 */ },
                    modifier = Modifier.width(160.dp)
                )
            }
        }
    }
}

/**
 * 流式布局（用于标签显示）
 */
@Composable
fun FlowLayout(
    items: List<String>,
    modifier: Modifier = Modifier,
    content: @Composable (String) -> Unit
) {
    var currentRowWidth = 0
    val rows = mutableListOf<MutableList<String>>()
    val currentRow = mutableListOf<String>()
    
    // 简单分组逻辑（实际项目中应该使用更复杂的布局）
    items.forEach { item ->
        // 假设每个标签大约80dp宽
        val itemWidth = 80
        if (currentRowWidth + itemWidth > 360) { // 假设屏幕宽度
            rows.add(ArrayList(currentRow))
            currentRow.clear()
            currentRowWidth = 0
        }
        currentRow.add(item)
        currentRowWidth += itemWidth
    }
    if (currentRow.isNotEmpty()) {
        rows.add(currentRow)
    }
    
    Column(modifier = modifier) {
        rows.forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                rowItems.forEach { item ->
                    content(item)
                }
            }
        }
    }
}