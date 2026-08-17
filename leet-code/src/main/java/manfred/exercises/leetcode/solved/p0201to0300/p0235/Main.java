package manfred.exercises.leetcode.solved.p0201to0300.p0235;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/ */

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定一个二叉搜索树，找到该树中两个指定节点的最近公共祖先。
最近公共祖先：节点 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。

示例 1: 输入 root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8, 输出 6
示例 2: 输入 root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4, 输出 2
*/
/**
 * LeetCode 第 235 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 构造示例中的二叉搜索树：[6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

        Solution solution = new Solution();

        // 示例 1: p = 2, q = 8 → 题面 Output: 6
        TreeNode p1 = find(root, 2);
        TreeNode q1 = find(root, 8);
        assertEquals(6, solution.lowestCommonAncestor(root, p1, q1).val);

        // 示例 2: p = 2, q = 4 → 题面 Output: 2
        TreeNode p2 = find(root, 2);
        TreeNode q2 = find(root, 4);
        assertEquals(2, solution.lowestCommonAncestor(root, p2, q2).val);
        System.out.println("p0235 passed");
    }

    /** 按 LeetCode 层序数组构造二叉树，null 表示空节点。 */
    private static TreeNode buildTree(Integer[] vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int i = 1;
        while (!deque.isEmpty() && i < vals.length) {
            TreeNode node = deque.poll();
            if (i < vals.length && vals[i] != null) {
                node.left = new TreeNode(vals[i]);
                deque.offer(node.left);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                node.right = new TreeNode(vals[i]);
                deque.offer(node.right);
            }
            i++;
        }
        return root;
    }

    /** 在二叉搜索树中按值查找节点。 */
    private static TreeNode find(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
