package manfred.exercises.leetcode.p0712;

/**
 * 滚动数组优化版：空间复杂度从 O(m×n) 降至 O(min(m, n))
 * 时间复杂度不变，仍为 O(m×n)
 */
class Solution2 {
    public int minimumDeleteSum(String s1, String s2) {
        // 保证沿较短的字符串方向滚动，节省空间
        if (s1.length() < s2.length()) return minimumDeleteSum(s2, s1);

        int len1 = s1.length();
        int len2 = s2.length();
        int[] dp = new int[len2 + 1];

        // 初始化第一行：s1 为空时，需删除 s2 前 j 个字符的代价
        for (int j = 1; j <= len2; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= len1; i++) {
            int prev = dp[0];                       // 保存 dp[i-1][j-1]（左上角值）
            dp[0] += s1.charAt(i - 1);              // 初始化 dp[i][0]：删除 s1 前 i 个字符的代价
            for (int j = 1; j <= len2; j++) {
                int curr = dp[j];                   // 即将被覆盖，提前保存供下一列使用
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 字符相同，两者均不删除，继承左上角状态
                    dp[j] = prev;
                } else {
                    // 取"删除 s1 当前字符"与"删除 s2 当前字符"中代价较小的一种
                    dp[j] = Math.min(dp[j] + s1.charAt(i - 1),
                                     dp[j - 1] + s2.charAt(j - 1));
                }
                prev = curr;
            }
        }
        return dp[len2];
    }
}
