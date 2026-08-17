package manfred.exercises.leetcode.wip.p0227;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/basic-calculator-ii/ */

/**
 * LeetCode 第 227 题「基本计算器 II」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(42, solution.calculate("42"));
        assertEquals(7, solution.calculate("3+2*2"));
        assertEquals(1, solution.calculate("3/2"));
        assertEquals(5, solution.calculate(" 3+5 / 2 "));

        Solution2 solution2 = new Solution2();
        assertEquals(42, solution2.calculate("42"));
        assertEquals(7, solution2.calculate("3+2*2"));
        assertEquals(1, solution2.calculate("3/2"));
        assertEquals(5, solution2.calculate(" 3+5 / 2 "));
        System.out.println("p0227 all assertions passed");
    }
}
