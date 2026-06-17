package manfred.exercises.leetcode.p0530;

class Solution2 {
    private int minDiff = Integer.MAX_VALUE;
    private int prevVal = -1;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    // BST 中序遍历产生升序序列，最小差值必然在相邻节点之间
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prevVal != -1) minDiff = Math.min(minDiff, node.val - prevVal);
        prevVal = node.val;
        inorder(node.right);
    }
}
