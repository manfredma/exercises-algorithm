package manfred.exercises.leetcode.solved.p0201to0300.p0240;

/**
 * 搜索二维矩阵 II —— 左下角起步搜索（O(m+n) 最优）。
 *
 * <p>思路：从左下角出发。左下角元素满足「往上变小、往右变大」——两个方向单调相反，
 * 每次比较能排除一行或一列：当前值偏大则上移 row--，偏小则右移 column++。
 * 与 {@link Solution3} 的右上角起步对称等价。
 *
 * <p>复杂度：时间 O(m+n)，空间 O(1)。
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            int current = matrix[row][column];
            if (current == target) {
                return true;
            }
            if (current > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }
}
