package manfred.exercises.leetcode.solved.p0001to0100.p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 15 题「三数之和」（方案 3）：排序后固定第一个数，再用相向双指针搜索其余两个数。
 * 固定首项、命中三元组后，分别跳过首项、左指针和右指针处的重复值，保证每个三元组仅加入一次。
 *
 * <p>排序时间复杂度为 O(n log n)，双指针枚举时间复杂度为 O(n²)，总时间复杂度为 O(n²)，
 * 除返回结果外空间复杂度为 O(1)。</p>
 */
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
