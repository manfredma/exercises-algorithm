/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0100;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/same-tree/ */

/**
 * LeetCode 第 100 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: [1,2,3] 与 [1,2,3] → true
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        assertTrue(solution.isSameTree(treeNode11, treeNode11));

        // 示例 2: [1,2] 与 [1,null,2] → false
        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        treeNode21.left = treeNode22;

        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(2);
        treeNode31.right = treeNode32;
        assertFalse(solution.isSameTree(treeNode21, treeNode31));

        // 示例 3: [1,2,1] 与 [1,1,2] → false
        TreeNode treeNode41 = new TreeNode(1);
        TreeNode treeNode42 = new TreeNode(2);
        TreeNode treeNode43 = new TreeNode(1);
        treeNode41.left = treeNode42;
        treeNode41.right = treeNode43;

        TreeNode treeNode51 = new TreeNode(1);
        TreeNode treeNode52 = new TreeNode(2);
        TreeNode treeNode53 = new TreeNode(1);
        treeNode51.left = treeNode53;
        treeNode51.right = treeNode52;
        assertFalse(solution.isSameTree(treeNode41, treeNode51));
        System.out.println("p0100 passed");
    }
}
