#!/bin/bash

echo "=== 使用系统Gradle构建测试 ==="
echo "注意：系统Gradle版本可能较旧，仅用于测试配置"
echo ""

# 设置环境变量
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 2>/dev/null || export JAVA_HOME=/usr/lib/jvm/java-17-openjdk 2>/dev/null
export PATH=$JAVA_HOME/bin:$PATH

echo "Java版本:"
java -version 2>&1 | head -3
echo ""

echo "Gradle版本:"
gradle --version 2>&1 | head -5
echo ""

# 尝试简单的Gradle任务
echo "尝试执行Gradle任务..."
echo "1. 检查项目配置:"

# 尝试运行help任务
if timeout 30 gradle projects 2>&1 | grep -q "Root project"; then
    echo "  ✓ Gradle可以识别项目"
    
    # 显示项目结构
    echo "  项目结构:"
    timeout 30 gradle projects 2>&1 | grep -A 10 "Root project"
else
    echo "  ✗ Gradle无法识别项目"
    echo "  错误信息:"
    timeout 30 gradle projects 2>&1 | tail -10
fi

echo ""
echo "2. 检查任务列表:"
if timeout 30 gradle tasks --all 2>&1 | grep -q "Build tasks"; then
    echo "  ✓ 可以获取任务列表"
    echo "  可用任务:"
    timeout 30 gradle tasks --all 2>&1 | grep -E "(assemble|build|clean|test)" | head -10
else
    echo "  ✗ 无法获取任务列表"
fi

echo ""
echo "3. 尝试清理项目:"
if timeout 60 gradle clean 2>&1 | tail -5 | grep -q "BUILD SUCCESSFUL"; then
    echo "  ✓ 清理成功"
else
    echo "  ✗ 清理失败"
    echo "  最后输出:"
    timeout 60 gradle clean 2>&1 | tail -10
fi

echo ""
echo "=== 测试总结 ==="
echo "如果使用系统Gradle可以正常工作，说明项目配置正确。"
echo "gradle-wrapper问题可能是由于："
echo "1. gradle-wrapper.jar文件损坏或不完整"
echo "2. 缺少必要的依赖类"
echo "3. Java版本不兼容"
echo ""
echo "解决方案:"
echo "1. 在Android Studio中打开项目，它会自动修复Gradle配置"
echo "2. 手动下载完整的Gradle分发版"
echo "3. 使用系统Gradle初始化wrapper: gradle wrapper --gradle-version 8.5"
echo "4. 检查网络连接和代理设置"