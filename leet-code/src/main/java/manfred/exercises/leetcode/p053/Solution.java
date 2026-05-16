package manfred.exercises.leetcode.p053;

/**
 * LeetCode 第 53 题「最大子数组和」：Kadane 算法，动态维护当前子数组和与全局最大值。
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int result = nums[0];
        int maxResult = result;

        for (int i = 1; i < nums.length; i++) {
            if (result < 0) {
                result = nums[i];
            } else {
                result = nums[i] + result;
            }

            maxResult = result > maxResult ? result : maxResult;
        }
        return maxResult;
    }
}