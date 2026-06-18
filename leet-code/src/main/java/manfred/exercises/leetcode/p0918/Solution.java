package manfred.exercises.leetcode.p0918;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int result = Integer.MIN_VALUE;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, nums[i]);
            int sum = nums[i];
            for (int j = (i + 1) % length; j != i && sum > 0; j = (j + 1) % length) {
                sum += nums[j];
                result = Math.max(result, sum);
                if (sum < 0) {
                    if (j > i) {
                        // 直接跳过大量数据重新开始即可。
                        i = j;
                    } else {
                        // 已经试探到环形后面来了，可以整体结束
                        return result;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
