package com.dunzi.storyhouse.ui.history

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.dunzi.storyhouse.ui.theme.ChildrenStoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 播放历史活动
 */
@AndroidEntryPoint
class PlayHistoryActivity : ComponentActivity() {
    
    private val viewModel: PlayHistoryViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 设置边缘到边缘显示
        WindowCompat.setDecorFitsSystemWindows(window, false)
        
        setContent {
            ChildrenStoryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlayHistoryScreen(
                        viewModel = viewModel,
                        onBack = { finish() }
                    )
                }
            }
        }
    }
    
    companion object {
        /**
         * 启动播放历史活动
         */
        fun startActivity(context: android.content.Context) {
            val intent = android.content.Intent(context, PlayHistoryActivity::class.java).apply {
                flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
    }
}