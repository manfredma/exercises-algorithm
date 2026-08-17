/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0070;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/climbing-stairs/ */

/**
 * LeetCode 第 70 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1：n=2 有 2 种爬法
        assertEquals(2, solution.climbStairs(2));
        // 题面示例 2：n=3 有 3 种爬法
        assertEquals(3, solution.climbStairs(3));
        // 手算：n=4 有 5 种爬法（斐波那契数列 1,2,3,5）
        assertEquals(5, solution.climbStairs(4));
        System.out.println("passed");
    }
}
