/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0088;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/merge-sorted-array/ */

/**
 * LeetCode 第 88 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例: nums1=[1,2,3,0,0,0], m=3, nums2=[2,5,6], n=3 → [1,2,2,3,5,6]
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        // 边界: nums2 为空
        int[] nums2 = new int[]{1, 2, 3, 0};
        solution.merge(nums2, 3, new int[]{}, 0);
        assertArrayEquals(new int[]{1, 2, 3, 0}, nums2);

        // 边界: nums1 有效元素为空，仅拷贝 nums2
        int[] nums3 = new int[]{0, 0, 0};
        solution.merge(nums3, 0, new int[]{1, 2, 3}, 3);
        assertArrayEquals(new int[]{1, 2, 3}, nums3);

        System.out.println("p0088 passed");
    }
}
