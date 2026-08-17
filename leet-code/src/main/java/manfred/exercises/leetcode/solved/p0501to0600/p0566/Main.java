/*
In MATLAB, there is a very useful function called 'reshape',
which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array,
and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.
 */
package manfred.exercises.leetcode.solved.p0501to0600.p0566;

import static manfred.exercises.assertion.Assert.assertArrayEquals;

/** 题目链接：https://leetcode.cn/problems/reshape-the-matrix/ */

/**
 * LeetCode 第 566 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1 变体: nums = [[1,2,3,4]], r = 2, c = 2 → 期望 [[1,2],[3,4]]
        int[][] r = solution.matrixReshape(new int[][]{{1, 2, 3, 4}}, 2, 2);
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, r);

        // 示例 2: nums = [[1,2],[3,4]], r = 1, c = 4 → 期望 [[1,2,3,4]]
        r = solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        assertArrayEquals(new int[][]{{1, 2, 3, 4}}, r);

        // 示例 2 变体: nums = [[1,2],[3,4]], r = 2, c = 4 → 期望 原矩阵 [[1,2],[3,4]]
        r = solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4);
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, r);

        System.out.println("p0566 passed");
    }
}
