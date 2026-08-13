package manfred.exercises.leetcode.solved.p0501to0600.p0560;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组 —— 前缀和 + 哈希表解法（最优）。
 *
 * <p>思路：若存在两个前缀和 prefixSum[j] 与 prefixSum[i]（j < i）满足
 * prefixSum[i] - prefixSum[j] == k，则 nums[j+1..i] 是一个和为 k 的子数组。
 * 用哈希表记录每个前缀和出现的次数，扫描到 i 时查 prefixSum[i] - k 的计数即可。
 *
 * <p>关键：初始放入 (0, 1)，表示前缀和为 0 出现过一次，覆盖「子数组从下标 0 开始」的情况。
 *
 * <p>复杂度：时间 O(n)，空间 O(n)。
 */
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 前缀和 → 出现次数
        Map<Integer, Integer> prefixCount = new HashMap<>();
        // 前缀和为 0 出现一次，对应「从下标 0 开始的子数组」恰好等于 k 的情况
        prefixCount.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            // 若之前存在前缀和 prefixSum - k，则二者之差对应的子数组和为 k
            result += prefixCount.getOrDefault(prefixSum - k, 0);
            // 记录当前前缀和，供后续位置查询
            prefixCount.merge(prefixSum, 1, Integer::sum);
        }

        return result;
    }
}
