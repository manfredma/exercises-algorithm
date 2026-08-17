/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0082;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/ */

/**
 * LeetCode 第 82 题「删除排序链表中的重复元素 II」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 题面示例 1: 1->2->3->3->4->4->5 → 1->2->5
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        Solution solution = new Solution();
        ListNode cu = solution.deleteDuplicates(l1);
        assertEquals(Arrays.asList(1, 2, 5), toList(cu));

        // 题面示例 2: 1->1->1->2->3 → 2->3
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        assertEquals(Arrays.asList(2, 3), toList(solution.deleteDuplicates(n1)));

        System.out.println("p0082 passed");
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
