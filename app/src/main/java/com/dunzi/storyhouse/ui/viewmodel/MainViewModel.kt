package com.dunzi.storyhouse.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository
import com.dunzi.storyhouse.data.repository.StoryRepository
import com.dunzi.storyhouse.data.repository.UserSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 主视图模型
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val userSettingsRepository: UserSettingsRepository,
    private val playHistoryRepository: PlayHistoryRepository
) : ViewModel() {
    
    // 状态
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    // 加载状态
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    init {
        // 初始化数据
        initializeData()
        
        // 监听数据变化
        observeData()
    }
    
    /**
     * 初始化数据
     */
    private fun initializeData() {
        viewModelScope.launch {
            try {
                // 初始化用户设置
                userSettingsRepository.initializeUserSettings()
                
                // 更新最后登录时间
                userSettingsRepository.updateLastLogin()
                
                // 加载初始数据
                loadInitialData()
                
                _isLoading.value = false
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message ?: "初始化失败") }
                _isLoading.value = false
            }
        }
    }
    
    /**
     * 监听数据变化
     */
    private fun observeData() {
        viewModelScope.launch {
            combine(
                storyRepository.getAllStories(),
                storyRepository.getFavoriteStories(),
                storyRepository.getRecentlyPlayedStories(),
                userSettingsRepository.getUserSettings()
            ) { allStories, favoriteStories, recentStories, userSettings ->
                MainUiState(
                    allStories = allStories,
                    favoriteStories = favoriteStories,
                    recentStories = recentStories,
                    userSettings = userSettings,
                    isLoading = false,
                    error = null
                )
            }.collect { newState ->
                _uiState.update { newState }
            }
        }
    }
    
    /**
     * 加载初始数据
     */
    private suspend fun loadInitialData() {
        // 这里可以加载一些初始数据，比如推荐故事
        val userSettings = userSettingsRepository.getUserSettingsSummary()
        val recommendations = storyRepository.getRecommendations(
            userId = "default",
            age = userSettings.childAge,
            limit = 10
        )
        
        _uiState.update { it.copy(recommendedStories = recommendations) }
    }
    
    /**
     * 搜索故事
     */
    fun searchStories(query: String) {
        viewModelScope.launch {
            if (query.isBlank()) {
                _uiState.update { it.copy(searchResults = emptyList(), searchQuery = "") }
                return@launch
            }
            
            try {
                val results = storyRepository.searchStories(query)
                results.collect { stories ->
                    _uiState.update { it.copy(searchResults = stories, searchQuery = query) }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(error = "搜索失败: ${e.message}") }
            }
        }
    }
    
    /**
     * 清除搜索
     */
    fun clearSearch() {
        _uiState.update { it.copy(searchResults = emptyList(), searchQuery = "") }
    }
    
    /**
     * 切换收藏状态
     */
    fun toggleFavorite(storyId: Long) {
        viewModelScope.launch {
            try {
                val currentState = _uiState.value
                val isFavorite = currentState.favoriteStories.any { it.id == storyId }
                
                storyRepository.toggleFavorite(storyId, !isFavorite)
                
                // 更新本地状态
                if (isFavorite) {
                    _uiState.update { state ->
                        state.copy(
                            favoriteStories = state.favoriteStories.filter { it.id != storyId }
                        )
                    }
                } else {
                    val story = currentState.allStories.find { it.id == storyId }
                    story?.let {
                        _uiState.update { state ->
                            state.copy(
                                favoriteStories = state.favoriteStories + it
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(error = "收藏操作失败: ${e.message}") }
            }
        }
    }
    
    /**
     * 获取分类故事
     */
    fun getStoriesByCategory(category: String): List<com.dunzi.storyhouse.data.model.Story> {
        return _uiState.value.allStories.filter { it.category == category }
    }
    
    /**
     * 获取按年龄推荐的故事
     */
    fun getAgeAppropriateStories(): List<com.dunzi.storyhouse.data.model.Story> {
        val age = _uiState.value.userSettings?.childAge ?: 4
        return _uiState.value.allStories.filter { it.isSuitableForAge(age) }
    }
    
    /**
     * 获取播放统计
     */
    fun getPlayStats() {
        viewModelScope.launch {
            try {
                val stats = playHistoryRepository.getPlayStatsSummary("default")
                _uiState.update { it.copy(playStats = stats) }
            } catch (e: Exception) {
                // 忽略错误，统计信息不是关键功能
            }
        }
    }
    
    /**
     * 处理错误
     */
    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
    
    /**
     * 刷新数据
     */
    fun refreshData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                loadInitialData()
                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = "刷新失败: ${e.message}") }
            }
        }
    }
    
    /**
     * 活动恢复时调用
     */
    fun onResume() {
        // 更新播放统计
        getPlayStats()
    }
    
    /**
     * 活动暂停时调用
     */
    fun onPause() {
        // 保存状态等操作
    }
    
    /**
     * 活动销毁时调用
     */
    fun onDestroy() {
        // 清理资源
    }
    
    /**
     * 主界面UI状态
     */
    data class MainUiState(
        val allStories: List<com.dunzi.storyhouse.data.model.Story> = emptyList(),
        val favoriteStories: List<com.dunzi.storyhouse.data.model.Story> = emptyList(),
        val recentStories: List<com.dunzi.storyhouse.data.model.Story> = emptyList(),
        val recommendedStories: List<com.dunzi.storyhouse.data.model.Story> = emptyList(),
        val searchResults: List<com.dunzi.storyhouse.data.model.Story> = emptyList(),
        val searchQuery: String = "",
        val userSettings: com.dunzi.storyhouse.data.model.UserSettings? = null,
        val playStats: com.dunzi.storyhouse.data.repository.PlayHistoryRepository.PlayStatsSummary? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    ) {
        /**
         * 获取分类列表
         */
        val categories: List<String>
            get() = allStories.map { it.category }.distinct().sorted()
        
        /**
         * 获取按分类分组的故事
         */
        val storiesByCategory: Map<String, List<com.dunzi.storyhouse.data.model.Story>>
            get() = allStories.groupBy { it.category }
        
        /**
         * 检查是否有故事
         */
        val hasStories: Boolean
            get() = allStories.isNotEmpty()
        
        /**
         * 检查是否有收藏
         */
        val hasFavorites: Boolean
            get() = favoriteStories.isNotEmpty()
        
        /**
         * 检查是否有最近播放
         */
        val hasRecent: Boolean
            get() = recentStories.isNotEmpty()
        
        /**
         * 检查是否在搜索
         */
        val isSearching: Boolean
            get() = searchQuery.isNotBlank()
        
        /**
         * 获取当前显示的故事列表
         */
        val displayedStories: List<com.dunzi.storyhouse.data.model.Story>
            get() = if (isSearching) {
                searchResults
            } else {
                allStories
            }
    }
}