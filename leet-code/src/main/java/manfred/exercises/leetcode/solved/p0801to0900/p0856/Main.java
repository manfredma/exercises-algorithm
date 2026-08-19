package manfred.exercises.leetcode.solved.p0801to0900.p0856;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/score-of-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertScore(1, "()", solution, solution2);
        assertScore(2, "(())", solution, solution2);
        assertScore(2, "()()", solution, solution2);
        assertScore(6, "(()(()))", solution, solution2);
        assertScore(3, "(())()", solution, solution2);
        assertScore(5, "(()())()", solution, solution2);
        assertScore(6, "(()()())", solution, solution2);
        assertScore(3, "()()()", solution, solution2);
        System.out.println("leet#0856 passed");
    }

    private static void assertScore(int expected, String input, Solution solution, Solution2 solution2) {
        assertEquals(expected, solution.scoreOfParentheses(input), "Solution input=\"" + input + "\"");
        assertEquals(expected, solution2.scoreOfParentheses(input), "Solution2 input=\"" + input + "\"");
    }
}
