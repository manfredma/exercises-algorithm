package manfred.exercises.leetcode.p0560;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            result += prefixCount.getOrDefault(prefixSum - k, 0);

            prefixCount.merge(prefixSum, 1, Integer::sum);
        }

        return result;
    }
}
