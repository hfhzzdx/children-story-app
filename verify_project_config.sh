#!/bin/bash
# 验证项目配置完整性

set -e

echo "=== 儿童故事应用项目配置验证 ==="
echo "验证时间: $(date)"
echo ""

# 检查关键文件
echo "1. 检查关键文件是否存在:"
required_files=(
    "build.gradle"
    "app/build.gradle"
    "settings.gradle"
    "gradle/wrapper/gradle-wrapper.properties"
    "app/src/main/AndroidManifest.xml"
    ".github/workflows/build.yml"
    "README.md"
)

missing_files=0
for file in "${required_files[@]}"; do
    if [ -f "$file" ]; then
        echo "  ✅ $file"
    else
        echo "  ❌ $file (缺失)"
        missing_files=$((missing_files + 1))
    fi
done

echo ""
echo "2. 检查Gradle配置:"
if grep -q "gradle-8.5" "gradle/wrapper/gradle-wrapper.properties"; then
    echo "  ✅ Gradle版本: 8.5"
else
    echo "  ❌ Gradle版本配置错误"
fi

echo ""
echo "3. 检查Android配置:"
if grep -q "compileSdk 34" "app/build.gradle"; then
    echo "  ✅ compileSdk: 34"
else
    echo "  ❌ compileSdk配置错误"
fi

if grep -q "minSdk 21" "app/build.gradle"; then
    echo "  ✅ minSdk: 21"
else
    echo "  ❌ minSdk配置错误"
fi

echo ""
echo "4. 检查依赖注入配置:"
if grep -q "dagger.hilt.android.plugin" "build.gradle"; then
    echo "  ✅ Hilt插件已配置"
else
    echo "  ❌ Hilt插件未配置"
fi

echo ""
echo "5. 检查仓库配置:"
if grep -q "jitpack.io" "settings.gradle"; then
    echo "  ✅ JitPack仓库已添加"
else
    echo "  ❌ JitPack仓库未添加"
fi

echo ""
echo "6. 检查GitHub Actions配置:"
if [ -f ".github/workflows/android-build.yml" ]; then
    echo "  ✅ GitHub Actions工作流已配置"
    echo "  📋 工作流步骤:"
    grep -E "^\s*- name:" ".github/workflows/android-build.yml" | sed 's/^[[:space:]]*- name:/    •/'
else
    echo "  ❌ GitHub Actions工作流未配置"
fi

echo ""
echo "7. 检查代码结构:"
kotlin_files=$(find app/src -name "*.kt" | wc -l)
xml_files=$(find app/src -name "*.xml" | wc -l)
echo "  📊 Kotlin文件: $kotlin_files 个"
echo "  📊 XML文件: $xml_files 个"

echo ""
echo "=== 验证结果 ==="
if [ $missing_files -eq 0 ]; then
    echo "✅ 项目配置完整，可以推送到GitHub进行构建测试"
    echo ""
    echo "下一步操作建议:"
    echo "1. 创建GitHub仓库"
    echo "2. 推送代码到仓库"
    echo "3. 查看GitHub Actions构建状态"
    echo "4. 下载生成的APK进行测试"
else
    echo "⚠️  发现 $missing_files 个缺失文件，请先修复配置"
    exit 1
fi

echo ""
echo "=== 项目信息 ==="
echo "项目名称: $(grep -oP 'rootProject.name = "\K[^"]+' settings.gradle 2>/dev/null || echo 'ChildrenStoryApp')"
echo "应用ID: $(grep -oP 'applicationId "\K[^"]+' app/build.gradle 2>/dev/null || echo 'com.dunzi.storyhouse')"
echo "版本: $(grep -oP 'versionName "\K[^"]+' app/build.gradle 2>/dev/null || echo '1.0.0')"