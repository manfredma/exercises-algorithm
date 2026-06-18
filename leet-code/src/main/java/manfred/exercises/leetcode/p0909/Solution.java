package manfred.exercises.leetcode.p0909;

import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        return bfs(n * n, board);
    }

    private int bfs(int dst, int[][] board) {
        int n = board.length;
        // 记录已经访问过谁了
        boolean[] visited = new boolean[n * n + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        int result = 0;
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            result++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer q = queue.poll();
                // 探寻直接寻址
                for (int j = 1; j < 7; j++) {
                    int next = q + j;
                    // 判断此处是否有梯子
                    int[] xy = calcXY(next, n);
                    if (board[xy[0]][xy[1]] != -1) {
                        next = board[xy[0]][xy[1]];
                    }
                    if (next == dst) {
                        return result;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        // 理论上不会走到此处，无论如何都会走到终点！
        return -1;
    }

    private int[] calcXY(int idx, int n) {
        int x = n - 1 - (idx - 1) / n;
        int y = (idx - 1) % n;
        if ((n - 1 - x) % 2 == 1) {
            // 奇数行是反方向数（即：从 n-1 -> 0 数）
            y = (n - 1) - y;
        }
        return new int[]{x, y};
    }
}
