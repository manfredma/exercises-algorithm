package manfred.exercises.leetcode.solved.p1801to1900.p1805;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> differentIntegers = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                sb.append(word.charAt(i));
            } else {
                if (sb.length() > 0) {
                    differentIntegers.add(removeLeaderZero(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() > 0) {
            differentIntegers.add(removeLeaderZero(sb.toString()));
        }
        return differentIntegers.size();
    }

    private String removeLeaderZero(String integer) {
        for (int i = 0; i < integer.length(); i++) {
            if (integer.charAt(i) != '0') {
                return integer.substring(i);
            }
        }
        return "0";
    }
}
