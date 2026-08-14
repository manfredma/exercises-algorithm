package manfred.exercises.leetcode.solved.p0301to0400.p0322;

/**
 * 零钱兑换 —— 一维动态规划解法。
 *
 * <p>思路：dp[i] 表示凑成金额 i 所需的最少硬币数。dp[0]=0，对每个金额 i，
 * 遍历所有面额 coin，若 i >= coin 且 dp[i-coin] 可达，则 dp[i] = min(dp[i-coin]+1)。
 *
 * <p>哨兵值用 amount+1 表示不可达（充当 +∞，避免 dp[i-coin]+1 溢出），
 * 最后 dp[amount] > amount 即返回 -1。amount=0 时自然返回 0，无需特判。
 *
 * <p>复杂度：时间 O(amount × coins.length)，空间 O(amount)。
 */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = 凑成金额 i 的最少硬币数；amount+1 表示不可达（+∞ 哨兵，避免 +1 溢出）
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
