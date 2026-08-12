package manfred.exercises.leetcode.solved.p1301to1400.p1306;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        // 使用广度优先的算法来遍历
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (arr[idx] == 0) {
                return true;
            }
            if (idx + arr[idx] >= 0 && idx + arr[idx] < arr.length) {
                if (!visited[idx + arr[idx]]) {
                    queue.offer(idx + arr[idx]);
                    visited[idx + arr[idx]] = true;
                }
            }
            if (idx - arr[idx] >= 0 && idx - arr[idx] < arr.length) {
                if (!visited[idx - arr[idx]]) {
                    queue.offer(idx - arr[idx]);
                    visited[idx - arr[idx]] = true;
                }
            }
        }
        return false;
    }
}
