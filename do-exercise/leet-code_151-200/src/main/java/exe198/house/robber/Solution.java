package exe198.house.robber;

/**
 * LeetCode 第 198 题「打家劫舍」：动态规划，dp[i] = max(dp[i-1], dp[i-2] + nums[i])。
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] rob = new int[nums.length];
        int[] cool = new int[nums.length];
        rob[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cool[i] = rob[i - 1];
            rob[i] = Math.max(rob[i - 1], cool[i - 1] + nums[i]);
        }
        return Math.max(rob[nums.length - 1], cool[nums.length - 1]);
    }
}