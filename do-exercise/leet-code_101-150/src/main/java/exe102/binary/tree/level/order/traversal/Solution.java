package exe102.binary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 102 题「二叉树的层序遍历」：BFS 队列，每层出队后记录结果并将子节点入队。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return new ArrayList<>();
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        result.add(cur);

        List<TreeNode> curNode = new ArrayList<>();
        curNode.add(root);

        do {
            List<TreeNode> nextNode = new ArrayList<>();
            List<Integer> next = new ArrayList<>();
            for (TreeNode treeNode : curNode) {
                if (treeNode.left != null) {
                    next.add(treeNode.left.val);
                    nextNode.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right.val);
                    nextNode.add(treeNode.right);
                }
            }
            if (!next.isEmpty()) {
                result.add(next);
            }
            curNode = nextNode;
        } while (!curNode.isEmpty());
        return result;
    }
}