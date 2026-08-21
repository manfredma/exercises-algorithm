# LeetCode 完成收尾与提交流程

适用：解法实现完成，要归档到 `solved` 并提交。`AGENTS.md` 约束优先，题面规范见 [`leetcode-content-spec.md`](leetcode-content-spec.md)。

## 完成一题的收尾 SOP（Claude Code 与 Codex 共同遵循）

每道 LeetCode 题目解法实现后、提交前，**必须按顺序**走完以下清单，缺一不可：

1. **补注释**：本题所有 `Solution*.java` 加类级 Javadoc，说明思路、关键点与复杂度；多解法间体现演进关系。
2. **补用例**：`Main.java` 含官方全部示例 + 适用边界用例（单元素/空/极值/并列/特殊结构），assert 断言风格；用例须覆盖能暴露常见 bug 的场景（如多位数、负数、溢出、非法并列等，依题而定）。
3. **编译验证**：`mvn -f pom.xml clean compile -pl leet-code -DskipTests -Dsort.skip=true` 通过。
4. **运行验证**：`java -cp leet-code/target/classes manfred.exercises.leetcode.wip.pXXXX.Main` 无 AssertionError 退出（退出码 0），末尾输出 `leet#XXXX passed`。多解法时全部测通。
5. **归档**：先跑 `python3 scripts/leetcode-segment.py <题号> --mv` 核验题号所在的百题段目录、package 声明，并确认 wip 已就绪、solved 目标不冲突（**禁止口算段目录**，曾因凭目录惯性错放 3105 到 `p3001to3100`）；再按脚本输出的命令把 `wip/pXXXX/` 整目录迁移到 `solved/pXXXXtoYYYY/pZZZZ/`，同步更新所有 `.java` 的 package 声明。
6. **归档后重新编译运行**：用归档后的包路径再跑一次 Main，确认 package 变更无误。
7. **更新进度**（若该题在 `HOT100_REVIEW.md` 表中）：对应行改为 `✅ 日期 重刷完成（说明，已归档）`。
8. **暂存、提交、推送**：只暂存本题 + 进度文件；commit 消息 `feat(leetcode): solve problem XXXX with <简述>`；推送到 `origin/main`。

> Claude Code 可用 `/finish-leetcode <题号>` 命令执行步骤 3–8 的机械部分；步骤 1–2（注释、用例）需人工判断，不在命令内自动完成。Codex 读取本清单与 `AGENTS.md`，按步骤手动执行。

**未完成（Solution 仍空骨架、Main 有失败用例）的题目不得归档**，留在 `wip` 并说明原因。

## 归档路径

迁移整个目录到 `leet-code/src/main/java/manfred/exercises/leetcode/solved/pXXXXtoYYYY/pZZZZ/`，其中范围是题号所在连续百题段；例如 328 归档到 `solved/p0301to0400/p0328/`，3105 归档到 `solved/p3101to3200/p3105/`。同步更新该题的 package 声明与所有跨题 import。

> **段目录必须用 `scripts/leetcode-segment.py` 计算，不得口算。** 题号到百题段的换算（如 3105 → `p3101to3200`，而非 `p3001to3100`）容易因凭相邻题的目录惯性出错。归档前执行 `python3 scripts/leetcode-segment.py <题号> --mv`，脚本会输出段目录名、package 声明、迁移命令，并校验 wip 就绪与 solved 冲突。

## 提交

用户要求提交某题时，若该题已完成，先归档再暂存、提交和推送；未完成的题目留在 `wip`，并在提交前说明原因。
