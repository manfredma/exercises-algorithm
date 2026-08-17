/*
Given a linked list and a value x,
partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */

package manfred.exercises.leetcode.solved.p0001to0100.p0086;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/partition-list/ */

/**
 * LeetCode 第 86 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例: 1->4->3->2->5->2, x=3 → 1->2->2->4->3->5
        ListNode head = buildList(new int[]{1, 4, 3, 2, 5, 2});
        Solution solution = new Solution();
        ListNode r = solution.partition(head, 3);
        assertArrayEquals(new int[]{1, 2, 2, 4, 3, 5}, toValues(r));

        // 边界: 全部大于等于 x，原序保留
        ListNode head2 = buildList(new int[]{4, 5, 6});
        ListNode r2 = solution.partition(head2, 3);
        assertArrayEquals(new int[]{4, 5, 6}, toValues(r2));

        // 边界: 全部小于 x，原序保留
        ListNode head3 = buildList(new int[]{1, 2});
        ListNode r3 = solution.partition(head3, 3);
        assertArrayEquals(new int[]{1, 2}, toValues(r3));

        System.out.println("p0086 passed");
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
