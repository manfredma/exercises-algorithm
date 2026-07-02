package manfred.exercises.leetcode.p1672;

import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int[] account : accounts) {
            result = Math.max(result, Arrays.stream(account).sum());
        }
        return result;
    }
}
