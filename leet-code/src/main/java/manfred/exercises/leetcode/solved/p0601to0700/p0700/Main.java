package manfred.exercises.leetcode.solved.p0601to0700.p0700;

/*
给定二叉搜索树的根节点 root 和整数 val，找到值等于 val 的节点并返回以该节点为根的子树；不存在则返回 null。

示例 1：root = [4,2,7,1,3], val = 2，输出：[2,1,3]。
示例 2：root = [4,2,7,1,3], val = 5，输出：[]。

提示：树中节点数在 [1, 5000] 范围内；root 是二叉搜索树；1 <= Node.val, val <= 10^7。
*/
/** LeetCode 第 700 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = tree();
        assertSame(root.left, solution.searchBST(root, 2));
        assertSame(null, solution.searchBST(root, 5));
    }

    private static TreeNode tree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        return root;
    }

    private static void assertSame(TreeNode expected, TreeNode actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
