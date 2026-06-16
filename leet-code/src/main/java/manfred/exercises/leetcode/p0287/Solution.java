package manfred.exercises.leetcode.p0287;

/**
 * LeetCode 第 287 题「寻找重复数」
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int expected = 0;
            int mask = 1 << i;
            for (int j = 1; j < nums.length; j++) {
                if ((j & mask) != 0) {
                    expected++;
                }
            }
            int actual = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    actual++;
                }
            }
            if (actual > expected) {
                result += mask;
            }
        }
        return result;
    }
}