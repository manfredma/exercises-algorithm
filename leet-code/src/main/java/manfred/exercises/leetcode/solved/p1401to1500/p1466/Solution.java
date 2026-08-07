package manfred.exercises.leetcode.solved.p1401to1500.p1466;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minReorder(int n, int[][] connections) {
        int numOfReverse = 0;
        boolean[] visited = new boolean[n];
        // 每条边保存相邻城市及从当前城市前往该城市时是否需要反转路线。
        List<int[]>[] adjs = new ArrayList[n];
        for (int i = 0; i < adjs.length; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            adjs[connection[1]].add(new int[]{connection[0], 0});
            adjs[connection[0]].add(new int[]{connection[1], 1});
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int city = queue.poll();
            List<int[]> adj = adjs[city];
            for (int[] a : adj) {
                if (visited[a[0]]) {
                    continue;
                }
                visited[a[0]] = true;
                numOfReverse += a[1];
                queue.offer(a[0]);
            }
        }
        return numOfReverse;
    }
}
