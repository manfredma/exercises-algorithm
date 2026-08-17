package manfred.exercises.leetcode.solved.p0001to0100.p0010;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/regular-expression-matching/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution / Solution2：保留验证，确保不被破坏（应通过）
        Solution s1 = new Solution();
        assertFalse(s1.isMatch("a", ".*..a*"));
        assertFalse(s1.isMatch("ab", ".*c"));
        assertTrue(s1.isMatch("aab", "c*a*b*"));
        assertFalse(s1.isMatch("aa", "a"));
        assertTrue(s1.isMatch("aa", "a*"));
        assertTrue(s1.isMatch("ab", ".*"));
        assertFalse(s1.isMatch("mississippi", "mis*is*p*."));
        Solution2 s2 = new Solution2();
        assertFalse(s2.isMatch("a", ".*..a*"));
        assertFalse(s2.isMatch("ab", ".*c"));
        assertTrue(s2.isMatch("aab", "c*a*b*"));
        assertFalse(s2.isMatch("aa", "a"));
        assertTrue(s2.isMatch("aa", "a*"));
        assertTrue(s2.isMatch("ab", ".*"));
        assertFalse(s2.isMatch("mississippi", "mis*is*p*."));
        // 新解法 Solution3：再刷解法验证（已实现，标准二维 DP，含空串/嵌套 a*a 等边界）
        Solution3 s3 = new Solution3();
        assertFalse(s3.isMatch("aa", "a"));
        assertTrue(s3.isMatch("aa", "a*"));
        assertTrue(s3.isMatch("ab", ".*"));
        assertTrue(s3.isMatch("aab", "c*a*b"));
        assertFalse(s3.isMatch("mississippi", "mis*is*p*."));
        assertTrue(s3.isMatch("", ""));
        assertTrue(s3.isMatch("", "a*"));
        assertFalse(s3.isMatch("a", ""));
        assertTrue(s3.isMatch("a", "."));
        assertTrue(s3.isMatch("aaa", "a*a"));
        System.out.println("leet#0010 passed");
    }
}
