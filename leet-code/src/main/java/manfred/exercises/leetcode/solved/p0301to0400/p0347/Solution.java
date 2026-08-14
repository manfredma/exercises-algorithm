package manfred.exercises.leetcode.solved.p0301to0400.p0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素 —— 大顶堆全量排序解法。
 *
 * <p>思路：用 HashMap 统计每个数的频次，把全部 (num, count) 入大顶堆（按频次降序），
 * 再依次弹出 k 个堆顶即得答案。
 *
 * <p>复杂度：时间 O(n log m)，m 为不同元素数；空间 O(m)。
 * 不满足进阶要求的 O(n log n) 以内（m 与 n 同阶时为 O(n log n)）。
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int j : nums) {
            numCount.merge(j, 1, Integer::sum);
        }
        // 大顶堆：按频次降序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        numCount.forEach((num, count) -> priorityQueue.add(new int[]{num, count}));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (!priorityQueue.isEmpty()) {
                result[i] = priorityQueue.poll()[0];
            }
        }
        return result;
    }
}
