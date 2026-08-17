/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0203;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/remove-linked-list-elements/ */

/**
 * LeetCode 第 203 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode node = new Solution().removeElements(listNode1, 6);

        // 题面示例: 输入 1->2->6->3->4->5->6, val=6 → 输出 1->2->3->4->5
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(node.next == null ? "" : "->");
            node = node.next;
        }
        assertEquals("1->2->3->4->5", sb.toString());
        System.out.println("p0203 passed");
    }
}
