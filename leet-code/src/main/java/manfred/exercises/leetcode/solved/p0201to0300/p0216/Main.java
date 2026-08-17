package manfred.exercises.leetcode.solved.p0201to0300.p0216;

import static manfred.exercises.assertion.Assert.assertEquals;
import static manfred.exercises.assertion.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/combination-sum-iii/ */

/**
 * LeetCode 第 216 题「组合总和 III」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        /*
        Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * <p>
 * Input: k = 4, n = 1
 * Output: []
         */
        Solution solution = new Solution();
        // 示例 1: k=3, n=7 → 期望 [[1,2,4]]（无序组合,用 size+containsAll）
        List<List<Integer>> exp1 = Arrays.asList(Arrays.asList(1, 2, 4));
        List<List<Integer>> act1 = solution.combinationSum3(3, 7);
        assertEquals(exp1.size(), act1.size());
        assertTrue(exp1.containsAll(act1));
        // 示例 2: k=3, n=9 → 期望 [[1,2,6],[1,3,5],[2,3,4]]
        List<List<Integer>> exp2 = Arrays.asList(
                Arrays.asList(1, 2, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 3, 4));
        List<List<Integer>> act2 = solution.combinationSum3(3, 9);
        assertEquals(exp2.size(), act2.size());
        assertTrue(exp2.containsAll(act2));
        // 示例 3: k=4, n=1 → 期望 []
        List<List<Integer>> exp3 = Collections.emptyList();
        List<List<Integer>> act3 = solution.combinationSum3(4, 1);
        assertEquals(exp3.size(), act3.size());
        assertTrue(exp3.containsAll(act3));
        System.out.println("p0216 passed");
    }
}
