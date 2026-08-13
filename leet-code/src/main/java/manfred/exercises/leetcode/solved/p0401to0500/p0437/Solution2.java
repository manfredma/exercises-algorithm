package manfred.exercises.leetcode.solved.p0401to0500.p0437;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和 III —— 前缀和 + 哈希表 + 回溯解法（最优）。
 *
 * <p>思路：树上向下的路径可视为数组，前缀和同样适用。设 prefixSum(node) 为根到 node
 * 的路径和，则路径 [ancestor → node] 的和 = prefixSum(node) - prefixSum(ancestor)。
 * 用哈希表记录当前路径上各前缀和出现的次数，访问 node 时查 prefixSum - targetSum 的计数即可。
 *
 * <p>关键点：
 * <ul>
 *   <li>初始放入 (0L, 1)，覆盖「从根出发的整段路径恰好等于 targetSum」的情况；</li>
 *   <li>用 long 前缀和，避免 10^9 量级节点相加溢出（int 会错算）；</li>
 *   <li>DFS 回溯时把当前节点的前缀和从哈希表撤销，否则会污染兄弟子树的结果。</li>
 * </ul>
 *
 * <p>复杂度：时间 O(n)，空间 O(n)。相比 Solution 的复制列表 O(n²)，用共享哈希表 + 回溯降到线性。
 */
class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0L, 1);
        return pathSum(root, targetSum, prefixSums, 0L);
    }

    private int pathSum(TreeNode node, int targetSum, Map<Long, Integer> prefixSums, long prevSum) {
        int result = 0;
        long prefixSum = prevSum + node.val;
        // 查有多少个祖先前缀和满足 prefixSum - ancestorSum == targetSum
        result += prefixSums.getOrDefault(prefixSum - targetSum, 0);
        // 当前前缀和入表，供后续子节点查询
        prefixSums.merge(prefixSum, 1, Integer::sum);
        // 递归处理左右子树
        if (node.left != null) {
            result += pathSum(node.left, targetSum, prefixSums, prefixSum);
        }
        if (node.right != null) {
            result += pathSum(node.right, targetSum, prefixSums, prefixSum);
        }
        // 回溯：撤销当前节点前缀和对兄弟子树的影响，避免左子树的结果漏到右子树
        prefixSums.merge(prefixSum, -1, Integer::sum);
        return result;
    }
}
