/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0039;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/combination-sum/ */

/**
 * LeetCode 第 39 题「组合总和」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1：组合顺序不限
        List<List<Integer>> r1 = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> e1 = Arrays.asList(
                Arrays.asList(7),
                Arrays.asList(2, 2, 3));
        assertEquals(e1.size(), r1.size());
        assertTrue(r1.containsAll(e1));

        // 题面示例 2
        List<List<Integer>> r2 = solution.combinationSum(new int[]{2, 3, 5}, 8);
        List<List<Integer>> e2 = Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5));
        assertEquals(e2.size(), r2.size());
        assertTrue(r2.containsAll(e2));
        System.out.println("p0039 passed");
    }
}
