package manfred.exercises.leetcode.solved.p1201to1300.p1249;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 注意：本题返回任意一个合法字符串即可，这里用 Solution 实际返回值做断言
        // 官方示例
        assertEquals("lee(t(c)o)de", solution.minRemoveToMakeValid("lee(t(c)o)de)"), "input=\"lee(t(c)o)de)\"");
        assertEquals("ab(c)d", solution.minRemoveToMakeValid("a)b(c)d"), "input=\"a)b(c)d\"");
        assertEquals("", solution.minRemoveToMakeValid("))(("), "input=\")((\"");
        // 边界：空串 / 纯字母 / 已合法 / 多余左 / 多余右 / 全无效 / 全左 / 全右 / 多个未配对
        assertEquals("", solution.minRemoveToMakeValid(""), "input=\"\"");
        assertEquals("abc", solution.minRemoveToMakeValid("abc"), "input=\"abc\"");
        assertEquals("()", solution.minRemoveToMakeValid("()"), "input=\"()\"");
        assertEquals("(a)", solution.minRemoveToMakeValid("(a)"), "input=\"(a)\"");
        assertEquals("()", solution.minRemoveToMakeValid("())"), "input=\"())\"");
        assertEquals("()", solution.minRemoveToMakeValid("(()"), "input=\"(()\"");
        assertEquals("", solution.minRemoveToMakeValid(")("), "input=\")(\"");
        assertEquals("", solution.minRemoveToMakeValid("((("), "input=\"(((\"");
        assertEquals("", solution.minRemoveToMakeValid(")))"), "input=\")\"\"\"");
        assertEquals("ab(c)d", solution.minRemoveToMakeValid("(a(b(c)d"), "input=\"(a(b(c)d\"");
        System.out.println("leet#1249 passed");
    }
}
