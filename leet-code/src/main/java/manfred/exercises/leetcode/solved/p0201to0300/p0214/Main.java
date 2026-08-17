package manfred.exercises.leetcode.solved.p0201to0300.p0214;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/shortest-palindrome/ */

/**
 * LeetCode 第 214 题「最短回文串」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // aacecaaa -> aaacecaaa（手算：在前补 'a' 形成回文）
        assertEquals("aaacecaaa", solution.shortestPalindrome("aacecaaa"));
        // aaaa -> aaaa（已是回文）
        assertEquals("aaaa", solution.shortestPalindrome("aaaa"));
        // abcd -> dcbabcd（手算：在前补 dcb 形成回文）
        assertEquals("dcbabcd", solution.shortestPalindrome("abcd"));
        // a -> a
        assertEquals("a", solution.shortestPalindrome("a"));
        // "" -> ""
        assertEquals("", solution.shortestPalindrome(""));
        System.out.println("p0214 passed");
    }
}
