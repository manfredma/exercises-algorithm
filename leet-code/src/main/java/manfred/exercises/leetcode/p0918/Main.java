package manfred.exercises.leetcode.p0918;

/*
给定一个长度为 n 的环形整数数组 nums，返回 nums 的非空子数组的最大可能和。

环形数组意味着数组末端与开头相连。子数组最多只能包含每个元素一次。

示例 1：
输入：nums = [1,-2,3,-2]
输出：3

示例 2：
输入：nums = [5,-3,5]
输出：10

示例 3：
输入：nums = [3,-2,2,-3]
输出：3

提示：
- n == nums.length
- 1 <= n <= 3 * 10^4
- -3 * 10^4 <= nums[i] <= 3 * 10^4
*/
/**
 * LeetCode 第 918 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 示例 1: nums = [1,-2,3,-2] → 期望 3
        System.out.println(solution.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        // 示例 2: nums = [5,-3,5] → 期望 10
        System.out.println(solution.maxSubarraySumCircular(new int[]{5, -3, 5}));
        // 示例 3: nums = [3,-2,2,-3] → 期望 3
        System.out.println(solution.maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
    }
}
