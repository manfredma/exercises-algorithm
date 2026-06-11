package manfred.exercises.leetcode.p0543;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterNodeOfBinaryTree(root) -1;

    }

    private int diameterNodeOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = highestOfBinaryTree(root.left);
        int right = highestOfBinaryTree(root.right);
        int diameterRoot = left + right + 1;

        int diameterLeft = diameterNodeOfBinaryTree(root.left);
        int diameterRight = diameterNodeOfBinaryTree(root.right);

        return Math.max(Math.max(diameterLeft, diameterRight), diameterRoot);
    }

    private int highestOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int highestLeft = highestOfBinaryTree(root.left);
        int highestRight = highestOfBinaryTree(root.right);
        return Math.max(highestLeft, highestRight) + 1;
    }
}
