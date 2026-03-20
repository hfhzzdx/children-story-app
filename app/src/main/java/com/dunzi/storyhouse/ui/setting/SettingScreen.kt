package com.dunzi.storyhouse.ui.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.dunzi.storyhouse.R
import com.dunzi.storyhouse.ui.theme.SettingDescriptionStyle
import com.dunzi.storyhouse.ui.theme.SettingTitleStyle

/**
 * 设置界面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    viewModel: SettingViewModel,
    onBack: () -> Unit
) {
    val settingState by viewModel.settingState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    
    // 加载设置
    LaunchedEffect(Unit) {
        viewModel.loadSettings()
    }
    
    // 显示错误消息
    LaunchedEffect(settingState.error) {
        settingState.error?.let { error ->
            snackbarHostState.showSnackbar(error)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            SettingTopBar(
                onBack = onBack,
                onReset = viewModel::resetToDefaults
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when {
                settingState.isLoading -> {
                    // 加载中
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                
                !settingState.hasSettings -> {
                    // 没有设置
                    EmptySettingScreen(
                        onBack = onBack,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                
                else -> {
                    // 显示设置内容
                    SettingContentScreen(
                        settingState = settingState,
                        onUpdateChildInfo = viewModel::updateChildInfo,
                        onUpdatePlaybackSettings = viewModel::updatePlaybackSettings,
                        onUpdateTimerSettings = viewModel::updateTimerSettings,
                        onUpdateDisplaySettings = viewModel::updateDisplaySettings,
                        onUpdateContentFilter = viewModel::updateContentFilter,
                        onUpdateParentalControl = viewModel::updateParentalControl,
                        onUpdateNotificationSettings = viewModel::updateNotificationSettings,
                        onUpdateStorageSettings = viewModel::updateStorageSettings,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

/**
 * 设置顶部栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingTopBar(
    onBack: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.settings_title),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        actions = {
            IconButton(onClick = onReset) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = stringResource(R.string.reset_settings)
                )
            }
        },
        modifier = modifier
    )
}

/**
 * 空设置界面
 */
@Composable
fun EmptySettingScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = stringResource(R.string.settings),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(64.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = stringResource(R.string.settings_not_found),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = stringResource(R.string.tip_reset_settings),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(onClick = onBack) {
            Text(text = stringResource(R.string.go_back))
        }
    }
}

/**
 * 设置内容界面
 */
@Composable
fun SettingContentScreen(
    settingState: SettingViewModel.SettingState,
    onUpdateChildInfo: (String, Int, String, String?) -> Unit,
    onUpdatePlaybackSettings: (Int, Float, String, Boolean, Boolean) -> Unit,
    onUpdateTimerSettings: (Boolean, Int, Boolean, Int) -> Unit,
    onUpdateDisplaySettings: (String, String, Boolean, Boolean) -> Unit,
    onUpdateContentFilter: (String, List<String>, List<String>, Boolean) -> Unit,
    onUpdateParentalControl: (Boolean, Boolean, Boolean, Boolean) -> Unit,
    onUpdateNotificationSettings: (Boolean, Boolean, Boolean, Boolean) -> Unit,
    onUpdateStorageSettings: (Boolean, String, Int, Boolean, Boolean, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val settings = settingState.settings!!
    
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        // 儿童信息
        item {
            ChildInfoSection(
                childInfo = settingState.childInfo,
                onUpdate = onUpdateChildInfo,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 播放设置
        item {
            PlaybackSettingsSection(
                playbackSettings = settingState.playbackSettings,
                onUpdate = onUpdatePlaybackSettings,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 定时设置
        item {
            TimerSettingsSection(
                timerSettings = settingState.timerSettings,
                onUpdate = onUpdateTimerSettings,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 显示设置
        item {
            DisplaySettingsSection(
                displaySettings = settingState.displaySettings,
                onUpdate = onUpdateDisplaySettings,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 内容过滤
        item {
            ContentFilterSection(
                contentFilter = settingState.contentFilter,
                onUpdate = onUpdateContentFilter,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 家长控制
        item {
            ParentalControlSection(
                parentalControl = settingState.parentalControl,
                onUpdate = onUpdateParentalControl,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 通知设置
        item {
            NotificationSettingsSection(
                notificationSettings = settingState.notificationSettings,
                onUpdate = onUpdateNotificationSettings,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 存储设置
        item {
            StorageSettingsSection(
                storageSettings = settingState.storageSettings,
                onUpdate = onUpdateStorageSettings,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // 应用信息
        item {
            AppInfoSection(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/**
 * 儿童信息部分
 */
@Composable
fun ChildInfoSection(
    childInfo: com.dunzi.storyhouse.data.model.UserSettings.ChildInfo?,
    onUpdate: (String, Int, String, String?) -> Unit,
    modifier: Modifier = Modifier
) {
    var isEditing by remember { mutableStateOf(false) }
    var childName by remember { mutableStateOf(childInfo?.name ?: "") }
    var childAge by remember { mutableStateOf(childInfo?.age ?: 3) }
    var childGender by remember { mutableStateOf(childInfo?.gender ?: "未知") }
    
    SettingSection(
        title = stringResource(R.string.child_info_title),
        icon = Icons.Default.ChildCare,
        modifier = modifier
    ) {
        if (isEditing) {
            // 编辑模式
            Column {
                // TODO: 实现编辑表单
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { isEditing = false }) {
                        Text(text = stringResource(R.string.cancel))
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    TextButton(
                        onClick = {
                            onUpdate(childName, childAge, childGender, null)
                            isEditing = false
                        }
                    ) {
                        Text(text = stringResource(R.string.save))
                    }
                }
            }
        } else {
            // 显示模式
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 头像
                if (childInfo?.avatar != null) {
                    AsyncImage(
                        model = childInfo.avatar,
                        contentDescription = stringResource(R.string.child_avatar),
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChildCare,
                            contentDescription = stringResource(R.string.child_avatar),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                // 儿童信息
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = childInfo?.name ?: stringResource(R.string.unknown_child),
                        style = SettingTitleStyle
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Text(
                        text = "${childInfo?.age ?: 0}岁 · ${childInfo?.gender ?: "未知"}",
                        style = SettingDescriptionStyle
                    )
                }
                
                // 编辑按钮
                IconButton(onClick = { isEditing = true }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(R.string.edit_child_info)
                    )
                }
            }
        }
    }
}

/**
 * 播放设置部分
 */
@Composable
fun PlaybackSettingsSection(
    playbackSettings: com.dunzi.storyhouse.data.model.UserSettings.PlaybackSettings?,
    onUpdate: (Int, Float, String, Boolean, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var volume by remember { mutableStateOf(playbackSettings?.defaultVolume ?: 80) }
    var speed by remember { mutableStateOf(playbackSettings?.defaultPlaybackSpeed ?: 1.0f) }
    var backgroundPlay by remember { mutableStateOf(playbackSettings?.backgroundPlay ?: true) }
    var autoPlayNext by remember { mutableStateOf(playbackSettings?.autoPlayNext ?: true) }
    
    SettingSection(
        title = stringResource(R.string.playback_settings_title),
        icon = Icons.Default.VolumeUp,
        modifier = modifier
    ) {
        // 音量设置
        SettingItem(
            title = stringResource(R.string.volume_setting),
            description = "${volume}%",
            icon = Icons.Default.VolumeUp,
            action = {
                // TODO: 实现音量滑块
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 播放速度
        SettingItem(
            title = stringResource(R.string.playback_speed),
            description = "${speed}x",
            icon = Icons.Default.PlayArrow,
            action = {
                // TODO: 实现速度选择器
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 后台播放
        SettingSwitchItem(
            title = stringResource(R.string.background_play),
            description = stringResource(R.string.background_play_desc),
            icon = Icons.Default.PlayArrow,
            checked = backgroundPlay,
            onCheckedChange = { checked ->
                backgroundPlay = checked
                onUpdate(volume, speed, "default", backgroundPlay, autoPlayNext)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 自动播放下一首
        SettingSwitchItem(
            title = stringResource(R.string.auto_play_next),
            description = stringResource(R.string.auto_play_next_desc),
            icon = Icons.Default.PlayArrow,
            checked = autoPlayNext,
            onCheckedChange = { checked ->
                autoPlayNext = checked
                onUpdate(volume, speed, "default", backgroundPlay, autoPlayNext)
            }
        )
    }
}

/**
 * 定时设置部分
 */
@Composable
fun TimerSettingsSection(
    timerSettings: com.dunzi.storyhouse.data.model.UserSettings.TimerSettings?,
    onUpdate: (Boolean, Int, Boolean, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var sleepTimerEnabled by remember { mutableStateOf(timerSettings?.sleepTimerEnabled ?: false) }
    var sleepTimerDuration by remember { mutableStateOf(timerSettings?.sleepTimerDuration ?: 30) }
    var dailyLimitEnabled by remember { mutableStateOf(timerSettings?.dailyLimitEnabled ?: true) }
    var dailyLimitDuration by remember { mutableStateOf(timerSettings?.dailyLimitDuration ?: 60) }
    
    SettingSection(
        title = stringResource(R.string.timer_settings_title),
        icon = Icons.Default.Timer,
        modifier = modifier
    ) {
        // 睡眠定时器
        SettingSwitchItem(
            title = stringResource(R.string.sleep_timer),
            description = stringResource(R.string.sleep_timer_desc),
            icon = Icons.Default.Timer,
            checked = sleepTimerEnabled,
            onCheckedChange = { checked ->
                sleepTimerEnabled = checked
                onUpdate(sleepTimerEnabled, sleepTimerDuration, dailyLimitEnabled, dailyLimitDuration)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 睡眠定时器时长
        if (sleepTimerEnabled) {
            SettingItem(
                title = stringResource(R.string.sleep_timer_duration),
                description = "${sleepTimerDuration}分钟",
                icon = Icons.Default.Timer,
                action = {
                    // TODO: 实现时长选择器
                }
            )
            
            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }
        
        // 每日限制
        SettingSwitchItem(
            title = stringResource(R.string.daily_limit),
            description = stringResource(R.string.daily_limit_desc),
            icon = Icons.Default.Timer,
            checked = dailyLimitEnabled,
            onCheckedChange = { checked ->
                dailyLimitEnabled = checked
                onUpdate(sleepTimerEnabled, sleepTimerDuration, dailyLimitEnabled, dailyLimitDuration)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 每日限制时长
        if (dailyLimitEnabled) {
            SettingItem(
                title = stringResource(R.string.daily_limit_duration),
                description = "${dailyLimitDuration}分钟",
                icon = Icons.Default.Timer,
                action = {
                    // TODO: 实现时长选择器
                }
            )
        }
    }
}

/**
 * 显示设置部分
 */
@Composable
fun DisplaySettingsSection(
    displaySettings: com.dunzi.storyhouse.data.model.UserSettings.DisplaySettings?,
    onUpdate: (String, String, Boolean, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var theme by remember { mutableStateOf(displaySettings?.theme ?: "light") }
    var fontSize by remember { mutableStateOf(displaySettings?.fontSize ?: "medium") }
    var eyeProtectionMode by remember { mutableStateOf(displaySettings?.eyeProtectionMode ?: false) }
    var animationEnabled by remember { mutableStateOf(displaySettings?.animationEnabled ?: true) }
    
    SettingSection(
        title = stringResource(R.string.display_settings_title),
        icon = Icons.Default.Visibility,
        modifier = modifier
    ) {
        // 主题
        SettingItem(
            title = stringResource(R.string.theme_setting),
            description = when (theme) {
                "light" -> stringResource(R.string.theme_light)
                "dark" -> stringResource(R.string.theme_dark)
                "auto" -> stringResource(R.string.theme_auto)
                else -> stringResource(R.string.theme_light)
            },
            icon = Icons.Default.DarkMode,
            action = {
                // TODO: 实现主题选择器
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 字体大小
        SettingItem(
            title = stringResource(R.string.font_size),
            description = when (fontSize) {
                "small" -> stringResource(R.string.font_size_small)
                "medium" -> stringResource(R.string.font_size_medium)
                "large" -> stringResource(R.string.font_size_large)
                else -> stringResource(R.string.font_size_medium)
            },
            icon = Icons.Default.Edit,
            action = {
                // TODO: 实现字体大小选择器
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 护眼模式
        SettingSwitchItem(
            title = stringResource(R.string.eye_protection_mode),
            description = stringResource(R.string.eye_protection_mode_desc),
            icon = Icons.Default.Visibility,
            checked = eyeProtectionMode,
            onCheckedChange = { checked ->
                eyeProtectionMode = checked
                onUpdate(theme, fontSize, eyeProtectionMode, animationEnabled)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 动画效果
        SettingSwitchItem(
            title = stringResource(R.string.animation_enabled),
            description = stringResource(R.string.animation_enabled_desc),
            icon = Icons.Default.PlayArrow,
            checked = animationEnabled,
            onCheckedChange = { checked ->
                animationEnabled = checked
                onUpdate(theme, fontSize, eyeProtectionMode, animationEnabled)
            }
        )
    }
}

/**
 * 内容过滤部分
 */
@Composable
fun ContentFilterSection(
    contentFilter: com.dunzi.storyhouse.data.model.UserSettings.ContentFilter?,
    onUpdate: (String, List<String>, List<String>, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var filterLevel by remember { mutableStateOf(contentFilter?.contentFilterLevel ?: "moderate") }
    var ageRestriction by remember { mutableStateOf(contentFilter?.ageRestriction ?: true) }
    
    SettingSection(
        title = stringResource(R.string.content_filter_title),
        icon = Icons.Default.FilterAlt,
        modifier = modifier
    ) {
        // 过滤级别
        SettingItem(
            title = stringResource(R.string.filter_level),
            description = when (filterLevel) {
                "strict" -> stringResource(R.string.filter_level_strict)
                "moderate" -> stringResource(R.string.filter_level_moderate)
                "lenient" -> stringResource(R.string.filter_level_lenient)
                else -> stringResource(R.string.filter_level_moderate)
            },
            icon = Icons.Default.FilterAlt,
            action = {
                // TODO: 实现过滤级别选择器
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 年龄限制
        SettingSwitchItem(
            title = stringResource(R.string.age_restriction),
            description = stringResource(R.string.age_restriction_desc),
            icon = Icons.Default.ChildCare,
            checked = ageRestriction,
            onCheckedChange = { checked ->
                ageRestriction = checked
                onUpdate(filterLevel, emptyList(), emptyList(), ageRestriction)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 屏蔽分类
        SettingItem(
            title = stringResource(R.string.blocked_categories),
            description = stringResource(R.string.blocked_categories_desc),
            icon = Icons.Default.FilterAlt,
            action = {
                // TODO: 实现分类屏蔽管理
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 屏蔽标签
        SettingItem(
            title = stringResource(R.string.blocked_tags),
            description = stringResource(R.string.blocked_tags_desc),
            icon = Icons.Default.FilterAlt,
            action = {
                // TODO: 实现标签屏蔽管理
            }
        )
    }
}

/**
 * 家长控制部分
 */
@Composable
fun ParentalControlSection(
    parentalControl: com.dunzi.storyhouse.data.model.UserSettings.ParentalControl?,
    onUpdate: (Boolean, Boolean, Boolean, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var enabled by remember { mutableStateOf(parentalControl?.parentalControlEnabled ?: true) }
    var purchaseLock by remember { mutableStateOf(parentalControl?.purchaseLock ?: true) }
    var dataCollectionAllowed by remember { mutableStateOf(parentalControl?.dataCollectionAllowed ?: false) }
    var analyticsEnabled by remember { mutableStateOf(parentalControl?.analyticsEnabled ?: false) }
    
    SettingSection(
        title = stringResource(R.string.parental_control_title),
        icon = Icons.Default.Lock,
        modifier = modifier
    ) {
        // 家长控制开关
        SettingSwitchItem(
            title = stringResource(R.string.parental_control_enabled),
            description = stringResource(R.string.parental_control_enabled_desc),
            icon = Icons.Default.Lock,
            checked = enabled,
            onCheckedChange = { checked ->
                enabled = checked
                onUpdate(enabled, purchaseLock, dataCollectionAllowed, analyticsEnabled)
            }
        )
        
        if (enabled) {
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            // 购买锁定
            SettingSwitchItem(
                title = stringResource(R.string.purchase_lock),
                description = stringResource(R.string.purchase_lock_desc),
                icon = Icons.Default.Lock,
                checked = purchaseLock,
                onCheckedChange = { checked ->
                    purchaseLock = checked
                    onUpdate(enabled, purchaseLock, dataCollectionAllowed, analyticsEnabled)
                }
            )
            
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            // 数据收集
            SettingSwitchItem(
                title = stringResource(R.string.data_collection),
                description = stringResource(R.string.data_collection_desc),
                icon = Icons.Default.Save,
                checked = dataCollectionAllowed,
                onCheckedChange = { checked ->
                    dataCollectionAllowed = checked
                    onUpdate(enabled, purchaseLock, dataCollectionAllowed, analyticsEnabled)
                }
            )
            
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            // 分析功能
            SettingSwitchItem(
                title = stringResource(R.string.analytics_enabled),
                description = stringResource(R.string.analytics_enabled_desc),
                icon = Icons.Default.History,
                checked = analyticsEnabled,
                onCheckedChange = { checked ->
                    analyticsEnabled = checked
                    onUpdate(enabled, purchaseLock, dataCollectionAllowed, analyticsEnabled)
                }
            )
        }
    }
}

/**
 * 通知设置部分
 */
@Composable
fun NotificationSettingsSection(
    notificationSettings: com.dunzi.storyhouse.data.model.UserSettings.NotificationSettings?,
    onUpdate: (Boolean, Boolean, Boolean, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var enabled by remember { mutableStateOf(notificationSettings?.notificationsEnabled ?: true) }
    var reminders by remember { mutableStateOf(notificationSettings?.reminderNotifications ?: true) }
    var updates by remember { mutableStateOf(notificationSettings?.updateNotifications ?: true) }
    var promotions by remember { mutableStateOf(notificationSettings?.promotionalNotifications ?: false) }
    
    SettingSection(
        title = stringResource(R.string.notification_settings_title),
        icon = Icons.Default.Notifications,
        modifier = modifier
    ) {
        // 通知开关
        SettingSwitchItem(
            title = stringResource(R.string.notifications_enabled),
            description = stringResource(R.string.notifications_enabled_desc),
            icon = Icons.Default.Notifications,
            checked = enabled,
            onCheckedChange = { checked ->
                enabled = checked
                onUpdate(enabled, reminders, updates, promotions)
            }
        )
        
        if (enabled) {
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            // 提醒通知
            SettingSwitchItem(
                title = stringResource(R.string.reminder_notifications),
                description = stringResource(R.string.reminder_notifications_desc),
                icon = Icons.Default.Notifications,
                checked = reminders,
                onCheckedChange = { checked ->
                    reminders = checked
                    onUpdate(enabled, reminders, updates, promotions)
                }
            )
            
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            // 更新通知
            SettingSwitchItem(
                title = stringResource(R.string.update_notifications),
                description = stringResource(R.string.update_notifications_desc),
                icon = Icons.Default.Notifications,
                checked = updates,
                onCheckedChange = { checked ->
                    updates = checked
                    onUpdate(enabled, reminders, updates, promotions)
                }
            )
            
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            
            // 推广通知
            SettingSwitchItem(
                title = stringResource(R.string.promotional_notifications),
                description = stringResource(R.string.promotional_notifications_desc),
                icon = Icons.Default.Notifications,
                checked = promotions,
                onCheckedChange = { checked ->
                    promotions = checked
                    onUpdate(enabled, reminders, updates, promotions)
                }
            )
        }
    }
}

/**
 * 存储设置部分
 */
@Composable
fun StorageSettingsSection(
    storageSettings: com.dunzi.storyhouse.data.model.UserSettings.StorageSettings?,
    onUpdate: (Boolean, String, Int, Boolean, Boolean, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var autoDownloadFavorites by remember { mutableStateOf(storageSettings?.autoDownloadFavorites ?: false) }
    var autoClearCache by remember { mutableStateOf(storageSettings?.autoClearCache ?: true) }
    var wifiOnlyDownload by remember { mutableStateOf(storageSettings?.wifiOnlyDownload ?: true) }
    var dataSaverMode by remember { mutableStateOf(storageSettings?.dataSaverMode ?: false) }
    
    SettingSection(
        title = stringResource(R.string.storage_settings_title),
        icon = Icons.Default.Storage,
        modifier = modifier
    ) {
        // 自动下载收藏
        SettingSwitchItem(
            title = stringResource(R.string.auto_download_favorites),
            description = stringResource(R.string.auto_download_favorites_desc),
            icon = Icons.Default.Download,
            checked = autoDownloadFavorites,
            onCheckedChange = { checked ->
                autoDownloadFavorites = checked
                onUpdate(autoDownloadFavorites, "internal", 1024, autoClearCache, wifiOnlyDownload, dataSaverMode)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 自动清理缓存
        SettingSwitchItem(
            title = stringResource(R.string.auto_clear_cache),
            description = stringResource(R.string.auto_clear_cache_desc),
            icon = Icons.Default.Delete,
            checked = autoClearCache,
            onCheckedChange = { checked ->
                autoClearCache = checked
                onUpdate(autoDownloadFavorites, "internal", 1024, autoClearCache, wifiOnlyDownload, dataSaverMode)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 仅WiFi下载
        SettingSwitchItem(
            title = stringResource(R.string.wifi_only_download),
            description = stringResource(R.string.wifi_only_download_desc),
            icon = Icons.Default.Download,
            checked = wifiOnlyDownload,
            onCheckedChange = { checked ->
                wifiOnlyDownload = checked
                onUpdate(autoDownloadFavorites, "internal", 1024, autoClearCache, wifiOnlyDownload, dataSaverMode)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 省流量模式
        SettingSwitchItem(
            title = stringResource(R.string.data_saver_mode),
            description = stringResource(R.string.data_saver_mode_desc),
            icon = Icons.Default.Download,
            checked = dataSaverMode,
            onCheckedChange = { checked ->
                dataSaverMode = checked
                onUpdate(autoDownloadFavorites, "internal", 1024, autoClearCache, wifiOnlyDownload, dataSaverMode)
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 缓存大小限制
        SettingItem(
            title = stringResource(R.string.cache_size_limit),
            description = "${storageSettings?.cacheSizeLimit ?: 1024}MB",
            icon = Icons.Default.Storage,
            action = {
                // TODO: 实现缓存大小设置
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 存储位置
        SettingItem(
            title = stringResource(R.string.storage_location),
            description = when (storageSettings?.storageLocation) {
                "internal" -> stringResource(R.string.storage_internal)
                "external" -> stringResource(R.string.storage_external)
                else -> stringResource(R.string.storage_internal)
            },
            icon = Icons.Default.Storage,
            action = {
                // TODO: 实现存储位置选择
            }
        )
    }
}

/**
 * 应用信息部分
 */
@Composable
fun AppInfoSection(
    modifier: Modifier = Modifier
) {
    SettingSection(
        title = stringResource(R.string.app_info_title),
        icon = Icons.Default.Info,
        modifier = modifier
    ) {
        // 版本信息
        SettingItem(
            title = stringResource(R.string.app_version),
            description = "1.0.0",
            icon = Icons.Default.Info,
            action = {}
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 隐私政策
        SettingItem(
            title = stringResource(R.string.privacy_policy),
            description = stringResource(R.string.privacy_policy_desc),
            icon = Icons.Default.Lock,
            action = {
                // TODO: 打开隐私政策
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 用户协议
        SettingItem(
            title = stringResource(R.string.terms_of_service),
            description = stringResource(R.string.terms_of_service_desc),
            icon = Icons.Default.Info,
            action = {
                // TODO: 打开用户协议
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 分享应用
        SettingItem(
            title = stringResource(R.string.share_app),
            description = stringResource(R.string.share_app_desc),
            icon = Icons.Default.Share,
            action = {
                // TODO: 分享应用
            }
        )
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // 清除数据
        SettingItem(
            title = stringResource(R.string.clear_data),
            description = stringResource(R.string.clear_data_desc),
            icon = Icons.Default.Delete,
            action = {
                // TODO: 清除数据
            }
        )
    }
}

/**
 * 设置部分容器
 */
@Composable
fun SettingSection(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // 标题
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Text(
                    text = title,
                    style = SettingTitleStyle,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 内容
            content()
        }
    }
}

/**
 * 设置项组件
 */
@Composable
fun SettingItem(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = action),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(2.dp))
            
            Text(
                text = description,
                style = SettingDescriptionStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .size(16.dp)
                .rotate(180f)
        )
    }
}

/**
 * 设置开关项组件
 */
@Composable
fun SettingSwitchItem(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(2.dp))
            
            Text(
                text = description,
                style = SettingDescriptionStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

// 导入缺失的Compose函数
import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.rotate