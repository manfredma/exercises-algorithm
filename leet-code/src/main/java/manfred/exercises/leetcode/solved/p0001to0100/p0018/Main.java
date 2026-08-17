/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0018;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/4sum/ */

/**
 * LeetCode 第 18 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：四元组顺序不限
        List<List<Integer>> r1 = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        List<List<Integer>> e1 = Arrays.asList(
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1));
        assertEquals(e1.size(), r1.size());
        assertTrue(r1.containsAll(e1));

        // 手算：[-1,0,-5,-2,-2,-4,0,1,-2] target=-9 的全部四元组（求和均为 -9）
        List<List<Integer>> r2 = solution.fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9);
        List<List<Integer>> e2 = Arrays.asList(
                Arrays.asList(-5, -4, -1, 1),
                Arrays.asList(-5, -4, 0, 0),
                Arrays.asList(-5, -2, -2, 0),
                Arrays.asList(-4, -2, -2, -1));
        assertEquals(e2.size(), r2.size());
        assertTrue(r2.containsAll(e2));
        System.out.println("p0018 passed");
    }
}
