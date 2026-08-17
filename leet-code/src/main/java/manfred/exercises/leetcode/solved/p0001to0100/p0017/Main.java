/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0017;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/ */

/**
 * LeetCode 第 17 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // "2312" 中 '1' 无字母映射（Solution 跳过），等价于 "232"：
        // {a,b,c} × {d,e,f} × {a,b,c} 共 27 个组合，结果顺序不限
        List<String> result = solution.letterCombinations("2312");
        List<String> expected = new ArrayList<>();
        for (char c1 : new char[]{'a', 'b', 'c'}) {
            for (char c2 : new char[]{'d', 'e', 'f'}) {
                for (char c3 : new char[]{'a', 'b', 'c'}) {
                    expected.add("" + c1 + c2 + c3);
                }
            }
        }
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        System.out.println("p0017 passed");
    }
}
