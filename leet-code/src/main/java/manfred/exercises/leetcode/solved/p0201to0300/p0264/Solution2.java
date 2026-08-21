package manfred.exercises.leetcode.solved.p0201to0300.p0264;

/**
 * 丑数 II：返回第 n 个丑数（质因子只包含 2、3、5 的正整数）。
 *
 * <p>解法二：三指针 DP（最优）。每个丑数必为某个更小丑数 × {2,3,5}，故维护三个指针
 * i2/i3/i5——分别记录「下一个该乘 2/3/5 的丑数」在 dp 中的下标。每轮取三候选
 * dp[i2]*2、dp[i3]*3、dp[i5]*5 的最小值填入 dp[i]。
 *
 * <p>关键点（去重）：同一值可能由多因子同时产生（如 6=2×3=3×2、10=2×5=5×2），故推进指针
 * 必须用三个独立 if（非 else if），命中的因子全部推进，否则下一轮会重复产出。单调性保证指针只前进。
 *
 * <p>对比 {@link Solution}：Solution 用最小堆 + 去重 Set，每次 poll/offer 为 O(log n)，整体 O(n log n)；
 * 本解法三指针 O(1) 取最小，整体 O(n)。用 int 即可（n=1690 时 dp 值 2123366400 未溢出 int）。
 *
 * <p>时间复杂度 O(n)，空间复杂度 O(n)。
 */
class Solution2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int next = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            dp[i] = next;
            // 三个独立 if（非 else if）：命中因子全推进，去重
            if (dp[i2] * 2 == next) {
                i2++;
            }
            if (dp[i3] * 3 == next) {
                i3++;
            }
            if (dp[i5] * 5 == next) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
