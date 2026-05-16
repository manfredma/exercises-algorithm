package manfred.exercises.leetcode.p0009;

/**
 * LeetCode 第 9 题「回文数」：反转后半段数字与前半段比较，无需转字符串。
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int remainder = x;
        int reverse = 0;
        while (remainder / 10 > 0) {
            reverse = reverse * 10 + remainder % 10;
            remainder = remainder / 10;
        }
        if (remainder > 0) {
            reverse = reverse * 10 + remainder;
        }
        return reverse == x;
    }
}