package manfred.exercises.leetcode.solved.p0301to0400.p0322;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 零钱兑换 —— BFS 求无权图最短路径解法。
 *
 * <p>思路：把「凑金额」建模成图——金额为节点，用一枚面额 coin 是从金额 a 转移到 a+coin
 * 的边（边权均为 1）。最少硬币数即从 0 到 amount 的最短路径。BFS 层序遍历天然求无权图
 * 最短路：第 i 层的节点是「恰好用 i 枚硬币能凑出的金额集合」，首次到达 amount 即得最少硬币数。
 *
 * <p>关键点：
 * <ul>
 *   <li>用 visited 布尔数组去重，每个金额只入队一次，避免重复扩展（否则退化成指数级）；</li>
 *   <li>队列非空就继续扩展，一旦命中 amount 立即返回层数；队列为空仍未命中则不可达返回 -1。</li>
 * </ul>
 *
 * <p>注意：这是 BFS（穷举所有扩展 + 层序保证最优），不是贪心。贪心「每次取最大面额」
 * 不保证最优（如 coins=[1,3,4], amount=6 贪心得 4+1+1=3 枚，最优为 3+3=2 枚）。
 *
 * <p>复杂度：时间 O(amount × coins.length)，空间 O(amount)。相比 {@link Solution2} 的 DP，
 * BFS 可在命中时早停，但队列与 visited 的常数开销略大。
 */
class Solution3 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        boolean[] visited = new boolean[amount + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        // level = 当前已使用的硬币数
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int preAmount = queue.poll();
                for (int coin : coins) {
                    int next = preAmount + coin;
                    if (next == amount) {
                        return level;
                    }
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
