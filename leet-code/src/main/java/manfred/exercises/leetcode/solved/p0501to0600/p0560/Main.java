package manfred.exercises.leetcode.solved.p0501to0600.p0560;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/subarray-sum-equals-k/ */

/*
给你一个整数数组 nums 和一个整数 k，请你统计并返回该数组中和为 k 的子数组的个数。

示例 1：

输入：nums = [1,1,1], k = 2
输出：2

示例 2：

输入：nums = [1,2,3], k = 3
输出：2
*/
/**
 * LeetCode 第 560 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: nums = [1,1,1], k = 2 → 期望 2
        assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, solution2.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, solution3.subarraySum(new int[]{1, 1, 1}, 2));
        // 示例 2: nums = [1,2,3], k = 3 → 期望 2
        assertEquals(2, solution.subarraySum(new int[]{1, 2, 3}, 3));
        assertEquals(2, solution2.subarraySum(new int[]{1, 2, 3}, 3));
        assertEquals(2, solution3.subarraySum(new int[]{1, 2, 3}, 3));
        // 边界: 含负数，前缀和哈希表的关键场景 → 期望 4（[0..1],[1..2],[2..3],[0..3] 均和为 0）
        assertEquals(4, solution.subarraySum(new int[]{1, -1, 1, -1}, 0));
        assertEquals(4, solution2.subarraySum(new int[]{1, -1, 1, -1}, 0));
        assertEquals(4, solution3.subarraySum(new int[]{1, -1, 1, -1}, 0));
        // 边界: 单元素等于 k → 期望 1
        assertEquals(1, solution.subarraySum(new int[]{5}, 5));
        assertEquals(1, solution2.subarraySum(new int[]{5}, 5));
        assertEquals(1, solution3.subarraySum(new int[]{5}, 5));
    }

}
