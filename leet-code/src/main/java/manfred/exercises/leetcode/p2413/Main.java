package manfred.exercises.leetcode.p2413;

/*
给你一个正整数 n，返回 2 和 n 的最小公倍数(正整数)。
*/
/**
 * LeetCode 第 2413 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 5 → 期望 10
        System.out.println(solution.smallestEvenMultiple(5));
        // 示例 2: n = 6 → 期望 6
        System.out.println(solution.smallestEvenMultiple(6));
    }
}
