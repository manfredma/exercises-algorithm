package manfred.exercises.leetcode.p058;

/**
 * LeetCode 第 58 题「最后一个单词的长度」：从末尾跳过空格后向前计数。
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int index = s.lastIndexOf(" ");
        if (index < 0) {
            return s.length();
        } else {
            return s.length() - 1 - index;
        }
    }
}