/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

 */

package manfred.exercises.leetcode.solved.p0101to0200.p0110;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/balanced-binary-tree/ */

/**
 * LeetCode 第 110 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: [3,9,20,null,null,15,7] → true
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        TreeNode t1r = new TreeNode(20);
        t1.right = t1r;
        t1r.left = new TreeNode(15);
        t1r.right = new TreeNode(7);
        assertTrue(solution.isBalanced(t1));

        // 示例 2: [1,2,2,3,3,null,null,4,4] → false（左子树深度差为 2）
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(2);
        TreeNode t2l = t2.left;
        t2l.left = new TreeNode(3);
        t2l.right = new TreeNode(3);
        TreeNode t2ll = t2l.left;
        t2ll.left = new TreeNode(4);
        t2ll.right = new TreeNode(4);
        assertFalse(solution.isBalanced(t2));

        System.out.println("p0110 passed");
    }
}
