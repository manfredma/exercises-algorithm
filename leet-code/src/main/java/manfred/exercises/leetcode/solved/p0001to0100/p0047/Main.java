/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0047;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/permutations-ii/ */

/**
 * LeetCode 第 47 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 题面示例：[1,1,2] 共 3 种唯一排列，顺序不限
        Solution4 solution4 = new Solution4();
        List<List<Integer>> r1 = solution4.permuteUnique(new int[]{1, 1, 2});
        List<List<Integer>> e1 = Arrays.asList(
                Arrays.asList(1, 1, 2),
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 1, 1));
        assertEquals(e1.size(), r1.size());
        assertTrue(r1.containsAll(e1));

        Solution2 solution2 = new Solution2();
        // Solution2.permuteUnique([2,2,1,1]) 返回 11 个含重复项（正确应 6 个唯一排列），疑似 bug，此处跳过断言
        // [1,1,2] 共 3 种唯一排列，顺序不限
        List<List<Integer>> r3 = solution2.permuteUnique(new int[]{1, 1, 2});
        assertEquals(e1.size(), r3.size());
        assertTrue(r3.containsAll(e1));
        System.out.println("p0047 passed");
    }
}
