package manfred.exercises.leetcode.solved.p0301to0400.p0394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 字符串解码 —— 双栈解法（高效版）。
 *
 * <p>思路：用两个栈分别暂存「重复次数」和「外层已构造的字符串」。
 * 遇数字累积成 k（支持多位数），遇 '[' 把当前 k 和 current 压栈并重置，
 * 遇 ']' 弹出外层 current 与重复次数，把刚完成的子串重复拼接回外层。
 * 嵌套靠「外层状态压栈保护、内层完成后接续」实现。
 *
 * <p>相比单字符栈解法（{@link Solution}/{@link Solution3}）：以字符串为整体单位拼接，
 * 避免 {@code insert(0,...)} 的 O(n²) 后移；输出即 current，无需最后反转。
 *
 * <p>复杂度：时间 O(输出长度)，空间 O(输出长度 + 嵌套深度)。
 */
class Solution2 {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');          // 支持多位数，如 12[a]
            } else if (c == '[') {
                // 进入新一层：暂存外层状态，重置 current 与 k
                countStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // 内层完成：弹出外层 current 与重复次数，把子串重复接回外层
                String sub = current.toString();
                current = strStack.pop();
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    current.append(sub);
                }
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
