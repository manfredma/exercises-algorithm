package manfred.exercises.leetcode.p0109;

/**
 * LeetCode 第 109 题「有序链表转换二叉搜索树」：快慢指针找链表中点作为根，递归构建左右子树。
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int x = 0;
        ListNode cur = head;
        while (null != cur) {
            x++;
            cur = cur.next;
        }
        int[] nums = new int[x];
        cur = head;
        for (int i = 0; i < x; i++) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        return sortedArrayToBST(nums);
    }

    private TreeNode sortedArrayToBST(int[] nums) {
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