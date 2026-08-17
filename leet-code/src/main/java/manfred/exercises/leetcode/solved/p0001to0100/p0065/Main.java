package manfred.exercises.leetcode.solved.p0001to0100.p0065;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/valid-number/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution / Solution2：保留验证，确保不被破坏（应通过）
        Solution s1 = new Solution();
        assertTrue(s1.isNumber("3."));
        assertTrue(s1.isNumber(" 0.1 "));
        assertTrue(s1.isNumber("2e10"));
        assertTrue(s1.isNumber("0"));
        assertFalse(s1.isNumber("abc"));
        assertFalse(s1.isNumber("1 a"));
        assertTrue(s1.isNumber(" -90e3   "));
        assertFalse(s1.isNumber(" 1e"));
        assertFalse(s1.isNumber("e3"));
        assertFalse(s1.isNumber(" 99e2.5 "));
        assertTrue(s1.isNumber("53.5e93"));
        assertFalse(s1.isNumber(" --6 "));
        assertFalse(s1.isNumber("-+3"));
        assertFalse(s1.isNumber("95a54e53"));
        Solution2 s2 = new Solution2();
        assertTrue(s2.isNumber("0"));
        assertFalse(s2.isNumber("e"));
        assertFalse(s2.isNumber("."));
        assertTrue(s2.isNumber(" 0.1 "));
        assertTrue(s2.isNumber("2e10"));
        assertTrue(s2.isNumber(" -90e3   "));
        assertTrue(s2.isNumber("-90E3"));
        assertTrue(s2.isNumber("53.5e93"));
        assertTrue(s2.isNumber("3."));
        assertFalse(s2.isNumber("abc"));
        assertFalse(s2.isNumber(" 1e"));
        assertFalse(s2.isNumber("e3"));
        assertFalse(s2.isNumber(" 99e2.5 "));
        assertFalse(s2.isNumber(" --6 "));
        assertFalse(s2.isNumber("-+3"));
        assertFalse(s2.isNumber("95a54e53"));
        // 新解法 Solution3：DFA 状态机验证
        // 题面明示合法样例（12 个）
        Solution3 s3 = new Solution3();
        assertTrue(s3.isNumber("2"));
        assertTrue(s3.isNumber("0089"));
        assertTrue(s3.isNumber("-0.1"));
        assertTrue(s3.isNumber("+3.14"));
        assertTrue(s3.isNumber("4."));
        assertTrue(s3.isNumber("-.9"));
        assertTrue(s3.isNumber("2e10"));
        assertTrue(s3.isNumber("-90E3"));
        assertTrue(s3.isNumber("3e+7"));
        assertTrue(s3.isNumber("+6e-1"));
        assertTrue(s3.isNumber("53.5e93"));
        assertTrue(s3.isNumber("-123.456e789"));
        // 题面明示非法样例（8 个）
        assertFalse(s3.isNumber("abc"));
        assertFalse(s3.isNumber("1a"));
        assertFalse(s3.isNumber("1e"));
        assertFalse(s3.isNumber("e3"));
        assertFalse(s3.isNumber("99e2.5"));
        assertFalse(s3.isNumber("--6"));
        assertFalse(s3.isNumber("-+3"));
        assertFalse(s3.isNumber("95a54e53"));
        // 官方 3 示例
        assertTrue(s3.isNumber("0"));
        assertFalse(s3.isNumber("e"));
        assertFalse(s3.isNumber("."));
        // 边界：能暴露常见 bug 的场景
        assertTrue(s3.isNumber(".0"));
        assertFalse(s3.isNumber("0e"));
        assertFalse(s3.isNumber("0e+"));
        assertTrue(s3.isNumber("0e+5"));
        assertTrue(s3.isNumber("+8"));
        assertTrue(s3.isNumber("6."));
        assertTrue(s3.isNumber("3.e3"));
        assertFalse(s3.isNumber(" "));
        assertFalse(s3.isNumber("  "));
        assertFalse(s3.isNumber("1 2"));
        assertFalse(s3.isNumber("1e2e3"));
        assertFalse(s3.isNumber(".1."));
        assertFalse(s3.isNumber(".e3"));
        assertFalse(s3.isNumber("+."));
        assertFalse(s3.isNumber("+e"));
        System.out.println("leet#0065 passed");
    }
}
