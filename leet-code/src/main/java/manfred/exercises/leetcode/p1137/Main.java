package manfred.exercises.leetcode.p1137;

/*
泰波那契序列：T0=0, T1=1, T2=1, Tn+3 = Tn + Tn+1 + Tn+2（n >= 0）
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

示例 1：
输入：n = 4
输出：4

示例 2：
输入：n = 25
输出：1389537

提示：
- 0 <= n <= 37
- 答案保证是一个 32 位整数
*/
/**
 * LeetCode 第 1137 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 4 → 期望 4
        System.out.println(solution.tribonacci(4));
        // 示例 2: n = 25 → 期望 1389537
        System.out.println(solution.tribonacci(25));
    }
}
