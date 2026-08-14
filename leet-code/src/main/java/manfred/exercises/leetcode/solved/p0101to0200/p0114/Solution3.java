package manfred.exercises.leetcode.solved.p0101to0200.p0114;

/**
 * 二叉树展开为链表 —— Morris 前驱指针法（迭代，O(1) 空间）。
 *
 * <p>思路：沿右链逐节点处理。对每个有左孩子的节点 cur，找其左子树的最右节点 prev
 * （即 cur 右子树在前序序列中应接上的位置），把 cur.right 整棵挂到 prev.right，
 * 再把 cur.left 提为 cur.right、cur.left 置空。cur 沿右链前进。
 *
 * <p>复杂度：时间 O(n)（每条 right 指针最多被走一次），空间 O(1)（纯迭代，无递归栈）。
 * 是进阶要求的 O(1) 额外空间解法。
 */
class Solution3 {

    public void flatten(TreeNode root) {
        // Morris 前驱指针法，O(1) 空间迭代展开。
        // 核心：找到当前节点 cur 的右子树应挂到左子树的哪个节点下（左子树的最右节点 prev），
        // 这样就能把 cur.left 整体提到 cur.right，原右子树接到 prev.right。
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                cur = cur.right;
                continue;
            }

            // 找到左子树的“最右侧”节点，这个节点就是左子树的最后一个元素
            while (left.right != null) {
                left = left.right;
            }

            left.right = cur.right;
            cur.right = cur.left;
            cur.left = null;
            cur = cur.right;
        }
    }
}
