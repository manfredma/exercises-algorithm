package manfred.exercises.leetcode.solved.p0201to0300.p0240;

/** 从左下角开始，每次排除整行或整列。 */
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
