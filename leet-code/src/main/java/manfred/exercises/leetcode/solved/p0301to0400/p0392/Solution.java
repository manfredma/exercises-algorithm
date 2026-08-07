package manfred.exercises.leetcode.solved.p0301to0400.p0392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int si = 0;
        for (int i = 0; i < t.length() && si < s.length(); i++) {
            if (s.charAt(si) == t.charAt(i)) {
                si++;
            }
        }
        return si == s.length();
    }
}
