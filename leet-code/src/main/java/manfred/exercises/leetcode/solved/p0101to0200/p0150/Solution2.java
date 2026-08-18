package manfred.exercises.leetcode.solved.p0101to0200.p0150;

import java.util.*;
import java.util.function.BiFunction;

/**
 * LeetCode 第 150 题「逆波兰表达式求值」：再刷解法，正向栈法 + BiFunction 运算符映射。
 * <p>
 * 思路：从左到右扫 tokens——数字 parseInt 入栈，运算符从 Map 取 BiFunction、弹两个数计算压回。
 * <p>
 * 关键点：减法/除法对操作数顺序敏感（a-b ≠ b-a），而两次 pop 先弹 b 再弹 a，
 * 故 lambda 形参写成 (b, a) -> a - b，用参数顺序化解 pop 顺序，无需临时变量交换。
 * 复杂度：时间 O(n)，空间 O(n)。
 * <p>
 * 风格：函数式映射优雅、运算符集中可扩展；但 HashMap 查找 + BiFunction 接口分发 + Integer 装箱
 * 带来常数开销，LeetCode 实测击败 11.33%（8ms）。追求性能见 {@link Solution3}
 * （switch 直算 + int[] 栈消除装箱）。与旧 {@link Solution}（逆向、绕且脆）对照。
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
