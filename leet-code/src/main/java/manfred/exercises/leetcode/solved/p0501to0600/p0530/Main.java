package manfred.exercises.leetcode.solved.p0501to0600.p0530;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/minimum-absolute-difference-in-bst/ */

/*
给你一个二叉搜索树的根节点 root，返回树中任意两不同节点值之间的最小差值。

差值是一个正数，其数值等于两值之差的绝对值。

示例 1：
输入：root = [4,2,6,1,3]
输出：1

示例 2：
输入：root = [1,0,48,null,null,12,49]
输出：1

提示：
- 树中节点的数目范围是 [2, 10^4]
- 0 <= Node.val <= 10^5
*/
/**
 * LeetCode 第 530 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [4,2,6,1,3] → 期望 1
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6));
        assertEquals(1, solution.getMinimumDifference(root1));

        // 示例 2: root = [1,0,48,null,null,12,49] → 期望 1
        TreeNode root2 = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        assertEquals(1, solution.getMinimumDifference(root2));

        System.out.println("p0530 passed");
    }
}
