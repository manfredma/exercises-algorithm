package manfred.exercises.leetcode.p0802;

/*
有一个有 n 个节点的有向图，节点按 0 到 n - 1 编号。
图由一个索引从 0 开始的 2D 整数数组 graph 表示，
graph[i] 是与节点 i 相邻的节点的整数数组，意味着从节点 i 到节点 graph[i][j] 存在一条有向边。
如果一个节点没有连出的有向边，则它是终端节点。
如果从该节点开始的所有可能路径都通向终端节点，则该节点为安全节点。
返回一个由图中所有安全节点组成的数组作为答案。答案数组中的元素应当按升序排列。
*/
/**
 * LeetCode 第 802 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: graph = [[1,2],[2,3],[5],[0],[5],[],[]] → 期望 [2,4,5,6]
        System.out.println(solution.eventualSafeNodes(
                new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
        // 示例 2: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]] → 期望 [4]
        System.out.println(solution.eventualSafeNodes(
                new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
    }
}
