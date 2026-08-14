package manfred.exercises.leetcode.solved.p0101to0200.p0155;

import java.util.Stack;

/**
 * 最小栈 —— 栈 + 升序双向链表（核心实现）。
 *
 * <p>思路：{@link Stack} 记录操作顺序（栈语义），另维护一条升序双向链表，
 * head 哨兵 {@code Integer.MIN_VALUE}、tail 哨兵 {@code Integer.MAX_VALUE}。
 * push 时沿链表找到首个 {@code >= x} 的节点并插在其前面（保持升序），同时入栈；
 * pop 时从栈和链表同时摘除；getMin 取 {@code head.next.val}（链表最小值）。
 *
 * <p>复杂度：push O(n)（链表找位），pop / top / getMin O(1)；空间 O(n)。
 */
class MinStack {

    private Stack<ListNode> stack = new Stack<>();
    private ListNode head;
    private ListNode tail;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        head = new ListNode(Integer.MIN_VALUE);
        tail = new ListNode(Integer.MAX_VALUE);

        head.next = tail;
        tail.pre = head;
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        ListNode next = head.next;
        while (next.val < node.val) {
            next = next.next;
        }
        ListNode pre = next.pre;
        node.next = next;
        node.pre = pre;
        pre.next = node;
        next.pre = node;
        stack.push(node);
    }

    public void pop() {
        ListNode listNode = stack.pop();
        ListNode pre = listNode.pre;
        ListNode next = listNode.next;
        pre.next = next;
        next.pre = pre;
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return head.next.val;
    }

    private static class ListNode {
        ListNode next;
        ListNode pre;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

}

