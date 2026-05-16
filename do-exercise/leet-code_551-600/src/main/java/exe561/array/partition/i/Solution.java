package exe561.array.partition.i;

import java.util.Arrays;

/**
 * LeetCode 第561题 数组拆分 I，将排序后的数组按相邻两两分组，取每组较小值求和以获得最大结果。
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }
}