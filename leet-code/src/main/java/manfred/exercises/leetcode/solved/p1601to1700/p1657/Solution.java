package manfred.exercises.leetcode.solved.p1601to1700.p1657;

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] word1CharCount = new int[26];
        int[] word2CharCount = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1CharCount[word1.charAt(i) - 'a']++;
            word2CharCount[word2.charAt(i) - 'a']++;
        }

        // 看下字符集是否一致！
        for (int i = 0; i < 26; i++) {
            if (word1CharCount[i] != 0 && word2CharCount[i] == 0) {
                return false;
            } else if (word1CharCount[i] == 0 && word2CharCount[i] != 0) {
                return false;
            }
        }

        // 看下数量是否能对上
        Arrays.sort(word1CharCount);
        Arrays.sort(word2CharCount);
        for (int i = 0; i < 26; i++) {
            if (word1CharCount[i] != word2CharCount[i]) {
                return false;
            }
        }
        return true;
    }
}
