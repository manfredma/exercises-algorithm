package manfred.exercises.leetcode.wip.p1021;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/remove-outermost-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals("()()()", solution.removeOuterParentheses("(()())(())"));
        assertEquals("()()()()(())", solution.removeOuterParentheses("(()())(())(()(()))"));
        assertEquals("", solution.removeOuterParentheses("()()"));
        System.out.println("leet#1021 passed");
    }
}
