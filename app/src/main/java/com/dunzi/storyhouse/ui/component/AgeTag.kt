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
import com.dunzi.storyhouse.ui.theme.AgeTagBackground
import com.dunzi.storyhouse.ui.theme.AgeTagTextStyle

/**
 * 年龄标签组件
 */
@Composable
fun AgeTag(
    minAge: Int,
    maxAge: Int = 0,
    modifier: Modifier = Modifier
) {
    val ageText = if (maxAge > 0) {
        "${minAge}-${maxAge}岁"
    } else {
        "${minAge}+岁"
    }
    
    Box(
        modifier = modifier
            .background(
                color = AgeTagBackground,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = ageText,
            style = AgeTagTextStyle,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}