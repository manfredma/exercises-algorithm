package manfred.exercises.leetcode.p0509;

/*
斐波那契数列由 0 和 1 开始，后面每项是前两项之和：
F(0) = 0，F(1) = 1，F(n) = F(n-1) + F(n-2)（n > 1）

给定 n，请计算 F(n)。

示例 1：
输入：n = 2
输出：1

示例 2：
输入：n = 3
输出：2

示例 3：
输入：n = 4
输出：3

提示：0 <= n <= 30
*/
/**
 * LeetCode 第 509 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 2 → 期望 1
        System.out.println(solution.fib(2));
        // 示例 2: n = 3 → 期望 2
        System.out.println(solution.fib(3));
        // 示例 3: n = 4 → 期望 3
        System.out.println(solution.fib(4));
    }
}
