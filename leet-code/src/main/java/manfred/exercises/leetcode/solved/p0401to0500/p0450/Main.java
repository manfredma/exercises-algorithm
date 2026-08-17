package manfred.exercises.leetcode.solved.p0401to0500.p0450;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/delete-node-in-a-bst/ */
/* 删除 BST 中值为 key 的节点，并保持二叉搜索树性质。
示例：root = [5,3,6,2,4,null,7], key = 3；key = 0；root = []，key = 0。 */

/**
 * LeetCode 第 450 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertNotNull(solution.deleteNode(tree(), 3));
        assertNotNull(solution.deleteNode(tree(), 0));
        assertSame(null, solution.deleteNode(null, 0));

        TreeNode result = new Solution2().deleteNode(tree(), 3);
        assertEquals(4, result.left.val);
        assertEquals(2, result.left.left.val);
        assertSame(null, result.left.right);
    }

    private static TreeNode tree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }



}
