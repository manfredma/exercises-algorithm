package manfred.exercises.leetcode.p0797;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        findAllPath(graph, 0, graph.length - 1, result, curPath);
        return result;
    }

    private void findAllPath(int[][] graph, int from, int target, List<List<Integer>> paths, List<Integer> curPath) {
        curPath.add(from);
        if (from == target) {
            // 说明已经查询到，则记录下来
            paths.add(new ArrayList<>(curPath));
            // 移除当前元素
            curPath.remove(curPath.size() - 1);
            return;
        }
        int[] nexts = graph[from];
        for (int next : nexts) {
            findAllPath(graph, next, target, paths, curPath);
        }
        // 移除当前路径
        curPath.remove(curPath.size() - 1);
    }
}
