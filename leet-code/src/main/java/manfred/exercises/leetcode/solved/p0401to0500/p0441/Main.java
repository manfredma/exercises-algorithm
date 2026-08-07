package manfred.exercises.leetcode.solved.p0401to0500.p0441;

/*
你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，
其第 i 行必须正好有 i 枚硬币。阶梯的最后一行可能是不完整的。

给你一个数字 n，计算并返回可形成完整阶梯行的总行数。

示例 1：

输入：n = 5
输出：2
解释：因为第三行不完整，所以返回 2 。

示例 2：

输入：n = 8
输出：3
解释：因为第四行不完整，所以返回 3 。

提示：

1 <= n <= 2^31 - 1
*/
/** LeetCode 第 441 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(2, solution.arrangeCoins(5));
        assertEquals(3, solution.arrangeCoins(8));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
