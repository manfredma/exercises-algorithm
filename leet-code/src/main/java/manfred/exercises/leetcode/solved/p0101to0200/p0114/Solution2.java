package manfred.exercises.leetcode.solved.p0101to0200.p0114;

/**
 * 二叉树展开为链表 —— 后序递归返回首尾节点（重刷实现）。
 *
 * <p>思路：后序遍历（先展平左右子树），递归返回每棵子树展开后的「首尾节点」{@code [head, tail]}。
 * 当前节点 node 作为头，左链 head 接到 node.right、右链 head 接到左链 tail.right；
 * 全程指针赋值，无需扫描尾链。{@code flatten} 外层判空后调 {@link #flattenAll}。
 *
 * <p>复杂度：时间 O(n)（每节点访问一次，拼接为 O(1)），空间 O(h)（递归栈，h 为树高）。
 * 优于 {@link Solution}（后序 + while 扫尾链，最坏 O(n^2)）；空间非 O(1)，见 {@link Solution3} 的 Morris 迭代。
 */
class Solution2 {
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        flattenAll(root);
    }

    private TreeNode[] flattenAll(TreeNode node) {
        if (null == node) {
            return null;
        }
        TreeNode[] left = flattenAll(node.left);
        TreeNode[] right = flattenAll(node.right);
        node.left = null;

        TreeNode lastChild = node;
        if (left != null) {
            node.right = left[0];
            lastChild = left[1];
        }
        if (right != null) {
            lastChild.right = right[0];
            lastChild = right[1];
        }
        // 返回这个链条的收尾节点
        return new TreeNode[]{node, lastChild};
    }
}
