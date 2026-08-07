package manfred.exercises.leetcode.solved.p0401to0500.p0459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}
