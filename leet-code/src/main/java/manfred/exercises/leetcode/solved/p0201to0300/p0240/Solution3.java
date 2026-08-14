package manfred.exercises.leetcode.solved.p0201to0300.p0240;

/**
 * 搜索二维矩阵 II —— 右上角起步搜索（O(m+n) 最优）。
 *
 * <p>思路：从右上角出发。矩阵每行左→右升序、每列上→下升序，右上角元素恰好满足
 * 「往左变小、往下变大」——两个方向单调相反，每次比较能确定排除一行或一列：
 * <ul>
 *   <li>当前值 == target：命中；</li>
 *   <li>当前值 > target：该列下方更大（列升序），整列排除，左移 column--；</li>
 *   <li>当前值 < target：该行左边更小（行升序），整行排除，下移 row++。</li>
 * </ul>
 *
 * <p>关键：必须从右上角或左下角起步——这两个角的两个方向单调相反。
 * 左上角（往右、往下都变大）与右下角（往左、往上都变小）两个方向同向，无法决定走哪边。
 *
 * <p>复杂度：时间 O(m+n)，每次排除一行或一列，最多 m+n 步；空间 O(1)。
 */
class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        // 边界并入循环条件：行不越界且列不越界
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                // 当前值偏大，整列排除（列下方更大），左移
                column--;
            } else {
                // 当前值偏小，整行排除（行左边更小），下移
                row++;
            }
        }
        return false;
    }
}
