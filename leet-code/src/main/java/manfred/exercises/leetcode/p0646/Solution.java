package manfred.exercises.leetcode.p0646;

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        int result = 1;
        // 优先按照结尾进行排序
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int[] longestChain = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            int r = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    r = Math.max(longestChain[j] + 1, r);
                }
            }
            longestChain[i] = r;
            result = Math.max(r, result);
        }
        return result;
    }
}
