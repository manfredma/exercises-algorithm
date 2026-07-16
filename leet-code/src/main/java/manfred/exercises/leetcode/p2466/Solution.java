package manfred.exercises.leetcode.p2466;

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = 1_000_000_000 + 7;
        dp[0] = 1; // 空串也算是一种选择？
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                // 尝试在默认增加 zero
                dp[i] = dp[i - zero];
            }

            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }

        }
        int result = 0;
        for (int i = low; i <= high; i++) {
            result += dp[i];
            result %= mod;
        }
        return result;
    }
}
