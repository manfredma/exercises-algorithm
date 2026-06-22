package manfred.exercises.leetcode.p0300;

/**
 * LeetCode 第 300 题「最长递增子序列」：动态规划 O(n²)。
 */
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
