# GitHub Actions 构建指南

## 项目概述
这是一个Android儿童故事应用，使用现代Android开发技术栈构建。

## 技术栈
- Kotlin
- Jetpack Compose
- Room Database
- Hilt (依赖注入)
- Retrofit (网络请求)
- ExoPlayer (音频播放)

## GitHub Actions 构建配置

### 工作流文件
`.github/workflows/android-build.yml` 包含以下步骤：

1. **代码检出** - 从仓库获取代码
2. **JDK 17设置** - 配置Java开发环境
3. **Android SDK设置** - 安装Android构建工具
4. **接受SDK许可证** - 自动接受Android SDK许可证
5. **Gradle缓存** - 缓存依赖以加速构建
6. **构建APK** - 编译并打包Debug版本APK
7. **上传APK** - 将生成的APK作为构建产物上传
8. **运行测试** - 执行单元测试
9. **上传测试结果** - 保存测试报告

### 触发条件
- 推送到 `main` 或 `master` 分支时自动构建
- 创建Pull Request到 `main` 或 `master` 分支时自动构建

## 本地开发环境设置

### 前提条件
1. **Android Studio** - 最新版本（推荐）
2. **JDK 17** - Java开发工具包
3. **Android SDK** - API 34及以上

### 项目配置检查清单

#### 1. Gradle配置
- [x] `gradle/wrapper/gradle-wrapper.properties` - 使用Gradle 8.5
- [x] `build.gradle` - 正确配置插件版本
- [x] `app/build.gradle` - 完整依赖配置
- [x] `settings.gradle` - 仓库配置包含JitPack

#### 2. 项目结构
- [x] `app/src/main/java/` - Kotlin源代码
- [x] `app/src/main/res/` - 资源文件
- [x] `app/src/main/AndroidManifest.xml` - 应用清单

#### 3. 关键文件
- [x] `local.properties` - Android SDK路径（本地开发需要）
- [x] `.gitignore` - 忽略构建文件和敏感信息
- [x] `README.md` - 项目说明文档

## 构建问题解决

### 常见问题

#### 1. Hilt插件问题
**症状**: `Plugin [id: 'dagger.hilt.android.plugin'] was not found`
**解决方案**: 确保在 `build.gradle` 中正确配置插件版本

#### 2. 依赖下载失败
**症状**: `Could not resolve all dependencies`
**解决方案**: 
- 检查网络连接
- 确保 `settings.gradle` 中包含所有必要的仓库
- 对于GitHub依赖，确保JitPack仓库已添加

#### 3. Android SDK许可证
**症状**: `SDK license not accepted`
**解决方案**: 运行 `sdkmanager --licenses` 并接受所有许可证

#### 4. Gradle版本不兼容
**症状**: `Minimum supported Gradle version is X.X`
**解决方案**: 更新 `gradle-wrapper.properties` 中的Gradle版本

## GitHub Actions 构建状态

构建状态徽章（添加到README.md）:
```markdown
![Android CI](https://github.com/你的用户名/children-story-app/actions/workflows/android-build.yml/badge.svg)
```

## 手动触发构建

1. 访问GitHub仓库的"Actions"标签页
2. 选择"Android CI"工作流
3. 点击"Run workflow"按钮
4. 选择分支并运行

## 构建产物

构建成功后，可以在以下位置找到APK:
1. GitHub Actions运行页面 → "Artifacts"部分 → "app-debug-apk"
2. 本地构建: `app/build/outputs/apk/debug/app-debug.apk`

## 后续步骤

1. **代码签名** - 配置发布版本签名
2. **发布到商店** - 设置Google Play发布流程
3. **持续集成** - 添加更多测试和检查
4. **代码质量** - 集成静态代码分析工具

## 联系方式

如有构建问题，请检查:
1. GitHub Actions日志中的详细错误信息
2. 项目配置是否符合Android开发规范
3. 依赖版本是否兼容