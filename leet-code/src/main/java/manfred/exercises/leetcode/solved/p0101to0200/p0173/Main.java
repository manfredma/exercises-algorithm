/*
Implement an iterator over a binary search tree (BST).
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is,
there will be at least a next smallest number in the BST when next() is called.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0173;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/binary-search-tree-iterator/ */

/**
 * LeetCode 第 173 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(20);

        root.left = treeNode2;
        root.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        BSTIterator iterator = new BSTIterator(root);
        // 题面示例序列
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());
        System.out.println("p0173 passed");
    }
}
