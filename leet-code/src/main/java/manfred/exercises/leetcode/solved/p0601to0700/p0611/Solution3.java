package manfred.exercises.leetcode.solved.p0601to0700.p0611;

import java.util.Arrays;

class Solution3 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int k = nums.length - 1; k >= 2; k--) {
            int left = 0;
            int right = k - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
