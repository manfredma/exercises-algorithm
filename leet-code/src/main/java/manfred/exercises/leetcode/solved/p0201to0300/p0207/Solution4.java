package manfred.exercises.leetcode.solved.p0201to0300.p0207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 课程表 —— 拓扑排序（Kahn 算法，入度数组 + 队列 BFS）。
 *
 * <p>思路：统计每个节点的入度，将入度为 0 的节点入队。每次出队一个节点，
 * 把它的所有后继入度 -1，入度归 0 则入队。最终已出队节点数 == numCourses 则无环。
 *
 * <p>相比 {@link Solution} 的朴素 Kahn（每轮全量扫描找入度 0 节点，O(V×E)），
 * 用入度数组 + 队列把找 0 入度节点降到 O(1)，整体 O(V+E)。
 *
 * <p>复杂度：时间 O(V+E)，空间 O(V+E)。
 */
class Solution4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数组：indegree[i] = 课程 i 的先修数量
        int[] indegree = new int[numCourses];
        // 邻接表：adjs[i] = 以 i 为先修的课程（i 的后继）
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            // pre = [a, b]：学 a 需先学 b → b 是 a 的先修，a 是 b 的后继
            adjs.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        // 入度为 0 的课程入队（无先修，可直接修）
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 逐个出队，后继入度 -1，归 0 则入队
        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished++;
            for (int next : adjs.get(course)) {
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 全部课程都能修完则无环
        return finished == numCourses;
    }
}
