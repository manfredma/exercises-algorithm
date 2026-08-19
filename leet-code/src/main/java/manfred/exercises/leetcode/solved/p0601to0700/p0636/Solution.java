package manfred.exercises.leetcode.solved.p0601to0700.p0636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 第 636 题「函数的独占时间」：栈保存调用帧的已累计独占时间和恢复时间。
 *
 * <p>子函数开始时先结算父函数从上次恢复到当前时间前的运行区间；子函数结束时，
 * 结算其此前累计时间和最后一段闭区间，并把父函数恢复时间设为 {@code end + 1}。
 * {@link Solution2} 使用函数 ID 栈和单个上一时间点表达相同逻辑，可读性更高。</p>
 *
 * <p>时间复杂度 {@code O(logs.length)}，栈空间 {@code O(logs.length)}。</p>
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] r = new int[n];
        Deque<int[]> deque = new ArrayDeque<>();
        for (String s : logs) {
            int[] log = parseLogs(s);
            // 是 end
            if (log[1] == 0) {
                int[] executeLog = deque.pop();
                // 函数结束时，将时间汇总到函数的执行时间上去。本函：本次调用之前的累计时间 + 最后一段的执行时间
                r[executeLog[0]] += executeLog[1] + log[2] - executeLog[2] + 1;
                if (!deque.isEmpty()) {
                    deque.peek()[2] = log[2] + 1;
                }
            } else {
                // 给调用函数加上时间，需要等本次调用结束之后再启用
                if (!deque.isEmpty()) {
                    deque.peek()[1] += log[2] - deque.peek()[2];
                }
                deque.push(new int[]{log[0], 0, log[2]});
            }
        }
        return r;
    }

    private int[] parseLogs(String logs) {
        int[] r = new int[3];
        String[] s = logs.split(":");
        r[0] = Integer.parseInt(s[0]);
        r[1] = (s[1].equals("start") ? 1 : 0);
        r[2] = Integer.parseInt(s[2]);
        return r;
    }
}
