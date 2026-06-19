package manfred.exercises.leetcode.p1768;

class Solution {
    public String mergeAlternately(String word1, String word2) {

        int i = 0;
        StringBuilder result = new StringBuilder();
        for (; i < word1.length() && i < word2.length(); i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        result.append(word1.substring(i));
        result.append(word2.substring(i));
        return result.toString();
    }
}
