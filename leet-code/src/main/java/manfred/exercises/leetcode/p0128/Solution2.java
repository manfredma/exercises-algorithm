package manfred.exercises.leetcode.p0128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        HashMap<Integer, Integer> index2LC = new HashMap<>();
        for (int num : nums) {
            if (index2LC.containsKey(num)) {
                continue;
            }
            int partitalMax = index2LC.getOrDefault(num + 1, 0) + index2LC.getOrDefault(num - 1, 0) + 1;
            int rightIndex = num + index2LC.getOrDefault(num + 1, 0);
            index2LC.put(rightIndex, partitalMax);
            int leftIndex = num - index2LC.getOrDefault(num - 1, 0);
            index2LC.put(leftIndex, partitalMax);
            index2LC.put(num, partitalMax);

            if (partitalMax > result) {
                result = partitalMax;
            }
        }
        return result;
    }
}