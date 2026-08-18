package manfred.exercises.leetcode.solved.p0201to0300.p0227;

import java.util.Stack;

/**
 * LeetCode 第 227 题「基本计算器 II」：混合栈，数字与运算符同栈，乘除即时算、加减末尾汇总。
 * <p>
 * 思路：replaceAll 去空格后扫描——数字与运算符依次压入 {@code Stack<Object>}；遇 {@code *}{@code /}
 * 立即弹栈顶两元素（左操作数与运算符）计算后压回；遇 {@code +}{@code -} 仅压栈。
 * 扫完遍历栈：从首元素起，按 +/- 把后续数字累加得到结果。
 * <p>
 * 缺点：{@code Stack<Object>} 装箱与 (Character)/(Integer) 强转类型不安全且慢；
 * replaceAll 多一次 O(n) 串拷贝。保留作对照。
 * 复杂度：时间 O(n)，空间 O(n)。
 * <p>
 * 对照 {@link Solution2}（符号跟踪栈，preSign 单趟更优）、{@link Solution3}（递归下降 + lastAdded 撤销技巧）。
 */
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int index = 0;
        Stack<Object> stack = new Stack<>();
        index = parseInteger(s, index, stack);

        while (index < s.length()) {
            index = parseOp(s, index, stack);
            char op = (Character) stack.peek();
            index = parseInteger(s, index, stack);
            if (op == '*' || op == '/') {
                int right = (Integer) stack.pop();
                char x = (Character) stack.pop();
                int left = (Integer) stack.pop();
                if (x == '*') {
                    stack.push(right * left);
                } else {
                    stack.push(left / right);
                }
            }
        }

        int result = (Integer) stack.get(0);
        for (int i = 1; i < stack.size(); i = i + 2) {
            if ((Character) stack.get(i) == '+') {
                result = result + (Integer) stack.get(i + 1);
            } else {
                result = result - (Integer) stack.get(i + 1);
            }
        }
        return result;
    }

    private int parseInteger(String s, int index, Stack<Object> stack) {
        StringBuilder x = new StringBuilder();
        while (index < s.length()) {
            if (!Character.isDigit(s.charAt(index))) {
                break;
            }
            x.append(s.charAt(index));
            index++;
        }

        stack.push(Integer.parseInt(x.toString()));
        return index;
    }

    private int parseOp(String s, int index, Stack<Object> stack) {
        stack.push(s.charAt(index));
        return ++index;
    }
}