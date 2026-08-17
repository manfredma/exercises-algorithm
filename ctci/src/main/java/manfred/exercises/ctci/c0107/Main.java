package manfred.exercises.ctci.c0107;

import java.util.Arrays;

import static manfred.exercises.assertion.Assert.*;

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

        // 示例输入说明
        System.out.println("before rotate:");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        solution.rotate(matrix);

        // 题面示例：顺时针 90 度后结果
        assertArrayEquals(new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        }, matrix);
        System.out.println("passed");
    }
}
