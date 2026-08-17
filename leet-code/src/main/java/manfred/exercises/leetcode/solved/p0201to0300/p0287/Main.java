package manfred.exercises.leetcode.solved.p0201to0300.p0287;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/find-the-duplicate-number/ */

/*
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。

你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。

示例 1：
输入：nums = [1,3,4,2,2]
输出：2

示例 2：
输入：nums = [3,1,3,4,2]
输出：3

示例 3：
输入：nums = [3,3,3,3,3]
输出：3

提示：
- 1 <= n <= 10^5
- nums.length == n + 1
- 1 <= nums[i] <= n
- nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
*/
/**
 * LeetCode 第 287 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 示例 1: nums = [1,3,4,2,2] → 题面 Output: 2
        assertEquals(2, solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        // 示例 2: nums = [3,1,3,4,2] → 题面 Output: 3
        assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        // 示例 3: nums = [3,3,3,3,3] → 题面 Output: 3
        assertEquals(3, solution.findDuplicate(new int[]{3, 3, 3, 3, 3}));
        // 示例 4: nums = [2,5,9,6,9,3,8,9,7,1] → 题面 Output: 9
        assertEquals(9, solution.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
        System.out.println("p0287 passed");
    }
}
