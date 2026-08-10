# LeetCode 题目工作流

本文件定义本项目新增、重新抓取与归档 LeetCode 题目的流程；`AGENTS.md` 中的约束优先。

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

`Solution.java` 只保留题面给出的类、构造器和方法签名，以及可编译的 TODO 占位返回值；不提前写解法。`Main.java` 必须有 `public static void main(String[] args)`，将全部官方示例写为可执行断言，并按题型补充边界、空/极值、并列结果和典型结构等必要用例。所有题目测试都放在 `Main.main`，不得新增 JUnit/TestNG 测试类。

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
