/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0040;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/combination-sum-ii/ */

/**
 * LeetCode 第 40 题「组合总和 II」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 2：[2,5,2,1,2] target=5，组合顺序不限
        List<List<Integer>> r1 = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        List<List<Integer>> e1 = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(5));
        assertEquals(e1.size(), r1.size());
        assertTrue(r1.containsAll(e1));

        // 题面示例 1：[10,1,2,7,6,1,5] target=8
        List<List<Integer>> r2 = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> e2 = Arrays.asList(
                Arrays.asList(1, 7),
                Arrays.asList(1, 2, 5),
                Arrays.asList(2, 6),
                Arrays.asList(1, 1, 6));
        assertEquals(e2.size(), r2.size());
        assertTrue(r2.containsAll(e2));
        System.out.println("p0040 passed");
    }
}
