package manfred.exercises.leetcode.solved.p1001to1100.p1021;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/remove-outermost-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals("()()()", solution.removeOuterParentheses("(()())(())"), "input=\"(()())(())\"");
        assertEquals("()()()()(())", solution.removeOuterParentheses("(()())(())(()(()))"), "input=\"(()())(())(()(()))\"");
        assertEquals("", solution.removeOuterParentheses("()()"), "input=\"()()\"");
        assertEquals("", solution.removeOuterParentheses("()"), "single primitive");
        assertEquals("(())", solution.removeOuterParentheses("((()))"), "nested primitive");
        System.out.println("leet#1021 passed");
    }
}
