package manfred.exercises.leetcode.solved.p0301to0400.p0322;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/coin-change/ */

/*
给你一个整数数组 coins，表示不同面额的硬币；以及一个整数 amount，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3

示例 2：

输入：coins = [2], amount = 3
输出：-1

示例 3：

输入：coins = [1], amount = 0
输出：0

提示：

1 <= coins.length <= 12

1 <= coins[i] <= 2^31 - 1

0 <= amount <= 10^4
*/
/**
 * LeetCode 第 322 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: coins=[1,2,5], amount=11 → 期望 3
        assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(3, solution2.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(3, solution3.coinChange(new int[]{1, 2, 5}, 11));
        // 示例 2: coins=[2], amount=3 → 期望 -1
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
        assertEquals(-1, solution2.coinChange(new int[]{2}, 3));
        assertEquals(-1, solution3.coinChange(new int[]{2}, 3));
        // 示例 3: coins=[1], amount=0 → 期望 0
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
        assertEquals(0, solution2.coinChange(new int[]{1}, 0));
        assertEquals(0, solution3.coinChange(new int[]{1}, 0));
        // 边界: amount 恰等于某硬币 → 期望 1
        assertEquals(1, solution.coinChange(new int[]{1, 2, 5}, 5));
        assertEquals(1, solution2.coinChange(new int[]{1, 2, 5}, 5));
        assertEquals(1, solution3.coinChange(new int[]{1, 2, 5}, 5));
        // 边界: 大金额贪心失效，需 DP → 期望 20
        assertEquals(20, solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
        assertEquals(20, solution2.coinChange(new int[]{186, 419, 83, 408}, 6249));
        assertEquals(20, solution3.coinChange(new int[]{186, 419, 83, 408}, 6249));
        // 边界: amount 小于最小硬币 → 期望 -1（旧 Solution2 在此越界，现修复）
        assertEquals(-1, solution.coinChange(new int[]{5}, 3));
        assertEquals(-1, solution2.coinChange(new int[]{5}, 3));
        assertEquals(-1, solution3.coinChange(new int[]{5}, 3));
        // 边界: 贪心反例 coins=[1,3,4], amount=6 → 期望 2（贪心 4+1+1=3 非最优，最优 3+3=2）
        assertEquals(2, solution.coinChange(new int[]{1, 3, 4}, 6));
        assertEquals(2, solution2.coinChange(new int[]{1, 3, 4}, 6));
        assertEquals(2, solution3.coinChange(new int[]{1, 3, 4}, 6));
        // 边界: 多面额组合 → 期望 4（5+5+2+2）
        assertEquals(4, solution.coinChange(new int[]{2, 5}, 14));
        assertEquals(4, solution2.coinChange(new int[]{2, 5}, 14));
        assertEquals(4, solution3.coinChange(new int[]{2, 5}, 14));
        // 边界: amount=0 且 coins 非 1 → 期望 0
        assertEquals(0, solution.coinChange(new int[]{2}, 0));
        assertEquals(0, solution2.coinChange(new int[]{2}, 0));
        assertEquals(0, solution3.coinChange(new int[]{2}, 0));
    }

}
