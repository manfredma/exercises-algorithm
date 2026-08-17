/*

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

A sudoku puzzle...

...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0037;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/sudoku-solver/ */

/**
 * LeetCode 第 37 题「解数独」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] chars = new char[9][];
        chars[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        chars[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        chars[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        chars[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        chars[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        chars[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        chars[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        chars[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        chars[8] = new char[]{'.','.','.','.','8','.','.','7','9'};

        solution.solveSudoku(chars);

        // 题目保证唯一解，此为该棋盘的标准解
        char[][] expected = new char[][]{
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
        };
        assertArrayEquals(expected, chars);
        System.out.println("p0037 passed");
    }
}
