/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0021;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/merge-two-sorted-lists/ */

/**
 * LeetCode 第 21 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例: 1->2->4 与 1->3->4 → 1->1->2->3->4->4
        ListNode l1 = buildList(new int[]{1, 2, 4});
        ListNode m1 = buildList(new int[]{1, 3, 4});
        ListNode l = new Solution().mergeTwoLists(l1, m1);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, toValues(l));

        // 边界: 其中一条为空
        ListNode l2 = buildList(new int[]{1, 2, 3});
        ListNode empty = null;
        ListNode r2 = new Solution().mergeTwoLists(l2, empty);
        assertArrayEquals(new int[]{1, 2, 3}, toValues(r2));

        // 边界: 两条均为空
        ListNode r3 = new Solution().mergeTwoLists(null, null);
        assertNull(r3);

        System.out.println("p0021 passed");
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
