package manfred.exercises.leetcode.p0637;

/*
给定一个非空二叉树的根节点 root，以数组的形式返回每一层节点的平均值。
与实际答案相差 10^-5 以内的答案可以被接受。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[3.00000,14.50000,11.00000]

示例 2：
输入：root = [3,9,20,15,7]
输出：[3.00000,14.50000,11.00000]

提示：
- 树中节点数量在 [1, 10^4] 范围内
- -2^31 <= Node.val <= 2^31 - 1
*/
/**
 * LeetCode 第 637 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root = [3,9,20,null,null,15,7] → 期望 [3.0, 14.5, 11.0]
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.averageOfLevels(root1));

        // 示例 2: root = [3,9,20,15,7] → 期望 [3.0, 14.5, 11.0]
        TreeNode root2 = new TreeNode(3,
                new TreeNode(9, new TreeNode(15), new TreeNode(7)),
                new TreeNode(20));
        System.out.println(solution.averageOfLevels(root2));
    }
}
