/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

示例 2:
输入: nums = [0]
输出: [0]

提示:
- 1 <= nums.length <= 10^4
- -2^31 <= nums[i] <= 2^31 - 1

进阶：你能尽量减少完成的操作次数吗？
*/
package manfred.exercises.leetcode.solved.p0201to0300.p0283;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/move-zeroes/ */

/**
 * LeetCode 第 283 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        // 示例 1: 题面 Output
        assertEquals(new int[]{1, 3, 12, 0, 0}, nums1);

        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        // 示例 2: 题面 Output
        assertEquals(new int[]{0}, nums2);
        System.out.println("p0283 passed");
    }
}
