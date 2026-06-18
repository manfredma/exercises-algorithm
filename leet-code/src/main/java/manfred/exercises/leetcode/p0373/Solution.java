package manfred.exercises.leetcode.p0373;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 小顶堆，存 [nums1下标, nums2下标]，按和排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));

        // 初始：每个 nums1[i] 与 nums2[0] 配对入堆
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(new int[]{i, 0});
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty() && result.size() < k) {
            int[] pair = queue.poll();
            int i = pair[0], j = pair[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            // 懒扩展：(i,j) 取出后，把 (i,j+1) 推入堆
            if (j + 1 < nums2.length) {
                queue.offer(new int[]{i, j + 1});
            }
        }
        return result;
    }
}
