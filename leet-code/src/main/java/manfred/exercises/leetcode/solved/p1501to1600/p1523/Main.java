package manfred.exercises.leetcode.solved.p1501to1600.p1523;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/ */

/*
给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。

示例 1：

输入：low = 3, high = 7
输出：3
解释：3 到 7 之间奇数数字为 [3,5,7] 。

示例 2：

输入：low = 8, high = 10
输出：1
解释：8 到 10 之间奇数数字为 [9] 。

提示：

0 <= low <= high <= 10^9
*/
/**
 * LeetCode 第 1523 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 low = 3, high = 7 → 期望 3
        assertEquals(3, solution.countOdds(3, 7));
        // 示例 2: 输入 low = 8, high = 10 → 期望 1
        assertEquals(1, solution.countOdds(8, 10));
        System.out.println("passed");
    }
}
