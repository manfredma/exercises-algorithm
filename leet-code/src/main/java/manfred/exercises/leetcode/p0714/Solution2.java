package manfred.exercises.leetcode.p0714;

/**
 * 动态规划解法(状态机 + 空间优化)。
 *
 * <p>每天只有两种状态:
 * <ul>
 *   <li>{@code cash}  —— 当天「不持股」时的最大利润</li>
 *   <li>{@code hold}  —— 当天「持股」时的最大利润</li>
 * </ul>
 *
 * <p>状态转移:
 * <pre>
 *   cash = max(cash,        hold + prices[i] - fee)   // 保持空仓 或 卖出(扣手续费)
 *   hold = max(hold,        prevCash - prices[i])      // 继续持有 或 买入
 * </pre>
 *
 * <p>注意:必须用 {@code prevCash} 暂存上一天的 cash,
 * 因为 cash 先更新、hold 后更新时还要用到旧 cash。
 *
 * <p>时间 O(n),空间 O(1)。
 */
class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int prevCash = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, prevCash - prices[i]);
        }
        return cash;
    }
}
