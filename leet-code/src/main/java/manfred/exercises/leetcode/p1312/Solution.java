package manfred.exercises.leetcode.p1312;

class Solution {
    public int minInsertions(String s) {
        int[][] longestCommon = new int[s.length() + 1][s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                int r = s.length() - j;
                if (s.charAt(i - 1) == s.charAt(r)) {
                    longestCommon[i][j] = longestCommon[i - 1][j - 1] + 1;
                } else {
                    longestCommon[i][j] = Math.max(longestCommon[i][j - 1], longestCommon[i - 1][j]);
                }
            }
        }
        return s.length() - longestCommon[s.length()][s.length()];
    }
}
