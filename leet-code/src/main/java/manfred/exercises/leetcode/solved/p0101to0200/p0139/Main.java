/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0139;

/** 题目链接：https://leetcode.cn/problems/word-break/ */

import java.util.Arrays;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 139 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertTrue(solution.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        assertTrue(solution.wordBreak("applepenapple", Arrays.asList(new String[]{"apple", "pen"})));
        assertFalse(solution.wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));

        System.out.println("p0139 passed");
    }
}
