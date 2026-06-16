package manfred.exercises.leetcode.p0739;

import java.util.Arrays;

/*
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i
天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1：
输入：temperatures = [73,74,75,71,69,72,76,73]
输出：[1,1,4,2,1,1,0,0]

示例 2：
输入：temperatures = [30,40,50,60]
输出：[1,1,1,0]

示例 3：
输入：temperatures = [30,60,90]
输出：[1,1,0]

提示：
1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100
*/

/**
 * LeetCode 第 739 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 示例 1: temperatures = [73,74,75,71,69,72,76,73] → 期望 [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        // 示例 2: temperatures = [30,40,50,60] → 期望 [1,1,1,0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 40, 50, 60})));
        // 示例 3: temperatures = [30,60,90] → 期望 [1,1,0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 60, 90})));
    }
}
