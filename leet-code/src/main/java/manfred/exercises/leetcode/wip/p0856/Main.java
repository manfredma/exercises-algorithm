package manfred.exercises.leetcode.wip.p0856;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/score-of-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(1, solution.scoreOfParentheses("()"));
        assertEquals(2, solution.scoreOfParentheses("(())"));
        assertEquals(2, solution.scoreOfParentheses("()()"));
        assertEquals(6, solution.scoreOfParentheses("(()(()))"));
        System.out.println("leet#0856 passed");
    }
}
