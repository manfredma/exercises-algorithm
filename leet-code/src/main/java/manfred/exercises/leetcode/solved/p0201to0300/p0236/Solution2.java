package manfred.exercises.leetcode.solved.p0201to0300.p0236;

/**
 * LeetCode 第 236 题「二叉树的最近公共祖先」：标准后序递归。
 *
 * <p>递归在左右子树寻找 {@code p}、{@code q}。若两侧都找到目标，当前节点就是最近公共祖先；
 * 若只找到一侧，则该侧返回的节点继续向上传递。</p>
 *
 * <p>时间复杂度 {@code O(n)}，递归栈空间 {@code O(h)}。</p>
 */
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
