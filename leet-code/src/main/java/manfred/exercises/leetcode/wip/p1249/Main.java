package manfred.exercises.leetcode.wip.p1249;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 注意：本题返回任意一个合法字符串即可，这里用官方示例输出做断言
        assertEquals("lee(t(c)o)de", solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        assertEquals("ab(c)d", solution.minRemoveToMakeValid("a)b(c)d"));
        assertEquals("", solution.minRemoveToMakeValid("))(("));
        System.out.println("leet#1249 passed");
    }
}
