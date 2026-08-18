package manfred.exercises.leetcode.solved.p0201to0300.p0224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 第 224 题「基本计算器」：再刷解法，符号跟踪栈。
 * <p>
 * 思路：单趟扫描，用栈记录括号层级的符号上下文。核心观察——每个操作数的实际符号
 * = 其前所有括号层的符号乘积。栈顶存「当前括号层的累积符号」，遇 '(' 压入当前符号上下文，
 * 遇 ')' 弹出；遇 +/- 时前一个数字按当前符号计入结果，并更新下一操作数的符号。
 * <p>
 * 关键点：括号嵌套的符号翻转通过栈自然传递（如 "-(2-(3+4))" 的符号层层相乘）；
 * 题面无 '*'/'/' 与连续运算符，故无需处理优先级。一元 '-' 靠「起始符号默认 +1、
 * 遇 - 翻转」自然支持（如 "-1+2" 开头遇 - 使首个操作数符号为 -1）。
 * 复杂度：时间 O(n)，空间 O(括号深度)。
 * <p>
 * 与 {@link Solution2} 对比：递归下降用调用栈解析（~70 行），本解用显式符号栈单趟扫描
 * （~25 行），无递归、更紧凑，是 EXPRESSION_REVIEW 建议的「栈 + 符号跟踪 ~20 行」方案。
 * <p>
 * 定位：本解是 224 题的**特化解**——其精巧建立在「运算符仅 +/-、无优先级差异、
 * 符号仅靠括号翻转」的强假设上。一旦题目演进（如 227 加 * / 需优先级、772 加幂），
 * 该假设失效即需重写。作为「针对本题的精妙特解 + 符号上下文乘积观察」有教学价值，
 * 但不可扩展；通用首选见 {@link Solution2}（递归下降）。
 */
class Solution3 {

    public int calculate(String s) {
        Deque<Integer> signStack = new ArrayDeque<>();
        signStack.push(1); // 全局符号上下文，初始正
        int result = 0;
        int num = 0;
        int sign = 1; // 当前操作数的符号
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * num; // 前一个数字计入结果
                num = 0;
                // 当前符号 = 栈顶上下文 × 本运算符；栈顶随括号层级翻转
                sign = signStack.peek() * (c == '+' ? 1 : -1);
            } else if (c == '(') {
                // 进入括号：压入当前操作数符号，括号内从此符号出发
                signStack.push(sign);
            } else if (c == ')') {
                result += sign * num; // 括号内末尾数字计入
                num = 0;
                signStack.pop(); // 退出括号，恢复外层上下文
                sign = signStack.peek();
            }
            // 空格忽略
        }
        result += sign * num; // 末尾残留数字
        return result;
    }
}
