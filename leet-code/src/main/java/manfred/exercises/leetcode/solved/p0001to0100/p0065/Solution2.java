package manfred.exercises.leetcode.solved.p0001to0100.p0065;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 第 65 题「有效数字」：再刷解法，手写游标解析器（trim + 逐段吃字符）。
 * <p>
 * 思路：trim 去空格 → 吃可选符号 → 吃整数部分（数字串）→ 吃可选小数点 + 小数部分 →
 * 吃可选指数(e/E + 可选符号 + 数字串)。每段用 tryEat 推进游标 cur，最终 cur 落到串尾即合法。
 * <p>
 * 关键点：整数/小数部分至少一侧有数字（integerPart 与 floatPart 不能同空）；
 * 指数段必须有数字（tryEat type=1 must=true，无数字返回 -1 致非法）；
 * tryEat 对越界与 must 校验统一兜底，避免空串崩溃。
 * 复杂度：时间 O(n)，空间 O(1)。
 * <p>
 * 修复：相对旧 {@link Solution} 补齐大写 E 支持；修掉前导零(0089)误判、指数符号(3e+7)漏吃、
 * 纯空格越界崩溃三类 bug。对照解 {@link Solution3} 用 DFA 转移表更系统、可读性更优。
 */
class Solution2 {
    public boolean isNumber(String s) {
        s = s.trim();

        // 吃掉正负号
        int cur = 0;
        cur = tryEat(s, cur, 2, false, Arrays.asList('-', '+'));
        if (isValidIdx(s, cur)) {
            return false;
        }

        String integerPart = "";
        // 吃掉所有的数值

        int beginInt  = cur;
        cur = tryEat(s, cur, 1, false, Collections.emptyList());
        integerPart = s.substring(beginInt, cur);

        if (cur == s.length()) {
            return true;
        }

        // 吃掉小数点及后面的数值
        String floatPart = "";
        if (s.charAt(cur) == '.') {
            cur++;
            int begin = cur;
            cur = tryEat(s, cur, 1, false, Collections.emptyList());
            floatPart = s.substring(begin, cur);
        }
        if (integerPart.isEmpty() && floatPart.isEmpty()) {
            return false;
        }
        if (cur == s.length()) {
            return true;
        }

        // 指数部分！
        if (s.charAt(cur) == 'E' || s.charAt(cur) == 'e') {
            cur++;
            cur = tryEat(s, cur, 2, false, Arrays.asList('-', '+'));
            cur = tryEat(s, cur, 1, true, Collections.emptyList());
        }
        // 如果没有结束，则说明不是合法数字！
        return cur == s.length();
    }

    private boolean isValidIdx(String s, int cur) {
        return cur == s.length() || cur < 0;
    }

    private int tryEat(String s, int cur, int type, boolean must, List<Character> targets) {
        // type = 1 : 后续所有数字
        if (type == 1) {
            if ((cur >= s.length() || !Character.isDigit(s.charAt(cur))) && must) {
                return -1;
            }
            while (cur < s.length() && Character.isDigit(s.charAt(cur))) {
                cur++;
            }
        } else if (type == 2) {
            if ((cur >= s.length() || !targets.contains(s.charAt(cur))) && must) {
                return -1;
            }
            if (cur < s.length() && targets.contains(s.charAt(cur))) {
                cur++;
            }
        }
        return cur;
    }
}
