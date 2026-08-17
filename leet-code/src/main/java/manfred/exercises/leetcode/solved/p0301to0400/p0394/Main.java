package manfred.exercises.leetcode.solved.p0301to0400.p0394;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/decode-string/ */

/*
给定一个经过编码的字符串，返回它解码后的字符串。编码规则为：k[encoded_string]。

示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"

示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"

示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
*/
/**
 * LeetCode 第 394 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: s = "3[a]2[bc]" → 期望 "aaabcbc"
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
        assertEquals("aaabcbc", solution2.decodeString("3[a]2[bc]"));
        assertEquals("aaabcbc", solution3.decodeString("3[a]2[bc]"));
        // 示例 2: s = "3[a2[c]]" → 期望 "accaccacc"（嵌套）
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
        assertEquals("accaccacc", solution2.decodeString("3[a2[c]]"));
        assertEquals("accaccacc", solution3.decodeString("3[a2[c]]"));
        // 示例 3: s = "2[abc]3[cd]ef" → 期望 "abcabccdcdcdef"
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
        assertEquals("abcabccdcdcdef", solution2.decodeString("2[abc]3[cd]ef"));
        assertEquals("abcabccdcdcdef", solution3.decodeString("2[abc]3[cd]ef"));
        // 示例 4: s = "abc3[cd]xyz" → 期望 "abccdcdcdxyz"
        assertEquals("abccdcdcdxyz", solution.decodeString("abc3[cd]xyz"));
        assertEquals("abccdcdcdxyz", solution2.decodeString("abc3[cd]xyz"));
        assertEquals("abccdcdcdxyz", solution3.decodeString("abc3[cd]xyz"));
        // 边界: 无编码 → 期望原串
        assertEquals("abc", solution.decodeString("abc"));
        assertEquals("abc", solution2.decodeString("abc"));
        assertEquals("abc", solution3.decodeString("abc"));
        // 边界: 多位数重复次数 → 期望 leetcode×10
        String ten = repeat("leetcode", 10);
        assertEquals(ten, solution.decodeString("10[leetcode]"));
        assertEquals(ten, solution2.decodeString("10[leetcode]"));
        assertEquals(ten, solution3.decodeString("10[leetcode]"));
        // 边界: 多位数重复单字符 → 期望 a×100
        String hundred = repeat("a", 100);
        assertEquals(hundred, solution.decodeString("100[a]"));
        assertEquals(hundred, solution2.decodeString("100[a]"));
        assertEquals(hundred, solution3.decodeString("100[a]"));
        // 边界: 多位数嵌套 → 期望 (a×100)×2
        String nested = repeat(repeat("a", 100), 2);
        assertEquals(nested, solution.decodeString("2[100[a]]"));
        assertEquals(nested, solution2.decodeString("2[100[a]]"));
        assertEquals(nested, solution3.decodeString("2[100[a]]"));
        // 边界: 多位数相邻 → 期望 a×10 + b×11
        String adjacent = repeat("a", 10) + repeat("b", 11);
        assertEquals(adjacent, solution.decodeString("10[a]11[b]"));
        assertEquals(adjacent, solution2.decodeString("10[a]11[b]"));
        assertEquals(adjacent, solution3.decodeString("10[a]11[b]"));
    }


    /** Java 8 无 String.repeat，手动拼接。 */
    private static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
