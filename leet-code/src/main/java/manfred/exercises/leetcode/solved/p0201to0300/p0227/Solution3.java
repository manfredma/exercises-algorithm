package manfred.exercises.leetcode.solved.p0201to0300.p0227;

/**
 * LeetCode 第 227 题「基本计算器 II」：再刷解法，递归下降 + lastAdded 撤销技巧。
 * <p>
 * 思路：沿用 224 题的递归下降框架（int[] cur 游标 + eatInteger/eatSpace），为处理 {@code *}{@code /}
 * 优先级引入 lastAdded——记录「最近一次加入 left 的项」。遇 {@code *}{@code /} 时：
 * 先 {@code left -= sign*lastAdded} 撤回上次加的项，再 {@code left += sign*lastAdded*right} 改为加乘积，
 * lastAdded 更新为乘积；遇 {@code +}{@code -} 则正常加减并刷新 lastAdded/sign。
 * <p>
 * 关键点：撤销-重加等价于「把上次加的项替换为它与右操作数的乘积」，从而在无显式栈下实现优先级。
 * 复杂度：时间 O(n)，空间 O(1)（无栈，优于 {@link Solution2} 的 O(n)）。
 * <p>
 * 定位：本解正确且空间 O(1) 是亮点，但 lastAdded 撤销技巧可读性差（{@code left -= sign*lastAdded;
 * left += sign*lastAdded*right} 不直观），易在边界出错。对照 {@link Solution2}（符号栈）为
 * 227 题首选：可读性更优，是标准模板。本解作「不同思路对照」留存。
 */
class Solution3 {

    public int calculate(String s) {
        s = s.trim();
        return calculate(s, new int[]{0});
    }

    private int calculate(String s, int[] cur) {
        int left = eatInteger(s, cur);
        int sign = 1;
        int lastAdded = left;
        while (cur[0] < s.length()) {
            // 计算运算符
            char operator = s.charAt(cur[0]);
            cur[0]++;
            eatSpace(s, cur);

            // 计算右表达式的值
            int right = eatInteger(s, cur);
            if (operator == '+') {
                left = left + right;
                sign = 1;
                lastAdded = right;
            } else if (operator == '-') {
                left = left - right;
                sign = -1;
                lastAdded = right;
            } else if (operator == '*') {
                left -= sign * lastAdded;
                left += sign * lastAdded * right;
                lastAdded = lastAdded * right;
            } else if (operator == '/') {
                left -= sign * lastAdded;
                left += sign * lastAdded / right;
                lastAdded = lastAdded / right;
            }
        }
        return left;
    }

    private int eatInteger(String s, int[] cur) {
        int result = 0;
        while (cur[0] < s.length() && Character.isDigit(s.charAt(cur[0]))) {
            result *= 10;
            result += s.charAt(cur[0]) - '0';
            cur[0]++;
        }
        eatSpace(s, cur);
        return result;

    }

    private void eatSpace(String s, int[] cur) {
        for (int i = cur[0]; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cur[0] = i + 1;
            } else {
                break;
            }
        }
    }
}
