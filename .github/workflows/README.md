# GitHub Actions 工作流说明

## 可用工作流

### 1. `build.yml` - 基础构建工作流
**用途**: 基本的Android应用构建和测试
**触发条件**:
- 推送到 `main` 或 `master` 分支
- 创建Pull Request到 `main` 或 `master` 分支
- 手动触发

**执行步骤**:
1. 检出代码
2. 设置JDK 17环境
3. 配置Android SDK (API 34)
4. 接受Android SDK许可证
5. 缓存Gradle依赖
6. 构建Debug和Release APK
7. 运行单元测试
8. 上传构建产物

**产物**:
- `app-debug-apk`: Debug版本APK
- `app-release-apk`: Release版本APK  
- `test-results`: 测试报告
- `build-reports`: 构建报告

### 2. `ci.yml` - 完整CI/CD流水线
**用途**: 完整的持续集成/持续部署流水线
**触发条件**:
- 推送到 `main`, `master`, `develop` 分支
- 推送到 `v*` 标签（如 `v1.0.0`）
- 创建Pull Request
- 手动触发（可选择环境）

**工作流程**:
1. **代码质量检查** (仅PR时运行)
2. **构建APK** (Debug和Release变体)
3. **运行测试** (单元测试和仪器测试)
4. **安全扫描** (MobSF安全扫描)
5. **部署** (创建GitHub Release，部署到Firebase)
6. **通知** (Slack通知)
7. **监控** (工作流指标)

## 配置要求

### 必需的环境变量
在GitHub仓库的 `Settings > Secrets and variables > Actions` 中配置:

| 变量名 | 说明 | 必需 |
|--------|------|------|
| `FIREBASE_APP_ID` | Firebase应用ID | 可选 |
| `FIREBASE_TOKEN` | Firebase访问令牌 | 可选 |
| `SLACK_WEBHOOK_URL` | Slack Webhook URL | 可选 |

### Android环境
- **JDK**: 17 (Temurin发行版)
- **Android SDK**: API 34
- **构建工具**: 34.0.0
- **Gradle**: 8.5 (通过gradle-wrapper)

## 使用指南

### 手动触发构建
1. 访问GitHub仓库的"Actions"标签页
2. 选择"Build Android App"工作流
3. 点击"Run workflow"按钮
4. 选择分支并运行

### 查看构建结果
1. 在"Actions"标签页查看运行状态
2. 点击具体的运行查看详细日志
3. 在"Artifacts"部分下载构建产物

### 故障排除

#### 常见问题
1. **Android SDK许可证问题**
   - 确保工作流中的许可证接受步骤正常工作
   - 检查网络连接

2. **Gradle构建失败**
   - 检查依赖配置是否正确
   - 查看构建日志中的具体错误信息

3. **测试失败**
   - 检查单元测试代码
   - 确保测试环境配置正确

#### 日志位置
- 构建日志: GitHub Actions运行页面
- 测试报告: `app/build/reports/tests/`
- 构建报告: `app/build/reports/`

## 自定义配置

### 修改构建变体
编辑 `build.yml` 中的构建步骤:
```yaml
- name: Build Debug APK
  run: ./gradlew assembleDebug
```

### 添加新的构建任务
在 `jobs.build.steps` 中添加新的步骤:
```yaml
- name: 自定义任务
  run: ./gradlew yourTask
```

### 调整缓存策略
修改缓存配置:
```yaml
- name: Cache Gradle dependencies
  uses: actions/cache@v4
  with:
    path: ~/.gradle/caches
    key: ${{ runner.os }}-gradle-${{ hashFiles('**/*.gradle*') }}
```

## 最佳实践

1. **保持工作流简洁**: 每个工作流专注于一个特定任务
2. **使用缓存**: 缓存Gradle依赖加速构建
3. **及时清理**: 设置合理的产物保留时间
4. **监控告警**: 配置通知机制及时发现问题
5. **版本控制**: 工作流文件随代码一起版本控制

## 联系方式

如有问题，请:
1. 查看GitHub Actions日志
2. 检查项目配置
3. 参考Android官方文档
4. 在GitHub Issues中报告问题