package manfred.exercises.leetcode.solved.p0001to0100.p0015;

import java.util.*;

/**
 * LeetCode 第 15 题「三数之和」（方案 1）：记录每个值最后出现的位置，枚举前两个数并查找补数。
 * 通过额外集合消除重复三元组。该方案保留作哈希查找和去重状态的对照，时间复杂度为 O(n²)，
 * 空间复杂度为 O(n)；方案 2 和方案 3 均使用排序 + 双指针，其中方案 3 的去重流程更标准。
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<Integer>> repeated = new HashMap<>();
        Map<Integer, Integer> numsSet = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numsSet.put(nums[i], i);
        }

        Set<Integer> checkedFirst = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length - 2; i++) {
            if (checkedFirst.contains(nums[i])) {
                continue;
            }
            Set<Integer> checkedSecond = new HashSet<>(nums.length);
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (checkedSecond.contains(nums[j])) {
                    continue;
                }
                Integer pos = numsSet.get(-nums[i] - nums[j]);
                if (null != pos && pos > j) {
                    int s = Math.min(Math.min(nums[i], nums[j]), -nums[i] - nums[j]);
                    Set<Integer> sc = repeated.get(s);
                    if (null == sc) {
                        sc = new HashSet<>(nums.length);
                        repeated.put(s, sc);
                    }
                    int b = Math.max(Math.max(nums[i], nums[j]), -nums[i] - nums[j]);
                    if (!sc.contains(b)) {
                        List<Integer> match = new ArrayList<>();
                        match.add(nums[i]);
                        match.add(nums[j]);
                        match.add(-nums[i] - nums[j]);
                        result.add(match);
                        sc.add(b);
                    }
                }
                checkedSecond.add(nums[j]);
            }
            checkedFirst.add(nums[i]);
        }
        return result;
    }
}
