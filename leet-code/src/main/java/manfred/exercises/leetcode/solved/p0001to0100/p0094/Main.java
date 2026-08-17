/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0094;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.Arrays;

/** 题目链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/ */

/**
 * LeetCode 第 94 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        // 题面示例：中序遍历为 [1,3,2]
        assertEquals(Arrays.asList(1, 3, 2), new Solution().inorderTraversal(treeNode1));
        System.out.println("passed");
    }
}
