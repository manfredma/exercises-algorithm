package manfred.exercises.leetcode.solved.p0601to0700.p0611;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int smallest = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int smaller = nums[j];
                int sum = smaller + smallest;
                int left = j + 1, right = nums.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 如果两边之和小于等于第三边，说明从当前节点（含）及其右侧都不能组成三角形
                    if (nums[mid] >= sum) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                result += left - j - 1;
            }
        }
        return result;
    }
}
