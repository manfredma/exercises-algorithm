package manfred.exercises.leetcode.p1143;

class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0; // 保存 dp[i-1][j-1]（对角线值），随 j 推进滚动
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // 覆盖前存下，下一轮 j 作为 dp[i-1][j-1]
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}
