package manfred.exercises.leetcode.p0931;

/*
给你一个 n x n 的方形整数数组 matrix，找出并返回通过 matrix 的下降路径的最小和。
下降路径从第一行任意元素开始，每行选一个元素，下一行的元素与当前行最多相隔一列
（正下方或对角线方向）。

示例 1：
输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
输出：13

示例 2：
输入：matrix = [[-19,57],[-40,-5]]
输出：-59

提示：
- n == matrix.length == matrix[i].length
- 1 <= n <= 100
- -100 <= matrix[i][j] <= 100
*/
/**
 * LeetCode 第 931 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: matrix = [[2,1,3],[6,5,4],[7,8,9]] → 期望 13
        System.out.println(solution.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        // 示例 2: matrix = [[-19,57],[-40,-5]] → 期望 -59
        System.out.println(solution.minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
    }
}
