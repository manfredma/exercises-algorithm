package manfred.exercises.leetcode.solved.p1401to1500.p1448;

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode node, int maxParentValue) {
        if (node == null) {
            return 0;
        }
        int curGood = maxParentValue > node.val ? 0 : 1;
        int curMax = Math.max(maxParentValue, node.val);
        int leftGood = goodNodes(node.left, curMax);
        int rightGood = goodNodes(node.right, curMax);
        return curGood + leftGood + rightGood;
    }
}
