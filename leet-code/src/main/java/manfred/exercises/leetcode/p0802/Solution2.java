package manfred.exercises.leetcode.p0802;

import java.util.ArrayList;
import java.util.List;

/**
 * 三色 DFS 解法(带记忆化的环检测)。
 *
 * <p>用三色标记每个节点的状态:
 * <ul>
 *   <li>{@code 0} 未访问</li>
 *   <li>{@code 1} 访问中(在当前 DFS 栈上,疑似环上)</li>
 *   <li>{@code 2} 安全(已确认所有路径都不进环)</li>
 * </ul>
 *
 * <p>节点 i 安全 ⇔ i 的所有后继都安全。
 * DFS 一条路走到底:遇到已在栈上的节点(颜色 1)说明有环,该路不安全;
 * 走到安全节点(颜色 2)或终端节点(无后继)则本路安全。
 * 只有所有后继都安全,i 才标记 2;否则保持 1(不安全)。
 *
 * <p>记忆化:每个节点只判定一次,后续访问直接读颜色。
 *
 * <p>时间 O(V + E),空间 O(V + E)(递归栈 + 邻接表)。
 * 按节点编号升序遍历,结果天然升序,无需排序。
 */
class Solution2 {
    private static final int UNVISITED = 0;
    private static final int VISITING = 1;
    private static final int SAFE = 2;

    private int[] color;
    private int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        this.color = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(i)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    /** 节点 i 是否安全:所有后继都安全(且不在环上)。 */
    private boolean isSafe(int i) {
        if (color[i] > UNVISITED) {
            // 已判定:VISITING 表示当前栈上(发现环)→ 不安全;SAFE → 安全
            return color[i] == SAFE;
        }
        color[i] = VISITING;   // 入栈,标记"正在访问"
        for (int successor : graph[i]) {
            if (!isSafe(successor)) {
                // 后继不安全(或撞到环)→ 本节点也不安全,保持 VISITING
                return false;
            }
        }
        color[i] = SAFE;       // 所有后继都安全 → 本节点安全
        return true;
    }
}
