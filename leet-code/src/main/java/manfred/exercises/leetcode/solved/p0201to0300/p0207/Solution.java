package manfred.exercises.leetcode.solved.p0201to0300.p0207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 课程表 —— 拓扑排序（Kahn 朴素删边法）。
 *
 * <p>思路：反复找出「无入度」的课程（无先修依赖），移除它及其出边；
 * 若能移除全部课程则无环（可完成），否则存在环。用邻接表记录每个课程的「被依赖」关系。
 *
 * <p>注意：早期版本有 {@code prerequisites.length < 2} 时直接返回 true 的过早返回，
 * 会漏判自环（如 [[0,0]] 只 1 条边却成环）。已移除该优化，统一走环检测。
 *
 * <p>复杂度：时间 O(V×E)（每轮全量扫描找入度为 0 的节点），空间 O(V+E)。
 * 不如入度数组 + 队列的标准 Kahn（见 {@link Solution4}）高效。
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> depends = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] depend = prerequisites[i];
            depends.putIfAbsent(depend[1], new HashSet<>());
            depends.get(depend[1]).add(depend[0]);
        }
        // 没有依赖的对象也需要放入进去，方便判断
        for (int i = 0; i < numCourses; i++) {
            depends.putIfAbsent(i, new HashSet<>());
        }

        while (!depends.isEmpty()) {
            int course = -1;
            for (Map.Entry<Integer, Set<Integer>> dependEntry : depends.entrySet()) {
                Set<Integer> depended = dependEntry.getValue();
                // 说明已经没有前置依赖课程了
                if (depended.isEmpty()) {
                    course = dependEntry.getKey();
                }
            }

            if (course != -1) {
                depends.remove(course);
                for (Map.Entry<Integer, Set<Integer>> dependEntry : depends.entrySet()) {
                    dependEntry.getValue().remove(course);
                }
            } else {
                // 出现环路
                return false;
            }
        }
        return true;
    }
}
