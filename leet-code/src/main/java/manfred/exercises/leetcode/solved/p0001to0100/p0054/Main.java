/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0054;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/spiral-matrix/ */

/**
 * LeetCode 第 54 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 手算：2x1 列矩阵 -> [3,2]
        assertEquals(Arrays.asList(3, 2), solution.spiralOrder(new int[][]{
                {3},
                {2}
        }));
        // 手算：单行 -> [6,9,7]
        assertEquals(Arrays.asList(6, 9, 7), solution.spiralOrder(new int[][]{
                {6, 9, 7}
        }));
        // 手算：2x2 -> [0,1,3,2]
        assertEquals(Arrays.asList(0, 1, 3, 2), solution.spiralOrder(new int[][]{
                {0, 1},
                {2, 3}
        }));
        // 题面示例 2：3x4 -> [1,2,3,4,8,12,11,10,9,5,6,7]
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
        // 题面示例 1：3x3 -> [1,2,3,6,9,8,7,4,5]
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
        System.out.println("passed");
    }
}
