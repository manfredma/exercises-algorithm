# LeetCode 题面抓取与规范（共享）

本文件定义 LeetCode 题面的抓取方式与 `readme.md` / `Main.java` 题面注释的统一规范。初始化新题（[`leetcode-init-workflow.md`](leetcode-init-workflow.md)）与重刷已解决题（[`leetcode-refresh-workflow.md`](leetcode-refresh-workflow.md)）均依赖本规范；仅刷新题面格式（不重刷解法）时也只读本文件。`AGENTS.md` 中的约束优先。

## 抓取题面

在项目根目录执行：

```bash
python3 scripts/fetch-leetcode-problem.py <题号>
```

脚本走 LeetCode 中文站 GraphQL，按题号查询，成功时输出一行 JSON，字段：

| 字段 | 含义 |
|------|------|
| `num` / `padded` | 题号 / 4位补零（如 `13` / `0013`） |
| `slug` | URL slug（如 `roman-to-integer`） |
| `titleCn` / `titleEn` | 中文标题 / 英文标题 |
| `difficulty` | 难度（`Easy` / `Medium` / `Hard`） |
| `contentCn` | 题面正文（HTML 已转纯文本，`<sub>` 已转 Unicode 下标） |
| `images` | 题面图片元数据（`url` / `alt` / `filename`） |
| `examples` | 尽力提取的示例 `input` / `output` |
| `returnType` / `methodName` / `params` | 方法签名（Java 风格） |

**完整性铁律**：只有取得完整 JSON 后才可创建或更新题面、骨架和测试。请求失败、超时、空数据或字段不完整时可重试；仍失败则停止，**不得使用记忆、摘要或第三方题面补全**。

## README 与题面注释规范

- 题面描述、全部示例、解释和提示必须完整保留，**不能概括或改写**。
- README 标题下写入链接，`Main.java` 题面注释前写入链接，两者使用本次抓取的**同一 `slug`**：
  - `readme.md`：`> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/{slug}/)`
  - `Main.java`：`/** 题目链接：https://leetcode.cn/problems/{slug}/ */`
- README 正文中的 Markdown 特殊字符必须按字面量可见：运算符等优先使用行内代码，示例放入 `text` 代码块，不能让字符被 Markdown 语法吞掉或额外显示转义符。
- HTML 下标转换为 Unicode 下标（如 `Rᵢ`、`Cⱼ`）；不得简化为普通字符，也不得使用 IntelliJ Markdown 预览不会渲染的 `<sub>` 标签。脚本输出的 `contentCn` 已完成此转换。

## 图片规范

- 以脚本输出的 `images` 为**唯一来源**。每张图片下载至当前题目目录的 `images/`，README 使用本地相对路径引用，**不得保留 LeetCode 外链**。
- 图片必须出现在 LeetCode 中文站原题对应的位置。例如图片位于示例标题和输入之间时，README 也必须在两者之间插入。图片**不得置于 `text` 代码块中**，也**不得统一追加到文末**。

## 验证核对清单

逐项确认：

- README 与 Main 的链接一致，且均使用本次抓取的 `slug`。
- 每张远程图片均已下载，并按原题位置以本地相对路径引用。
- 特殊字符和 Unicode 下标在 IntelliJ Markdown 预览中可见。
- `Main` 覆盖全部示例和适用的关键场景。

编译命令必须包含 `-Dsort.skip=true`：

```bash
mvn -f pom.xml clean compile -pl leet-code -DskipTests -Dsort.skip=true
```
