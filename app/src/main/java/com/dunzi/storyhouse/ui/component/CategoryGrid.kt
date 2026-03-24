package com.dunzi.storyhouse.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.outlined.Nature
import androidx.compose.material.icons.outlined.Science
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dunzi.storyhouse.ui.theme.ChildrenStoryAppTheme

/**
 * 首页分类网格
 */
@Composable
fun CategoryGrid(
    modifier: Modifier = Modifier,
    onCategoryClick: (String) -> Unit,
) {
    val categories = remember {
        listOf(
            CategoryItem("历史", Icons.Filled.History, Color(0xFFE3F2FD)),
            CategoryItem("图书", Icons.Filled.LibraryBooks, Color(0xFFFCE4EC)),
            CategoryItem("音乐", Icons.Filled.MusicNote, Color(0xFFE8F5E9)),
            CategoryItem("自然", Icons.Outlined.Nature, Color(0xFFFFF3E0)),
            CategoryItem("宠物", Icons.Filled.Pets, Color(0xFFEDE7F6)),
            CategoryItem("科学", Icons.Outlined.Science, Color(0xFFE0F7FA)),
            CategoryItem("收藏", Icons.Filled.Favorite, Color(0xFFFFEBEE)),
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp),
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) { item ->
            CategoryCard(item = item) {
                onCategoryClick(item.label)
            }
        }
    }
}

@Composable
private fun CategoryCard(
    item: CategoryItem,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = item.bgColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(text = item.label, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        }
    }
}

data class CategoryItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val bgColor: Color
)

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun CategoryGridPreview() {
    ChildrenStoryAppTheme {
        CategoryGrid(onCategoryClick = {})
    }
}
