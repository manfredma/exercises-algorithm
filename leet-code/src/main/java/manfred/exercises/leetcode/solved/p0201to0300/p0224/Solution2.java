package manfred.exercises.leetcode.solved.p0201to0300.p0224;

/**
 * LeetCode 第 224 题「基本计算器」：再刷解法，递归下降解析器。
 * <p>
 * 文法：表达式 = 项 (('+'|'-') 项)*；项 = ['-'] (数字 | '(' 表达式 ')')。
 * calculate 解析表达式（项的加减序列），eatInteger 解析单项（吃一元 '-' 后取数字或括号子式），
 * 遇 '(' 递归、遇 ')' 返回，括号配对靠递归栈。游标用 int[] cur 单元素数组传引用共享。
 * <p>
 * 关键点：题面禁 '+' 一元、允 '-' 一元，故 eatInteger 只吃 '-' 不吃 '+'；
 * eatSpace 在各处吃空格以兼容空格穿插。
 * 复杂度：时间 O(n)，空间 O(递归深度)。
 * <p>
 * 与 {@link Solution} 演进：旧解 AST + 调度场 ~250 行；本解递归下降 ~70 行，结构清晰。
 * <p>
 * 定位：本解是计算器系列的**通用解析器骨架**——文法分层使其可自然扩展到 227（加 * /）、
 * 770/772（加幂、变量）等题，只需增/改文法产生式。对照 {@link Solution3}（符号跟踪栈）
 * 为 224 题特化解：代码更短但建立在「仅 +/-、无优先级」强假设上，不可扩展。
 */
class Solution2 {
    char leftBrace = '(';
    char rightBrace = ')';

    public int calculate(String s) {
        s = s.trim();
        return calculate(s, new int[]{0});
    }

    private int calculate(String s, int[] cur) {
        int left = eatInteger(s, cur);
        while (cur[0] < s.length()) {
            if (s.charAt(cur[0]) == rightBrace) {
                cur[0]++;
                eatSpace(s, cur);
                // 表达式计算结束！
                break;
            }
            // 计算运算符
            char operator = s.charAt(cur[0]);
            cur[0]++;
            eatSpace(s, cur);

            // 计算右表达式的值
            int right = eatInteger(s, cur);
            if (operator == '+') {
                left = left + right;
            } else if (operator == '-') {
                left = left - right;
            }
        }
        return left;
    }

    private int eatInteger(String s, int[] cur) {
        int sign = 1;
        if (s.charAt(cur[0]) == '-') {
            sign = -1;
            cur[0]++;
            eatSpace(s, cur);
        }

        if (s.charAt(cur[0]) == leftBrace) {
            cur[0]++;
            eatSpace(s, cur);
            int eval = calculate(s, cur);
            eatSpace(s, cur);
            return sign * eval;
        } else {
            int result = 0;
            while (cur[0] < s.length() && Character.isDigit(s.charAt(cur[0]))) {
                result *= 10;
                result += s.charAt(cur[0]) - '0';
                cur[0]++;
            }
            eatSpace(s, cur);
            return sign * result;
        }
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
