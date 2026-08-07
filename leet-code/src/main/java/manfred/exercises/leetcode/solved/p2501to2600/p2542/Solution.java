package manfred.exercises.leetcode.solved.p2501to2600.p2542;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[][] numPair = new int[len][];
        for (int i = 0; i < len; i++) {
            numPair[i] = new int[] {nums1[i], nums2[i]};
        }

        Arrays.sort(numPair, Comparator.<int[]>comparingInt(a -> -a[1]).thenComparing(a -> -a[0]));
        long added = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            queue.offer(numPair[i][0]);
            added += numPair[i][0];
        }
        long result = added * numPair[k - 1][1];

        // 逐步推进
        for (int i = k; i < len; i++) {
            queue.offer(numPair[i][0]);
            added += numPair[i][0];
            added -= queue.poll();
            result = Math.max(added * numPair[i][1], result);
        }
        return result;
    }
}
