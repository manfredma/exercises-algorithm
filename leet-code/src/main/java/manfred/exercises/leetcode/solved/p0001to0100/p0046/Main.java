/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0046;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/permutations/ */

/**
 * LeetCode 第 46 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        // [1,2,3] 共 6 种全排列，题面示例，顺序不限
        List<List<Integer>> r = solution2.permute(new int[]{1, 2, 3});
        List<List<Integer>> e = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1));
        assertEquals(e.size(), r.size());
        assertTrue(r.containsAll(e));
        System.out.println("p0046 passed");
    }
}
