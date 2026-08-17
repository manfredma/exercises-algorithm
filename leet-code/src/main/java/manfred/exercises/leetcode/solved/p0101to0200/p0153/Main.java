/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0153;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/ */

/**
 * LeetCode 第 153 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [3, 1, 2]: 最小值为 1（手算）
        assertEquals(1, solution.findMin(new int[]{3, 1, 2}));
        // 题面示例 1
        assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
        // 题面示例 2
        assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("p0153 passed");
    }
}
