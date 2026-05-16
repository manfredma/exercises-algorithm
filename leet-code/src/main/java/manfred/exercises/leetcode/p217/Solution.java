package manfred.exercises.leetcode.p217;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 第 217 题「存在重复元素」：哈希集合，或排序后检查相邻元素。
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> has = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!has.add(num)) {
                return true;
            }
        }
        return false;
    }
}