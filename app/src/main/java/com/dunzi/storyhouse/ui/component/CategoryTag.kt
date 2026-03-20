package com.dunzi.storyhouse.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dunzi.storyhouse.ui.theme.CategoryTagBackground
import com.dunzi.storyhouse.ui.theme.CategoryTagTextStyle

/**
 * 分类标签组件
 */
@Composable
fun CategoryTag(
    category: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = CategoryTagBackground,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = category,
            style = CategoryTagTextStyle,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}