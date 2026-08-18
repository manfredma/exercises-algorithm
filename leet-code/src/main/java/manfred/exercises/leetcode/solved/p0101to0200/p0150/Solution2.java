package manfred.exercises.leetcode.solved.p0101to0200.p0150;

import java.util.*;
import java.util.function.BiFunction;

/**
 * LeetCode 第 150 题「逆波兰表达式求值」：再刷骨架，待填充；参考 EXPRESSION_REVIEW.md 改进方案重写。
 */
class Solution2 {


    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> expression = new HashMap<>();
        expression.put("+", Integer::sum);
        // 减法和除法用相反的顺序计算是因为其对前后顺序敏感
        expression.put("-", (b, a) -> a - b);
        expression.put("*", (b, a) -> a * b);
        expression.put("/", (b, a) -> a / b);

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (expression.containsKey(token)) {
                stack.push(expression.get(token).apply(stack.pop()/*b*/, stack.pop())/*a*/);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
