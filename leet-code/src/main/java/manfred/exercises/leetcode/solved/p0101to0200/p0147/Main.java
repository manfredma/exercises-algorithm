/*
Sort a linked list using insertion sort.

A graphical example of insertion sort.
The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data,
finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0147;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/insertion-sort-list/ */

/**
 * LeetCode 第 147 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        System.out.println("p0147 passed");
    }

    private static void test1() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        ListNode head = solution.insertionSortList(node1);

        // Input: 4->2->1->3 → Output: 1->2->3->4
        assertArrayEquals(new int[]{1, 2, 3, 4}, toArray(head));
    }

    private static void test2() {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode head = solution.insertionSortList(node1);

        // Input: -1->5->3->4->0 → Output: -1->0->3->4->5
        assertArrayEquals(new int[]{-1, 0, 3, 4, 5}, toArray(head));
    }

    private static int[] toArray(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }
}
