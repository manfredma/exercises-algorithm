package manfred.exercises.leetcode.p090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 90 题「子集 II」：回溯法排序后跳过同层重复元素。
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(l);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ) {
            int numNum = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    numNum++;
                } else {
                    break;
                }
            }
            int preSize = result.size();
            for (int j = 1; j <= numNum; j++) {
                List<Integer> candidate = new ArrayList<>();
                for (int k = 0; k < j; k++) {
                    candidate.add(nums[i]);
                }
                for (int k = 0; k < preSize; k++) {
                    List<Integer> integers = new ArrayList<>(result.get(k));
                    integers.addAll(candidate);
                    result.add(integers);
                }
            }
            i = i + numNum;

        }
        return result;
    }
}