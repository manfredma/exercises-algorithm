package manfred.exercises.leetcode.p0909;

/*
给你一个大小为 n x n 的整数矩阵 board，方格按从 1 到 n² 编号，编号遵循转行交替方式，
从左下角开始的每一行改变方向。

你一开始位于方格 1，每回合掷骰子选定 [curr+1, min(curr+6, n²)] 内的目标方格，
遇到蛇或梯子（board[r][c] != -1）则传送到 board[r][c]，每次最多经过一次。
返回到达 n² 的最少掷骰次数，不可能则返回 -1。

示例 1：
输入：board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],
               [-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
输出：4

示例 2：
输入：board = [[-1,-1],[-1,3]]
输出：1

提示：
- n == board.length == board[i].length
- 2 <= n <= 20
- board[i][j] 的值是 -1 或在范围 [1, n²] 内
*/
/**
 * LeetCode 第 909 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1 → 期望 4
        int[][] board1 = {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
        };
        System.out.println(solution.snakesAndLadders(board1));

        // 示例 2 → 期望 1
        int[][] board2 = {{-1,-1},{-1,3}};
        System.out.println(solution.snakesAndLadders(board2));
    }
}
