package manfred.exercises.leetcode.solved.p0301to0400.p0394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 字符串解码 —— 单字符栈解法（朴素版，重刷实现）。
 *
 * <p>思路：所有字符按序压栈，遇到 ']' 触发展开——弹出 '[' 之上的字符得到子串，
 * 再弹出前导数字得到重复次数，把子串按次数逐字符重新压回。最后弹出全部字符拼接。
 * 嵌套靠「内层先遇 ']' 先展开、结果压回栈后被外层复用」天然支持。
 *
 * <p>注意两点：
 * <ul>
 *   <li>{@code insert(0, ...)} 每次把已有字符整体后移，单次 O(n)，最坏退化为
 *       O(输出长度²)。可改为 append + reverse，或参考 {@link Solution2} 的双栈写法。</li>
 *   <li>多位数解析必须 {@code pow++} 逐位加权，否则栈顶个位之外的数位都会丢失
 *       （单位数用例无法暴露此 bug，需用 10[leetcode]、100[a] 等多位数用例覆盖）。</li>
 * </ul>
 *
 * <p>复杂度：时间 O(输出长度)~O(输出长度²)，空间 O(输出长度)。
 */
class Solution3 {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                // 弹出 '[' 之上的字符，还原成子串
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                // 弹出左中括号
                stack.pop();

                // 弹出前导数字，逐位加权还原重复次数（栈顶是个位，pow 从 0 递增）
                int dup = 0;
                int pow = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    dup += (int) ((stack.pop() - '0') * Math.pow(10, pow));
                    pow++;
                }

                // 子串按次数逐字符重新压回栈，供外层或后续复用
                for (int j = 0; j < dup; j++) {
                    for (int k = 0; k < sb.length(); k++) {
                        stack.push(sb.charAt(k));
                    }
                }
            }
        }

        // 栈顶在末尾，insert(0,...) 还原成原顺序
        StringBuilder r = new StringBuilder();
        while (!stack.isEmpty()) {
            r.insert(0, stack.pop());
        }
        return r.toString();
    }
}
