/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0005;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/longest-palindromic-substring/ */

/**
 * LeetCode 第 5 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertLongestPalindrome("abcbcbc", solution.longestPalindrome("abcbcbc"), 5);
        assertLongestPalindrome("babad", solution.longestPalindrome("babad"), 3);
        assertLongestPalindrome("cbbd", solution.longestPalindrome("cbbd"), 2);

        Solution2 solution2 = new Solution2();
        assertLongestPalindrome("bb", solution2.longestPalindrome("bb"), 2);
        assertLongestPalindrome("abcbcbc", solution2.longestPalindrome("abcbcbc"), 5);
        assertLongestPalindrome("babad", solution2.longestPalindrome("babad"), 3);
        assertLongestPalindrome("cbbd", solution2.longestPalindrome("cbbd"), 2);

        Solution3 solution3 = new Solution3();
        assertLongestPalindrome("bb", solution3.longestPalindrome("bb"), 2);
        assertLongestPalindrome("abcbcbc", solution3.longestPalindrome("abcbcbc"), 5);
        assertLongestPalindrome("babad", solution3.longestPalindrome("babad"), 3);
        assertLongestPalindrome("cbbd", solution3.longestPalindrome("cbbd"), 2);
        System.out.println("p0005 passed");
    }

    /** 多解场景：仅校验结果长度、回文性质、是否为原串子串，不锁定具体字符串。 */
    private static void assertLongestPalindrome(String s, String result, int expectedLen) {
        assertEquals(expectedLen, result.length());
        assertTrue(isPalindrome(result), result + " should be a palindrome");
        assertTrue(s.indexOf(result) >= 0, result + " should be a substring of " + s);
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
