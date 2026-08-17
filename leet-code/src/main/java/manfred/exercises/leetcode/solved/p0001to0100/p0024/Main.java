/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0024;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/swap-nodes-in-pairs/ */

/**
 * LeetCode 第 24 题「两两交换链表中的节点」的测试入口。
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
        // 1->2->3->4->5->6 两两交换后为 2->1->4->3->6->5
        ListNode l = new Solution().swapPairs(n1);
        assertArrayEquals(new int[]{2, 1, 4, 3, 6, 5}, listValues(l));
        System.out.println("p0024 passed");
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
