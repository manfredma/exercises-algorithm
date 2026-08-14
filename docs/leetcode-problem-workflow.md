# LeetCode 题目工作流

本文件定义本项目新增、重新抓取与归档 LeetCode 题目的流程；`AGENTS.md` 中的约束优先。

## 完成一题的收尾 SOP（Claude Code 与 Codex 共同遵循）

每道 LeetCode 题目解法实现后、提交前，**必须按顺序**走完以下清单，缺一不可：

1. **补注释**：本题所有 `Solution*.java` 加类级 Javadoc，说明思路、关键点与复杂度；多解法间体现演进关系。
2. **补用例**：`Main.java` 含官方全部示例 + 适用边界用例（单元素/空/极值/并列/特殊结构），assert 断言风格；用例须覆盖能暴露常见 bug 的场景（如多位数、负数、溢出、非法并列等，依题而定）。
3. **编译验证**：`mvn -f pom.xml clean compile -pl leet-code -DskipTests -Dsort.skip=true` 通过。
4. **运行验证**：`java -cp leet-code/target/classes manfred.exercises.leetcode.wip.pXXXX.Main` 无 AssertionError 退出（退出码 0）。多解法时全部测通。
5. **归档**：`wip/pXXXX/` 整目录迁移到 `solved/pAAABBB/pXXXX/`（`AAABBB` 为题号所在连续百题段），同步更新所有 `.java` 的 package 声明。
6. **归档后重新编译运行**：用归档后的包路径再跑一次 Main，确认 package 变更无误。
7. **更新进度**（若该题在 `HOT100_REVIEW.md` 表中）：对应行改为 `✅ 日期 重刷完成（说明，已归档）`。
8. **暂存、提交、推送**：只暂存本题 + 进度文件；commit 消息 `feat(leetcode): solve problem XXXX with <简述>`；推送到 `origin/main`。

> Claude Code 可用 `/finish-leetcode <题号>` 命令执行步骤 3–8 的机械部分；步骤 1–2（注释、用例）需人工判断，不在命令内自动完成。Codex 读取本清单与 `AGENTS.md`，按步骤手动执行。

**未完成（Solution 仍空骨架、Main 有失败用例）的题目不得归档**，留在 `wip` 并说明原因。

## 抓取题面

在项目根目录执行：

```bash
python3 scripts/fetch-leetcode-problem.py <题号>
```

脚本成功时输出一行 JSON，包含 `num`、`padded`、`slug`、`titleCn`、`difficulty`、`contentCn`、`images`、`examples`、`returnType`、`methodName` 和 `params`。只有取得完整 JSON 后才可创建或更新题面、骨架和测试；请求失败、超时、空数据或字段不完整时可以重试，仍失败则停止，不能使用记忆、摘要或第三方题面补全。

## 初始化目录与文件

新题目录固定为：

```text
leet-code/src/main/java/manfred/exercises/leetcode/wip/pXXXX/
```

包名为 `manfred.exercises.leetcode.wip.pXXXX`。目录包含 `readme.md`、`Solution.java` 和 `Main.java`。

`Solution.java` 只保留题面给出的类、构造器和方法签名，以及可编译的 TODO 占位返回值；不提前写解法。占位返回值按返回类型选择：`int`/`long` → `0`，`boolean` → `false`，`String` → `""`，数组/对象 → `null`。`Main.java` 必须有 `public static void main(String[] args)`，将全部官方示例写为可执行断言，并按题型补充边界、空/极值、并列结果和典型结构等必要用例。所有题目测试都放在 `Main.main`，不得新增 JUnit/TestNG 测试类。

## Java 8 约束

项目使用 Java 8，`Solution.java` 与 `Main.java` 禁止使用 Java 9+ API：

- ❌ `List.of()`、`Map.of()`、`Set.of()` → ✅ `Arrays.asList()`
- ❌ `var` 关键字
- ❌ `String.isBlank()`、`Optional.ifPresentOrElse()` 等 Java 9+ 方法

## README 与题面注释

- 题面描述、全部示例、解释和提示必须完整保留，不能概括或改写。
- README 标题下写入 `> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/{slug}/)`；`Main.java` 的题面注释前写入 `/** 题目链接：https://leetcode.cn/problems/{slug}/ */`。两者均使用本次抓取的同一 `slug`。
- README 正文中的 Markdown 特殊字符必须按字面量可见：运算符等优先使用行内代码，示例放入 `text` 代码块，不能让字符被 Markdown 语法吞掉或额外显示转义符。
- HTML 下标转换为 Unicode 下标，如 `Rᵢ`、`Cⱼ`；不要简化为普通字符，也不要使用 IntelliJ Markdown 预览不会渲染的 `<sub>` 标签。

## 图片

以脚本输出的 `images` 为唯一来源。每张图片下载至当前题目目录的 `images/`，README 使用本地相对路径引用，不能保留 LeetCode 外链。

图片必须出现在 LeetCode 中文站原题对应的位置。例如图片位于示例标题和输入之间时，README 也必须在两者之间插入图片。图片不得置于 `text` 代码块中，也不得统一追加到文末。

## 验证

逐项确认：

- README 与 Main 的链接一致，且均使用本次抓取的 `slug`。
- 每张远程图片均已下载，并按原题位置以本地相对路径引用。
- 特殊字符和 Unicode 下标在 IntelliJ Markdown 预览中可见。
- `Main` 覆盖全部示例和适用的关键场景。

编译命令必须包含 `-Dsort.skip=true`：

```bash
mvn -f pom.xml clean compile -pl leet-code -DskipTests -Dsort.skip=true
```

## 归档与提交

题目完成并通过 `Main` 验证后，迁移整个目录到：

```text
leet-code/src/main/java/manfred/exercises/leetcode/solved/pXXXXtoYYYY/pZZZZ/
```

其中范围是题号所在连续百题段；例如 328 归档到 `solved/p0301to0400/p0328/`。同步更新该题的 package 声明与所有跨题 import。

用户要求提交某题时，若该题已完成，先归档再暂存、提交和推送；未完成的题目留在 `wip`，并在提交前说明原因。
