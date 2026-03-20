package com.dunzi.storyhouse.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 播放历史视图模型
 */
@HiltViewModel
class PlayHistoryViewModel @Inject constructor(
    private val playHistoryRepository: PlayHistoryRepository
) : ViewModel() {
    
    // 播放历史状态
    private val _historyState = MutableStateFlow(PlayHistoryState())
    val historyState: StateFlow<PlayHistoryState> = _historyState.asStateFlow()
    
    // 加载播放历史
    fun loadPlayHistory() {
        _historyState.update { it.copy(isLoading = true) }
        
        viewModelScope.launch {
            try {
                // 加载播放历史
                val history = playHistoryRepository.getPlayHistory("default", 50)
                
                // 加载统计信息
                val stats = playHistoryRepository.getPlayStatsSummary("default")
                
                // 加载最常播放的故事
                val mostPlayed = playHistoryRepository.getMostPlayedStories("default", 10)
                
                _historyState.update { state ->
                    state.copy(
                        playHistory = history,
                        playStats = stats,
                        mostPlayedStories = mostPlayed,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _historyState.update { state ->
                    state.copy(
                        isLoading = false,
                        error = "加载播放历史失败: ${e.message}"
                    )
                }
            }
        }
    }
    
    /**
     * 清除播放历史
     */
    fun clearPlayHistory() {
        viewModelScope.launch {
            try {
                playHistoryRepository.clearPlayHistory("default")
                
                // 重新加载数据
                loadPlayHistory()
            } catch (e: Exception) {
                _historyState.update { state ->
                    state.copy(error = "清除播放历史失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 删除单个播放记录
     */
    fun deleteHistoryItem(historyId: Long) {
        viewModelScope.launch {
            try {
                playHistoryRepository.deletePlayHistory(historyId)
                
                // 重新加载数据
                loadPlayHistory()
            } catch (e: Exception) {
                _historyState.update { state ->
                    state.copy(error = "删除播放记录失败: ${e.message}")
                }
            }
        }
    }
    
    /**
     * 清除错误
     */
    fun clearError() {
        _historyState.update { it.copy(error = null) }
    }
    
    /**
     * 播放历史状态
     */
    data class PlayHistoryState(
        val playHistory: List<com.dunzi.storyhouse.data.model.PlayHistory> = emptyList(),
        val playStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary? = null,
        val mostPlayedStories: List<com.dunzi.storyhouse.data.repository.PlayHistoryRepository.StoryPlayStats> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null
    ) {
        /**
         * 检查是否有播放历史
         */
        val hasHistory: Boolean
            get() = playHistory.isNotEmpty()
        
        /**
         * 获取按日期分组的播放历史
         */
        val historyByDate: Map<String, List<com.dunzi.storyhouse.data.model.PlayHistory>>
            get() = playHistory.groupBy { history ->
                val date = history.playedAt
                // 简单按日期分组（实际项目中应该使用更复杂的逻辑）
                "${date.year + 1900}-${date.month + 1}-${date.date}"
            }
        
        /**
         * 获取总播放时长（分钟）
         */
        val totalPlayTimeMinutes: Int
            get() = playStats?.totalPlayTime?.div(60) ?: 0
        
        /**
         * 获取总播放次数
         */
        val totalPlayCount: Int
            get() = playStats?.totalPlayCount ?: 0
        
        /**
         * 获取平均播放时长（分钟）
         */
        val averagePlayTimeMinutes: Int
            get() = if (totalPlayCount > 0) totalPlayTimeMinutes / totalPlayCount else 0
    }
}