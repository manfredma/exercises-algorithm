package manfred.exercises.leetcode.solved.p0201to0300.p0227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 第 227 题「基本计算器 II」：符号跟踪栈（preSign），227 题标准最优解。
 * <p>
 * 思路：单趟扫描，preSign 记录当前数字前的运算符（默认 '+'）。遇运算符或串尾时按 preSign 处理
 * 当前 num：{@code +} 压 num、{@code -} 压 -num、{@code *}{@code /} 与栈顶弹出的数即时计算后压回。
 * 扫完栈内全为「带符号的项」，求和即结果。
 * <p>
 * 关键点：乘除在入栈时即与栈顶消解，保证优先级高于加减；加减项延迟到末尾求和。
 * 复杂度：时间 O(n)，空间 O(n)。
 * <p>
 * 定位：本解是 227 题的首选模板（~30 行、单趟、易读）。对照 {@link Solution}（混合栈，装箱慢）、
 * {@link Solution3}（递归下降 + lastAdded 撤销技巧，正确但隐晦）。
 */
class Solution2 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}

