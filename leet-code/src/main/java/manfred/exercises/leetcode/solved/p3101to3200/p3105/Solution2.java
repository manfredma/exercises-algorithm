package manfred.exercises.leetcode.solved.p3101to3200.p3105;

/**
 * LeetCode 第 3105 题「最长的严格递增或严格递减子数组」：一次遍历同向追踪，统一结算。
 *
 * <p>同时维护当前严格递增段长度 {@code inc} 与当前严格递减段长度 {@code dec}：
 * 相邻两元素 {@code nums[i] > nums[i-1]} 时 {@code inc++}、{@code dec} 归 1；
 * {@code <} 时反之；相等时两者都归 1。方向切换只影响"谁涨谁归 1"，
 * 而答案刷新统一放在循环末尾 {@code ans = max(ans, max(inc, dec))}，无需在每个分支里
 * 判断此刻该结算哪个方向，逻辑集中、心智负担更小。</p>
 *
 * <p>时间复杂度 {@code O(n)}，空间复杂度 {@code O(1)}。</p>
 *
 * @see <a href="https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/">LeetCode 中文站</a>
 */
class Solution2 {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc += 1;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec += 1;
                inc = 1;
            } else {
                // 相等则都清 1
                inc = 1;
                dec = 1;
            }
            ans = Math.max(ans, Math.max(inc, dec));
        }
        return ans;
    }
}
