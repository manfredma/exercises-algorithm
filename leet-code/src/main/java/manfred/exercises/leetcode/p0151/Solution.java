package manfred.exercises.leetcode.p0151;

/**
 * LeetCode 第 151 题「反转字符串中的单词」：先去除多余空格，再整体反转后逐单词反转。
 */
class Solution {
    public String reverseWords(String s) {
        String result = "";
        s = s.trim();
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (ss[ss.length - 1 - i] != null && !"".equals(ss[ss.length - 1 - i])) {
                result += ss[ss.length - 1 - i];
                if (i != ss.length - 1) {
                    result += " ";
                }
            }

        }
        return result;
    }
}