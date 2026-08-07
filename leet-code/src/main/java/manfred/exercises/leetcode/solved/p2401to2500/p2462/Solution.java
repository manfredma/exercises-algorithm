package manfred.exercises.leetcode.solved.p2401to2500.p2462;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        // 按照工人成本排序，然后按照序号排序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

        int left = 0, right = costs.length - 1;
        for (int i = 0; i < candidates; i++) {
            // 将左右元素初始化优先级队列
            if (left <= right) {
                priorityQueue.offer(new int[] {costs[left], left});
                left++;
            }
            if (left <= right) {
                priorityQueue.offer(new int[] {costs[right], right});
                right--;
            }
        }

        // 开始挑选工人
        long result = 0;
        for (int i = 0; i < k; i++) {
            int[] candidate = priorityQueue.poll();
            result += candidate[0];
            // 判断使用的是左半部分的工人则再增加一个左半部分的工人
            if (candidate[1] <= left && left <= right) {
                priorityQueue.offer(new int[] {costs[left], left});
                left++;
            }
            if (candidate[1] >= right && left <= right) {
                priorityQueue.offer(new int[] {costs[right], right});
                right--;
            }
        }

        return result;
    }
}
