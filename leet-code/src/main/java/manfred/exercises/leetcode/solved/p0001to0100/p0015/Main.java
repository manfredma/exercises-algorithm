package manfred.exercises.leetcode.solved.p0001to0100.p0015;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/3sum/ */

/*
给你一个整数数组 nums，判断是否存在三元组满足和为 0，返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：

输入：nums = [0,1,1]
输出：[]

示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
*/
/**
 * LeetCode 第 15 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: nums = [-1,0,1,2,-1,-4] → 期望 [[-1,-1,2],[-1,0,1]]
        assertTripleListEquals(
                Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)),
                solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertTripleListEquals(
                Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)),
                solution2.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertTripleListEquals(
                Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)),
                solution3.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // 示例 2: nums = [0,1,1] → 期望 []
        assertTripleListEquals(Arrays.asList(), solution.threeSum(new int[]{0, 1, 1}));
        assertTripleListEquals(Arrays.asList(), solution2.threeSum(new int[]{0, 1, 1}));
        assertTripleListEquals(Arrays.asList(), solution3.threeSum(new int[]{0, 1, 1}));
        // 示例 3: nums = [0,0,0] → 期望 [[0,0,0]]
        assertTripleListEquals(Arrays.asList(Arrays.asList(0, 0, 0)), solution.threeSum(new int[]{0, 0, 0}));
        assertTripleListEquals(Arrays.asList(Arrays.asList(0, 0, 0)), solution2.threeSum(new int[]{0, 0, 0}));
        assertTripleListEquals(Arrays.asList(Arrays.asList(0, 0, 0)), solution3.threeSum(new int[]{0, 0, 0}));
        // 边界: 多个相同值，去重关键场景 → 期望 [[-2,0,2]]
        assertTripleListEquals(
                Arrays.asList(Arrays.asList(-2, 0, 2)),
                solution.threeSum(new int[]{-2, 0, 0, 2, 2}));
        assertTripleListEquals(
                Arrays.asList(Arrays.asList(-2, 0, 2)),
                solution2.threeSum(new int[]{-2, 0, 0, 2, 2}));
        assertTripleListEquals(
                Arrays.asList(Arrays.asList(-2, 0, 2)),
                solution3.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    /** 三元组内部及列表间顺序均无关，统一排序后比较。 */
    private static void assertTripleListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (normalize(expected).equals(normalize(actual))) {
            return;
        }
        fail("expected: " + expected + ", actual: " + actual);
    }

    private static List<String> normalize(List<List<Integer>> triples) {
        java.util.List<String> keys = new java.util.ArrayList<>();
        for (List<Integer> t : triples) {
            int[] arr = new int[t.size()];
            for (int i = 0; i < t.size(); i++) {
                arr[i] = t.get(i);
            }
            Arrays.sort(arr);
            keys.add(Arrays.toString(arr));
        }
        java.util.Collections.sort(keys);
        return keys;
    }
}
