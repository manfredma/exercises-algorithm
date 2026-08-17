package manfred.exercises.ctci.c0108;

import static manfred.exercises.assertion.Assert.*;

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
        // 题面示例：含 0 的行列置零
        assertArrayEquals(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }, input);
        System.out.println("passed");
    }
}
