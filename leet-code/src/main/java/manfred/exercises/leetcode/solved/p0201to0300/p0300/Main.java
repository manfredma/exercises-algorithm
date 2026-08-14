package manfred.exercises.leetcode.solved.p0201to0300.p0300;

/** 题目链接：https://leetcode.cn/problems/longest-increasing-subsequence/ */

/*
给你一个整数数组 nums，找到其中最长严格递增子序列的长度。

示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4

示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1
*/
/**
 * LeetCode 第 300 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        Solution4 solution4 = new Solution4();
        // 示例 1: nums = [10,9,2,5,3,7,101,18] → 期望 4
        assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, solution2.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, solution3.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, solution4.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // 示例 2: nums = [0,1,0,3,2,3] → 期望 4
        assertEquals(4, solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(4, solution2.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(4, solution3.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(4, solution4.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        // 示例 3: nums = [7,7,7,7,7,7,7] → 期望 1（严格递增，等值不算）
        assertEquals(1, solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        assertEquals(1, solution2.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        assertEquals(1, solution3.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        assertEquals(1, solution4.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        // 边界: 单元素 → 期望 1
        assertEquals(1, solution.lengthOfLIS(new int[]{5}));
        assertEquals(1, solution2.lengthOfLIS(new int[]{5}));
        assertEquals(1, solution3.lengthOfLIS(new int[]{5}));
        assertEquals(1, solution4.lengthOfLIS(new int[]{5}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
