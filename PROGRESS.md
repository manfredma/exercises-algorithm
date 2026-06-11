# 解题进度追踪

> 记录待优化的解法 + 新初始化待解的题目，按优先级排序。
>
> 状态说明：`⬜ 待处理` · `🔄 进行中` · `✅ 已完成`

---

## 一、待优化解法

> 已有解法但存在明显问题，需要重写或补充 `Solution2.java`。

### 🔴 高优先级（可能 TLE / 正确性风险）

| 状态 | 题号 | 题目 | 问题描述 | 优化方向 |
|------|------|------|----------|----------|
| ⬜ | [p0087](leet-code/src/main/java/manfred/exercises/leetcode/p0087/) | 扰乱字符串 | 纯递归无记忆化，指数级复杂度，大概率 TLE | 加 `HashMap` 记忆化，或改 3D DP `dp[i][j][len]` |
| ⬜ | [p0322](leet-code/src/main/java/manfred/exercises/leetcode/p0322/) | 零钱兑换 | 递归贪心+回溯，最坏指数级 | 经典背包 DP：`dp[i] = min(dp[i], dp[i-coin]+1)`，O(amount×n) |

### 🟠 中优先级（过度工程 / 算法选择不当）

| 状态 | 题号 | 题目 | 问题描述 | 优化方向 |
|------|------|------|----------|----------|
| ⬜ | [p0224](leet-code/src/main/java/manfred/exercises/leetcode/p0224/) | 基本计算器 | 200 行：词法分析器 + 调度场算法 + AST | 栈解法 ~20 行：遇 `(` 压栈，遇 `)` 弹栈还原 |
| ⬜ | [p0044](leet-code/src/main/java/manfred/exercises/leetcode/p0044/) | 通配符匹配 | NFA 状态机，大量对象分配 | 2D DP：`dp[i][j]` ~15 行 |
| ⬜ | [p0040](leet-code/src/main/java/manfred/exercises/leetcode/p0040/) | 组合总和 II | 先枚举全部结果再用 `toString()` 去重，O(n²) 开销 | 回溯时跳过重复：`if (i > index && candidates[i] == candidates[i-1]) continue` |

### 🟡 低优先级（正确但有优化空间）

| 状态 | 题号 | 题目 | 问题描述 | 优化方向 |
|------|------|------|----------|----------|
| ⬜ | [p0169](leet-code/src/main/java/manfred/exercises/leetcode/p0169/) | 多数元素 | 注释写 Boyer-Moore，实现却是 `Arrays.sort` 取中位数 | 实现真正的 Boyer-Moore：O(n) 时间 O(1) 空间 |
| ⬜ | [p0218](leet-code/src/main/java/manfred/exercises/leetcode/p0218/) | 天际线问题 | O(n²)：每个关键点遍历所有建筑物 | 扫描线 + `TreeMap` 维护活跃高度，O(n log n) |
| ⬜ | [p0076](leet-code/src/main/java/manfred/exercises/leetcode/p0076/) | 最小覆盖子串 | 80 行复杂自制数据结构 | 标准滑动窗口 + `int[128]` 计数，~20 行 |
| ⬜ | [p0300](leet-code/src/main/java/manfred/exercises/leetcode/p0300/) | 最长递增子序列 | O(n²) DP（注释提到了 O(n log n) 但未实现） | 补 `Solution2`：耐心排序 + 二分，O(n log n) |
| ✅ | [p0438](leet-code/src/main/java/manfred/exercises/leetcode/p0438/) | 找到字符串中所有字母异位词 | `Arrays.sort` 排序子串，O(n·m·log m) | 已补 `Solution2` 滑动窗口 O(n) |

---

## 二、新初始化待解题目

> 已有骨架（`Solution.java` 为空），等待实现。

| 状态 | 题号 | 题目 | 难度 | 备注 |
|------|------|------|------|------|
| ✅ | [p0238](leet-code/src/main/java/manfred/exercises/leetcode/p0238/) | 除了自身以外数组的乘积 | Medium | 不能用除法，O(n)；进阶 O(1) 额外空间 |
| ⬜ | [p0363](leet-code/src/main/java/manfred/exercises/leetcode/p0363/) | 矩形区域不超过 K 的最大数值和 | Hard | DP 扫描线题；枚举上下边界→一维前缀和→TreeSet.ceiling() |
| ✅ | [p0560](leet-code/src/main/java/manfred/exercises/leetcode/p0560/) | 和为 K 的子数组 | Medium | 统计和为 k 的连续子数组个数 |

---

## 更新记录

| 日期 | 事项 |
|------|------|
| 2026-06-11 | 批量扫描全部 239 题，补全所有中文 README；识别 9 个待优化题目 |
| 2026-06-11 | 初始化 p0438 并补充 Solution2（滑动窗口）✅ |
| 2026-06-11 | 初始化 p0560、p0238 骨架 |
