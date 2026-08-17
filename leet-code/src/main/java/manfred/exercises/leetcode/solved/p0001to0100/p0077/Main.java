/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0077;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 题目链接：https://leetcode.cn/problems/combinations/ */

/**
 * LeetCode 第 77 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例: n=4, k=2 → 6 组组合，组合间无序
        List<List<Integer>> r = solution.combine(4, 2);
        assertEquals(6, r.size());

        Set<List<Integer>> expected = new HashSet<>();
        expected.add(sortedList(Arrays.asList(1, 2)));
        expected.add(sortedList(Arrays.asList(1, 3)));
        expected.add(sortedList(Arrays.asList(1, 4)));
        expected.add(sortedList(Arrays.asList(2, 3)));
        expected.add(sortedList(Arrays.asList(2, 4)));
        expected.add(sortedList(Arrays.asList(3, 4)));

        Set<List<Integer>> actual = new HashSet<>();
        for (List<Integer> c : r) {
            actual.add(sortedList(c));
        }
        assertEquals(expected, actual);
        System.out.println("p0077 passed");
    }

    private static List<Integer> sortedList(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }
}
