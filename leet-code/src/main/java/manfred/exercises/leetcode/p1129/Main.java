package manfred.exercises.leetcode.p1129;

import java.util.Arrays;

/*
给定有向图节点数 n（节点 0..n-1），每条边为红色或蓝色，可能有自环/平行边。
给定 redEdges（红色有向边）和 blueEdges（蓝色有向边）。
返回长度为 n 的数组 answer，answer[X] 是从节点 0 到 X 的"红蓝交替"最短路径长度；不存在则 -1。

示例 1: 输入 n=3, red_edges=[[0,1],[1,2]], blue_edges=[]  输出 [0,1,-1]
示例 2: 输入 n=3, red_edges=[[0,1]],        blue_edges=[[2,1]]  输出 [0,1,-1]
*/
/**
 * LeetCode 第 1129 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n=3, red=[[0,1],[1,2]], blue=[] → 期望 [0,1,-1]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(
                3, new int[][]{{0, 1}, {1, 2}}, new int[][]{})));
        // 示例 2: n=3, red=[[0,1]], blue=[[2,1]] → 期望 [0,1,-1]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(
                3, new int[][]{{0, 1}}, new int[][]{{2, 1}})));
    }
}
