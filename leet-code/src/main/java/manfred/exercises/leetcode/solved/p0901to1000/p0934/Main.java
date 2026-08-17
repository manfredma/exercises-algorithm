package manfred.exercises.leetcode.solved.p0901to1000.p0934;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/shortest-bridge/ */

/*
给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。

岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。

你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。

返回必须翻转的 0 的最小数目。

示例 1：

输入：grid = [[0,1],[1,0]]
输出：1

示例 2：

输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
输出：2

示例 3：

输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
输出：1

提示：

n == grid.length == grid[i].length

2 <= n <= 100

grid[i][j] 为 0 或 1

grid 中恰有两个岛
 */
/**
 * LeetCode 第 934 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertBothEquals(2, solution, solution2, new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}});
        assertBothEquals(1, solution, solution2, new int[][]{{0, 1}, {1, 0}});
        assertBothEquals(1, solution, solution2, new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        });
        assertBothEquals(1, solution, solution2, new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 0, 0}});
    }

    private static void assertBothEquals(int expected, Solution solution, Solution2 solution2, int[][] grid) {
        assertEquals(expected, solution.shortestBridge(copyGrid(grid)));
        assertEquals(expected, solution2.shortestBridge(copyGrid(grid)));
    }

    private static int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int row = 0; row < grid.length; row++) {
            copy[row] = grid[row].clone();
        }
        return copy;
    }

}
