package manfred.exercises.leetcode.solved.p0001to0100.p0013;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 13 题「罗马数字转整数」：再刷对照解，栈 + 双倍扣减法。
 * <p>
 * 思路：先把所有字符值累加到 sum；当遇到「当前值比前一个大」时，说明前面的较小值
 * 本应是「减」而非「加」，用栈收集这些小值到 sub，最终 sum - 2*sub 双倍扣回
 * （一次抵消已加的、一次实现真正的减）。
 * <p>
 * 关键点：罗马数字「小在大前」表减法，sum 已误加这些小值，故对它们扣两倍。
 * 复杂度：时间 O(n)，空间 O(n)（Deque 栈，劣于 {@link Solution} 的 O(1)）。
 * <p>
 * 保留作对比：非标准写法，可读性差、空间多一个栈；{@link Solution} 用「右邻比较直接加减」
 * 更直观且 O(1) 空间，是首选。本解仅作「不同思路对照」留存。
 */
class Solution2 {
    public int romanToInt(String s) {
        Map<Character, Integer> romanChar = new HashMap<>();
        romanChar.put('I', 1);
        romanChar.put('V', 5);
        romanChar.put('X', 10);
        romanChar.put('L', 50);
        romanChar.put('C', 100);
        romanChar.put('D', 500);
        romanChar.put('M', 1000);

        Deque<Integer> values = new ArrayDeque<>();
        int sub = 0;
        int sum = 0;
        int cur = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = romanChar.get(c);
            sum += value;
            if (cur < value) {
                // 将较小的值全部弹出并加到待扣减的值中
                while (!values.isEmpty() && values.peek() < value) {
                    sub += values.pop();
                }
            }
            cur = value;
            values.push(value);
        }
        return sum - 2 * sub;
    }
}
