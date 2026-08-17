package manfred.exercises.leetcode.wip.p0241;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/different-ways-to-add-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertListEquals(Arrays.asList(0, 2), solution.diffWaysToCompute("2-1-1"), "2-1-1");
        assertListEquals(Arrays.asList(-34, -14, -10, -10, 10), solution.diffWaysToCompute("2*3-4*5"), "2*3-4*5");
        System.out.println("leet#0241 passed");
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
