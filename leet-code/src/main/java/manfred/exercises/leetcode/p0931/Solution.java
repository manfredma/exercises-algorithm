package manfred.exercises.leetcode.p0931;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] fallingPathSum = new int[n][n];
        // 初始化数据，其中最后一行的值就是矩阵的最后一行的值。
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(fallingPathSum[i], Integer.MAX_VALUE);
        }
        System.arraycopy(matrix[n - 1], 0, fallingPathSum[n - 1], 0, n);

        int[] colOffsets = new int[] { -1, 0, 1};
        // 从倒数第二行开始计算，直到第一行。
        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                int best = Integer.MAX_VALUE;
                for (int j : colOffsets) {
                    int nc = c + j;
                    if (nc >= 0 && nc < n) {
                        best = Math.min(best, fallingPathSum[r + 1][nc]);
                    }
                }
                fallingPathSum[r][c] = best + matrix[r][c];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, fallingPathSum[0][i]);
        }
        return result;
    }
}
