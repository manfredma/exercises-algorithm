/*

Given two integers representing the numerator and denominator of a fraction,
return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0166;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/fraction-to-recurring-decimal/ */

/**
 * LeetCode 第 166 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // -1 / -2147483648 = 1/2^31 的精确小数（运行输出，需复核）
        assertEquals("0.0000000004656612873077392578125", solution.fractionToDecimal(-1, -2147483648));
        // 7 / -12 = -0.58333...，循环 3（运行输出，需复核）
        assertEquals("-0.58(3)", solution.fractionToDecimal(7, -12));
        // -50 / 8 = -6.25（手算）
        assertEquals("-6.25", solution.fractionToDecimal(-50, 8));
        // 1 / 6 = 0.1666...，循环 6（运行输出，需复核）
        assertEquals("0.1(6)", solution.fractionToDecimal(1, 6));
        // 题面示例 3
        assertEquals("0.(6)", solution.fractionToDecimal(2, 3));
        // 题面示例 1
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
        // 题面示例 2
        assertEquals("2", solution.fractionToDecimal(2, 1));
        System.out.println("p0166 passed");
    }
}
