package manfred.exercises.leetcode.p1351;

/*
给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。
请你统计并返回 grid 中负数的数目。

示例 1:
输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
输出：8

示例 2:
输入：grid = [[3,2],[1,0]]
输出：0
*/
/**
 * LeetCode 第 1351 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]] → 期望 8
        System.out.println(solution.countNegatives(
                new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
        // 示例 2: 输入 grid = [[3,2],[1,0]] → 期望 0
        System.out.println(solution.countNegatives(
                new int[][]{{3, 2}, {1, 0}}));
    }
}
