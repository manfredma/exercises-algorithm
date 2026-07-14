package manfred.exercises.leetcode.p0867;

import java.util.Arrays;

/*
给你一个二维整数数组 matrix，返回 matrix 的转置矩阵。
矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
*/
/**
 * LeetCode 第 867 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: matrix = [[1,2,3],[4,5,6],[7,8,9]] → 期望 [[1,4,7],[2,5,8],[3,6,9]]
        System.out.println(Arrays.deepToString(solution.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        // 示例 2: matrix = [[1,2,3],[4,5,6]] → 期望 [[1,4],[2,5],[3,6]]
        System.out.println(Arrays.deepToString(solution.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
}
