package manfred.exercises.leetcode.p0547;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int circlesNum = 0;
        // 使用广度优先搜索来解决这个问题
        int len = isConnected.length;
        boolean[] searched = new boolean[len];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            // 需要将所有节点都判断一遍
            if (searched[i]) {
                continue;
            }
            circlesNum++;
            queue.offer(i);
            searched[i] = true;

            // 开始进行搜索
            while (!queue.isEmpty()) {
                int s = queue.poll();
                for (int j = 0; j < len; j++) {
                    if (searched[j]) {
                        continue;
                    }
                    if (isConnected[s][j] == 1) {
                        queue.offer(j);
                        searched[j] = true;
                    }
                }
            }
        }
        return circlesNum;
    }
}
