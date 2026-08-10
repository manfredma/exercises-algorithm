package manfred.exercises.leetcode.solved.p1401to1500.p1448;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public int goodNodes(TreeNode root) {
        int result = 0;
        Deque<NodeExtra> stack = new ArrayDeque<>();
        stack.push(new NodeExtra(root, root.val));
        while (!stack.isEmpty()) {
            NodeExtra nodeExtra = stack.pop();
            if (nodeExtra.node.val >= nodeExtra.pathMax) {
                result++;
            }
            if (nodeExtra.node.left != null) {
                stack.push(new NodeExtra(nodeExtra.node.left, Math.max(nodeExtra.pathMax, nodeExtra.node.left.val)));
            }
            if (nodeExtra.node.right != null) {
                stack.push(new NodeExtra(nodeExtra.node.right, Math.max(nodeExtra.pathMax, nodeExtra.node.right.val)));
            }
        }
        return result;
    }

    private static class NodeExtra {
        private final TreeNode node;
        private final int pathMax;

        public NodeExtra (TreeNode node, int pathMax) {
            this.node = node;
            this.pathMax = pathMax;
        }
    }
}
