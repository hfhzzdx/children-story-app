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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.History as HistoryOutlined
import androidx.compose.material.icons.outlined.LibraryBooks as LibraryBooksOutlined
import androidx.compose.material.icons.outlined.MusicNote as MusicNoteOutlined
import androidx.compose.material.icons.outlined.Nature as NatureOutlined
import androidx.compose.material.icons.outlined.Pets as PetsOutlined
import androidx.compose.material.icons.outlined.Science as ScienceOutlined
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.theme.CategoryCardBackground
import com.dunzi.storyhouse.ui.theme.CategoryCardTextStyle

/**
 * 分类网格组件
 */
@Composable
fun CategoryGrid(
    categories: List<CategoryItem>,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // 标题
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.category_title),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Text(
                text = stringResource(R.string.view_all),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { /* TODO: 查看全部分类 */ }
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // 分类网格
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                CategoryCard(
                    category = category,
                    onClick = { onCategoryClick(category.id) }
                )
            }
        }
    }
}

/**
 * 分类卡片
 */
@Composable
fun CategoryCard(
    category: CategoryItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(80.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 图标
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(CategoryCardBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = category.name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(28.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 名称
        Text(
            text = category.name,
            style = CategoryCardTextStyle,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}

/**
 * 分类项数据类
 */
data class CategoryItem(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val color: Color
)

/**
 * 获取默认分类列表
 */
fun getDefaultCategories(): List<CategoryItem> {
    return listOf(
        CategoryItem(
            id = "favorite",
            name = "收藏",
            icon = Icons.Default.Favorite,
            color = MaterialTheme.colorScheme.primary
        ),
        CategoryItem(
            id = "recent",
            name = "最近播放",
            icon = Icons.Default.History,
            color = MaterialTheme.colorScheme.secondary
        ),
        CategoryItem(
            id = "fairy_tale",
            name = "童话故事",
            icon = Icons.Default.Star,
            color = MaterialTheme.colorScheme.tertiary
        ),
        CategoryItem(
            id = "animal",
            name = "动物世界",
            icon = Icons.Default.Pets,
            color = MaterialTheme.colorScheme.primary
        ),
        CategoryItem(
            id = "nature",
            name = "自然科普",
            icon = Icons.Default.Nature,
            color = MaterialTheme.colorScheme.secondary
        ),
        CategoryItem(
            id = "science",
            name = "科学探索",
            icon = Icons.Default.Science,
            color = MaterialTheme.colorScheme.tertiary
        ),
        CategoryItem(
            id = "music",
            name = "音乐故事",
            icon = Icons.Default.MusicNote,
            color = MaterialTheme.colorScheme.primary
        ),
        CategoryItem(
            id = "classic",
            name = "经典名著",
            icon = Icons.Default.LibraryBooks,
            color = MaterialTheme.colorScheme.secondary
        )
    )
}