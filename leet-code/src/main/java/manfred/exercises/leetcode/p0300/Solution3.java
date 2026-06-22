package manfred.exercises.leetcode.p0300;

/**
 * LeetCode 第 300 题「最长递增子序列」：二分搜索 + 耐心排序 O(n log n)。
 */
class Solution3 {
    public int lengthOfLIS(int[] nums) {
        // tails[i] 表示：所有长度为 i+1 的递增子序列中，末尾元素的最小值。
        // 例如：nums = [10,9,2,5,3,7,101,18]
        //   处理完后 tails 可能是 [2,3,7,18]，代表：
        //     长度为 1 的 LIS 末尾最小是 2
        //     长度为 2 的 LIS 末尾最小是 3
        //     长度为 3 的 LIS 末尾最小是 7
        //     长度为 4 的 LIS 末尾最小是 18
        // 注意：tails 本身不一定是一个合法的子序列，但其长度就是 LIS 长度。
        int[] tails = new int[nums.length];
        int len = 0; // 当前 tails 的有效长度，即当前找到的最长递增子序列长度

        for (int num : nums) {
            // 二分查找：在 tails[0..len-1] 中找第一个 >= num 的位置
            // - 若 num 比所有 tails 末尾都大（lo == len），说明 num 能延伸当前最长序列，追加
            // - 否则找到位置 lo，用 num 替换 tails[lo]：
            //     贪心策略：相同长度的子序列，末尾越小，越容易在后面继续延伸
            int lo = 0, hi = len;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < num) lo = mid + 1; // num 比 mid 处大，往右找
                else hi = mid;                       // num <= mid 处，往左收缩
            }

            // lo 就是第一个 >= num 的位置
            tails[lo] = num; // 替换或追加

            // 若 lo == len，说明 num 比所有现有末尾都大，LIS 长度 +1
            if (lo == len) len++;
        }

        return len;
    }
}
