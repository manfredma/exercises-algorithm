package manfred.exercises.leetcode.p0896;

import java.util.Arrays;

/*
如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。
如果对于所有 i <= j，nums[i] >= nums[j]，那么数组 nums 是单调递减的。
当给定的数组 nums 是单调数组时返回 true，否则返回 false。
提示：1 <= nums.length <= 10^5，-10^5 <= nums[i] <= 10^5
*/

/**
 * LeetCode 第 896 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：nums = [1,2,2,3] → 期望 true
        System.out.println(solution.isMonotonic(new int[]{1, 2, 2, 3}));

        // 示例 2：nums = [6,5,4,4] → 期望 true
        System.out.println(solution.isMonotonic(new int[]{6, 5, 4, 4}));

        // 示例 3：nums = [1,3,2] → 期望 false
        System.out.println(solution.isMonotonic(new int[]{1, 3, 2}));
    }
}
