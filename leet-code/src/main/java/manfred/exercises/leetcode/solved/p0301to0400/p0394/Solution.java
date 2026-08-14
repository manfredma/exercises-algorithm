package manfred.exercises.leetcode.solved.p0301to0400.p0394;

import java.util.Stack;

/**
 * 字符串解码 —— 单字符栈解法（朴素版）。
 *
 * <p>思路：所有字符按序压栈，遇到 ']' 触发展开——弹出 '[' 之上的字符得到子串，
 * 再弹出前导数字得到重复次数，把子串按次数逐字符重新压回。最后弹出全部字符拼接。
 * 嵌套靠「内层先遇 ']' 先展开、结果压回栈后被外层复用」天然支持。
 *
 * <p>注意：{@code insert(0, ...)} 每次把已有字符整体后移，单次 O(n)，
 * 最坏退化为 O(输出长度²)。多位数靠 {@code pow} 逐位加权还原。
 *
 * <p>复杂度：时间 O(输出长度)~O(输出长度²)，空间 O(输出长度)。
 * 与 {@link Solution3} 同思路，仅命名与细节不同。
 */
class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (']' == s.charAt(i)) {
                // 弹出 '[' 之上的字符，还原成子串
                StringBuilder segment = new StringBuilder();
                while (stack.peek() != '[') {
                    segment.insert(0, stack.pop());
                }
                stack.pop();
                // 弹出前导数字，逐位加权还原重复次数（栈顶是个位）
                int digitPos = 0;
                int repeatCount = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    repeatCount += (int) Math.pow(10, digitPos) * (stack.pop() - '0');
                    digitPos++;
                }
                // 子串按次数逐字符重新压回栈，供外层或后续复用
                for (int j = 0; j < repeatCount; j++) {
                    for (int k = 0; k < segment.length(); k++) {
                        stack.push(segment.charAt(k));
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        // 栈顶在末尾，insert(0,...) 还原成原顺序
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
