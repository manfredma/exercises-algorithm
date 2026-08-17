/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0090;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 题目链接：https://leetcode.cn/problems/subsets-ii/ */

/**
 * LeetCode 第 90 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例: [1,2,2] → 6 个子集，子集间无序，子集内部按非降序比较
        List<List<Integer>> r = solution.subsetsWithDup(new int[]{1, 2, 2});
        assertEquals(6, r.size());

        Set<List<Integer>> expected = new HashSet<>();
        expected.add(sortedList(Arrays.asList()));
        expected.add(sortedList(Arrays.asList(1)));
        expected.add(sortedList(Arrays.asList(2)));
        expected.add(sortedList(Arrays.asList(1, 2)));
        expected.add(sortedList(Arrays.asList(2, 2)));
        expected.add(sortedList(Arrays.asList(1, 2, 2)));

        Set<List<Integer>> actual = new HashSet<>();
        for (List<Integer> s : r) {
            actual.add(sortedList(s));
        }
        assertEquals(expected, actual);
        System.out.println("p0090 passed");
    }

    private static List<Integer> sortedList(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }
}
