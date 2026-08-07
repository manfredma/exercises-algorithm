package manfred.exercises.leetcode.solved.p0801to0900.p0872;

import java.util.*;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = postOrder(root1);
        List<Integer> leafValues2 = postOrder(root2);
        return leafValues1.equals(leafValues2);
    }

    private List<Integer> postOrder(TreeNode root) {
        List<Integer> leafValues = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return leafValues;
    }
}
