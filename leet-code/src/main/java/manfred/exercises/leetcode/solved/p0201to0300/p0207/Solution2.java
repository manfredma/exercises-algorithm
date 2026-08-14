package manfred.exercises.leetcode.solved.p0201to0300.p0207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程表 —— 三色标记 DFS 检测环。
 *
 * <p>思路：对每个未访问节点做 DFS。stack（灰）标记「当前递归栈中」的节点，遇灰则成环；
 * marked（黑）标记「子树已完整探过」的节点，跳过避免重复。回溯时 stack[start]=false。
 *
 * <p>注意：早期版本有 {@code prerequisites.length < 2} 过早返回 true，漏判自环，已移除。
 * 与 {@link Solution3} 同为 DFS 判环，此版用两个 boolean 数组（stack/marked），
 * Solution3 用 Set + visited，写法不同本质相同。
 *
 * <p>复杂度：时间 O(V+E)，空间 O(V+E)。
 */
class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] stack = new boolean[numCourses];
        boolean[] marked = new boolean[numCourses];
        Map<Integer, List<int[]>> edgeFromI = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            edgeFromI.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edgeFromI.get(prerequisites[i][0]).add(prerequisites[i]);
        }
        return !existsCycle(edgeFromI, marked, stack);
    }

    private boolean existsCycle(Map<Integer, List<int[]>> edgeFromI, boolean[] marked, boolean[] stack) {
        for (int i = 0; i < marked.length; i++) {
            // 节点没有被check过
            if (!marked[i]) {
                if (existsCycle(edgeFromI, marked, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existsCycle(Map<Integer, List<int[]>> edgeFromI, boolean[] marked, boolean[] stack, int start) {
        if (stack[start]) {
            return true;
        }
        marked[start] = true;
        stack[start] = true;

        List<int[]> edges = edgeFromI.get(start);
        for (int[] edge : edges) {
            if (existsCycle(edgeFromI, marked, stack, edge[1])) {
                return true;
            }
        }
        stack[start] = false;
        return false;
    }
}