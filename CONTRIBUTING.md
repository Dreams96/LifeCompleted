# Contributing

感谢你对「人生已完成清单 · Life Completed」的关注。

欢迎提交 Bug 修复、功能改进、UI 优化、性能优化、文档改进以及其他与项目目标相关的贡献。

## 项目维护者

**GitHub：** Dreams96

**Email：** dreams3040@qq.com

## 开始之前

提交贡献前，请确认：

- 你有权提交所贡献的代码、文字或素材；
- 不包含 API Key、Token、密码、私钥或 Android 签名密钥；
- 不包含真实用户的个人数据；
- 不提交未经授权的第三方图片、字体、音乐、文字或其他素材；
- 修改内容与项目目标相关。

## 开发流程

推荐按照以下流程进行：

1. Fork 本项目。
2. 创建独立分支。
3. 完成修改。
4. 在本地构建并测试。
5. 提交 Commit。
6. Push 到自己的 Fork。
7. 创建 Pull Request。

推荐使用以下分支命名方式：

```text
feature/功能名称
fix/问题名称
docs/文档名称
refactor/重构内容
```

## 开发环境

本项目主要使用：

- Android Studio
- Kotlin
- Jetpack Compose
- Material 3
- Gradle
- Android SDK

具体版本以项目当前 Gradle 配置为准。

## 代码要求

请尽量遵循以下原则：

- 使用清晰、易读的 Kotlin 代码；
- 遵循 Kotlin 推荐的代码风格；
- 保持现有项目结构；
- 避免无必要的大范围修改；
- UI 修改尽量保持现有设计语言；
- 新增功能应考虑异常情况；
- 不提交本地绝对路径；
- 不提交开发环境专属配置；
- 不提交生成的 APK、AAB 或签名文件。

## Commit

建议使用清晰的 Commit 信息，例如：

```text
feat: add life statistics

fix: preserve completed items

docs: update README

refactor: simplify data storage

ui: improve checklist layout
```

## Pull Request

Pull Request 建议说明：

- 修改了什么；
- 为什么修改；
- 如何测试；
- 是否涉及数据结构变化；
- 是否涉及 UI 变化；
- 是否新增第三方依赖。

如果修改涉及 UI，建议附上修改前后的截图。

## 第三方依赖和素材

如果 Pull Request 新增第三方依赖，请说明：

- 依赖名称；
- 使用目的；
- 版本；
- 许可证。

如果新增图片、字体、图标或其他资源，请确认其许可证允许在本项目中使用，并在必要时补充版权和来源信息。

## 数据和隐私

本项目涉及用户个人数据时，应尽量遵循最小化原则。

不要在 Issue、Pull Request、日志或截图中提交：

```text
姓名
电话号码
邮箱
地址
账号信息
密码
Token
设备唯一标识
其他个人敏感信息
```

## 安全问题

如果发现可能导致数据泄露、密钥泄露、权限绕过或其他严重安全问题，请不要直接在公开 Issue 中发布完整漏洞利用细节。

请参考：

```text
SECURITY.md
```

## 行为准则

参与项目讨论和协作时，请遵守：

```text
CODE_OF_CONDUCT.md
```

## 许可证

提交到本项目的代码应当能够按照项目当前开源许可证进行授权。

如果贡献内容包含第三方代码、文字或素材，请在提交前确认其许可证允许这样做，并提供必要的版权和许可证信息。