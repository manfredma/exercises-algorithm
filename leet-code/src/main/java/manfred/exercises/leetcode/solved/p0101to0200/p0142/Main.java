/*

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list,
we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

Example 1:

Input: head = [3,2,0,-4(->2)], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2(->1)], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

Follow-up:
Can you solve it without using extra space?

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0142;

import static manfred.exercises.assertion.Assert.assertNull;
import static manfred.exercises.assertion.Assert.assertSame;

/** 题目链接：https://leetcode.cn/problems/linked-list-cycle-ii/ */

/**
 * LeetCode 第 142 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1：head = [3,2,0,-4], pos = 1 -> 环入口为索引 1 的节点(值为 2)
        ListNode n0 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        assertSame(n1, solution.detectCycle(n0));

        // 题面示例 3：head = [1], pos = -1 -> 无环，返回 null
        ListNode single = new ListNode(1);
        assertNull(solution.detectCycle(single));
        System.out.println("p0142 passed");
    }
}
