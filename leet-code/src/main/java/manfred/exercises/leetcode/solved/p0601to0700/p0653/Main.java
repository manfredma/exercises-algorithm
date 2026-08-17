/*
Given a Binary Search Tree and a target number,
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

 */
package manfred.exercises.leetcode.solved.p0601to0700.p0653;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/ */

/**
 * LeetCode 第 653 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;

        // 示例 1: target = 9 → 期望 true
        assertTrue(new Solution().findTarget(treeNode1, 9));
        // 示例 2: target = 28 → 期望 false
        assertFalse(new Solution().findTarget(treeNode1, 28));

        System.out.println("p0653 passed");
    }
}
