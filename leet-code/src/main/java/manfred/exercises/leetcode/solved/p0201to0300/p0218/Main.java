package manfred.exercises.leetcode.solved.p0201to0300.p0218;

import static manfred.exercises.assertion.Assert.assertEquals;
import static manfred.exercises.assertion.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/the-skyline-problem/ */

/**
 * LeetCode 第 218 题「天际线问题」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        int[][] input = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        Solution solution = new Solution();
        // 题面示例输出: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]（按 x 排序）
        List<List<Integer>> exp = Arrays.asList(
                Arrays.asList(2, 10),
                Arrays.asList(3, 15),
                Arrays.asList(7, 12),
                Arrays.asList(12, 0),
                Arrays.asList(15, 10),
                Arrays.asList(20, 8),
                Arrays.asList(24, 0));
        List<List<Integer>> act = solution.getSkyline(input);
        assertEquals(exp.size(), act.size());
        assertTrue(exp.containsAll(act));

        SolutionV2 solutionV2 = new SolutionV2();
        List<List<Integer>> act2 = solutionV2.getSkyline(input);
        assertEquals(exp.size(), act2.size());
        assertTrue(exp.containsAll(act2));
        System.out.println("p0218 passed");
    }
}
