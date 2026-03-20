#!/bin/bash

echo "=== 儿童故事应用代码质量检查 ==="
echo ""

# 检查Kotlin文件中的常见问题
echo "1. 检查TODO标记:"
todo_count=$(grep -r "TODO" --include="*.kt" . | wc -l)
echo "   发现 $todo_count 个TODO标记"

if [ $todo_count -gt 0 ]; then
    echo "   具体位置:"
    grep -r "TODO" --include="*.kt" . | head -10
fi

echo ""
echo "2. 检查FIXME标记:"
fixme_count=$(grep -r "FIXME" --include="*.kt" . | wc -l)
echo "   发现 $fixme_count 个FIXME标记"

echo ""
echo "3. 检查空行和格式:"
echo "   检查文件中是否有连续空行..."

# 检查是否有连续两个空行
double_empty_lines=$(find . -name "*.kt" -type f -exec grep -n '^$' {} \; | awk 'NR==1{prev=$1; next} $1==prev+1{print "文件: " FILENAME " 行: " prev; prev=$1; next} {prev=$1}' | wc -l)
echo "   发现 $double_empty_lines 个文件有连续空行"

echo ""
echo "4. 检查导入语句:"
echo "   检查未使用的导入..."

# 简单的导入检查（查找可能未使用的导入）
echo "   注：完整的导入检查需要编译器"

echo ""
echo "5. 检查文件编码:"
non_utf8_files=$(find . -name "*.kt" -type f -exec file {} \; | grep -v "UTF-8" | wc -l)
echo "   发现 $non_utf8_files 个非UTF-8编码文件"

echo ""
echo "6. 检查行长度:"
long_lines=$(find . -name "*.kt" -type f -exec awk 'length > 120 {print FILENAME ":" NR ": " length " chars"}' {} \; | wc -l)
echo "   发现 $long_lines 行超过120字符"

if [ $long_lines -gt 0 ]; then
    echo "   前5个长行:"
    find . -name "*.kt" -type f -exec awk 'length > 120 {print FILENAME ":" NR ": " length " chars"}' {} \; | head -5
fi

echo ""
echo "7. 检查魔法数字:"
# 查找可能的魔法数字（简单的正则匹配）
magic_numbers=$(grep -r "\b[0-9]\{3,\}\b" --include="*.kt" . | grep -v "//" | grep -v "/*" | wc -l)
echo "   发现 $magic_numbers 个可能的魔法数字"

echo ""
echo "8. 检查硬编码字符串:"
hardcoded_strings=$(grep -r '\"[^\"]*\"' --include="*.kt" . | grep -v "R.string" | grep -v "//" | wc -l)
echo "   发现 $hardcoded_strings 个硬编码字符串（需要人工检查）"

echo ""
echo "9. 检查空方法:"
empty_methods=$(grep -r "{}" --include="*.kt" . | wc -l)
echo "   发现 $empty_methods 个空方法体"

echo ""
echo "10. 检查异常处理:"
try_catch_blocks=$(grep -r "try\|catch\|finally" --include="*.kt" . | wc -l)
echo "   发现 $try_catch_blocks 个try-catch块"

echo ""
echo "=== 代码质量总结 ==="
echo "总Kotlin文件数: $(find . -name "*.kt" -type f | wc -l)"
echo "总代码行数: $(find . -name "*.kt" -type f -exec wc -l {} \; | awk '{sum+=$1} END{print sum}')"

if [ $todo_count -eq 0 ] && [ $fixme_count -eq 0 ] && [ $double_empty_lines -eq 0 ]; then
    echo "✓ 代码质量良好，未发现严重问题"
else
    echo "⚠ 发现一些问题需要处理:"
    [ $todo_count -gt 0 ] && echo "  - 有 $todo_count 个TODO标记需要完成"
    [ $fixme_count -gt 0 ] && echo "  - 有 $fixme_count 个FIXME标记需要修复"
    [ $double_empty_lines -gt 0 ] && echo "  - 有 $double_empty_lines 个文件有格式问题"
fi

echo ""
echo "建议:"
echo "1. 使用Android Studio的Lint工具进行更全面的检查"
echo "2. 添加单元测试确保代码质量"
echo "3. 配置CI/CD流水线进行自动化检查"