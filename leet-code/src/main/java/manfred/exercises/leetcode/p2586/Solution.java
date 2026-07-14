package manfred.exercises.leetcode.p2586;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) ? 1 : 0;
        }
        return result;
    }

    private boolean isVowel(char input) {
        return 'a' == input || 'e' == input || 'i' == input || 'o' == input || 'u' == input;
    }
}
