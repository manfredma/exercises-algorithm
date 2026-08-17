/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0014;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/longest-common-prefix/ */

/**
 * LeetCode 第 14 题「最长公共前缀」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println("p0014 passed");
    }
}
