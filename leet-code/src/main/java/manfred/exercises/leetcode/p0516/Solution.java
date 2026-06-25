package manfred.exercises.leetcode.p0516;

class Solution {
    public int longestPalindromeSubseq(String s) {
        // 用动态规划来解决，dp[i][j] 表示了s中从 i 到 j 的回文串长度
        // 最优子表达式：如果 s[i] == s[j], 那么 dp[i][j] = 2 + dp[i+1][j-1], 否则：dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
