/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0085;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/maximal-rectangle/ */

/**
 * LeetCode 第 85 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        char[][] x = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        Solution solution = new Solution();
        // 题面示例：最大全 1 矩形面积为 6
        assertEquals(6, solution.maximalRectangle(x));
        System.out.println("passed");
    }
}
