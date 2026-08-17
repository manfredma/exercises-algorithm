package manfred.exercises.leetcode.wip.p0013;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/roman-to-integer/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
        Solution s1 = new Solution();
        assertEquals(3, s1.romanToInt("III"));
        assertEquals(4, s1.romanToInt("IV"));
        assertEquals(9, s1.romanToInt("IX"));
        assertEquals(58, s1.romanToInt("LVIII"));
        assertEquals(1994, s1.romanToInt("MCMXCIV"));
        assertEquals(12, s1.romanToInt("XII"));
        assertEquals(27, s1.romanToInt("XXVII"));
        assertEquals(1, s1.romanToInt("I"));
        assertEquals(3999, s1.romanToInt("MMMCMXCIX"));
        // 新解法 Solution2：新增验证，骨架占位下 RED，待实现后通过
        Solution2 s2 = new Solution2();
        assertEquals(3, s2.romanToInt("III"));
        assertEquals(4, s2.romanToInt("IV"));
        assertEquals(9, s2.romanToInt("IX"));
        assertEquals(58, s2.romanToInt("LVIII"));
        assertEquals(1994, s2.romanToInt("MCMXCIV"));
        assertEquals(1, s2.romanToInt("I"));
        assertEquals(3999, s2.romanToInt("MMMCMXCIX"));
        System.out.println("leet#0013 passed");
    }
}
