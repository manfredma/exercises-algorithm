package manfred.exercises.leetcode.p0263;

/*
丑数就是只包含质因数 2、3 和 5 的正整数。
给你一个整数 n，请你判断 n 是否为丑数。如果是，返回 true；否则，返回 false。
*/
/**
 * LeetCode 第 263 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 6 → 期望 true
        System.out.println(solution.isUgly(6));
        // 示例 2: n = 1 → 期望 true
        System.out.println(solution.isUgly(1));
        // 示例 3: n = 14 → 期望 false
        System.out.println(solution.isUgly(14));
    }
}
