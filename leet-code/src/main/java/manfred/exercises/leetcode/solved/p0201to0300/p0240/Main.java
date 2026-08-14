package manfred.exercises.leetcode.solved.p0201to0300.p0240;

/** 题目链接：https://leetcode.cn/problems/search-a-2d-matrix-ii/ */

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
每行从左到右升序，每列从上到下升序。

示例 1：

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],...], target = 5
输出：true

示例 2：

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],...], target = 20
输出：false
*/
/**
 * LeetCode 第 240 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        // 示例 1: target = 5 → 期望 true
        assertEquals(true, solution.searchMatrix(matrix, 5));
        assertEquals(true, solution2.searchMatrix(matrix, 5));
        assertEquals(true, solution3.searchMatrix(matrix, 5));
        // 示例 2: target = 20 → 期望 false
        assertEquals(false, solution.searchMatrix(matrix, 20));
        assertEquals(false, solution2.searchMatrix(matrix, 20));
        assertEquals(false, solution3.searchMatrix(matrix, 20));
        // 边界: target 为左上角最小值 → 期望 true
        assertEquals(true, solution.searchMatrix(matrix, 1));
        assertEquals(true, solution2.searchMatrix(matrix, 1));
        assertEquals(true, solution3.searchMatrix(matrix, 1));
        // 边界: target 为右下角最大值 → 期望 true
        assertEquals(true, solution.searchMatrix(matrix, 30));
        assertEquals(true, solution2.searchMatrix(matrix, 30));
        assertEquals(true, solution3.searchMatrix(matrix, 30));
        // 边界: 1x1 矩阵命中 → 期望 true
        assertEquals(true, solution.searchMatrix(new int[][]{{5}}, 5));
        assertEquals(true, solution2.searchMatrix(new int[][]{{5}}, 5));
        assertEquals(true, solution3.searchMatrix(new int[][]{{5}}, 5));
        // 边界: 1x1 矩阵未命中 → 期望 false
        assertEquals(false, solution.searchMatrix(new int[][]{{5}}, 6));
        assertEquals(false, solution2.searchMatrix(new int[][]{{5}}, 6));
        assertEquals(false, solution3.searchMatrix(new int[][]{{5}}, 6));
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
