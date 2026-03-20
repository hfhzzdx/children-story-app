#!/bin/bash
# 使用已下载的Gradle 8.5构建项目

set -e

echo "=== 使用已下载的Gradle 8.5构建儿童故事应用 ==="
echo "当前目录: $(pwd)"

# 找到已下载的Gradle
GRADLE_HOME="$HOME/.gradle/wrapper/dists/gradle-8.5-bin/5t9huq95ubn472n8rpzujfbqh/gradle-8.5"
GRADLE_CMD="$GRADLE_HOME/bin/gradle"

if [ ! -f "$GRADLE_CMD" ]; then
    echo "错误: 找不到Gradle命令: $GRADLE_CMD"
    exit 1
fi

echo "使用Gradle版本:"
"$GRADLE_CMD" --version

echo ""
echo "=== 步骤1: 清理项目 ==="
"$GRADLE_CMD" clean

echo ""
echo "=== 步骤2: 检查项目配置 ==="
"$GRADLE_CMD" projects

echo ""
echo "=== 步骤3: 下载依赖 ==="
"$GRADLE_CMD" dependencies

echo ""
echo "=== 步骤4: 编译项目 ==="
"$GRADLE_CMD" compileDebugSources

echo ""
echo "=== 步骤5: 构建APK ==="
"$GRADLE_CMD" assembleDebug

echo ""
echo "=== 构建完成 ==="
echo "APK文件位置: app/build/outputs/apk/debug/"
ls -la app/build/outputs/apk/debug/ 2>/dev/null || echo "APK目录不存在，构建可能失败"

echo ""
echo "=== 构建日志摘要 ==="
echo "如果看到任何错误，请检查上面的输出。"