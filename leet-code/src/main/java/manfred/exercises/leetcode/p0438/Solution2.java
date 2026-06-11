package manfred.exercises.leetcode.p0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] winCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            winCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, winCount)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            winCount[s.charAt(i) - 'a']++;
            winCount[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pCount, winCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
