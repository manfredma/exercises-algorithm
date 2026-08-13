package manfred.exercises.leetcode.solved.p0501to0600.p0560;

/**
 * 和为 K 的子数组 —— 暴力枚举解法。
 *
 * <p>思路：枚举所有子数组 [i, j]，累加 nums[i..j] 的和，统计等于 k 的个数。
 * 内层用 sum 增量累加，避免每次重新求和。
 *
 * <p>复杂度：时间 O(n²)，空间 O(1)。
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 枚举子数组起点 i
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 枚举子数组终点 j，sum 即 nums[i..j] 的和
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
