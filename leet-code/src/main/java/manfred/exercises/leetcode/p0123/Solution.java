package manfred.exercises.leetcode.p0123;

/**
 * LeetCode 第 123 题「买卖股票的最佳时机 III」：状态机动态规划，维护最多两次交易的四种状态。
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int[] leftCMax = new int[prices.length];
        int[] rightCMax = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            leftMin = Math.min(leftMin, prices[i - 1]);
            rightMax = Math.max(rightMax, prices[prices.length - i]);

            leftCMax[i] = Math.max(leftCMax[i - 1], prices[i] - leftMin);
            rightCMax[prices.length - 1 - i] = Math.max(rightCMax[prices.length - i], rightMax - prices[prices.length - 1 - i]);
        }

        int result = leftCMax[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            result = Math.max(result, leftCMax[i] + rightCMax[i + 1]);
        }
        return result;
    }
}