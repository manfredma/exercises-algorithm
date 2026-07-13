package manfred.exercises.leetcode.p0518;

/*
给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0。
假设每一种面额的硬币有无限个。
*/
/**
 * LeetCode 第 518 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: amount = 5, coins = [1, 2, 5] → 期望 4
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        // 示例 2: amount = 3, coins = [2] → 期望 0
        System.out.println(solution.change(3, new int[]{2}));
        // 示例 3: amount = 10, coins = [10] → 期望 1
        System.out.println(solution.change(10, new int[]{10}));
    }
}
