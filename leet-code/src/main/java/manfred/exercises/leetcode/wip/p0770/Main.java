package manfred.exercises.leetcode.wip.p0770;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/basic-calculator-iv/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertListEquals(Arrays.asList("-1*a", "14"), solution.basicCalculatorIV("e + 8 - a + 5", new String[]{"e"}, new int[]{1}), "ex1");
        assertListEquals(Arrays.asList("-1*pressure", "5"), solution.basicCalculatorIV("e - 8 + temperature - pressure", new String[]{"e", "temperature"}, new int[]{1, 12}), "ex2");
        assertListEquals(Arrays.asList("1*e*e", "-64"), solution.basicCalculatorIV("(e + 8) * (e - 8)", new String[]{}, new int[]{}), "ex3");
        System.out.println("leet#0770 passed");
    }

    private static void assertListEquals(List<String> expected, List<String> actual, String desc) {
        assertNotNull(actual); // 骨架 return null 时 RED
        List<String> e = new ArrayList<>(expected);
        List<String> a = new ArrayList<>(actual);
        Collections.sort(e);
        Collections.sort(a);
        assertTrue(e.equals(a), desc + " expected " + e + ", actual " + a);
    }
}
