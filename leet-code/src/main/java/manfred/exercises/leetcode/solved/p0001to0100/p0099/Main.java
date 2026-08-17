/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
   \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0099;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/recover-binary-search-tree/ */

/**
 * LeetCode 第 99 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 题面示例 1：[1,3,null,null,2] 恢复为 [3,1,null,null,2]
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);

        treeNode11.left = treeNode13;
        treeNode13.right = treeNode12;

        new Solution().recoverTree(treeNode11);
        // 恢复后根=3，左子=1，左子的右子=2
        assertEquals(3, treeNode11.val);
        assertEquals(2, treeNode12.val);
        assertEquals(1, treeNode13.val);

        // 题面示例 2：[3,1,4,null,null,2] 恢复为 [2,1,4,null,null,3]
        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode23 = new TreeNode(3);
        TreeNode treeNode24 = new TreeNode(4);

        treeNode23.left = treeNode21;
        treeNode23.right = treeNode24;
        treeNode24.left = treeNode22;

        new Solution().recoverTree(treeNode23);
        // 恢复后根=2，左子=1，右子=4，右子的左子=3
        assertEquals(1, treeNode21.val);
        assertEquals(3, treeNode22.val);
        assertEquals(2, treeNode23.val);
        assertEquals(4, treeNode24.val);
        System.out.println("passed");
    }
}
