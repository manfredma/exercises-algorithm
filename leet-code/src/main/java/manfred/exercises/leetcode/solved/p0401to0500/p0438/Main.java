package manfred.exercises.leetcode.solved.p0401to0500.p0438;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/ */

/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1：

输入：s = "cbaebabacd", p = "abc"
输出：[0,6]

示例 2：

输入：s = "abab", p = "ab"
输出：[0,1,2]
*/
/**
 * LeetCode 第 438 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: s = "cbaebabacd", p = "abc" → 期望 [0,6]
        assertListEquals(Arrays.asList(0, 6), solution.findAnagrams("cbaebabacd", "abc"));
        assertListEquals(Arrays.asList(0, 6), solution2.findAnagrams("cbaebabacd", "abc"));
        assertListEquals(Arrays.asList(0, 6), solution3.findAnagrams("cbaebabacd", "abc"));
        // 示例 2: s = "abab", p = "ab" → 期望 [0,1,2]
        assertListEquals(Arrays.asList(0, 1, 2), solution.findAnagrams("abab", "ab"));
        assertListEquals(Arrays.asList(0, 1, 2), solution2.findAnagrams("abab", "ab"));
        assertListEquals(Arrays.asList(0, 1, 2), solution3.findAnagrams("abab", "ab"));
        // 边界: s 与 p 等长且为异位词 → 期望 [0]
        assertListEquals(Arrays.asList(0), solution.findAnagrams("bac", "abc"));
        assertListEquals(Arrays.asList(0), solution2.findAnagrams("bac", "abc"));
        assertListEquals(Arrays.asList(0), solution3.findAnagrams("bac", "abc"));
        // 边界: p 比 s 长 → 期望 []
        assertListEquals(Arrays.asList(), solution.findAnagrams("ab", "abc"));
        assertListEquals(Arrays.asList(), solution2.findAnagrams("ab", "abc"));
        assertListEquals(Arrays.asList(), solution3.findAnagrams("ab", "abc"));
    }

    private static void assertListEquals(List<Integer> expected, List<Integer> actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
