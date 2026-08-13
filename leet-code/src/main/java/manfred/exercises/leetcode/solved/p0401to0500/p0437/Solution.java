package manfred.exercises.leetcode.solved.p0401to0500.p0437;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 III —— 前缀和列表解法（朴素版）。
 *
 * <p>思路：维护根到当前节点路径上所有「起点」的前缀和列表。每访问一个节点，
 * 把列表里每个前缀和加上当前节点值（即把这些起点延伸到当前节点），
 * 再把当前节点本身作为一个新起点加入。若某个前缀和等于 targetSum，则对应路径命中。
 *
 * <p>注意：每层递归复制一份列表传递给子节点，导致最坏 O(n²) 的时间与空间。
 * 用 long 前缀和以避免大值节点相加溢出。
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, new ArrayList<>());
    }

    private int pathSum(TreeNode root, int targetSum, List<Long> prefixSum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        // 把已有起点都延伸到当前节点：prefixSum[i] + root.val 即「起点 i 到当前节点」的和
        List<Long> currentSum = new ArrayList<>();
        for (Long i : prefixSum) {
            currentSum.add(i + root.val);
            if (i + root.val == targetSum) {
                count++;
            }
        }
        // 当前节点自身也作为一个起点（对应「从当前节点出发的路径」）
        currentSum.add((long) root.val);
        if (root.val == targetSum) {
            count++;
        }
        return count + pathSum(root.left, targetSum, currentSum) + pathSum(root.right, targetSum, currentSum);
    }
}
