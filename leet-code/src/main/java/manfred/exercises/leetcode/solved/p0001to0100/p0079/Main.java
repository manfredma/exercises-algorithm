/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0079;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/word-search/ */

/**
 * LeetCode 第 79 题「单词搜索」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        char[][] x = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        Solution solution = new Solution();
        // 手算："AB" 在左上角相邻
        assertTrue(solution.exist(x, "AB"));
        // 题面示例："ABCCED" 存在
        assertTrue(solution.exist(x, "ABCCED"));
        // 题面示例："SEE" 存在
        assertTrue(solution.exist(x, "SEE"));
        // 题面示例："ABCB" 不存在（B 无法重复访问）
        assertFalse(solution.exist(x, "ABCB"));
        System.out.println("passed");
    }
}
