/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */

package manfred.exercises.leetcode.solved.p0101to0200.p0108;

import java.util.ArrayList;
import java.util.List;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/ */

/**
 * LeetCode 第 108 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new Solution().sortedArrayToBST(nums);

        List<Integer> inorderResult = new ArrayList<>();
        collectInorder(root, inorderResult);

        assertEquals(toList(nums), inorderResult);
        assertTrue(isBalanced(root));

        System.out.println("p0108 passed");
    }

    private static List<Integer> toList(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int v : a) {
            list.add(v);
        }
        return list;
    }

    private static void collectInorder(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }
        collectInorder(node.left, out);
        out.add(node.val);
        collectInorder(node.right, out);
    }

    private static int balanceHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = balanceHeight(node.left);
        if (left < 0) {
            return -1;
        }
        int right = balanceHeight(node.right);
        if (right < 0) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    private static boolean isBalanced(TreeNode node) {
        return balanceHeight(node) >= 0;
    }
}
