package manfred.exercises.leetcode.solved.p0701to0800.p0790;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/domino-and-tromino-tiling/ */

/*
有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。

示例 1:
输入: n = 3
输出: 5

示例 2:
输入: n = 1
输出: 1
*/
/**
 * LeetCode 第 790 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 n = 3 → 期望 5
        assertEquals(5, solution.numTilings(3));
        // 示例 2: 输入 n = 1 → 期望 1
        assertEquals(1, solution.numTilings(1));
        // 示例 3: 输入 n = 4 → 期望 11
        assertEquals(11, solution.numTilings(4));

        // 回归：两解法在 n=1000 须一致且等于 979232805
        int n = 1000;
        int a = solution.numTilings(n);
        int b = new Solution2().numTilings(n);
        assertEquals(979232805L, a);
        assertEquals(979232805L, b);
        System.out.println("n=" + n + " Solution=" + a + " Solution2=" + b + " OK");

        System.out.println("p0790 passed");
    }
}
