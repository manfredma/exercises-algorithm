package manfred.exercises.leetcode.p0436;

import java.util.Arrays;

/*
给你一个区间数组 intervals，其中 intervals[i] = [starti, endi]，且每个 starti 都不同。
区间 i 的右侧区间是满足 startj >= endi 且 startj 最小的区间 j（i 可能等于 j）。
返回每个区间 i 对应的右侧区间下标组成的数组，不存在则为 -1。

示例 1:
输入：intervals = [[1,2]]
输出：[-1]

示例 2:
输入：intervals = [[3,4],[2,3],[1,2]]
输出：[-1,0,1]

示例 3:
输入：intervals = [[1,4],[2,3],[3,4]]
输出：[-1,2,-1]
*/
/**
 * LeetCode 第 436 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 intervals = [[1,2]] → 期望 [-1]
        System.out.println(Arrays.toString(solution.findRightInterval(
                new int[][]{{1, 2}})));
        // 示例 2: 输入 intervals = [[3,4],[2,3],[1,2]] → 期望 [-1,0,1]
        System.out.println(Arrays.toString(solution.findRightInterval(
                new int[][]{{3, 4}, {2, 3}, {1, 2}})));
        // 示例 3: 输入 intervals = [[1,4],[2,3],[3,4]] → 期望 [-1,2,-1]
        System.out.println(Arrays.toString(solution.findRightInterval(
                new int[][]{{1, 4}, {2, 3}, {3, 4}})));
    }
}
