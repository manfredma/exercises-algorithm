package manfred.exercises.leetcode.solved.p0101to0200.p0150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 第 150 题「逆波兰表达式求值」：逆向栈法，从右向左扫描 tokens。
 * <p>
 * 思路：逆序取 token——运算符入栈；数字入栈前若栈顶是运算符则暂存待算，否则触发计算
 * （弹运算符 + 数字，算完压回）。逆向处理使数字先于其右侧运算符落定。
 * <p>
 * 修复（2026-08-18）：原版第 26 行 {@code stack.peek()} 在首次循环、栈空时抛
 * {@code EmptyStackException}，单元素输入 {@code ["42"]} 崩溃。补 {@code !stack.isEmpty()}
 * 前置判断后，单元素落到 else 分支直接入栈返回，正确处理。
 * <p>
 * 注：本解逆向写法绕且脆（EXPRESSION_REVIEW 记录的「绕且脆」评价），保留作对照；
 * {@link Solution2} 的正向栈法 + BiFunction 映射为标准首选。
 * 复杂度：时间 O(n)，空间 O(n)。
 */
class Solution {
    private List<String> operatorStr = new ArrayList<>();

    {
        operatorStr.add("+");
        operatorStr.add("-");
        operatorStr.add("*");
        operatorStr.add("/");
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String curToken = tokens[tokens.length - 1 - i];
            if (operatorStr.contains(curToken)) {
                stack.push(curToken);
            } else if (!stack.isEmpty() && operatorStr.contains(stack.peek())) {
                stack.push(curToken);
            } else {
                while (!stack.isEmpty()) {
                    if (!operatorStr.contains(stack.peek())) {
                        curToken = operator(stack, curToken);
                    } else {
                        break;
                    }
                }
                stack.push(curToken);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private String operator(Stack<String> stack, String curToken) {
        int result;
        String operator2 = stack.pop();
        String operator = stack.pop();
        if (operator.equals("+")) {
            result = Integer.parseInt(curToken) + Integer.parseInt(operator2);
        } else if (operator.equals("-")) {
            result = Integer.parseInt(curToken) - Integer.parseInt(operator2);
        } else if (operator.equals("*")) {
            result = Integer.parseInt(curToken) * Integer.parseInt(operator2);
        } else {
            result = Integer.parseInt(curToken) / Integer.parseInt(operator2);
        }
        return String.valueOf(result);
    }
}