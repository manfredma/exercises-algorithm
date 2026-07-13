package manfred.exercises.leetcode.p0258;

/*
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
*/
/**
 * LeetCode 第 258 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: num = 38 → 期望 2
        System.out.println(solution.addDigits(38));
        // 示例 2: num = 0 → 期望 0
        System.out.println(solution.addDigits(0));
    }
}
