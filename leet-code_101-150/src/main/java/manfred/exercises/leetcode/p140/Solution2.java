package manfred.exercises.leetcode.p140;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 140 题「单词拆分 II」（方案2）：记忆化回溯，从当前位置枚举字典单词向后延伸。
 */
class Solution2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        boolean[] wordBreakCache = new boolean[s.length() + 1];
        wordBreakCache[0] = true;
        List<String>[] wordBreakResultCache = new List[s.length()];
        for (int i = 0; i < wordBreakResultCache.length; i++) {
            wordBreakResultCache[i] = new ArrayList<>();
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                if (wordBreakCache[j] && wordDict.contains(tmp)) {
                    wordBreakCache[i] = true;
                    if (j == 0) {
                        wordBreakResultCache[i - 1].add(tmp);
                    } else {
                        for (int i1 = 0; i1 < wordBreakResultCache[j - 1].size(); i1++) {
                            wordBreakResultCache[i - 1].add(wordBreakResultCache[j - 1].get(i1) + " " + tmp);
                        }
                    }
                }
            }
        }
        return wordBreakResultCache[s.length() - 1];
    }
}