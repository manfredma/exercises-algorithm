package manfred.exercises.leetcode.p0283;

/**
 * LeetCode 第 283 题「移动零」：双指针，slow 记录下一个非零元素的落点。
 * 当 slow == fast 时跳过交换，避免无零元素时的无效操作。
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                if (slow != fast) {      // 有过零元素才需要移动
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                }
                slow++;
            }
        }
    }
}
