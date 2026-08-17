/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means
it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0211;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/design-add-and-search-words-data-structure/ */

/**
 * LeetCode 第 211 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        // 题面示例
        assertFalse(wordDictionary.search("pad"));
        assertTrue(wordDictionary.search("bad"));
        assertTrue(wordDictionary.search(".ad"));
        assertTrue(wordDictionary.search("b.."));
        System.out.println("p0211 passed");
    }
}
