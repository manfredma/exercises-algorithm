/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0125;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/valid-palindrome/ */

/**
 * LeetCode 第 125 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(solution.isPalindrome("race a car"));

        System.out.println("p0125 passed");
    }
}
