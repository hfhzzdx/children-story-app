# 构建说明

本文档详细说明如何构建和部署"小墩子故事屋"Android应用。

## 环境要求

### 必需软件
1. **Java Development Kit (JDK) 17**
   - 下载地址：https://adoptium.net/
   - 验证安装：`java -version`

2. **Android SDK**
   - 包含Android SDK Build-Tools 34.0.0
   - 包含Android SDK Platform 34
   - 验证安装：`sdkmanager --list`

3. **Git** (用于版本控制)

### 可选软件
1. **Android Studio** (推荐用于开发)
2. **GitHub CLI** (用于GitHub操作)

## 本地构建

### 1. 克隆项目
```bash
git clone https://github.com/<your-username>/children-story-app.git
cd children-story-app
```

### 2. 配置环境变量
```bash
# 设置Android SDK路径（根据你的安装位置）
export ANDROID_HOME=/path/to/android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

# 设置Java路径
export JAVA_HOME=/path/to/jdk-17
export PATH=$JAVA_HOME/bin:$PATH
```

### 3. 构建项目
```bash
# 赋予gradlew执行权限
chmod +x gradlew

# 同步Gradle依赖
./gradlew build --refresh-dependencies

# 构建Debug版本APK
./gradlew assembleDebug

# 构建Release版本APK（需要签名配置）
./gradlew assembleRelease

# 清理构建
./gradlew clean
```

### 4. 安装到设备
```bash
# 连接Android设备或启动模拟器
adb devices

# 安装Debug版本
./gradlew installDebug

# 安装Release版本
./gradlew installRelease
```

## GitHub Actions构建

### 1. 仓库设置
1. 将项目推送到GitHub仓库
2. 确保仓库有正确的分支保护规则

### 2. Secrets配置
在GitHub仓库设置中配置以下Secrets：

| Secret名称 | 描述 | 是否必需 |
|------------|------|----------|
| `GITHUB_TOKEN` | GitHub自动生成的令牌 | 是 |
| `ANDROID_SIGNING_KEY` | Android签名密钥（Base64编码） | 否（Release构建需要） |
| `KEYSTORE_PASSWORD` | 密钥库密码 | 否（Release构建需要） |
| `KEY_ALIAS` | 密钥别名 | 否（Release构建需要） |
| `KEY_PASSWORD` | 密钥密码 | 否（Release构建需要） |

### 3. 触发构建
构建会在以下情况下自动触发：
- 推送到`main`或`master`分支
- 创建Pull Request
- 手动触发（通过GitHub UI）

### 4. 获取构建产物
构建完成后，可以在以下位置获取APK：
1. **GitHub Actions Artifacts**：构建工作流的Artifacts部分
2. **GitHub Releases**：如果创建了标签，会自动发布到Releases

## 签名配置（Release构建）

### 1. 生成签名密钥
```bash
# 生成密钥库
keytool -genkey -v -keystore storyhouse.keystore -alias storyhouse -keyalg RSA -keysize 2048 -validity 10000

# 查看密钥库信息
keytool -list -v -keystore storyhouse.keystore
```

### 2. 本地配置签名
在`app/build.gradle`中添加签名配置：
```gradle
android {
    signingConfigs {
        release {
            storeFile file("storyhouse.keystore")
            storePassword System.getenv("KEYSTORE_PASSWORD")
            keyAlias System.getenv("KEY_ALIAS")
            keyPassword System.getenv("KEY_PASSWORD")
        }
    }
    
    buildTypes {
        release {
            signingConfig signingConfigs.release
        }
    }
}
```

### 3. GitHub Actions配置
1. 将密钥库转换为Base64：
   ```bash
   base64 -i storyhouse.keystore > keystore.base64
   ```

2. 在GitHub仓库Secrets中设置：
   - `ANDROID_SIGNING_KEY`: Base64编码的密钥库内容
   - `KEYSTORE_PASSWORD`: 密钥库密码
   - `KEY_ALIAS`: 密钥别名
   - `KEY_PASSWORD`: 密钥密码

3. 在工作流中添加解码步骤：
   ```yaml
   - name: Decode signing key
     run: |
       echo "${{ secrets.ANDROID_SIGNING_KEY }}" | base64 --decode > storyhouse.keystore
     shell: bash
   ```

## 构建脚本

项目包含以下构建脚本：

### `scripts/build-apk.sh`
```bash
#!/bin/bash
# 构建APK脚本

set -e  # 遇到错误时退出

echo "开始构建小墩子故事屋APK..."

# 清理
./gradlew clean

# 构建Debug版本
echo "构建Debug版本..."
./gradlew assembleDebug

# 构建Release版本（如果配置了签名）
if [ -f "storyhouse.keystore" ]; then
    echo "构建Release版本..."
    ./gradlew assembleRelease
fi

# 显示构建结果
echo "构建完成！"
find . -name "*.apk" -type f | xargs ls -la
```

### `scripts/generate-stories.py`
```python
#!/usr/bin/env python3
# AI故事生成脚本

import openai
import json
import os

# 配置OpenAI API
openai.api_key = os.getenv("OPENAI_API_KEY")

def generate_story(category, theme, age_range):
    """生成一个儿童故事"""
    prompt = f"""请为{age_range}岁儿童创作一个{category}故事，主题是{theme}。
要求：
1. 故事积极向上，有教育意义
2. 语言简单易懂，适合儿童
3. 包含对话和生动描述
4. 故事长度约500-800字
5. 结尾要有简单的道理总结"""
    
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content": "你是一位儿童故事作家，擅长创作适合3-6岁儿童的生动有趣的故事。"},
            {"role": "user", "content": prompt}
        ],
        temperature=0.7,
        max_tokens=1000
    )
    
    return response.choices[0].message.content

# 使用示例
if __name__ == "__main__":
    story = generate_story("通话故事", "友谊", "3-4")
    print(story)
```

### `scripts/import-stories.sh`
```bash
#!/bin/bash
# 故事导入脚本

set -e

echo "开始导入故事文件..."

# 创建导入目录
IMPORT_DIR="./imports"
mkdir -p "$IMPORT_DIR"

echo "请将故事文件（PDF/TXT/EPUB）放入 $IMPORT_DIR 目录"
echo "然后运行："
echo "  ./gradlew :app:importStories"
```

## 常见问题

### 1. 构建失败：找不到Android SDK
**解决方案**：
```bash
# 设置ANDROID_HOME环境变量
export ANDROID_HOME=/path/to/android/sdk

# 或者在gradle.properties中添加
echo "sdk.dir=/path/to/android/sdk" >> gradle.properties
```

### 2. 构建失败：Java版本不匹配
**解决方案**：
```bash
# 检查Java版本
java -version

# 设置JAVA_HOME
export JAVA_HOME=/path/to/jdk-17
```

### 3. GitHub Actions构建超时
**解决方案**：
- 增加构建超时时间
- 使用缓存减少下载时间
- 分阶段构建

### 4. APK文件过大
**解决方案**：
- 启用代码混淆（ProGuard）
- 启用资源压缩
- 移除未使用的资源
- 使用Android App Bundle

## 性能优化建议

### 构建优化
1. **启用构建缓存**：
   ```gradle
   org.gradle.caching=true
   ```

2. **启用配置缓存**：
   ```gradle
   org.gradle.configuration-cache=true
   ```

3. **使用并行构建**：
   ```gradle
   org.gradle.parallel=true
   ```

### APK优化
1. **启用代码压缩**：
   ```gradle
   minifyEnabled true
   shrinkResources true
   ```

2. **启用资源压缩**：
   ```gradle
   crunchPngs true
   ```

3. **使用App Bundle**：
   ```gradle
   bundle {
       language {
           enableSplit = true
       }
       density {
           enableSplit = true
       }
       abi {
           enableSplit = true
       }
   }
   ```

## 发布流程

### 1. 版本管理
- 使用语义化版本控制：`主版本.次版本.修订版本`
- 每次发布前更新版本号
- 创建Git标签：`v1.0.0`

### 2. 测试流程
1. **单元测试**：`./gradlew test`
2. **集成测试**：`./gradlew connectedCheck`
3. **UI测试**：手动测试主要功能
4. **性能测试**：检查内存使用和启动时间

### 3. 发布检查清单
- [ ] 版本号已更新
- [ ] 所有测试通过
- [ ] 代码已合并到主分支
- [ ] 创建Git标签
- [ ] 更新CHANGELOG.md
- [ ] 构建Release APK
- [ ] 上传到应用商店

### 4. 应用商店发布
1. **Google Play Store**：
   - 创建应用列表
   - 上传APK或App Bundle
   - 填写应用详情
   - 设置年龄分级
   - 提交审核

2. **国内应用商店**：
   - 华为应用市场
   - 小米应用商店
   - 腾讯应用宝
   - OPPO软件商店
   - VIVO应用商店

## 监控和维护

### 1. 错误监控
- 集成Firebase Crashlytics
- 设置错误报警
- 定期查看崩溃报告

### 2. 性能监控
- 使用Android Vitals
- 监控ANR（应用无响应）
- 监控启动时间
- 监控电池使用

### 3. 用户反馈
- 集成应用内反馈
- 监控应用商店评价
- 收集用户建议

## 更新日志

### v1.0.0 (计划中)
- 初始版本发布
- 基础故事播放功能
- 文件导入支持
- 基础UI设计

---

*最后更新：2026-03-19*