package manfred.exercises.leetcode.solved.p1101to1200.p1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 第 1190 题「反转每对括号间的子串」：再刷解法，跳转遍历法，O(n)。
 * <p>
 * 思路：括号嵌套反转等价于「在配对括号间跳转并翻转方向」。先用栈预处理 pair 数组
 * （pair[i] = i 处 '(' 或 ')' 的配对括号下标，双向映射）；再从 0 起按 dir=+1 遍历，
 * 遇 '(' 或 ')' 跳到 pair[i] 并翻转 dir，遇字母则收集。
 * <p>
 * 关键点：跳转+翻方向恰好实现「嵌套越深方向翻转越多次」——奇数层字符反向、偶数层正向，
 * 与「从内到外逐层反转」语义等价，但用方向标志避免了实际反转区间。
 * 复杂度：时间 O(n)（预处理 + 遍历各一趟，每字符访问一次），空间 O(n)（pair 数组）。
 * <p>
 * 与 {@link Solution} 对比：旧解遇 ')' 反转 charArray 区间为 O(n²)；本解消除重复扫描，
 * 是 1190 题的最优解。
 */
class Solution2 {

    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int open = stack.pop();
                pair[open] = i;
                pair[i] = open;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        int dir = 1;
        while (i >= 0 && i < n) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                result.append(c);
            }
            i += dir;
        }
        return result.toString();
    }
}
