/*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0164;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/maximum-gap/ */

/**
 * LeetCode 第 164 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [1,1,1,1]：所有元素相同，最大间距为 0（手算）
        assertEquals(0, solution.maximumGap(new int[]{1, 1, 1, 1}));
        // [1,1,1,1,1,5,5,5,5,5]：排序后 1→5 处最大间距 4（运行输出，手算确认）
        assertEquals(4, solution.maximumGap(new int[]{1, 1, 1, 1, 1, 5, 5, 5, 5, 5}));
        // 题面示例 1
        assertEquals(3, solution.maximumGap(new int[]{3, 6, 9, 1}));
        // 题面示例 2
        assertEquals(0, solution.maximumGap(new int[]{10}));
        System.out.println("p0164 passed");
    }
}
