package manfred.exercises.leetcode.p0326;

/*
给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true；否则，返回 false。
整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x。
*/
/**
 * LeetCode 第 326 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 27 → 期望 true
        System.out.println(solution.isPowerOfThree(27));
        // 示例 2: n = 0 → 期望 false
        System.out.println(solution.isPowerOfThree(0));
        // 示例 3: n = 9 → 期望 true
        System.out.println(solution.isPowerOfThree(9));
        // 示例 4: n = 45 → 期望 false
        System.out.println(solution.isPowerOfThree(45));
    }
}
