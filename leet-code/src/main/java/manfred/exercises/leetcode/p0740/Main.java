package manfred.exercises.leetcode.p0740;

/*
给你一个整数数组 nums，每次操作选 nums[i] 删除并获得 nums[i] 点数，
同时必须删除所有等于 nums[i]-1 和 nums[i]+1 的元素。
返回能获得的最大点数。

示例 1：
输入：nums = [3,4,2]
输出：6

示例 2：
输入：nums = [2,2,3,3,3,4]
输出：9

提示：
- 1 <= nums.length <= 2 * 10^4
- 1 <= nums[i] <= 10^4
*/

/**
 * LeetCode 第 740 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: nums = [3,4,2] → 期望 6
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
        // 示例 2: nums = [2,2,3,3,3,4] → 期望 9
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        // 示例 3: nums = [1,1,1,2,4,5,5,5,6] → 期望 18
        System.out.println(solution.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
    }
}
