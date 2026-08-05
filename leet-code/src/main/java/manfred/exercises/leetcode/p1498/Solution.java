package manfred.exercises.leetcode.p1498;

import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        final int mod = 1_000_000_007;
        int[] powersOfTwo = new int[nums.length];
        powersOfTwo[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powersOfTwo[i] = (powersOfTwo[i - 1] * 2) % mod;
        }

        int left = 0, right = nums.length - 1;
        int result = 0;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                // 固定最小元素 nums[left]，(left, right] 中的元素均可选或不选。
                result = (result + powersOfTwo[right - left]) % mod;
                left++;
            }
        }

        return result;
    }
}
