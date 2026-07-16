package manfred.exercises.leetcode.p2140;

class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len];
        dp[len - 1] = questions[len - 1][0];
        for (int i = len - 2; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            // 两种选择：做这题拿分 + 跳过 brainpower 道后接剩余段；不做则继承 dp[i+1]
            long solve = points + (i + brainpower + 1 < len ? dp[i + brainpower + 1] : 0);
            long skip = dp[i + 1];
            dp[i] = Math.max(solve, skip);
        }
        return dp[0];
    }
}
