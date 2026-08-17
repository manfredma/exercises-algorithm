/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0132;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/palindrome-partitioning-ii/ */

/**
 * LeetCode 第 132 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(1, solution.minCut("aab"));
        assertEquals(4, solution.minCut("abcde"));
        assertEquals(0, solution.minCut("aa"));

        System.out.println("p0132 passed");
    }
}
