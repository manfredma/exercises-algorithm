package manfred.exercises.leetcode.solved.p0201to0300.p0279;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/perfect-squares/ */

/*
给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

示例 1：
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4

示例 2：
输入：n = 13
输出：2
解释：13 = 4 + 9

提示：
1 <= n <= 10^4
*/
/**
 * LeetCode 第 279 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertEquals(3, solution.numSquares(12));
        assertEquals(2, solution.numSquares(13));
        assertEquals(3, solution2.numSquares(12));
        assertEquals(2, solution2.numSquares(13));
    }

}
