package manfred.exercises.leetcode.p0222;

/**
 * LeetCode 第 222 题「完全二叉树的节点个数」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode();
        treeNode.right = new TreeNode();

        treeNode.left.left = new TreeNode();
        treeNode.left.right = new TreeNode();

        treeNode.right.left = new TreeNode();

        Solution solution = new Solution();
        System.out.println(solution.countNodes(treeNode));
    }
}
