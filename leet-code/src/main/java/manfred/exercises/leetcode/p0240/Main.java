package manfred.exercises.leetcode.p0240;

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

示例 1：
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
             [10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true

示例 2：
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
             [10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false

提示：
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
每行的所有元素从左到右升序排列。
每列的所有元素从上到下升序排列。
-10^9 <= target <= 10^9
*/
/** LeetCode 第 240 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertEquals(true, solution.searchMatrix(matrix, 5));
        assertEquals(false, solution.searchMatrix(matrix, 20));
        assertEquals(true, solution.searchMatrix(matrix, 1));
        assertEquals(true, solution.searchMatrix(matrix, 30));
        assertEquals(false, solution.searchMatrix(matrix, 0));
        assertEquals(false, solution.searchMatrix(matrix, 31));

        Solution2 solution2 = new Solution2();
        assertEquals(true, solution2.searchMatrix(matrix, 5));
        assertEquals(false, solution2.searchMatrix(matrix, 20));
        assertEquals(true, solution2.searchMatrix(matrix, 1));
        assertEquals(true, solution2.searchMatrix(matrix, 30));
        assertEquals(false, solution2.searchMatrix(matrix, 0));
        assertEquals(false, solution2.searchMatrix(matrix, 31));
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new AssertionError("期望：" + expected + "，实际：" + actual);
        }
        System.out.println("通过：" + expected);
    }
}
