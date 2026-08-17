/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0022;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/generate-parentheses/ */

/**
 * LeetCode 第 22 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // n=1：仅 "()"，结果顺序不限
        List<String> r1 = solution.generateParenthesis(1);
        List<String> e1 = Arrays.asList("()");
        assertEquals(e1.size(), r1.size());
        assertTrue(r1.containsAll(e1));

        // n=2：两种
        List<String> r2 = solution.generateParenthesis(2);
        List<String> e2 = Arrays.asList("()()", "(())");
        assertEquals(e2.size(), r2.size());
        assertTrue(r2.containsAll(e2));

        // n=3：题面示例五种
        List<String> r3 = solution.generateParenthesis(3);
        List<String> e3 = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(e3.size(), r3.size());
        assertTrue(r3.containsAll(e3));
        System.out.println("p0022 passed");
    }
}
