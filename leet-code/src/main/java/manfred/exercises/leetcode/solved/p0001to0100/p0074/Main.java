/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0074;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/search-a-2d-matrix/ */

/**
 * LeetCode 第 74 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        int[][] x = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Solution solution = new Solution();
        // 题面示例 1：target=3 在矩阵中
        assertTrue(solution.searchMatrix(x, 3));
        // 题面示例 2：target=13 不在矩阵中
        assertFalse(solution.searchMatrix(x, 13));

        x = new int[][]{
                {1, 1}
        };
        // 手算：[1,1] 不含 2
        assertFalse(solution.searchMatrix(x, 2));

        x = new int[][]{
                {1, 3}
        };
        // 手算：含 1
        assertTrue(solution.searchMatrix(x, 1));
        // 手算：含 3
        assertTrue(solution.searchMatrix(x, 3));
        System.out.println("passed");
    }
}
