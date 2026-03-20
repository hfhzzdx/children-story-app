package com.dunzi.storyhouse.data

import com.dunzi.storyhouse.data.model.Story
import com.dunzi.storyhouse.data.model.UserSettings
import java.util.Date
import java.util.UUID

/**
 * 模拟数据生成器
 */
object MockDataGenerator {
    
    /**
     * 生成模拟故事列表
     */
    fun generateMockStories(): List<Story> {
        return listOf(
            Story(
                id = 1,
                title = "三只小猪",
                author = "经典童话",
                description = "三只小猪建造房子的故事，教会孩子们勤劳和智慧的重要性。",
                content = "从前有三只小猪，它们决定各自建造一座房子...",
                category = "通话故事",
                tags = listOf("勤劳", "智慧", "安全"),
                minAge = 3,
                maxAge = 6,
                duration = 300, // 5分钟
                coverImage = "https://example.com/three-pigs.jpg",
                audioUrl = "https://example.com/three-pigs.mp3",
                isFavorite = true,
                playCount = 15,
                lastPlayedAt = Date(),
                progress = 0.8f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 2,
                title = "小红帽",
                author = "格林童话",
                description = "小红帽去看望奶奶，遇到大灰狼的故事。",
                content = "从前有个可爱的小姑娘，大家都叫她小红帽...",
                category = "通话故事",
                tags = listOf("勇敢", "警惕", "亲情"),
                minAge = 4,
                maxAge = 7,
                duration = 420, // 7分钟
                coverImage = "https://example.com/red-riding-hood.jpg",
                audioUrl = "https://example.com/red-riding-hood.mp3",
                isFavorite = false,
                playCount = 8,
                lastPlayedAt = Date(),
                progress = 0.3f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 3,
                title = "龟兔赛跑",
                author = "伊索寓言",
                description = "乌龟和兔子比赛跑步的寓言故事。",
                content = "有一天，兔子嘲笑乌龟爬得慢...",
                category = "寓言故事",
                tags = listOf("坚持", "谦虚", "努力"),
                minAge = 3,
                maxAge = 8,
                duration = 240, // 4分钟
                coverImage = "https://example.com/tortoise-hare.jpg",
                audioUrl = "https://example.com/tortoise-hare.mp3",
                isFavorite = true,
                playCount = 12,
                lastPlayedAt = Date(),
                progress = 1.0f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 4,
                title = "晚安，月亮",
                author = "玛格丽特·怀斯·布朗",
                description = "睡前故事，帮助孩子放松入睡。",
                content = "在绿色的大房间里，有一只小兔子躺在床上...",
                category = "睡前故事",
                tags = listOf("睡前", "温馨", "放松"),
                minAge = 2,
                maxAge = 5,
                duration = 180, // 3分钟
                coverImage = "https://example.com/goodnight-moon.jpg",
                audioUrl = "https://example.com/goodnight-moon.mp3",
                isFavorite = false,
                playCount = 25,
                lastPlayedAt = Date(),
                progress = 0.5f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 5,
                title = "拔萝卜",
                author = "俄罗斯民间故事",
                description = "大家一起拔萝卜的故事，教会孩子们团结合作。",
                content = "老爷爷种了一棵萝卜，萝卜长得又大又结实...",
                category = "通话故事",
                tags = listOf("合作", "团结", "坚持"),
                minAge = 2,
                maxAge = 4,
                duration = 150, // 2.5分钟
                coverImage = "https://example.com/turnip.jpg",
                audioUrl = "https://example.com/turnip.mp3",
                isFavorite = true,
                playCount = 18,
                lastPlayedAt = Date(),
                progress = 0.9f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 6,
                title = "小马过河",
                author = "中国寓言",
                description = "小马过河的故事，教会孩子们要勇于尝试。",
                content = "小马要过河，不知道河水有多深...",
                category = "寓言故事",
                tags = listOf("勇敢", "尝试", "思考"),
                minAge = 4,
                maxAge = 7,
                duration = 210, // 3.5分钟
                coverImage = "https://example.com/little-horse.jpg",
                audioUrl = "https://example.com/little-horse.mp3",
                isFavorite = false,
                playCount = 6,
                lastPlayedAt = Date(),
                progress = 0.2f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 7,
                title = "恐龙世界",
                author = "科普作家",
                description = "介绍各种恐龙的科普故事。",
                content = "很久很久以前，地球上生活着各种各样的恐龙...",
                category = "科普故事",
                tags = listOf("恐龙", "科学", "自然"),
                minAge = 5,
                maxAge = 10,
                duration = 480, // 8分钟
                coverImage = "https://example.com/dinosaurs.jpg",
                audioUrl = "https://example.com/dinosaurs.mp3",
                isFavorite = true,
                playCount = 9,
                lastPlayedAt = Date(),
                progress = 0.4f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 8,
                title = "守株待兔",
                author = "中国成语故事",
                description = "守株待兔的成语故事。",
                content = "宋国有个农夫，他的田里有一棵树桩...",
                category = "成语故事",
                tags = listOf("成语", "勤劳", "智慧"),
                minAge = 6,
                maxAge = 9,
                duration = 180, // 3分钟
                coverImage = "https://example.com/wait-rabbit.jpg",
                audioUrl = "https://example.com/wait-rabbit.mp3",
                isFavorite = false,
                playCount = 4,
                lastPlayedAt = Date(),
                progress = 0.1f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 9,
                title = "丑小鸭",
                author = "安徒生童话",
                description = "丑小鸭变成美丽天鹅的故事。",
                content = "从前有一只小鸭子，它长得和其他小鸭子不一样...",
                category = "通话故事",
                tags = listOf("自信", "成长", "美丽"),
                minAge = 4,
                maxAge = 8,
                duration = 540, // 9分钟
                coverImage = "https://example.com/ugly-duckling.jpg",
                audioUrl = "https://example.com/ugly-duckling.mp3",
                isFavorite = true,
                playCount = 11,
                lastPlayedAt = Date(),
                progress = 0.7f,
                createdAt = Date(),
                updatedAt = Date()
            ),
            Story(
                id = 10,
                title = "星星的旅行",
                author = "原创故事",
                description = "一颗小星星的冒险之旅。",
                content = "在遥远的夜空中，有一颗小小的星星...",
                category = "绘本故事",
                tags = listOf("冒险", "友谊", "梦想"),
                minAge = 3,
                maxAge = 6,
                duration = 270, // 4.5分钟
                coverImage = "https://example.com/star-travel.jpg",
                audioUrl = "https://example.com/star-travel.mp3",
                isFavorite = false,
                playCount = 7,
                lastPlayedAt = Date(),
                progress = 0.6f,
                createdAt = Date(),
                updatedAt = Date()
            )
        )
    }
    
    /**
     * 生成默认用户设置
     */
    fun generateDefaultUserSettings(): UserSettings {
        return UserSettings(
            userId = "default",
            childInfo = UserSettings.ChildInfo(
                name = "小明",
                age = 4,
                gender = "男",
                avatar = null
            ),
            playbackSettings = UserSettings.PlaybackSettings(
                defaultVolume = 80,
                defaultPlaybackSpeed = 1.0f,
                voiceType = "default",
                backgroundPlay = true,
                autoPlayNext = true
            ),
            timerSettings = UserSettings.TimerSettings(
                sleepTimerEnabled = false,
                sleepTimerDuration = 30,
                dailyLimitEnabled = true,
                dailyLimitDuration = 60
            ),
            displaySettings = UserSettings.DisplaySettings(
                theme = "light",
                fontSize = "medium",
                eyeProtectionMode = false,
                animationEnabled = true
            ),
            contentFilter = UserSettings.ContentFilter(
                contentFilterLevel = "moderate",
                blockedCategories = emptyList(),
                blockedTags = emptyList(),
                ageRestriction = true
            ),
            parentalControl = UserSettings.ParentalControl(
                parentalControlEnabled = true,
                purchaseLock = true,
                dataCollectionAllowed = false,
                analyticsEnabled = false
            ),
            notificationSettings = UserSettings.NotificationSettings(
                notificationsEnabled = true,
                reminderNotifications = true,
                updateNotifications = true,
                promotionalNotifications = false
            ),
            storageSettings = UserSettings.StorageSettings(
                autoDownloadFavorites = false,
                storageLocation = "internal",
                cacheSizeLimit = 1024,
                autoClearCache = true,
                wifiOnlyDownload = true,
                dataSaverMode = false
            ),
            audioSettings = UserSettings.AudioSettings(
                equalizerPreset = "default",
                spatialAudio = false,
                volumeBoost = false
            ),
            playbackMode = UserSettings.PlaybackMode(
                shuffle = false,
                repeatMode = "none"
            ),
            learningSettings = UserSettings.LearningSettings(
                learningModeEnabled = false,
                questionAfterStory = false,
                vocabularyHighlight = false,
                pronunciationGuide = false
            ),
            createdAt = Date(),
            updatedAt = Date(),
            lastLoginAt = Date(),
            totalPlayTime = 3600, // 1小时
            totalStoriesPlayed = 15,
            favoriteCategories = listOf("通话故事", "睡前故事"),
            customSettings = emptyMap()
        )
    }
}