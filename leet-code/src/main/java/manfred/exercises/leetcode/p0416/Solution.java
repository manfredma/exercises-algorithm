package manfred.exercises.leetcode.p0416;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] result = new boolean[target + 1];
        result[0] = true;

        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                result[t] = result[t] || result[t - num];
            }
        }
        return result[target];
    }
}
