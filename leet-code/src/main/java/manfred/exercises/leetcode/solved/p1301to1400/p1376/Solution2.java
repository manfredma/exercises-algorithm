package manfred.exercises.leetcode.solved.p1301to1400.p1376;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** 建树后从总负责人开始广度优先遍历。 */
class Solution2 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] subordinates = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            subordinates[i] = new ArrayList<>();
        }
        for (int employee = 0; employee < n; employee++) {
            if (manager[employee] != -1) {
                subordinates[manager[employee]].add(employee);
            }
        }

        int longestMinutes = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{headID, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int employee = current[0];
            int elapsedMinutes = current[1];
            longestMinutes = Math.max(longestMinutes, elapsedMinutes);
            for (int subordinate : subordinates[employee]) {
                queue.offer(new int[]{subordinate, elapsedMinutes + informTime[employee]});
            }
        }
        return longestMinutes;
    }
}
