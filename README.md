# 小墩子故事屋 (Dunzi Story House)

专为3-6岁儿童设计的讲故事应用

## 项目状态
- **状态**: 开发中 (85% 完成)
- **最后更新**: 2026年3月20日
- **版本**: 0.1.0-alpha

## 功能特性

### ✅ 已完成的功能
- **故事播放**: 支持音频故事播放，包含播放/暂停/停止/下一首/上一首控制
- **播放进度**: 实时同步播放进度，支持跳转和快进/快退
- **睡眠定时器**: 支持15/30/60分钟定时停止播放
- **播放设置**: 音量控制、播放速度调整、随机播放、循环模式
- **播放历史**: 记录播放记录，显示统计信息和最常播放的故事
- **用户设置**: 儿童信息管理、播放设置、定时设置、家长控制
- **界面设计**: 儿童友好的Material Design 3界面，支持深色/护眼模式

### 🔧 开发中的功能
- 构建系统优化
- 单元测试和集成测试
- UI完善和性能优化

## 技术架构

### 技术栈
- **语言**: Kotlin
- **UI框架**: Jetpack Compose
- **数据库**: Room
- **音频播放**: ExoPlayer
- **依赖注入**: Dagger Hilt
- **架构模式**: MVVM

### 项目结构
```
app/src/main/java/com/dunzi/storyhouse/
├── data/                    # 数据层
│   ├── model/              # 数据模型
│   ├── dao/                # 数据访问对象
│   ├── repository/         # 仓库层
│   ├── database/           # 数据库
│   └── converter/          # 类型转换器
├── ui/                     # 用户界面层
│   ├── screen/            # 界面屏幕
│   ├── component/         # UI组件
│   ├── viewmodel/         # ViewModel
│   ├── player/            # 播放器界面
│   ├── setting/           # 设置界面
│   ├── history/           # 播放历史界面
│   └── story/             # 故事详情界面
├── service/               # 服务层
│   └── AudioPlaybackService.kt
└── di/                    # 依赖注入
    └── AppModule.kt
```

## 快速开始

### 环境要求
- Android Studio Flamingo 或更高版本
- JDK 17
- Android SDK 34
- Gradle 8.5

### 本地构建说明
1. 克隆项目
2. 使用Android Studio打开项目
3. 等待Gradle同步完成
4. 连接设备或启动模拟器
5. 运行应用

### GitHub Actions 自动化构建
项目已配置完整的GitHub Actions CI/CD流水线，支持自动构建、测试和部署：

![Android CI](https://github.com/你的用户名/children-story-app/actions/workflows/build.yml/badge.svg)
![CI/CD Pipeline](https://github.com/你的用户名/children-story-app/actions/workflows/ci.yml/badge.svg)

#### 可用工作流：
1. **基础构建工作流** (`build.yml`)
   - 自动构建Debug和Release APK
   - 运行单元测试
   - 上传构建产物和测试报告

2. **完整CI/CD流水线** (`ci.yml`)
   - 代码质量检查
   - 安全扫描
   - 自动化部署
   - 通知和监控

#### 触发条件：
- **自动触发**：推送到 `main`/`master`/`develop` 分支或创建PR时
- **手动触发**：通过GitHub Actions界面手动运行
- **标签发布**：推送到 `v*` 标签时自动创建Release

#### 构建产物：
- **APK文件**：Debug和Release版本
- **测试报告**：单元测试和仪器测试结果
- **构建报告**：详细的构建日志和分析
- **安全报告**：MobSF安全扫描结果

#### 使用步骤：
1. 将代码推送到GitHub仓库
2. 访问仓库的"Actions"标签页
3. 查看构建状态和下载产物
4. 根据测试报告修复问题

详细配置和使用指南请参考：
- [GITHUB_ACTIONS_BUILD.md](GITHUB_ACTIONS_BUILD.md) - 基础构建指南
- [.github/workflows/README.md](.github/workflows/README.md) - 工作流详细说明

## 数据库设计

### 实体关系
```
Story (1) ── (N) PlayHistory (N) ── (1) UserSettings
```

### 主要实体
1. **Story**: 故事信息，包含标题、作者、分类、时长、内容等
2. **PlayHistory**: 播放历史记录，关联故事和播放详情
3. **UserSettings**: 用户设置，包含儿童信息、播放偏好、家长控制等

## 音频播放特性

### 核心功能
- 前台服务播放，支持后台播放
- 播放进度实时同步到数据库
- 睡眠定时器自动停止播放
- 通知控制栏集成

### 播放控制
- 播放速度: 0.5x - 2.0x 可调
- 音量控制: 0.0 - 1.0 线性调整
- 播放模式: 顺序播放、随机播放、循环播放
- 快速跳转: 快进10秒、快退10秒

## 用户界面

### 主界面
- 欢迎横幅和儿童信息
- 播放统计卡片
- 分类网格导航
- 故事分区（最近播放、推荐故事、收藏故事）

### 播放器界面
- 故事封面和基本信息
- 播放进度条和控制按钮
- 额外控制面板（音量、速度、播放模式）
- 睡眠定时器控制

### 设置界面
- 儿童信息管理
- 播放设置（音量、速度、后台播放）
- 定时设置（睡眠定时器、每日限制）
- 显示设置（主题、字体、护眼模式）
- 家长控制（内容过滤、购买锁定）

## 开发进度

### 里程碑
- [x] 项目规划和架构设计
- [x] 数据库层实现
- [x] 音频播放服务
- [x] 核心用户界面
- [x] 设置和播放历史功能
- [ ] 构建和测试
- [ ] 功能完善和优化
- [ ] 发布准备

### 代码统计
- Kotlin文件: 43个
- XML文件: 22个
- 总代码行数: ~11,600行
- TODO标记: 31个（正在处理中）

## 贡献指南

### 开发流程
1. Fork项目
2. 创建功能分支
3. 提交代码变更
4. 创建Pull Request
5. 代码审查和合并

### 代码规范
- 遵循Kotlin官方编码规范
- 使用Kotlin DSL进行Gradle配置
- 使用Compose进行UI开发
- 遵循MVVM架构模式

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 联系方式

- **项目负责人**: 霍风浩
- **邮箱**: [待添加]
- **GitHub**: [待添加]

## 致谢

感谢所有为项目做出贡献的开发者和测试人员。

---

**注意**: 本项目仍在积极开发中，API和功能可能会有变动。