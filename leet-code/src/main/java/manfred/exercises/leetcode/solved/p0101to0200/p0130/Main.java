/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border,
which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
package manfred.exercises.leetcode.solved.p0101to0200.p0130;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/surrounded-regions/ */

/**
 * LeetCode 第 130 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}
        };

        new Solution().solve(input);

        char[][] expected = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X'}
        };
        assertArrayEquals(expected, input);

        System.out.println("p0130 passed");
    }
}
