package manfred.exercises.leetcode.p387;

/**
 * LeetCode 第387题 字符串中的第一个唯一字符，用长度为26的计数数组统计频次后线性扫描找到首个唯一字符。
 */
class Solution {
    public int firstUniqChar(String s) {
        if (null == s || "".equals(s)) {
            return -1;
        }
        int[] letterFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterFrequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letterFrequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}