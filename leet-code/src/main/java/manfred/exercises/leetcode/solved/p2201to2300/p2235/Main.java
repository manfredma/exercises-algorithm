package manfred.exercises.leetcode.solved.p2201to2300.p2235;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/add-two-integers/ */

/*
给你两个整数 num1 和 num2，返回这两个整数的和。
*/
/**
 * LeetCode 第 2235 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: num1 = 12, num2 = 5 → 期望 17
        assertEquals(17, solution.sum(12, 5));
        // 示例 2: num1 = -10, num2 = 4 → 期望 -6
        assertEquals(-6, solution.sum(-10, 4));
        System.out.println("passed");
    }
}
