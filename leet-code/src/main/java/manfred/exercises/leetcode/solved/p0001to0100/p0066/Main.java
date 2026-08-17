/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list,
and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0066;

import static manfred.exercises.assertion.Assert.assertArrayEquals;

/** 题目链接：https://leetcode.cn/problems/plus-one/ */

/**
 * LeetCode 第 66 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 题面示例 1：[1,2,3] +1 = [1,2,4]
        assertArrayEquals(new int[]{1, 2, 4}, solution.plusOne(new int[]{1, 2, 3}));
        // 题面示例 2：[4,3,2,1] +1 = [4,3,2,2]
        assertArrayEquals(new int[]{4, 3, 2, 2}, solution.plusOne(new int[]{4, 3, 2, 1}));
        System.out.println("passed");
    }
}
