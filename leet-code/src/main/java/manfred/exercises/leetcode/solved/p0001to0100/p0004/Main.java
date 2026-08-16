package manfred.exercises.leetcode.solved.p0001to0100.p0004;

/** 题目链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/ */

/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数。

算法的时间复杂度应该为 O(log (m+n))。

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000

示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000

提示：

0 <= m <= 1000

0 <= n <= 1000

1 <= m + n <= 2000

-10^6 <= nums1[i], nums2[i] <= 10^6
*/
/**
 * LeetCode 第 4 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        // 示例 1: nums1 = [1,3], nums2 = [2] → 期望 2.0
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.0, solution2.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        // 示例 2: nums1 = [1,2], nums2 = [3,4] → 期望 2.5
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        assertEquals(2.5, solution2.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        // 边界: nums1 为空 → 期望 1.0
        assertEquals(1.0, solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        assertEquals(1.0, solution2.findMedianSortedArrays(new int[]{}, new int[]{1}));
        // 边界: nums2 为空，单元素 → 期望 2.0
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
        assertEquals(2.0, solution2.findMedianSortedArrays(new int[]{2}, new int[]{}));
        // 边界: nums2 为空，偶数个 → 期望 2.5
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 4}, new int[]{}));
        assertEquals(2.5, solution2.findMedianSortedArrays(new int[]{1, 4}, new int[]{}));
        // 边界: 一个全部小于另一个，合并后偶数个 → 期望 3.5
        assertEquals(3.5, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5, 6}));
        assertEquals(3.5, solution2.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5, 6}));
    }

    private static void assertEquals(double expected, double actual) {
        if (Math.abs(expected - actual) > 1e-5) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
