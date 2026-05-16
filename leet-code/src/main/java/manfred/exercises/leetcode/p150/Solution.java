package manfred.exercises.leetcode.p150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 第 150 题「逆波兰表达式求值」：栈，遇数字入栈，遇运算符弹出两个操作数计算后入栈。
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
            } else if (operatorStr.contains(stack.peek())) {
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