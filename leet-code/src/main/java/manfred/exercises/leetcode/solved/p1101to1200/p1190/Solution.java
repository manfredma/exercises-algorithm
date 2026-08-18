package manfred.exercises.leetcode.solved.p1101to1200.p1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 第 1190 题「反转每对括号间的子串」：反转配对区间法，O(n²)。
 * <p>
 * 思路：用栈记录 '(' 下标，遇 ')' 反转 charArray 中 [open, close] 区间；扫完过滤括号拼结果。
 * 嵌套括号因「内层先反转、外层后反转」自然得到正确结果。
 * <p>
 * 复杂度：时间 O(n²)（每次反转最坏 O(n)），空间 O(n)。
 * 对照 {@link Solution2}（跳转遍历法 O(n)）为更优解。
 */
class Solution {
    public String reverseParentheses(String s) {
        char[] charArray = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 直接记录配对坐标
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                reverse(charArray, stack.pop(), i);
            }
        }
        StringBuilder r = new StringBuilder();
        for (char c : charArray) {
            if (c != '(' && c != ')') {
                r.append(c);
            }
        }
        return r.toString();
    }

    private void reverse(char[] arr, int from, int end) {
        while (from < end) {
            char tmp = arr[from];
            arr[from] = arr[end];
            arr[end] = tmp;
            from++;
            end--;
        }
    }
}
