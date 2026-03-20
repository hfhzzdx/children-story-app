#!/bin/bash
# 故事导入脚本 - 小墩子故事屋

set -e  # 遇到错误时退出

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 日志函数
log_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

log_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

log_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# 配置
IMPORT_DIR="./imports"
OUTPUT_DIR="./imported_stories"
SUPPORTED_EXTENSIONS=("pdf" "txt" "epub" "docx" "md")
DATABASE_PATH="stories.db"

# 检查依赖
check_dependencies() {
    log_info "检查依赖..."
    
    local missing_deps=()
    
    # 检查Python
    if ! command -v python3 &> /dev/null; then
        missing_deps+=("python3")
    fi
    
    # 检查必要的Python包
    if command -v python3 &> /dev/null; then
        python3 -c "import sqlite3" 2>/dev/null || missing_deps+=("python3-sqlite3")
    fi
    
    # 检查文件工具
    if ! command -v file &> /dev/null; then
        missing_deps+=("file")
    fi
    
    if [ ${#missing_deps[@]} -gt 0 ]; then
        log_error "缺少依赖: ${missing_deps[*]}"
        log_info "请安装缺少的依赖后重试"
        exit 1
    fi
    
    log_success "依赖检查完成"
}

# 初始化目录
init_directories() {
    log_info "初始化目录..."
    
    # 创建导入目录
    if [ ! -d "$IMPORT_DIR" ]; then
        mkdir -p "$IMPORT_DIR"
        log_info "创建导入目录: $IMPORT_DIR"
    fi
    
    # 创建输出目录
    if [ ! -d "$OUTPUT_DIR" ]; then
        mkdir -p "$OUTPUT_DIR"
        log_info "创建输出目录: $OUTPUT_DIR"
    fi
    
    # 创建日志目录
    if [ ! -d "./logs" ]; then
        mkdir -p "./logs"
        log_info "创建日志目录: ./logs"
    fi
    
    log_success "目录初始化完成"
}

# 显示导入目录内容
show_import_dir() {
    log_info "导入目录内容:"
    
    if [ -d "$IMPORT_DIR" ]; then
        local file_count=0
        local total_size=0
        
        # 遍历支持的文件类型
        for ext in "${SUPPORTED_EXTENSIONS[@]}"; do
            for file in "$IMPORT_DIR"/*."$ext" "$IMPORT_DIR"/*."${ext^^}"; do
                if [ -f "$file" ]; then
                    file_count=$((file_count + 1))
                    size=$(du -h "$file" | cut -f1)
                    total_size=$((total_size + $(du -k "$file" | cut -f1)))
                    echo "  📄 $(basename "$file") ($size)"
                fi
            done
        done
        
        if [ $file_count -eq 0 ]; then
            log_warning "导入目录中没有支持的文件"
            echo "支持的文件格式: ${SUPPORTED_EXTENSIONS[*]}"
            echo "请将文件放入: $IMPORT_DIR"
        else
            log_info "找到 $file_count 个文件，总计 $(du -h "$IMPORT_DIR" | cut -f1)"
        fi
    else
        log_warning "导入目录不存在: $IMPORT_DIR"
    fi
}

# 检查文件类型
check_file_type() {
    local file="$1"
    local mime_type
    
    if command -v file &> /dev/null; then
        mime_type=$(file --mime-type -b "$file")
        echo "$mime_type"
    else
        # 简单通过扩展名判断
        local extension="${file##*.}"
        echo "application/$extension"
    fi
}

# 提取文本内容（简单实现）
extract_text() {
    local file="$1"
    local output_file="$2"
    local mime_type="$3"
    
    log_info "提取文本: $(basename "$file")"
    
    case "$mime_type" in
        text/plain|application/txt)
            # TXT文件直接复制
            cp "$file" "$output_file"
            ;;
        application/pdf)
            # PDF文件使用pdftotext（如果可用）
            if command -v pdftotext &> /dev/null; then
                pdftotext "$file" "$output_file"
            else
                log_warning "未找到pdftotext，尝试简单提取"
                strings "$file" > "$output_file"
            fi
            ;;
        application/epub+zip)
            # EPUB文件（需要解压）
            if command -v unzip &> /dev/null; then
                # 创建临时目录
                local temp_dir=$(mktemp -d)
                unzip -q "$file" -d "$temp_dir"
                
                # 查找HTML文件并提取文本
                find "$temp_dir" -name "*.html" -o -name "*.xhtml" | head -5 | while read -r html_file; do
                    # 简单提取文本（移除HTML标签）
                    sed 's/<[^>]*>//g' "$html_file" >> "$output_file"
                    echo "" >> "$output_file"
                done
                
                # 清理临时目录
                rm -rf "$temp_dir"
            else
                log_warning "未找到unzip，无法处理EPUB文件"
                return 1
            fi
            ;;
        application/vnd.openxmlformats-officedocument.wordprocessingml.document)
            # DOCX文件（需要python-docx）
            if python3 -c "import docx" 2>/dev/null; then
                python3 -c "
import docx
import sys
doc = docx.Document('$file')
with open('$output_file', 'w', encoding='utf-8') as f:
    for para in doc.paragraphs:
        f.write(para.text + '\n')
"
            else
                log_warning "未安装python-docx，尝试解压DOCX"
                if command -v unzip &> /dev/null; then
                    local temp_dir=$(mktemp -d)
                    unzip -q "$file" -d "$temp_dir"
                    if [ -f "$temp_dir/word/document.xml" ]; then
                        # 简单提取文本
                        grep -o '<w:t[^>]*>[^<]*</w:t>' "$temp_dir/word/document.xml" | \
                            sed 's/<[^>]*>//g' > "$output_file"
                    fi
                    rm -rf "$temp_dir"
                fi
            fi
            ;;
        text/markdown)
            # Markdown文件直接复制
            cp "$file" "$output_file"
            ;;
        *)
            log_warning "不支持的文件类型: $mime_type"
            return 1
            ;;
    esac
    
    # 检查提取结果
    if [ -f "$output_file" ] && [ -s "$output_file" ]; then
        local line_count=$(wc -l < "$output_file")
        local word_count=$(wc -w < "$output_file")
        log_info "提取完成: $line_count 行, $word_count 词"
        return 0
    else
        log_error "提取失败或文件为空"
        return 1
    fi
}

# 分析故事内容
analyze_story() {
    local content_file="$1"
    local title=""
    local category=""
    local age_range=""
    local theme=""
    
    log_info "分析故事内容..."
    
    # 读取前几行作为标题候选
    local first_lines=$(head -10 "$content_file")
    
    # 尝试提取标题（第一行或包含"标题"的行）
    title=$(echo "$first_lines" | grep -i "标题[：:]" | head -1 | sed 's/.*标题[：:]//' | tr -d '\r')
    
    if [ -z "$title" ]; then
        # 使用第一行非空行作为标题
        title=$(echo "$first_lines" | grep -v '^$' | head -1 | cut -c1-50)
    fi
    
    # 清理标题
    title=$(echo "$title" | sed 's/^[[:space:]]*//;s/[[:space:]]*$//')
    if [ -z "$title" ] || [ "${#title}" -lt 2 ]; then
        title="未命名故事_$(date +%Y%m%d_%H%M%S)"
    fi
    
    # 分析内容确定分类
    local content=$(head -100 "$content_file" | tr '\n' ' ')
    
    # 关键词匹配分类
    if echo "$content" | grep -qi "对话\|电话\|聊天"; then
        category="通话故事"
    elif echo "$content" | grep -qi "绘本\|图画\|插图"; then
        category="绘本故事"
    elif echo "$content" | grep -qi "睡觉\|晚安\|梦境"; then
        category="睡前故事"
    elif echo "$content" | grep -qi "成语\|典故\|古语"; then
        category="成语故事"
    elif echo "$content" | grep -qi "寓言\|道理\|教训"; then
        category="寓言故事"
    elif echo "$content" | grep -qi "科学\|知识\|自然"; then
        category="科普故事"
    else
        # 随机分配分类
        categories=("通话故事" "绘本故事" "睡前故事" "成语故事" "寓言故事" "科普故事")
        category=${categories[$RANDOM % ${#categories[@]}]}
    fi
    
    # 分析年龄范围（简单通过词数判断）
    local word_count=$(wc -w < "$content_file")
    if [ "$word_count" -lt 300 ]; then
        age_range="3-4"
    elif [ "$word_count" -lt 500 ]; then
        age_range="4-5"
    else
        age_range="5-6"
    fi
    
    # 分析主题（关键词匹配）
    local themes=("友谊" "家庭" "学习" "勇敢" "诚实" "分享" "自然" "动物")
    theme=${themes[$RANDOM % ${#themes[@]}]}
    
    # 生成标签
    local tags=("$category" "$age_range" "$theme" "导入")
    
    echo "$title|$category|$age_range|$theme|${tags[*]}"
}

# 导入单个文件
import_file() {
    local file="$1"
    local filename=$(basename "$file")
    local log_file="./logs/import_$(date +%Y%m%d).log"
    
    log_info "开始导入: $filename"
    
    # 检查文件类型
    local mime_type=$(check_file_type "$file")
    log_info "文件类型: $mime_type"
    
    # 创建临时文件
    local temp_file=$(mktemp)
    local text_file="$OUTPUT_DIR/${filename%.*}.txt"
    
    # 提取文本
    if ! extract_text "$file" "$text_file" "$mime_type"; then
        log_error "文本提取失败: $filename"
        echo "$(date): 导入失败 - $filename (提取失败)" >> "$log_file"
        rm -f "$temp_file"
        return 1
    fi
    
    # 分析故事
    local analysis=$(analyze_story "$text_file")
    IFS='|' read -r title category age_range theme tags <<< "$analysis"
    
    log_info "分析结果:"
    log_info "  标题: $title"
    log_info "  分类: $category"
    log_info "  年龄: $age_range"
    log_info "  主题: $theme"
    log_info "  标签: $tags"
    
    # 计算词数
    local word_count=$(wc -w < "$text_file")
    
    # 保存到数据库
    if [ -f "$DATABASE_PATH" ]; then
        log_info "保存到数据库..."
        
        # 读取文本内容
        local content=$(cat "$text_file" | tr -d '\000')
        
        # 插入数据库（使用Python处理）
        python3 -c "
import sqlite3
import hashlib
import json
from datetime import datetime

conn = sqlite3.connect('$DATABASE_PATH')
cursor = conn.cursor()

# 计算内容哈希
content_hash = hashlib.md5('$content'.encode()).hexdigest()

# 检查是否重复
cursor.execute('SELECT id FROM stories WHERE hash = ?', (content_hash,))
if cursor.fetchone():
    print('故事已存在，跳过导入')
    exit(1)

# 插入故事
cursor.execute('''
INSERT INTO stories (title, content, category, age_range, theme, word_count, tags, source)
VALUES (?, ?, ?, ?, ?, ?, ?, ?)
''', (
    '$title',
    '$content',
    '$category',
    '$age_range',
    '$theme',
    $word_count,
    '$tags',
    'import'
))

story_id = cursor.lastrowid
conn.commit()
conn.close()

print(f'导入成功，故事ID: {story_id}')
" 2>&1 | tee -a "$log_file"
        
        if [ $? -eq 0 ]; then
            log_success "导入成功: $title"
            echo "$(date): 导入成功 - $filename -> $title (ID: ?)" >> "$log_file"
            
            # 移动原文件到已处理目录
            local processed_dir="$IMPORT_DIR/processed"
            mkdir -p "$processed_dir"
            mv "$file" "$processed_dir/"
            
            return 0
        else
            log_error "数据库保存失败"
            echo "$(date): 导入失败 - $filename (数据库错误)" >> "$log_file"
            return 1
        fi
    else
        log_warning "数据库不存在，仅保存文本文件"
        echo "$(date): 导入警告 - $filename (无数据库)" >> "$log_file"
        return 0
    fi
}

# 批量导入
batch_import() {
    local file_count=0
    local success_count=0
    local fail_count=0
    
    log_info "开始批量导入..."
    
    # 遍历支持的文件类型
    for ext in "${SUPPORTED_EXTENSIONS[@]}"; do
        for file in "$IMPORT_DIR"/*."$ext" "$IMPORT_DIR"/*."${ext^^}"; do
            if [ -f "$file" ]; then
                file_count=$((file_count + 1))
                
                if import_file "$file"; then
                    success_count=$((success_count + 1))
                else
                    fail_count=$((fail_count + 1))
                fi
                
                echo ""  # 空行分隔
            fi
        done
    done
    
    # 显示统计
    echo "=== 导入统计 ==="
    echo "总文件数: $file_count"
    echo "成功: $success_count"
    echo "失败: $fail_count"
    
    if [ $file_count -eq 0 ]; then
        log_warning "没有找到可导入的文件"
        echo ""
        echo "使用方法:"
        echo "1. 将故事文件放入 $IMPORT_DIR 目录"
        echo "2. 支持格式: ${SUPPORTED_EXTENSIONS[*]}"
        echo "3. 重新运行此脚本"
    fi
}

# 清理临时文件
cleanup() {
    log_info "清理临时文件..."
    
    # 清理空的输出文件
    find "$OUTPUT_DIR" -name "*.txt" -size 0 -delete 2>/dev/null || true
    
    # 清理临时目录
    rm -rf /tmp/tmp.* 2>/dev/null || true
    
    log_success "清理完成"
}

# 显示帮助
show_help() {
    cat << EOF
小墩子故事屋 - 故事导入脚本

用法: $0 [选项]

选项:
  -h, --help          显示此帮助信息
  -s, --show          显示导入目录内容
  -i, --import        批量导入故事文件
  -f, --file FILE     导入单个文件
  --check             检查依赖和环境
  --cleanup           清理临时文件

示例:
  $0 --show           # 显示可导入的文件
  $0 --import         # 批量导入所有文件
  $0 --file story.pdf # 导入单个文件
  $0 --check          # 检查环境

文件格式支持:
  ${SUPPORTED_EXTENSIONS[*]}

目录结构:
  $IMPORT_DIR/        # 放入要导入的文件
  $OUTPUT_DIR/        # 提取的文本文件
  ./logs/             # 导入日志
  $DATABASE_PATH      # 故事数据库

注意:
  1. 确保文件编码为UTF-8
  2. 大文件可能需要较长时间处理
  3. 导入前建议备份数据库

EOF
}

# 主函数
main() {
    # 如果没有参数，显示帮助
    if [ $# -eq 0 ]; then
        show_help
        exit 0
    fi
    
    # 解析参数
    while [[ $# -gt 0 ]]; do
        case $1 in
            -h|--help)
                show_help
                exit 0
                ;;
            --check)
                check_dependencies
                init_directories
                exit 0
                ;;
            -s|--show)
                init_directories
                show_import_dir
                exit 0
                ;;
            -i|--import)
                check_dependencies
                init_directories
                batch_import
                cleanup
                exit 0
                ;;
            -f|--file)
                if [ -z "$2" ]; then
                    log_error "--file 参数需要指定文件路径"
                    exit 1
                fi
                check_dependencies
                init_directories
                import_file "$2"
                cleanup
                exit 0
                ;;
            --cleanup)
                cleanup
                exit 0
                ;;
            *)
                log_error "未知选项: $1"
                show_help
                exit 1
                ;;
        esac
        shift
    done
}

# 运行主函数
main "$@"