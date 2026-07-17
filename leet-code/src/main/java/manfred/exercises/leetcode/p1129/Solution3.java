package manfred.exercises.leetcode.p1129;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 备选解法 2：分层 BFS，最简写法。
 *
 * <p>不显式记录步数，靠 BFS "按层推进" 的性质：每一轮处理当前层全部状态，步数 +1。
 * 状态仍为 (node, lastColor)，但用两个并行队列分层，逻辑最短。
 *
 * <p>颜色约定：lastColor = 0 起点 / 1 红 / 2 蓝；下一步走与 lastColor 不同的颜色。
 * 时间 O(n+E)，空间 O(n+E)。
 */
class Solution3 {

    private static final int RED = 1;
    private static final int BLUE = 2;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redAdj = buildAdj(n, redEdges);
        List<List<Integer>> blueAdj = buildAdj(n, blueEdges);

        int[] answer = new int[n];
        for (int i = 1; i < n; i++) {
            answer[i] = -1;
        }
        boolean[][] visited = new boolean[n][3];

        // 状态：{node, lastColor}
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();   // 当前层的全部状态，统一处理
            while (size-- > 0) {
                int[] cur = queue.poll();
                int node = cur[0], lastColor = cur[1];
                if (answer[node] == -1) {
                    answer[node] = steps;   // 首次到达即最短
                }
                if (lastColor != RED) {
                    for (int next : redAdj.get(node)) {
                        if (!visited[next][RED]) {
                            visited[next][RED] = true;
                            queue.offer(new int[]{next, RED});
                        }
                    }
                }
                if (lastColor != BLUE) {
                    for (int next : blueAdj.get(node)) {
                        if (!visited[next][BLUE]) {
                            visited[next][BLUE] = true;
                            queue.offer(new int[]{next, BLUE});
                        }
                    }
                }
            }
            steps++;
        }
        return answer;
    }

    private List<List<Integer>> buildAdj(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        return adj;
    }
}
