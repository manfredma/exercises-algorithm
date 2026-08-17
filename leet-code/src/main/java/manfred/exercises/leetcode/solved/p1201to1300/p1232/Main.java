package manfred.exercises.leetcode.solved.p1201to1300.p1232;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/check-if-it-is-a-straight-line/ */

/*
给定一个整数数组 coordinates ，其中 coordinates[i] = [x, y] ，[x, y] 表示横坐标为 x、纵坐标为 y 的点。
请你来判断，这些点是否在该坐标系中属于同一条直线上。

示例 1：

输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
输出：true

示例 2：

输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
输出：false

提示：

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates 中不含重复的点
*/
/**
 * LeetCode 第 1232 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] → 期望 true
        assertTrue(solution.checkStraightLine(
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        // 示例 2: [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] → 期望 false
        assertFalse(solution.checkStraightLine(
                new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println("passed");
    }
}
