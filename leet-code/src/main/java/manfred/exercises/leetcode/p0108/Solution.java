package manfred.exercises.leetcode.p0108;

/**
 * LeetCode 第 108 题「将有序数组转换为二叉搜索树」：递归取中间元素为根，左右区间分别构建子树。
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        int[] l = new int[mid];
        System.arraycopy(nums, 0, l, 0, mid);
        root.left = sortedArrayToBST(l);

        int[] r = new int[nums.length - 1 - mid];
        System.arraycopy(nums, mid + 1, r, 0, nums.length - 1 - mid);
        root.right = sortedArrayToBST(r);
        return root;
    }
}