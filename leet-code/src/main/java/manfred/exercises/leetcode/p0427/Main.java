package manfred.exercises.leetcode.p0427;

/*
给你一个 n * n 矩阵 grid，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵，并返回四叉树的根节点。

构建步骤：
1. 若当前网格值全部相同，设 isLeaf=true，val 为对应值，四个子节点为 null
2. 若不同，设 isLeaf=false，均分为四个子网格，递归构建

示例 1：
输入：grid = [[0,1],[1,0]]
输出：[[0,1],[1,0],[1,1],[1,1],[1,0]]

示例 2：
输入：grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],
              [1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],
              [1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],
              [1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
输出：[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]

提示：
- n == grid.length == grid[i].length
- n == 2^x，其中 0 <= x <= 6
*/
/**
 * LeetCode 第 427 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1 → 期望根节点 isLeaf=false, val=true
        int[][] grid1 = {{0, 1}, {1, 0}};
        Node root1 = solution.construct(grid1);
        System.out.println("isLeaf=" + root1.isLeaf + ", val=" + root1.val);

        // 示例 2 → 期望根节点 isLeaf=false
        int[][] grid2 = {
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Node root2 = solution.construct(grid2);
        System.out.println("isLeaf=" + root2.isLeaf + ", val=" + root2.val);
    }
}
