package manfred.exercises.leetcode.solved.p1301to1400.p1372;

/** 题目链接：https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/ */

/**
 * 交错路径每走一步都要改变方向。路径长度是访问节点数减一，单节点路径为 0。
 * 返回树中最长交错路径的长度。
 * 示例输出依次为 3、4、0。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertSolutions(solution, solution2, 3, buildTree(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1));
        assertSolutions(solution, solution2, 4, buildTree(1, 1, 1, null, 1, null, null, 1, 1, null, 1));
        assertSolutions(solution, solution2, 0, buildTree(1));

        assertSolutions(solution, solution2, 1, buildTree(1, 1, null, 1, null, 1));
        assertSolutions(solution, solution2, 1, buildTree(1, null, 1, null, 1, null, 1));
        assertSolutions(solution, solution2, 6, alternatingChain(7));

        // 递归解法在 5 万层链状树上可能栈溢出；迭代版应正常处理。
        assertEquals(1, solution2.longestZigZag(rightChain(50_000)));
    }

    private static void assertSolutions(Solution solution, Solution2 solution2, int expected, TreeNode root) {
        assertEquals(expected, solution.longestZigZag(root));
        assertEquals(expected, solution2.longestZigZag(root));
    }

    private static TreeNode alternatingChain(int length) {
        TreeNode root = new TreeNode(1);
        TreeNode current = root;
        for (int i = 1; i < length; i++) {
            TreeNode next = new TreeNode(1);
            if (i % 2 == 1) current.left = next;
            else current.right = next;
            current = next;
        }
        return root;
    }

    private static TreeNode rightChain(int length) {
        TreeNode root = new TreeNode(1);
        TreeNode current = root;
        for (int i = 1; i < length; i++) {
            current.right = new TreeNode(1);
            current = current.right;
        }
        return root;
    }

    private static TreeNode buildTree(Integer... values) {
        if (values.length == 0 || values[0] == null) return null;
        java.util.Queue<TreeNode> queue = new java.util.ArrayDeque<>();
        TreeNode root = new TreeNode(values[0]); queue.offer(root);
        for (int i = 1; !queue.isEmpty() && i < values.length;) {
            TreeNode node = queue.poll();
            if (values[i] != null) { node.left = new TreeNode(values[i]); queue.offer(node.left); } i++;
            if (i < values.length && values[i] != null) { node.right = new TreeNode(values[i]); queue.offer(node.right); } i++;
        }
        return root;
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
