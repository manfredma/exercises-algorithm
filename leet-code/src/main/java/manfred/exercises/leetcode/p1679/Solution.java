package manfred.exercises.leetcode.p1679;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> unpairedCounts = new HashMap<>();
        for (int num : nums) {
            if (unpairedCounts.getOrDefault(k - num, 0) > 0) {
                result++;
                unpairedCounts.put(k - num, unpairedCounts.get(k - num) - 1);
            } else {
                unpairedCounts.put(num, unpairedCounts.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }
}
