package manfred.exercises.leetcode.wip.p1096;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/brace-expansion-ii/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertListEquals(Arrays.asList("ac", "ad", "ae", "bc", "bd", "be"), solution.braceExpansionII("{a,b}{c,{d,e}}"), "ex1");
        assertListEquals(Arrays.asList("a", "ab", "ac", "z"), solution.braceExpansionII("{{a,z},a{b,c},{ab,z}}"), "ex2");
        System.out.println("leet#1096 passed");
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
