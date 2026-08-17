/*
/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

 */

package manfred.exercises.leetcode.solved.p0201to0300.p0206;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-linked-list/ */

/**
 * LeetCode 第 206 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例: 1->2->3->4->5 → 5->4->3->2->1
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode r = solution.reverseList(head);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toValues(r));

        // 边界: 单节点反转后不变
        ListNode single = buildList(new int[]{1});
        ListNode rs = solution.reverseList(single);
        assertArrayEquals(new int[]{1}, toValues(rs));

        // 边界: 空链表
        assertNull(solution.reverseList(null));

        System.out.println("p0206 passed");
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static int[] toValues(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        int[] arr = new int[size];
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            arr[i++] = cur.val;
        }
        return arr;
    }
}
