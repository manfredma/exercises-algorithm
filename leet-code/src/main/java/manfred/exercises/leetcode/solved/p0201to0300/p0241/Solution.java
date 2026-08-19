package manfred.exercises.leetcode.solved.p0201to0300.p0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * LeetCode 第 241 题「为运算表达式设计优先级」：朴素递归分治基线解法。
 *
 * <p>枚举每个运算符作为当前表达式最后执行的运算，递归取得左右子表达式的全部结果后做
 * 笛卡尔积组合。该实现会重复计算相同区间，保留用于与 {@link Solution2} 的记忆化递归和
 * {@link Solution3} 的区间 DP 对照。</p>
 *
 * <p>结果数量本身呈 Catalan 数增长；由于重复子问题，本实现的额外递归开销高于后两种解法。</p>
 */
class Solution {

    Map<Character, BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();

    {
        operator.put('+', Integer::sum);
        operator.put('-', (a, b) -> a - b);
        operator.put('*', (a, b) -> a * b);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return calculate(expression, 0, expression.length() - 1);
    }

    private List<Integer> calculate(String expression, int start, int end) {
        List<Integer> r = new ArrayList<>();
        boolean isOneInteger = isOneInteger(expression, start, end);
        if (isOneInteger) {
            r.add(Integer.parseInt(expression.substring(start, end + 1)));
            return r;
        }
        for (int i = start; i <= end; i++) {
            if (operator.containsKey(expression.charAt(i))) {
                List<Integer> left = calculate(expression, start, i - 1);
                List<Integer> right = calculate(expression, i + 1, end);
                BiFunction<Integer, Integer, Integer> op = operator.get(expression.charAt(i));
                for (Integer la : left) {
                    for (Integer ra : right) {
                        r.add(op.apply(la, ra));
                    }
                }
            }
        }
        return r;
    }

    private boolean isOneInteger(String expression, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
