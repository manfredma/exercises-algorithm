/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0049;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 题目链接：https://leetcode.cn/problems/group-anagrams/ */

/**
 * LeetCode 第 49 题「字母异位词分组」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：分组间顺序不限，组内顺序不限，故用 Set<Set<String>> 深度无序比较
        List<List<String>> r = solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        Set<Set<String>> expected = new HashSet<>();
        expected.add(new HashSet<>(Arrays.asList("ate", "eat", "tea")));
        expected.add(new HashSet<>(Arrays.asList("nat", "tan")));
        expected.add(new HashSet<>(Arrays.asList("bat")));
        Set<Set<String>> actual = new HashSet<>();
        for (List<String> g : r) {
            actual.add(new HashSet<>(g));
        }
        assertEquals(expected, actual);
        System.out.println("p0049 passed");
    }
}
