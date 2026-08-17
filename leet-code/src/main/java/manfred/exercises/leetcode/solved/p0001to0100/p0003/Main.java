/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0003;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/ */

/**
 * LeetCode 第 3 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        // "abba" 最长无重复子串为 "ab"/"ba"，长度为 2
        assertEquals(2, solution.lengthOfLongestSubstring("abba"));
        System.out.println("p0003 passed");
    }
}
