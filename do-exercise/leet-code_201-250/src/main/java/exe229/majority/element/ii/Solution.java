package exe229.majority.element.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 229 题「多数元素 II」：Boyer-Moore 扩展投票，维护两个候选数。
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int[][] candidates = new int[2][2];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidates[0][0]) {
                candidates[0][1] = candidates[0][1] + 1;
            } else if (nums[i] == candidates[1][0]) {
                candidates[1][1] = candidates[1][1] + 1;
            } else {
                if (candidates[0][1] == 0) {
                    candidates[0][0] = nums[i];
                    candidates[0][1] = 1;
                } else if (candidates[1][1] == 0) {
                    candidates[1][0] = nums[i];
                    candidates[1][1] = 1;
                } else {
                    candidates[0][1] = candidates[0][1] - 1;
                    candidates[1][1] = candidates[1][1] - 1;
                }
            }
        }

        candidates[0][1] = 0;
        candidates[1][1] = 0;
        for (int num : nums) {
            if (num == candidates[0][0]) {
                candidates[0][1]++;
            } else if (num == candidates[1][0]) {
                candidates[1][1]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        int x = nums.length / 3;
        if (candidates[0][1] > x) {
            result.add(candidates[0][0]);
        }

        if (candidates[1][1] > x) {
            result.add(candidates[1][0]);
        }

        return result;
    }
}