package manfred.exercises.leetcode.p0746;

/*
给你一个整数数组 cost，cost[i] 是从第 i 个台阶向上爬需要支付的费用。
支付后可选择向上爬一个或两个台阶。可从下标 0 或 1 开始。
返回达到楼梯顶部的最低花费。

示例 1：
输入：cost = [10,15,20]
输出：15

示例 2：
输入：cost = [1,100,1,1,1,100,1,1,100,1]
输出：6

提示：
- 2 <= cost.length <= 1000
- 0 <= cost[i] <= 999
*/
/**
 * LeetCode 第 746 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: cost = [10,15,20] → 期望 15
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        // 示例 2: cost = [1,100,1,1,1,100,1,1,100,1] → 期望 6
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
