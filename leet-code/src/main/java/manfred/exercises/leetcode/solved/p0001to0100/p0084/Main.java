package manfred.exercises.leetcode.solved.p0001to0100.p0084;

/** 题目链接：https://leetcode.cn/problems/largest-rectangle-in-histogram/ */

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

示例 1：

输入：heights = [2,1,5,6,2,3]
输出：10

示例 2：

输入：heights = [2,4]
输出：4
*/
/**
 * LeetCode 第 84 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: heights = [2,1,5,6,2,3] → 期望 10
        assertAllSolutions(solution, solution2, solution3, 10, new int[]{2, 1, 5, 6, 2, 3});
        // 示例 2: heights = [2,4] → 期望 4
        assertAllSolutions(solution, solution2, solution3, 4, new int[]{2, 4});
        // 边界: 单根柱子 → 期望自身高度
        assertAllSolutions(solution, solution2, solution3, 7, new int[]{7});
        // 边界: 全部等高 → 期望 高度 × 长度
        assertAllSolutions(solution, solution2, solution3, 12, new int[]{3, 3, 3, 3});
        // 边界: 含 0 → 期望 4
        assertAllSolutions(solution, solution2, solution3, 4, new int[]{2, 0, 4});
        // 递增序列: 最优矩形不从首柱开始 → 期望 9
        assertAllSolutions(solution, solution2, solution3, 9, new int[]{1, 2, 3, 4, 5});
        // 递减序列: 每次弹栈均需正确计算宽度 → 期望 9
        assertAllSolutions(solution, solution2, solution3, 9, new int[]{5, 4, 3, 2, 1});
        // 局部并列高度: 最优矩形跨越全部柱子 → 期望 5
        assertAllSolutions(solution, solution2, solution3, 5, new int[]{2, 2, 1, 2, 2});
    }

    private static void assertAllSolutions(Solution solution, Solution2 solution2, Solution3 solution3,
                                           int expected, int[] heights) {
        assertEquals(expected, solution.largestRectangleArea(heights));
        assertEquals(expected, solution2.largestRectangleArea(heights));
        assertEquals(expected, solution3.largestRectangleArea(heights));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
