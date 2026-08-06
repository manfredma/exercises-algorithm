package manfred.exercises.leetcode.p1372;

class Solution {
    public int longestZigZag(TreeNode root) {
         return longestZigZag(root, new int[] {0, 0});
    }

    private int longestZigZag(TreeNode node, int[] zigZag) {
        int r = Math.max(zigZag[0], zigZag[1]);
        if (node.left != null) {
            // 说明当前节点是父节点的左节点, 需要重新计数
            if (zigZag[0] > 0) {
                r = Math.max(r, longestZigZag(node.left, new int[] {1, 0}));
            } else {
                r = Math.max(r, longestZigZag(node.left, new int[] {zigZag[1] + 1, 0}));
            }
        }
        if (node.right != null) {
            if (zigZag[1] > 0) {
                r = Math.max(r, longestZigZag(node.right, new int[] {0, 1}));
            } else {
                r = Math.max(r, longestZigZag(node.right, new int[] {0, zigZag[0] + 1}));
            }
        }
        return r;
    }
}
