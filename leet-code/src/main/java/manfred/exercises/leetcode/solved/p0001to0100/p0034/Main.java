/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0034;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/ */

/**
 * LeetCode 第 34 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        findOnce(solution, 3, new int[]{-1, -1});
        findOnce(solution, 5, new int[]{0, 0});
        findOnce(solution, 6, new int[]{-1, -1});
        findOnce(solution, 7, new int[]{1, 2});
        findOnce(solution, 8, new int[]{3, 4});
        findOnce(solution, 10, new int[]{5, 5});
        findOnce(solution, 12, new int[]{-1, -1});
        System.out.println("p0034 passed");
    }

    private static void findOnce(Solution solution, int target, int[] expected) {
        int[] r = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, target);
        assertArrayEquals(expected, r);
    }

}
