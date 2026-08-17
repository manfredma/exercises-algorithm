/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:

Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0117;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/ */

/**
 * LeetCode 第 117 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例: 树结构如下
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   7
        // 期望 connect 后 next 指向同层右兄弟: 2->3, 4->5, 5->7
        Node n4 = new Node(4, null, null, null);
        Node n5 = new Node(5, null, null, null);
        Node n7 = new Node(7, null, null, null);
        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, null, n7, null);
        Node root = new Node(1, n2, n3, null);

        Node result = solution.connect(root);

        // 根的 next 应为 null
        assertNull(result.next);
        // 第二层: 2.next = 3, 3.next = null
        assertSame(n3, result.left.next);
        assertNull(result.right.next);
        // 第三层: 4.next = 5, 5.next = 7, 7.next = null
        assertSame(n5, n4.next);
        assertSame(n7, n5.next);
        assertNull(n7.next);

        System.out.println("p0117 passed");
    }
}
