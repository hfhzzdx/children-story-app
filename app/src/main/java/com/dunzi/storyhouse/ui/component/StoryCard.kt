package com.dunzi.storyhouse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.data.model.Story
import com.dunzi.storyhouse.ui.theme.FavoriteColor
import com.dunzi.storyhouse.ui.theme.StoryCardBackground
import com.dunzi.storyhouse.ui.theme.StoryCardShadow
import com.dunzi.storyhouse.ui.theme.StoryDescriptionStyle
import com.dunzi.storyhouse.ui.theme.StoryTitleStyle
import com.dunzi.storyhouse.ui.theme.TagBackground
import com.dunzi.storyhouse.ui.theme.TagText
import com.dunzi.storyhouse.ui.theme.TagTextStyle

/**
 * 故事卡片组件
 */
@Composable
fun StoryCard(
    story: Story,
    onStoryClick: (Long) -> Unit,
    onToggleFavorite: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(160.dp)
            .height(200.dp)
            .clickable { onStoryClick(story.id) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = StoryCardBackground
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // 封面图片
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
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
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
                
                // 收藏按钮
                IconButton(
                    onClick = { onToggleFavorite(story.id) },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = if (story.isFavorite) {
                            Icons.Default.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = stringResource(R.string.btn_favorite),
                        tint = if (story.isFavorite) FavoriteColor else Color.Gray
                    )
                }
                
                // 播放进度指示器
                if (story.progress > 0) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .align(Alignment.BottomStart)
                            .background(Color.Gray.copy(alpha = 0.3f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(story.progress)
                                .height(4.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                }
            }
            
            // 故事信息
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                // 标题
                Text(
                    text = story.title,
                    style = StoryTitleStyle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                // 作者
                if (story.author.isNotBlank()) {
                    Text(
                        text = story.author,
                        style = StoryDescriptionStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
                
                // 标签和时长
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // 年龄标签
                    if (story.minAge > 0 || story.maxAge > 0) {
                        AgeTag(
                            minAge = story.minAge,
                            maxAge = story.maxAge,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    // 时长
                    if (story.duration > 0) {
                        Text(
                            text = story.getDurationString(),
                            style = TagTextStyle,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}



/**
 * 故事列表项组件（用于列表视图）
 */
@Composable
fun StoryListItem(
    story: Story,
    onStoryClick: (Long) -> Unit,
    onToggleFavorite: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onStoryClick(story.id) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 封面缩略图
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
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
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
                
                // 播放进度指示器
                if (story.progress > 0) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp)
                            .align(Alignment.BottomStart)
                            .background(Color.Gray.copy(alpha = 0.3f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(story.progress)
                                .height(3.dp)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // 故事信息
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // 标题和收藏按钮
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = story.title,
                        style = StoryTitleStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    
                    IconButton(
                        onClick = { onToggleFavorite(story.id) },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = if (story.isFavorite) {
                                Icons.Default.Favorite
                            } else {
                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = stringResource(R.string.btn_favorite),
                            tint = if (story.isFavorite) FavoriteColor else Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(4.dp))
                
                // 作者和分类
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (story.author.isNotBlank()) {
                        Text(
                            text = story.author,
                            style = StoryDescriptionStyle,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    // 分类标签
                    CategoryTag(
                        category = story.category,
                        modifier = Modifier
                    )
                }
                
                Spacer(modifier = Modifier.height(4.dp))
                
                // 时长和年龄
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // 时长
                    if (story.duration > 0) {
                        Text(
                            text = story.getDurationString(),
                            style = TagTextStyle,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    // 年龄
                    AgeTag(
                        minAge = story.minAge,
                        maxAge = story.maxAge,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

