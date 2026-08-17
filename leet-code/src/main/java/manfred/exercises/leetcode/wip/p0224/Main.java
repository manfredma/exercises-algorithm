package manfred.exercises.leetcode.wip.p0224;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/basic-calculator/ */

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 224 题「基本计算器」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        List<TestEntry> expression = Arrays.asList(
                new TestEntry("-1+2", 1),
                new TestEntry("1-(-2)", 3),
                new TestEntry("-1", -1),
                new TestEntry("-(1)", -1),
                new TestEntry("3+-4", -1),
                new TestEntry("1 + 1", 2),
                new TestEntry(" 2-(1 + 2) ", -1),
                new TestEntry("(1+(4+5+2)-3)+(6+8)", 23),
                new TestEntry("0", 0),
                new TestEntry("(0)", 0),
                new TestEntry("(1+2+3-(4-3))", 5)
        );

        Solution solution = new Solution();
        for (TestEntry s : expression) {
            assertEquals(s.result, solution.calculate(s.expression));
        }
        System.out.println("p0224 all assertions passed");
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
