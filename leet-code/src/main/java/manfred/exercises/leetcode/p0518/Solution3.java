package manfred.exercises.leetcode.p0518;

/**
 * 二维 DP(二重循环,消去 k 循环版本)。
 *
 * <p>相比 Solution2 的三重循环,这里用递推等价变形消掉了「枚举硬币用了几个」的内层 k 循环。
 *
 * <p>推导:令 c = coins[i],
 * <pre>
 *   change[i][j]   = Σ_{k=0,c,2c,...}      change[i-1][j-k]
 *   change[i][j-c] = Σ_{k=c,2c,3c,...}     change[i-1][j-k]   // 错位一个 c
 *   ⇒ change[i][j] = change[i-1][j] + change[i][j-c]          (j ≥ c)
 * </pre>
 *
 * <p>语义:不用 coins[i] 的方案数(上一行同列) + 至少用一个 coins[i] 的方案数(本行 j-c)。
 * 「至少用一个」的方案恰好等于 change[i][j-c]——因为先用掉一个 c,剩下 j-c 继续可选用 coins[i]。
 *
 * <p>时间 O(amount·coins),空间 O(coins·amount)。
 */
class Solution3 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] change = new int[n][amount + 1];
        // 初始化:只用第一种硬币,能整除则 1 种
        for (int j = 0; j <= amount; j++) {
            change[0][j] = (j % coins[0] == 0) ? 1 : 0;
        }
        // 递推:change[i][j] = change[i-1][j] + change[i][j-coins[i]]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                change[i][j] = change[i - 1][j];
                if (j >= coins[i]) {
                    change[i][j] += change[i][j - coins[i]];
                }
            }
        }
        return change[n - 1][amount];
    }
}
