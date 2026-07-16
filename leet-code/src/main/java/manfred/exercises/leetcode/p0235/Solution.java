package manfred.exercises.leetcode.p0235;


import java.util.ArrayList;
import java.util.List;

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
