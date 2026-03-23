package com.dunzi.storyhouse.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.dunzi.storyhouse.ui.history.PlayHistoryActivity
import com.dunzi.storyhouse.ui.setting.SettingActivity
import com.dunzi.storyhouse.ui.story.StoryDetailActivity
import com.dunzi.storyhouse.ui.theme.ChildrenStoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 主活动
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private val viewModel: com.dunzi.storyhouse.ui.screen.MainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        // 安装启动屏
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }
        
        super.onCreate(savedInstanceState)
        
        // 设置边缘到边缘显示
        WindowCompat.setDecorFitsSystemWindows(window, false)
        
        setContent {
            ChildrenStoryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        viewModel = viewModel,
                        onStoryClick = { storyId ->
                            StoryDetailActivity.startActivity(this, storyId)
                        },
                        onSettingClick = {
                            SettingActivity.startActivity(this)
                        },
                        onHistoryClick = {
                            PlayHistoryActivity.startActivity(this)
                        }
                    )
                }
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
    
    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}