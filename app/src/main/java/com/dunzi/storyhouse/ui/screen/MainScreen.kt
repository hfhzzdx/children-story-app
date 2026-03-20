package com.dunzi.storyhouse.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.component.CategoryGrid
import com.dunzi.storyhouse.ui.component.StatCard
import com.dunzi.storyhouse.ui.component.StoryCard
import com.dunzi.storyhouse.ui.component.WelcomeBanner
import com.dunzi.storyhouse.ui.component.getDefaultCategories
import com.dunzi.storyhouse.ui.viewmodel.MainViewModel

/**
 * 主界面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onStoryClick: (Long) -> Unit = {},
    onSettingClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {}
) {
    val uiState = viewModel.uiState.value
    val snackbarHostState = remember { SnackbarHostState() }
    
    // 显示错误消息
    LaunchedEffect(uiState.error) {
        uiState.error?.let { error ->
            snackbarHostState.showSnackbar(error)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            MainTopBar(
                onSettingClick = onSettingClick,
                onHistoryClick = onHistoryClick
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
                uiState.isLoading -> {
                    // 加载中
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                
                !uiState.hasStories -> {
                    // 没有故事
                    EmptyStateScreen(
                        onImportClick = { /* TODO: 打开导入界面 */ }
                    )
                }
                
                else -> {
                    // 显示主内容
                    MainContentScreen(
                        uiState = uiState,
                        onSearch = viewModel::searchStories,
                        onClearSearch = viewModel::clearSearch,
                        onToggleFavorite = viewModel::toggleFavorite,
                        onStoryClick = { /* TODO: 打开故事详情 */ },
                        onCategoryClick = { /* TODO: 显示分类故事 */ }
                    )
                }
            }
        }
    }
}

/**
 * 空状态界面
 */
@Composable
fun EmptyStateScreen(
    onImportClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.empty_no_stories),
                style = com.dunzi.storyhouse.ui.theme.ChildLargeText
            )
            Text(
                text = stringResource(R.string.tip_add_first_story),
                style = com.dunzi.storyhouse.ui.theme.ChildMediumText,
                modifier = Modifier.padding(top = 8.dp)
            )
            // TODO: 添加导入按钮
        }
    }
}

/**
 * 主内容界面
 */
@Composable
fun MainContentScreen(
    uiState: MainViewModel.MainUiState,
    onSearch: (String) -> Unit,
    onClearSearch: () -> Unit,
    onToggleFavorite: (Long) -> Unit,
    onStoryClick: (Long) -> Unit,
    onCategoryClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 搜索栏
        SearchBar(
            query = uiState.searchQuery,
            onQueryChange = onSearch,
            onClear = onClearSearch,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        
        // 内容区域
        if (uiState.isSearching) {
            // 搜索结果
            SearchResultsScreen(
                stories = uiState.searchResults,
                onStoryClick = onStoryClick,
                onToggleFavorite = onToggleFavorite
            )
        } else {
            // 主内容
            MainContent(
                uiState = uiState,
                onStoryClick = onStoryClick,
                onToggleFavorite = onToggleFavorite,
                onCategoryClick = onCategoryClick
            )
        }
    }
}

/**
 * 搜索栏
 */
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    com.dunzi.storyhouse.ui.component.SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onClear = onClear,
        modifier = modifier
    )
}

/**
 * 搜索结果界面
 */
@Composable
fun SearchResultsScreen(
    stories: List<com.dunzi.storyhouse.data.model.Story>,
    onStoryClick: (Long) -> Unit,
    onToggleFavorite: (Long) -> Unit
) {
    if (stories.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.search_no_results),
                style = com.dunzi.storyhouse.ui.theme.ChildMediumText,
                color = com.dunzi.storyhouse.ui.theme.TextSecondary
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
        ) {
            items(stories) { story ->
                StoryCard(
                    story = story,
                    onStoryClick = { onStoryClick(story.id) },
                    onToggleFavorite = { onToggleFavorite(story.id) },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

/**
 * 主内容
 */
@Composable
fun MainContent(
    uiState: MainViewModel.MainUiState,
    onStoryClick: (Long) -> Unit,
    onToggleFavorite: (Long) -> Unit,
    onCategoryClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        // 欢迎横幅
        item {
            WelcomeBanner(
                childName = uiState.childName,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 统计卡片
        item {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    title = "总故事数",
                    value = uiState.totalStories.toString(),
                    icon = Icons.Default.Star,
                    modifier = Modifier.weight(1f)
                )
                
                StatCard(
                    title = "播放次数",
                    value = uiState.totalPlayCount.toString(),
                    icon = Icons.Default.PlayArrow,
                    modifier = Modifier.weight(1f)
                )
                
                StatCard(
                    title = "最近播放",
                    value = uiState.recentPlayCount.toString(),
                    icon = Icons.Default.History,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        
        // 分类网格
        item {
            CategoryGrid(
                categories = getDefaultCategories(),
                onCategoryClick = onCategoryClick,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 最近播放
        if (uiState.recentStories.isNotEmpty()) {
            item {
                StorySection(
                    title = stringResource(R.string.recent_stories),
                    stories = uiState.recentStories,
                    onStoryClick = onStoryClick,
                    onToggleFavorite = onToggleFavorite,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
        
        // 推荐故事
        if (uiState.recommendedStories.isNotEmpty()) {
            item {
                StorySection(
                    title = stringResource(R.string.recommended_stories),
                    stories = uiState.recommendedStories,
                    onStoryClick = onStoryClick,
                    onToggleFavorite = onToggleFavorite,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
        
        // 收藏故事
        if (uiState.favoriteStories.isNotEmpty()) {
            item {
                StorySection(
                    title = stringResource(R.string.favorite_stories),
                    stories = uiState.favoriteStories,
                    onStoryClick = onStoryClick,
                    onToggleFavorite = onToggleFavorite,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
        
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/**
 * 故事分区
 */
@Composable
fun StorySection(
    title: String,
    stories: List<com.dunzi.storyhouse.data.model.Story>,
    onStoryClick: (Long) -> Unit,
    onToggleFavorite: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // 标题
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = com.dunzi.storyhouse.ui.theme.SectionTitleStyle,
                color = com.dunzi.storyhouse.ui.theme.TextPrimary
            )
            
            Text(
                text = stringResource(R.string.view_all),
                style = com.dunzi.storyhouse.ui.theme.ViewAllTextStyle,
                color = com.dunzi.storyhouse.ui.theme.PrimaryColor,
                modifier = androidx.compose.ui.Modifier.clickable { /* TODO: 查看全部 */ }
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 故事列表
        androidx.compose.foundation.lazy.LazyRow(
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)
        ) {
            items(stories) { story ->
                StoryCard(
                    story = story,
                    onStoryClick = { onStoryClick(story.id) },
                    onToggleFavorite = { onToggleFavorite(story.id) },
                    modifier = Modifier.width(160.dp)
                )
            }
        }
    }
}

/**
 * 主界面顶部栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    onSettingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = "小墩子故事屋",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        },
        actions = {
            IconButton(onClick = onSettingClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "设置"
                )
            }
        },
        modifier = modifier
    )
}
