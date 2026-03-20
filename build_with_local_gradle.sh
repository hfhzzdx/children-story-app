#!/bin/bash

echo "=== 使用本地Gradle 8.5构建测试 ==="
echo ""

# 设置Gradle路径
GRADLE_HOME="/home/hfh/.gradle/wrapper/dists/gradle-8.5-bin/5t9huq95ubn472n8rpzujfbqh/gradle-8.5"
GRADLE_CMD="$GRADLE_HOME/bin/gradle"

echo "Gradle路径: $GRADLE_CMD"
echo "Gradle版本:"
$GRADLE_CMD --version 2>&1 | head -5
echo ""

# 设置环境变量
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 2>/dev/null || export JAVA_HOME=/usr/lib/jvm/java-17-openjdk 2>/dev/null
export PATH=$JAVA_HOME/bin:$PATH

echo "Java版本:"
java -version 2>&1 | head -3
echo ""

# 清理可能的缓存问题
echo "清理Gradle缓存..."
rm -rf ~/.gradle/caches/transforms-* 2>/dev/null
rm -rf ~/.gradle/caches/modules-* 2>/dev/null
rm -rf ~/.gradle/caches/jars-* 2>/dev/null
echo "缓存清理完成"
echo ""

# 尝试构建
echo "尝试构建项目..."
echo "1. 检查项目配置..."

timeout 120 $GRADLE_CMD -q projects 2>&1
if [ $? -eq 0 ]; then
    echo "  ✓ 项目配置正确"
else
    echo "  ✗ 项目配置有问题"
    echo "  最后输出:"
    timeout 120 $GRADLE_CMD -q projects 2>&1 | tail -20
fi

echo ""
echo "2. 尝试同步项目..."

timeout 180 $GRADLE_CMD -q buildEnvironment 2>&1 | tail -10
if [ $? -eq 0 ]; then
    echo "  ✓ 项目同步成功"
else
    echo "  ✗ 项目同步失败"
fi

echo ""
echo "=== 测试完成 ==="
echo "如果使用本地Gradle可以工作，说明问题在于gradle-wrapper配置。"
echo "解决方案:"
echo "1. 使用完整的Gradle分发版，而不是单独的gradle-wrapper.jar"
echo "2. 在Android Studio中打开项目"
echo "3. 手动配置GRADLE_HOME环境变量"