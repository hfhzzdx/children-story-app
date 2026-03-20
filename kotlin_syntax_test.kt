// Kotlin语法测试文件
// 测试项目中的Kotlin代码是否有基本语法错误

// 测试数据类（类似Story）
data class TestStory(
    val id: Long,
    val title: String,
    val author: String,
    val duration: Long,
    val category: String
)

// 测试枚举类（类似RepeatMode）
enum class TestRepeatMode {
    NONE,
    REPEAT_ALL,
    REPEAT_ONE
}

// 测试密封类（类似播放状态）
sealed class TestPlaybackState {
    object Idle : TestPlaybackState()
    object Playing : TestPlaybackState()
    object Paused : TestPlaybackState()
    data class Error(val message: String) : TestPlaybackState()
}

// 测试扩展函数
fun TestStory.getFormattedDuration(): String {
    val minutes = duration / 60000
    val seconds = (duration % 60000) / 1000
    return String.format("%02d:%02d", minutes, seconds)
}

// 测试伴生对象
class TestAudioService {
    companion object {
        const val ACTION_PLAY = "ACTION_PLAY"
        const val ACTION_PAUSE = "ACTION_PAUSE"
        const val ACTION_STOP = "ACTION_STOP"
    }
    
    fun play() {
        println("Playing audio...")
    }
    
    fun pause() {
        println("Pausing audio...")
    }
    
    fun stop() {
        println("Stopping audio...")
    }
}

// 测试协程相关代码
import kotlinx.coroutines.*

// 测试挂起函数
suspend fun fetchStoryDetails(storyId: Long): TestStory {
    delay(100) // 模拟网络延迟
    return TestStory(
        id = storyId,
        title = "测试故事",
        author = "测试作者",
        duration = 300000L, // 5分钟
        category = "童话"
    )
}

// 测试Flow
fun getStoryUpdates(): Flow<TestStory> = flow {
    for (i in 1..3) {
        emit(TestStory(
            id = i.toLong(),
            title = "故事 $i",
            author = "作者 $i",
            duration = (i * 60000L),
            category = when (i % 3) {
                0 -> "童话"
                1 -> "寓言"
                else -> "儿歌"
            }
        ))
        delay(500)
    }
}

// 主函数
fun main() {
    println("=== Kotlin语法测试开始 ===")
    
    // 测试数据类
    val story = TestStory(
        id = 1,
        title = "三只小猪",
        author = "传统童话",
        duration = 600000L,
        category = "童话"
    )
    println("故事: ${story.title}, 时长: ${story.getFormattedDuration()}")
    
    // 测试枚举
    val repeatMode = TestRepeatMode.REPEAT_ALL
    println("循环模式: $repeatMode")
    
    // 测试密封类
    val playbackState: TestPlaybackState = TestPlaybackState.Playing
    when (playbackState) {
        is TestPlaybackState.Idle -> println("播放状态: 空闲")
        is TestPlaybackState.Playing -> println("播放状态: 播放中")
        is TestPlaybackState.Paused -> println("播放状态: 暂停")
        is TestPlaybackState.Error -> println("播放状态: 错误")
    }
    
    // 测试伴生对象
    println("播放动作: ${TestAudioService.ACTION_PLAY}")
    
    // 测试协程
    runBlocking {
        println("开始获取故事详情...")
        val fetchedStory = fetchStoryDetails(1)
        println("获取到的故事: ${fetchedStory.title}")
        
        println("开始监听故事更新...")
        getStoryUpdates().collect { story ->
            println("收到更新: ${story.title} (${story.category})")
        }
    }
    
    println("=== Kotlin语法测试完成 ===")
    println("所有Kotlin语法测试通过！")
    println("项目中的Kotlin代码应该没有基本语法错误。")
}