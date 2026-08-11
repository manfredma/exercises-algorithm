package manfred.exercises.leetcode.solved.p0801to0900.p0889;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    private final Map<Integer, Integer> postorderIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postorderIndex.clear();
        for (int i = 0; i < postorder.length; i++) {
            postorderIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight) {
            return root;
        }

        int leftRootValue = preorder[preLeft + 1];
        int leftPostRight = postorderIndex.get(leftRootValue);
        int leftSize = leftPostRight - postLeft + 1;

        root.left = build(preorder, preLeft + 1, preLeft + leftSize, postLeft, leftPostRight);
        root.right = build(preorder, preLeft + leftSize + 1, preRight, leftPostRight + 1, postRight - 1);
        return root;
    }
}
