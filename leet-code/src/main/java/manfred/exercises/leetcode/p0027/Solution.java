package manfred.exercises.leetcode.p0027;

/**
 * LeetCode 第 27 题「移除元素」：双指针原地覆盖，将非目标值前移。
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        if (null == nums || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                continue;
            }
            nums[result++] = nums[i];
        }
        return result;
    }
}