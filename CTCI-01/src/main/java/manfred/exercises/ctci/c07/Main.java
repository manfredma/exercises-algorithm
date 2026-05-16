package manfred.exercises.ctci.c07;

import java.util.Arrays;

/**
 * CTCI 面试题 01.07「旋转矩阵」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16},
        };

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        solution.rotate(matrix);

        System.out.println("++++++++++");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
