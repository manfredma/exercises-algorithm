package manfred.exercises.leetcode.solved.p0801to0900.p0889;

/** 题目链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。

如果存在多个答案，您可以返回其中 任何 一个。



示例 1：

输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]

示例 2:

输入: preorder = [1], postorder = [1]
输出: [1]



提示：


1 <= preorder.length <= 30


1 <= preorder[i] <= preorder.length


preorder 中所有值都 不同


postorder.length == preorder.length


1 <= postorder[i] <= postorder.length


postorder 中所有值都 不同


保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
*/
/** LeetCode 第 889 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertTraversals(
                new int[] {1, 2, 4, 5, 3, 6, 7},
                new int[] {4, 5, 2, 6, 7, 3, 1},
                solution.constructFromPrePost(
                        new int[] {1, 2, 4, 5, 3, 6, 7},
                        new int[] {4, 5, 2, 6, 7, 3, 1}));
        assertTraversals(
                new int[] {1, 2, 4, 5, 3, 6, 7},
                new int[] {4, 5, 2, 6, 7, 3, 1},
                solution2.constructFromPrePost(
                        new int[] {1, 2, 4, 5, 3, 6, 7},
                        new int[] {4, 5, 2, 6, 7, 3, 1}));
        assertTraversals(
                new int[] {1}, new int[] {1}, solution.constructFromPrePost(new int[] {1}, new int[] {1}));
        assertTraversals(
                new int[] {1}, new int[] {1}, solution2.constructFromPrePost(new int[] {1}, new int[] {1}));
        assertTraversals(
                new int[] {1, 2}, new int[] {2, 1}, solution.constructFromPrePost(new int[] {1, 2}, new int[] {2, 1}));
        assertTraversals(
                new int[] {1, 2}, new int[] {2, 1}, solution2.constructFromPrePost(new int[] {1, 2}, new int[] {2, 1}));
    }

    private static void assertTraversals(int[] expectedPreorder, int[] expectedPostorder, TreeNode root) {
        assertArrayEquals(expectedPreorder, valuesInPreorder(root));
        assertArrayEquals(expectedPostorder, valuesInPostorder(root));
    }

    private static int[] valuesInPreorder(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        collectPreorder(root, values);
        return toArray(values);
    }

    private static int[] valuesInPostorder(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        collectPostorder(root, values);
        return toArray(values);
    }

    private static void collectPreorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        collectPreorder(node.left, values);
        collectPreorder(node.right, values);
    }

    private static void collectPostorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        collectPostorder(node.left, values);
        collectPostorder(node.right, values);
        values.add(node.val);
    }

    private static int[] toArray(List<Integer> values) {
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    private static void assertArrayEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(
                    "expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
        }
    }
}
