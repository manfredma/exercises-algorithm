/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0041;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/first-missing-positive/ */

/**
 * LeetCode 第 41 题「缺失的第一个正数」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        assertEquals(3, s.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, s.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, s.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println("p0041 passed");
    }
}
