package manfred.exercises.leetcode.solved.p0701to0800.p0797;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution2 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> nodes = new ArrayDeque<>();
        Deque<Integer> nextIndexes = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();

        nodes.push(0);
        nextIndexes.push(0);
        path.add(0);

        int target = graph.length - 1;
        while (!nodes.isEmpty()) {
            int node = nodes.peek();
            if (node == target) {
                result.add(new ArrayList<>(path));
                nodes.pop();
                nextIndexes.pop();
                path.remove(path.size() - 1);
                continue;
            }

            int nextIndex = nextIndexes.pop();
            if (nextIndex == graph[node].length) {
                nodes.pop();
                path.remove(path.size() - 1);
                continue;
            }

            nextIndexes.push(nextIndex + 1);
            int next = graph[node][nextIndex];
            nodes.push(next);
            nextIndexes.push(0);
            path.add(next);
        }
        return result;
    }
}
