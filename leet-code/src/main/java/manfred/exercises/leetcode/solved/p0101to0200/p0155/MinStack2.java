package manfred.exercises.leetcode.solved.p0101to0200.p0155;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 最小栈 —— 双端队列 + 小顶堆（重刷实现）。
 *
 * <p>思路：{@link ArrayDeque} 维护栈操作顺序，{@link PriorityQueue}（小顶堆）维护当前最小值。
 * push 同步入队与堆；pop 时从队列出栈并 {@code remove} 堆中同值；getMin 取堆顶。
 *
 * <p>复杂度：push O(log n)（堆插入），top / getMin O(1)，pop O(n)（堆 remove 为线性查找）；空间 O(n)。
 * 最优解通常用「辅助栈同步记录历史最小值」，可做到 push / pop / getMin 全 O(1)。
 */
class MinStack2 {

    private Deque<Integer> queue = new ArrayDeque<>();

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public MinStack2() {

    }

    public void push(int x) {
        queue.push(x);
        priorityQueue.offer(x);
    }

    public void pop() {
        Integer p = queue.pop();
        priorityQueue.remove(p);
    }

    public int top() {
        return queue.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}
