package manfred.exercises.leetcode.solved.p0301to0400.p0345;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-vowels-of-a-string/ */

/*
给你一个字符串 s，仅反转字符串中的所有元音字母，并返回结果字符串。
元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。

示例 1：
输入：s = "IceCreAm"
输出："AceCreIm"

示例 2：
输入：s = "leetcode"
输出："leotcede"

提示：
- 1 <= s.length <= 3 * 10^5
- s 由可打印的 ASCII 字符组成
*/
/**
 * LeetCode 第 345 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 "IceCreAm" → 期望 "AceCreIm"
        assertEquals("AceCreIm", solution.reverseVowels("IceCreAm"));
        // 示例 2: 输入 "leetcode" → 期望 "leotcede"
        assertEquals("leotcede", solution.reverseVowels("leetcode"));
        System.out.println("p0345 passed");
    }
}
