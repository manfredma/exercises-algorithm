/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
package manfred.exercises.leetcode.solved.p0201to0300.p0217;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/contains-duplicate/ */

/**
 * LeetCode 第 217 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: [1,2,3,1] → true
        assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
        // 示例 2: [1,2,3,4] → false
        assertFalse(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
        // 示例 3: [1,1,1,3,3,4,3,2,4,2] → true
        assertTrue(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println("p0217 passed");
    }
}
