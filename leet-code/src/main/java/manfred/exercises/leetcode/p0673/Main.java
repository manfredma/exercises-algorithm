package manfred.exercises.leetcode.p0673;

/*
给定一个未排序的整数数组 nums，返回最长递增子序列的个数。

注意：这个数列必须是严格递增的。

提示：
- 1 <= nums.length <= 2000
- -10^6 <= nums[i] <= 10^6
*/
/**
 * LeetCode 第 673 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: [1,3,5,4,7] → 期望 2
        System.out.println(solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        // 示例 2: [2,2,2,2,2] → 期望 5
        System.out.println(solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}
