/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0105;

import java.util.ArrayList;
import java.util.List;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ */

/**
 * LeetCode 第 105 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);

        List<Integer> preorderResult = new ArrayList<>();
        collectPreorder(root, preorderResult);
        List<Integer> inorderResult = new ArrayList<>();
        collectInorder(root, inorderResult);

        assertEquals(toList(preorder), preorderResult);
        assertEquals(toList(inorder), inorderResult);

        System.out.println("p0105 passed");
    }

    private static List<Integer> toList(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int v : a) {
            list.add(v);
        }
        return list;
    }

    private static void collectPreorder(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }
        out.add(node.val);
        collectPreorder(node.left, out);
        collectPreorder(node.right, out);
    }

    private static void collectInorder(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }
        collectInorder(node.left, out);
        out.add(node.val);
        collectInorder(node.right, out);
    }
}
