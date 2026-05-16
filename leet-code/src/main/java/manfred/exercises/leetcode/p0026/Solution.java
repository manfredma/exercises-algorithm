package manfred.exercises.leetcode.p0026;

/**
 * LeetCode 第 26 题「删除有序数组中的重复项」：双指针，慢指针维护无重复区间末尾。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        if (null == nums || nums.length == 0) {
            return result;
        }
        int current = nums[0];
        result++;
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                continue;
            }
            current = nums[i];
            nums[result++] = current;
        }
        return result;
    }
}