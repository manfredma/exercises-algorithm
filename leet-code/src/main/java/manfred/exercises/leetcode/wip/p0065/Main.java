package manfred.exercises.leetcode.wip.p0065;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/valid-number/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
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
        // 新解法 Solution2：新增验证，骨架占位下 RED，待实现后通过
        // 注意：旧 Solution 仅认小写 e（EXPRESSION_REVIEW 记录的 bug），故旧测试用小写 e；
        // 新解法应同时支持大写 E，故新增 E 用例。
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
        System.out.println("leet#0065 passed");
    }
}
