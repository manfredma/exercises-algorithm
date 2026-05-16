package manfred.exercises.leetcode.p066;

import java.util.Arrays;

/**
 * LeetCode 第 66 题「加一」：从末位加一，若进位则继续向前传递。
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            digits[digits.length - 1 - i] = digits[digits.length - 1 - i] + 1;
            if (digits[digits.length - 1 - i] / 10 == 0) {
                break;
            }
            digits[digits.length - 1 - i] = digits[digits.length - 1 - i] % 10;
        }
        if (digits[0] == 0) {
            int[] r = new int[digits.length + 1];
            r[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                r[i + 1] = digits[i];
            }
            return r;
        }
        return digits;
    }
}