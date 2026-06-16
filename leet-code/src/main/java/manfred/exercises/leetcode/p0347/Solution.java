package manfred.exercises.leetcode.p0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int j : nums) {
            numCount.merge(j, 1, Integer::sum);
        }
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
