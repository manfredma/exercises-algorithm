package exe01._08.zero.matrix.lcci;

/**
 * CTCI 面试题 01.08「零矩阵」：首行首列作标记，两遍扫描置零。
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean[] rowMask = new boolean[matrix.length];
        boolean[] columnMask = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowMask[i] = true;
                    columnMask[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowMask[i] || columnMask[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}