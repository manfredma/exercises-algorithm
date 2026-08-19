package manfred.exercises.leetcode.solved.p0201to0300.p0241;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 241 题「为运算表达式设计优先级」：自底向上区间 DP。
 *
 * <p>先将表达式拆为数字和运算符。{@code dp[left][right]} 保存从第 {@code left} 个数字到
 * 第 {@code right} 个数字的所有结果；枚举最后运算的运算符，将两个更短区间的结果做笛卡尔积。
 * 与 {@link Solution2} 的递归分治等价，但没有递归调用和缓存查找。</p>
 *
 * <p>设最终结果数为 {@code R}，时间和空间都至少为 {@code Ω(R)}；DP 表保存 {@code O(n²)}
 * 个区间结果。</p>
 */
class Solution3 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> numbers = new ArrayList<Integer>();
        List<Character> operators = new ArrayList<Character>();
        parse(expression, numbers, operators);

        int count = numbers.size();
        @SuppressWarnings("unchecked")
        List<Integer>[][] dp = (List<Integer>[][]) new List[count][count];
        for (int i = 0; i < count; i++) {
            dp[i][i] = new ArrayList<Integer>();
            dp[i][i].add(numbers.get(i));
        }

        for (int length = 2; length <= count; length++) {
            for (int left = 0; left + length <= count; left++) {
                int right = left + length - 1;
                dp[left][right] = new ArrayList<Integer>();
                for (int split = left; split < right; split++) {
                    char operator = operators.get(split);
                    for (int first : dp[left][split]) {
                        for (int second : dp[split + 1][right]) {
                            dp[left][right].add(calculate(first, second, operator));
                        }
                    }
                }
            }
        }
        return dp[0][count - 1];
    }

    private void parse(String expression, List<Integer> numbers, List<Character> operators) {
        int number = 0;
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character >= '0' && character <= '9') {
                number = number * 10 + character - '0';
            } else {
                numbers.add(number);
                operators.add(character);
                number = 0;
            }
        }
        numbers.add(number);
    }

    private int calculate(int first, int second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            default:
                return first * second;
        }
    }
}
