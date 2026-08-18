package manfred.exercises.leetcode.solved.p0101to0200.p0150;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
        // 旧 Solution 原单元素输入 ["42"] 空栈 peek 崩溃（EXPRESSION_REVIEW 记录的 bug），
        // 已于 2026-08-18 修复，现补单元素防回归用例。
        Solution s1 = new Solution();
        assertEquals(9, s1.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, s1.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, s1.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        assertEquals(42, s1.evalRPN(new String[]{"42"})); // 单元素（旧解 bug 点，已修复）
        assertEquals(-3, s1.evalRPN(new String[]{"-3"})); // 单负数
        // 新解法 Solution2：正向栈法 + BiFunction 映射验证（已实现）
        Solution2 s2 = new Solution2();
        assertEquals(9, s2.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, s2.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, s2.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        assertEquals(42, s2.evalRPN(new String[]{"42"})); // 单元素边界
        assertEquals(-3, s2.evalRPN(new String[]{"-3"})); // 单负数
        // 新解法 Solution3：性能优化版验证（switch 直算 + int[] 栈，消除装箱与 HashMap 开销）
        Solution3 s3 = new Solution3();
        assertEquals(9, s3.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, s3.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, s3.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        assertEquals(42, s3.evalRPN(new String[]{"42"})); // 单元素
        assertEquals(-3, s3.evalRPN(new String[]{"-3"})); // 单负数
        assertEquals(14, s3.evalRPN(new String[]{"3", "11", "+"}));
        assertEquals(-8, s3.evalRPN(new String[]{"3", "11", "-"})); // 顺序敏感
        assertEquals(2, s3.evalRPN(new String[]{"13", "5", "/"}));  // 除截断
        assertEquals(-2, s3.evalRPN(new String[]{"-13", "5", "/"})); // 负数除
        System.out.println("leet#0150 passed");
    }
}
