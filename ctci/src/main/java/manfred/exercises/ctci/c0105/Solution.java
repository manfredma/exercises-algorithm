package manfred.exercises.ctci.c0105;

/**
 * CTCI 面试题 01.05「一次编辑」：分情况判断替换、插入、删除一次能否转换。
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        int cur = m - n, count = 1;
        if (cur > 1 || cur < -1) {
            return false;
        }
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (cur == 1) {
                    j--;
                } else if (cur == -1) {
                    i--;
                }
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}