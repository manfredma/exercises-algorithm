/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0028;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/ */

/**
 * LeetCode 第 28 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: "hello" 中找 "ll" → 2
        assertEquals(2, solution.strStr("hello", "ll"));
        // 示例 2: "aaaaa" 中找 "bba" → -1
        assertEquals(-1, solution.strStr("aaaaa", "bba"));
        // 空 needle → 0
        assertEquals(0, solution.strStr("hello", ""));
        // haystack 与 needle 相同 → 0
        assertEquals(0, solution.strStr("abc", "abc"));
        // needle 未出现 → -1
        assertEquals(-1, solution.strStr("abc", "abcd"));
        System.out.println("p0028 passed");
    }
}
