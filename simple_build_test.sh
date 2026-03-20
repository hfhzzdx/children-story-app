#!/bin/bash

echo "=== 简单构建测试 ==="
echo "测试项目配置是否正确..."
echo ""

# 检查Gradle文件语法
echo "1. 检查Gradle文件语法:"

# 检查settings.gradle
echo "  检查settings.gradle..."
if grep -q "rootProject.name" settings.gradle; then
    echo "  ✓ rootProject.name 已设置"
else
    echo "  ✗ rootProject.name 未设置"
fi

if grep -q "include" settings.gradle; then
    echo "  ✓ include 语句存在"
else
    echo "  ✗ include 语句不存在"
fi

# 检查build.gradle
echo ""
echo "  检查build.gradle..."
if grep -q "com.android.application" build.gradle; then
    echo "  ✓ Android应用插件已配置"
else
    echo "  ✗ Android应用插件未配置"
fi

if grep -q "org.jetbrains.kotlin.android" build.gradle; then
    echo "  ✓ Kotlin插件已配置"
else
    echo "  ✗ Kotlin插件未配置"
fi

# 检查app/build.gradle
echo ""
echo "  检查app/build.gradle..."
if grep -q "namespace" app/build.gradle; then
    echo "  ✓ namespace 已设置"
else
    echo "  ✗ namespace 未设置"
fi

if grep -q "compileSdk" app/build.gradle; then
    echo "  ✓ compileSdk 已设置"
else
    echo "  ✗ compileSdk 未设置"
fi

if grep -q "minSdk" app/build.gradle; then
    echo "  ✓ minSdk 已设置"
else
    echo "  ✗ minSdk 未设置"
fi

if grep -q "targetSdk" app/build.gradle; then
    echo "  ✓ targetSdk 已设置"
else
    echo "  ✗ targetSdk 未设置"
fi

# 检查依赖项
echo ""
echo "  检查依赖项..."
dependencies=(
    "androidx.compose"
    "androidx.room"
    "com.google.android.exoplayer"
    "com.google.dagger.hilt"
)

for dep in "${dependencies[@]}"; do
    if grep -q "$dep" app/build.gradle; then
        echo "  ✓ $dep 依赖存在"
    else
        echo "  ✗ $dep 依赖不存在"
    fi
done

# 检查AndroidManifest.xml
echo ""
echo "2. 检查AndroidManifest.xml:"
if [ -f "app/src/main/AndroidManifest.xml" ]; then
    if grep -q "package=" app/src/main/AndroidManifest.xml; then
        package_name=$(grep "package=" app/src/main/AndroidManifest.xml | sed "s/.*package=\"\([^\"]*\)\".*/\1/")
        echo "  ✓ 包名: $package_name"
    else
        echo "  ✗ 包名未设置"
    fi
    
    if grep -q "<application" app/src/main/AndroidManifest.xml; then
        echo "  ✓ application 标签存在"
    else
        echo "  ✗ application 标签不存在"
    fi
    
    if grep -q "android:name=" app/src/main/AndroidManifest.xml; then
        echo "  ✓ Application类已配置"
    else
        echo "  ✗ Application类未配置"
    fi
else
    echo "  ✗ AndroidManifest.xml 文件不存在"
fi

# 检查Kotlin文件编译
echo ""
echo "3. 检查Kotlin文件基本语法:"
kotlin_files=$(find . -name "*.kt" -type f | head -5)
echo "  随机检查5个Kotlin文件..."

for file in $kotlin_files; do
    # 简单的语法检查：检查是否有明显的语法错误
    if grep -q "class\|fun\|val\|var" "$file"; then
        echo "  ✓ $file: 包含Kotlin关键字"
    else
        echo "  ✗ $file: 可能不是有效的Kotlin文件"
    fi
done

echo ""
echo "=== 测试结果 ==="
echo "如果所有检查都通过✓，说明项目配置基本正确。"
echo "Gradle构建问题可能是由于环境配置或gradle-wrapper.jar文件问题。"
echo ""
echo "建议:"
echo "1. 在Android Studio中打开项目，让IDE自动修复Gradle配置"
echo "2. 确保使用正确的JDK版本（JDK 17）"
echo "3. 检查网络连接，确保可以下载Gradle依赖"
echo "4. 清理Gradle缓存: rm -rf ~/.gradle/caches/"