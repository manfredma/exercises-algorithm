package manfred.exercises.leetcode.solved.p0201to0300.p0257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 0257 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-paths/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：root = [1,2,3,null,5] → ["1->2->5","1->3"]
        assertPaths(Arrays.asList("1->2->5", "1->3"),
                solution.binaryTreePaths(treeOf(1, 2, 3, null, 5)),
                "root=[1,2,3,null,5]");

        // 示例 2：root = [1] → ["1"]
        assertPaths(Arrays.asList("1"),
                solution.binaryTreePaths(treeOf(1)),
                "root=[1]");

        // 边界：单链深路径，验证 "->" 逐层连接
        assertPaths(Arrays.asList("1->2->3->4"),
                solution.binaryTreePaths(treeOf(1, 2, null, 3, null, 4)),
                "root=[1,2,null,3,null,4]");

        // 边界：负数值，验证负号在路径中保留
        assertPaths(Arrays.asList("-1->-2", "-1->-3"),
                solution.binaryTreePaths(treeOf(-1, -2, -3)),
                "root=[-1,-2,-3]");

        System.out.println("leet#0257 passed");
    }

    /** 顺序无关地比较两个路径列表：排序后逐项比较（题目允许任意顺序返回）。 */
    private static void assertPaths(List<String> expected, List<String> actual, String desc) {
        List<String> e = new ArrayList<>(expected);
        List<String> a = actual == null ? new ArrayList<>() : new ArrayList<>(actual);
        Collections.sort(e);
        Collections.sort(a);
        assertEquals(e, a, desc);
    }

    /** 层序数组建树（LeetCode 风格，null 表示空位）。 */
    private static TreeNode treeOf(Integer... vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int i = 1;
        int head = 0;
        while (head < queue.size() && i < vals.length) {
            TreeNode node = queue.get(head++);
            if (i < vals.length) {
                Integer v = vals[i++];
                if (v != null) {
                    node.left = new TreeNode(v);
                    queue.add(node.left);
                }
            }
            if (i < vals.length) {
                Integer v = vals[i++];
                if (v != null) {
                    node.right = new TreeNode(v);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
