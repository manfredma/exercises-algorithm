package manfred.exercises.leetcode.solved.p1501to1600.p1512;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/number-of-good-pairs/ */

/*
给你一个整数数组 nums。
如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j,就可以认为这是一组好数对。
返回好数对的数目。
*/
/**
 * LeetCode 第 1512 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: nums = [1,2,3,1,1,3] → 期望 4
        assertEquals(4, solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        // 示例 2: nums = [1,1,1,1] → 期望 6
        assertEquals(6, solution.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        // 示例 3: nums = [1,2,3] → 期望 0
        assertEquals(0, solution.numIdenticalPairs(new int[]{1, 2, 3}));
        System.out.println("passed");
    }
}
