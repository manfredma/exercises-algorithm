/*
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0098;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/validate-binary-search-tree/ */

/**
 * LeetCode 第 98 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        // 题面示例 1：[2,1,3] 是合法 BST
        assertTrue(s.isValidBST(treeNode2));

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(5);

        treeNode5.left = treeNode1;
        treeNode5.right = treeNode4;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode6;
        // 手算：根 5 的右子树根为 4（4 < 5），违反 BST 右子树须大于根的约束
        assertFalse(s.isValidBST(treeNode5));
        System.out.println("passed");
    }
}
