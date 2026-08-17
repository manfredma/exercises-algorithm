/*

Given a non-empty array of integers, every element appears twice except for one.
Find that single one.

Note:

Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0136;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/single-number/ */

/**
 * LeetCode 第 136 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, solution.singleNumber(new int[]{4, 1, 2, 1, 2}));

        System.out.println("p0136 passed");
    }
}
