package manfred.exercises.leetcode.solved.p0001to0100.p0008;

/**
 * LeetCode 第 8 题「字符串转换整数 (atoi)」：逐字符解析，处理前导空格、符号和溢出。
 * <p>
 * 思路：char[] + index 游标跳过前导空格，解析符号，逐位累加到 long；
 * 溢出按符号分支判断（负数与 MIN_VALUE 绝对值、正数与 MAX_VALUE 比较）后截断。
 * 复杂度：时间 O(n)，空间 O(n)（toCharArray 复制）。
 */
class Solution {

    public int myAtoi(String str) {
        long result = 0;
        int sign = 1;
        if (null == str || "".equals(str)) {
            return (int) result;
        }

        char[] chars = str.toCharArray();

        // 跳过开始的空格
        int index = 0;
        for (char aChar : chars) {
            if (' ' == aChar) {
                index++;
            } else {
                break;
            }
        }

        if (index >= chars.length) {
            return (int)result;
        }

        // 判断首位是否合法，以及是否符号
        if ('-' == chars[index]) {
            sign = -1;
            index++;
        } else if ('+' == chars[index]) {
            index++;
        }

        for (int i = index; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                result = result * 10 + Character.digit(chars[i], 10);
                if (sign == -1 && result > Math.abs((long) Integer.MIN_VALUE)) {
                    // 溢出
                    return Integer.MIN_VALUE;
                } else if (sign == 1 && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return (int) result * sign;
    }
}