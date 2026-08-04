package manfred.exercises.leetcode.p0611;

import java.util.Arrays;

class Solution2 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int smallest = nums[i];
            int thirdEdgeIdx = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int smaller = nums[j];
                int sum = smaller + smallest;
                thirdEdgeIdx = Math.max(thirdEdgeIdx, j + 1);
                while (thirdEdgeIdx < nums.length && nums[thirdEdgeIdx] < sum) {
                    thirdEdgeIdx++;
                }

                result += thirdEdgeIdx - j - 1;
            }
        }
        return result;
    }
}
