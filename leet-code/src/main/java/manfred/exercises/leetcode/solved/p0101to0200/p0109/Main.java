/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0109;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/ */

/**
 * LeetCode 第 109 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例: [-10,-3,0,5,9] → 高度平衡 BST
        // 本 Solution 取中点 nums[length/2] 为根，结果唯一确定：
        //        0
        //       / \
        //     -3   9
        //     /   /
        //   -10  5
        ListNode head = buildList(new int[]{-10, -3, 0, 5, 9});
        TreeNode root = solution.sortedListToBST(head);

        // 中序遍历须等于原升序链表
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        assertEquals(5, inOrder.size());
        assertArrayEquals(new Integer[]{-10, -3, 0, 5, 9}, inOrder.toArray(new Integer[0]));
        // 高度平衡
        assertTrue(isBalanced(root));

        // 根值应为 0
        assertEquals(0, root.val);
        // 左子树根 -3，右子树根 9
        assertEquals(-3, root.left.val);
        assertEquals(9, root.right.val);
        // -3 的左孩子 -10，右孩子为空
        assertEquals(-10, root.left.left.val);
        assertNull(root.left.right);
        // 9 的左孩子 5，右孩子为空
        assertEquals(5, root.right.left.val);
        assertNull(root.right.right);

        System.out.println("p0109 passed");
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static void inOrder(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }
        inOrder(node.left, out);
        out.add(node.val);
        inOrder(node.right, out);
    }

    private static boolean isBalanced(TreeNode node) {
        return height(node) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = height(node.left);
        int r = height(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
