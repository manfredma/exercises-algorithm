package manfred.exercises.leetcode.wip.p0150;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
        // 注意：旧 Solution 单元素输入 ["42"] 会空栈 peek 抛异常（EXPRESSION_REVIEW 记录的 bug），
        // 故旧测试不含单元素用例；新解法 Solution2 应正确处理，新增该边界。
        Solution s1 = new Solution();
        assertEquals(9, s1.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, s1.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, s1.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        // 新解法 Solution2：新增验证，骨架占位下 RED，待实现后通过
        Solution2 s2 = new Solution2();
        assertEquals(9, s2.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, s2.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, s2.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        assertEquals(42, s2.evalRPN(new String[]{"42"})); // 单元素边界（旧解法 bug 点）
        assertEquals(-3, s2.evalRPN(new String[]{"-3"})); // 单负数
        System.out.println("leet#0150 passed");
    }
}
