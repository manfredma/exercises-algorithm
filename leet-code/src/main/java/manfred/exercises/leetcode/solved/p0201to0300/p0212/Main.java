/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once in a word.

Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0212;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 题目链接：https://leetcode.cn/problems/word-search-ii/ */

/**
 * LeetCode 第 212 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // board1：[oa,oaa]（运行输出，需复核；无序结果用集合比较）
        assertSameSet(Arrays.asList("oa", "oaa"), solution.findWords(new char[][]{
                        {'o', 'a', 'b', 'n'},
                        {'o', 't', 'a', 'e'},
                        {'a', 'h', 'k', 'r'},
                        {'a', 'f', 'l', 'v'},
                },
                new String[]{"oa", "oaa"}));

        // 题面示例：["eat","oath"]（无序，用集合比较）
        assertSameSet(Arrays.asList("eat", "oath"), solution.findWords(new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                },
                new String[]{"oath", "pea", "eat", "rain"}));

        // 2x2 board 搜不到 "abcb"（手算：路径需回头，无解）
        assertSameSet(Arrays.asList(), solution.findWords(new char[][]{
                        {'a', 'b'},
                        {'c', 'd'}
                },
                new String[]{"abcb"}));

        System.out.println("p0212 passed");
    }

    /** 校验两个 List<String> 包含相同元素（无视顺序）。 */
    private static void assertSameSet(List<String> expected, List<String> actual) {
        Set<String> expectedSet = new HashSet<>(expected);
        Set<String> actualSet = new HashSet<>(actual);
        if (!expectedSet.equals(actualSet)) {
            fail("expected (as set): " + expectedSet + ", actual (as set): " + actualSet);
        }
    }
}
