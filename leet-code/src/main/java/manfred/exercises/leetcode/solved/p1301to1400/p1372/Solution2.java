package manfred.exercises.leetcode.solved.p1301to1400.p1372;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public int longestZigZag(TreeNode root) {
        int longest = 0;
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(root, 0, 0));

        while (!stack.isEmpty()) {
            State state = stack.pop();
            longest = Math.max(longest, Math.max(state.leftLength, state.rightLength));

            if (state.node.left != null) {
                stack.push(new State(state.node.left, state.rightLength + 1, 0));
            }
            if (state.node.right != null) {
                stack.push(new State(state.node.right, 0, state.leftLength + 1));
            }
        }
        return longest;
    }

    private static class State {
        private final TreeNode node;
        private final int leftLength;
        private final int rightLength;

        private State(TreeNode node, int leftLength, int rightLength) {
            this.node = node;
            this.leftLength = leftLength;
            this.rightLength = rightLength;
        }
    }
}
