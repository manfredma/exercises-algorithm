package manfred.exercises.leetcode.p0918;

import java.util.Arrays;

class Solution2 {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curMax = 0;
        int minSum = Integer.MAX_VALUE, curMin = 0;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, (totalSum - minSum)) : maxSum;
    }
}
