package manfred.exercises.leetcode.solved.p0101to0200.p0150;

/**
 * LeetCode 第 150 题「逆波兰表达式求值」：再刷解法，性能优化版。
 * <p>
 * 思路：正向扫描 tokens——数字 parseInt 后压栈，运算符弹两个数计算压回。
 * 与 {@link Solution2} 的函数式映射不同，本解用 switch 直算 + int[] 数组模拟栈，
 * 消除 HashMap 查找、BiFunction 接口分发与 Integer 装箱三重常数开销。
 * <p>
 * 关键点：运算符均为单字符，用 {@code token.length()==1} 区分运算符与负数（如 "-11"），
 * 避免 switch 按首字符误判；减除顺序为 a op b（先弹 b 再弹 a）。
 * 复杂度：时间 O(n)，空间 O(n)（int[] 预分配 tokens 长度）。
 * <p>
 * 性能：相比 Solution2 击败 11.33%（8ms），本解消除装箱与哈希开销，常数显著降低。
 */
class Solution3 {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            if (token.length() == 1) {
                char c = token.charAt(0);
                // 单字符可能是运算符或单数字（含 "-"/"+" 单字符非法输入，题目保证合法故按运算符）
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    int b = stack[top--];
                    int a = stack[top--];
                    int r;
                    switch (c) {
                        case '+': r = a + b; break;
                        case '-': r = a - b; break;
                        case '*': r = a * b; break;
                        default:  r = a / b; break; // '/'
                    }
                    stack[++top] = r;
                    continue;
                }
            }
            stack[++top] = Integer.parseInt(token);
        }
        return stack[top];
    }
}
