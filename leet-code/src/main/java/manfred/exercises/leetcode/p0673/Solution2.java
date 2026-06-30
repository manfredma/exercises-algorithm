package manfred.exercises.leetcode.p0673;

class Solution2 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2]; // dp[i] = {最长长度, 方案数}
        int maxLen = 0, result = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                result = dp[i][1];
            } else if (dp[i][0] == maxLen) {
                result += dp[i][1];
            }
        }
        return result;
    }
}
