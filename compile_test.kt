// 简单的Kotlin语法测试
fun main() {
    println("=== 儿童故事应用代码语法测试 ===")
    
    // 测试基本语法
    val storyTitle = "三只小猪"
    val storyDuration = 600000L // 10分钟
    val isFavorite = true
    
    println("故事标题: $storyTitle")
    println("故事时长: ${storyDuration / 60000}分钟")
    println("是否收藏: $isFavorite")
    
    // 测试集合操作
    val categories = listOf("童话", "寓言", "儿歌", "科普")
    println("分类列表: ${categories.joinToString(", ")}")
    
    // 测试函数
    val totalPlayTime = calculateTotalPlayTime(listOf(300000L, 450000L, 600000L))
    println("总播放时长: ${totalPlayTime / 60000}分钟")
    
    println("=== 测试完成 ===")
}

fun calculateTotalPlayTime(durations: List<Long>): Long {
    return durations.sum()
}

// 测试数据类
data class Story(
    val id: Long,
    val title: String,
    val author: String,
    val duration: Long,
    val category: String
)

// 测试密封类
sealed class PlaybackState {
    object Idle : PlaybackState()
    object Playing : PlaybackState()
    object Paused : PlaybackState()
    data class Error(val message: String) : PlaybackState()
}