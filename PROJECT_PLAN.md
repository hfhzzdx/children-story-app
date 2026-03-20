# 儿童故事应用 - 项目规划文档

## 项目概述
**项目名称**：小墩子故事屋 (Dunzi Story House)
**目标用户**：3-6岁儿童
**核心功能**：儿童故事播放应用，支持多种故事来源和格式

## 功能需求

### 1. 故事内容管理
- **故事分类**：
  - 通话故事
  - 绘本故事  
  - 睡前故事
  - 成语故事
  - 寓言故事
  - 科普故事
- **故事来源**：
  - AI生成（5000+不重复故事）
  - 网络获取
  - 手动导入（PDF/TXT/EPUB）
- **内容要求**：
  - 积极向上，有教育意义
  - 适合3-6岁儿童
  - 故事不重复（内容相似度<80%）

### 2. 音频播放功能
- **TTS语音合成**：高质量儿童语音
- **背景音乐**：可选背景音效
- **播放控制**：播放/暂停/快进/快退
- **定时关闭**：15/30/60分钟或自定义
- **后台播放**：锁屏/后台持续播放

### 3. 用户界面
- **护眼主题**：柔和色彩，低蓝光模式
- **儿童化图标**：卡通风格，圆润设计
- **简单交互**：大按钮，语音引导
- **家长控制**：设置入口，内容过滤

### 4. 文件导入
- **支持格式**：PDF、TXT、EPUB
- **批量导入**：支持文件夹导入
- **自动分类**：基于内容智能分类
- **内容解析**：提取文本内容

## 技术架构

### 前端技术栈
- **开发语言**：Kotlin
- **架构模式**：MVVM + Clean Architecture
- **目标SDK**：Android 17 (API 34)
- **最低SDK**：Android 5.0 (API 21)

### 主要依赖库
1. **Android Jetpack**：
   - Room (数据库)
   - ViewModel + LiveData
   - Navigation Component
   - WorkManager (后台任务)
2. **音频播放**：
   - ExoPlayer (音频播放)
   - Android TTS Engine
3. **文件解析**：
   - PDF解析库
   - EPUB解析库
4. **UI组件**：
   - Material Design Components
   - Glide (图片加载)

### 后端服务（可选）
- **故事生成API**：Python FastAPI + OpenAI API
- **文件存储**：对象存储服务
- **内容管理**：数据库存储故事库

## 项目结构

```
children-story-app/
├── app/                          # 主模块
│   ├── src/main/
│   │   ├── java/com/dunzi/storyhouse/
│   │   │   ├── ui/                      # 界面相关
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── StoryPlayerActivity.kt
│   │   │   │   ├── StoryLibraryActivity.kt
│   │   │   │   ├── SettingsActivity.kt
│   │   │   │   └── ImportActivity.kt
│   │   │   ├── service/                 # 服务层
│   │   │   │   ├── StoryPlayerService.kt
│   │   │   │   ├── TTSManager.kt
│   │   │   │   └── FileImportService.kt
│   │   │   ├── repository/              # 数据层
│   │   │   │   ├── StoryRepository.kt
│   │   │   │   ├── StoryDatabase.kt
│   │   │   │   └── StoryDao.kt
│   │   │   ├── model/                   # 数据模型
│   │   │   │   ├── Story.kt
│   │   │   │   ├── Category.kt
│   │   │   │   └── PlaybackState.kt
│   │   │   ├── utils/                   # 工具类
│   │   │   │   ├── StoryParser.kt
│   │   │   │   ├── StoryGenerator.kt
│   │   │   │   └── ThemeManager.kt
│   │   │   └── di/                      # 依赖注入
│   │   │       └── AppModule.kt
│   │   ├── res/                         # 资源文件
│   │   │   ├── layout/                  # 布局文件
│   │   │   ├── drawable/                # 图标和图片
│   │   │   ├── values/                  # 颜色、主题、字符串
│   │   │   ├── raw/                     # 音频文件
│   │   │   └── xml/                     # 配置文件
│   │   └── AndroidManifest.xml          # 应用清单
│   └── build.gradle                     # 模块构建配置
├── story-generator/                     # 故事生成服务（可选）
│   ├── api/                             # API服务
│   ├── models/                          # 数据模型
│   └── story_generator.py               # AI故事生成脚本
├── scripts/                             # 构建和部署脚本
│   ├── build-apk.sh                     # APK构建脚本
│   ├── generate-stories.py              # 故事生成脚本
│   └── import-stories.sh                # 故事导入脚本
├── .github/workflows/                   # GitHub Actions
│   └── build-android.yml                # Android构建工作流
├── build.gradle                         # 项目构建配置
├── settings.gradle                      # 项目设置
├── gradle.properties                    # Gradle属性配置
├── README.md                            # 项目说明
├── PROJECT_PLAN.md                      # 项目规划文档
├── BUILD_INSTRUCTIONS.md                # 构建说明
└── USAGE.md                             # 使用说明
```

## 数据库设计

### 1. 故事表 (stories)
```sql
CREATE TABLE stories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,                 -- 故事标题
    content TEXT NOT NULL,               -- 故事内容
    category_id INTEGER NOT NULL,        -- 分类ID
    source_type TEXT NOT NULL,           -- 来源类型: ai/network/import
    duration INTEGER,                    -- 预计播放时长(秒)
    age_range TEXT,                      -- 适合年龄: 3-4/4-5/5-6
    tags TEXT,                           -- 标签(JSON数组)
    audio_path TEXT,                     -- 音频文件路径
    cover_image TEXT,                    -- 封面图片
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_favorite BOOLEAN DEFAULT 0,      -- 是否收藏
    play_count INTEGER DEFAULT 0,        -- 播放次数
    last_played TIMESTAMP                -- 最后播放时间
);
```

### 2. 分类表 (categories)
```sql
CREATE TABLE categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,                  -- 分类名称
    icon TEXT,                           -- 分类图标
    color TEXT,                          -- 分类颜色
    description TEXT,                    -- 分类描述
    sort_order INTEGER DEFAULT 0         -- 排序顺序
);
```

### 3. 播放记录表 (playback_history)
```sql
CREATE TABLE playback_history (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    story_id INTEGER NOT NULL,           -- 故事ID
    user_id TEXT,                        -- 用户ID(预留)
    progress INTEGER DEFAULT 0,          -- 播放进度(秒)
    duration INTEGER NOT NULL,           -- 故事总时长
    played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed BOOLEAN DEFAULT 0          -- 是否播放完成
);
```

### 4. 用户设置表 (user_settings)
```sql
CREATE TABLE user_settings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    key TEXT NOT NULL UNIQUE,            -- 设置键
    value TEXT,                          -- 设置值
    type TEXT DEFAULT 'string'           -- 值类型: string/int/boolean
);
```

## 权限配置

### AndroidManifest.xml
```xml
<!-- 存储权限 -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.MANAGE_EXTERNAL_STORAGE" />

<!-- 网络权限 -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<!-- 音频权限 -->
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.VIBRATE" />

<!-- TTS权限 -->
<uses-permission android:name="android.permission.BIND_TTS_SERVICE" />
```

## 构建配置

### 编译环境要求
- **JDK**: OpenJDK 17
- **Gradle**: 8.5
- **Android SDK**: 34 (Android 17)
- **Build Tools**: 34.0.0

### GitHub Actions配置
使用环境变量：
- `GITHUB_USERNAME`: GitHub用户名
- `GITHUB_PASSWORD`: GitHub Personal Access Token

## 开发计划

### 第一阶段：基础框架 (1-2周)
1. 项目初始化，基础架构搭建
2. GitHub Actions CI/CD配置
3. 数据库设计和实现
4. 基础播放功能

### 第二阶段：核心功能 (2-3周)
1. TTS语音合成集成
2. 故事库管理界面
3. 文件导入功能
4. 后台播放服务

### 第三阶段：AI集成 (1-2周)
1. AI故事生成接口
2. 批量故事生成工具
3. 内容去重和质量检查

### 第四阶段：优化完善 (1周)
1. 护眼主题实现
2. 儿童化UI设计
3. 性能优化
4. 测试和发布准备

## 特色功能

### 1. 智能推荐系统
- 基于儿童年龄推荐故事
- 基于播放历史推荐
- 基于时间推荐（白天/睡前）

### 2. 互动学习功能
- 故事后的小问答
- 单词学习卡片
- 发音练习

### 3. 家长控制功能
- 播放时间限制
- 内容过滤设置
- 使用报告生成

### 4. 离线功能
- 故事下载
- 离线播放
- 自动更新

## 质量要求

### 1. 性能要求
- 启动时间 < 2秒
- 音频加载时间 < 1秒
- 内存占用 < 100MB
- 电池消耗优化

### 2. 兼容性要求
- 支持Android 5.0+ (API 21+)
- 适配不同屏幕尺寸
- 支持横竖屏切换

### 3. 安全要求
- 数据本地加密存储
- 网络请求使用HTTPS
- 权限最小化原则

## 测试策略

### 1. 单元测试
- 数据层测试
- 业务逻辑测试
- 工具类测试

### 2. 集成测试
- 播放功能测试
- 文件导入测试
- 数据库操作测试

### 3. UI测试
- 界面交互测试
- 主题切换测试
- 多语言测试

## 部署发布

### 1. 发布渠道
- Google Play Store
- 国内应用商店（华为、小米等）
- 官网直接下载

### 2. 更新策略
- 自动检查更新
- 增量更新支持
- 热修复能力

## 维护计划

### 1. 日常维护
- 错误监控和修复
- 性能监控和优化
- 用户反馈处理

### 2. 内容更新
- 定期添加新故事
- 节日主题故事
- 用户生成内容

### 3. 功能迭代
- 基于用户反馈改进
- 新技术集成
- 跨平台扩展

---

*文档版本：1.0*
*创建日期：2026-03-19*
*最后更新：2026-03-19*