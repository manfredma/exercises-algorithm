package manfred.exercises.leetcode.p2235;

/*
给你两个整数 num1 和 num2，返回这两个整数的和。
*/
/**
 * LeetCode 第 2235 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: num1 = 12, num2 = 5 → 期望 17
        System.out.println(solution.sum(12, 5));
        // 示例 2: num1 = -10, num2 = 4 → 期望 -6
        System.out.println(solution.sum(-10, 4));
    }
}
