package manfred.exercises.leetcode.p0373;

/*
给定两个非递减整数数组 nums1 和 nums2，以及整数 k。
找到和最小的 k 个数对 (u, v)，u 来自 nums1，v 来自 nums2。

示例 1：
输入：nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出：[[1,2],[1,4],[1,6]]

示例 2：
输入：nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出：[[1,1],[1,1]]

提示：
- 1 <= nums1.length, nums2.length <= 10^5
- -10^9 <= nums1[i], nums2[i] <= 10^9
- nums1 和 nums2 均为升序排列
- 1 <= k <= 10^4
*/
/**
 * LeetCode 第 373 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: nums1=[1,7,11], nums2=[2,4,6], k=3 → 期望 [[1,2],[1,4],[1,6]]
        System.out.println(solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        // 示例 2: nums1=[1,1,2], nums2=[1,2,3], k=2 → 期望 [[1,1],[1,1]]
        System.out.println(solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }
}
