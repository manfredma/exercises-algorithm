package manfred.exercises.leetcode.solved.p2201to2300.p2236;

class Solution {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
