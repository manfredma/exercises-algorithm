package manfred.exercises.leetcode.p0712;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化第一行和第一列，即：某一字符串长度为 0 的情况
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }
        // 最优子表达式：
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 不需要删除的场景，忽略这个新位置即可。
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果最后一个元素不相同，则需要处理一下在如何进行删除时是最优的
                    dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j - 1), dp[i - 1][j] + s1.charAt(i - 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
