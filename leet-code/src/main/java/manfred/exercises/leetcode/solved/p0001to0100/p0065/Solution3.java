package manfred.exercises.leetcode.solved.p0001to0100.p0065;

/**
 * LeetCode 第 65 题「有效数字」：再刷解法，DFA 状态机。
 * <p>
 * 把合法数字文法编译成确定有限自动机，先 trim 去首尾空格，再逐字符查转移表推进状态，
 * 终态落在「可接受」集合即合法。trim 后串中空格走 OTHER 直接判非法（中间空格本就非法）。
 * 相比手写游标解析器，状态机把所有边界（前导零、小数点两侧任一有数、指数必须带数字、
 * 符号仅出现在三处）统一进转移表，不再依赖零散 if 分支，可读性与可维护性更好。
 * <p>
 * 状态：0 起始｜1 符号｜2 整数｜3 点(前无数)｜4 点(前有数)｜5 小数｜6 e/E｜7 指数符号｜8 指数数字｜9 非法。
 * 终态：2 整数、4 点(前有数，如 "3.")、5 小数、8 指数数字。
 * 复杂度：时间 O(n)，空间 O(1)（转移表常数 10×6）。
 */
class Solution3 {

    // 字符类别
    private static final int CLS_DIGIT = 0;
    private static final int CLS_SIGN = 1;
    private static final int CLS_DOT = 2;
    private static final int CLS_EXP = 3;
    private static final int CLS_SPACE = 4;
    private static final int CLS_OTHER = 5;

    // 状态
    private static final int ST_START = 0;
    private static final int ST_SIGN = 1;
    private static final int ST_INT = 2;
    private static final int ST_DOT_NO_INT = 3;
    private static final int ST_DOT_INT = 4;
    private static final int ST_FRAC = 5;
    private static final int ST_EXP = 6;
    private static final int ST_EXP_SIGN = 7;
    private static final int ST_EXP_NUM = 8;
    private static final int ST_ILLEGAL = 9;

    // 转移表: transition[state][charClass] = nextState
    // 注意：空格不在 DFA 内处理，先 trim 去首尾空格；串中空格走 OTHER 直接非法。
    private static final int[][] TRANSITION = {
        //              DIGIT   SIGN    DOT     EXP     SPACE   OTHER
        /* START     */ {ST_INT, ST_SIGN, ST_DOT_NO_INT, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
        /* SIGN      */ {ST_INT, ST_ILLEGAL, ST_DOT_NO_INT, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
        /* INT       */ {ST_INT, ST_ILLEGAL, ST_DOT_INT, ST_EXP, ST_ILLEGAL, ST_ILLEGAL},
        /* DOT_NO_INT*/ {ST_FRAC, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
        /* DOT_INT   */ {ST_FRAC, ST_ILLEGAL, ST_ILLEGAL, ST_EXP, ST_ILLEGAL, ST_ILLEGAL},
        /* FRAC      */ {ST_FRAC, ST_ILLEGAL, ST_ILLEGAL, ST_EXP, ST_ILLEGAL, ST_ILLEGAL},
        /* EXP       */ {ST_EXP_NUM, ST_EXP_SIGN, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
        /* EXP_SIGN  */ {ST_EXP_NUM, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
        /* EXP_NUM   */ {ST_EXP_NUM, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
        /* ILLEGAL   */ {ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL, ST_ILLEGAL},
    };

    // 可接受终态
    private static final boolean[] ACCEPT = {
        false, false, true, false, true, true, false, false, true, false
    };

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        int state = ST_START;
        for (int i = 0; i < s.length(); i++) {
            int cls = charClass(s.charAt(i));
            state = TRANSITION[state][cls];
            if (state == ST_ILLEGAL) {
                return false;
            }
        }
        return ACCEPT[state];
    }

    private int charClass(char c) {
        if (c >= '0' && c <= '9') {
            return CLS_DIGIT;
        }
        if (c == '+' || c == '-') {
            return CLS_SIGN;
        }
        if (c == '.') {
            return CLS_DOT;
        }
        if (c == 'e' || c == 'E') {
            return CLS_EXP;
        }
        if (c == ' ') {
            return CLS_SPACE;
        }
        return CLS_OTHER;
    }
}
