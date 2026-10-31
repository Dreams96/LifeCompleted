# 人生已完成清单 · Life Completed

<p align="center">
  <strong>记录已经完成的人生经历，珍藏每一个值得记住的瞬间。</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green?style=flat-square" alt="Android">
  <img src="https://img.shields.io/badge/Language-Kotlin-purple?style=flat-square" alt="Kotlin">
  <img src="https://img.shields.io/badge/UI-Jetpack%20Compose-blue?style=flat-square" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/License-MIT-yellow?style=flat-square" alt="MIT License">
</p>

---

## 项目简介

**人生已完成清单（Life Completed）** 是一款基于 Kotlin 和 Jetpack Compose 开发的 Android 本地生活记录应用。

它的核心理念很简单：

> 人生不应该只记录“还没完成什么”，也应该记住“已经完成了什么”。

应用提供固定人生事项、自定义经历、完成状态记录以及数据管理等功能，帮助用户记录生活中的经历、挑战和值得纪念的时刻。

本项目目前以**个人学习、技术实践和开源交流**为主要目的。

---

## ✨ 功能

### 🏠 首页

- 查看人生数据概览
- 查看清单完成情况
- 快速了解当前完成进度

### 📋 人生清单

支持用户创建和管理自己的生活经历。

例如：

- 一个人旅行
- 学会一种乐器
- 看一次日出
- 完成一次挑战
- 做一件一直想做的事情

### 🎯 固定人生事项

应用内置一组人生经历事项，目前为 **185 项**。

支持：

- 查看全部事项
- 查看已完成事项
- 查看未完成事项
- 点击事项进行完成 / 取消
- 查看整体完成进度
- 退出应用后保留完成状态

固定事项与用户自定义经历采用独立的数据结构和存储逻辑。

### 📊 数据统计

用于查看个人清单完成情况以及相关统计信息。

### 💾 数据备份

应用支持本地数据管理，并提供 JSON 数据备份 / 恢复机制。

> 建议在卸载应用、刷机或更换设备前先备份重要数据。

---

## 🛠 技术栈

| 技术 | 版本 / 用途 |
|---|---|
| Kotlin | 2.2.10 |
| Android Gradle Plugin | 9.5.0 |
| Jetpack Compose | UI |
| Compose BOM | 2026.02.01 |
| Material 3 | UI 组件 |
| Android SDK | Android 应用开发 |
| SharedPreferences | 本地数据存储 |
| JSON | 数据备份 |

### 应用信息

| 项目 | 内容 |
|---|---|
| 应用名称 | 人生已完成清单 |
| 英文名称 | Life Completed |
| Application ID | `com.dreams.lifecompleted` |
| 当前版本 | `1.0` |
| 最低 Android 版本 | API 24 |
| 开发语言 | Kotlin |

---

## 📱 开发环境

推荐使用：

- Android Studio
- JDK 11
- Android SDK
- Gradle Wrapper

首次打开项目后，等待 Android Studio 完成 Gradle Sync。

然后连接 Android 手机或启动模拟器：

```text
Run → Run 'app'
```

即可运行项目。

---

## 🚀 构建项目

### Debug

可以直接使用 Android Studio：

```text
Build → Build APK(s)
```

生成的 Debug APK 通常位于：

```text
app/build/outputs/apk/debug/
```

### Release

正式发布建议使用：

```text
Build
→ Generate Signed Bundle / APK
→ APK
→ release
```

Release APK 通常位于：

```text
app/build/outputs/apk/release/
```

---

## 🔐 签名密钥

**请勿将 Android 签名密钥提交到 GitHub。**

例如：

```text
*.jks
*.keystore
```

应该加入 `.gitignore`。

签名密钥一旦用于正式发布，请妥善保存。

如果未来需要更新已经发布的 APK，应继续使用对应的签名密钥。

---

## ⚠️ 开源前的安全检查

在将本项目公开到 GitHub 前，请确认仓库中没有：

- Android 签名密钥
- 密钥密码
- API Key
- Access Token
- Cookie
- 数据库密码
- 私人服务器地址
- 私人配置文件
- 个人身份信息
- 本地绝对路径
- 私人备份文件

例如不要提交：

```text
*.jks
*.keystore
local.properties
.env
*.pem
*.key
secrets.properties
```

GitHub 官方建议公开仓库启用 Secret Scanning、Push Protection、Dependabot 等安全功能，以减少密钥泄露和依赖漏洞风险。

---

# ⚖️ 开源许可

本项目源代码采用：

**MIT License**

MIT 是一种宽松型开源许可证，允许他人使用、复制、修改、合并、发布和再分发代码，同时保留版权和许可证声明。MIT 是 OSI 列出的批准开源许可证之一。

完整许可证内容请参见：

```text
LICENSE
```

> 注意：MIT License 主要针对本项目作者拥有版权并有权授权的代码。第三方依赖、第三方素材、字体、图片、图标和其他内容仍受其各自许可证或授权条款约束。

---

# 📦 第三方依赖

本项目使用 Android / Kotlin / Jetpack Compose 等第三方开源软件。

第三方依赖的版权及许可证归其各自权利人所有。

本项目不会因为使用这些依赖而主张拥有第三方项目的版权或商标权。

建议在发布正式版本前检查：

```text
gradle/libs.versions.toml
```

以及 Gradle 依赖树，并根据实际依赖情况保留相应的版权和许可证信息。

---

# 🎨 图片、图标与其他素材

本项目中的图片、图标、字体、插画等非代码素材不应默认视为 MIT License 授权。

如果仓库中包含第三方素材，应当：

1. 确认素材来源；
2. 确认允许开源项目使用；
3. 确认允许修改和再分发；
4. 根据素材许可证保留署名；
5. 在 `NOTICE.md` 或相应目录中注明来源。

对于无法确认版权或授权情况的素材，不建议直接提交到公开仓库。

---

# ™️ 商标与品牌

本项目不授予任何第三方使用相关商标、品牌名称、Logo 或其他具有识别性的商业标识的权利。

包括但不限于：

- Android
- Google
- Kotlin
- Jetpack Compose
- GitHub

上述名称和标识属于其各自权利人。

本项目与 Google、Android、JetBrains、GitHub 或其他第三方机构不存在默认的官方合作、授权或隶属关系。

---

# 📚 项目中的文字与清单内容

本项目包含用于演示和记录人生经历的清单内容。

对于项目作者自行创作并依法享有权利的代码、文字及素材，其版权归相应权利人所有，并按照项目许可证进行授权。

如果某些清单、文字或其他内容来源于第三方：

- 不应默认认为其属于本项目；
- 应确认其版权状态；
- 应遵守原作者的许可条件；
- 必要时应获得授权；
- 不应将第三方受保护内容直接声明为本项目原创内容。

如果发现仓库中存在版权归属不清晰的内容，可以通过 Issue 或其他公开联系方式联系维护者。

---

# 🔒 隐私说明

本项目设计目标是以本地存储为主。

应用中的个人清单数据属于用户自己的数据。

如果用户通过 JSON 等方式导出数据，导出的文件可能包含用户个人创建的内容。

因此：

- 不建议将个人备份文件提交到公开 GitHub 仓库；
- 不建议将包含个人信息的 JSON 文件上传到公开 Issue；
- 不建议将私人截图、日志或设备信息直接公开；
- 用户应自行妥善保管个人数据。

本项目仓库本身不应包含真实用户的私人数据。

---

# ⚠️ 免责声明

本项目按“**现状（AS IS）**”提供，仅用于学习、研究、个人使用及开源交流。

项目作者不对以下事项作出保证：

- 软件始终能够正常运行；
- 软件不存在缺陷；
- 软件适用于所有 Android 设备；
- 数据不会因设备、系统、存储异常等原因丢失；
- 第三方依赖始终保持兼容；
- 项目能够满足特定商业或其他用途的要求。

使用本项目产生的风险由使用者自行承担。

对于因使用、修改、重新发布或二次开发本项目而产生的任何直接或间接损失，应按照适用法律及项目许可证处理。

本免责声明不旨在排除适用法律明确规定不得排除或限制的责任。

---

# 🚫 不得提交的内容

Pull Request 和 Commit 中不得提交：

```text
密码
API Key
Token
Cookie
私钥
签名密钥
真实用户数据
个人身份证件
私人照片
私人备份文件
未获授权的第三方素材
```

发现敏感信息后，应立即停止继续传播，并尽快采取撤销、轮换或删除等措施。

**仅删除 GitHub 当前文件并不一定意味着历史提交中的敏感信息已经彻底消失。**

---

# 🤝 贡献

欢迎提交：

- Bug 修复
- UI 改进
- 功能建议
- 文档改进
- 性能优化
- 代码重构

建议贡献前先阅读：

```text
CONTRIBUTING.md
```

提交 Pull Request 前，请确保：

- 项目能够正常编译；
- 不包含敏感信息；
- 不包含未经授权的第三方内容；
- 不引入明显的安全问题；
- 修改内容与项目目标相关；
- 提交说明清晰。

---

# 🐛 Issue

如果发现问题，可以提交 GitHub Issue。

Bug 报告建议包含：

```text
Android 版本：
设备型号：
App 版本：
问题描述：
复现步骤：
预期结果：
实际结果：
相关日志：
```

提交日志前，请删除：

```text
Token
密码
Cookie
个人信息
设备唯一标识
私人文件路径
其他敏感数据
```

---

# 🔐 安全问题

如果发现可能导致：

- 数据泄露
- 密钥泄露
- 权限绕过
- 任意代码执行
- 用户隐私泄露
- 严重安全漏洞

等问题，请不要直接在公开 Issue 中发布完整利用细节。

建议通过项目维护者提供的私下联系方式进行负责任披露。

详细规则请参见：

```text
SECURITY.md
```

GitHub 也建议开源项目提供 `SECURITY.md`，用于说明漏洞报告方式和负责任披露流程。

---

# 📄 相关文件

建议仓库包含以下文件：

| 文件 | 用途 |
|---|---|
| `README.md` | 项目介绍与使用说明 |
| `LICENSE` | 开源许可证 |
| `NOTICE.md` | 第三方版权及声明 |
| `CONTRIBUTING.md` | 贡献指南 |
| `CODE_OF_CONDUCT.md` | 社区行为规范 |
| `SECURITY.md` | 安全漏洞报告 |
| `.gitignore` | Git 忽略规则 |

GitHub 官方也推荐通过 README、License、贡献指南、行为准则和安全策略明确项目的使用及协作规则。

---

# 🗺️ Roadmap

未来可能考虑：

- [ ] 完善数据备份与恢复
- [ ] 固定清单数据完整纳入 JSON 备份
- [ ] 增加更多统计方式
- [ ] 优化 UI 与动画
- [ ] 增加主题设置
- [ ] 增加数据导入校验
- [ ] 完善多设备数据迁移
- [ ] 完善开源文档
- [ ] 增加自动化测试

Roadmap 仅代表当前规划，不构成未来功能或发布时间承诺。

---

# 📜 版本

当前版本：

```text
1.0
```

项目仍处于持续开发阶段，API、数据结构、UI 和功能可能发生变化。

---

# ❤️ 致谢

感谢以下开源项目和社区提供的技术支持：

- Kotlin
- Android
- Jetpack Compose
- Material 3
- AndroidX
- Gradle
- GitHub

感谢所有开源软件作者及贡献者。

---

# 📄 License

Copyright © 2026 Project Contributors.

本项目源代码采用 MIT License 授权。

具体内容请参阅 [`LICENSE`](LICENSE)。

---

<p align="center">
  <strong>记录经历 · 完成目标 · 珍藏生活</strong>
</p>