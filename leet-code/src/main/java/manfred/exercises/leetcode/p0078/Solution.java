package manfred.exercises.leetcode.p0078;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 78 题「子集」：位掩码枚举或回溯法生成所有子集。
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(l);

        for (int num : nums) {
            int preSize = result.size();
            for (int i = 0; i < preSize; i++) {
                List<Integer> z = new ArrayList<>(result.get(i));
                z.add(num);
                result.add(z);
            }
        }
        return result;

    }
}