package manfred.exercises.leetcode.p0790;

/*
有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。

示例 1:
输入: n = 3
输出: 5

示例 2:
输入: n = 1
输出: 1
*/
/**
 * LeetCode 第 790 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 n = 3 → 期望 5
        System.out.println(solution.numTilings(3));
        // 示例 2: 输入 n = 1 → 期望 1
        System.out.println(solution.numTilings(1));
        // 示例 3: 输入 n = 4 → 期望 11
        System.out.println(solution.numTilings(4));

        // 回归：两解法在 n=1000 须一致且等于 979232805
        int n = 1000;
        int a = solution.numTilings(n);
        int b = new Solution2().numTilings(n);
        System.out.println("n=" + n + " Solution=" + a + " Solution2=" + b
                + (a == b && a == 979232805 ? " OK" : " FAIL"));
    }
}
