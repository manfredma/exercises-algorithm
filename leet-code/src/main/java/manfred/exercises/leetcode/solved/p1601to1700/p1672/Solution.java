package manfred.exercises.leetcode.solved.p1601to1700.p1672;

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
