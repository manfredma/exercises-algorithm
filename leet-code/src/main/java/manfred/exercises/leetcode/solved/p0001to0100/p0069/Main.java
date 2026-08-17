/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0069;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/sqrtx/ */

/**
 * LeetCode 第 69 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 101 的整数平方根为 10（10^2=100 <= 101, 11^2=121 > 101）
        assertEquals(10, solution.mySqrt(101));
        // 100 的整数平方根为 10
        assertEquals(10, solution.mySqrt(100));
        // 题面示例 1：sqrt(4) = 2
        assertEquals(2, solution.mySqrt(4));
        // 题面示例 2：sqrt(8) 截断小数部分为 2
        assertEquals(2, solution.mySqrt(8));
        System.out.println("passed");
    }
}
