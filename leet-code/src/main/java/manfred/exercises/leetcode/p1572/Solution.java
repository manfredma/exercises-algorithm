package manfred.exercises.leetcode.p1572;

class Solution {
    public int diagonalSum(int[][] mat) {
        int result = 0;
        int length = mat.length;
        for (int i = 0; i < length; i++) {
            result += mat[i][i];
            result += mat[i][length - 1 - i];
        }
        return result - (length % 2 == 0 ? 0 : mat[length / 2][length / 2]);
    }
}
