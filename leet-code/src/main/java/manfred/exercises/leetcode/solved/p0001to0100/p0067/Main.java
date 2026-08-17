/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0067;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/add-binary/ */

/**
 * LeetCode 第 67 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1：11 + 1 = 100
        assertEquals("100", solution.addBinary("11", "1"));
        // 题面示例 2：1010 + 1011 = 10101
        assertEquals("10101", solution.addBinary("1010", "1011"));
        System.out.println("passed");
    }
}
