/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0131;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/palindrome-partitioning/ */

/**
 * LeetCode 第 131 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertSameSet(Arrays.asList(
                Arrays.asList("c", "d", "d"),
                Arrays.asList("c", "dd")
        ), solution.partition("cdd"));
        assertSameSet(Arrays.asList(
                Arrays.asList("aa", "b"),
                Arrays.asList("a", "a", "b")
        ), solution.partition("aab"));

        System.out.println("p0131 passed");
    }

    private static void assertSameSet(List<List<String>> expected, List<List<String>> actual) {
        Set<List<String>> expectedSet = new HashSet<>(expected);
        Set<List<String>> actualSet = new HashSet<>(actual);
        if (!expectedSet.equals(actualSet)) {
            fail("expected set: " + expectedSet + ", actual set: " + actualSet);
        }
    }
}
