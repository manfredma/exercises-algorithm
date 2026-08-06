package manfred.exercises.leetcode.p0872;

/*
请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列。
如果有两棵二叉树的叶值序列相同，那么我们就认为它们是叶相似的。
如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false。

示例 1：
输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
输出：true

示例 2：
输入：root1 = [1,2,3], root2 = [1,3,2]
输出：false

提示：给定的两棵树结点数在 [1, 200] 范围内；结点值在 [0, 200] 范围内。
*/
/** LeetCode 第 872 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertEquals(true, solution.leafSimilar(firstTree(), secondTree()));
        assertEquals(false, solution.leafSimilar(tree(1, tree(2), tree(3)), tree(1, tree(3), tree(2))));
        assertEquals(true, solution2.leafSimilar(firstTree(), secondTree()));
        assertEquals(false, solution2.leafSimilar(tree(1, tree(2), tree(3)), tree(1, tree(3), tree(2))));
    }

    private static TreeNode firstTree() {
        return tree(3, tree(5, tree(6), tree(2, tree(7), tree(4))), tree(1, tree(9), tree(8)));
    }

    private static TreeNode secondTree() {
        return tree(3, tree(5, tree(6), tree(7)), tree(1, tree(4), tree(2, tree(9), tree(8))));
    }

    private static TreeNode tree(int value) {
        return new TreeNode(value);
    }

    private static TreeNode tree(int value, TreeNode left, TreeNode right) {
        TreeNode root = new TreeNode(value);
        root.left = left;
        root.right = right;
        return root;
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
