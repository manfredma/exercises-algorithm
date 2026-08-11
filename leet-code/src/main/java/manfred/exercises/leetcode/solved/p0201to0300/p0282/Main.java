package manfred.exercises.leetcode.solved.p0201to0300.p0282;

/** 题目链接：https://leetcode.cn/problems/expression-add-operators/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回 所有 能够得到 target 的表达式。

注意，返回表达式中的操作数 不应该 包含前导零。

注意，一个数字可以包含多个数位。


示例 1:

输入: num = "123", target = 6
输出: ["1+2+3", "1*2*3"]
解释: “1*2*3” 和 “1+2+3” 的值都是6。

示例 2:

输入: num = "232", target = 8
输出: ["2*3+2", "2+3*2"]
解释: “2*3+2” 和 “2+3*2” 的值都是8。

示例 3:

输入: num = "3456237490", target = 9191
输出: []
解释: 表达式 “3456237490” 无法得到 9191 。


提示：


1 <= num.length <= 10




num 仅含数字


-2^31 <= target <= 2^31 - 1
 */
/**
 * LeetCode 第 282 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertExpressionSetEquals(
                Arrays.asList("1+2+3", "1*2*3"), solution.addOperators("123", 6));
        assertExpressionSetEquals(
                Arrays.asList("1+2+3", "1*2*3"), solution2.addOperators("123", 6));
        assertExpressionSetEquals(
                Arrays.asList("2*3+2", "2+3*2"), solution.addOperators("232", 8));
        assertExpressionSetEquals(
                Arrays.asList("2*3+2", "2+3*2"), solution2.addOperators("232", 8));
        assertExpressionSetEquals(Collections.<String>emptyList(), solution.addOperators("3456237490", 9191));
        assertExpressionSetEquals(Collections.<String>emptyList(), solution2.addOperators("3456237490", 9191));
        assertExpressionSetEquals(
                Arrays.asList("0+0", "0-0", "0*0"), solution.addOperators("00", 0));
        assertExpressionSetEquals(
                Arrays.asList("0+0", "0-0", "0*0"), solution2.addOperators("00", 0));
    }

    private static void assertExpressionSetEquals(List<String> expected, List<String> actual) {
        List<String> expectedCopy = new ArrayList<String>(expected);
        List<String> actualCopy = new ArrayList<String>(actual);
        Collections.sort(expectedCopy);
        Collections.sort(actualCopy);
        if (!expectedCopy.equals(actualCopy)) {
            throw new AssertionError("expected: " + expectedCopy + ", actual: " + actualCopy);
        }
    }
}
