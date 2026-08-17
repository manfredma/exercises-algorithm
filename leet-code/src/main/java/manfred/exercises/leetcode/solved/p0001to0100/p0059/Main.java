/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0059;

import static manfred.exercises.assertion.Assert.assertArrayEquals;

/** 题目链接：https://leetcode.cn/problems/spiral-matrix-ii/ */

/**
 * LeetCode 第 59 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 题面示例：n=3 生成螺旋矩阵 [[1,2,3],[8,9,4],[7,6,5]]
        assertArrayEquals(new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        }, new Solution().generateMatrix(3));
        System.out.println("passed");
    }
}
