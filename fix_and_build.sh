#!/bin/bash
# 修复并构建儿童故事应用

set -e

echo "=== 修复并构建儿童故事应用 ==="
echo "当前目录: $(pwd)"

# 使用已下载的Gradle 8.5
GRADLE_CMD="$HOME/.gradle/wrapper/dists/gradle-8.5-bin/5t9huq95ubn472n8rpzujfbqh/gradle-8.5/bin/gradle"

if [ ! -f "$GRADLE_CMD" ]; then
    echo "错误: 找不到Gradle 8.5命令"
    exit 1
fi

echo "使用Gradle 8.5版本:"
"$GRADLE_CMD" --version

echo ""
echo "=== 步骤1: 备份原文件 ==="
cp app/build.gradle app/build.gradle.backup
cp build.gradle build.gradle.backup

echo ""
echo "=== 步骤2: 修复build.gradle（移除Hilt插件）==="
cat > build.gradle << 'EOF'
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id 'com.android.application' version '8.2.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.9.24' apply false
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
EOF

echo ""
echo "=== 步骤3: 修复app/build.gradle（简化配置）==="
# 读取原文件并移除Hilt相关配置
cat app/build.gradle.backup | \
    grep -v "dagger.hilt.android.plugin" | \
    grep -v "id 'dagger.hilt.android.plugin'" | \
    grep -v "com.google.dagger:hilt-android" | \
    grep -v "kapt 'com.google.dagger:hilt-compiler" | \
    grep -v "androidx.hilt:hilt-navigation-compose" | \
    sed 's/testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"/testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"/' | \
    sed 's/implementation '\\''com.google.dagger:hilt-android:2.50'\\''//' | \
    sed 's/kapt '\\''com.google.dagger:hilt-compiler:2.50'\\''//' | \
    sed 's/implementation '\\''androidx.hilt:hilt-navigation-compose:1.1.0'\\''//' > app/build.gradle.tmp

# 确保plugins块正确
cat > app/build.gradle << 'EOF'
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
    id 'kotlin-parcelize'
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

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        debug {
            debuggable true
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
        release {
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = '17'
    }

    buildFeatures {
        viewBinding true
        dataBinding true
        compose true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion '1.5.11'
    }

    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}

dependencies {
    // Android Core
    implementation 'androidx.core:core-ktx:1.13.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.12.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    
    // Compose
    implementation platform('androidx.compose:compose-bom:2024.02.02')
    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-graphics'
    implementation 'androidx.compose.ui:ui-tooling-preview'
    implementation 'androidx.compose.material3:material3'
    implementation 'androidx.activity:activity-compose:1.8.2'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0'
    implementation 'androidx.compose.runtime:runtime-livedata'
    implementation 'androidx.navigation:navigation-compose:2.7.7'
    
    // Lifecycle
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.8.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.8.0'
    implementation 'androidx.lifecycle:lifecycle-service:2.8.0'
    
    // Navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.7.7'
    implementation 'androidx.navigation:navigation-ui-ktx:2.7.7'
    
    // Room Database
    implementation 'androidx.room:room-runtime:2.6.1'
    implementation 'androidx.room:room-ktx:2.6.1'
    kapt 'androidx.room:room-compiler:2.6.1'
    
    // Audio Playback
    implementation 'com.google.android.exoplayer:exoplayer:2.19.1'
    implementation 'com.google.android.exoplayer:extension-mediasession:2.19.1'
    
    // File Parsing
    implementation 'com.github.barteksc:android-pdf-viewer:3.2.0-beta.1'
    implementation 'org.jsoup:jsoup:1.17.2'
    
    // Network
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.12.0'
    
    // Image Loading
    implementation 'com.github.bumptech.glide:glide:4.16.0'
    kapt 'com.github.bumptech.glide:compiler:4.16.0'
    implementation 'com.github.bumptech.glide:compose:1.0.0-beta01'
    
    // Permissions
    implementation 'com.guolindev.permissionx:permissionx:1.7.1'
    
    // Work Manager
    implementation 'androidx.work:work-runtime-ktx:2.9.0'
    
    // Preferences
    implementation 'androidx.preference:preference-ktx:1.2.1'
    implementation 'androidx.datastore:datastore-preferences:1.0.0'
    
    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0'
    
    // Timber for logging
    implementation 'com.jakewharton.timber:timber:5.0.1'
    
    // Splash Screen
    implementation 'androidx.core:core-splashscreen:1.0.1'
    
    // Testing
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation platform('androidx.compose:compose-bom:2024.02.02')
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
    debugImplementation 'androidx.compose.ui:ui-tooling'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}
EOF

echo ""
echo "=== 步骤4: 修复AndroidManifest.xml（确保包名正确）==="
if ! grep -q "package=\"com.dunzi.storyhouse\"" app/src/main/AndroidManifest.xml; then
    echo "修复AndroidManifest.xml包名..."
    sed -i '1s/^.*$/<?xml version="1.0" encoding="utf-8"?>/' app/src/main/AndroidManifest.xml
    sed -i '2s/^.*$/<manifest xmlns:android="http:\/\/schemas.android.com\/apk\/res\/android"/' app/src/main/AndroidManifest.xml
    sed -i '2s/$/\n    package="com.dunzi.storyhouse">/' app/src/main/AndroidManifest.xml
fi

echo ""
echo "=== 步骤5: 创建local.properties（设置Android SDK路径）==="
if [ -d "$HOME/Android/Sdk" ]; then
    echo "sdk.dir=$HOME/Android/Sdk" > local.properties
    echo "已设置Android SDK路径: $HOME/Android/Sdk"
else
    echo "警告: 未找到Android SDK，尝试自动检测..."
    # 尝试常见位置
    for dir in "$HOME/Android/Sdk" "/home/$USER/Android/Sdk" "/opt/android-sdk" "/usr/local/android-sdk"; do
        if [ -d "$dir" ]; then
            echo "sdk.dir=$dir" > local.properties
            echo "已设置Android SDK路径: $dir"
            break
        fi
    done
fi

if [ ! -f "local.properties" ]; then
    echo "sdk.dir=/home/hfh/Android/Sdk" > local.properties
    echo "使用默认Android SDK路径"
fi

echo ""
echo "=== 步骤6: 尝试构建 ==="
echo "运行: $GRADLE_CMD :app:assembleDebug"

# 设置环境变量
export ANDROID_HOME="$HOME/Android/Sdk"
export JAVA_HOME="$(readlink -f /usr/bin/java | sed 's:/bin/java::')"

timeout 300 "$GRADLE_CMD" :app:assembleDebug 2>&1 | tail -200

echo ""
echo "=== 步骤7: 检查构建结果 ==="
if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
    echo "✅ 构建成功！APK文件: app/build/outputs/apk/debug/app-debug.apk"
    ls -lh app/build/outputs/apk/debug/
else
    echo "❌ 构建失败，APK文件未生成"
    echo "检查错误信息并尝试:"
    echo "1. 查看完整构建日志: $GRADLE_CMD :app:assembleDebug --stacktrace"
    echo "2. 检查网络连接和代理设置"
    echo "3. 确保Android SDK已正确安装"
fi

echo ""
echo "=== 步骤8: 恢复原文件（可选）==="
echo "原文件已备份为:"
echo "  - app/build.gradle.backup"
echo "  - build.gradle.backup"
echo "如需恢复，运行: cp app/build.gradle.backup app/build.gradle && cp build.gradle.backup build.gradle"

echo ""
echo "=== 修复构建完成 ==="