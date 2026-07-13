package manfred.exercises.leetcode.p0518;

/**
 * 一维 DP(空间优化版本,518 标准最优解)。
 *
 * <p>在 Solution3 的递推 change[i][j] = change[i-1][j] + change[i][j-c] 基础上压维:
 * <ul>
 *   <li>change[i-1][j] —— 上一轮同列,即 {@code dp[j]} 更新前的旧值</li>
 *   <li>change[i][j-c] —— 本轮左侧,即 {@code dp[j-c]} 更新后的新值</li>
 * </ul>
 * 所以 {@code j} <b>正序</b>遍历时,一行代码 {@code dp[j] += dp[j-c]} 同时取到「上一轮同列」和「本轮左侧」。
 *
 * <p>顺序要害(完全背包易翻车点):
 * <ul>
 *   <li>外层硬币、内层金额(正序) = <b>组合数</b>(本题 518)</li>
 *   <li>外层金额、内层硬币       = <b>排列数</b>(377 组合总和 IV)</li>
 * </ul>
 * 同一转移方程,顺序一换答案就变。
 *
 * <p>时间 O(amount·coins),空间 O(amount)。
 */
class Solution4 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;   // 凑 0 有 1 种:什么都不选
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
