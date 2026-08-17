package manfred.exercises.leetcode.solved.p0001to0100.p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 15 题「三数之和」（方案 2）：排序后固定第一个数，并通过双指针查找剩余两个数。
 * 该方案通过移动时跳过重复元素避免重复解，时间复杂度为 O(n²)，除排序外的额外空间复杂度为 O(1)。
 * 方案 3 将首项和双指针两侧的去重内联，作为更易迁移的标准写法。
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int first = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (first == nums[i]) {
                continue;
            }
            first = nums[i];
            for (int left = i + 1, right = nums.length - 1; left < right; ) {
                if (first + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(first, nums[left], nums[right]));
                    left = shiftLeft(nums, left, right);
                } else if (first + nums[left] + nums[right] < 0) {
                    left = shiftLeft(nums, left, right);
                } else {
                    right = shiftRight(nums, left, right);
                }
            }
        }
        return result;
    }

    private int shiftRight(int[] nums, int left, int right) {
        // 移动到下一个不满足要求的点，跳过重复的元素
        while (left < right) {
            if (nums[right - 1] != nums[right]) {
                right--;
                break;
            } else {
                right--;
            }
        }
        return right;
    }

    private int shiftLeft(int[] nums, int left, int right) {
        // 移动到下一个不满足要求的点，跳过重复的元素
        while (left < right) {
            if (nums[left + 1] != nums[left]) {
                left++;
                break;
            } else {
                left++;
            }
        }
        return left;
    }
}
