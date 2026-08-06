package manfred.exercises.leetcode.p1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int i : arr) {
            occurrence.merge(i, 1, Integer::sum);
        }
        Set<Integer> uniqueOcc = new HashSet<>();
        for (Integer i : occurrence.keySet()) {
            if (uniqueOcc.contains(occurrence.get(i))) {
                return false;
            }
            uniqueOcc.add(occurrence.get(i));
        }
        return true;
    }
}
