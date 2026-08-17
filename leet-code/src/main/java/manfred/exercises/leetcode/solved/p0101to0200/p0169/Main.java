/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0169;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/majority-element/ */

/**
 * LeetCode 第 169 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1
        assertEquals(3, solution.majorityElement(new int[]{3, 2, 3}));
        // 题面示例 2
        assertEquals(2, solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println("p0169 passed");
    }
}
