package manfred.exercises.leetcode.p0978;

/**
 * LeetCode 第 978 题（最长湍流子数组）的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(solution.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(solution.maxTurbulenceSize(new int[]{100}));
    }
}
