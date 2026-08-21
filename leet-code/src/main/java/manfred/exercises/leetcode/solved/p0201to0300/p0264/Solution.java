package manfred.exercises.leetcode.solved.p0201to0300.p0264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数 II：返回第 n 个丑数（质因子只包含 2、3、5 的正整数）。
 *
 * <p>解法一：最小堆 + 去重。堆中始终放候选丑数，每次弹出最小者当作当前第 i 个，
 * 再把它的 2/3/5 倍入堆（用 Set 去重，已入过堆的跳过）。循环 n-1 次后堆顶即第 n 个。
 *
 * <p>关键点：用 long 防溢出——丑数序列可增长到 21 亿（n=1690 时为 2123366400），
 * 中间产物 next×5 可能超 int 上限，全程用 long 计算，末尾 intValue() 收回。
 *
 * <p>对比 {@link Solution2}：本解法每次 poll/offer 为 O(log n)，整体 O(n log n)，且堆与 Set 额外占 O(n) 空间；
 * Solution2 三指针 DP 为 O(n) 时间、O(n) 空间，更优。保留本解法展示「堆取最小」的朴素思路。
 *
 * <p>时间复杂度 O(n log n)，空间复杂度 O(n)。
 */
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> added = new HashSet<>();
        Long[] x = new Long[]{2L, 3L, 5L};
        for (Long i : x) {
            queue.offer(i);
            added.add(i);
        }
        for (int i = 2; i < n; i++) {
            Long next = queue.poll();
            for (Long multi : x) {
                if (added.add(next * multi)) {
                    queue.offer(next * multi);
                }
            }
        }
        return queue.peek().intValue();
    }
}
