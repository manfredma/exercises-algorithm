package manfred.exercises.leetcode.p0452;

/*
有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
其中 points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend 之间的气球。

一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的
开始和结束坐标为 xstart，xend，且满足 xstart ≤ x ≤ xend，则该气球会被引爆。

给你一个数组 points ，返回引爆所有气球所必须射出的最小弓箭数。

示例 1：
输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2

示例 2：
输入：points = [[1,2],[3,4],[5,6],[7,8]]
输出：4

示例 3：
输入：points = [[1,2],[2,3],[3,4],[4,5]]
输出：2

提示：
- 1 <= points.length <= 10^5
- points[i].length == 2
- -2^31 <= xstart < xend <= 2^31 - 1
*/
/**
 * LeetCode 第 452 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: points = [[10,16],[2,8],[1,6],[7,12]] → 期望 2
        System.out.println(solution.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        // 示例 2: points = [[1,2],[3,4],[5,6],[7,8]] → 期望 4
        System.out.println(solution.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        // 示例 3: points = [[1,2],[2,3],[3,4],[4,5]] → 期望 2
        System.out.println(solution.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }
}
