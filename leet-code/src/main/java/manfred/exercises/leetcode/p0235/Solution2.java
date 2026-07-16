package manfred.exercises.leetcode.p0235;

/**
 * 备选解法：利用 BST 性质一次遍历，O(1) 空间。
 *
 * <p>核心：在 BST 上，p、q 的"分叉点"就是最近公共祖先。
 * 从根往下走：
 * <ul>
 *   <li>curr 同时大于 p、q → 二者都在左子树，往左走</li>
 *   <li>curr 同时小于 p、q → 二者都在右子树，往右走</li>
 *   <li>否则（分居两侧，或 curr 就是 p/q）→ curr 即 LCA，返回</li>
 * </ul>
 * 时间 O(h)，空间 O(1)。对比 {@link Solution} 的双路径法 O(h) 时间 + O(h) 空间。
 */
class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > p.val && curr.val > q.val) {
                // p、q 都在左子树
                curr = curr.left;
            } else if (curr.val < p.val && curr.val < q.val) {
                // p、q 都在右子树
                curr = curr.right;
            } else {
                // 分叉点：p、q 分居两侧，或 curr 本身就是 p/q
                return curr;
            }
        }
        return null;
    }
}
