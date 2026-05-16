package manfred.exercises.leetcode.p0139;

import java.util.List;

/**
 * LeetCode 第 139 题「单词拆分」（方案2）：动态规划，dp[i] 表示 s[0..i) 能否由字典单词拼成。
 */
class Solution2 {
    public boolean wordBreak(String s, List<String> dict) {
        int len = s.length();
        //len+1
        //dp[i]表示前i个字符能不能被dict完美划分
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // 注意substring是前闭后开
                String tmp = s.substring(j, i);
                //能否组合出f[i]表示的子串，k表示组合中前半段的
                if (dp[j] && dict.contains(tmp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}