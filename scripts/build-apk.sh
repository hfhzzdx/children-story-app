#!/bin/bash
# 构建APK脚本 - 小墩子故事屋

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

# 检查环境函数
check_environment() {
    log_info "检查构建环境..."
    
    # 检查Java
    if command -v java &> /dev/null; then
        JAVA_VERSION=$(java -version 2>&1 | head -1 | cut -d'"' -f2)
        log_info "Java版本: $JAVA_VERSION"
        
        # 检查Java版本是否为17
        if [[ $JAVA_VERSION != *"17"* ]]; then
            log_warning "建议使用Java 17，当前版本: $JAVA_VERSION"
        fi
    else
        log_error "未找到Java，请安装Java 17"
        exit 1
    fi
    
    # 检查Android SDK
    if [ -n "$ANDROID_HOME" ]; then
        log_info "ANDROID_HOME: $ANDROID_HOME"
    else
        log_warning "ANDROID_HOME未设置，尝试自动检测..."
        
        # 尝试常见路径
        possible_paths=(
            "$HOME/Android/Sdk"
            "/usr/local/android-sdk"
            "/opt/android-sdk"
            "/Users/$USER/Library/Android/sdk"
        )
        
        for path in "${possible_paths[@]}"; do
            if [ -d "$path" ]; then
                export ANDROID_HOME="$path"
                log_info "检测到Android SDK: $ANDROID_HOME"
                break
            fi
        done
        
        if [ -z "$ANDROID_HOME" ]; then
            log_error "未找到Android SDK，请设置ANDROID_HOME环境变量"
            exit 1
        fi
    fi
    
    # 检查Gradle
    if [ -f "./gradlew" ]; then
        log_info "使用项目Gradle Wrapper"
        chmod +x ./gradlew
    else
        log_error "未找到gradlew，请在项目根目录运行此脚本"
        exit 1
    fi
    
    # 检查设备连接（可选）
    if command -v adb &> /dev/null; then
        DEVICE_COUNT=$(adb devices | grep -v "List of devices" | grep -c "device$")
        if [ $DEVICE_COUNT -gt 0 ]; then
            log_info "检测到 $DEVICE_COUNT 个已连接的Android设备"
        else
            log_warning "未检测到已连接的Android设备"
        fi
    fi
    
    log_success "环境检查完成"
}

# 清理构建
clean_build() {
    log_info "清理构建文件..."
    ./gradlew clean
    log_success "清理完成"
}

# 构建Debug版本
build_debug() {
    log_info "开始构建Debug版本..."
    
    # 同步依赖
    log_info "同步Gradle依赖..."
    ./gradlew build --refresh-dependencies
    
    # 构建Debug APK
    log_info "构建Debug APK..."
    ./gradlew assembleDebug
    
    # 检查构建结果
    if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
        APK_SIZE=$(du -h "app/build/outputs/apk/debug/app-debug.apk" | cut -f1)
        log_success "Debug APK构建成功！大小: $APK_SIZE"
        log_info "APK位置: $(pwd)/app/build/outputs/apk/debug/app-debug.apk"
    else
        log_error "Debug APK构建失败"
        exit 1
    fi
}

# 构建Release版本
build_release() {
    log_info "开始构建Release版本..."
    
    # 检查签名配置
    if [ ! -f "storyhouse.keystore" ]; then
        log_warning "未找到签名密钥库，跳过Release构建"
        log_info "如需构建Release版本，请先配置签名："
        log_info "1. 生成密钥库: keytool -genkey -v -keystore storyhouse.keystore -alias storyhouse -keyalg RSA -keysize 2048 -validity 10000"
        log_info "2. 在app/build.gradle中配置签名"
        return
    fi
    
    # 构建Release APK
    log_info "构建Release APK..."
    ./gradlew assembleRelease
    
    # 检查构建结果
    if [ -f "app/build/outputs/apk/release/app-release.apk" ]; then
        APK_SIZE=$(du -h "app/build/outputs/apk/release/app-release.apk" | cut -f1)
        log_success "Release APK构建成功！大小: $APK_SIZE"
        log_info "APK位置: $(pwd)/app/build/outputs/apk/release/app-release.apk"
    else
        log_error "Release APK构建失败"
        exit 1
    fi
}

# 运行测试
run_tests() {
    log_info "运行测试..."
    
    # 单元测试
    log_info "运行单元测试..."
    ./gradlew test
    
    # Android测试（如果有设备连接）
    if command -v adb &> /dev/null && [ $(adb devices | grep -v "List of devices" | grep -c "device$") -gt 0 ]; then
        log_info "运行Android测试..."
        ./gradlew connectedCheck
    else
        log_warning "跳过Android测试（无设备连接）"
    fi
    
    log_success "测试完成"
}

# 代码质量检查
run_lint() {
    log_info "运行代码质量检查..."
    ./gradlew lintDebug
    
    # 检查lint结果
    if [ -f "app/build/reports/lint-results.html" ]; then
        log_info "Lint报告: $(pwd)/app/build/reports/lint-results.html"
    fi
    
    log_success "代码质量检查完成"
}

# 安装到设备
install_to_device() {
    log_info "安装APK到设备..."
    
    if ! command -v adb &> /dev/null; then
        log_error "未找到adb命令，跳过安装"
        return
    fi
    
    DEVICE_COUNT=$(adb devices | grep -v "List of devices" | grep -c "device$")
    
    if [ $DEVICE_COUNT -eq 0 ]; then
        log_warning "未检测到已连接的Android设备，跳过安装"
        return
    fi
    
    # 选择要安装的APK
    APK_FILE=""
    if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
        APK_FILE="app/build/outputs/apk/debug/app-debug.apk"
    elif [ -f "app/build/outputs/apk/release/app-release.apk" ]; then
        APK_FILE="app/build/outputs/apk/release/app-release.apk"
    fi
    
    if [ -z "$APK_FILE" ]; then
        log_error "未找到APK文件，请先构建"
        return
    fi
    
    log_info "安装APK: $APK_FILE"
    
    # 获取包名
    PACKAGE_NAME="com.dunzi.storyhouse"
    
    # 卸载旧版本（如果存在）
    if adb shell pm list packages | grep -q "$PACKAGE_NAME"; then
        log_info "卸载旧版本..."
        adb uninstall "$PACKAGE_NAME"
    fi
    
    # 安装新版本
    adb install "$APK_FILE"
    
    if [ $? -eq 0 ]; then
        log_success "安装成功！"
        
        # 可选：启动应用
        read -p "是否要启动应用？(y/n): " -n 1 -r
        echo
        if [[ $REPLY =~ ^[Yy]$ ]]; then
            log_info "启动应用..."
            adb shell am start -n "$PACKAGE_NAME/.MainActivity"
        fi
    else
        log_error "安装失败"
    fi
}

# 生成构建报告
generate_report() {
    log_info "生成构建报告..."
    
    REPORT_FILE="build-report-$(date +%Y%m%d-%H%M%S).txt"
    
    cat > "$REPORT_FILE" << EOF
小墩子故事屋 - 构建报告
生成时间: $(date)
构建环境: $(uname -s) $(uname -m)

Java版本:
$(java -version 2>&1)

Gradle版本:
$(./gradlew --version 2>&1 | grep -A2 "Gradle")

Android SDK:
ANDROID_HOME=$ANDROID_HOME
$(ls $ANDROID_HOME/platforms/)

构建配置:
$(./gradlew -q properties | grep -E 'versionName|versionCode|buildToolsVersion|compileSdkVersion|minSdkVersion|targetSdkVersion')

构建结果:
$(find . -name "*.apk" -type f -exec ls -la {} \;)

测试结果:
$(if [ -f "app/build/reports/tests/testDebugUnitTest/index.html" ]; then echo "单元测试报告已生成"; else echo "无单元测试报告"; fi)

代码质量:
$(if [ -f "app/build/reports/lint-results.html" ]; then echo "Lint报告已生成"; else echo "无Lint报告"; fi)
EOF
    
    log_success "构建报告已生成: $REPORT_FILE"
    cat "$REPORT_FILE"
}

# 显示帮助
show_help() {
    cat << EOF
小墩子故事屋 - APK构建脚本

用法: $0 [选项]

选项:
  -h, --help          显示此帮助信息
  -c, --clean         清理构建文件
  -d, --debug         构建Debug版本（默认）
  -r, --release       构建Release版本
  -t, --test          运行测试
  -l, --lint          运行代码质量检查
  -i, --install       安装到设备
  -a, --all           执行所有步骤（清理、构建、测试、安装）
  --check-env         只检查环境

示例:
  $0 -a               # 执行完整构建流程
  $0 -d -t           # 构建Debug版本并运行测试
  $0 --check-env     # 只检查构建环境

环境变量:
  ANDROID_HOME       Android SDK路径
  JAVA_HOME          Java安装路径

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
            --check-env)
                check_environment
                exit 0
                ;;
            -c|--clean)
                DO_CLEAN=true
                shift
                ;;
            -d|--debug)
                DO_DEBUG=true
                shift
                ;;
            -r|--release)
                DO_RELEASE=true
                shift
                ;;
            -t|--test)
                DO_TEST=true
                shift
                ;;
            -l|--lint)
                DO_LINT=true
                shift
                ;;
            -i|--install)
                DO_INSTALL=true
                shift
                ;;
            -a|--all)
                DO_CLEAN=true
                DO_DEBUG=true
                DO_TEST=true
                DO_LINT=true
                DO_INSTALL=true
                shift
                ;;
            *)
                log_error "未知选项: $1"
                show_help
                exit 1
                ;;
        esac
    done
    
    # 检查环境
    check_environment
    
    # 执行清理
    if [ "$DO_CLEAN" = true ]; then
        clean_build
    fi
    
    # 构建Debug版本（如果没有指定构建类型，默认构建Debug）
    if [ "$DO_DEBUG" = true ] || ([ "$DO_RELEASE" != true ] && [ "$DO_DEBUG" != true ] && [ "$DO_CLEAN" != true ] && [ "$DO_TEST" != true ] && [ "$DO_LINT" != true ]); then
        build_debug
    fi
    
    # 构建Release版本
    if [ "$DO_RELEASE" = true ]; then
        build_release
    fi
    
    # 运行测试
    if [ "$DO_TEST" = true ]; then
        run_tests
    fi
    
    # 代码质量检查
    if [ "$DO_LINT" = true ]; then
        run_lint
    fi
    
    # 安装到设备
    if [ "$DO_INSTALL" = true ]; then
        install_to_device
    fi
    
    # 生成报告
    generate_report
    
    log_success "构建流程完成！"
}

# 运行主函数
main "$@"