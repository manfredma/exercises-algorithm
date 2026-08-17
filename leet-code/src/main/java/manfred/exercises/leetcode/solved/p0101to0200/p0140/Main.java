/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0140;

/** 题目链接：https://leetcode.cn/problems/word-break-ii/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 140 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertStringSet(Arrays.asList("cats and dog", "cat sand dog"), solution.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        assertStringSet(Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple"), solution.wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
        assertTrue(solution.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))).isEmpty());

        Solution2 solution2 = new Solution2();
        assertStringSet(Arrays.asList("cats and dog", "cat sand dog"), solution2.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        assertStringSet(Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple"), solution2.wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
        assertTrue(solution2.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))).isEmpty());

        Solution3 solution3 = new Solution3();
        assertStringSet(Arrays.asList("cats and dog", "cat sand dog"), solution3.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        assertStringSet(Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple"), solution3.wordBreak("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
        assertTrue(solution3.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))).isEmpty());

        System.out.println("p0140 passed");
    }

    private static void assertStringSet(List<String> expected, List<String> actual) {
        Set<String> expectedSet = new HashSet<>(expected);
        Set<String> actualSet = new HashSet<>(actual);
        if (!expectedSet.equals(actualSet)) {
            fail("expected set: " + expectedSet + ", actual set: " + actualSet);
        }
    }
}
