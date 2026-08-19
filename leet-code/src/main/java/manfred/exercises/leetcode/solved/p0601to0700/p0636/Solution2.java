package manfred.exercises.leetcode.solved.p0601to0700.p0636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode 第 636 题「函数的独占时间」：函数 ID 栈加上一条日志的后继时间点。
 *
 * <p>栈顶始终是正在运行的函数。处理 {@code start} 日志时，先把栈顶从
 * {@code previousTime} 运行到当前时间之前的部分计入答案；处理 {@code end} 日志时，
 * 把栈顶从 {@code previousTime} 到结束时间的闭区间计入答案，并将下一段的起点设为
 * {@code end + 1}。</p>
 *
 * <p>时间复杂度 {@code O(logs.length)}，栈空间 {@code O(logs.length)}。</p>
 */
class Solution2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> callStack = new ArrayDeque<Integer>();
        int previousTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            int timestamp = Integer.parseInt(parts[2]);
            if ("start".equals(parts[1])) {
                if (!callStack.isEmpty()) {
                    result[callStack.peek()] += timestamp - previousTime;
                }
                callStack.push(functionId);
                previousTime = timestamp;
            } else {
                result[callStack.pop()] += timestamp - previousTime + 1;
                previousTime = timestamp + 1;
            }
        }
        return result;
    }
}
