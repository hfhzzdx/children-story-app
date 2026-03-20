#!/bin/bash
# 最小化构建测试

set -e

echo "=== 最小化构建测试 ==="
echo "当前目录: $(pwd)"

# 创建最小化项目结构
TEST_DIR="minimal_test"
rm -rf "$TEST_DIR"
mkdir -p "$TEST_DIR/app/src/main/java/com/test"
mkdir -p "$TEST_DIR/app/src/main/res"

# 创建最小化的build.gradle
cat > "$TEST_DIR/build.gradle" << 'EOF'
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:8.2.2'
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24'
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
EOF

cat > "$TEST_DIR/settings.gradle" << 'EOF'
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MinimalTest"
include ':app'
EOF

# 创建最小化的app/build.gradle
cat > "$TEST_DIR/app/build.gradle" << 'EOF'
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'com.test.minimal'
    compileSdk 34

    defaultConfig {
        applicationId "com.test.minimal"
        minSdk 21
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
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
    implementation 'androidx.core:core-ktx:1.13.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
}
EOF

# 创建最小化的AndroidManifest.xml
cat > "$TEST_DIR/app/src/main/AndroidManifest.xml" << 'EOF'
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.test.minimal">

    <application
        android:allowBackup="true"
        android:label="Minimal Test">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
EOF

# 创建最小化的Kotlin文件
cat > "$TEST_DIR/app/src/main/java/com/test/MainActivity.kt" << 'EOF'
package com.test.minimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
EOF

# 创建最小化的布局文件
cat > "$TEST_DIR/app/src/main/res/layout/activity_main.xml" << 'EOF'
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello Minimal Test!"
        android:layout_centerInParent="true"/>

</androidx.constraintlayout.widget.ConstraintLayout>
EOF

# 复制gradle wrapper
cp -r gradle "$TEST_DIR/"
cp gradlew "$TEST_DIR/"
cp gradlew.bat "$TEST_DIR/" 2>/dev/null || true

# 进入测试目录并尝试构建
cd "$TEST_DIR"
chmod +x gradlew

echo ""
echo "=== 尝试构建最小化项目 ==="
echo "项目目录: $(pwd)"

# 尝试构建
./gradlew :app:assembleDebug 2>&1 | tail -100

cd ..

echo ""
echo "=== 测试完成 ==="
echo "如果最小化项目能构建成功，说明原项目的配置有问题。"
echo "如果最小化项目也失败，说明构建环境有问题。"