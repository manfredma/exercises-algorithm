package manfred.exercises.leetcode.p1161;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxLevelSum(TreeNode root) {
        // 使用广度优先算法来计算每层的和
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = level;
        while (!deque.isEmpty()) {
            int curSum = 0;
            int count = deque.size();
            for (int i = 0; i < count; i++) {
                TreeNode treeNode = deque.poll();
                curSum += treeNode.val;
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
            }
            if (maxSum < curSum) {
                maxLevel = level;
                maxSum = curSum;
            }
            level++;
        }
        return maxLevel;
    }
}
