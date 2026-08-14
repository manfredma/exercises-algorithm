package manfred.exercises.leetcode.solved.p0101to0200.p0155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈 —— 辅助栈同步最小值（标准最优解）。
 *
 * <p>思路：主栈存操作值，辅助栈与主栈「同步入栈/出栈」，栈顶始终保存「当前历史最小值」。
 * push 时辅助栈入 {@code min(x, 辅助栈顶)}（首次入 x）；pop 时两栈同弹。
 * getMin 直接取辅助栈顶，无需扫描或堆维护。
 *
 * <p>复杂度：push / pop / top / getMin 均 O(1)；空间 O(n)（辅助栈最坏与主栈等长）。
 * 优于 {@link MinStack}（push O(n)）与 {@link MinStack2}（pop O(n)）。
 */
class MinStack3 {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack3() {
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
