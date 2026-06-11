package manfred.exercises.leetcode.p0236;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> root2p = new ArrayList<>();
        List<TreeNode> root2q = new ArrayList<>();
        construct(root, p, q, root2p, root2q);
        TreeNode lowestCommonAncestor = root;
        for (int i = 1; i < Math.min(root2p.size(), root2q.size()); i++) {
            if (root2p.get(i) == root2q.get(i)) {
                lowestCommonAncestor = root2p.get(i);
            }
        }
        return lowestCommonAncestor;
    }

    private void construct(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> root2p, List<TreeNode> root2q) {
        if (node == null || isFinished(root2p, p) && isFinished(root2q, q)) {
            return;
        }
        // 只要找到了p 或 q，则从根节点到 p或q 的路径节点就不再变化
        if (!isFinished(root2p, p)) {
            root2p.add(node);
        }
        if (!isFinished(root2q, q)) {
            root2q.add(node);
        }
        if (!isFinished(root2p, p) || !isFinished(root2q, q)) {
            construct(node.left, p, q, root2p, root2q);
            construct(node.right, p, q, root2p, root2q);
        }
        // 清理自己
        if (!isFinished(root2p, p)) {
            root2p.remove(node);
        }
        if (!isFinished(root2q, q)) {
            root2q.remove(node);
        }
    }

    private boolean isFinished(List<TreeNode> root2p, TreeNode p) {
        return !root2p.isEmpty() && root2p.get(root2p.size() - 1) == p;
    }
}
