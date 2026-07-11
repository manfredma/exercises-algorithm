package manfred.exercises.leetcode.p0714;

/**
 * 贪心解法(LeetCode 官方思路)。
 *
 * <p>维护一个「动态买入价」{@code buy},遍历价格:
 * <ul>
 *   <li>若 {@code prices[i] < buy}:出现更低的买入点,更新 buy</li>
 *   <li>若 {@code prices[i] > buy + fee}:有利可图,落袋为安
 *       {@code result += prices[i] - buy - fee},
 *       并令 {@code buy = prices[i] - fee}</li>
 * </ul>
 *
 * <p>关键在 {@code buy = prices[i] - fee} 这一 trick:
 * 卖出后若后续价格更高,相当于「没卖、直接补差价」,
 * 不会重复扣手续费。若后续出现真正更低的买入点,
 * {@code prices[i] < buy} 会自然更新,逻辑自洽。
 *
 * <p>时间 O(n),空间 O(1)。
 */
class Solution3 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int result = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy + fee) {
                result += prices[i] - buy - fee;
                buy = prices[i] - fee;
            }
        }
        return result;
    }
}
