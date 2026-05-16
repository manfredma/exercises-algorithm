package manfred.exercises.leetcode.p136;

/**
 * LeetCode 第 136 题「只出现一次的数字」：全员异或，相同数字抵消后剩余即为答案。
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}