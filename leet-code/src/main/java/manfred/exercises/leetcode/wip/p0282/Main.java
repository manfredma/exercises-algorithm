package manfred.exercises.leetcode.wip.p0282;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/expression-add-operators/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution / Solution2：保留验证，确保不被破坏（应通过）
        Solution solution = new Solution();
        assertExpressionSetEquals(Arrays.asList("1+2+3", "1*2*3"), solution.addOperators("123", 6), "123/6");
        assertExpressionSetEquals(Arrays.asList("2*3+2", "2+3*2"), solution.addOperators("232", 8), "232/8");
        assertExpressionSetEquals(Collections.<String>emptyList(), solution.addOperators("3456237490", 9191), "3456237490/9191");
        assertExpressionSetEquals(Arrays.asList("0+0", "0-0", "0*0"), solution.addOperators("00", 0), "00/0");
        Solution2 solution2 = new Solution2();
        assertExpressionSetEquals(Arrays.asList("1+2+3", "1*2*3"), solution2.addOperators("123", 6), "123/6");
        assertExpressionSetEquals(Arrays.asList("2*3+2", "2+3*2"), solution2.addOperators("232", 8), "232/8");
        assertExpressionSetEquals(Collections.<String>emptyList(), solution2.addOperators("3456237490", 9191), "3456237490/9191");
        assertExpressionSetEquals(Arrays.asList("0+0", "0-0", "0*0"), solution2.addOperators("00", 0), "00/0");
        // 新解法 Solution3：新增验证，骨架占位下 RED，待实现后通过
        Solution3 s3 = new Solution3();
        assertExpressionSetEquals(Arrays.asList("1+2+3", "1*2*3"), s3.addOperators("123", 6), "123/6");
        assertExpressionSetEquals(Arrays.asList("2*3+2", "2+3*2"), s3.addOperators("232", 8), "232/8");
        assertExpressionSetEquals(Collections.<String>emptyList(), s3.addOperators("3456237490", 9191), "3456237490/9191");
        System.out.println("leet#0282 passed");
    }

    private static void assertExpressionSetEquals(List<String> expected, List<String> actual, String desc) {
        assertNotNull(actual); // 骨架 return null 时 RED
        List<String> expectedCopy = new ArrayList<String>(expected);
        List<String> actualCopy = new ArrayList<String>(actual);
        Collections.sort(expectedCopy);
        Collections.sort(actualCopy);
        assertTrue(expectedCopy.equals(actualCopy), desc + " expected " + expectedCopy + ", actual " + actualCopy);
    }
}
