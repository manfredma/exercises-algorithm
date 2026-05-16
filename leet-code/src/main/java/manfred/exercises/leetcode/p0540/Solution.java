package manfred.exercises.leetcode.p0540;

/**
 * LeetCode 第540题 有序数组中的单一元素，利用异或运算在 O(n) 时间内找出只出现一次的元素。
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}