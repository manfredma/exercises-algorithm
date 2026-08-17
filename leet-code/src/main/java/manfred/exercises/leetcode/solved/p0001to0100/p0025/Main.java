/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0025;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/ */

/**
 * LeetCode 第 25 题「K 个一组翻转链表」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        // 1->2->3->4->5->6 按 k=2 翻转后为 2->1->4->3->6->5
        ListNode l = new Solution().reverseKGroup(n1, 2);
        assertArrayEquals(new int[]{2, 1, 4, 3, 6, 5}, listValues(l));

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        l = new Solution2().reverseKGroup(n1, 2);
        assertArrayEquals(new int[]{2, 1, 4, 3, 6, 5}, listValues(l));
        System.out.println("p0025 passed");
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
