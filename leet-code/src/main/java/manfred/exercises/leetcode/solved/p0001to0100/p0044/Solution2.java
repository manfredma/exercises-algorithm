package manfred.exercises.leetcode.solved.p0001to0100.p0044;
/**
 * LeetCode 第 44 题「通配符匹配」：再刷解法，标准二维 DP。
 * <p>
 * 思路：dp[i][j] 表示 s[0..i) 与 p[0..j) 是否匹配。
 * <ul>
 *   <li>第一行初始化：p 前缀连续 '*' 可匹配空串，dp[0][j]=dp[0][j-1]。</li>
 *   <li>p[j-1]=='*'：dp[i][j]=dp[i][j-1]（* 匹配空）|| dp[i-1][j]（* 匹配一个并继续）。</li>
 *   <li>否则：dp[i][j]=dp[i-1][j-1] && matches(s[i-1], p[j-1])，matches 即 '?' 或字符相等。</li>
 * </ul>
 * <p>
 * 关键点：'*' 转移是「不消费 s / 消费 s 并保留 *」两分支，递推清晰无内层循环。
 * 复杂度：时间 O(mn)，空间 O(mn)。
 * <p>
 * 与 {@link Solution} 演进：旧解手写 NFA 自动机模拟（~130 行，状态+转移表）；
 * 本解用标准 DP 递推（~30 行），等价正确且大幅简化，是首选。
 */
class Solution2 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        // 第一行的需要初始化一下，因为正则表达式可以表示空串，例如：* 也可以表示空串（0个 a）
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                // 匹配空串，只考虑 0 个场景，不需要考虑 1 个或多个场景
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 分别考虑
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    // 当前字符匹配且之前的字符也匹配即认为匹配成功
                    dp[i][j] = dp[i - 1][j - 1] && matches(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }
        return dp[sLen][pLen];
    }

    private boolean matches(char sChar, char pChar) {
        return pChar == '?' || pChar == sChar;
    }
}
