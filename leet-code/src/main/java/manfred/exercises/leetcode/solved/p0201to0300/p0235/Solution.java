package manfred.exercises.leetcode.solved.p0201to0300.p0235;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 235 题「二叉搜索树的最近公共祖先」：分别记录根到两个目标的搜索路径。
 *
 * <p>利用 BST 性质找到根到 {@code p}、{@code q} 的两条路径，再从根开始比较，最后一个
 * 相同节点即为最近公共祖先。{@link Solution2} 直接利用 BST 分叉性质一次遍历，空间更优。</p>
 *
 * <p>时间复杂度 {@code O(h)}，空间复杂度 {@code O(h)}，其中 {@code h} 为树高。</p>
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path2p = search(root, p);
        List<TreeNode> path2q = search(root, q);
        int parentIdx = -1;
        for (int i = 0; i < path2p.size() && i < path2q.size(); i++) {
            if (path2p.get(i).val != path2q.get(i).val ) {
               break;
            }
            parentIdx++;
        }
        return path2p.get(parentIdx);
    }

    private List<TreeNode> search(TreeNode from, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        while (true) {
            path.add(from);
            if (from.val == target.val) {
                break;
            }
            if (from.val > target.val) {
                from = from.left;
            } else {
                from = from.right;
            }
        }
        return path;
    }
}
