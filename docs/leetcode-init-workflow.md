# LeetCode 初始化新题流程

适用：从题号开始一道**全新题目**（题库中尚未做过）。把空骨架与完整题面搭好，用户在骨架上写第一版实现。重刷已解决题见 [`leetcode-refresh-workflow.md`](leetcode-refresh-workflow.md)，完成收尾见 [`leetcode-finish-workflow.md`](leetcode-finish-workflow.md)。`AGENTS.md` 约束优先，题面规范见 [`leetcode-content-spec.md`](leetcode-content-spec.md)。

## 流程

1. **抓取题面** — `python3 scripts/fetch-leetcode-problem.py <题号>`（见 content-spec「抓取题面」），取得完整 JSON。
2. **建目录** — 固定 `leet-code/src/main/java/manfred/exercises/leetcode/wip/pXXXX/`，包名 `manfred.exercises.leetcode.wip.pXXXX`。无需改 `pom.xml`。目录包含 `readme.md`、`Solution.java`、`Main.java`。
3. **写 `Solution.java`** — 只保留题面给出的类、构造器和方法签名，以及可编译的 TODO 占位返回值；**不提前写解法**。占位返回值按返回类型选择：`int`/`long` → `0`，`boolean` → `false`，`String` → `""`，数组/对象 → `null`。签名以 JSON 的 `returnType` / `methodName` / `params` 为准。
4. **写 `readme.md`** — 按 content-spec「README 与题面注释规范」「图片规范」生成；图片下载到 `wip/pXXXX/images/`。readme 结构（标题/示例/提示排版）参照 [`leetcode-template-conventions.md`](leetcode-template-conventions.md) 与模板题 p3069 / p3096 / p0257。
5. **写 `Main.java`** — 必须有 `public static void main(String[] args)`，将全部官方示例写为可执行断言，并按题型补充边界、空/极值、并列结果和典型结构等必要用例。`main` 最后一句打印 `leet#XXXX passed`（`XXXX` 为 4 位题号，如第 1 题打印 `leet#0001 passed`）。所有测试放在 `Main.main`，**不得新增 JUnit/TestNG 测试类**，不得在 `src/main/java` 用 `@Test`。Main Javadoc 与用例写法参照 [`leetcode-template-conventions.md`](leetcode-template-conventions.md) 与模板题 p3069 / p3096 / p0257。

## Java 8 约束

`Solution.java` 与 `Main.java` 禁止使用 Java 9+ API（`List.of()` → `Arrays.asList()`、禁 `var`、禁 `String.isBlank()` 等），详见 `AGENTS.md` 的「Java 8 约束」段。

## 产出

wip 下可编译的空骨架 + 完整题面 + 完整测试用例，待用户写实现。实现完成后走 [`leetcode-finish-workflow.md`](leetcode-finish-workflow.md) 归档提交。
