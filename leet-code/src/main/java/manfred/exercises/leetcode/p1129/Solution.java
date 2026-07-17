package manfred.exercises.leetcode.p1129;

import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 使用广度优先策略来访问，记录访问到当前节点的最小值，需要区分来源的边是 red 还是 blue
        int[][] shortestPath = new int[n][2];
        for (int i = 1; i < n; i++) {
            // 节点 0 默认是联通的，其他节点默认是不联通的
            shortestPath[i] = new int[]{-1, -1};
        }


        // 换算成邻接矩阵的方式以方便搜索, n 最大值为 100，因此设置数组大小为 100即可
        List<Integer>[] redAdj = new List[100];
        List<Integer>[] blueAdj = new List[100];
        for (int i = 0; i < 100; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }
        for (int[] redEdge : redEdges) {
            redAdj[redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            blueAdj[blueEdge[0]].add(blueEdge[1]);
        }

        // BFS 需要队列，需要两个队列还是一个队列呢？我感觉一个队列就行，先试试
        Set<Access> searched = new HashSet<>();
        Deque<Access> queue = new ArrayDeque<>();
        queue.offer(new Access(0, true, 0));
        queue.offer(new Access(0, false, 0));
        searched.add(new Access(0, true, 0));
        searched.add(new Access(0, false, 0));

        while (!queue.isEmpty()) {
            Access a = queue.poll();
            // 需要拿访问当前节点的路径颜色不同的相邻矩阵，即：路线需要红蓝交替
            List<Integer> adj = a.red ? blueAdj[a.node] : redAdj[a.node];
            for (Integer i : adj) {
                // 从蓝色访问 i, 路径加 1
                Access o = new Access(i, !a.red, a.seq + 1);
                if (searched.contains(o)) {
                    // 已经从蓝色访问过 i， 则跳过再次访问
                    continue;
                }
                queue.offer(o);
                searched.add(o);
                // 第一次访问则为最小值
                shortestPath[i][o.red ? 0 : 1] = a.seq + 1;
            }

        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int[] s = shortestPath[i];
            if (s[0] >= 0 && s[1] >= 0) {
                result[i] = Math.min(s[0], s[1]);
            } else {
                result[i] = s[0] < 0 ? s[1] : s[0];
            }
        }
        return result;
    }

    private static class Access {

        private int node;

        private boolean red;

        private int seq;

        Access(int node, boolean red, int seq) {
            this.node = node;
            this.red = red;
            this.seq = seq;
        }

        @Override
        public int hashCode() {
            return node;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Access)) {
                return false;
            }
            Access other = (Access) o;
            return this.node == other.node && this.red == other.red;
        }
    }
}
