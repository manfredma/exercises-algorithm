package manfred.exercises.leetcode.solved.p3101to3200.p3105;

/**
 * LeetCode 第 3105 题「最长的严格递增或严格递减子数组」：一次遍历同向追踪，分支内结算。
 *
 * <p>同时维护当前严格递增段长度 {@code inc} 与当前严格递减段长度 {@code dec}，
 * 以及历史已结算的最长长度 {@code ans}。方向切换时把即将被中断的那个方向
 * 结算进 {@code ans}（递增则结算 {@code dec}，递减则结算 {@code inc}），
 * 相等时两个方向都结算。结算分散在各分支内，循环后再兜底
 * {@code max(ans, max(inc, dec))} 兜住尚未中断的末尾段。</p>
 *
 * <p>与 {@link Solution2} 思路一致，区别在 {@code ans} 的刷新位置：本解法在分支内
 * 按需结算（递增/递减分支每次少一次 {@code Math.max}），{@code Solution2} 统一在
 * 循环末尾刷新（逻辑更集中）。n ≤ 50 下性能无实际差异，属风格取舍。</p>
 *
 * <p>时间复杂度 {@code O(n)}，空间复杂度 {@code O(1)}。</p>
 *
 * @see <a href="https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/">LeetCode 中文站</a>
 */
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc += 1;
                ans = Math.max(ans, dec);
                dec = 1;
            } else if (nums[i] < nums[i -1]) {
                dec += 1;
                ans = Math.max(ans, inc);
                inc = 1;
            } else {
                // 相等则都清 1
                ans = Math.max(ans, inc);
                ans = Math.max(ans, dec);
                inc = 1;
                dec = 1;
            }
        }
        return Math.max(ans, Math.max(inc, dec));
    }
}
