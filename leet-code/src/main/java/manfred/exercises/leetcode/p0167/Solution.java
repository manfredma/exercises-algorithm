package manfred.exercises.leetcode.p0167;

import java.util.Arrays;

/**
 * LeetCode 第 167 题「两数之和 II - 输入有序数组」：双指针从两端向中间收缩。
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        int[] re = new int[numbers.length];
        for (int k = 0; k < numbers.length; k++) {
            re[k] = target - numbers[numbers.length - 1 - k];
        }
        int i = 0, j = 0;
        while (i < numbers.length && j < numbers.length) {
            if (numbers[i] == re[j]) {
                result[0] = Math.min(i, numbers.length - 1 - j) + 1;
                result[1] = Math.max(i, numbers.length - 1 - j) + 1;
                break;
            } else if (numbers[i] > re[j]) {
                j++;
            } else {
                i++;
            }
        }
        return result;
    }
}