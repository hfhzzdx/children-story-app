#!/bin/bash
# 简化构建脚本，跳过有问题的插件

set -e

echo "=== 简化构建儿童故事应用 ==="
echo "当前目录: $(pwd)"

# 使用已下载的Gradle 8.5
GRADLE_CMD="$HOME/.gradle/wrapper/dists/gradle-8.5-bin/5t9huq95ubn472n8rpzujfbqh/gradle-8.5/bin/gradle"

if [ ! -f "$GRADLE_CMD" ]; then
    echo "错误: 找不到Gradle命令"
    exit 1
fi

echo "Gradle版本:"
"$GRADLE_CMD" --version

echo ""
echo "=== 步骤1: 创建简化版build.gradle ==="

# 创建简化版的app/build.gradle
cat > app/build.gradle.simple << 'EOF'
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'com.dunzi.storyhouse'
    compileSdk 34

    defaultConfig {
        applicationId "com.dunzi.storyhouse"
        minSdk 21
        targetSdk 34
        versionCode 1
        versionName "1.0.0"
    }

    buildTypes {
        debug {
            debuggable true
            minifyEnabled false
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = '17'
    }
}

dependencies {
    // 基本依赖
    implementation 'androidx.core:core-ktx:1.13.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.12.0'
}
EOF

# 备份原文件
if [ -f "app/build.gradle" ]; then
    cp app/build.gradle app/build.gradle.backup
    cp app/build.gradle.simple app/build.gradle
    echo "已创建简化版build.gradle"
fi

echo ""
echo "=== 步骤2: 尝试编译 ==="
"$GRADLE_CMD" :app:compileDebugKotlin 2>&1 | tail -50

echo ""
echo "=== 步骤3: 恢复原文件 ==="
if [ -f "app/build.gradle.backup" ]; then
    cp app/build.gradle.backup app/build.gradle
    echo "已恢复原build.gradle"
fi

echo ""
echo "=== 构建测试完成 ==="