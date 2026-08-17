/*
Given a string containing just the characters '(' and ')',
find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0032;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/longest-valid-parentheses/ */

/**
 * LeetCode 第 32 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // "()(()" 最长有效括号子串为开头的 "()"，长度 2
        assertEquals(2, solution.longestValidParentheses("()(()"));
        assertEquals(2, solution.longestValidParentheses("(()"));
        assertEquals(4, solution.longestValidParentheses(")()())"));
        System.out.println("p0032 passed");
    }
}
