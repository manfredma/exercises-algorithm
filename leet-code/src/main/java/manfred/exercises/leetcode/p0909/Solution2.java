package manfred.exercises.leetcode.p0909;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution2 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    int[] xy = calcXY(next, n);
                    if (board[xy[0]][xy[1]] != -1) {
                        next = board[xy[0]][xy[1]];
                    }
                    if (next == n * n) return steps;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int[] calcXY(int idx, int n) {
        int x = n - 1 - (idx - 1) / n;
        int y = (idx - 1) % n;
        if ((n - 1 - x) % 2 == 1) y = n - 1 - y;
        return new int[]{x, y};
    }
}
