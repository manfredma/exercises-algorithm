package manfred.exercises.leetcode.wip.p3116;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 3116 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/kth-smallest-amount-with-single-denomination-combination/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：coins = [3,6,9], k = 3 → 9（6、9 均为 3 的倍数，并集即 3 的倍数）
        assertEquals(9L, solution.findKthSmallest(new int[]{3, 6, 9}, 3),
                "coins=[3,6,9], k=3");

        // 示例 2：coins = [5,2], k = 7 → 12
        assertEquals(12L, solution.findKthSmallest(new int[]{5, 2}, 7),
                "coins=[5,2], k=7");

        // 边界·k=1：最小金额为最小面额
        assertEquals(3L, solution.findKthSmallest(new int[]{3, 6, 9}, 1),
                "coins=[3,6,9], k=1");

        // 边界·单硬币：coins=[7], k=3 → 21（7,14,21）
        assertEquals(21L, solution.findKthSmallest(new int[]{7}, 3),
                "coins=[7], k=3");

        // 边界·两硬币 LCM 交集：coins=[2,3], k=10 → 15
        // 并集排序：2,3,4,6,8,9,10,12,14,15，第 10 小为 15
        assertEquals(15L, solution.findKthSmallest(new int[]{2, 3}, 10),
                "coins=[2,3], k=10");

        // 边界·大 k 不溢出（返回类型 long 必要性）：coins=[1], k=2*10^9 → 2*10^9
        assertEquals(2_000_000_000L, solution.findKthSmallest(new int[]{1}, 2_000_000_000),
                "coins=[1], k=2000000000");

        System.out.println("leet#3116 passed");
    }
}
