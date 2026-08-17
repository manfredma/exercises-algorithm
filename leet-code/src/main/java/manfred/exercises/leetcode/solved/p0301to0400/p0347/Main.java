package manfred.exercises.leetcode.solved.p0301to0400.p0347;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;

/** 题目链接：https://leetcode.cn/problems/top-k-frequent-elements/ */

/*
给你一个整数数组 nums 和一个整数 k，请你返回其中出现频率前 k 高的元素。可以按任意顺序返回答案。

示例 1：

输入：nums = [1,1,1,2,2,3], k = 2
输出：[1,2]

示例 2：

输入：nums = [1], k = 1
输出：[1]
*/
/**
 * LeetCode 第 347 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: nums = [1,1,1,2,2,3], k = 2 → 期望 [1,2]（顺序无关）
        assertArrayEqualsAnyOrder(new int[]{1, 2}, solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEqualsAnyOrder(new int[]{1, 2}, solution2.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEqualsAnyOrder(new int[]{1, 2}, solution3.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        // 示例 2: nums = [1], k = 1 → 期望 [1]
        assertArrayEqualsAnyOrder(new int[]{1}, solution.topKFrequent(new int[]{1}, 1));
        assertArrayEqualsAnyOrder(new int[]{1}, solution2.topKFrequent(new int[]{1}, 1));
        assertArrayEqualsAnyOrder(new int[]{1}, solution3.topKFrequent(new int[]{1}, 1));
        // 边界: 多元素但 1 频率最高（1 出现 4 次）→ 期望 [1,2]
        assertArrayEqualsAnyOrder(new int[]{1, 2}, solution.topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2));
        assertArrayEqualsAnyOrder(new int[]{1, 2}, solution2.topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2));
        assertArrayEqualsAnyOrder(new int[]{1, 2}, solution3.topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2));
        // 边界: 负数，频率区分 → 期望 [-2,-1]（-2 出现 3 次，-1 出现 2 次）
        assertArrayEqualsAnyOrder(new int[]{-2, -1}, solution.topKFrequent(new int[]{-1, -1, -2, -2, -2, -3}, 2));
        assertArrayEqualsAnyOrder(new int[]{-2, -1}, solution2.topKFrequent(new int[]{-1, -1, -2, -2, -2, -3}, 2));
        assertArrayEqualsAnyOrder(new int[]{-2, -1}, solution3.topKFrequent(new int[]{-1, -1, -2, -2, -2, -3}, 2));
        // 边界: 边界值 ±10000 → 期望 [-10000]
        assertArrayEqualsAnyOrder(new int[]{-10000}, solution.topKFrequent(new int[]{-10000, -10000, 10000}, 1));
        assertArrayEqualsAnyOrder(new int[]{-10000}, solution2.topKFrequent(new int[]{-10000, -10000, 10000}, 1));
        assertArrayEqualsAnyOrder(new int[]{-10000}, solution3.topKFrequent(new int[]{-10000, -10000, 10000}, 1));
        // 边界: 全部相同 → 期望 [5]
        assertArrayEqualsAnyOrder(new int[]{5}, solution.topKFrequent(new int[]{5, 5, 5, 5}, 1));
        assertArrayEqualsAnyOrder(new int[]{5}, solution2.topKFrequent(new int[]{5, 5, 5, 5}, 1));
        assertArrayEqualsAnyOrder(new int[]{5}, solution3.topKFrequent(new int[]{5, 5, 5, 5}, 1));
        // 边界: k 等于不同元素数，频率各不同 → 期望 [3,2,1]
        assertArrayEqualsAnyOrder(new int[]{3, 2, 1}, solution.topKFrequent(new int[]{3, 3, 3, 2, 2, 1}, 3));
        assertArrayEqualsAnyOrder(new int[]{3, 2, 1}, solution2.topKFrequent(new int[]{3, 3, 3, 2, 2, 1}, 3));
        assertArrayEqualsAnyOrder(new int[]{3, 2, 1}, solution3.topKFrequent(new int[]{3, 3, 3, 2, 2, 1}, 3));
        // 边界: 阶梯频率分布 → 期望 [1,2,3]
        assertArrayEqualsAnyOrder(new int[]{1, 2, 3}, solution.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4}, 3));
        assertArrayEqualsAnyOrder(new int[]{1, 2, 3}, solution2.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4}, 3));
        assertArrayEqualsAnyOrder(new int[]{1, 2, 3}, solution3.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4}, 3));
    }

    /** 频率前 k 高的元素顺序无关，排序后比较。 */
    private static void assertArrayEqualsAnyOrder(int[] expected, int[] actual) {
        int[] e = expected.clone();
        int[] a = actual.clone();
        Arrays.sort(e);
        Arrays.sort(a);
        if (!Arrays.equals(e, a)) {
            fail("expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
        }
    }
}
