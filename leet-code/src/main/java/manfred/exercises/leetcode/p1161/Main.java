package manfred.exercises.leetcode.p1161;

/**
 * 给你二叉树根节点 root。根节点位于第 1 层，子节点位于第 2 层，依此类推。
 * 返回层内元素之和最大的层中，层号最小的那个。
 *
 * 示例 1：root = [1,7,0,7,-8,null,null]，输出 2。
 * 示例 2：root = [989,null,10250,98693,-89388,null,null,null,-32127]，输出 2。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(2, solution.maxLevelSum(buildTree(1, 7, 0, 7, -8, null, null)));
        assertEquals(2, solution.maxLevelSum(buildTree(989, null, 10250, 98693, -89388,
                null, null, null, -32127)));

        // 只有根节点。
        assertEquals(1, solution.maxLevelSum(buildTree(42)));

        // 第 1、2 层的和相同，应返回层号更小的第 1 层。
        assertEquals(1, solution.maxLevelSum(buildTree(1, 0, 1)));

        // 所有层和均为负数，验证 maxSum 的初始值。
        assertEquals(1, solution.maxLevelSum(buildTree(-100, -200, -300, -20, -30, -40, -50)));

        // 最大层出现在最深层。
        assertEquals(3, solution.maxLevelSum(buildTree(1, 2, 3, 4, 5, 6, 100)));

        // 不平衡树中，最大层仍可能位于中间层。
        assertEquals(2, solution.maxLevelSum(buildTree(1, 10, null, -100, -100)));

        // 节点值边界。
        assertEquals(2, solution.maxLevelSum(buildTree(-100000, 100000, 100000)));
    }

    private static TreeNode buildTree(Integer... values) {
        if (values.length == 0 || values[0] == null) return null;
        java.util.Queue<TreeNode> queue = new java.util.ArrayDeque<>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);
        for (int i = 1; !queue.isEmpty() && i < values.length;) {
            TreeNode node = queue.poll();
            if (values[i] != null) { node.left = new TreeNode(values[i]); queue.offer(node.left); }
            i++;
            if (i < values.length && values[i] != null) { node.right = new TreeNode(values[i]); queue.offer(node.right); }
            i++;
        }
        return root;
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
