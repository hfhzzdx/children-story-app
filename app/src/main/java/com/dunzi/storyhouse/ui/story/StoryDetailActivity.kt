package com.dunzi.storyhouse.ui.story

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dunzi.storyhouse.ui.theme.ChildrenStoryAppTheme

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
    
    private val viewModel: com.dunzi.storyhouse.ui.story.StoryDetailViewModel by viewModels()
    
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
