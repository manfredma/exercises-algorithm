package manfred.exercises.leetcode.solved.p1001to1100.p1096;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/brace-expansion-ii/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 官方示例
        assertListEquals(Arrays.asList("ac", "ad", "ae", "bc", "bd", "be"),
                solution.braceExpansionII("{a,b}{c,{d,e}}"), "example 1");
        assertListEquals(Arrays.asList("a", "ab", "ac", "z"),
                solution.braceExpansionII("{{a,z},a{b,c},{ab,z}}"), "example 2");

        // 单一元素、无花括号的连续字面量与重复分支去重。
        assertListEquals(Arrays.asList("a"), solution.braceExpansionII("a"), "single literal");
        assertListEquals(Arrays.asList("abcd"), solution.braceExpansionII("abcd"), "adjacent literals");
        assertListEquals(Arrays.asList("a", "b"), solution.braceExpansionII("{a,a,b}"), "duplicate union members");

        // 多层嵌套、连续拼接和字典序输出。
        assertListEquals(Arrays.asList("abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"),
                solution.braceExpansionII("a{b,c}{d,e}f{g,h}"), "nested cartesian product");
        System.out.println("leet#1096 passed");
    }

    private static void assertListEquals(List<String> expected, List<String> actual, String desc) {
        assertNotNull(actual, desc);
        assertEquals(expected, actual, desc);
    }
}
