package manfred.exercises.leetcode.p0983;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        // dp[i] 表示从 days[i] 开始往后完成所有旅行，最少需要花费多少钱。
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            // days[i] 这天必须出门，必买一张从 days[i] 起算的票，三种取最小：
            //   一日票覆盖 [days[i], days[i]]、七日票覆盖 [days[i], days[i]+6]、三十日票覆盖 [days[i], days[i]+29]
            int cost1 = costs[0] + (i + 1 < len ? dp[i + 1] : 0);
            int cost7 = costs[1] + remainingCostAfter(days, dp, i, 6);
            int cost30 = costs[2] + remainingCostAfter(days, dp, i, 29);
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }
        return dp[0];
    }

    /**
     * 买一张覆盖 [days[from], days[from] + span] 的票之后，剩余旅行日的最低花费。
     * 跳过窗口内被覆盖的旅行日，返回第一个超出窗口的旅行日的 dp 值；若之后全部被覆盖，返回 0。
     */
    private int remainingCostAfter(int[] days, int[] dp, int from, int span) {
        int coveredUntil = days[from] + span;
        for (int i = from + 1; i < days.length; i++) {
            if (days[i] > coveredUntil) {
                return dp[i];
            }
        }
        // 当前票型覆盖了之后所有旅行日
        return 0;
    }
}
