package manfred.exercises.leetcode.solved.p1401to1500.p1448;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/count-good-nodes-in-binary-tree/ */

/*
给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。

「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。



示例 1：

输入：root = [3,1,4,3,null,1,5]
输出：4
解释：图中蓝色节点为好节点。
根节点 (3) 永远是个好节点。
节点 4 -> (3,4) 是路径中的最大值。
节点 5 -> (3,4,5) 是路径中的最大值。
节点 3 -> (3,1,3) 是路径中的最大值。

示例 2：

输入：root = [3,3,null,4,2]
输出：3
解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。

示例 3：

输入：root = [1]
输出：1
解释：根节点是好节点。



提示：


二叉树中节点数目范围是 [1, 10^5] 。


每个节点权值的范围是 [-10^4, 10^4] 。
*/
/** LeetCode 第 1448 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        assertEquals(4, solution.goodNodes(tree(3, 1, 4, 3, null, 1, 5)));
        assertEquals(3, solution.goodNodes(tree(3, 3, null, 4, 2)));
        assertEquals(1, solution.goodNodes(tree(1)));
        assertEquals(1, solution.goodNodes(tree(-1, -2, -3)));
        assertEquals(3, solution.goodNodes(tree(1, 1, 1)));
    }

    private static TreeNode tree(Integer... values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
        java.util.Queue<TreeNode> queue = new java.util.ArrayDeque<TreeNode>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);
        for (int i = 1; !queue.isEmpty() && i < values.length; ) {
            TreeNode node = queue.poll();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

}
