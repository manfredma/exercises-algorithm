package manfred.exercises.leetcode.solved.p0201to0300.p0236;

import static manfred.exercises.assertion.Assert.assertSame;


/**
 * LeetCode 第 236 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        // 示例 1: root=[3,5,1,6,2,0,8,null,null,7,4], p=5, q=1 → 期望: 3
        TreeNode n7 = new TreeNode(7), n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n7, n4);
        TreeNode n6 = new TreeNode(6);
        TreeNode p1 = new TreeNode(5, n6, n2);
        TreeNode q1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root1 = new TreeNode(3, p1, q1);
        // 示例 1: 题面 Output: 3
        assertLca(root1, p1, q1, root1, solution, solution2, "example 1: split at root");

        // 示例 2: 同一棵树，p=5, q=4 → 题面 Output: 5
        assertLca(root1, p1, n4, p1, solution, solution2, "example 2: target is ancestor");

        // 示例 3: root=[1,2], p=1, q=2 → 题面 Output: 1
        TreeNode root3 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);
        root3.left = q3;
        assertLca(root3, root3, q3, root3, solution, solution2, "example 3: root is target");

        assertLca(root1, n6, n4, p1, solution, solution2, "targets split below root");
        System.out.println("leet#0236 passed");
    }

    private static void assertLca(TreeNode root, TreeNode p, TreeNode q, TreeNode expected,
                                  Solution solution, Solution2 solution2, String desc) {
        assertSame(expected, solution.lowestCommonAncestor(root, p, q), "Solution " + desc);
        assertSame(expected, solution2.lowestCommonAncestor(root, p, q), "Solution2 " + desc);
    }
}
