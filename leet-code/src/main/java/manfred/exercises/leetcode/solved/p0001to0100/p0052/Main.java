/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0052;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/n-queens-ii/ */

/**
 * LeetCode 第 52 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        // 题面示例：n = 4 时共有 2 种不同摆法
        assertEquals(2, new Solution().totalNQueens(4));
        System.out.println("p0052 passed");
    }
}
