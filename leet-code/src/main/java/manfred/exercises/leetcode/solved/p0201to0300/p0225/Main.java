/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back,
peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively.
You may simulate a queue by using a list or deque (double-ended queue),
as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0225;

import static manfred.exercises.assertion.Assert.assertEquals;
import static manfred.exercises.assertion.Assert.assertFalse;

/** 题目链接：https://leetcode.cn/problems/implement-stack-using-queues/ */

/**
 * LeetCode 第 225 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        // returns 2
        assertEquals(2, stack.top());
        // returns 2
        assertEquals(2, stack.pop());
        // returns false
        assertFalse(stack.empty());
        System.out.println("p0225 passed");
    }
}
