package manfred.exercises.leetcode.p2236;

/*
给你一个二叉树的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
如果根结点值等于两个子结点值之和，返回 true，否则返回 false。
*/
/**
 * LeetCode 第 2236 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: root = [10,4,6] → 期望 true
        TreeNode root1 = new TreeNode(10, new TreeNode(4), new TreeNode(6));
        System.out.println(solution.checkTree(root1));
        // 示例 2: root = [5,3,1] → 期望 false
        TreeNode root2 = new TreeNode(5, new TreeNode(3), new TreeNode(1));
        System.out.println(solution.checkTree(root2));
    }
}
