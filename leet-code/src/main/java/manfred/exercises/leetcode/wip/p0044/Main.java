/*

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */
package manfred.exercises.leetcode.wip.p0044;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/wildcard-matching/ */

/**
 * LeetCode 第 44 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertTrue(solution.isMatch("ab", "a*b*"));
        assertTrue(solution.isMatch("c", "*?*"));
        assertFalse(solution.isMatch(
                "aaaaaabbaabaaaaabababbabbaababbaabaababaaaaabaaaabaaaabababbbabbbbaabbababbbbababbaaababbbabbbaaaaaaabbaabbbbababbabbaaabababaaaabaaabaaabbbbbabaaabbbaabbbbbbbaabaaababaaaababbbbbaabaaabbabaabbaabbaaaaba",
                "*bbb*a*abb*b*a*bbbbaab*b*aaba*a*b*a*abb*aa*b*bb*abbbb*b*bbbabaa*b*ba*a*ba*b*a*a*aaa"));
        assertTrue(solution.isMatch("abcd", "abc*d"));
        assertTrue(solution.isMatch("a", "a*"));
        assertFalse(solution.isMatch("mississippi", "m??*ss*?i*pi"));
        assertTrue(solution.isMatch("aaaa", "**a"));
        assertTrue(solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        assertTrue(solution.isMatch("adceb", "*a*b"));
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "*"));
        assertFalse(solution.isMatch("cb", "?a"));
        assertFalse(solution.isMatch("acdcb", "a*c?b"));
        System.out.println("p0044 all assertions passed");
    }
}
