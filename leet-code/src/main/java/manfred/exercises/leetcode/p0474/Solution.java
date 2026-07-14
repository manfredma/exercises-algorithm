package manfred.exercises.leetcode.p0474;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 按照 0 和 1 的个数对 strs 进行分组，超过 m 和 n 的忽略
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] x = parseZeroOnes(str);
            for (int i = m; i >= x[0]; i--) {
                for (int j = n; j >= x[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - x[0]][j - x[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] parseZeroOnes(String str) {
        int zeroNum = 0;
        int oneNum = 0;
        for (int j = 0; j < str.length(); j++) {
            zeroNum += (str.charAt(j) == '0' ? 1 : 0);
            oneNum += (str.charAt(j) == '1' ? 1 : 0);
        }
        return new int[]{zeroNum, oneNum};
    }
}
