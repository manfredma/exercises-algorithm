package manfred.exercises.leetcode.p0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
