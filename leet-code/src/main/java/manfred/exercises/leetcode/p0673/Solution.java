package manfred.exercises.leetcode.p0673;

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] numOfLis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            numOfLis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    numOfLis[i] = numOfLis[j];
                } else if (nums[j] < nums[i] && lis[i] == lis[j] + 1) {
                    numOfLis[i] += numOfLis[j];
                }

            }
        }
        int maxLis = Arrays.stream(lis).max().getAsInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (maxLis == lis[i]) {
                result += numOfLis[i];
            }
        }
        return result;
    }
}
