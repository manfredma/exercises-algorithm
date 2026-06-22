package manfred.exercises.leetcode.p0740;

import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        // 排序以方便实现相邻值不能同时选的逻辑。
        Arrays.sort(nums);

        int result = 0;
        int prePreEarn = 0;
        int preEarn = 0;
        int preValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 找到和当前值一样的所有的元素（一起来决定是否删除）
            int count = 1;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                count++;
                i++;
            }
            int earn = count * nums[i];
            // 看下比它小的元素是否紧邻，如果非紧邻，则当前earn直接加到结果中即可。
            if (nums[i] != preValue + 1) {
                result += earn;
            } else {
                // 如果是紧邻的，就要在次次大基础上进行增加
                result = Math.max(prePreEarn + earn, result);
            }

            preValue = nums[i];
            prePreEarn = preEarn;
            preEarn = result;
        }
        return result;
    }
}
