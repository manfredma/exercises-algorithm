package manfred.exercises.leetcode.solved.p0201to0300.p0222;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/count-complete-tree-nodes/ */

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
        // 完全二叉树节点数：根 + 左 + 右 + 左左 + 左右 + 右左 = 6
        assertEquals(6, solution.countNodes(treeNode));
        System.out.println("p0222 passed");
    }
}
