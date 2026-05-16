package manfred.exercises.ctci.c02;

import java.util.HashMap;
import java.util.Map;

/**
 * CTCI 面试题 01.02「判定是否互为字符重排」：字符频次统计，两字符串对应频次相等。
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        //
        if (s1.length() != s2.length()) {
            return false;
        }

        //
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (charCount.containsKey(c)) {
                if (charCount.get(c) == 0) {
                    return false;
                }
                charCount.put(c, charCount.get(c) -1);
            } else {
                return false;
            }
        }
        return true;

    }
}