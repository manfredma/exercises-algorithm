package manfred.exercises.leetcode.p1275;

/*
井字棋是由两个玩家 A 和 B 在 3 x 3 的棋盘上进行的游戏。
给你一个数组 moves，其中 moves[i] = [row_i, col_i] 表示第 i 次移动在 grid[row_i][col_i]。
如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；
如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
*/
/**
 * LeetCode 第 1275 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]] → 期望 "A"
        System.out.println(solution.tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}}));

        // 示例 2: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]] → 期望 "B"
        System.out.println(solution.tictactoe(new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}));

        // 示例 3: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]] → 期望 "Draw"
        System.out.println(solution.tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
    }
}
