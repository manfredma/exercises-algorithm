package manfred.exercises.leetcode.p1491;

import java.util.Arrays;

/*
给你一个整数数组 salary，数组里每个数都是唯一的，其中 salary[i] 是第 i 个员工的工资。
请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。

示例 1：
输入：salary = [4000,3000,1000,2000]
输出：2500.00000

示例 2：
输入：salary = [1000,2000,3000]
输出：2000.00000

示例 3：
输入：salary = [6000,5000,4000,3000,2000,1000]
输出：3500.00000

示例 4：
输入：salary = [8000,9000,2000,3000,6000,1000]
输出：4750.00000

提示：
- 3 <= salary.length <= 100
- 10^3 <= salary[i] <= 10^6
- salary[i] 是唯一的。
- 与真实值误差在 10^-5 以内的结果都将视为正确答案。
*/
/**
 * LeetCode 第 1491 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 [4000,3000,1000,2000] → 期望 2500.00000
        System.out.println(solution.average(new int[]{4000, 3001, 1000, 2000}));
        // 示例 2: 输入 [1000,2000,3000] → 期望 2000.00000
        System.out.println(solution.average(new int[]{1000, 2000, 3000}));
        // 示例 3: 输入 [6000,5000,4000,3000,2000,1000] → 期望 3500.00000
        System.out.println(solution.average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        // 示例 4: 输入 [8000,9000,2000,3000,6000,1000] → 期望 4750.00000
        System.out.println(solution.average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }
}
