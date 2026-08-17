package manfred.exercises.leetcode.wip.p1190;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals("dcba", solution.reverseParentheses("(abcd)"));
        assertEquals("iloveu", solution.reverseParentheses("(u(love)i)"));
        assertEquals("leetcode", solution.reverseParentheses("(ed(et(oc))el)"));
        System.out.println("leet#1190 passed");
    }
}
