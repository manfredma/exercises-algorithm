package manfred.exercises.leetcode.p0502;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // 把 capital 和 profit 打包，按 capital 排序，避免 Integer[] 装箱开销
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, Comparator.comparingInt(p -> p[0]));

        // 大顶堆，初始容量设为 n，避免频繁扩容
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, Comparator.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            // 把当前资本能启动的项目全部入堆
            while (ptr < n && projects[ptr][0] <= w) {
                maxHeap.offer(projects[ptr][1]);
                ptr++;
            }
            // 没有可做的项目，提前结束
            if (maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;
    }
}
