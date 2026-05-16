package manfred.exercises.leetcode.p0072;

/**
 * LeetCode 第 72 题「编辑距离」：动态规划，dp[i][j] 为将 s1[0..i) 转为 s2[0..j) 的最少操作数。
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }

        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        distance[0][0] = 0;
        for (int i = 0; i < word1.length(); i++) {
            distance[i + 1][0] = i + 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            distance[0][i + 1] = i + 1;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                int x = distance[i][j + 1] + 1;
                int y = distance[i + 1][j] + 1;
                int z = distance[i][j] + 1;
                if (word1.charAt(i) == word2.charAt(j)) {
                    z = distance[i][j];
                }
                distance[i + 1][j + 1] = Math.min(Math.min(x, y), z);
            }
        }
        return distance[word1.length()][word2.length()];
    }
}