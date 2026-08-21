package manfred.exercises.leetcode.solved.p0201to0300.p0257;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 0257 题「二叉树的所有路径」：递归分治，返回从根到每个叶子的全部路径。
 *
 * <p>每个节点把自身值作为前缀，拼接到左右子树返回的所有路径之前；叶子节点
 * （无左右子）返回单元素 {@code ["val"]} 作为路径终点。两棵子树的路径合并后统一加前缀。
 * 用返回值传递路径而非传入 accumulator，避免回溯时维护 {@code StringBuilder} 状态，
 * 风格更函数式、可读性更好。</p>
 *
 * <p>时间复杂度 {@code O(n²)} 最坏（单链退化时每层字符串拼接累计 {@code O(n²)}，
 * n ≤ 100 足够）；空间复杂度 {@code O(h)} 递归栈 + 路径存储，{@code h} 为树高。</p>
 *
 * <p>Definition for a binary tree node:
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r = new ArrayList<>();
        if (root == null) {
             return r;
        }
        if (root.left == null && root.right == null) {
            r.add(String.valueOf(root.val));
            return r;
        }
        List<String> all = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        all.addAll(right);

        for (int i = 0; i < all.size(); i++) {
            r.add(root.val + "->" + all.get(i));
        }

        return r;
    }
}
