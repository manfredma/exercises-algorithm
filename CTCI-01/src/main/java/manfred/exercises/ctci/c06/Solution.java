package manfred.exercises.ctci.c06;

/**
 * CTCI 面试题 01.06「字符串压缩」：统计连续相同字符长度，拼接压缩串，若不更短返回原串。
 */
class Solution {
    public String compressString(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                count++;
                continue;
            }
            result.append(cur).append(count);
            cur = s.charAt(i);
            count = 1;
        }
        result.append(cur).append(count);
        return result.length() > s.length() ? s : result.toString();
    }
}