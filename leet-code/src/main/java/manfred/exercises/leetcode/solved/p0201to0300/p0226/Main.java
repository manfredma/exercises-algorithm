/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew),
but you can’t invert a binary tree on a whiteboard so f*** off.

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0226;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 题目链接：https://leetcode.cn/problems/invert-binary-tree/ */

/**
 * LeetCode 第 226 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        // 题面示例输入:
        //      4
        //    /   \
        //   2     7
        //  / \   / \
        // 1   3 6   9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = new Solution().invertTree(root);
        // 题面示例输出:
        //      4
        //    /   \
        //   7     2
        //  / \   / \
        // 9   6 3   1
        // 完全二叉树,层序遍历应为 [4,7,2,9,6,3,1]
        List<Integer> expected = Arrays.asList(4, 7, 2, 9, 6, 3, 1);
        List<Integer> actual = levelOrder(inverted);
        assertEquals(expected, actual);
        System.out.println("p0226 passed");
    }

    /** 层序遍历完全二叉树(无 null 节点)。 */
    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
}
