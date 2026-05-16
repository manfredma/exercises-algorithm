package manfred.exercises.leetcode.p125;

/**
 * LeetCode 第 125 题「验证回文串」：双指针跳过非字母数字字符，忽略大小写比较。
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        int i = s.length() - 1;
        for (int j = 0; j < s.length(); j++) {
            if (Character.isLetterOrDigit(s.charAt(j))) {
                while (true) {
                    if (Character.isLetterOrDigit(s.charAt(i))) {

                        if (s.charAt(i) != s.charAt(j)) {
                            return false;
                        } else {
                            i--;
                            break;
                        }
                    } else {
                        i--;
                    }
                }
            }
        }
        return true;
    }
}