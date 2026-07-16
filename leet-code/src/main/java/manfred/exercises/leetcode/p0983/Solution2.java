package manfred.exercises.leetcode.p0983;

// 备选解法：按日历天数倒推 DP，免去按下标解法（见 Solution）里“跳窗口”的线性探测。
//
// 状态 dp[d]：从第 d 天（含）到年末完成所有旅行的最低花费，d 取 1..365。
//   第 d 天非旅行日：dp[d] = dp[d+1]（不花钱，继承后一天）
//   第 d 天是旅行日：必买票，三种取最小
//     一日票：costs[0] + dp[d+1]
//     七日票：costs[1] + dp[d+7]
//     三十日票：costs[2] + dp[d+30]
//   超过最大旅行日的天，花费视为 0。
//
// 关键：买 7 日票后直接索引 dp[d+7]，无需循环找“第一个超出窗口的旅行日”——
//       因为 dp[d+7] 若 d+7 非旅行日会继承 dp[d+8]……层层继承到下一个旅行日，
//       “跳过窗口”被“非旅行日继承”自然吸收。
// 时间 O(365)，空间 O(365)，均视为 O(1)。
class Solution2 {

    private static final int LAST = 365;

    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travel = new boolean[LAST + 1];
        int maxDay = 0;
        for (int d : days) {
            travel[d] = true;
            maxDay = Math.max(maxDay, d);
        }
        // 多开 30 位，保证 d+30 不越界；末尾默认 0 表示“超出最大旅行日 = 0 花费”
        int[] dp = new int[LAST + 31];
        for (int d = maxDay; d >= 1; d--) {
            if (!travel[d]) {
                dp[d] = dp[d + 1];
            } else {
                int cost1 = costs[0] + dp[d + 1];
                int cost7 = costs[1] + dp[d + 7];
                int cost30 = costs[2] + dp[d + 30];
                dp[d] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        return dp[days[0]];
    }
}
