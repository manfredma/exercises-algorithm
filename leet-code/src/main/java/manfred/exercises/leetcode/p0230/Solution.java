package manfred.exercises.leetcode.p0230;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 230 题「二叉搜索树中第 K 小的元素」：中序遍历第 k 个节点，或迭代栈。
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedValue = new ArrayList<>(k);
        collectKValueSorted(root, sortedValue, k);
        return sortedValue.get(k - 1);
    }

    private void collectKValueSorted(TreeNode node, List<Integer> sortedValue, int k) {
        if (node == null) {
            return;
        }
        collectKValueSorted(node.left, sortedValue, k);
        sortedValue.add(node.val);
        if (sortedValue.size() >= k) {
            return;
        }
        collectKValueSorted(node.right, sortedValue, k);
    }
}