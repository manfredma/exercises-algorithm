package manfred.exercises.ctci.c0108;

import java.util.Arrays;

/**
 * CTCI 面试题 01.08「零矩阵」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(input);
        System.out.println("++++++++++");
        for (int[] ints : input) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
