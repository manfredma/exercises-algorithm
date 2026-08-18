package manfred.exercises.leetcode.solved.p1201to1300.p1249;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 第 1249 题「移除无效的括号」：栈标记无效括号，两趟扫描。
 * <p>
 * 思路：第一趟用栈配对——遇 '(' 下标入栈，遇 ')' 栈非空则 pop 配对、栈空则标记该 ')' 无效；
 * 末尾栈里残留的下标（未配对的 '('）也标记无效。第二趟跳过无效下标构建结果串。
 * <p>
 * 关键点：栈存下标而非字符，便于第二趟按位置过滤；字母字符不影响配对。
 * 复杂度：时间 O(n)，空间 O(n)（栈 + 无效集合）。本解已是 1249 题最优解。
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidBrace = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    invalidBrace.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            invalidBrace.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidBrace.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
