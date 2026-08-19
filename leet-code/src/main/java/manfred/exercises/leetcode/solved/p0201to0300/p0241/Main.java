package manfred.exercises.leetcode.solved.p0201to0300.p0241;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/different-ways-to-add-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        assertAllSolutions(Arrays.asList(0, 2), "2-1-1", solution, solution2, solution3);
        assertAllSolutions(Arrays.asList(-34, -14, -10, -10, 10), "2*3-4*5", solution, solution2, solution3);
        assertAllSolutions(Arrays.asList(11), "11", solution, solution2, solution3);
        assertAllSolutions(Arrays.asList(10, 14), "2*3+4", solution, solution2, solution3);
        System.out.println("leet#0241 passed");
    }

    private static void assertAllSolutions(List<Integer> expected, String expression,
                                           Solution solution, Solution2 solution2, Solution3 solution3) {
        assertListEquals(expected, solution.diffWaysToCompute(expression), "Solution input=\"" + expression + "\"");
        assertListEquals(expected, solution2.diffWaysToCompute(expression), "Solution2 input=\"" + expression + "\"");
        assertListEquals(expected, solution3.diffWaysToCompute(expression), "Solution3 input=\"" + expression + "\"");
    }

    private static void assertListEquals(List<Integer> expected, List<Integer> actual, String desc) {
        assertNotNull(actual); // 骨架 return null 时 RED
        List<Integer> e = new ArrayList<>(expected);
        List<Integer> a = new ArrayList<>(actual);
        Collections.sort(e);
        Collections.sort(a);
        assertTrue(e.equals(a), desc + " expected " + e + ", actual " + a);
    }
}
