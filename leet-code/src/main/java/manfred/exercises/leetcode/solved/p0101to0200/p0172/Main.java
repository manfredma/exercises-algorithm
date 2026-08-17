/*

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0172;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/factorial-trailing-zeroes/ */

/**
 * LeetCode 第 172 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1
        assertEquals(0, solution.trailingZeroes(3));
        // 题面示例 2
        assertEquals(1, solution.trailingZeroes(5));
        System.out.println("p0172 passed");
    }
}
