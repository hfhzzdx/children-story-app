#!/bin/bash
# 修复Gradle Wrapper问题

set -e

echo "=== 修复Gradle Wrapper ==="
echo "当前目录: $(pwd)"

# 备份旧的gradle-wrapper.jar
if [ -f "gradle/wrapper/gradle-wrapper.jar" ]; then
    echo "备份旧的gradle-wrapper.jar..."
    cp gradle/wrapper/gradle-wrapper.jar gradle/wrapper/gradle-wrapper.jar.backup
fi

# 方法1: 从Gradle官方下载正确的wrapper
echo "尝试从Gradle官方下载wrapper..."
curl -L -o gradle/wrapper/gradle-wrapper.jar \
    https://github.com/gradle/gradle/raw/v8.7.0/gradle/wrapper/gradle-wrapper.jar 2>/dev/null || \
    echo "下载失败，尝试方法2..."

# 检查文件
if [ -f "gradle/wrapper/gradle-wrapper.jar" ]; then
    FILE_SIZE=$(stat -c%s "gradle/wrapper/gradle-wrapper.jar")
    echo "下载的gradle-wrapper.jar大小: ${FILE_SIZE}字节"
    
    if [ $FILE_SIZE -lt 50000 ]; then
        echo "文件可能不完整，恢复备份..."
        cp gradle/wrapper/gradle-wrapper.jar.backup gradle/wrapper/gradle-wrapper.jar
    fi
fi

# 方法2: 使用系统Gradle生成wrapper
echo "尝试使用系统Gradle生成wrapper..."
if command -v gradle &> /dev/null; then
    echo "系统Gradle版本:"
    gradle --version | head -5
    
    # 创建临时项目生成wrapper
    TEMP_DIR=$(mktemp -d)
    cd "$TEMP_DIR"
    echo "在临时目录生成wrapper: $TEMP_DIR"
    
    gradle wrapper --gradle-version 8.7 2>&1 | grep -v "Downloading" || true
    
    if [ -f "gradle/wrapper/gradle-wrapper.jar" ]; then
        echo "复制生成的gradle-wrapper.jar..."
        cp gradle/wrapper/gradle-wrapper.jar /home/hfh/.openclaw/workspace/children-story-app/gradle/wrapper/
    fi
    
    cd /home/hfh/.openclaw/workspace/children-story-app
    rm -rf "$TEMP_DIR"
else
    echo "系统Gradle不可用"
fi

# 测试gradlew
echo ""
echo "=== 测试gradlew ==="
if [ -f "gradlew" ]; then
    chmod +x gradlew
    echo "运行: ./gradlew --version"
    ./gradlew --version 2>&1 | head -20 || echo "gradlew测试失败"
else
    echo "gradlew文件不存在"
fi

echo ""
echo "=== 修复完成 ==="
echo "如果gradlew仍然失败，可能需要手动下载完整的Gradle 8.7分发版。"