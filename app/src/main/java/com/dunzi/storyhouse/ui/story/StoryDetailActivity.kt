package com.dunzi.storyhouse.ui.story

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.theme.ChildrenStoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 故事详情活动
 */
@AndroidEntryPoint
class StoryDetailActivity : ComponentActivity() {
    
    companion object {
        const val EXTRA_STORY_ID = "story_id"
        
        /**
         * 启动故事详情活动
         */
        fun startActivity(context: android.content.Context, storyId: Long) {
            val intent = android.content.Intent(context, StoryDetailActivity::class.java).apply {
                putExtra(EXTRA_STORY_ID, storyId)
                flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
    }
    
    private val viewModel: StoryDetailViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val storyId = intent.getLongExtra(EXTRA_STORY_ID, -1L)
        if (storyId == -1L) {
            finish()
            return
        }
        
        setContent {
            ChildrenStoryAppTheme {
                StoryDetailScreen(
                    storyId = storyId,
                    viewModel = viewModel,
                    onBack = { finish() }
                )
            }
        }
    }
}

/**
 * 故事详情视图模型
 */
@AndroidEntryPoint
class StoryDetailViewModel @androidx.hilt.lifecycle.ViewModelInject constructor(
    private val storyRepository: com.dunzi.storyhouse.data.repository.StoryRepository
) : androidx.lifecycle.ViewModel() {
    
    private val _story = androidx.compose.runtime.mutableStateOf<com.dunzi.storyhouse.data.model.Story?>(null)
    val story: androidx.compose.runtime.State<com.dunzi.storyhouse.data.model.Story?> = _story
    
    private val _isLoading = androidx.compose.runtime.mutableStateOf(true)
    val isLoading: androidx.compose.runtime.State<Boolean> = _isLoading
    
    private val _error = androidx.compose.runtime.mutableStateOf<String?>(null)
    val error: androidx.compose.runtime.State<String?> = _error
    
    fun loadStory(storyId: Long) {
        _isLoading.value = true
        _error.value = null
        
        viewModelScope.launch {
            try {
                storyRepository.getStoryById(storyId).collect { story ->
                    _story.value = story
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                _error.value = "加载故事失败: ${e.message}"
                _isLoading.value = false
            }
        }
    }
    
    fun toggleFavorite(storyId: Long) {
        viewModelScope.launch {
            try {
                val currentStory = _story.value
                if (currentStory != null) {
                    val isFavorite = currentStory.isFavorite
                    storyRepository.toggleFavorite(storyId, !isFavorite)
                    
                    // 更新本地状态
                    _story.value = currentStory.copy(isFavorite = !isFavorite)
                }
            } catch (e: Exception) {
                _error.value = "收藏操作失败: ${e.message}"
            }
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}

/**
 * 故事详情界面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailScreen(
    storyId: Long,
    viewModel: StoryDetailViewModel,
    onBack: () -> Unit
) {
    val story by viewModel.story
    val isLoading by viewModel.isLoading
    val error by viewModel.error
    val snackbarHostState = remember { androidx.compose.material3.SnackbarHostState() }
    
    // 加载故事
    LaunchedEffect(storyId) {
        viewModel.loadStory(storyId)
    }
    
    // 显示错误消息
    LaunchedEffect(error) {
        error?.let { errorMessage ->
            snackbarHostState.showSnackbar(errorMessage)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            StoryDetailTopBar(
                storyTitle = story?.title ?: "",
                isFavorite = story?.isFavorite ?: false,
                onBack = onBack,
                onToggleFavorite = { viewModel.toggleFavorite(storyId) }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                isLoading -> {
                    // 加载中
                    Box(
                        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                
                story == null -> {
                    // 故事不存在
                    EmptyStoryScreen(
                        onBack = onBack,
                        modifier = androidx.compose.ui.Modifier.fillMaxSize()
                    )
                }
                
                else -> {
                    // 显示故事详情
                    StoryDetailContent(
                        story = story!!,
                        modifier = androidx.compose.ui.Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

/**
 * 故事详情顶部栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailTopBar(
    storyTitle: String,
    isFavorite: Boolean,
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = storyTitle,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        actions = {
            // 收藏按钮
            IconButton(onClick = onToggleFavorite) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(R.string.btn_favorite),
                    tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
            }
            
            // 分享按钮
            IconButton(onClick = { /* TODO: 实现分享功能 */ }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(R.string.btn_share)
                )
            }
        },
        modifier = modifier
    )
}

/**
 * 空故事界面
 */
@Composable
fun EmptyStoryScreen(
    onBack: () -> Unit,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = stringResource(R.string.story_title),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = androidx.compose.ui.Modifier.size(64.dp)
        )
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        
        Text(
            text = stringResource(R.string.story_not_found),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
        
        Text(
            text = stringResource(R.string.tip_go_back),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))
        
        Button(onClick = onBack) {
            Text(text = stringResource(R.string.go_back))
        }
    }
}

/**
 * 故事详情内容
 */
@Composable
fun StoryDetailContent(
    story: com.dunzi.storyhouse.data.model.Story,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // 封面图片
        Card(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            if (story.coverImage.isNotBlank()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(story.coverImage)
                        .crossfade(true)
                        .build(),
                    contentDescription = stringResource(R.string.story_cover),
                    contentScale = ContentScale.Crop,
                    modifier = androidx.compose.ui.Modifier.fillMaxSize()
                )
            } else {
                Box(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = stringResource(R.string.story_cover),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = androidx.compose.ui.Modifier.size(48.dp)
                    )
                }
            }
        }
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        
        // 标题
        Text(
            text = story.title,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
        
        // 作者和分类
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = story.author,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            androidx.compose.material3.Text(
                text = " • ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Text(
                text = story.category,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        
        // 年龄和时长信息
        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
        ) {
            // 年龄范围
            Card(
                shape = CircleShape,
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = androidx.compose.ui.Modifier
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = "${story.minAge}-${story.maxAge}岁",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = androidx.compose.ui.Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
            
            // 时长
            Text(
                text = "${story.duration / 60}分钟",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        
        // 标签
        if (story.tags.isNotEmpty()) {
            FlowLayout(
                items = story.tags,
                modifier = androidx.compose.ui.Modifier.fillMaxWidth()
            ) { tag ->
                Card(
                    shape = MaterialTheme.shapes.small,
                    colors = androidx.compose.material3.CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = androidx.compose.ui.Modifier.padding(end = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = tag,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = androidx.compose.ui.Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
            
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        }
        
        // 描述
        Text(
            text = stringResource(R.string.story_description),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
        
        Text(
            text = story.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 24.sp
        )
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))
        
        // 播放按钮
        Button(
            onClick = { /* TODO: 实现播放功能 */ },
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = stringResource(R.string.btn_play),
                modifier = androidx.compose.ui.Modifier.size(24.dp)
            )
            
            Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))
            
            Text(
                text = stringResource(R.string.btn_play),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        
        // 统计信息
        Card(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = androidx.compose.ui.Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.stats_title),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
                
                Row(
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = story.playCount.toString(),
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = stringResource(R.string.stats_play_count),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = if (story.progress >= 1.0f) "✓" else "${(story.progress * 100).toInt()}%",
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = stringResource(R.string.story_progress),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = if (story.isFavorite) "♥" else "♡",
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                            color = if (story.isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = stringResource(R.string.story_favorite),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = androidx.compose.ui.Modifier.height(32.dp))
    }
}

// 导入缺失的依赖
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.theme.ChildrenStoryAppTheme

// 添加缺失的字符串资源引用
private const val STORY_NOT_FOUND = "故事不存在"
private const val TIP_GO_BACK = "请返回主界面选择其他故事"
private const val STATS_TITLE = "统计信息"
private const val STATS_PLAY_COUNT = "播放次数"