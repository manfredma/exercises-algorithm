/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0106;

import java.util.ArrayList;
import java.util.List;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ */

/**
 * LeetCode 第 106 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {3, 9, 20, 15, 7};
        int[] postorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(inorder, postorder);

        List<Integer> inorderResult = new ArrayList<>();
        collectInorder(root, inorderResult);
        List<Integer> postorderResult = new ArrayList<>();
        collectPostorder(root, postorderResult);

        assertEquals(toList(inorder), inorderResult);
        assertEquals(toList(postorder), postorderResult);

        System.out.println("p0106 passed");
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

    private static void collectPostorder(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }
        collectPostorder(node.left, out);
        collectPostorder(node.right, out);
        out.add(node.val);
    }
}
