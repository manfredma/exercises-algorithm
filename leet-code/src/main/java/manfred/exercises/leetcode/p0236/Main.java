package manfred.exercises.leetcode.p0236;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为："对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。"

示例 1：

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

示例 2：

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。

示例 3：

输入：root = [1,2], p = 1, q = 2
输出：1

提示：

树中节点数目在范围 [2, 10^5] 内
-10^9 <= Node.val <= 10^9
所有 Node.val 互不相同
p != q
p 和 q 均存在于给定的二叉树中
*/
/**
 * LeetCode 第 236 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: root=[3,5,1,6,2,0,8,null,null,7,4], p=5, q=1 → 期望: 3
        TreeNode n7 = new TreeNode(7), n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n7, n4);
        TreeNode n6 = new TreeNode(6);
        TreeNode p1 = new TreeNode(5, n6, n2);
        TreeNode q1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root1 = new TreeNode(3, p1, q1);
        System.out.println(solution.lowestCommonAncestor(root1, p1, q1).val); // 期望: 3

        // 示例 2: 同一棵树，p=5, q=4 → 期望: 5
        System.out.println(solution.lowestCommonAncestor(root1, p1, n4).val); // 期望: 5

        // 示例 3: root=[1,2], p=1, q=2 → 期望: 1
        TreeNode root3 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);
        root3.left = q3;
        System.out.println(solution.lowestCommonAncestor(root3, root3, q3).val); // 期望: 1
    }
}
