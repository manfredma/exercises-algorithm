/*
Share
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

Note:

You must return the copy of the given head as a reference to the cloned list.
 */
package manfred.exercises.leetcode.solved.p0101to0200.p0138;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/copy-list-with-random-pointer/ */

/**
 * LeetCode 第 138 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.val = 1;
        node2.val = 2;

        node1.next = node2;
        node1.random = node2;
        node2.random = node2;

        Node clone = new Solution().copyRandomList(node1);

        assertNotNull(clone);
        assertTrue(clone != node1, "clone should be a different object");
        assertEquals(1, clone.val);
        assertNotNull(clone.next);
        assertEquals(2, clone.next.val);
        assertSame(clone.next, clone.random);
        assertSame(clone.next, clone.next.random);
        assertNull(clone.next.next);

        System.out.println("p0138 passed");
    }
}
