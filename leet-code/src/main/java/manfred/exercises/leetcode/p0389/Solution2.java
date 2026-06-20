package manfred.exercises.leetcode.p0389;

class Solution2 {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = (char)(result ^ s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            result = (char)(result ^ t.charAt(i));
        }
        return result;
    }
}
