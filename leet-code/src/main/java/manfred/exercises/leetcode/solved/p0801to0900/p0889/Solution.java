package manfred.exercises.leetcode.solved.p0801to0900.p0889;

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preLeft, int preRight, int[] postorder, int postLeft, int postRight) {
        // 构造根节点，然后将树分为两个子树递归构造
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        // preLeft < preRight 说明有子节点
        if (preLeft < preRight) {
            // 第一个孩子（可能是左子树，如果没有左子树则是右子树！）
            int firstChild = preorder[preLeft + 1];
            int lastChild = postorder[postRight - 1];
            if (firstChild == lastChild) {
                // 只有一个孩子
                root.left = constructFromPrePost(preorder, preLeft + 1, preRight, postorder, postLeft, postRight - 1);
            } else {
                int leftRoot = 0;
                for (int i = postLeft; i < postorder.length; i++) {
                    if (postorder[i] == firstChild) {
                        leftRoot = i;
                        break;
                    }
                }
                int rightRoot = 0;
                for (int i = preLeft; i < preorder.length; i++) {
                    if (preorder[i] == lastChild) {
                        rightRoot = i;
                        break;
                    }
                }
                // 构造左子树
                root.left = constructFromPrePost(preorder, preLeft + 1, rightRoot - 1, postorder, postLeft, leftRoot);
                // 构造右子树
                root.right = constructFromPrePost(preorder, rightRoot, preRight, postorder, leftRoot + 1, postRight - 1);
            }
        }

        return root;
    }
}
