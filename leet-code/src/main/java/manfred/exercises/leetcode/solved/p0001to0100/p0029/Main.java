/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume that we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0029;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/divide-two-integers/ */

/**
 * LeetCode 第 29 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // -2147483648 / -3 = 715827882（向零截断，未溢出）
        assertEquals(715827882, solution.divide(-2147483648, -3));
        // -2147483648 / 2 = -1073741824
        assertEquals(-1073741824, solution.divide(-2147483648, 2));
        assertEquals(3, solution.divide(10, 3));
        assertEquals(-2, solution.divide(7, -3));
        System.out.println("p0029 passed");
    }
}
