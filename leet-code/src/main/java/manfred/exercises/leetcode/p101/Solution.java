package manfred.exercises.leetcode.p101;

/**
 * LeetCode 第 101 题「对称二叉树」：递归比较左子树与右子树的镜像关系。
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return doIsSymmetric(root, root);
    }

    private boolean doIsSymmetric(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        if (!doIsSymmetric(p.left, q.right)) {
            return false;
        }
        return doIsSymmetric(p.right, q.left);
    }
}