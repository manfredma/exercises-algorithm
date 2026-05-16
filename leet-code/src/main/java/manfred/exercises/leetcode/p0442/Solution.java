package manfred.exercises.leetcode.p0442;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第442题 数组中重复的数据，利用原地取反标记已访问元素，在 O(n) 时间 O(1) 空间内找出所有重复元素。
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        // 利用符号记录是否已经查找到元素
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                result.add(x);
            } else {
                nums[x - 1] = -nums[x - 1];
            }
        }
        return result;
    }
}