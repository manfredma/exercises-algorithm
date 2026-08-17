/*
You are given a string, s, and a list of words, words, that are all of the same length.
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0030;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words/ */

/**
 * LeetCode 第 30 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1：起始下标顺序不限
        List<Integer> r1 = solution.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        List<Integer> e1 = Arrays.asList(0, 9);
        assertEquals(e1.size(), r1.size());
        assertTrue(r1.containsAll(e1));

        // 题面示例 2：无匹配
        List<Integer> r2 = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        assertEquals(0, r2.size());
        System.out.println("p0030 passed");
    }
}
