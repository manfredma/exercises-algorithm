/*

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0148;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/sort-list/ */

/**
 * LeetCode 第 148 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例 1: 4->2->1->3 → 1->2->3->4
        assertSorted(new int[]{4, 2, 1, 3}, new int[]{1, 2, 3, 4});
        // 示例 2: -1->5->3->4->0 → -1->0->3->4->5
        assertSorted(new int[]{-1, 5, 3, 4, 0}, new int[]{-1, 0, 3, 4, 5});
        // 边界: 3->2->4 → 2->3->4
        assertSorted(new int[]{3, 2, 4}, new int[]{2, 3, 4});
        System.out.println("p0148 passed");
    }

    /** 构造链表、排序后收集为 int[]，与期望数组深度比较。 */
    private static void assertSorted(int[] input, int[] expected) {
        ListNode head = buildList(input);
        ListNode sorted = new Solution().sortList(head);
        assertArrayEquals(expected, toArray(sorted));
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

    private static int[] toArray(ListNode head) {
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
