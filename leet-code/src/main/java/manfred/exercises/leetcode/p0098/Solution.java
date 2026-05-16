package manfred.exercises.leetcode.p0098;

/**
 * LeetCode 第 98 题「验证二叉搜索树」：递归传递上下界约束，或中序遍历验证严格递增。
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (root.left != null) {
            int maxLeft = root.left.val;
            TreeNode maxLeftNode = root.left;
            while (maxLeftNode.right != null) {
                maxLeftNode = maxLeftNode.right;
                maxLeft = maxLeftNode.val;
            }

            if (maxLeft >= root.val) {
                return false;
            }

            if (!isValidBST(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            int minRight = root.right.val;
            TreeNode minRightNode = root.right;
            while (minRightNode.left != null) {
                minRightNode = minRightNode.left;
                minRight = minRightNode.val;
            }

            if (minRight <= root.val) {
                return false;
            }
            if (!isValidBST(root.right)) {
                return false;
            }
        }
        return true;
    }
}