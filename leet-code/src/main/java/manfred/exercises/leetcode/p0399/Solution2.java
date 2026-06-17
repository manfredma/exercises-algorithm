package manfred.exercises.leetcode.p0399;

import java.util.*;

class Solution2 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph);
        }
        return result;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / values[i]);
        }
        return graph;
    }

    private double bfs(String src, String dst, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(src) || !graph.containsKey(dst)) {
            return -1.0;
        }
        if (src.equals(dst)) {
            return 1.0;
        }

        Set<String> visited = new HashSet<>();
        // 队列元素：[节点, 到该节点的累计乘积]
        Queue<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[]{src, 1.0});
        visited.add(src);

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            String node = (String) curr[0];
            double product = (double) curr[1];
            for (Map.Entry<String, Double> e : graph.get(node).entrySet()) {
                double nextProduct = product * e.getValue();
                if (e.getKey().equals(dst)) {
                    return nextProduct;
                }
                if (visited.add(e.getKey())) {
                    queue.offer(new Object[]{e.getKey(), nextProduct});
                }
            }
        }
        return -1.0;
    }
}
