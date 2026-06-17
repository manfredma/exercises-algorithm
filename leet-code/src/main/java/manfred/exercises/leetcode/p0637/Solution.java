package manfred.exercises.leetcode.p0637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        currentLevel.push(root);
        List<Double> result = new ArrayList<>();
        long size = 0;
        long sum = 0;
        while (true) {
            if (currentLevel.isEmpty()) { // 当前这一层已经结束了，需要记录结果并判断是否存在下一层
                result.add(sum * 1.0 / size);
                if (nextLevel.isEmpty()) {
                    break;
                } else {
                    currentLevel = nextLevel;
                    nextLevel = new ArrayDeque<>();
                    sum = 0;
                    size = 0;
                }
            } else {
                TreeNode t = currentLevel.pop();
                size++;
                sum += t.val;
                if (t.left != null) {
                    nextLevel.push(t.left);
                }
                if (t.right != null) {
                    nextLevel.push(t.right);
                }
            }

        }
        return result;
    }
}
