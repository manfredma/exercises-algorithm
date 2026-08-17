package manfred.exercises.leetcode.solved.p1901to2000.p1926;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/ */

/**
 * 在迷宫中上下左右移动，寻找离入口最近的边界空格；入口自身不算出口。
 * 不存在出口时返回 -1。示例输出依次为 1、2、-1。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(1, solution.nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));
        assertEquals(2, solution.nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}));
        assertEquals(-1, solution.nearestExit(new char[][]{{'.', '+'}}, new int[]{0, 0}));

        // 唯一路径需要经过多步才能抵达出口。
        assertEquals(5, solution.nearestExit(new char[][]{
                {'+', '+', '+', '.', '+'},
                {'+', '.', '.', '.', '+'},
                {'+', '.', '+', '+', '+'},
                {'+', '.', '+', '+', '+'},
                {'+', '+', '+', '+', '+'}
        }, new int[]{3, 1}));

        // 有多个出口时，应返回距离更小的出口。
        assertEquals(2, solution.nearestExit(new char[][]{
                {'+', '+', '+', '+', '+'},
                {'+', '+', '+', '.', '+'},
                {'.', '.', '.', '.', '+'},
                {'+', '+', '+', '.', '+'},
                {'+', '+', '+', '.', '+'}
        }, new int[]{2, 2}));
    }

}
