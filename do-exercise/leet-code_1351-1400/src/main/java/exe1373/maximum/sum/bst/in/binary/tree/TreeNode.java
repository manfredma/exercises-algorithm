package exe1373.maximum.sum.bst.in.binary.tree;

/**
 * 二叉树节点定义，包含节点值 val 及左右子节点引用，用于 LeetCode 第1373题二叉搜索树的相关计算。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}