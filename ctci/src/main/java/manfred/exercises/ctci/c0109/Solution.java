package manfred.exercises.ctci.c0109;

/**
 * CTCI 面试题 01.09「字符串轮转」：判断 s2 是否为 s1+s1 的子串。
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}