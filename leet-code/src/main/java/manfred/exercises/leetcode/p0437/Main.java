package manfred.exercises.leetcode.p0437;

/*
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

示例 1：

输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。

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

        // 示例 1: root=[10,5,-3,3,2,null,11,3,-2,null,1], targetSum=8 → 期望: 3
        TreeNode root1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(solution.pathSum(root1, 8)); // 期望: 3

        // 示例 2: root=[5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum=22 → 期望: 3
        TreeNode root2 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(solution.pathSum(root2, 22)); // 期望: 3

        // 整数溢出陷阱用例:
        // root=[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        // targetSum=0 → 期望: 0（用 int 做前缀和会因溢出错误返回 1）
        TreeNode root3 = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000), null), null), null), null), null);
        System.out.println(solution.pathSum(root3, 0)); // 期望: 0
    }
}
