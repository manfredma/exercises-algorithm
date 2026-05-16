package manfred.exercises.leetcode.p0100;

/**
 * LeetCode 第 100 题「相同的树」：递归同步遍历两棵树，逐节点比较。
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }
}