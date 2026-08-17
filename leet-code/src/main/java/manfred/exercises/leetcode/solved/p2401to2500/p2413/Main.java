package manfred.exercises.leetcode.solved.p2401to2500.p2413;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/smallest-even-multiple/ */

/*
给你一个正整数 n，返回 2 和 n 的最小公倍数(正整数)。
*/
/**
 * LeetCode 第 2413 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 5 → 期望 10
        assertEquals(10, solution.smallestEvenMultiple(5));
        // 示例 2: n = 6 → 期望 6
        assertEquals(6, solution.smallestEvenMultiple(6));
        System.out.println("passed");
    }
}
