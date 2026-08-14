package manfred.exercises.leetcode.solved.p0101to0200.p0114;

/** 题目链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/ */

/*
给你二叉树的根结点 root，请你将它展开为一个单链表：

- 展开后的单链表应该同样使用 TreeNode，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null。
- 展开后的单链表应该与二叉树 先序遍历 顺序相同。

示例 1：

输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]

示例 2：

输入：root = []
输出：[]

示例 3：

输入：root = [0]
输出：[0]

提示：

树中结点数在范围 [0, 2000] 内

-100 <= Node.val <= 100
*/
/**
 * LeetCode 第 114 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: root=[1,2,5,3,4,null,6] → 展开后先序序列 [1,2,3,4,5,6]
        TreeNode root1 = buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution.flatten(root1);
        assertFlattened(root1, new int[]{1, 2, 3, 4, 5, 6});
        TreeNode root1b = buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution2.flatten(root1b);
        assertFlattened(root1b, new int[]{1, 2, 3, 4, 5, 6});
        TreeNode root1c = buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution3.flatten(root1c);
        assertFlattened(root1c, new int[]{1, 2, 3, 4, 5, 6});
        // 示例 2: root=[] → 无节点
        solution.flatten(null);
        solution2.flatten(null);
        solution3.flatten(null);
        // 示例 3: root=[0] → 单节点
        TreeNode root3 = buildTree(new Integer[]{0});
        solution.flatten(root3);
        assertFlattened(root3, new int[]{0});
        TreeNode root3b = buildTree(new Integer[]{0});
        solution2.flatten(root3b);
        assertFlattened(root3b, new int[]{0});
        TreeNode root3c = buildTree(new Integer[]{0});
        solution3.flatten(root3c);
        assertFlattened(root3c, new int[]{0});
        // 边界: 左子树无右孩子，前驱=左子树根（prev 不沿 right 下行）
        // root=[1,2,5,3,null,null,6] → 先序 [1,2,3,5,6]，3.right 应指向 5
        TreeNode root4 = buildTree(new Integer[]{1, 2, 5, 3, null, null, 6});
        solution3.flatten(root4);
        assertFlattened(root4, new int[]{1, 2, 3, 5, 6});
    }

    /** 校验展开后右链为先序序列，且所有左指针为 null。 */
    private static void assertFlattened(TreeNode root, int[] expected) {
        java.util.List<Integer> actual = new java.util.ArrayList<>();
        for (TreeNode cur = root; cur != null; cur = cur.right) {
            actual.add(cur.val);
            if (cur.left != null) {
                throw new AssertionError("节点 " + cur.val + " 的 left 未置空");
            }
        }
        if (actual.size() != expected.length) {
            throw new AssertionError("expected 长度 " + expected.length + ", actual 长度 " + actual.size() + ": " + actual);
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i)) {
                throw new AssertionError("expected: " + java.util.Arrays.toString(expected) + ", actual: " + actual);
            }
        }
    }

    /** 按层序数组构建二叉树，null 表示缺位。 */
    private static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        java.util.Queue<TreeNode> queue = new java.util.ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            if (i < values.length && values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
