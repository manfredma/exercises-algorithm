package manfred.exercises.leetcode.solved.p0001to0100.p0010;

/**
 * LeetCode 第 10 题「正则表达式匹配」：再刷解法，标准二维 DP。
 * <p>
 * 思路：dp[i][j] 表示 s[0..i) 与 p[0..j) 是否匹配。
 * <ul>
 *   <li>第一行初始化：p 形如 x* 时可匹配空串，dp[0][j]=dp[0][j-2]（取 0 个 x）。</li>
 *   <li>p[j-1]=='*'：取 0 个前驱字符 dp[i][j-2]，或取多个 dp[i-1][j] && matches(s[i-1], p[j-2])。</li>
 *   <li>否则：dp[i][j]=dp[i-1][j-1] && matches(s[i-1], p[j-1])，matches 即 '.' 或字符相等。</li>
 * </ul>
 * <p>
 * 关键点：题目保证 '*' 前必有有效字符，故 j-2 不会越界；'.' 与相等统一收口到 matches。
 * 复杂度：时间 O(mn)，空间 O(mn)。
 * <p>
 * 与 {@link Solution2} 演进：旧解遇 '*' 用内层 for k 向下传播 dp[k][j]，写法非标准；
 * 本解 '*' 转移折叠为「0 个 / 多个」两分支的标准递推，无需内层循环，逻辑更清晰。
 */
class Solution3 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        // 第一行的需要初始化一下，因为正则表达式可以表示空串，例如：a* 也可以表示空串（0个 a）
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                // 匹配空串，只考虑 0 个场景，不需要考虑 1 个或多个场景
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 分别考虑 0 和 多个的情况, 当 0 个时候，就不用考虑 * 及 * 号前的元素，如果是多个，则需要星号前的字符
                    // 与s末尾的字符相同，且之前就已经匹配上了（这样末尾才可以继续多一个相同的字符出来！）
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && matches(s.charAt(i - 1), p.charAt(j - 2)));
                } else {
                    // 当前字符匹配及之前的字符也匹配即认为匹配成功
                    dp[i][j] = dp[i - 1][j - 1] && matches(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }
        return dp[sLen][pLen];
    }

    private boolean matches(char sChar, char pChar) {
        return pChar == '.' || pChar == sChar;
    }
}
