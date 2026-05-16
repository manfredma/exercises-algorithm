package manfred.exercises.leetcode.p041;

/**
 * LeetCode 第 41 题「缺失的第一个正数」：原地哈希，将正数放到对应下标位置，再扫描找缺失。
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 1;
        }
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }
            tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = 0;
            while (tmp > 0 && tmp < nums.length + 1) {
                int tmp2 = tmp;
                tmp = nums[tmp2 - 1];
                nums[tmp2 - 1] = tmp2;
                if (tmp == tmp2) {
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}