package manfred.exercises.leetcode.solved.p0201to0300.p0207;

import java.util.*;

/**
 * 课程表 —— DFS 检测环 + 剪枝（重刷实现）。
 *
 * <p>思路：对每个未访问节点做 DFS。inStackCourse 标记「当前递归路径」上的节点，
 * {@code add} 失败（已在本路径）即成环；visited 标记「子树已完整探过」的节点，
 * 命中则跳过展开（剪枝，避免重复 DFS）。回溯时从 inStackCourse 移除。
 *
 * <p>与 {@link Solution2} 同为三色 DFS：inStackCourse 相当于「灰」，visited 相当于「黑」。
 *
 * <p>复杂度：时间 O(V+E)，空间 O(V+E)。
 */
class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 转为邻接表
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjs.get(prerequisite[0]).add(prerequisite[1]);
        }

        // visited 标记子树已完整探过的节点（黑），跨轮次复用，避免重复 DFS
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }
            // inStackCourse 标记当前递归路径上的节点（灰），每轮 DFS 独立
            Set<Integer> inStackCourse = new HashSet<>();
            if (!canFinish(i, adjs, inStackCourse, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int start, List<List<Integer>> adjs, Set<Integer> inStackCourse, boolean[] visited) {
        // add 返回 false 表示 start 已在当前递归路径上 → 成环
        if (!inStackCourse.add(start)) {
            return false;
        }
        // 剪枝：子树已完整探过（黑），跳过展开
        if (!visited[start]) {
            for (Integer c : adjs.get(start)) {
                if (!canFinish(c, adjs, inStackCourse, visited)) {
                    return false;
                }
            }
            // 子树探完，标记完成（黑）
            visited[start] = true;
        }

        // 回溯：移出当前路径（灰→黑）
        inStackCourse.remove(start);
        return true;
    }
}
