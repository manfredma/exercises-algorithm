package manfred.exercises.ctci.c03;

/**
 * CTCI 面试题 01.03「URL 化」：统计非空字符后从后向前填充空格替换为 %20。
 */
class Solution {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i >= chars.length) {
                sb.append("%20");
            } else if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}