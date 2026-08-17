package manfred.exercises.leetcode.solved.p0701to0800.p0797;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/all-paths-from-source-to-target/ */

import java.util.Arrays;
import java.util.List;

/*
给你一个有 n 个节点的有向无环图（DAG），请你找出从节点 0 到节点 n - 1
的所有路径并输出（不要求按特定顺序）。

graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到 graph[i][j]
存在一条有向边）。

示例 1：

输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3

示例 2：

输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

提示：

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i（即不存在自环）
graph[i] 中的所有元素互不相同
保证输入为有向无环图（DAG）
*/
/** LeetCode 第 797 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(Arrays.asList(Arrays.asList(0, 1, 3), Arrays.asList(0, 2, 3)),
                solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        assertEquals(Arrays.asList(Arrays.asList(0, 4), Arrays.asList(0, 3, 4),
                        Arrays.asList(0, 1, 3, 4), Arrays.asList(0, 1, 2, 3, 4),
                        Arrays.asList(0, 1, 4)),
                solution.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }

}
