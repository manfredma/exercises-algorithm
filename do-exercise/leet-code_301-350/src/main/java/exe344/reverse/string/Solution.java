package exe344.reverse.string;

/**
 * LeetCode 第 344 题「反转字符串」：双指针原地交换首尾字符。
 */
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
        }
    }
}