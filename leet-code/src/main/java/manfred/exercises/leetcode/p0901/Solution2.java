package manfred.exercises.leetcode.p0901;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    // 栈存储 [价格, 跨度]，弹出时把跨度累加，无需额外列表
    private final Deque<int[]> stack = new ArrayDeque<>();

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
