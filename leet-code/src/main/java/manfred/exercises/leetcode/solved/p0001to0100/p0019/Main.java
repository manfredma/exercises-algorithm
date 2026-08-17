/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do it in one pass?
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0019;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/ */

/**
 * LeetCode 第 19 题「删除链表的倒数第 N 个节点」的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        ListNode n = new ListNode(5);
        ListNode n2 = new ListNode(4);
        n2.next = n;
        ListNode n3 = new ListNode(3);
        n3.next = n2;
        ListNode n4 = new ListNode(2);
        n4.next = n3;
        ListNode n5 = new ListNode(1);
        n5.next = n4;
        Solution solution = new Solution();
        // 1->2->3->4->5，删除倒数第 5 个（即头节点）后为 2->3->4->5
        ListNode r = solution.removeNthFromEnd(n5, 5);
        assertArrayEquals(new int[]{2, 3, 4, 5}, listValues(r));

        ListNode n6 = new ListNode(5);
        // 单节点删除倒数第 1 个后为 null
        ListNode n7 = solution.removeNthFromEnd(n6, 1);
        assertNull(n7);
        System.out.println("p0019 passed");
    }

    private static int[] listValues(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] values = new int[count];
        cur = head;
        for (int i = 0; i < count; i++) {
            values[i] = cur.val;
            cur = cur.next;
        }
        return values;
    }
}
