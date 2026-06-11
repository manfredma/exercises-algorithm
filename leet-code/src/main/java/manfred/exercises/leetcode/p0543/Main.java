package manfred.exercises.leetcode.p0543;

/*
给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。

示例 1：

输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

示例 2：

输入：root = [1,2]
输出：1

提示：

树中节点数目在范围 [1, 10^4] 内
-100 <= Node.val <= 100
*/
/**
 * LeetCode 第 543 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [1,2,3,4,5] → 期望: 3
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        System.out.println(solution.diameterOfBinaryTree(root1));

        // 示例 2: root = [1,2] → 期望: 1
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(solution.diameterOfBinaryTree(root2));
    }
}
