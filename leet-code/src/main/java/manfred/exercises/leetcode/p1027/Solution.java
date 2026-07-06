package manfred.exercises.leetcode.p1027;

class Solution {
    private static final int OFFSET = 500;
    private static final int DIFF_RANGE = 1001;

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] lengthByDiffAt = new int[n][DIFF_RANGE];
        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diffIndex = nums[i] - nums[j] + OFFSET;
                int prevLength = lengthByDiffAt[j][diffIndex];
                int length = (prevLength == 0 ? 1 : prevLength) + 1;
                lengthByDiffAt[i][diffIndex] = length;
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
