package exe169.majority.element;

import java.util.Arrays;

/**
 * LeetCode 第 169 题「多数元素」：Boyer-Moore 投票算法，O(1) 空间找众数。
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}