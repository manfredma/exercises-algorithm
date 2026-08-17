/*

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0201;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/bitwise-and-of-numbers-range/ */

/**
 * LeetCode 第 201 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1: [5,7] → 4
        assertEquals(4, solution.rangeBitwiseAnd(5, 7));
        // 手算: 5 & 6 = 4
        assertEquals(4, solution.rangeBitwiseAnd(5, 6));
        // 手算: 2 & 3 & 4 = 0
        assertEquals(0, solution.rangeBitwiseAnd(2, 4));
        // 题面示例 2: [0,1] → 0
        assertEquals(0, solution.rangeBitwiseAnd(0, 1));
        System.out.println("p0201 passed");
    }
}
