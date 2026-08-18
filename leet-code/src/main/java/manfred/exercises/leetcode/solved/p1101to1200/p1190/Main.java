package manfred.exercises.leetcode.solved.p1101to1200.p1190;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals("dcba", solution.reverseParentheses("(abcd)"), "input=\"(abcd)\"");
        assertEquals("iloveu", solution.reverseParentheses("(u(love)i)"), "input=\"(u(love)i)\"");
        assertEquals("leetcode", solution.reverseParentheses("(ed(et(oc))el)"), "input=\"(ed(et(oc))el)\"");
        // 新解法 Solution2：跳转遍历法验证（已实现，O(n)，含嵌套/多层边界）
        Solution2 s2 = new Solution2();
        assertEquals("dcba", s2.reverseParentheses("(abcd)"), "input=\"(abcd)\"");
        assertEquals("iloveu", s2.reverseParentheses("(u(love)i)"), "input=\"(u(love)i)\"");
        assertEquals("leetcode", s2.reverseParentheses("(ed(et(oc))el)"), "input=\"(ed(et(oc))el)\"");
        assertEquals("abc", s2.reverseParentheses("abc"), "input=\"abc\"");
        assertEquals("", s2.reverseParentheses("()"), "input=\"()\"");
        assertEquals("a", s2.reverseParentheses("((a))"), "input=\"((a))\"");
        assertEquals("ab", s2.reverseParentheses("((ab))"), "input=\"((ab))\"");
        assertEquals("dbca", s2.reverseParentheses("(a(bc)d)"), "input=\"(a(bc)d)\"");
        assertEquals("agcedfbh", s2.reverseParentheses("a(b(c(de)f)g)h"), "input=\"a(b(c(de)f)g)h\"");
        System.out.println("leet#1190 passed");
    }
}
