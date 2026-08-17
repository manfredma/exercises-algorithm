# LeetCode 重刷已解决题流程

适用：已归档到 `solved` 的题，要**重新实现一版**（更优解法 / 标准模板）。与初始化新题（[`leetcode-init-workflow.md`](leetcode-init-workflow.md)）的区别：题目已存在，拉回 wip 重做，而非从零开始。`AGENTS.md` 约束优先，题面规范见 [`leetcode-content-spec.md`](leetcode-content-spec.md)，收尾见 [`leetcode-finish-workflow.md`](leetcode-finish-workflow.md)。

## 交付承诺

流程跑完，wip 下有完整题面 + 新空骨架 + 完整测试用例，**用户只需在新骨架上写实现**。

## 流程

1. **拉回 wip** — 目录 `solved/pXXXXtoYYYY/pZZZZ/` → `wip/pXXXX/`；package 从 `manfred.exercises.leetcode.solved.pXXXXtoYYYY.pZZZZ` 改回 `manfred.exercises.leetcode.wip.pXXXX`；同步所有 `.java` 的 package 声明与跨题 import。
2. **重新抓题面** — `python3 scripts/fetch-leetcode-problem.py <题号>`（见 content-spec「抓取题面」），用新 JSON 重写 `readme.md`（见 content-spec「README 与题面注释规范」）；图片变化则重下到 `wip/pXXXX/images/` 并按原位置引用（见 content-spec「图片规范」）。
3. **建新骨架** — 新建 `SolutionN.java`（N = 下一版本号，沿用现有命名：如已有 `Solution` / `Solution2` 则建 `Solution3`，或按既有 `SolutionV2` 风格延续），仅题面签名 + 可编译 TODO 占位（规则见 [`leetcode-init-workflow.md`](leetcode-init-workflow.md)），**不写解法**。
4. **测试用例（保留旧解法验证 + 新增新解法验证，严禁替换）** — `Main.java` **必须保留**对所有已有解法（`Solution`、`Solution2`…）的测试块，**新增**对新 `SolutionN` 的测试块。新旧解法测试并存：
   - 旧解法测试保留原样，验证旧解法**不被破坏**（应通过）。
   - 新解法测试覆盖官方示例 + 边界/极值/并列/特殊结构，在骨架占位下 RED，待实现后通过。
   - `main` 末尾打印 `leet#XXXX passed`（所有解法全部通过后才打印）。

   > ⚠️ **严禁**把 `Main` 改成只测新解法而删除旧解法的测试。重刷是为了叠加新解法验证，不是替换；旧解法测试必须保留，确保旧解法不被后续改动破坏。历史上若存在「删旧只测新」的错误 Main，必须修正为「旧保留 + 新增新」。
5. **交付** — wip 可编译、新骨架 TODO 占位可过、`Main` 保留旧解法（通过）+ 新增新解法（RED，待实现后通过）。

## 完成

用户在新骨架写完实现后，走 [`leetcode-finish-workflow.md`](leetcode-finish-workflow.md) 归档提交（含 package 改回 `solved`）。

## 与「只刷新题面」的区别

若仅因 `readme.md` 格式有问题或题面需更新，**不重刷解法**，则不走本流程，而是原地重抓 `readme.md`：仅跑 fetch 重写 `readme.md`（+按需重下图片），不动位置、package、`Solution.java`、`Main.java`。规范见 [`leetcode-content-spec.md`](leetcode-content-spec.md)。
