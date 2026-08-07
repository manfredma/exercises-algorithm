package manfred.exercises.leetcode.solved.p0201to0300.p0226;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}