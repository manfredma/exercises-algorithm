package manfred.exercises.leetcode.solved.p0201to0300.p0224;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/basic-calculator/ */
public class Main {
    public static void main(String[] args) {
        List<TestEntry> expression = Arrays.asList(
                new TestEntry("1 + 1", 2),
                new TestEntry("-1+2", 1),
                new TestEntry("1-(-2)", 3),
                new TestEntry("-1", -1),
                new TestEntry("-(1)", -1),
                new TestEntry("3+-4", -1),
                new TestEntry(" 2-(1 + 2) ", -1),
                new TestEntry("(1+(4+5+2)-3)+(6+8)", 23),
                new TestEntry("0", 0),
                new TestEntry("(0)", 0),
                new TestEntry("(1+2+3-(4-3))", 5),
                // 边界：符号翻转 / 深嵌套 / 大数
                new TestEntry("-(2-(3+4))", 5),
                new TestEntry("-((1+2))", -3),
                new TestEntry("(1-(2-(3-4)))", -2),
                new TestEntry("1-2-3", -4),
                new TestEntry("2147483647", 2147483647)
        );
        // 旧解法 Solution：保留验证，确保不被破坏（应通过）
        Solution s1 = new Solution();
        for (TestEntry t : expression) {
            assertEquals(t.result, s1.calculate(t.expression), t.toString());
        }
        // 新解法 Solution2：递归下降解析器验证（已实现，文法递归 + int[] 游标）
        Solution2 s2 = new Solution2();
        for (TestEntry t : expression) {
            assertEquals(t.result, s2.calculate(t.expression), t.toString());
        }
        // 新解法 Solution3：符号跟踪栈验证（已实现，单趟 O(n) 无递归）
        Solution3 s3 = new Solution3();
        for (TestEntry t : expression) {
            assertEquals(t.result, s3.calculate(t.expression), t.toString());
        }
        System.out.println("leet#0224 passed");
    }

    static class TestEntry {
        String expression;
        int result;
        TestEntry(String expression, int result) {
            this.expression = expression;
            this.result = result;
        }
        public String toString() {
            return String.format("{expression:'%s', result: %d}", expression, result);
        }
    }
}
