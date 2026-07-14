package manfred.exercises.leetcode.p0377;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    // 将最后一个是 num 的情况都加一下
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
