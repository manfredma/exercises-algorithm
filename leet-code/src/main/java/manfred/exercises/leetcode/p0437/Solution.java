package manfred.exercises.leetcode.p0437;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, new ArrayList<>());
    }

    private int pathSum(TreeNode root, int targetSum, List<Long> prefixSum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        List<Long> currentSum = new ArrayList<>();
        for (Long i : prefixSum) {
            currentSum.add(i + root.val);
            if (i + root.val == targetSum) {
                count++;
            }
        }
        currentSum.add((long) root.val);
        if (root.val == targetSum) {
            count++;
        }
        return count + pathSum(root.left, targetSum, currentSum) + pathSum(root.right, targetSum, currentSum);
    }
}
