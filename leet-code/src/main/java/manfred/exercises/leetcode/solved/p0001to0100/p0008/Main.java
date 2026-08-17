package manfred.exercises.leetcode.solved.p0001to0100.p0008;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/string-to-integer-atoi/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
        Solution s1 = new Solution();
        assertEquals(4193, s1.myAtoi("4193 with words"));
        assertEquals(42, s1.myAtoi("42"));
        assertEquals(-2147483648, s1.myAtoi("-91283472332"));
        // 新解法 Solution2：新增验证，骨架占位下 RED，待实现后通过
        Solution2 s2 = new Solution2();
        assertEquals(42, s2.myAtoi("42"));
        assertEquals(-42, s2.myAtoi(" -042"));
        assertEquals(1337, s2.myAtoi("1337c0d3"));
        assertEquals(0, s2.myAtoi("0-1"));
        assertEquals(0, s2.myAtoi("words and 987"));
        assertEquals(0, s2.myAtoi(""));
        assertEquals(0, s2.myAtoi("   "));
        assertEquals(0, s2.myAtoi("+"));
        assertEquals(0, s2.myAtoi("-"));
        assertEquals(123, s2.myAtoi("  000123"));
        assertEquals(2147483647, s2.myAtoi("2147483648"));
        assertEquals(-2147483648, s2.myAtoi("-91283472332"));
        System.out.println("leet#0008 passed");
    }
}
