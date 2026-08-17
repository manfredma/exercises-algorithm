/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0143;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/reorder-list/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 143 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        node4.next = node5;

        Solution solution = new Solution();
        solution.reorderList(node1);

        // 题面示例 2：1->2->3->4->5 重排为 1->5->2->4->3
        List<Integer> actual = new ArrayList<>();
        ListNode cur = node1;
        while (cur != null) {
            actual.add(cur.val);
            cur = cur.next;
        }
        assertEquals(Arrays.asList(1, 5, 2, 4, 3), actual);
        System.out.println("p0143 passed");
    }
}
