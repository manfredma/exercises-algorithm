package manfred.exercises.leetcode.solved.p0201to0300.p0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 第 241 题「为运算表达式设计优先级」：记忆化递归分治。
 *
 * <p>枚举每个运算符作为当前区间最后执行的运算，将左右子区间的所有结果做笛卡尔积。
 * 使用区间 {@code [start, end]} 作为缓存键，避免同一子表达式在不同括号划分路径中
 * 被重复计算。</p>
 *
 * <p>设最终结果数为 {@code R}，时间和空间都至少为 {@code Ω(R)}；记忆化消除了重复子区间
 * 计算，额外缓存空间为 {@code O(n²)} 个区间结果。</p>
 */
class Solution2 {
    private final Map<Integer, List<Integer>> memo = new HashMap<Integer, List<Integer>>();
    private String expression;
    private int expressionLength;

    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        this.expressionLength = expression.length();
        memo.clear();
        return compute(0, expressionLength - 1);
    }

    private List<Integer> compute(int start, int end) {
        int key = start * expressionLength + end;
        List<Integer> cached = memo.get(key);
        if (cached != null) {
            return cached;
        }

        List<Integer> result = new ArrayList<Integer>();
        boolean hasOperator = false;
        for (int i = start; i <= end; i++) {
            char operator = expression.charAt(i);
            if (operator != '+' && operator != '-' && operator != '*') {
                continue;
            }
            hasOperator = true;
            List<Integer> leftResults = compute(start, i - 1);
            List<Integer> rightResults = compute(i + 1, end);
            for (int left : leftResults) {
                for (int right : rightResults) {
                    result.add(calculate(left, right, operator));
                }
            }
        }
        if (!hasOperator) {
            result.add(parseNumber(start, end));
        }
        memo.put(key, result);
        return result;
    }

    private int parseNumber(int start, int end) {
        int number = 0;
        for (int i = start; i <= end; i++) {
            number = number * 10 + expression.charAt(i) - '0';
        }
        return number;
    }

    private int calculate(int left, int right, char operator) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            default:
                return left * right;
        }
    }
}
