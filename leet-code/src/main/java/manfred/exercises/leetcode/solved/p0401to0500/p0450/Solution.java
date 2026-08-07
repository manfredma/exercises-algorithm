package manfred.exercises.leetcode.solved.p0401to0500.p0450;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 尝试删除自己，并使用子节点来替换自己
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                // 查一下左子树的最大值
                TreeNode max = root.left;
                while (max.right != null) {
                    max = max.right;
                }
                root.val = max.val;
                root.left = deleteNode(root.left, root.val);
            } else {
                TreeNode min = root.right;
                while (min.left != null) {
                    min = min.left;
                }
                root.val = min.val;
                root.right = deleteNode(root.right, root.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
