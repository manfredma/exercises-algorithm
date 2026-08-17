/*

Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0064;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/minimum-path-sum/ */

/**
 * LeetCode 第 64 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        int[][] x = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Solution solution = new Solution();
        // 题面示例：最小路径和为 7（路径 1→3→1→1→1）
        assertEquals(7, solution.minPathSum(x));
        System.out.println("passed");
    }
}
