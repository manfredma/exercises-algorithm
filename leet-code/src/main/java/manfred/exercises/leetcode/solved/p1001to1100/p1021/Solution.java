package manfred.exercises.leetcode.solved.p1001to1100.p1021;

/**
 * LeetCode 第 1021 题「删除最外层的括号」：使用嵌套深度计数器。
 *
 * <p>读入左括号后深度由 0 变为 1 时，它是一个原语的最外层左括号，应跳过；
 * 读入右括号前深度为 1 时，它是对应的最外层右括号，也应跳过。其他括号属于
 * 原语内部，追加到结果即可。</p>
 *
 * <p>时间复杂度 {@code O(n)}，额外空间 {@code O(n)}（返回结果）。</p>
 */
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder r = new StringBuilder();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (++level != 1) {
                    r.append('(');
                }
            } else if (s.charAt(i) == ')') {
                if (level-- != 1) {
                    r.append(')');
                }
            }
        }
        return r.toString();
    }
}
