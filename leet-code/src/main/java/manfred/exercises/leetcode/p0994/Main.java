package manfred.exercises.leetcode.p0994;

import java.util.Arrays;

/*
在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

    值 0 代表空单元格；

    值 1 代表新鲜橘子；

    值 2 代表腐烂的橘子。

每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

示例 1：
输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4

示例 2：
输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。

示例 3：
输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2
*/
/**
 * LeetCode 第 994 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: grid = [[2,1,1],[1,1,0],[0,1,1]] → 期望 4
         System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        // 示例 2: grid = [[2,1,1],[0,1,1],[1,0,1]] → 期望 -1
         System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        // 示例 3: grid = [[0,2]] → 期望 0
         System.out.println(solution.orangesRotting(new int[][]{{0,2}}));
    }
}
