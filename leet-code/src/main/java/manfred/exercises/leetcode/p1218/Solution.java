package manfred.exercises.leetcode.p1218;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        Map<Integer, Integer> longestSubsequence = new HashMap<>();

        for (int j : arr) {
            int pre = j - difference;
            int longest = 1;
            if (longestSubsequence.containsKey(pre)) {
                longest = longestSubsequence.get(pre) + 1;
            }
            longestSubsequence.put(j, longest);
            result = Math.max(result, longest);
        }
        return result;
    }
}
