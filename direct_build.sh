#!/bin/bash

echo "=== 直接构建儿童故事应用 ==="
echo "跳过gradle-wrapper，直接使用Gradle 8.5"
echo ""

# 设置路径
PROJECT_DIR="/home/hfh/.openclaw/workspace/children-story-app"
GRADLE_HOME="/home/hfh/.gradle/wrapper/dists/gradle-8.5-bin/5t9huq95ubn472n8rpzujfbqh/gradle-8.5"
GRADLE_CMD="$GRADLE_HOME/bin/gradle"

cd "$PROJECT_DIR"

echo "项目目录: $PROJECT_DIR"
echo "Gradle命令: $GRADLE_CMD"
echo ""

# 检查Gradle
echo "检查Gradle..."
$GRADLE_CMD --version 2>&1 | head -5
echo ""

# 设置Java
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 2>/dev/null || export JAVA_HOME=/usr/lib/jvm/java-17-openjdk 2>/dev/null
export PATH=$JAVA_HOME/bin:$PATH

echo "Java版本:"
java -version 2>&1 | head -3
echo ""

# 清理和准备
echo "准备构建环境..."
echo "1. 创建本地gradle.properties..."
cat > local.properties << 'EOF'
sdk.dir=/home/hfh/Android/Sdk
EOF

echo "2. 设置Gradle属性..."
export GRADLE_USER_HOME="$PROJECT_DIR/.gradle"
mkdir -p "$GRADLE_USER_HOME"

echo "3. 清理旧构建..."
rm -rf build/ app/build/ .gradle/

echo ""
echo "开始构建..."
echo "步骤1: 验证项目配置"

# 使用简单的任务测试
timeout 300 $GRADLE_CMD -q tasks --all 2>&1 | grep -E "(assemble|build|clean|test)" | head -10
if [ $? -eq 0 ]; then
    echo "✓ 项目配置验证通过"
else
    echo "✗ 项目配置验证失败"
    echo "尝试查看详细错误..."
    timeout 60 $GRADLE_CMD assembleDebug 2>&1 | tail -30
    exit 1
fi

echo ""
echo "步骤2: 尝试编译调试版本"
echo "这可能需要几分钟时间下载依赖..."

# 后台运行构建，显示进度
(
    $GRADLE_CMD assembleDebug 2>&1 | tee build.log | grep -E "(BUILD|FAILED|SUCCESSFUL|error:|warning:)"
) &

BUILD_PID=$!

# 等待构建完成
for i in {1..300}; do
    if kill -0 $BUILD_PID 2>/dev/null; then
        sleep 1
        # 每10秒显示进度
        if [ $((i % 10)) -eq 0 ]; then
            echo "构建中... 已等待 ${i}秒"
        fi
    else
        break
    fi
done

# 检查结果
if wait $BUILD_PID; then
    echo ""
    echo "✓ 构建成功！"
    echo "APK位置: app/build/outputs/apk/debug/"
    ls -la app/build/outputs/apk/debug/*.apk 2>/dev/null || echo "APK文件未找到，请检查构建日志"
else
    echo ""
    echo "✗ 构建失败"
    echo "查看构建日志: build.log"
    echo "最后错误:"
    tail -50 build.log 2>/dev/null || echo "无法读取构建日志"
fi

echo ""
echo "=== 构建完成 ==="
echo "如果构建成功，说明项目代码和配置是正确的。"
echo "gradle-wrapper问题可以通过以下方式解决:"
echo "1. 使用此脚本直接构建"
echo "2. 在Android Studio中打开项目"
echo "3. 从其他项目复制完整的gradle-wrapper"