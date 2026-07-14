package manfred.exercises.leetcode.p1470;

/**
 * 位编码原地解法,O(1) 额外空间。
 *
 * <p>利用 {@code nums[i] <= 10^3 < 2^16},每个值占低位 16 位以内,
 * 高位 16 位空闲,可暂存目标值。
 *
 * <p>位置 {@code i} 的最终值来自原位置:
 * <ul>
 *   <li>偶数位 {@code 2k} 放 {@code x_{k+1} = nums[k]} → {@code src = i/2}</li>
 *   <li>奇数位 {@code 2k+1} 放 {@code y_{k+1} = nums[n+k]} → {@code src = n + i/2}</li>
 * </ul>
 *
 * <p>两遍扫描:
 * <ol>
 *   <li>把目标值编码进高位:{@code nums[i] |= (nums[src] & 0xFFFF) << 16}
 *       —— {@code & 0xFFFF} 只取原值(低位始终不变,即使 src&lt;i 也安全)</li>
 *   <li>右移取高位:{@code nums[i] >>= 16}</li>
 * </ol>
 *
 * <p>注意:原地操作会修改入参数组(返回 nums 本身)。
 * 这是 O(1) 空间的代价——若调用方需保留原数组,应先复制。
 *
 * <p>时间 O(n),空间 O(1)(不计返回值占用)。
 */
class Solution2 {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++) {
            int src = (i % 2 == 0) ? (i / 2) : (n + i / 2);
            nums[i] |= (nums[src] & 0xFFFF) << 16;
        }
        for (int i = 0; i < 2 * n; i++) {
            nums[i] >>= 16;
        }
        return nums;
    }
}
