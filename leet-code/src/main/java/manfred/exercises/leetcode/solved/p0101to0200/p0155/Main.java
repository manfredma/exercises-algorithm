package manfred.exercises.leetcode.solved.p0101to0200.p0155;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/min-stack/ */

/*
设计一个支持 push、pop、top 操作，并能在常数时间内检索到最小元素的栈。
- MinStack()
- void push(int value)
- void pop()
- int top()
- int getMin()

示例操作序列：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
输出：[null,null,null,null,-3,null,0,-2]
*/
/**
 * LeetCode 第 155 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例：官方用例
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());   // 最小 -3
        minStack.pop();                        // 弹出 -3
        assertEquals(0, minStack.top());       // 栈顶 0
        assertEquals(-2, minStack.getMin());   // 最小恢复 -2

        // 重刷：MinStack2 走相同操作序列
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        assertEquals(-3, minStack2.getMin());
        minStack2.pop();
        assertEquals(0, minStack2.top());
        assertEquals(-2, minStack2.getMin());

        // 辅助栈：MinStack3 走相同操作序列
        MinStack3 minStack3 = new MinStack3();
        minStack3.push(-2);
        minStack3.push(0);
        minStack3.push(-3);
        assertEquals(-3, minStack3.getMin());
        minStack3.pop();
        assertEquals(0, minStack3.top());
        assertEquals(-2, minStack3.getMin());

        // 边界: 递增入栈，最小始终是首个
        MinStack s2a = new MinStack();
        s2a.push(1);
        s2a.push(2);
        s2a.push(3);
        assertEquals(1, s2a.getMin());
        assertEquals(3, s2a.top());

        MinStack2 s2b = new MinStack2();
        s2b.push(1);
        s2b.push(2);
        s2b.push(3);
        assertEquals(1, s2b.getMin());
        assertEquals(3, s2b.top());

        MinStack3 s3c = new MinStack3();
        s3c.push(1);
        s3c.push(2);
        s3c.push(3);
        assertEquals(1, s3c.getMin());
        assertEquals(3, s3c.top());

        // 边界: 弹到只剩一个
        s2a.pop();
        s2a.pop();
        assertEquals(1, s2a.getMin());
        assertEquals(1, s2a.top());

        s2b.pop();
        s2b.pop();
        assertEquals(1, s2b.getMin());
        assertEquals(1, s2b.top());

        s3c.pop();
        s3c.pop();
        assertEquals(1, s3c.getMin());
        assertEquals(1, s3c.top());

        // 边界: 重复最小值入栈再弹出，辅助栈需同步
        MinStack3 s3d = new MinStack3();
        s3d.push(5);
        s3d.push(2);
        s3d.push(2);          // 重复当前最小值
        assertEquals(2, s3d.getMin());
        s3d.pop();            // 弹出一个 2，最小仍应为 2
        assertEquals(2, s3d.getMin());
        s3d.pop();            // 弹出最后一个 2，最小恢复 5
        assertEquals(5, s3d.getMin());
    }

}
