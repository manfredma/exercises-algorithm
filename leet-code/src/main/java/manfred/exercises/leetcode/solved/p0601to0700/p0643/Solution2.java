package manfred.exercises.leetcode.solved.p0601to0700.p0643;

class Solution2 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (right >= k) {
                sum -= nums[right - k];
            }
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return (double) maxSum / k;
    }
}
