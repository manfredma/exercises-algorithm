package manfred.exercises.leetcode.p121;

/**
 * LeetCode 第 121 题「买卖股票的最佳时机」：一次遍历维护最低价和最大利润。
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int leftMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            leftMin = Math.min(prices[i - 1], leftMin);
            if (prices[i] > leftMin) {
                maxProfit = Math.max(prices[i] - leftMin, maxProfit);
            }
        }
        return maxProfit;
    }
}