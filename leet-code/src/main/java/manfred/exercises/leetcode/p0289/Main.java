package manfred.exercises.leetcode.p0289;

import java.util.Arrays;

/*
根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）
的细胞都遵循以下四条生存定律：

- 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
- 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
- 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
- 如果死细胞周围正好有三个活细胞，则该位置死细胞复活。

示例 1：
输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

示例 2：
输入：board = [[1,1],[1,0]]
输出：[[1,1],[1,1]]

提示：
- m == board.length
- n == board[i].length
- 1 <= m, n <= 25
- board[i][j] 为 0 或 1
*/
/**
 * LeetCode 第 289 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: → 期望 [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        int[][] board1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution.gameOfLife(board1);
        for (int[] row : board1) System.out.println(Arrays.toString(row));

        System.out.println("---");

        // 示例 2: → 期望 [[1,1],[1,1]]
        int[][] board2 = {{1,1},{1,0}};
        solution.gameOfLife(board2);
        for (int[] row : board2) System.out.println(Arrays.toString(row));
    }
}
