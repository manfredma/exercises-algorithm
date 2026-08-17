package manfred.exercises.leetcode.solved.p0201to0300.p0221;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/maximal-square/ */

/**
 * LeetCode 第 221 题「最大正方形」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        /*
         * Example 1:
         * Input: matrix = [<p>
         * |                 ["1","0","1","0","0"],
         * |                 ["1","0","1","1","1"],
         * |                 ["1","1","1","1","1"],
         * |                 ["1","0","0","1","0"]
         * |                ]
         * Output: 4
         * Example 2:
         * <p>
         * <p>
         * Input: matrix = [
         * ["0","1"],
         * ["1","0"]
         * ]
         * <p>
         * Output: 1
         * Example 3:
         * <p>
         * Input: matrix = [["0"]]
         * Output: 0
         */
        Solution solution = new Solution();
        // 示例 1: matrix 4x5 → 期望 4
        assertEquals(4, solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));

        // 示例 2: matrix [["0","1"],["1","0"]] → 期望 1
        assertEquals(1, solution.maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}
        }));
        // 示例 3: matrix [["0"]] → 期望 0
        assertEquals(0, solution.maximalSquare(new char[][]{
                {'0'}
        }));
        System.out.println("p0221 passed");
    }
}
