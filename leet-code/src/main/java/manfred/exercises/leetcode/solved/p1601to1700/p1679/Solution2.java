package manfred.exercises.leetcode.solved.p1601to1700.p1679;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> unpairedCounts = new HashMap<>();

        for (int num : nums) {
            int complement = k - num;
            if (unpairedCounts.containsKey(complement)) {
                result++;
                unpairedCounts.computeIfPresent(
                        complement,
                        (key, count) -> count == 1 ? null : count - 1
                );
            } else {
                unpairedCounts.merge(num, 1, Integer::sum);
            }
        }
        return result;
    }
}
