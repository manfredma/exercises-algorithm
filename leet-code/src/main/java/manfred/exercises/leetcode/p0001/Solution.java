package manfred.exercises.leetcode.p0001;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 1 题「两数之和」：哈希表存储已遍历元素，一次遍历找到目标差值对应的索引。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{
                -1, -1
        };

        Map<Integer, Integer> checked = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (checked.containsKey((target - nums[i]))) {
                result[0] = checked.get(target - nums[i]);
                result[1] = i;
            } else {
                checked.put(nums[i], i);
            }

        }
        return result;
    }
}