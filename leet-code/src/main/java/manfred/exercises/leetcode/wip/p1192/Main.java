package manfred.exercises.leetcode.wip.p1192;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。它们之间以 服务器到服务器 的形式相互连接组成了一个内部集群，连接是无向的。用 connections 表示集群网络，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。

关键连接 是在该集群中的重要连接，假如我们将它移除，便会导致某些服务器无法访问其他服务器。

请你以任意顺序返回该集群内的所有 关键连接 。

示例 1：

输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
输出：[[1,3]]
解释：[[3,1]] 也是正确的。

示例 2:

输入：n = 2, connections = [[0,1]]
输出：[[0,1]]

提示：

2 <= n <= 10^5
n - 1 <= connections.length <= 10^5
0 <= ai, bi <= n - 1
ai != bi
不存在重复的连接
*/
/** LeetCode 第 1192 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEdgeListsEquals(Arrays.asList(Arrays.asList(1, 3)), solution.criticalConnections(4,
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2),
                        Arrays.asList(2, 0), Arrays.asList(1, 3))));
        assertEdgeListsEquals(Arrays.asList(Arrays.asList(0, 1)), solution.criticalConnections(2,
                Arrays.asList(Arrays.asList(0, 1))));
    }

    private static void assertEdgeListsEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (!normalizeEdges(expected).equals(normalizeEdges(actual))) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }

    private static Set<String> normalizeEdges(List<List<Integer>> edges) {
        Set<String> normalized = new HashSet<>();
        for (List<Integer> edge : edges) {
            int from = Math.min(edge.get(0), edge.get(1));
            int to = Math.max(edge.get(0), edge.get(1));
            normalized.add(from + "-" + to);
        }
        return normalized;
    }
}
