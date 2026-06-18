package manfred.exercises.leetcode.p0502;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        // idx 表示capital的下标。
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        // 按照 capital 的大小对其索引进行排序
        Arrays.sort(idx, Comparator.comparingInt(o -> capital[o]));

        PriorityQueue<Integer> profits2projects = new PriorityQueue<>(k, Comparator.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            // 顺序迭代 capital 中满足条件的值
            while (ptr < n && capital[idx[ptr]] <= w) {
                profits2projects.offer(profits[idx[ptr]]);
                ptr++;
            }
            w = w + (!profits2projects.isEmpty() ? profits2projects.poll() : 0);
        }
        return w;
    }
}
