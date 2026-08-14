package manfred.exercises.leetcode.solved.p0201to0300.p0207;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表 —— 标准三色标记 DFS。
 *
 * <p>用一个 int 数组 color 表示节点状态，三种值对应三色：
 * <ul>
 *   <li>0（白）：未访问；</li>
 *   <li>1（灰）：正在访问（在当前递归栈中），遇之即环；</li>
 *   <li>2（黑）：子树已完整探过，无环，跳过展开。</li>
 * </ul>
 *
 * <p>相比 {@link Solution2}（两个 boolean 数组 stack/marked）与 {@link Solution3}
 * （Set + boolean），本版用单一 int 数组三值，是三色 DFS 的最标准写法，状态语义最清晰。
 *
 * <p>复杂度：时间 O(V+E)，空间 O(V+E)。
 */
class Solution5 {
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表：adjs[i] = i 的后继
        List<List<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjs.get(pre[0]).add(pre[1]);
        }

        int[] color = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == WHITE) {
                if (hasCycle(adjs, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjs, int[] color, int start) {
        // 进入节点：白→灰
        color[start] = GRAY;
        for (int next : adjs.get(start)) {
            if (color[next] == GRAY) {
                // 遇灰：当前递归路径上的节点，成环
                return true;
            }
            if (color[next] == WHITE) {
                // 白：继续深入
                if (hasCycle(adjs, color, next)) {
                    return true;
                }
            }
            // 黑：已完整探过，跳过（剪枝）
        }
        // 子树探完：灰→黑（回溯）
        color[start] = BLACK;
        return false;
    }
}
