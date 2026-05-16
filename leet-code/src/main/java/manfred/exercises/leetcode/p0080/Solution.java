package manfred.exercises.leetcode.p0080;

/**
 * LeetCode 第 80 题「删除有序数组中的重复项 II」：双指针，每个元素最多保留两次。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 1;
        int pre = nums[0];
        int numOfCurrent = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == pre) {
                numOfCurrent++;
                if (numOfCurrent <= 2) {
                    nums[i++] = pre;
                }
            } else {
                pre = nums[j];
                nums[i++] = pre;
                numOfCurrent = 1;
            }
        }
        return i;
    }
}