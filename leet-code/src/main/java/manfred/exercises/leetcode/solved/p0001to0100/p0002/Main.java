/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0002;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/add-two-numbers/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 2 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        List<Integer> actual = new ArrayList<>();
        while (result != null) {
            actual.add(result.val);
            result = result.next;
        }
        List<Integer> expected = Arrays.asList(7, 0, 8);
        assertEquals(expected, actual);
        System.out.println("p0002 passed");
    }

}

