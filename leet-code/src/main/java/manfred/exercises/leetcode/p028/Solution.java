package manfred.exercises.leetcode.p028;

/**
 * LeetCode 第 28 题「找出字符串中第一个匹配项的下标」：KMP 算法或 Java 内置 indexOf。
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (null == needle || "".equals(needle)) {
            return 0;
        }
        if (null == haystack || "".equals(haystack)) {
            return -1;
        }

        return haystack.indexOf(needle);
    }
}