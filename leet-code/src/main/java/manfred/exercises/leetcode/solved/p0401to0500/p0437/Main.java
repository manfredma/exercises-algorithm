package manfred.exercises.leetcode.solved.p0401to0500.p0437;

/** 题目链接：https://leetcode.cn/problems/path-sum-iii/ */

/*
给定一个二叉树的根节点 root，和一个整数 targetSum，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

示例 1：

输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3

示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3

提示：

二叉树的节点个数的范围是 [0, 1000]

-10^9 <= Node.val <= 10^9

-1000 <= targetSum <= 1000
*/
/**
 * LeetCode 第 437 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        // 示例 1: root=[10,5,-3,3,2,null,11,3,-2,null,1], targetSum=8 → 期望 3
        TreeNode root1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        assertEquals(3, solution.pathSum(root1, 8));
        assertEquals(3, solution2.pathSum(root1, 8));
        // 示例 2: root=[5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum=22 → 期望 3
        TreeNode root2 = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        assertEquals(3, solution.pathSum(root2, 22));
        assertEquals(3, solution2.pathSum(root2, 22));
        // 边界: 空树 → 期望 0
        assertEquals(0, solution.pathSum(null, 0));
        assertEquals(0, solution2.pathSum(null, 0));
        // 整数溢出陷阱: 大值节点 + targetSum=0 → 期望 0（用 int 前缀和会因溢出错误返回 1）
        TreeNode root3 = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        assertEquals(0, solution.pathSum(root3, 0));
        assertEquals(0, solution2.pathSum(root3, 0));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
