/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0023;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/merge-k-sorted-lists/ */

/**
 * LeetCode 第 23 题「合并 K 个升序链表」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(6);
        p1.next = p2;

        ListNode l = new Solution().mergeKLists(new ListNode[]{n1, m1, p1});
        // 题面示例: 合并后 1->1->2->3->4->4->5->6
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6), toList(l));
        System.out.println("p0023 passed");
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
