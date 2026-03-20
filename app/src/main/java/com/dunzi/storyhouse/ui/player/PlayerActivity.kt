package com.dunzi.storyhouse.ui.player

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
 * 播放器活动
 */
@AndroidEntryPoint
class PlayerActivity : ComponentActivity() {
    
    private val viewModel: PlayerViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 设置边缘到边缘显示
        WindowCompat.setDecorFitsSystemWindows(window, false)
        
        // 获取传递的故事ID
        val storyId = intent.getLongExtra("story_id", -1L)
        if (storyId != -1L) {
            // TODO: 加载故事并开始播放
        }
        
        setContent {
            ChildrenStoryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlayerScreen(
                        viewModel = viewModel,
                        onBack = { finish() }
                    )
                }
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        // 恢复播放器状态
    }
    
    override fun onPause() {
        super.onPause()
        // 保存播放器状态
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // 清理资源
    }
    
    companion object {
        /**
         * 启动播放器活动
         */
        fun startActivity(context: android.content.Context, storyId: Long) {
            val intent = android.content.Intent(context, PlayerActivity::class.java).apply {
                putExtra("story_id", storyId)
                flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
    }
}