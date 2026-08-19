package manfred.exercises.leetcode.solved.p0801to0900.p0856;

/**
 * LeetCode 第 856 题「括号的分数」：递归下降计算每个原语及其同层兄弟的分数。
 *
 * <p>递归进入左括号后计算其内部表达式；最内层 {@code ()} 的基础分为 1，
 * 非空内部表达式通过 {@code 2 * score} 计算。遇到本层右括号后，若后续仍是左括号，
 * 继续递归并累加同层原语。{@link Solution2} 用显式栈表达同一规则，可读性更直接。</p>
 *
 * <p>时间复杂度 {@code O(n)}，递归栈空间 {@code O(n)}。</p>
 */
class Solution {
    public int scoreOfParentheses(String s) {
        // 使用递归下降的方式来计算，每次计算一层
        return scoreOfLevel(s, new int[]{0});
    }

    private int scoreOfLevel(String s, int[] cur) {
        int result = 1;
        cur[0]++; // 过滤第一个左括号
        while (cur[0] < s.length()) {
            if (s.charAt(cur[0]) == '(') {
                // * 下一层的分数
                result = 2 * scoreOfLevel(s, cur);
            } else {
                // 遇到同级的右括号就要考虑是否还有同层的兄弟，如果有，就继续计算
                cur[0]++;
                if (cur[0] < s.length() && s.charAt(cur[0]) == '(') {
                    // 本层的分数需要相加，因此需要链式传递下去！
                    result += scoreOfLevel(s, cur);
                }
                break;
            }
        }
        return result;
    }
}
