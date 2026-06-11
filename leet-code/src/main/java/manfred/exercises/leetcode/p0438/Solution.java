package manfred.exercises.leetcode.p0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            return result;
        }

        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        String sortedP = new String(pArray);

        for(int i = 0; i <= s.length() - p.length(); i++) {
            String part = s.substring(i, i+p.length());
            char[] partArray = part.toCharArray();
            Arrays.sort(partArray);
            String sortPart = new String(partArray);
            if (sortedP.equals(sortPart)) {
                result.add(i);
            }
        }
        return result;
    }
}
