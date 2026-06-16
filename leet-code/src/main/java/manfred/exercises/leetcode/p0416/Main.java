package manfred.exercises.leetcode.p0416;

/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。

提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
/**
 * LeetCode 第 416 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: nums = [1,5,11,5] → 期望 true
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        // 示例 2: nums = [1,2,3,5] → 期望 false
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }
}
