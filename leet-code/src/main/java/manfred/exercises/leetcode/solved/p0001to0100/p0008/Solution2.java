package manfred.exercises.leetcode.solved.p0001to0100.p0008;

/**
 * LeetCode 第 8 题「字符串转换整数 (atoi)」：再刷解法（见 EXPRESSION_REVIEW.md 复盘）。
 * <p>
 * 思路：trim 去前导空格 → 解析可选正负号 → 跳过前导 0 → 逐字符累加到 long，
 * 每步用 sign*result 与 int 边界比较，越界即截断返回。
 * <p>
 * 关键点：前导 0 过滤使后续溢出判断稳定；溢出用 long 中间值兜底，避免 int 提前溢出。
 * 复杂度：时间 O(n)，空间 O(1)。
 * <p>
 * 与 {@link Solution} 演进：旧解手写 char[] 游标解析、溢出按符号分支判断；
 * 本解用 trim + 前导0过滤简化流程，溢出判断统一为 sign*result 单点比较。
 */
class Solution2 {
    public int myAtoi(String s) {
        s = s.trim();
        int cur = 0;
        // 解析符号
        int sign = 1;
        if (cur < s.length() && (s.charAt(cur) == '+' || s.charAt(cur) == '-')) {
            sign *= (s.charAt(cur) == '-' ? -1 : 1);
            cur++;
        }

        // 过滤前导 0
        while (cur < s.length() && s.charAt(cur) == '0') {
            cur++;
        }

        long result = 0;
        for (int i = cur; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            result = result * 10 + (s.charAt(i) - '0');
            if (sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int) result;
    }
}
