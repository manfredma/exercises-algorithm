package manfred.exercises.leetcode.solved.p0301to0400.p0322;

import java.util.Arrays;

/**
 * 零钱兑换 —— 递归枚举解法。
 *
 * <p>思路：按面额从大到小回溯，枚举每个面额的使用数量（0 到 amount/coin），
 * 剩余金额交给更小面额递归求最少硬币数，取所有枚举的最小值。
 *
 * <p>注意：会 {@code Arrays.sort} 排序入参 coins，调用方需自行 clone 防止污染。
 *
 * <p>复杂度：最坏指数级，存在大量重复子问题（无记忆化）。
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return doCoinChange(coins, amount, coins.length - 1);
    }

    private int doCoinChange(int[] coins, int amount, int index) {
        int result = Integer.MAX_VALUE;
        int loop = amount / coins[index];
        amount = amount % coins[index];
        if (amount == 0) {
            return loop;
        }
        if (index > 0) {
            int subIndex = index - 1;
            for (int i = 0; i <= loop; i++) {
                int subResult = doCoinChange(coins, amount, subIndex);
                if (subResult != -1) {
                    result = Math.min(loop - i + subResult, result);
                }
                amount = amount + coins[index];
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}
