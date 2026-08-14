package manfred.exercises.leetcode.solved.p0201to0300.p0300;

/**
 * 最长递增子序列 —— 耐心排序 + 二分查找解法（O(n log n) 最优）。
 *
 * <p>与 {@link Solution3} 同算法，此处为重刷实现。
 *
 * <p>思路：维护 tails 数组，tails[i] = 所有长度为 i+1 的递增子序列中末尾元素的最小值。
 * 对每个 num，二分定位第一个 tails[i] >= num 的位置并替换；若 num 比所有末尾都大则追加。
 * tails 的长度即 LIS 长度（tails 本身不一定是合法子序列，但长度正确）。
 *
 * <p>复杂度：时间 O(n log n)，空间 O(n)。
 */
class Solution4 {
    public int lengthOfLIS(int[] nums) {
        // tails[i] = 长度为 i+1 的递增子序列中，末尾元素的最小值
        int[] tails = new int[nums.length];
        int len = 0; // tails 的有效长度，即当前 LIS 长度
        for (int num : nums) {
            // 在 tails[0..len) 中二分找第一个 >= num 的位置
            int low = 0, high = len;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tails[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            // 用 num 替换或追加到 tails[low]
            tails[low] = num;
            if (low == len) {
                // num 比所有现有末尾都大，LIS 可延伸一位
                len++;
            }
        }
        return len;
    }
}
