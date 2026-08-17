/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0092;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/reverse-linked-list-ii/ */

/**
 * LeetCode 第 92 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        Solution solution = new Solution();

        // 题面示例: m=2, n=4 → 1->4->3->2->5
        reset(listNode1, listNode2, listNode3, listNode4, listNode5);
        ListNode r = solution.reverseBetween(listNode1, 2, 4);
        assertEquals(Arrays.asList(1, 4, 3, 2, 5), toList(r));

        // m=1, n=4 → 4->3->2->1->5
        reset(listNode1, listNode2, listNode3, listNode4, listNode5);
        r = solution.reverseBetween(listNode1, 1, 4);
        assertEquals(Arrays.asList(4, 3, 2, 1, 5), toList(r));

        // m=2, n=5 → 1->5->4->3->2
        reset(listNode1, listNode2, listNode3, listNode4, listNode5);
        r = solution.reverseBetween(listNode1, 2, 5);
        assertEquals(Arrays.asList(1, 5, 4, 3, 2), toList(r));

        System.out.println("p0092 passed");
    }

    private static void reset(ListNode n1, ListNode n2, ListNode n3, ListNode n4, ListNode n5) {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
    }

    private static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
