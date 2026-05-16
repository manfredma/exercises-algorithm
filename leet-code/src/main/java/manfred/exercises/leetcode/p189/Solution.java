package manfred.exercises.leetcode.p189;

/**
 * LeetCode 第 189 题「轮转数组」：三次翻转：全部反转，前 k 反转，后 n-k 反转。
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            int tmp2;
            for (int j = 0; j < nums.length; j++) {
                tmp2 = nums[j];
                nums[j] = tmp;
                tmp = tmp2;
            }
        }
    }
}