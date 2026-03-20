#!/bin/bash

echo "=== 儿童故事应用构建测试 ==="
echo "当前目录: $(pwd)"
echo ""

# 检查Gradle包装器
if [ ! -f "./gradlew" ]; then
    echo "错误: gradlew 文件不存在"
    exit 1
fi

echo "1. 检查项目结构..."
echo "Kotlin文件数量: $(find . -name "*.kt" -type f | wc -l)"
echo "XML文件数量: $(find . -name "*.xml" -type f | wc -l)"
echo ""

echo "2. 检查关键文件..."
check_files=(
    "app/build.gradle"
    "settings.gradle"
    "gradle/wrapper/gradle-wrapper.properties"
    "app/src/main/AndroidManifest.xml"
    "app/src/main/java/com/dunzi/storyhouse/MainActivity.kt"
    "app/src/main/java/com/dunzi/storyhouse/ui/screen/MainScreen.kt"
    "app/src/main/java/com/dunzi/storyhouse/ui/setting/SettingActivity.kt"
    "app/src/main/java/com/dunzi/storyhouse/ui/story/StoryDetailActivity.kt"
)

for file in "${check_files[@]}"; do
    if [ -f "$file" ]; then
        echo "  ✓ $file"
    else
        echo "  ✗ $file (缺失)"
    fi
done

echo ""
echo "3. 尝试同步Gradle项目..."
chmod +x ./gradlew
./gradlew --version

echo ""
echo "=== 测试完成 ==="