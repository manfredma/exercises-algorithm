package manfred.exercises.leetcode.solved.p1101to1200.p1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 使用 Tarjan 来求桥
        int[] dfn = new int[n];
        AtomicInteger seq = new AtomicInteger(0);
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        // 将 connection 转为邻接矩阵
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        dfs(0, -1, dfn, low, seq, bridges, adj);
        return bridges;
    }

    private void dfs(int node, int parent, int[] dfn, int[] low, AtomicInteger seq, List<List<Integer>> bridges, List<List<Integer>> adj) {
        dfn[node] = low[node] = seq.addAndGet(1);
        List<Integer> subs = adj.get(node);
        for (Integer sub : subs) {
            if (sub == parent) {
                // 无向图，同一条边会存在两份，防止再探寻一次！
                continue;
            }
            // dfn 的初始值为 0，为 0 说明没有探寻过该节点
            if (dfn[sub] == 0) {
                dfs(sub, node, dfn, low, seq, bridges, adj);
                // 探寻完成之后，需要尝试更新当前的 low 值
                low[node] = Math.min(low[node], low[sub]);
                if (low[sub] > dfn[node]) {
                    bridges.add(Arrays.asList(node, sub));
                }
            } else {
                // 说明碰到了回边，注意记录
                low[node] = Math.min(low[node], dfn[sub]);
            }
        }
    }
}
