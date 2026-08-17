/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 [−2^31,  2^31 − 1].
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0007;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-integer/ */

/**
 * LeetCode 第 7 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 1534236469 反转后溢出 32 位有符号整数，按题意返回 0
        assertEquals(0, solution.reverse(1534236469));
        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(21, solution.reverse(120));
        System.out.println("p0007 passed");
    }
}
