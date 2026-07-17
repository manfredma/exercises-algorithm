package manfred.exercises.leetcode.p1129;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 备选解法 1：BFS + 颜色编码 + 二维 visited 数组。
 *
 * <p>与 {@link Solution} 同算法（BFS、状态=节点+上一边颜色），写法上简化：
 * <ul>
 *   <li>颜色用 0/1/2 编码：0=起点（无上一边）、1=红、2=蓝，免去 boolean 与"起点"特判</li>
 *   <li>visited 用 {@code boolean[n][3]} 代替 HashSet，无 hashCode/equals 负担</li>
 *   <li>邻接表按 n 建表（非硬编码 100）</li>
 *   <li>队列统一用 offer（队尾），保证 FIFO 层级推进</li>
 * </ul>
 * 时间 O(n+E)，空间 O(n+E)。
 */
class Solution2 {

    private static final int RED = 1;
    private static final int BLUE = 2;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redAdj = buildAdj(n, redEdges);
        List<List<Integer>> blueAdj = buildAdj(n, blueEdges);

        int[] answer = new int[n];
        for (int i = 1; i < n; i++) {
            answer[i] = -1;
        }
        // visited[node][color]：是否已以"上一边为 color"的状态访问过 node（color=0 表起点）
        boolean[][] visited = new boolean[n][3];

        // 状态：{node, lastColor, steps}
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], lastColor = cur[1], steps = cur[2];
            // 上一步若非红，则可走红边；上一步若非蓝，则可走蓝边
            if (lastColor != RED) {
                relax(node, steps, RED, redAdj.get(node), queue, visited, answer);
            }
            if (lastColor != BLUE) {
                relax(node, steps, BLUE, blueAdj.get(node), queue, visited, answer);
            }
        }
        return answer;
    }

    private void relax(int from, int steps, int edgeColor, List<Integer> neighbors,
                       Deque<int[]> queue, boolean[][] visited, int[] answer) {
        for (int next : neighbors) {
            if (visited[next][edgeColor]) {
                continue;
            }
            visited[next][edgeColor] = true;
            if (answer[next] == -1) {
                answer[next] = steps + 1;   // BFS 首次到达即最短
            }
            queue.offer(new int[]{next, edgeColor, steps + 1});
        }
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
