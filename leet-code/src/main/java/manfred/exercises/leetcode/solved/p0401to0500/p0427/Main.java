package manfred.exercises.leetcode.solved.p0401to0500.p0427;

import static manfred.exercises.assertion.Assert.assertFalse;

/** 题目链接：https://leetcode.cn/problems/construct-quad-tree/ */

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

        // 示例 1: grid = [[0,1],[1,0]] → 期望根节点 isLeaf=false（四个值不全相同）
        int[][] grid1 = {{0, 1}, {1, 0}};
        Node root1 = solution.construct(grid1);
        assertFalse(root1.isLeaf, "示例1 根节点应为非叶节点");

        // 示例 2: grid 8x8 → 期望根节点 isLeaf=false
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
        assertFalse(root2.isLeaf, "示例2 根节点应为非叶节点");
        System.out.println("p0427 passed");
    }
}
