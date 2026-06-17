package manfred.exercises.leetcode.p0399;

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构造邻接矩阵
        Map<String, Map<String, Double>> adj = constructAdj(equations, values);

        // 使用 BFS 来查找路径
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adj);
        }
        return result;
    }

    private Map<String, Map<String, Double>> constructAdj(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            // 插入邻接指针
            Map<String, Double> value = adj.getOrDefault(equations.get(i).get(0), new HashMap<>());
            value.put(equations.get(i).get(1), values[i]);
            adj.put(equations.get(i).get(0), value);

            // 再插入一个反向的、权重为倒数（a/b 变为 b/a）的邻接指针
            Map<String, Double> reverseValue = adj.getOrDefault(equations.get(i).get(1), new HashMap<>());
            reverseValue.put(equations.get(i).get(0), 1.0 / values[i]);
            adj.put(equations.get(i).get(1), reverseValue);
        }
        return adj;
    }

    private Double bfs(String s, String t, Map<String, Map<String, Double>> adj) {
        if (!adj.containsKey(s)) {
            return -1.0;
        }
        if (s.equals(t)) {
            return 1.0;
        }
        Set<String> visited = new HashSet<>();
        Map<String, String> prev = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.add(s);
        while (!queue.isEmpty()) {
            String w = queue.poll();
            for (String q : adj.get(w).keySet()) {
                if (!visited.contains(q)) {
                    prev.put(q, w);
                    if (q.equals(t)) {
                        // 找到了目标，开始根据路径计算数值是多少
                        return calcProduct(adj, prev, s, t);
                    }
                    visited.add(q);
                    queue.add(q);
                }
            }
        }
        return -1.0;
    }

    private Double calcProduct(Map<String, Map<String, Double>> adj, Map<String, String> prev, String s, String t) {
        if (s.equals(t)) {
            return 1.0;
        }
        String from2t = prev.get(t);
        return adj.get(from2t).get(t) * calcProduct(adj, prev, s, prev.get(t));
    }
}