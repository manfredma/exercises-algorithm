package manfred.exercises.leetcode.p0802;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 反向图 + 拓扑排序解法。
 *
 * <p>核心洞察:节点 i 安全 ⇔ i 的所有后继都安全。
 * 这是「不动点」关系,适合用拓扑排序从「已确定安全」的节点向外传播。
 *
 * <p>终端节点(原图出度 0)没有后继,vacuously 安全,作为拓扑种子。
 * 每剥离一个安全节点 n,它在反向图中的前驱 v 的「未确定出边」减一;
 * 当 v 的出度归零,说明 v 所有后继都已安全 → v 安全,入队。
 *
 * <p>用「原图出度」充当拓扑里的「入度」(方向反过来),这是与 210 课程表
 * (入度驱动、正向拓扑)的对偶。
 *
 * <p>时间 O(V + E),空间 O(V + E)。
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // reverseGraph[v] = 原图中以 v 为后继的节点集合,即 v 的所有前驱
        List<Integer>[] reverseGraph = new List[n];
        for (int i = 0; i < n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        // outDegree[i] = 原图节点 i 的出度(= 反向图入度)
        int[] outDegree = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            outDegree[i] = graph[i].length;
            // 出度为 0 的终端节点是安全种子(必存在,否则全图有环,返回空集)
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
            for (int successor : graph[i]) {
                reverseGraph[successor].add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        // Kahn 剥离:每弹出一个安全节点,其前驱的待定出边 -1,归零即安全
        while (!queue.isEmpty()) {
            int safe = queue.poll();
            safeNodes.add(safe);
            for (int predecessor : reverseGraph[safe]) {
                if (--outDegree[predecessor] == 0) {
                    queue.offer(predecessor);
                }
            }
        }

        // 题目要求升序;拓扑得到的顺序并非天然升序,需排序
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
