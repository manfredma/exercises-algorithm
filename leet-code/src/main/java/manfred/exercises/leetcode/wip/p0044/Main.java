package manfred.exercises.leetcode.wip.p0044;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/wildcard-matching/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
        Solution s1 = new Solution();
        assertTrue(s1.isMatch("ab", "a*b*"));
        assertTrue(s1.isMatch("c", "*?*"));
        assertFalse(s1.isMatch(
                "aaaaaabbaabaaaaabababbabbaababbaabaababaaaaabaaaabaaaabababbbabbbbaabbababbbbababbaaababbbabbbaaaaaaabbaabbbbababbabbaaabababaaaabaaabaaabbbbbabaaabbbaabbbbbbbaabaaababaaaababbbbbaabaaabbabaabbaabbaaaaba",
                "*bbb*a*abb*b*a*bbbbaab*b*aaba*a*b*a*abb*aa*b*bb*abbbb*b*bbbabaa*b*ba*a*ba*b*a*a*aaa"));
        assertTrue(s1.isMatch("abcd", "abc*d"));
        assertTrue(s1.isMatch("a", "a*"));
        assertFalse(s1.isMatch("mississippi", "m??*ss*?i*pi"));
        assertTrue(s1.isMatch("aaaa", "**a"));
        assertTrue(s1.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        assertTrue(s1.isMatch("adceb", "*a*b"));
        assertFalse(s1.isMatch("aa", "a"));
        assertTrue(s1.isMatch("aa", "*"));
        assertFalse(s1.isMatch("cb", "?a"));
        assertFalse(s1.isMatch("acdcb", "a*c?b"));
        // 新解法 Solution2：新增验证，骨架占位下 RED，待实现后通过
        Solution2 s2 = new Solution2();
        assertFalse(s2.isMatch("aa", "a"));
        assertTrue(s2.isMatch("aa", "*"));
        assertFalse(s2.isMatch("cb", "?a"));
        assertTrue(s2.isMatch("adceb", "*a*b"));
        assertFalse(s2.isMatch("acdcb", "a*c?b"));
        // 边界：空串 / 空模式 / 单字符 / 问号
        assertTrue(s2.isMatch("", ""));
        assertTrue(s2.isMatch("", "*"));
        assertFalse(s2.isMatch("a", ""));
        assertTrue(s2.isMatch("a", "?"));
        assertTrue(s2.isMatch("ab", "a*b"));
        System.out.println("leet#0044 passed");
    }
}
