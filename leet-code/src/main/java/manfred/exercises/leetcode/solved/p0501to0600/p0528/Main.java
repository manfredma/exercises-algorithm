package manfred.exercises.leetcode.solved.p0501to0600.p0528;

/** 题目链接：https://leetcode.cn/problems/random-pick-with-weight/ */

/*
给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。

请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。

例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。

示例 1：

输入：
["Solution","pickIndex"]
[[[1]],[]]
输出：
[null,0]
解释：
Solution solution = new Solution([1]);
solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。

示例 2：

输入：
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
输出：
[null,1,1,1,1,0]
解释：随机题允许多个输出；每次返回的下标都必须位于 [0, 1]。

提示：

1 <= w.length <= 10^4

1 <= w[i] <= 10^5

pickIndex 将被调用不超过 10^4 次
*/
/** LeetCode 第 528 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution single = new Solution(new int[]{1});
        assertEquals(0, single.pickIndex());

        Solution weighted = new Solution(new int[]{1, 3});
        for (int i = 0; i < 5; i++) {
            assertInRange(weighted.pickIndex(), 0, 1);
        }
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }

    private static void assertInRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new AssertionError("expected range: [" + min + ", " + max + "], actual: " + value);
        }
    }
}
