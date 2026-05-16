package manfred.exercises.leetcode.p0309;

/**
 * LeetCode 第 309 题「买卖股票的最佳时机含冷冻期」：状态机动态规划，维护持股、卖出冷冻、空仓三种状态。
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] sellProfit = new int[prices.length];
        int[] buyProfit = new int[prices.length];
        int[] coolDown = new int[prices.length];
        buyProfit[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            coolDown[i] = sellProfit[i - 1];
            sellProfit[i] = Math.max(sellProfit[i - 1], buyProfit[i - 1] + prices[i]);
            buyProfit[i] = Math.max(buyProfit[i - 1], coolDown[i - 1] - prices[i]);
        }

        return Math.max(sellProfit[prices.length - 1], coolDown[prices.length - 1]);
    }
}