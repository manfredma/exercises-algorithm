package manfred.exercises.leetcode.solved.p0501to0600.p0560;

/**
 * 和为 K 的子数组 —— 增量枚举解法。
 *
 * <p>思路：sum[j] 维护「以 j 为起点、到当前位置 i 的子数组和」。外层每推进一个 i，
 * 就把 nums[i] 累加进所有 sum[j]（j ∈ [0, i]），使得 sum[j] 始终等于 nums[j..i] 的和。
 * 若 sum[j] == k 则命中一个子数组。
 *
 * <p>与暴力解法（Solution）的差别：暴力对每个起点重置 sum 从头累加，本解法用一维数组
 * 把每个起点的和"挂"起来增量更新，避免重复遍历。仍枚举全部 O(n²) 个子数组，
 * 但内层循环体极轻（一次加法 + 一次比较），常数因子小。
 *
 * <p>复杂度：时间 O(n²)，空间 O(n)。
 */
class Solution3 {
    public int subarraySum(int[] nums, int k) {
        // sum[j] 表示 nums[j..i] 的和，i 为当前外层循环位置
        int result = 0;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 将 nums[i] 累加进所有以 j 为起点、终点扩展到 i 的子数组
            for (int j = 0; j <= i; j++) {
                sum[j] += nums[i];
                if (sum[j] == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
