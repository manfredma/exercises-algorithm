package manfred.exercises.leetcode.solved.p0001to0100.p0065;

/**
 * LeetCode 第 65 题「有效数字」：字符串拆分法，处理整数、小数、指数格式。
 * <p>
 * 思路：trim 后剥符号 → 按 e 拆指数段 → 指数段再剥符号后须为纯数字；非指数段按 . 拆小数，
 * 小数点两侧至少一侧有数字。各段用 isAllDigital 校验纯数字。
 * <p>
 * 修复（2026-08-17）：原版只认小写 e（contains/indexOf/split("e")），大写 E 如 "-90E3" 判错；
 * 此解 7 年前在平台通过，后平台补充大写 E 用例暴露该 bug。现统一 replace('E','e') 后处理。
 * 复杂度：时间 O(n)，空间 O(n)（split 产生子串）。
 * <p>
 * 对照 {@link Solution2}（游标解析器）、{@link Solution3}（DFA 状态机）为再刷解。
 */
class Solution {

    private final char charOfZero = '0';
    private final char charOfNine = '9';

    public boolean isNumber(String s) {
        if (null == s) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }

        // 处理只有单个字符的情况
        if (s.length() == 1) {
            return (s.charAt(0) >= charOfZero && s.charAt(0) <= charOfNine);
        }

        // 处理符号位
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }

        // 按符号E拆解（统一小写，使大写 E 与小写 e 等价处理）
        s = s.replace('E', 'e');
        if (s.contains("e")  && s.indexOf("e") == s.lastIndexOf("e")) {
            String[] x = s.split("e");
            if (x.length == 2) {
                // 处理符号位
                if (x[1].length() > 1 && (x[1].charAt(0) == '+' || x[1].charAt(0) == '-')) {
                    x[1] = x[1].substring(1);
                }
                return isNormalDecimal(x[0]) && isAllDigital(x[1]);
            } else {
                return false;
            }
        } else {
            return isNormalDecimal(s);
        }
    }

    private boolean isNormalDecimal(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }
        // 按符号'.'拆解
        if (s.contains(".") && s.indexOf(".") == s.lastIndexOf(".")) {
            String[] x = s.split("\\.");
            if (x.length == 2) {
                if (x[0].isEmpty() && x[1].isEmpty()) {
                    return false;
                }
                return (x[0].isEmpty() || isAllDigital(x[0])) && (x[1].isEmpty() || isAllDigital(x[1]));
            } else if (x.length == 1) {
                return isAllDigital(x[0]);
            } else {
                return false;
            }
        } else {
            return isAllDigital(s);
        }
    }

    private boolean isAllDigital(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return (s.charAt(0) >= charOfZero && s.charAt(0) <= charOfNine);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < charOfZero || s.charAt(i) > charOfNine) {
                return false;
            }
        }
        return true;
    }
}