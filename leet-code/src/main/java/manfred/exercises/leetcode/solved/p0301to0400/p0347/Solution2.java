package manfred.exercises.leetcode.solved.p0301to0400.p0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素 —— 大小为 k 的小顶堆解法（满足进阶要求）。
 *
 * <p>思路：HashMap 统计频次，遍历每个 (num, count) 入小顶堆（按频次升序），
 * 堆大小超过 k 时弹出堆顶（频次最低的），最终堆里就是频次最高的 k 个。
 *
 * <p>关键：用「小顶堆 + 限容 k」而非大顶堆全量，把单次入堆代价从 O(log m) 降到 O(log k)。
 *
 * <p>复杂度：时间 O(n + m log k)，优于 O(n log n)；空间 O(m + k)。
 */
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.merge(num, 1, Integer::sum);
        }

        // 大小为 k 的最小堆，按频次升序，堆顶是当前 k 个中频次最低的
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, (o1, o2) -> o1[1] - o2[1]);
        numCount.forEach((num, count) -> {
            minHeap.offer(new int[]{num, count});
            // 超过 k 个时，淘汰频次最低的，保持堆大小为 k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
