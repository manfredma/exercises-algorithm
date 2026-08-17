/*
Given an array with n objects colored red, white or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0075;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/sort-colors/ */

/**
 * LeetCode 第 75 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例: [2,0,2,1,1,0] → [0,0,1,1,2,2]
        int[] x = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(x);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, x);

        // 边界: 已排序输入应保持不变
        int[] y = new int[]{0, 0, 1, 1, 2, 2};
        solution.sortColors(y);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, y);

        // 边界: 单元素
        int[] z = new int[]{1};
        solution.sortColors(z);
        assertArrayEquals(new int[]{1}, z);

        System.out.println("p0075 passed");
    }
}
