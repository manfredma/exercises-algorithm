package manfred.exercises.leetcode.solved.p2401to2500.p2462;

/** 题目链接：https://leetcode.cn/problems/total-cost-to-hire-k-workers/ */

/**
 * 每轮从最前 candidates 位或最后 candidates 位可选工人中雇佣代价最小者；相同代价选较小下标。
 * 返回雇佣 k 人的总代价。示例输出分别为 11 和 4。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(11L, solution.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        assertEquals(4L, solution.totalCost(new int[]{1, 2, 4, 1}, 3, 3));

        // 候选窗口不断从右侧补员。
        assertEquals(7L, solution.totalCost(new int[]{5, 3, 4, 2, 1}, 3, 1));
        // 两端成本相同，应优先选择下标更小的工人。
        assertEquals(2L, solution.totalCost(new int[]{1, 100, 100, 1}, 2, 1));
        // 总成本超过 int 范围。
        assertEquals(10_000_000_000L, solution.totalCost(filledCosts(100_000, 100_000), 100_000, 1));
    }

    private static int[] filledCosts(int length, int value) {
        int[] costs = new int[length];
        java.util.Arrays.fill(costs, value);
        return costs;
    }

    private static void assertEquals(long expected, long actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
