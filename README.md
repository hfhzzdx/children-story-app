# 小墩子故事屋 (Dunzi Story House)

专为3-6岁儿童设计的讲故事Android应用。

## 项目概述

这是一个面向3-6岁儿童的讲故事应用，提供丰富的故事内容、智能推荐、家长控制等功能。项目采用现代Android开发技术栈，包括Jetpack Compose、Room数据库、Hilt依赖注入等。

## 功能特性

### 核心功能
- 📚 **故事管理**：分类展示、搜索、收藏、播放历史
- 🎵 **音频播放**：后台播放、播放控制、进度保存
- 👶 **儿童友好**：大字体、鲜艳颜色、简单交互
- 👨‍👩‍👧‍👦 **家长控制**：内容过滤、每日限制、播放时间管理
- 📊 **学习统计**：播放记录、完成率、学习进度

### 技术特性
- 🏗 **现代架构**：MVVM + Clean Architecture
- 🎨 **现代UI**：Jetpack Compose + Material Design 3
- 💾 **数据持久化**：Room数据库 + DataStore
- 🔧 **依赖注入**：Hilt
- 🎵 **音频播放**：ExoPlayer
- 🌐 **网络支持**：Retrofit + OkHttp
- 🖼 **图片加载**：Glide + Coil

## 项目结构

```
children-story-app/
├── app/
│   ├── src/main/
│   │   ├── java/com/dunzi/storyhouse/
│   │   │   ├── data/              # 数据层
│   │   │   │   ├── model/         # 数据模型
│   │   │   │   ├── dao/          # 数据访问对象
│   │   │   │   ├── database/     # 数据库
│   │   │   │   ├── converter/    # 类型转换器
│   │   │   │   └── repository/   # 仓库层
│   │   │   ├── di/               # 依赖注入
│   │   │   ├── service/          # 服务层
│   │   │   ├── ui/               # UI层
│   │   │   │   ├── component/    # 可复用组件
│   │   │   │   ├── screen/       # 屏幕组件
│   │   │   │   ├── story/        # 故事相关界面
│   │   │   │   ├── player/       # 播放器界面
│   │   │   │   ├── theme/        # 主题和样式
│   │   │   │   └── viewmodel/    # 视图模型
│   │   │   └── StoryApplication.kt
│   │   └── res/                  # 资源文件
│   │       ├── drawable/         # 图片资源
│   │       ├── mipmap/           # 应用图标
│   │       ├── values/           # 值资源
│   │       └── xml/              # XML配置
│   └── build.gradle              # 应用构建配置
├── .github/workflows/            # GitHub Actions工作流
├── build.gradle                  # 项目构建配置
├── settings.gradle              # 项目设置
├── gradle.properties            # Gradle属性
└── gradlew                      # Gradle包装器
```

## 技术栈

### 主要依赖
- **Android SDK**: 34
- **Kotlin**: 1.9.24
- **Jetpack Compose**: BOM 2024.02.02
- **Room**: 2.6.1
- **Hilt**: 2.50
- **ExoPlayer**: 2.19.1
- **Retrofit**: 2.9.0
- **Glide**: 4.16.0

### 开发工具
- **Android Studio**: 最新版本
- **Gradle**: 8.5
- **JDK**: 17

## 快速开始

### 环境要求
- Android Studio Flamingo 或更高版本
- JDK 17
- Android SDK 34

### 构建步骤
1. 克隆项目
2. 使用Android Studio打开项目
3. 等待Gradle同步完成
4. 连接Android设备或启动模拟器
5. 点击运行按钮

### GitHub Actions构建
项目已配置GitHub Actions工作流，支持自动构建APK：
- 推送代码到main分支时自动构建
- 手动触发构建
- 生成可下载的APK文件

## 数据库设计

### 主要表结构
1. **story表**：故事基本信息
   - id, title, author, category, duration, audioUrl, coverImage等
2. **play_history表**：播放历史记录
   - id, storyId, userId, duration, playedAt, completed等
3. **user_settings表**：用户设置
   - userId, childInfo, playbackSettings, parentalControl等

### 数据关系
- 一个故事可以有多个播放记录
- 一个用户有一套设置
- 播放记录关联故事和用户

## UI设计原则

### 儿童友好设计
- **大字体**：易于阅读
- **鲜艳颜色**：吸引注意力
- **简单交互**：减少操作复杂度
- **清晰反馈**：操作有明确反馈
- **安全设计**：避免误操作

### 家长控制
- **内容过滤**：按年龄和分类过滤
- **时间限制**：每日播放时间限制
- **播放控制**：后台播放、自动播放等设置
- **隐私保护**：数据收集控制

## 开发进度

### 已完成
- ✅ 项目架构搭建
- ✅ 数据库设计和实现
- ✅ 数据访问层和仓库层
- ✅ 依赖注入配置
- ✅ 音频播放服务
- ✅ 播放器界面
- ✅ 故事详情界面
- ✅ 资源文件配置
- ✅ GitHub Actions工作流

### 进行中
- 🔄 主界面完善
- 🔄 设置功能实现
- 🔄 故事导入功能

### 待完成
- ⏳ 单元测试
- ⏳ 错误处理优化
- ⏳ 性能优化
- ⏳ 多语言支持

## 贡献指南

1. Fork项目
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开Pull Request

## 许可证

本项目采用MIT许可证。详见 [LICENSE](LICENSE) 文件。

## 联系方式

- 开发者：hfhzzdx
- 项目主页：https://github.com/yourusername/children-story-app
- 问题反馈：请使用GitHub Issues

## 致谢

感谢所有为项目做出贡献的开发者！

---
**小墩子故事屋** - 让每个孩子都有好故事听！ 📚🎵👶


~本项目由deepseek和openclaw生成~
