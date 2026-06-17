package manfred.exercises.leetcode.p0637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution2 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 快照当前层节点数
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add((double) sum / size);
        }
        return result;
    }
}
