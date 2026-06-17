package manfred.exercises.leetcode.p0530;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        // 二叉搜索树的特点是有序树，使用中序遍历会使得返回值是有序的，因此可以使用这个有序的值来进行
        midTrav(root, values);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            result = Math.min(values.get(i) - values.get(i - 1), result);
        }
        return result;
    }

    private void midTrav(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        midTrav(node.left, values);
        values.add(node.val);
        midTrav(node.right, values);
    }
}
